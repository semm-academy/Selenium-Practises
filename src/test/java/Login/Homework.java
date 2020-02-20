package Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class Homework {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testandquiz.com/selenium/testing.html");

        try {
            WebElement link = driver.findElement(By.cssSelector("a[href='https://www.javatpoint.com/']"));
            link.click();
            Thread.sleep(3000);
            driver.navigate().back();

            //login
            Thread.sleep(2000);
            WebElement fname = driver.findElement(By.id("fname"));
            fname.sendKeys("Yasemin");
            Thread.sleep(2000);

            WebElement submitButton = driver.findElement(By.id("idOfButton"));
            submitButton.click();
            Thread.sleep(2000);

           //RADIO BUTTON
            WebElement radioButton = (driver.findElement(By.xpath("//*[@id='male']")));
            radioButton.click();

            Thread.sleep(3000);
             //CHECKBOX
            List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
            checkBoxes.get(0).click();
            checkBoxes.get(1).click();
            Thread.sleep(3000);

            Select itemsInDropdown = new Select(driver.findElement(By.id("testingDropdown")));
            System.out.println(itemsInDropdown.getOptions());
            itemsInDropdown.selectByVisibleText("Manual Testing");

            Thread.sleep(3000);

            Actions action = new Actions(driver);
            action.doubleClick(driver.findElement(By.id("dblClkBtn"))).perform();
            Thread.sleep(1000);
            driver.switchTo().alert().dismiss();

            //WebElement DoubleClickButton = driver.findElement(By.id("dblClkBtn"));
            //DoubleClickButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}



























