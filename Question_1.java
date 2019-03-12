package Scripts_Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Question_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Folder_1/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        //Part 1
        driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Part 2
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //Part 3
        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Japneet");
        driver.switchTo().alert().accept();
    }
}
