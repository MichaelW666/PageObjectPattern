package pages.hotel.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {

    private WebDriver driver;

    @FindBy(className = "user_login")
    private WebElement signInButton;

    @FindBy(id = "header_logo")
    private WebElement logo;

    public HeaderSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToAuthentication() {
        signInButton.click();
    }

    public void clickLogo() {
        logo.click();
    }
}
