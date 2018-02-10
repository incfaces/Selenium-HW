package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;

import java.util.Properties;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickWithoutWait(locator);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickWithoutWait(element);
    }

    public void clickWithoutWait(By locator){
        clickWithoutWait(driver.findElement(locator));
    }

    public void clickWithoutWait(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();
    }

    public void fillField(By locator, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        element.sendKeys(value);
    }

    public void fillField(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        element.sendKeys(value);
    }


}
