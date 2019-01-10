package Run.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty","html:target\\HtmlReport" },
features = "src\\test\\java\\cucumber\\feature\\Registration.feature",
monochrome = true, glue = "StepDefinitions.cucumber")
public class RunCucumberTest {
}
