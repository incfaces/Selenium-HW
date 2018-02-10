package ru.sber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class InsProgramPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'sbrf-rich-outer')]/h1")
    public WebElement header;

    @FindBy(xpath = "//a/img[contains(@src,'banner-zashita-traveler')]")
    public WebElement PicButton;

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement title;

    public InsProgramPage(){
        PageFactory.initElements(driver, this);
    }
    public WebElement getTitle() {
        return title;
    }

    public void clickSendNowButton (){
        PicButton.click();
        switchNextPage();
    };

    public void switchNextPage() {
        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[windows.length-1].toString());
    }

}
