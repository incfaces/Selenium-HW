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
 * Created by Oggy Osbourne on 04.02.2018.
 */
public class VeiwCalcPage extends BasePage {

    @FindBy(xpath = "//h3 [text()='Выберите сумму страховой защиты']/parent::section")
    public WebElement summ;

    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    public WebElement applyButton;

    public VeiwCalcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(summ));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",summ);
        wait.until(ExpectedConditions.visibilityOf(applyButton));
    }

    public void selectSumm(String webItem){
        summ.findElement(By.xpath(".//div[text()='"+ webItem +"']")).click();

    }

    public void pressAppButton(){
        applyButton.click();
    }

}
