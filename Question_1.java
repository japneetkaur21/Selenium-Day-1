package Scripts_Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String str = "Quality Assurance Engineer";

            List<WebElement> l1 = driver.findElements(By.xpath("//h2[text()='HTML Table with no id']/following-sibling::table//tbody//tr"));
        for (int i = 2; i <= l1.size(); i++) {

            List<WebElement> l2 = driver.findElements(By.xpath("//h2[text()='HTML Table with no id']/following-sibling::table//tbody//tr[" + i + "]//td"));
            if (l2.get(0).getText().equals(str)) {
                System.out.println("Salary of  "+l2.get(0).getText()+ " is "+l2.get(2).getText());
            }
        }
        driver.close();
    }
    }
