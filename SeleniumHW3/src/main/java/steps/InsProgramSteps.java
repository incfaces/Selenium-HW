package steps;

import org.openqa.selenium.WebDriver;
import pages.InsProgramPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class InsProgramSteps {
    WebDriver driver;

    public InsProgramSteps(WebDriver driver){
        this.driver = driver;
    }
    
    @Step("Проверить текст заголовка")
    public void stepCheckTitle(){
        new InsProgramPage(driver).getTitle();
    }

    @Step("Нажать на кнопку Оформить сейчас")
    public void stepClickSendNowButton(){
        new InsProgramPage(driver).clickSendNowButton();
    }

    @Step("Переход на новую вкладку")
    public void switchNextPage() {

        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[windows.length-1].toString());
    }

}
