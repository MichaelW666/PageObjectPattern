package waits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitingsTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test
    public void noWait() {
        WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));

        clickMeButton.click();
    }

    @Test
    public void sleepWait() throws InterruptedException {
        WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));
        Thread.sleep(5000);
        clickMeButton.click();
    }

    @Test
    public void sleepWithWhileLoop() throws InterruptedException {

        int counter = 0;
        int threshold = 10000;
        int interval = 1000;

        WebElement loader = driver.findElement(By.id("loader"));
        while (loader.isDisplayed()) {
            Thread.sleep(interval);
            counter += interval;
            if (threshold < counter)
                throw new TimeoutException("Element was not displayed");
        }

        WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));
        clickMeButton.click();
    }

    @Test
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));
        clickMeButton.click();
    }

    @Test
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // jesli element jest wbudowany w strone
        //WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));
        //wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));
        //clickMeButton.click();

        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 p")));
        el.click();
    }

    @Test
    public void fluentWait() {
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        //wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 p")));

        WebElement clickMeButton = driver.findElement(By.cssSelector("#button1 p"));
        clickMeButton.click();
    }
}
