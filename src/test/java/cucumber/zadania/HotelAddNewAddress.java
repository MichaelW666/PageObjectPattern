package cucumber.zadania;

import common.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.hotel.AuthenticationPage;
import pages.hotel.NewAddressPage;
import pages.hotel.sections.HeaderSection;
import pages.hotel.sections.UserMenu;

public class HotelAddNewAddress {

    private WebDriver driver;

    @Given("user with hotel-testlab account with opened website")
    public void userWithHotelTestlabAccountWithOpenedWebsite() {
        driver = Utils.setUpDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("user logs in with {string} and {string}")
    public void userLogsIn(String email, String password) {
        HeaderSection headerSection = new HeaderSection(driver);
        headerSection.goToAuthentication();
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginAs(email, password);
    }

    @And("user goes to My addresses page")
    public void userGoesToMyAddressesPage() {
        UserMenu userMenu = new UserMenu(driver);
        userMenu.goToMyAddresses();
    }

    @And("user clicks Add a new address button")
    public void userClicksAddANewAddressButton() {
        //driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span")).click();
    }

    @When("user fills {string}, {string}, {string}, {string}, {string} and {string}")
    public void userFillsAnd(
            String address,
            String zip,
            String city,
            String homePhone,
            String mobilePhone,
            String title) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillAndConfirmNewAddressForm(
               address, zip, city, homePhone, mobilePhone, title
        );
    }

    @Then("new address {string} appears on My Addresses page")
    public void newAddressAppearsOnMyAddressesPage(String address) {
        WebElement addedAddress = driver.findElement(By.xpath("//*[text()='" + address + "']/../.."));
        addedAddress.findElement(By.xpath("//*[@data-id=\"addresses_confirm\"]")).click();
    }
}
