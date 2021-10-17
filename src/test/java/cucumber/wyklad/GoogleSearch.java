package cucumber.wyklad;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openBrowserWithGoogleCom() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword {string} is entered in input field")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
    }

    @Then("the first one should contain {string}")
    public void theFirstOneShouldContainSelenium(String expectedKeyword) {
        System.out.println(expectedKeyword);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
