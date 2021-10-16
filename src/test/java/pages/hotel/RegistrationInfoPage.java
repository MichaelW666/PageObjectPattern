package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationInfoPage {

    private WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public RegistrationInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUserRegistrationData(
            String firstName,
            String lastName,
            String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        registerButton.click();
    }

    // to powinno znalezc sie w oddzielnym page objectie
    @FindBy(className = "alert-success")
    private WebElement successMessage;

    public String getRegistrationSuccessMessage() {
        return successMessage.getText();
    }
}
