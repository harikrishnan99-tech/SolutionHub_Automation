package org.solutionhub.services.producerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.hooks.hooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AssetsService {
    public AssetsService(){

    }
    private final WebDriver driver = hooks.get();
    private final WebDriverWait wait = hooks.getWait();
    public By btn_asset_number = By.xpath
            ("//button[@class='dropdown-item'][contains(text(),'25')]");
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

    public By btn_product_category_infrastructure=By.xpath
            ("//span[@class='col pl-0 category-name'][contains(text(),'Infrastructure Software')]");
    public By btn_product_category_network=By.xpath
            ("//div[@class='text-truncate'][contains(text(),'Network')]");
    public By btn_product_category_devops=By.xpath
            ("//span[@class='col pl-0 category-name'][contains(text(),'DevOps')]");
    public By btn_product_category_cicd=By.xpath
            ("//div[@class='text-truncate'][contains(text(),'CICD Pipelines')]");
    public By txt_product_category1_check=By.xpath
            ("//span[@class='text text-truncate body3'][contains(text(),'Infrastructure Software')]");
    public By txt_product_category2_check=By.xpath
            ("//span[@class='text text-truncate body3'][contains(text(),'DevOps')]");
    public By btn_solution_category_industry_solution=By.xpath
            ("//span[@class='col pl-0 category-name'][contains(text(),'Industry Solution')]");
    public By btn_solution_category_it_software=By.xpath
            ("//div[@class='text-truncate'][contains(text(),'IT Software')]");
    public By btn_solution_category_industries=By.xpath
            ("//span[@class='col pl-0 category-name'][contains(text(),'Industries')]");
    public By btn_solution_category_healthcare=By.xpath
            ("//div[@class='text-truncate'][contains(text(),'Healthcare')]");
    public By txt_solution_category1_check=By.xpath
            ("//span[@class='text text-truncate body3'][contains(text(),'Industry Solution')]");
    public By txt_solution_category2_check=By.xpath
            ("//span[@class='text text-truncate body3'][contains(text(),'Industries')]");
    public By clear_filter=By.xpath
            ("//button[@class='btn btn-link size-s ml-8px']");
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
        assertEquals(sortedAssetNames, assetTitles);
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

    public void verifyAssetNumber(String expectedCount) {
        for(WebElement assetCard:assetCards){
            int actualCount = assetCard.findElements(By.xpath
                    ("//app-asset-list-item[@class='d-block']")).size();
            int expectedAssetCardCount = Integer.parseInt(expectedCount);
            assertEquals(expectedAssetCardCount, actualCount);
        }
    }

    public void clickProductCategoryInfrastrucuture(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_infrastructure)).click();
    }

    public void clickProductCategoryNetwork(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_network)).click();
    }

    public void checkProductCategory1(){
        String ActualProductCategory=driver.findElement(txt_product_category1_check).getText();
        String ExpectedProductCategory=driver.findElement(btn_product_category_network).getText();
        boolean isPresent = ActualProductCategory.contains(ExpectedProductCategory);
        assertTrue("Product Category"+ExpectedProductCategory+"PASSED!!",isPresent);
    }
    public void clickProductCategoryDevOps(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_devops)).click();
    }

    public void clickProductCategoryCICDPipelines(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_cicd)).click();
    }

    public void checkProductCategory2(){
        String ActualProductCategory=driver.findElement(txt_product_category2_check).getText();
        String ExpectedProductCategory=driver.findElement(btn_product_category_cicd).getText();
        boolean isPresent = ActualProductCategory.contains(ExpectedProductCategory);
        assertTrue("Product Category"+ExpectedProductCategory+"PASSED!!",isPresent);
    }

    public void clickSolutionCategoryIndustrySolution(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_industry_solution)).click();
    }
    public void clickSolutionCategoryITSoftware(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_it_software)).click();
    }

    public void checkSolutionCategory1() {
        String ActualProductCategory = driver.findElement(txt_solution_category1_check).getText();
        String ExpectedProductCategory = driver.findElement(btn_solution_category_it_software).getText();
        boolean isPresent = ActualProductCategory.contains(ExpectedProductCategory);
        assertTrue("Solution Category" + ExpectedProductCategory + "PASSED!!", isPresent);
    }

    public void clickSolutionCategoryIndustries(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_industries)).click();
    }
    public void clickSolutionCategoryHealthcare(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_healthcare)).click();
    }

    public void checkSolutionCategory2() {
        String ActualProductCategory = driver.findElement(txt_solution_category2_check).getText();
        String ExpectedProductCategory = driver.findElement(btn_solution_category_healthcare).getText();
        boolean isPresent = ActualProductCategory.contains(ExpectedProductCategory);
        assertTrue("Solution Category" + ExpectedProductCategory + "PASSED!!", isPresent);
    }
        public void ClearFilterResults(){
        wait.until(ExpectedConditions.elementToBeClickable(clear_filter)).click();
    }


}
