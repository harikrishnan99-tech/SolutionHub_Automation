package org.solutionhub.services.producerPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.TestRunner;
import org.solutionhub.hooks.hooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssetsService {
    public AssetsService(){

    }
    private final WebDriver driver = hooks.get();
    private final WebDriverWait wait = hooks.getWait();
    public By btn_asset_number = By.xpath
            ("/html/body/app-root/lib-sidenav-container/lib-sidenav-content/div[2]/app-assets/app-assets-list-wrapper/as-split/as-split-area[2]/lib-pagination[1]/div/div/div[1]/div/div/div/button[2]");
    public By txt_asset_number = By.xpath
            ("//span[@class='secondary-text-and-icons'][contains(text(),'25')]");
    public By txt_searchBar = By.cssSelector
            ("#search");
    public By btn_sort = By.xpath
            ("//button[contains(@class,'dropdown-toggle')]//fa-icon");
    public By btn_sort_name_asc = By.xpath
            ("//div[@class='dropdown']//li[contains(text(),' Name: ASC')]");
    public By btn_sort_name_desc = By.xpath
            ("//div[@class='dropdown']//li[contains(text(),' Name: DESC')]");
    public List<String> assetTitles = new ArrayList<String>();
    //    private List<Integer> webPageRatings;
    public By btn_list_view = By.xpath
            ("//label[@class='button-toggle']//fa-icon[@icon='grid2Horizontal']");
    //    By btn_sort_rating_asc=By.xpath
//            ("//div[@class='dropdown']//li[contains(text(),' Rating: ASC')]");
//    //String username=ConfigReader.getProperty("PRODUCER_USERNAME");
//    String password= ConfigReader.getProperty("PRODUCER_PASSWORD");
    public By btn_grid_view = By.xpath
            ("//label[@class='button-toggle']//fa-icon[@icon='grid']");
    public By btn_asset_number_drop_down = By.xpath
            ("//button[@id='dropdownBasic1']");
    public By btn_assets_tab = By.xpath
            ("//a[@id='assets-tab']");
    public By btn_sidenav_expand = By.xpath("//div[@class='expand-control cursor-pointer']");
    public By btn_sidenav_pin = By.xpath
            ("//button[@class='btn btn-link ml-auto px-1 py-1']");
    //    By btn_sort_rating_desc=By.xpath
//            ("//div[@class='dropdown']//li[contains(text(),' Rating: DESC')]");
    public List<WebElement> assetCards = driver.findElements(By.className("assets-list-container"));

    public void clickAssetsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_sidenav_expand)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_sidenav_pin)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_assets_tab)).click();
    }

    public void enterSearchData(String assetInput) {
        WebElement actualResult = wait.until(ExpectedConditions.elementToBeClickable(txt_searchBar));
        actualResult.sendKeys(assetInput);
    }

    public void clickSortDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_sort)).click();
    }

    public void sortNameAsc() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_sort_name_asc)).click();
    }

    public void sortNameDesc() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_sort_name_desc)).click();
    }

    public void checksortAssetNamesAsc() {
        for (WebElement assetCard : assetCards) {
            WebElement titleElement = assetCard.findElement(By.className("text-truncate"));
            String title = titleElement.getText().trim();
            assetTitles.add(title);
        }
        List<String> sortedAssetNames = new ArrayList<String>(assetTitles);
        Collections.sort(sortedAssetNames, String.CASE_INSENSITIVE_ORDER);
        assert assetTitles.equals(sortedAssetNames);
    }

    public void checksortAssetNamesDesc() {
        for (WebElement assetCard : assetCards) {
            WebElement titleElement = assetCard.findElement(By.className("text-truncate"));
            String title = titleElement.getText().trim();
            assetTitles.add(title);
        }
        List<String> sortedAssetNames = new ArrayList<String>(assetTitles);
        Collections.sort(sortedAssetNames, Collections.reverseOrder());
        Assert.assertEquals(sortedAssetNames, assetTitles);
    }

//    public void sortRatingAsc(){
//        wait.until(ExpectedConditions.elementToBeClickable(btn_sort_rating_asc)).click();
//    }

//    public static JsonPath getAllRatings(){
//        String username=ConfigReader.getProperty("PRODUCER_USERNAME");
//        String password= ConfigReader.getProperty("PRODUCER_PASSWORD");
//        return given()
//                .contentType(ContentType.JSON)
//                .auth().preemptive().basic(username,password)
//                .queryParam("page",0).queryParam("size",50).queryParam("sort","currentVersion.rating.asc")
//                .when()
//                .get("https://qa-solutionhub.ustpace.com/api/v1/assets/launched?size=50&page=0&sort=currentVersion.rating,asc")
//                .getBody().jsonPath();
//    }

//    private List<Integer> getWebPageRatings() {
//        // Code to retrieve the ratings displayed on the web page
//        List<Integer> ratings = new ArrayList<>();
//        List<WebElement> ratingElements = driver.findElements(By.xpath("//span[@class='color-brand']"));
//        for (WebElement ratingElement : ratingElements) {
//            ratings.add(Integer.parseInt(ratingElement.getText()));
//        }
//        return ratings;
//    }

//    public void sortRatingDesc(){
//        wait.until(ExpectedConditions.elementToBeClickable(btn_sort_rating_desc)).click();
//    }

    public void clickListView() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_list_view)).click();
    }

    public void verifyAssetListView() {
        List<WebElement> assetList = driver.findElements(By.cssSelector(".assets-list-container"));
        assert assetList.size() > 0 : "No assets found in list format";
        for (WebElement asset : assetList) {
            assert asset.getTagName().equals("li") : "Product is not displayed as a list item";
        }
    }

    public void clickGridView() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_grid_view)).click();
    }

    public void verifyAssetGridView() {
        List<WebElement> assetGrid = driver.findElements(By.cssSelector(".assets-list-container"));
        assert assetGrid.size() > 0 : "No assets found in grid format";
        for (WebElement asset : assetGrid) {
            assert asset.getTagName().equals("div") : "Asset is not displayed as a grid item";
        }
    }

    public void clickAssetNumberDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_asset_number_drop_down)).click();
    }

    public void clickAssetNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_asset_number)).click();
    }

    public void verifyAssetNumber() {
        String AssetNumberText = driver.findElement(btn_asset_number).getText();
        String ExpectedAssetNumberText = driver.findElement(txt_asset_number).getText();
        String[] words = ExpectedAssetNumberText.split("\\s+");

        String ExpectedAssetNumber = "";
        if (words.length >= 4) {
            ExpectedAssetNumber = words[3];
        }
        System.out.println(ExpectedAssetNumber);
        Assert.assertEquals(AssetNumberText, ExpectedAssetNumber);

    }

}
