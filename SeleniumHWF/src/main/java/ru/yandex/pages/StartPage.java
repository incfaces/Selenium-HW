package ru.yandex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.utils.Tools;

public class StartPage extends Tools{
    String pageUrl = "https://www.yandex.ru/";

    @FindBy(linkText = "Маркет")
    WebElement marketLink;

    public StartPage(){
        PageFactory.initElements(driver, this);
    }

    public void switchTo(){
        click(marketLink);
        new MarketPage().regionSubmit();
    }

    public void open(){
        driver.get(pageUrl);
    }

}
