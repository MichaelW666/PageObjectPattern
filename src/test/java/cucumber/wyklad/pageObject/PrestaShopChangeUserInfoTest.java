package cucumber.wyklad.pageObject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/prestashop-change-user-information.feature",
        plugin = {"pretty", "html:target/cucumber-presta-reports.html"}
)
public class PrestaShopChangeUserInfoTest {
}
