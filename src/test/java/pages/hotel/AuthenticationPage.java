package pages.hotel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class AuthenticationPage {

    private WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "email")
    private WebElement emailLoginInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerAs(String email) {
        emailCreateInput.clear();
        emailCreateInput.sendKeys(email);
        createAnAccountButton.click();
    }

    public void loginAs(String email, String password) {
        emailLoginInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}
