package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Oggy Osbourne on 03.02.2018.
 */
public class InsProgramPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'sbrf-rich-outer')]/h1")
    public WebElement header;

    @FindBy(xpath = "//a/img[contains(@src,'banner-zashita-traveler')]")
    public WebElement PicButton;

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement title;

    public InsProgramPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public WebElement getTitle() {
        return title;
    }

}
