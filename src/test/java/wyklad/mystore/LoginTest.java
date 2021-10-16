package wyklad.mystore;

import common.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.mystore.LoginPage;
import pages.mystore.MainHeader;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    //@Before - Junit 4
    public void setUp() {
        driver = Utils.setUpDriver();
    }

    @Test
    public void loginWithProperCredentials() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        LoginPage loginPage = new LoginPage(driver);
        MainHeader mainHeader = new MainHeader(driver);

        mainHeader.clickSignInButton();
        loginPage.loginAs("johnd@mail.com", "qwerty");

        String fullUserName = mainHeader.getFullUserName();
        Assertions.assertEquals("John Doe", fullUserName);
    }

    @AfterEach
    //@After - JUnit 4
    public void tearDown() {
        driver.close();
    }
}
