package org.solutionhub.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solutionhub.utils.BrowserFactory;
import java.time.Duration;

public class hooks {
    public static WebDriver driver= BrowserFactory.getDriver();
    public static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));

    @Before
    public static void setUp() {
        System.out.println("DRIVER LOADED!!");
    }

    public static WebDriver get() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png","Screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        driver.quit();
    }
}
