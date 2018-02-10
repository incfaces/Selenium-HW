package ru.sber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.sber.pages.InsProgramPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class InsProgramSteps {

    @When("^проверить, что заголовок страницы 'Страхование путешественников'$")
    public void stepCheckTitle(){
        new InsProgramPage().getTitle();
    }

    @When("^нажимаем на 'Оформить Онлайн'$")
    public void stepClickSendNowButton(){
        new InsProgramPage().clickSendNowButton();
    }

}
