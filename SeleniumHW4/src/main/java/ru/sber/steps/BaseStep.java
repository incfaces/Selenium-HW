package ru.sber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sber.util.TestProperties;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public static void setUp() throws Exception {

        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
        }

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 200);
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
