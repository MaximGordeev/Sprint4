package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage {
    //локатор для поля Имя
    private final static By NAME = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля Фамилия
    private final static By SURNAME = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для адреса доставки
    private final static By ADDRESS = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля станции метро
    private final static By METRO = By.xpath("//input[@placeholder='* Станция метро']");
    //локатор для первого элемента в списке станций метро
    private final static By FIRST_SEARCH_ELEMENT = By.xpath("//div[@class='select-search__select']");
    //локатор для поля номер телефона
    private final static By TELEPHONE = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор для кнопки Далее
    private final static By NEXT_BUTTON = By.xpath("//button[text() = 'Далее']");

    private final WebDriver driver;
    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(NAME).sendKeys(name);
    }
    public void enterSurname(String surname) {
        driver.findElement(SURNAME).sendKeys(surname);
    }
    public void enterAddress(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }
    public void enterMetroStation(String metroStationPattern) {
        driver.findElement(METRO).sendKeys(metroStationPattern);
        driver.findElement(FIRST_SEARCH_ELEMENT).click();
    }
    public void enterTelephone(String telephoneNumber) {
        driver.findElement(TELEPHONE).sendKeys(telephoneNumber);
    }
    public void clickOnNextButton(){
        driver.findElement(NEXT_BUTTON).click();
    }
    public void enterPersonalData(String name, String surname, String address, String metroStationPattern, String telephoneNumber){
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetroStation(metroStationPattern);
        enterTelephone(telephoneNumber);
        clickOnNextButton();
    }


}
