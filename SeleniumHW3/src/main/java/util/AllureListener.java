package util;


import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Attachment;


/**
 * Created by Oggy Osbourne on 05.02.2018.
 */
public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BasePage.takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png",value = "Скриншот ошибки")
    public byte[] takeScreenshot(){
        return  ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    }
