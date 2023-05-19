import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class FirstTest {

    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By sum = By.xpath("//input[@data-qa-node='amount']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submitButton = By.xpath("//button[@data-qa-node='submit']");
    By details = By.xpath("//div[@data-qa-node='details']");
    By amount = By.xpath("//div[@data-qa-node='amount']");
    By receiver = By.xpath("//span[@data-qa-node='nameB']");
    By commission = By.xpath("//span[@data-qa-node='commission']");
    By commissionCurrency = By.xpath("//span[@data-qa-node='commission-currency']");

    @Test
  public void checkPaymentData(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://next.privat24.ua/mobile");
        driver.findElement(phoneNumber).sendKeys("988902023");
        driver.findElement(sum).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        driver.findElement(sum).sendKeys("150");
        driver.findElement(cardNumber).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("0525");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(firstName).sendKeys("Stepan");
        driver.findElement(lastName).sendKeys("Bandera");
        driver.findElement(submitButton).click();

        Assertions.assertAll(
             () -> Assertions.assertEquals("Поповнення телефону. На номер +380988902023", driver.findElement(details).getText()),
             () -> Assertions.assertEquals("150 UAH", driver.findElement(amount).getText()),
             () -> Assertions.assertEquals("Kyivstar Ukraine", driver.findElement(receiver).getText()),
             () -> Assertions.assertEquals(" UAH", driver.findElement(commissionCurrency).getText()),
             () -> Assertions.assertEquals("4", driver.findElement(commission).getText())
        );
        driver.close();
    }
}
