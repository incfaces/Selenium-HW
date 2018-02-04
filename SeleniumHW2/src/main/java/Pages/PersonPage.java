package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oggy Osbourne on 03.02.2018.
 */
public class PersonPage extends BasePage{


    @FindBy(xpath = "//div[contains(@class, 'bp-area header_more_nav')]//div[@class= 'alt-menu-mid']")
    WebElement menuItems;

    @FindBy(xpath = "//div[@class = 'sbrf-div-list-inner --area bp-area header_more_nav']//a[contains(@aria-label, 'Раздел Застраховать себя  и имущество')]/../div[contains(@class, 'alt-menu-collapser__area_cols_3')]")
    WebElement subMenu;

    @FindBy(xpath = "//a[@aria-label='Раздел Застраховать себя  и имущество']")
    WebElement title;

    public PersonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(menuItems));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",menuItems);
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void selectMainMenu(String menuItem){
         menuItems.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem){
            subMenu.findElement(By.xpath(".//*[contains(text(), '" + menuItem + "')]")).click();
    }

}
