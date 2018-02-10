package ru.sber.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.sber.pages.AppFormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class AppFormSteps {

    @Step ("заполнено поле {0} значением {1}")
    public void fillField(String fieldName, String value) {
        new AppFormPage().fillField(fieldName,value);
    }

    @When("^заполнены поля:$")
    public void fullFields(DataTable fields){
        Map<String, String> data = fields.asMap(String.class, String.class);
        data.forEach((key, value)->fillField(key,value));
    }

    @And("^указать пол - \"(.+)\"$")
    public void stepSetMale(String value){
        new AppFormPage().sex(value);
    }

    @Step("В поле {0} присутсвие значения {1}")
    public void stepCheck(String value){
        new AppFormPage().getFillValue(value);
    }

    @Step("Поле {0} заполнено значением {1}")
    public void checkFullField(String field, String value){
        String Value = new AppFormPage().getFillValue(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, Value, value),Value.equals(value));
    }

    @Then("^значения полей:$")
    public void checkFilling(DataTable fields){
        fields.asMap(String.class, String.class).forEach((key, value)-> checkFullField(key,value));
    }

    @When("^нажимаем на кнопку 'Продолжить'$")
    public void stepClickForward(){
        new AppFormPage().clickContinue();
    }

    @Then("^тогда появляется сообщение \"(.+)\"")
    public void checkErrorMessage(String value){
        new AppFormPage().checkMessage(value);}
}
