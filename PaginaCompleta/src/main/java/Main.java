import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BernyCsti\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("Berny");

        driver.findElement(By.id("radio-button-3")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='4']"));
        driver.findElement(By.id("datepicker")).sendKeys("11/11/2001");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
        // class: alert alert-success
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
        String alertText = alert.getText();
        assertEquals("The form was successfully submitted!",alertText);
    }
}