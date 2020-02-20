package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

// JUNIT, NUNIT
public class WithTestNG {
    // Design Pattern (Page Object Model)
    WebDriver driver;

    @BeforeTest
    public void start() {
        System.out.println("Basliyor");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.testandquiz.com/selenium/testing.html");
    }

    @Test
    public void testLogin() throws InterruptedException {
        WebElement link = driver.findElement(By.cssSelector("a[href='https://www.javatpoint.com/']"));
        link.click();
        Thread.sleep(3000);
        String title = driver.getTitle();

        Assert.assertEquals(title, "Tutorials List - Javatpoint");
    }

    @Test
    public void testDoubleClick() throws InterruptedException {
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.id("dblClkBtn"))).perform();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
    }

    @AfterTest
    public void end() {
        System.out.println("Bitiyor");
        driver.quit();
    }
}
