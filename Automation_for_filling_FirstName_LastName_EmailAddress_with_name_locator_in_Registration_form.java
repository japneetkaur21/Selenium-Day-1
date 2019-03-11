package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Automation_for_filling_FirstName_LastName_EmailAddress_with_name_locator_in_Registration_form {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ttn/Downloads/Registration.html");
List<WebElement> dr=driver.findElements(By.name("Demo"));
dr.get(0).sendKeys("Japneet");
dr.get(1).sendKeys("Kaur");
dr.get(2).sendKeys("japneetkaur@abc.com");

    }
}