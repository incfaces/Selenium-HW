
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
    }
}
