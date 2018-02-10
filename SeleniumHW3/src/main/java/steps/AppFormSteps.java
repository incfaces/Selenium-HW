package steps;

import org.openqa.selenium.WebDriver;
import pages.AppFormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class AppFormSteps {
    WebDriver driver;
    
    public AppFormSteps(WebDriver driver){
        this.driver = driver;
    }

    @Step ("заполнено поле {0} значением {1}")
    public void fillField(String fieldName, String value) {
        new AppFormPage(driver).fillField(fieldName,value);
    }

    @Step("Заполнение полей:")
    public void fullFields(HashMap<String,String> fields){
        fields.forEach((key, value)->fillField(key,value));
    }

    @Step("Указание пола - Мужской")
    public void stepSetMale(String value){
        new AppFormPage(driver).sex(value);
    }

    @Step("В поле {0} присутсвие значения {1}")
    public void stepCheck(String value){
        new AppFormPage(driver).getFillValue(value);
    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFullField(String field, String value){
        String Value = new AppFormPage(driver).getFillValue(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, Value, value),Value.equals(value));
    }
    @Step("Поля заполнены следующими данными:")
    public void checkFilling(HashMap<String,String> fields){
        fields.forEach((key, value)-> checkFullField(key,value));
    }

    @Step("Нажать кнопку Далее")
    public void stepClickForward(){
        new AppFormPage(driver).clickContinue();
    }

    @Step("Проверить наличие ошибки")
    public void checkErrorMessage(String value){
        new AppFormPage(driver).checkMessage(value);}
}
