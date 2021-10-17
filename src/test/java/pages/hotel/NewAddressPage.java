package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class NewAddressPage extends PageBase {

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        super(driver);
    }

    public void fillAndConfirmNewAddressForm(
            String address,
            String zip,
            String city,
            String homePhone,
            String mobilePhone,
            String alias
    ) {
        addressInput.sendKeys(address);
        zipCodeInput.sendKeys(zip);
        cityInput.sendKeys(city);
        homePhoneInput.sendKeys(homePhone);
        mobilePhoneInput.sendKeys(mobilePhone);
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        saveButton.click();
    }
}
