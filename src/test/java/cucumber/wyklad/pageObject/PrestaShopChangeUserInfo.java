package cucumber.wyklad.pageObject;

import common.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.mystore.LoginPage;
import pages.mystore.UserInfoPage;
import pages.mystore.YourAccountPage;

public class PrestaShopChangeUserInfo {

    private WebDriver driver;

    private UserInfoPage userInfoPage;

    @Given("User is logged in to CodersLab shop with email: {string} and password: {string}")
    public void userIsLoggedInToCodersLabShopWithEmailAndPassword(String email, String password) {
        driver = Utils.setUpDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @When("User goes to UserInformationPage")
    public void userGoesToUserInformationPage() {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToInformation();
    }

    @And("User changes his birthday to {string}")
    public void userChangesHisBirthdayTo(String birthdate) {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.setBirthdate(birthdate);
    }

    @And("User signs up for our newsletter")
    public void userSignsUpForOurNewsletter() {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.signInForNewsletter();
    }

    @And("User saves information with password: {string}")
    public void userSavesInformationWithPassword(String password) {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.inputPassword(password);
        userInfoPage.saveData();
    }

    @Then("User sees {string}")
    public void userSeesSuccessMessage(String expectedMessage) {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        String actualMessage = userInfoPage.getUpdateInformation();

        Assertions.assertEquals(expectedMessage, actualMessage);

        driver.quit();
    }
}
