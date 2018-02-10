package ru.sber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class PersonPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'bp-area header_more_nav')]//div[@class= 'alt-menu-mid']")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class = 'sbrf-div-list-inner --area bp-area header_more_nav']//a[contains(@aria-label, 'Раздел Застраховать себя  и имущество')]/../div[contains(@class, 'alt-menu-collapser__area_cols_3')]")
    WebElement subMenu;

    @FindBy(xpath = "//a[@aria-label='Раздел Застраховать себя  и имущество']")
    WebElement title;

    String baseUrl;

    public PersonPage(){
        PageFactory.initElements(driver, this);
        baseUrl = properties.getProperty("app.url");
    }

    public void open(){
        driver.get(baseUrl);
    }

    public void selectMainMenu(String menuItem){
        click(menuItems.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")));
    }

    public void selectSubMenu(String menuItem){
        click(subMenu.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")));
    }
}
