package org.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import java.time.Duration;

public class login {
    private WebDriver driver=Test.get();
    private WebDriverWait wait=Test.getWait();

    @Given("I am on the landing page")
    public void i_am_on_the_landing_page() {
        String url = ConfigReader.getProperty("url_qa");
        Test.get().get(url);
        System.out.println("User is on Landing Page");
    }

    @When("I click on sign-in button")
    public void i_click_on_sign_in_button() {
       wait.until(ExpectedConditions.elementToBeClickable(
               By.xpath("/html/body/app-root/app-header/div/nav/div[2]/div/a[2]"))).click();
       System.out.println("User clicked on sign-in button");
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("username"))).sendKeys("harikrishnan_anilkumar");
        System.out.println("User entered username");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("password"))).sendKeys("Mykeycloak@123");
        System.out.println("User entered password");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("kc-login"))).click();
        System.out.println("User logged in");
    }

    @Then("I should be redirected to the landing page")
    public void i_should_be_redirected_to_the_landing_page() {
        //waiting for user profile icon to be visible
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/app-root/app-header/div/nav/div[2]/div/lib-user-pic/span/span")));
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://qa-solutionhub.ustpace.com/#/";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("Login Successfull");
    }

}
