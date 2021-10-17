package cucumber.zadania;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/hotel-testlab-register.feature",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class HotelTestlabRegistrationTest {
}
