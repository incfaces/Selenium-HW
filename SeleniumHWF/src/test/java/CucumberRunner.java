import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        glue = {"ru.yandex"},
        plugin = {"ru.yandex.utils.AllureReporter"}
)

public class CucumberRunner {
}