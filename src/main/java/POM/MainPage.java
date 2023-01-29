package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class MainPage {


    //кнопка "Заказать" из шапки сайта
    private final static By HEADER_ORDER_BUTTON = By.xpath("//button[@class ='Button_Button__ra12g']");
    //кнопка "Заказать" расположенная в середине сайта
    private final static By MIDDLE_ORDER_BUTTON = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    //текст заголовка раздела "Вопросы о главном"
    private final static By HEADER_TEXT_IMPORTANT_QUESTIONS = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");
    //элементы выпадающих списков в графе "Вопросы о важном"
    private final static By IMPORTANT_QUESTIONS = By.xpath("//div[@class = 'accordion__item']");
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public By getHeaderOrderButton(){
        return this.HEADER_ORDER_BUTTON;
    }
    public By getMiddleOrderButton(){
        return this.MIDDLE_ORDER_BUTTON;
    }



    public void scrollToElement(){
        WebElement element = driver.findElement(HEADER_TEXT_IMPORTANT_QUESTIONS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public String[] clickAllDifferentQuestionsAndReturnThem(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(IMPORTANT_QUESTIONS)));
        List<WebElement> elements = driver.findElements(IMPORTANT_QUESTIONS);
        Iterator<WebElement> i = elements.iterator();
        int k = 0;
        String[] actualText = new String[elements.size()];
        while(i.hasNext()) {
            i.next().click();
            String idAccordion = "accordion__panel-" + k;
            actualText[k] = driver.findElement(By.id(idAccordion)).getText();
            //Assert.assertEquals(EXPECTED_TEXTS[k],actualText[k]);
            k++;
        }
        return actualText;
    }
    public void clickOnOrderButton(By orderButton){
        driver.findElement(orderButton).click();
    }



}
