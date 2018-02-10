package ru.sber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.sber.pages.PersonPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class PersonSteps {

    @When("^запущена главная страница$")
    public void openHomepage(){
        new PersonPage().open();
    }

    @When("открыт раздел \"(.+)\"$")
    public void stepSelectMainMenu(String menuItem){
        new PersonPage().selectMainMenu(menuItem);
    }

    @Then("^выбрать услугу \"(.+)\"$")
    public void stepSelectSubMenu(String menuItem){
        new PersonPage().selectSubMenu(menuItem);
    }
}