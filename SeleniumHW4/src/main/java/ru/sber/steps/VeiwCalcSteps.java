package ru.sber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import ru.sber.pages.VeiwCalcPage;

/**
 * Created by Oggy Osbourne on 06.02.2018.
 */
public class VeiwCalcSteps {

    @Then("^указать \"(.+)\" сумму страхования$")
    public void stepClickMinSum(String menuItem){
        new VeiwCalcPage().selectSumm(menuItem);
    }

    @And("^нажать на кнопку 'Продолжить'")
    public void stepClickProceed(){
        new VeiwCalcPage().pressAppButton();
    }
}
