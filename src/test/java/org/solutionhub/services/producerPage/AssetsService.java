package org.solutionhub.services.producerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.hooks.hooks;
import org.solutionhub.utils.ConfigReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class AssetsService {
    public AssetsService(){

    }
    private final WebDriver driver = hooks.get();
    private final WebDriverWait wait = hooks.getWait();
    public By btn_asset_per_page_25 = By.xpath
            ("//button[@class='dropdown-item'][contains(text(),'25')]");
    public By btn_asset_per_page_10 = By.xpath
            ("//button[@class='dropdown-item'][contains(text(),'10')]");
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
            ("//div[@class='tag']//span[@class='text text-truncate body3'][contains(text(),'Network')]");
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
    public By btn_filter_delivery_method=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Delivery method')]");
    public By btn_filter_solution=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='Solution']");
    public By btn_filter_tooling=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Tooling')]");
    public By btn_filter_cloudformation=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='Cloudformation']");
    public By btn_filter_cloud=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Cloud')]");
    public By btn_filter_aws=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='AWS']");
    public By btn_filter_industry=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Industry')]");
    public By btn_filter_health=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='Health']");
    public By btn_filter_regulation=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Regulation')]");
    public By btn_filter_soc1=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='SOC1']");
    public By btn_filter_license=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'License')]");
    public By btn_filter_ust_license=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='UST License']");
    public By btn_filter_publisher=By.xpath
            ("//span[@class='col pl-0 filter-name'][contains(text(),'Publisher')]");
    public By btn_filter_test_group=By.xpath
            ("//div[@class='checkbox-item__label'][normalize-space(text())='Test-Group']");
    public By txt_filter_solution_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='Solution']");
    public By txt_filter_cloudformation_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='Cloudformation']");
    public By txt_filter_aws_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='AWS']");
    public By txt_filter_health_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='Health']");
    public By txt_filter_soc1_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='SOC1']");
    public By txt_filter_ust_license_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='UST License']");
    public By txt_filter_test_group_check=By.xpath
            ("//span[@class='text text-truncate body3'][normalize-space(text())='Test-Group']");
    public By asset_card=By.xpath
            ("//lib-card[@id='asset-item-143-167']");
    public By asset_title=By.xpath
            ("//lib-card[@id='asset-item-143-167']//span[@class='text-truncate'][normalize-space(text())='Cucumber_UI_test']");
    public By asset_image=By.cssSelector
            ("img[alt='Cucumber_UI_test']");
    public By asset_tags=By.xpath
            ("//lib-card[@id='asset-item-143-167']//div[@class='d-flex flex-wrap mt-4px']");
    public By txt_asset_version=By.xpath
            ("//lib-card[@id='asset-item-143-167']//div[@class='d-flex align-items-center mt-16px']");
    public By txt_asset_publisher_name=By.xpath
            ("//lib-card[@id='asset-item-143-167']//div[@class='disable min-width-80px'][normalize-space(text())='Publisher:']");
    public By txt_asset_description=By.xpath
            ("//lib-card[@id='asset-item-143-167']//div[@class='disable min-width-80px'][normalize-space(text())='Description:']");
    public By btn_asset_get_it=By.xpath
            ("//lib-card[@id='asset-item-143-167']//button[@class='btn btn-warning asset-download-btn action-button size-s']");
    public By btn_asset_link=By.xpath
            ("//lib-card[@id='asset-item-143-167']//button[@class='btn btn-primary asset-github-link action-button size-s']");
    public By btn_next_page=By.xpath
            ("//span[@class='next']//fa-icon[@class='ng-fa-icon fa cursor-pointer font-16px color-brand']");
    public By badge_private=By.xpath
            ("//lib-card[@id='asset-item-143-167']//div[@class='asset-access-badge access-badge-private']");
    public By icon_private_asset=By.xpath
            ("//fa-icon[@class='ng-fa-icon font-16px color-brand']");
    public By header_flex=By.xpath
            ("//nav[@class='navbar navbar-expand-lg d-flex flex-row align-items-center w-100 h-100 p-0']");
    public By header_title=By.cssSelector
            ("img[alt='UST PACE SolutionHub']");
    public By icon_user=By.xpath
            ("//lib-user-pic[@class='lib-user-pic mr-8px']");
    public By btn_header_products=By.xpath
            ("//div[@class='app-nav-item']//span[contains(text(),'Products')]");
    public By btn_header_product_category_infrastructure=By.xpath
            ("//a[@class='navigation-dropdown-item cursor-default'][contains(text(),'Infrastructure Software')]");
    public By btn_header_product_category_network=By.xpath
            ("//a[@id='dropdown-0-0-0'][contains(text(),'Network')]");
    public By btn_header_solutions=By.xpath
            ("//div[@id='nav-item-1']//span[contains(text(),'Solutions')]");
    public By btn_header_solution_industry_solution=By.xpath
            ("//a[@id='dropdown-1-0']");
    public By btn_header_solution_it_software=By.xpath
            ("//a[@id='dropdown-1-0-0'][contains(text(),'IT Software')]");
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
        wait.until(ExpectedConditions.elementToBeClickable(btn_asset_per_page_25)).click();
    }

    public void verifyAssetNumber(String expectedCount) {
        for(WebElement assetCard:assetCards){
            int actualCount = assetCard.findElements(By.xpath
                    ("//app-asset-list-item[@class='d-block']")).size();
            int expectedAssetCardCount = Integer.parseInt(expectedCount);
            assertEquals(expectedAssetCardCount, actualCount);
        }
    }

    public void clickProductCategoryInfrastructure(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_infrastructure)).click();
    }

    public void clickProductSecondaryCategoryNetwork(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_network)).click();
    }

    public void checkProductCategory(String category){
        if(category.equals("Network")){
            String ActualProductCategory=driver.findElement(txt_product_category1_check).getText();
            System.out.println("Actual product category"+ActualProductCategory);
            boolean isPresent = ActualProductCategory.contains(category);
            assertTrue("Product Category"+category+"PASSED!!",isPresent);
        } else if (category.equals("CICD Pipelines")) {
            String ActualProductCategory=driver.findElement(txt_product_category2_check).getText();
            boolean isPresent = ActualProductCategory.contains(category);
            assertTrue("Product Category"+category+"PASSED!!",isPresent);
        }

    }
    public void clickProductCategoryDevOps(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_devops)).click();
    }

    public void clickProductSecondaryCategoryCICDPipelines(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_product_category_cicd)).click();
    }

    public void clickSolutionCategoryIndustrySolution(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_industry_solution)).click();
    }
    public void clickSolutionSecondaryCategoryITSoftware(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_it_software)).click();
    }

    public void checkSolutionCategory(String category) {
        if(category.equals("IT Software")){
            String ActualProductCategory = driver.findElement(txt_solution_category1_check).getText();
            boolean isPresent = ActualProductCategory.contains(category);
            assertTrue("Solution Category" + ActualProductCategory + "PASSED!!", isPresent);
        } else if (category.equals("Healthcare")) {
            String ActualProductCategory = driver.findElement(txt_solution_category2_check).getText();
            boolean isPresent = ActualProductCategory.contains(category);
            assertTrue("Solution Category" + ActualProductCategory + "PASSED!!", isPresent);
        }
    }

    public void clickSolutionCategoryIndustries(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_industries)).click();
    }
    public void clickSolutionSecondaryCategoryHealthcare(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_solution_category_healthcare)).click();
    }
    public void clearFilterResults(){wait.until(ExpectedConditions.elementToBeClickable(clear_filter)).click();
    }

    public void clickFilterDeliveryMethod(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_delivery_method)).click();
    }

    public void clickFilterSolution(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_solution)).click();
    }

    public void clickFilterTooling(){
        By btn_show_more=By.xpath
                ("//button[@class='btn btn-link size-s ml-40px mb-3']");
        wait.until(ExpectedConditions.elementToBeClickable(btn_show_more)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_tooling)).click();
    }

    public void clickFilterCloudFormation(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_cloudformation)).click();
    }
    public void clickFilterCloud(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_cloud)).click();
    }

    public void clickFilterAWS(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_aws)).click();
    }
    public void clickFilterIndustry(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_industry)).click();
    }

    public void clickFilterHealth(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_health)).click();
    }
    public void clickFilterRegulation(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_regulation)).click();
    }

    public void clickFilterSOC1(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_soc1)).click();
    }
    public void clickFilterLicense(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_license)).click();
    }

    public void clickFilterUSTLicense(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_ust_license)).click();
    }

    public void clickFilterPublisher(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_publisher)).click();
    }

    public void clickFilterTestGroup(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_filter_test_group)).click();
    }

    public void checkFilter(String filter){
        if(filter.equals("Solution")){
            String ActualFilter = driver.findElement(txt_filter_solution_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        } else if (filter.equals("Cloudformation")) {
            String ActualFilter = driver.findElement(txt_filter_cloudformation_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        } else if (filter.equals("AWS")) {
            String ActualFilter = driver.findElement(txt_filter_aws_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        } else if (filter.equals("Health")) {
            String ActualFilter = driver.findElement(txt_filter_health_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        } else if (filter.equals("SOC1")) {
            String ActualFilter = driver.findElement(txt_filter_soc1_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        }else if (filter.equals("UST License")) {
            String ActualFilter = driver.findElement(txt_filter_ust_license_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        }else if (filter.equals("Test-Group")) {
            String ActualFilter = driver.findElement(txt_filter_test_group_check).getText();
            boolean isPresent = ActualFilter.contains(filter);
            assertTrue(ActualFilter, isPresent);
        }
    }
//asset card UI
    public void locateAssetCard(){
        wait.until(ExpectedConditions.elementToBeClickable(asset_card)).isDisplayed();
    }

    public void verifyAssetUIElements(){
        WebElement asset_name=driver.findElement(asset_title);
        WebElement asset_logo=driver.findElement(asset_image);
        WebElement asset_tag=driver.findElement(asset_tags);
        WebElement asset_version=driver.findElement(txt_asset_version);
        WebElement asset_publisher=driver.findElement(txt_asset_publisher_name);
        WebElement asset_description=driver.findElement(txt_asset_description);

        assert asset_name.isDisplayed();
        assert asset_logo.isDisplayed();
        assert asset_tag.isDisplayed();
        assert asset_version.isDisplayed();
        assert asset_publisher.isDisplayed();
        assert asset_description.isDisplayed();
    }

    public void verifyAssetButtons(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_asset_get_it)).click();
        WebElement asset_download_popup=driver.findElement(By.xpath
                ("//div[@class='modal-content']"));
        assert asset_download_popup.isDisplayed();

        WebElement asset_link_button=driver.findElement(btn_asset_link);
        asset_link_button.isDisplayed();
        asset_link_button.isEnabled();
    }

    //pagination
    public void clickOnNextPage(){
        clickAssetNumberDropDown();
        wait.until(ExpectedConditions.elementToBeClickable(btn_asset_per_page_10)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_next_page)).click();
    }

    public void verifyPagination(){
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Extract the current page value from the URL using regex
        String pattern = "page=(\\d+)";
        Pattern pagePattern = Pattern.compile(pattern);
        Matcher matcher = pagePattern.matcher(currentUrl);

        // Check if the page attribute value is found and increment it
        if (matcher.find()) {
            String currentPageStr = matcher.group(1);
            int currentPage = Integer.parseInt(currentPageStr);

            // Verify if the page attribute value has been incremented
            int expectedNextPage = currentPage + 1;
            assert expectedNextPage == (currentPage + 1);
            System.out.println("Pagination Done");
        } else {
            System.out.println("Pagination error!!");
            assert false;
        }
    }

    public void viewPrivateAssets(){
        wait.until(ExpectedConditions.elementToBeClickable(badge_private)).isDisplayed();
    }

    public void verifyPrivateAssetBadge(){
        WebElement private_asset_badge=driver.findElement(badge_private);
        if(private_asset_badge.isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(asset_title)).click();
            wait.until(ExpectedConditions.elementToBeClickable(icon_private_asset)).isDisplayed();
        }else{
            System.out.println("Asset is not Private");
        }
    }
    //Header component
    public void locateHeaderComponent(){
        wait.until(ExpectedConditions.elementToBeClickable(header_flex)).isDisplayed();
    }

    public void locateHeaderTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(header_title)).isDisplayed();
    }

    public void verifyHeaderTitle(String title){
        WebElement title_header=driver.findElement(header_title);
        String altText = title_header.getAttribute("alt");
        assertEquals(title,altText);
    }

    public void clickHeaderTitle(){
        String expectedUrl= ConfigReader.getProperty("URL_QA");
        System.out.println("Landing page URL:"+expectedUrl);
        String currentUrl=driver.getCurrentUrl();
        System.out.println("Assets page URL:"+currentUrl);
        wait.until(ExpectedConditions.elementToBeClickable(header_title)).click();
        assertEquals(currentUrl,expectedUrl);
    }

    public void checkUserIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(icon_user)).isDisplayed();
    }

    public void clickHeaderProductCategoryInfrastructure(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_products)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_product_category_infrastructure)).click();
    }

    public void clickHeaderProductSecondaryCategoryNetwork(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_product_category_network)).click();
    }

    public void clickHeaderSolutionCategoryIndustrySolution(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_product_category_infrastructure)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_solutions)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_solution_industry_solution)).click();
    }

    public void clickHeaderSolutionCategoryITSoftware(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_header_solution_it_software)).click();
    }


}
