package org.solutionhub.services.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.TestRunner;
import org.solutionhub.hooks.hooks;

public class LoginService {



    private WebDriver driver= hooks.get();
    private WebDriverWait wait= hooks.getWait();

    By btn_signin= By.cssSelector
            ("body > app-root > app-header > div > nav > div.d-flex.flex-row.ml-auto > div > a.btn.btn-primary.size-m.font-14px.text-nowrap");
    By txt_username=By.xpath
            ("//input[@id='username']");
    By txt_password=By.xpath
            ("//input[@id='password']");
    By btn_login=By.cssSelector
            ("#kc-login");
    By txt_admin=By.cssSelector
            ("body > app-root > app-header > div > nav > div.d-flex.flex-row.ml-auto > div > app-user-role-badge > span > span");

    By txt_producer=By.cssSelector
            ("body > app-root > app-header > div > nav > div.d-flex.flex-row.ml-auto > div > lib-user-pic > span > span");

    By btn_logout=By.cssSelector
            ("body > app-root > app-header > div > nav > div.d-flex.flex-row.ml-auto > div > a");

    public void clickSignin(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_signin)).click();
    }

    public void enterUsername(String username){
        wait.until(ExpectedConditions.elementToBeClickable(txt_username)).sendKeys(username);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(txt_password)).sendKeys(password);
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
    }

    public void checkAdminisDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_admin)).isDisplayed();
    }

    public void checkProducerisDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(txt_producer)).isDisplayed();
    }

    public void clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_logout)).click();
    }

}
