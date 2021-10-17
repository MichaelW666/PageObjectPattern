package pages.hotel.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class UserMenu extends PageBase {

    @FindBy(id = "user_info_acc")
    private WebElement userName;

    @FindBy(xpath = "//*[text()='Accounts']")
    private WebElement accountsOption;

    @FindBy(className = "icon-building")
    private WebElement myAddressessButton;

    public UserMenu(WebDriver driver) {
        super(driver);
    }

    public void goToMyAddresses() {
        userName.click();
        accountsOption.click();
        myAddressessButton.click();
    }
}
