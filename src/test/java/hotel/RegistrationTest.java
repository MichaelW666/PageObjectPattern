package hotel;

import common.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.hotel.AuthenticationPage;

public class RegistrationTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void registerNewUser() {
        String email = Utils.generateEmail();

        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.registerAs(email);
    }
}
