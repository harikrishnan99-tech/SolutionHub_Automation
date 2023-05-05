package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        WebDriver driver=null;
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Solutionhub_Automation\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Solutionhub_Automation\\Drivers\\edgedriver.exe");
            driver = new EdgeDriver();
        }
        return driver;
    }

}
