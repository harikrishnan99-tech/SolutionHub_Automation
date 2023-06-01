package org.solutionhub.steps.assets;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.HookTestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.hooks.hooks;
import org.solutionhub.services.producerPage.AssetsService;
import org.solutionhub.TestRunner;
import org.solutionhub.steps.login.login;

import static junit.framework.TestCase.assertEquals;

public class assets {

    private final WebDriver driver = hooks.get();
    private final WebDriverWait wait = hooks.getWait();
    AssetsService assetservice = new AssetsService();
    login Login = new login();


//    @Given("Producer is on SolutionHub landing page")
//    public void producer_is_on_solution_hub_landing_page() {
//        String url = ConfigReader.getProperty("URL_QA");
//        driver.get(url);
//    }
//
//    @When("Producer signs-in to SolutionHub")
//    public void producer_signs_in_to_solution_hub() {
//        Login.user_click_on_sign_in_button();
//        String parentWindowHandle = driver.getWindowHandle();
//        driver.switchTo().window(parentWindowHandle);
//        Login.user_enter_producer_username_and_password();
//        Login.user_click_the_login_button();
//    }

    @And("User click on assets tab")
    public void user_click_on_assets_tab() {
        try {
            assetservice.clickAssetsTab();
        } catch (CucumberException e) {
            e.printStackTrace();
        }

    }

    //Scenario-Search
    @When("Producer enter {string} in the search bar")
    public void producer_enter_in_the_search_bar(String assetName) {
        assetservice.enterSearchData(assetName);
    }

    @Then("the search result should contain the asset name {string}")
    public void the_search_result_should_contain_the_asset_name(String expectedAssetName) {
        String actualAssetName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#asset-card-138-161 > div > div.d-flex.text-truncate > div.asset-description-block.text-truncate > div.asset-top-info.text-truncate.line-height-18px > div.d-flex.align-items-center.text-truncate.my-4px > span"))).getText();
        assertEquals(expectedAssetName, actualAssetName);
    }

    //Scenario-Sorting

    @When("producer sort assets by name in descending order")
    public void producer_sort_assets_by_name_in_descending_order() {
        assetservice.clickSortDropDown();
        assetservice.sortNameDesc();
    }

    @Then("assets should be displayed in alphabetical order by descending")
    public void assets_should_be_displayed_in_alphabetical_order_by_descending() {
        assetservice.checksortAssetNamesDesc();
        System.out.println("SORT BY DESCENDING COMPLETE");
    }
    @When("producer sort assets by name in ascending order")
    public void producer_sort_assets_by_name_in_ascending_order() {
        assetservice.clickSortDropDown();
        assetservice.sortNameAsc();
    }

    @Then("assets should be displayed in alphabetical order by ascending")
    public void assets_should_be_displayed_in_alphabetical_order_by_ascending() {
        assetservice.checksortAssetNamesAsc();
        System.out.println("SORT BY ASCENDING COMPLETE");
    }



//    @When("producer sort assets by rating in ascending order")
//    public void producer_sort_assets_by_rating_in_ascending_order() {
//        AssetsService.clickSortDropDown();
//        AssetsService.sortRatingAsc();
//    }

//    @Then("assets should be displayed in ascending order of rating")
//    public void assets_should_be_displayed_in_ascending_order_of_rating() {
//
//    }

//    @When("producer sort assets by rating in descending order")
//    public void producer_sort_assets_by_rating_in_descending_order() {
//        AssetsService.clickSortDropDown();
//        AssetsService.sortRatingDesc();
//    }

//    @Then("assets should be displayed in descending order of rating")
//    public void assets_should_be_displayed_in_descending_order_of_rating() {
//    }

    @And("Producer sign-out from SolutionHub")
    public void producerSignOutFromSolutionHub() {
        Login.user_should_logout();
    }

    //Assets View
    @When("producer click on List view button")
    public void producer_click_on_list_view_button() {
        assetservice.clickListView();
    }

    @Then("the assets should be displayed in a list format")
    public void the_assets_should_be_displayed_in_a_list_format() {
        assetservice.verifyAssetListView();
    }

    @When("producer click on Grid view button")
    public void producer_click_on_grid_view_button() {
        assetservice.clickGridView();
    }

    @Then("the assets should be displayed in a grid format")
    public void the_assets_should_be_displayed_in_a_grid_format() {
        assetservice.verifyAssetGridView();
    }

    //Assets per page

    @When("producer select the option to display {string} assets per page")
    public void producer_select_the_option_to_display_assets_per_page(String arg0) {
        assetservice.clickAssetNumberDropDown();
        assetservice.clickAssetNumber();
    }

    @Then("producer should see {string} assets displayed on the page")
    public void producer_should_see_assets_displayed_on_the_page(String arg0) {
        assetservice.verifyAssetNumber();
    }

}
