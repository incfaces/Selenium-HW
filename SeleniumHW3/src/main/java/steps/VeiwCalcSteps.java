package steps;

import org.openqa.selenium.WebDriver;
import pages.VeiwCalcPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class VeiwCalcSteps {

    WebDriver driver;

    public VeiwCalcSteps(WebDriver driver){
        this.driver = driver;
    }

    @Step("Выбрать вкладку - Минимальный")
    public void stepClickMinSum(String menuItem){
        new VeiwCalcPage(driver).selectSumm(menuItem);
    }

    @Step("Нажать кнопку - Продолжить")
    public void stepClickProceed(){
        new VeiwCalcPage(driver).pressAppButton();
    }
}
