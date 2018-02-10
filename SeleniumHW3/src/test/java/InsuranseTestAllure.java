
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class InsuranseTestAllure extends BaseTest{

    @Test
    @Title("Страхование путешестевнников")
    public void testOne() {

        AppFormSteps appformSteps = new AppFormSteps(driver);
        InsProgramSteps insprogramSteps = new InsProgramSteps(driver);
        PersonSteps personSteps = new PersonSteps(driver);
        VeiwCalcSteps veiwcalcSteps = new VeiwCalcSteps(driver);

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        personSteps.openHomepage();

        //2. Нажать на – Застраховать себя и имущество
        personSteps.stepSelectMainMenu("Застраховать себя");

        //3. Выбрать – Страхование путешественников
        personSteps.stepSelectSubMenu("Страхование путешественников");

        //4. Проверить наличие на странице заголовка – Страхование путешественников
        insprogramSteps.stepCheckTitle();

        //5. Нажать на – Оформить Онлайн
        insprogramSteps.stepClickSendNowButton();
        insprogramSteps.switchNextPage();

        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        veiwcalcSteps.stepClickMinSum("Минимальная");
        veiwcalcSteps.stepClickProceed();

        //8. На вкладке Оформить заполнить поля:
        HashMap<String, String> inputData = new HashMap<>();
        inputData.put("Фамилия застрахованного", "Carlos");
        inputData.put("Имя застрахованного", "Castaneda");
        inputData.put("Дата рождения застрахованного", "25.12.1935");
        inputData.put("Фамилия", "Дон");
        inputData.put("Имя", "Хуан");
        inputData.put("Отчество", "Матус");
        inputData.put("Дата рождения", "01.01.1910");
        inputData.put("Серия", "1234");
        inputData.put("Номер", "567890");
        inputData.put("Дата выдачи", "01.01.2018");
        inputData.put("Кем выдан", "Mexico");
        appformSteps.fullFields(inputData);
        appformSteps.checkFilling(inputData);
        appformSteps.stepSetMale("мужской");
        appformSteps.stepClickForward();
        appformSteps.checkErrorMessage("Заполнены не все обязательные поля");


        /*/1. Перейти на страницу http://www.sberbank.ru/ru/person
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
*/
    }
}
