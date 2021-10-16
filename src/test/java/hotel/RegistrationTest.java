package hotel;

import common.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.hotel.AuthenticationPage;
import pages.hotel.RegistrationInfoPage;

public class RegistrationTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void registerNewUser() {
        // arrange
        String email = Utils.generateEmail();
        String firstName = "Jan";
        String lastName = "Kowalski";
        String password = "qwerty";

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        RegistrationInfoPage registrationInfoPage = new RegistrationInfoPage(driver);

        // act
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        authenticationPage.registerAs(email);
        registrationInfoPage.fillUserRegistrationData(firstName, lastName, password);

        // assert
        Assertions.assertEquals("Your account has been created.", registrationInfoPage.getRegistrationSuccessMessage());
    }
}
