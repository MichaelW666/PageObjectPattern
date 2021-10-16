package pages.hotel.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {

    private WebDriver driver;

    @FindBy(id = "hotel_location")
    private WebElement hotelLocationInput;

    @FindBy(id = "hotel_cat_name")
    private WebElement hotelNameDropdown;

    @FindBy(id = "check_in_time")
    private WebElement checkInTimeInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutTimeInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchNowButton;

    // zawsze bierze 1szy hotel z listy
//    @FindBy(className = "hotel_name")
//    private WebElement firstHotel;

    public SearchBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchHotel(
            String location,
            String hotelName,
            String checkInDate,
            String checkOutDate
    ) {
        hotelLocationInput.sendKeys(location);
        checkInTimeInput.sendKeys(checkInDate);
        checkOutTimeInput.sendKeys(checkOutDate);
        hotelNameDropdown.click();

//        List<WebElement> hotelsToPick = driver.findElements(By.className("hotel_name"));
//        for (WebElement hotelElement : hotelsToPick) {
//            if (hotelElement.getText().contains(hotelName))
//            {
//                hotelElement.click();
//                break;
//            }
//        }

        WebElement hotelOption = driver.findElement(By.xpath(
           "//*[text()='" + hotelName +"']"
        ));
        hotelOption.click();

        searchNowButton.click();
    }
}
