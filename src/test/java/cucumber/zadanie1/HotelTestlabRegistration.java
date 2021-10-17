package cucumber.zadanie1;

import common.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HotelTestlabRegistration {

    private WebDriver driver;

    @Before
    public void setupDriver() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.quit();
    }

    @Given("user is on the hotel-testlab website")
    public void userIsOnTheHotelTestlabWebsite() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("user clicks Sign in button")
    public void userClicksSignInButton() {
        WebElement signInButton = driver.findElement(By.cssSelector(".user_login.navigation-link"));
        signInButton.click();
    }

    @When("user inputs {string} address in Create an Account section")
    public void userInputsEmailAddressInCreateAnAccountSection(String email) {
        WebElement registrationEmailInput = driver.findElement(By.id("email_create"));
        registrationEmailInput.sendKeys(email);
        //registrationEmailInput.sendKeys(Utils.generateEmail());
    }

    @And("user clicks Create an account button")
    public void userClicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user fills {string} as first Name, {string} as last Name and {string} as password")
    public void userFillsFirstNameLastNameAndPassword(String firstName, String lastName, String password) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("user clicks Register")
    public void userClicksRegister() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("{string} is displayed")
    public void isDisplayed(String message) {
        String successAlertText = driver.findElement(By.className("alert-success")).getText();
        Assertions.assertEquals(message, successAlertText, "Error occured!");
    }
}
