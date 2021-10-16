package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageBase;

public class RoomsPage extends PageBase {

    public RoomsPage(WebDriver driver) {
        super(driver);
    }

    public void bookRoom(String roomName, String quantity) {
        String roomXpathSelector = "//*[text()='" + roomName + "']/..";
        WebElement roomSection = driver.findElement(By.xpath(roomXpathSelector));

        WebElement quantityInput = roomSection.findElement(By.cssSelector(".cat_quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys(quantity);

        WebElement bookNowButton = roomSection.findElement(By.xpath("//*[text()='Book Now']"));
        bookNowButton.click();
//        String bookNowButtonSelector =
//                roomXpathSelector + "/..//*[text()='Book Now']";
//        WebElement bookNowButton = driver.findElement(By.xpath(bookNowButtonSelector));

        // zamkniecie potwierdzenia i klikniecie w Continue shoppin
        driver.findElement(By.xpath("//*[@title=\"Continue shopping\"]")).click();
    }
}
