package wyklad.mystore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestNoPOP {

    private WebDriver driver;

    @BeforeEach
    //@Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginWithProperCredentials() {
        // przejdz na strone mystore
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        // kliknij przycisk Sign In
        WebElement signInButtonTop = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        signInButtonTop.click();

        // podaj email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("johnd@mail.com");

        // podaj haslo
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("qwerty");

        // kliknij przycisk Sign in
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        //pobierz i sprawdz nazw uzytkownika
        WebElement userFullNameButton = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        String userFullName = userFullNameButton.getText();

        Assertions.assertEquals("John Doe", userFullName);
    }

    @AfterEach
    //@After
    public void tearDown() {
        driver.close();
    }
}
