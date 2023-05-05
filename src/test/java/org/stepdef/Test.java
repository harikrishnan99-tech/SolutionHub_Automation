package org.stepdef;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.picocontainer.PicoFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFactory;
import utils.ConfigReader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/login.feature"},
        glue = {"org.stepdef"}
)
public class Test {
    private static WebDriver driver=BrowserFactory.getDriver();
    private static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeClass
    public static void setUp() {
        System.out.println("DRIVER LOADED!!");
    }

    public static WebDriver get() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }



}
