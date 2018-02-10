package ru.yandex.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.pages.StartPage;

public class StartSteps {
    private StartPage startPage = new StartPage();

    @When("^открыта главная страница$")
    public void openHomepage(){
        startPage.open();
    }

    @Then("^перейти в 'Маркет'$")
    public void search(){
        startPage.switchTo();
    }

}
