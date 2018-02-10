package ru.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.utils.Tools;

import java.util.Collections;
import java.util.List;

public class MarketPage extends Tools{

    @FindBy(css = ".n-region-notification__actions-cell")
    WebElement regionSubmit;

    @FindBy(css = "#glf-pricefrom-var")
    WebElement fromAmountInput;

    @FindBy(css = ".button_action_n-filter-apply")
    WebElement filterApplyButton;

    @FindBy(css = ".radio-button__radio_side_right")
    WebElement setListViewButton;

    @FindBy(css = "#header-search")
    WebElement searchHeader;

    String globalChainID;

    public MarketPage(){
        PageFactory.initElements(driver, this);
    }

    public void regionSubmit(){
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(regionSubmit));
        if (elementExists(regionSubmit))click(regionSubmit);
    }

    public void focusOn(String element){
        mouseOn(By.linkText(element));
    }

    public void select(String item){
        click(By.linkText(item));
    }

    public void setAmountFrom(String value){
        sendKeys(fromAmountInput, value);
    }

    public void selectBrands(String brands){
        String[] arrayOfBrands = brands.split(",", -1);
        for(String brand: arrayOfBrands){
            selectBrand(brand);
        }
    }

    @Step("выбран бренд {0}")
    public void selectBrand(String brand){
        click(By.xpath("//label[contains(text(), '"+brand+"')]"));
    }

    public void submitFilter(){
        String data_reqid_chain_before = driver.findElement(By.tagName("body")).getAttribute("data-reqid-chain");
        click(filterApplyButton);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(By.tagName("body"));
                if(data_reqid_chain_before.equals(element.getAttribute("data-reqid-chain")))
                    return false;
                else
                    return true;
            }
        });

        click(setListViewButton);
    }

    public List<WebElement> getListOfElements(){
        return driver.findElements(By.cssSelector(".n-snippet-card2__title"));
    }

    public List<WebElement> getListOfTitles(){
        return driver.findElements(By.cssSelector(".n-title__text"));
    }

    public void search(String query){
        sendKeys(searchHeader, query);
        globalChainID = driver.findElement(By.tagName("body")).getAttribute("data-reqid-chain");
        searchHeader.submit();
    }

    public boolean isSearchResultContains(String element) {
        List<WebElement> elements = Collections.emptyList();

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    List<WebElement> elements = getListOfElements();
                    elements.addAll(getListOfTitles());
                    if (elements.size() != 0 && !elements.get(0).getText().equals(""))return true;
                } catch (StaleElementReferenceException e) {
                    return false;
                }
                return false;
            }
        });

        elements = getListOfElements();
        elements.addAll(getListOfTitles());

        for (WebElement title : elements) {
            if (element.equals(title.getText())) {
                return true;
            }
        }
        return false;
    }

}
