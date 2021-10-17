package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class UserInfoPage extends PageBase {

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "birthday")
    private WebElement birthdateInput;

    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//*[@data-link-action='save-customer']")
    private WebElement saveButton;

    @FindBy(className = "alert-success")
    private WebElement successInformation;

    public UserInfoPage(WebDriver driver) {
        super(driver);
    }

    public void setBirthdate(String birthdate) {
        birthdateInput.clear();
        birthdateInput.sendKeys(birthdate);
    }

    public void signInForNewsletter() {
        checkCheckbox();
    }

    public void signOutForNewsletter() {
        uncheckCheckbox();
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void saveData() {
        saveButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

    private void checkCheckbox() {
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    private void uncheckCheckbox() {
        if (newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }
}
