package ru.yandex.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tools {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public Tools(){
        driver = Runner.getDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public boolean elementExists(WebElement element){
        try{
            element.getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void sendKeys(By locator, String data){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendKeys(driver.findElement(locator), data);
    }

    public void mouseOn(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
        new Actions(driver).moveToElement(driver.findElement(locator)).build().perform();
    }

    public void sendKeys(WebElement element, String data){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        element.sendKeys(data);
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
}
