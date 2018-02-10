package pages;

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
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class VeiwCalcPage extends BasePage {

    @FindBy(xpath = "//h3 [text()='Выберите сумму страховой защиты']/parent::section")
    public WebElement summ;

    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    public WebElement applyButton;

    public VeiwCalcPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectSumm(String webItem){
        click(summ.findElement(By.xpath(".//div[text()='"+ webItem +"']")));

    }

    public void pressAppButton(){
        click(applyButton);
    }
}
