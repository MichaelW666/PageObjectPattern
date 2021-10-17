package pages.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class YourAccountPage extends PageBase {

    @FindBy(id = "identity-link")
    private WebElement informationButton;

    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToInformation() {
        informationButton.click();
    }
}
