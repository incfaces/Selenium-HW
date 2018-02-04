import Pages.AppFormPage;
import Pages.InsProgramPage;
import Pages.PersonPage;
import Pages.VeiwCalcPage;
import org.junit.Assert;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

/**
 * Created by Oggy Osbourne on 03.02.2018.
 */
public class NewInsuranseTest extends BaseTest {

    @Test
    public void testOne() throws InterruptedException {

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get(baseUrl);

        //2. Нажать на – Застраховать себя и имущество
        PersonPage personPage = new PersonPage(driver);
        personPage.selectMainMenu("Застраховать себя");

        //3. Выбрать – Страхование путешественников
        personPage.selectSubMenu("Страхование путешественников");

        //4. Проверить наличие на странице заголовка – Страхование путешественников
        InsProgramPage insprogramPage = new InsProgramPage(driver);
        Assert.assertEquals("Страхование путешественников",insprogramPage.header.getText());

        //5. Нажать на – Оформить Онлайн
        insprogramPage.PicButton.click();

        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[windows.length-1].toString());

        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        VeiwCalcPage veiwcalcPage = new VeiwCalcPage(driver);
        veiwcalcPage.selectSumm("Минимальная");
        Thread.currentThread().sleep(1000) ;
        veiwcalcPage.pressAppButton();

        //8. На вкладке Оформить заполнить поля:
        Thread.currentThread().sleep(3000) ;
        AppFormPage appformPage = new AppFormPage(driver);

        appformPage.fillField("Фамилия застрахованного", "Carlos");
        appformPage.fillField("Имя застрахованного", "Castaneda");
        appformPage.fillField("Дата рождения застрахованного", "25.12.1935");
        appformPage.fillField("Фамилия", "Дон");
        appformPage.fillField("Имя", "Хуан");
        appformPage.fillField("Отчество", "Матус");
        appformPage.fillField("Дата рождения", "01.01.1910");
        appformPage.sex("мужской");
        appformPage.fillField("Серия", "1234");
        appformPage.fillField("Номер", "567890");
        appformPage.fillField("Дата выдачи", "01.01.2018");
        appformPage.fillField("Кем выдан", "Mexico");


        assertEquals("Carlos", appformPage.insuredSurName.getAttribute("value"));
        assertEquals("Castaneda", appformPage.insuredName.getAttribute("value"));
        assertEquals("25.12.1935", appformPage.insuredBirthDate.getAttribute("value"));

        assertEquals("Дон", appformPage.surname.getAttribute("value"));
        assertEquals("Хуан", appformPage.name.getAttribute("value"));
        assertEquals("Матус", appformPage.middlename.getAttribute("value"));
        assertEquals("01.01.1910", appformPage.birthDate.getAttribute("value"));
        assertEquals("female", appformPage.female.getAttribute("name"));
        assertEquals("1234", appformPage.passportSeries.getAttribute("value"));
        assertEquals("567890", appformPage.passportNumber.getAttribute("value"));
        assertEquals("01.01.2018", appformPage.issueDate.getAttribute("value"));
        assertEquals("Mexico", appformPage.issuePlace.getAttribute("value"));

        appformPage.clickContinue();
        Thread.currentThread().sleep(1000) ;
        appformPage.checkMessage("Заполнены не все обязательные поля");

    }
}
