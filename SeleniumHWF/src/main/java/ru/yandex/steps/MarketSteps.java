package ru.yandex.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ru.yandex.pages.MarketPage;

public class MarketSteps {
    MarketPage marketPage = new MarketPage();
    String savedTitle;

    @When("^выбран раздел \"(.+)\"$")
    public void openSection(String element){
        marketPage.focusOn(element);
    }

    @Then("^выбрать раздел \"(.+)\"$")
    public void select(String item){
        marketPage.select(item);
    }

    @Then("^указать сумму с ([0-9]+)$")
    public void setAmountFrom(String value){
        marketPage.setAmountFrom(value);
    }

    @When("^выбран бренд (.+)$")
    public void selectBrand(String brand){
        marketPage.selectBrand(brand);
    }

    @When("^выбраны бренды (.+)$")
    public void selectBrands(String brands){
        marketPage.selectBrands(brands);
    }

    @Then("^Нажать на кнопку 'Применить'$")
    public void applyFilterButtonClick(){
            marketPage.submitFilter();
    }

    @And("^количество товаров на странице = ([0-9]+)$")
    public void checkCountOfProducts(String count){
        Long intCount = new Long(count);
        Assert.assertEquals(new Long(marketPage.getListOfElements().size()), intCount);
    }

    @And("^запомнить наименование первого элемента$")
    public void saveTitle(){
        savedTitle = marketPage.getListOfElements().get(0).getText();
    }

    @Then("^искать по значению первого элемента$")
    public void search(){
        marketPage.search(savedTitle);
    }

    @Then("^проверить, что результат поиска содержит запомненный продукт")
    public void checkResults(){
        Assert.assertTrue(marketPage.isSearchResultContains(savedTitle));
    }


}

