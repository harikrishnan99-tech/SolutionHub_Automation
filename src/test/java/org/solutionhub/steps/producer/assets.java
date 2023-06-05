package org.solutionhub.steps.producer;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.hooks.hooks;
import org.solutionhub.services.producerPage.AssetsService;
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
    public void producer_should_see_assets_displayed_on_the_page(String expectedCount) {
        assetservice.verifyAssetNumber(expectedCount);
    }
// Products category filter
    @When("producer selects primary category filter {string}")
    public void producerSelectsPrimaryCategoryFilter(String primaryCategory) {
        if(primaryCategory.equals("Infrastructure software")){
            assetservice.clickProductCategoryInfrastructure();
        } else if (primaryCategory.equals("DevOps")) {
            assetservice.clickProductCategoryDevOps();
        }
    }

    @And("producer selects secondary category filter {string}")
    public void producerSelectsSecondaryCategoryFilter(String secondaryCategory) {
        if(secondaryCategory.equals("Network")){
            assetservice.clickProductSecondaryCategoryNetwork();
        } else if (secondaryCategory.equals("CICD Pipelines")) {
            assetservice.clickProductSecondaryCategoryCICDPipelines();
        }
    }

    @Then("producer should see all assets contained in category {string}")
    public void producerShouldSeeAllAssetsContainedInCategory(String category) {
        assetservice.checkProductCategory(category);
    }

    @When("producer selects primary category solution {string}")
    public void producerSelectsPrimaryCategorySolution(String primaryCategory) {
        if(primaryCategory.equals("Industry Solution")){
            assetservice.clickSolutionCategoryIndustrySolution();
        } else if (primaryCategory.equals("Industries")) {
            assetservice.clickSolutionCategoryIndustries();
        }
    }

    @And("producer selects secondary category solution {string}")
    public void producerSelectsSecondaryCategorySolution(String secondaryCategory) {
        if(secondaryCategory.equals("IT Software")){
            assetservice.clickSolutionSecondaryCategoryITSoftware();
        } else if (secondaryCategory.equals("Healthcare")) {
            assetservice.clickSolutionSecondaryCategoryHealthcare();
        }
    }

    @Then("producer should see all assets contained in given solution category {string}")
    public void producerShouldSeeAllAssetsContainedInGivenSolutionCategory(String category) {
        assetservice.checkSolutionCategory(category);
    }

    @And("producer should clear the filter")
    public void producerShouldClearTheFilter() {
        assetservice.clearFilterResults();
    }
//filter
    @When("producer selects filter {string}")
    public void producerSelectsFilter(String primaryFilter) {
        if(primaryFilter.equals("Delivery method")){
            assetservice.clickFilterDeliveryMethod();
        } else if (primaryFilter.equals("Tooling")) {
            assetservice.clickFilterTooling();
        } else if (primaryFilter.equals("Cloud")) {
            assetservice.clickFilterCloud();
        } else if (primaryFilter.equals("Industry")) {
            assetservice.clickFilterIndustry();
        } else if (primaryFilter.equals("Regulation")) {
            assetservice.clickFilterRegulation();
        } else if (primaryFilter.equals("License")) {
            assetservice.clickFilterLicense();
        } else if (primaryFilter.equals("Publisher")) {
            assetservice.clickFilterPublisher();
        }
    }

    @And("producer selects delivery method {string}")
    public void producerSelectsDeliveryMethod(String secondaryFilter) {
        if(secondaryFilter.equals("Solution")){
            assetservice.clickFilterSolution();
        } else if (secondaryFilter.equals("Cloudformation")) {
            assetservice.clickFilterCloudFormation();
        } else if (secondaryFilter.equals("AWS")) {
            assetservice.clickFilterAWS();
        } else if (secondaryFilter.equals("Health")) {
            assetservice.clickFilterHealth();
        } else if (secondaryFilter.equals("SOC1")) {
            assetservice.clickFilterSOC1();
        } else if (secondaryFilter.equals("Test-Group")) {
            assetservice.clickFilterTestGroup();
        } else if (secondaryFilter.equals("UST License")) {
            assetservice.clickFilterUSTLicense();
        }
    }

    @Then("producer should see all assets based on given {string} filter")
    public void producerShouldSeeAllAssetsBasedOnGivenFilter(String filter) {
        assetservice.checkFilter(filter);
    }
}
