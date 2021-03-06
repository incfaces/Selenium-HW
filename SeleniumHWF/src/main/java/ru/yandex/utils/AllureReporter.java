package ru.yandex.utils;

import gherkin.formatter.model.Result;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result){
        if ("failed".equals(result.getStatus())) takeScreenshot(result);
        super.result(result);
    }

    public void takeScreenshot(Result result){
        if (Runner.getDriver() != null)
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent(Runner.takeScreenshot(), "Error", "image/png"));
    }
}