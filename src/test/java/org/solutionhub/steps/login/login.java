package org.solutionhub.steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.TestRunner;
import org.solutionhub.hooks.hooks;
import org.solutionhub.services.loginPage.LoginService;
import org.solutionhub.utils.ConfigReader;

public class login {
    private WebDriver driver= hooks.get();
    private WebDriverWait wait= hooks.getWait();

    LoginService loginSer=new LoginService();

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        String url = ConfigReader.getProperty("URL_QA");
        driver.get(url);
    }

    @When("User click on sign-in button")
    public void user_click_on_sign_in_button() {
       loginSer.clickSignin();
    }

    @And("User enter admin username and password")
    public void user_enter_admin_username_and_password() {
        String adminUsername=ConfigReader.getProperty("ADMIN_USERNAME");
        String adminPassword=ConfigReader.getProperty("ADMIN_PASSWORD");
        loginSer.enterUsername(adminUsername);
        loginSer.enterPassword(adminPassword);
    }

    @And("User enter producer username and password")
    public void user_enter_producer_username_and_password() {
        String producerUsername=ConfigReader.getProperty("PRODUCER_USERNAME");
        String producerPassword= ConfigReader.getProperty("PRODUCER_PASSWORD");
        loginSer.enterUsername(producerUsername);
        loginSer.enterPassword(producerPassword);
    }

    @And("User enter group-admin username and password")
    public void user_enter_group_admin_username_and_password() {
        String groupAdminUsername=ConfigReader.getProperty("GROUP_ADMIN_USERNAME");
        String groupAdminPassword= ConfigReader.getProperty("GROUP_ADMIN_PASSWORD");
        loginSer.enterUsername(groupAdminUsername);
        loginSer.enterPassword(groupAdminPassword);
    }

    @Then("User click the login button")
    public void user_click_the_login_button() {
        loginSer.clickLogin();
    }

    @Then("User should see the Admin label on top of the page")
    public void user_should_see_the_admin_label_on_top_of_the_page() {
        loginSer.checkAdminisDisplayed();
    }

    @Then("User should not see the Admin label on top of the page")
    public void user_should_not_see_the_admin_label_on_top_of_the_page() {
        loginSer.checkProducerisDisplayed();
    }

    @And("User should logout")
    public void user_should_logout() {
        loginSer.clickLogout();
    }



}
