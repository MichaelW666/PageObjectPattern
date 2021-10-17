package cucumber.wyklad.wstep;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/google-text-search.feature",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class GoogleSearchTest {
}
