package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open_ToTheNew_and_navigate_to_ContactUs_using_XPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/");
        driver.findElement(By.xpath("//*[@id='h-contact-us']")).click();
    }
}