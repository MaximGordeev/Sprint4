package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderDataPage {

    private final static By ORDER_DATA_DELIVERY = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final static By RENTAL_PERIOD = By.xpath("//div[@class= 'Dropdown-placeholder']");
    private final static By RENTAL_PERIOD_OPTION = By.xpath("//div[@class = 'Dropdown-option']");
    private final static By SCOOTER_COLOUR = By.xpath("//input[@id = 'grey']");
    private final static By COMMENT_FOR_COURIER = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    private final static By ORDER_BUTTON = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final static By CONMFIRM_ORDER = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final static By CHECK_ORDER = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private final WebDriver driver;
    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryDate(String deliveryDate) {
        driver.findElement(ORDER_DATA_DELIVERY).sendKeys(deliveryDate);
        driver.findElement(ORDER_DATA_DELIVERY).sendKeys(Keys.RETURN);
    }
    public void enterRentalPeriod(int rentDays) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(RENTAL_PERIOD)));
        driver.findElement(RENTAL_PERIOD).click();
        List<WebElement> orderDuration = driver.findElements(RENTAL_PERIOD_OPTION);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElements(orderDuration));
        orderDuration.get(rentDays).click();
    }
    public void enterScooterColour() {
        driver.findElement(SCOOTER_COLOUR).click();
    }
    public void enterCourierComment(String courierComment) {
        driver.findElement(COMMENT_FOR_COURIER).sendKeys(courierComment);
    }
    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }
    public void clickConfirmButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(CONMFIRM_ORDER)));
        driver.findElement(CONMFIRM_ORDER).click();
    }
    public boolean isOrderConmfirmed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(CHECK_ORDER)));
        boolean actualResult = driver.findElement(CHECK_ORDER).isDisplayed();
        return actualResult;
    }
    public void enterOrderData(String deliveryDate, int rentDays, String courierComment) {
        enterDeliveryDate(deliveryDate);
        enterRentalPeriod(rentDays);
        enterScooterColour();
        enterCourierComment(courierComment);
        clickOrderButton();
        clickConfirmButton();
    }
}
