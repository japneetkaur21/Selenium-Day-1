package Scripts_Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Question_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement testdropdown = driver.findElement(By.id("multi-select"));
        Select dropdown = new Select(testdropdown);

        //Part 1
        System.out.println(dropdown.isMultiple());

        //Part 2
        List<WebElement> dl = dropdown.getOptions();
        for (int i = 0; i < dl.size(); i++) {
            System.out.println(dl.get(i).getText());
        }

        //Part 3
        dropdown.selectByValue("New Jersey");
        dropdown.selectByValue("New York");
        dropdown.selectByValue("Texas");
        System.out.println("First Selected option is: ");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        System.out.println("All selected options are: ");
        List<WebElement> dl1 = dropdown.getAllSelectedOptions();
        for (int i = 0; i < dl1.size(); i++) {
            System.out.println(dl1.get(i).getText());
        }

        //Part 4
        dropdown.deselectAll();

       
    }
}