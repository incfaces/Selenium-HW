package steps;

import org.openqa.selenium.WebDriver;
import pages.PersonPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class PersonSteps {
    WebDriver driver;

    public PersonSteps(WebDriver driver){
        this.driver = driver;
    }

    @Step("Зайти на главную страницу")
    public void openHomepage(){
        new PersonPage(driver).open();
    }

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        new PersonPage(driver).selectMainMenu(menuItem);
    }

    @Step("Выбран вид страхования {0}")
    public void stepSelectSubMenu(String menuItem){
        new PersonPage(driver).selectSubMenu(menuItem);
    }
}
