package Pages;

import org.junit.Assert;
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
public class AppFormPage extends BasePage {

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement button;

    @FindBy(xpath = "//input[@name = 'insured0_surname']")
    public WebElement insuredSurName;

    @FindBy(xpath = "//input[@name = 'insured0_name']")
    public WebElement insuredName;

    @FindBy(xpath = "//input[@name = 'insured0_birthDate']")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "female")
    public WebElement female;

    @FindBy(name = "male")
    public WebElement male;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;


    @FindBy(xpath = "//div [text()='Заполнены не все обязательные поля']" )
    public WebElement alertText;

    public void fillField(String fieldName, String value) {
        if (fieldName.equals("Фамилия застрахованного")) {
            fillElement(insuredSurName, value);
        }
        else if (fieldName.equals("Имя застрахованного")){
            fillElement(insuredName, value);
        }
        else if (fieldName.equals("Дата рождения застрахованного")){
            fillElement(insuredBirthDate, value);
        }
        else if (fieldName.equals("Фамилия")) {
            fillElement(surname, value);
        }
        else if (fieldName.equals("Имя")) {
            fillElement(name, value);
        }
        else if (fieldName.equals("Отчество")) {
            fillElement(middlename, value);
        }
        else if (fieldName.equals("Дата рождения")) {
            fillElement(birthDate, value);
        }
        else if (fieldName.equals("Серия")) {
            fillElement(passportSeries, value);
        }
        else if (fieldName.equals("Номер")) {
            fillElement(passportNumber, value);
        }
        else if (fieldName.equals("Дата выдачи")) {
            fillElement(issueDate, value);
        }
        else if (fieldName.equals("Кем выдан")) {
            fillElement(issuePlace, value);
        }

        else {
            throw new AssertionError("Поле '" + fieldName + "' отсутствует на странице");
        }
    }

    public void sex(String value) {

        if (value.equals("мужской")) {
            male.click();
        }
        else if (value.equals("женский")) {
            female.click();
        }
        else {
            throw new AssertionError("Поле '" + value + "' отсутствует на странице");
        }
    }
    public void fillElement(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }

    public AppFormPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        Wait<WebDriver> wait = new WebDriverWait(driver,10, 1000);
        wait.until(ExpectedConditions.visibilityOf(insuredSurName));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",insuredSurName);
        wait.until(ExpectedConditions.visibilityOf(button));
    }


    public void clickContinue (){
        button.click();
    }
    public void checkMessage(String inputData){
        Assert.assertEquals(inputData,alertText.getText());
    }
}
