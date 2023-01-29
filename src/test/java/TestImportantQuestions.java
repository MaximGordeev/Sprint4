import POM.MainPage;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class TestImportantQuestions {
   private WebDriver driver;

   //кнопка использования Cookie
   private final static By COOKIE_BUTTON = By.xpath("//button[@id='rcc-confirm-button']");
   //url сайта
   private final static String SITE_URL = "https://qa-scooter.praktikum-services.ru/";
   //ожидаемые данные при раскрытии AccordionItems
   private final static String[] EXPECTED_TEXTS = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                                                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                                                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                                                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                                                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                                                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                                                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                                                "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

   @Before
   public void beforeSteps(){
      System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get(SITE_URL);
      driver.findElement(COOKIE_BUTTON).click();
   }

   @Test
   public void testAnswersInImportantQuestions(){
      MainPage objMainPage = new MainPage(driver);
      objMainPage.scrollToElement();
      Assert.assertArrayEquals(EXPECTED_TEXTS, objMainPage.clickAllDifferentQuestionsAndReturnThem());

   }
   @After
   public void tearDown(){
      driver.quit();
   }
}
