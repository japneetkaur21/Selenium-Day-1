package Scripts_Day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Question_5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.londonfreelance.org/courses/frames/index.html");

        //Part 1
        System.out.println("Total number of frames are: ");
        System.out.println(driver.findElements(By.xpath("//frame")).size());

        //Part 2
        String match="Acid-free paper for the digital age";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//a[text()='Sample content']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("content");
        String actual=driver.findElement(By.xpath("//h2")).getText();
        if(match.equals(actual)){
            System.out.println("The header is correct ");
        }

        driver.close();
    }
}