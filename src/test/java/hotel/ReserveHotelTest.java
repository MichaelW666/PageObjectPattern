package hotel;

import common.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.hotel.AuthenticationPage;
import pages.hotel.RegistrationInfoPage;
import pages.hotel.RoomsPage;
import pages.hotel.sections.HeaderSection;
import pages.hotel.sections.SearchBar;

public class ReserveHotelTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Utils.setUpDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void registerNewUser() {
        // arrange
        String email = "johndoe@mail.com";
        String password = "qwerty";
        String hotelLocation = "Cracow";
        String hotelName = "The Hotel Prime";
        String checkInDate = "18-10-2021";
        String checkOutDate = "24-10-2021";
        String roomName = "General Rooms";
        String roomQuantity = "2";

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        HeaderSection headerSection = new HeaderSection(driver);
        SearchBar searchBar = new SearchBar(driver);
        RoomsPage roomsPage = new RoomsPage(driver);

        // act
        headerSection.goToAuthentication();
        authenticationPage.loginAs(email, password);
        headerSection.clickLogo();
        searchBar.searchHotel(hotelLocation, hotelName, checkInDate, checkOutDate);
        roomsPage.bookRoom(roomName, roomQuantity);

        // assert
        // zrobic asercje sprawdzajace poprawnosc koszyka
    }
}
