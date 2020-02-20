import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// WebDriver --> RemoteWebDriver --> ChromeDriver

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://blogger.life");

        try {
            Thread.sleep(2000);
            WebElement girisBtn = driver.findElement(By.cssSelector("a[href='/accounts/login/']"));
            girisBtn.click();
            Thread.sleep(2000);
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys("mucahitaktepe@gmail.com");

            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("123456");

            WebElement entry = driver.findElement(By.id("btn"));
            entry.click();

            List<WebElement> alert = driver.findElements(By.cssSelector("div.alert-danger"));
            if(alert.size() > 0 )
                System.out.println("test passed");

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
