import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 22.01.2018.
 */
public class Task1 {
    WebDriver driver;
    WebDriverWait wait;
    @Before
            public void setUp (){
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10, 500);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testOne() throws InterruptedException {

        //1. Перейти на страницу http://www.sberbank.ru/ru/person
        driver.get("http://www.sberbank.ru/ru/person");

        //2. Нажать на – Застраховать себя и имущество
        click(By.xpath("//a[@aria-label='Раздел Застраховать себя  и имущество']"));

        //3. Выбрать – Страхование путешественников
        click(By.xpath("//a[contains(text(),'Страхование путешественников')]"));

        //4. Проверить наличие на странице заголовка – Страхование путешественников
        Assert.assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']/h1")).getText());

        //5. Нажать на – Оформить Онлайн
        click(By.xpath("//a/img[contains(@src,'banner-zashita-traveler')]"));

        //Переход на новую страницу и ожидание зпгрузки необходимого элемента
        Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[windows.length-1].toString());

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),\"Минимальная\")]"))));
        click(By.xpath("//*[contains(text(),'Минимальная')]"));


        //6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
        click(By.xpath("//*[contains(text(),'Минимальная')]"));

        //Шаг 7. Нажать Оформить
        click(By.xpath("//*[contains(text(),'Оформить')]"));

        //8. На вкладке Оформить заполнить поля:
        wait.until(ExpectedConditions.elementToBeClickable(By.name("insured0_surname")));

        fillField(By.name("insured0_surname"), "Carlos");
        fillField(By.name("insured0_name"), "Castaneda");
        fillField(By.name("insured0_birthDate"), "25.12.1935");

        fillField(By.name("surname"), "Дон");
        fillField(By.name("name"), "Хуан");
        fillField(By.name("middlename"), "Матус");
        fillField(By.name("birthDate"),"01.01.1910");

        driver.findElement(By.name("male")).click();
        fillField(By.name("passport_series"),"1234");
        fillField(By.name("passport_number"),"567890");
        fillField(By.name("issueDate"), "01.01.2018");
        //click(By.xpath("//a[contains(text(),23)]"));
        fillField(By.name("issuePlace"), "Mexico");

        //9. Проверить, что все поля заполнены правильно
        Assert.assertEquals("Carlos", driver.findElement(By.xpath("//INPUT[@name='insured0_surname']")).getAttribute("value"));
        Assert.assertEquals("Castaneda", driver.findElement(By.xpath("//INPUT[@name='insured0_name']")).getAttribute("value"));
        Assert.assertEquals("25.12.1935", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("Дон", driver.findElement(By.xpath("//INPUT[@name='surname']")).getAttribute("value"));
        Assert.assertEquals("Хуан", driver.findElement(By.xpath("//INPUT[@name='name']")).getAttribute("value"));
        Assert.assertEquals("Матус", driver.findElement(By.xpath("//INPUT[@name='middlename']")).getAttribute("value"));
        Assert.assertEquals("01.01.1910", driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1234", driver.findElement(By.xpath("//input[@placeholder='Серия']")).getAttribute("value"));
        Assert.assertEquals("567890", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        Assert.assertEquals("01.01.2018", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("Mexico", driver.findElement(By.xpath("//TEXTAREA[@name='issuePlace']")).getAttribute("value"));

        //10. Нажать продолжить
        click(By.xpath("//span[contains(text(), 'Продолжить')]"));

        //11. Проверить, что появилось сообщение - Заполнены не все обязательные поля
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid']")).getText());

        //Время для небольшого созерцания
        Thread.sleep(3000);

    }
    @After
    public void clear(){
        driver.quit();
        driver = null;
    }

    private void click(By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
        }


}
