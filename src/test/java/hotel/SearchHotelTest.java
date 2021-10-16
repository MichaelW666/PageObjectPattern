package hotel;

import common.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.hotel.AuthenticationPage;
import pages.hotel.RegistrationInfoPage;
import pages.hotel.sections.HeaderSection;

public class SearchHotelTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void registerNewUser() {
        // arrange
        String email = "johndoe@mail.com";
        String password = "qwerty";

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        HeaderSection headerSection = new HeaderSection(driver);

        // act
        headerSection.goToAuthentication();
        authenticationPage.loginAs(email, password);
        headerSection.clickLogo();

        // assert

    }
}
