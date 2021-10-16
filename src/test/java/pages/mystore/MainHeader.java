package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHeader {

    private WebDriver driver;

    @FindBy(css = "#_desktop_user_info span")
    private WebElement signInButtonTop;

    public MainHeader(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSignInButton() {
        signInButtonTop.click();
    }

    public String getFullUserName() {
        return signInButtonTop.getText();
    }
}
