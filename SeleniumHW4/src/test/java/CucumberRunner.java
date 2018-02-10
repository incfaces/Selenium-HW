import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"ru.sber"},
        plugin = {"ru.sber.util.AllureReporter"}
)

public class CucumberRunner {
}