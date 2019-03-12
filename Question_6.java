package Scripts_Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Question_6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
driver.findElement(By.xpath("//button[text()='New Browser Tab']")).click();

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> itr = handle.iterator();
        String parent= itr.next();
        System.out.println(driver.getCurrentUrl());
        String child= itr.next();
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().window(child);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//span[text()='Blogs']")).click();
    }
}