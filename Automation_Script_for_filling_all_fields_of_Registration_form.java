package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Script_for_filling_all_fields_of_Registration_form {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ttn/Downloads/Registration.html");
        driver.findElement(By.xpath("//*[@ng-model='FirstName']")).sendKeys("Japneet");
        driver.findElement(By.xpath("//*[@ng-model='LastName']")).sendKeys("Kaur");
        driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("11,Golf Road");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("japneettkaur@abc.com");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("1000110001");
driver.findElements(By.name("radiooptions")).get(1).click();
driver.findElement(By.id("checkbox1")).click();
driver.findElement(By.id("checkbox2")).click();
        driver.findElement(By.id("firstpassword")).sendKeys("password1");
        driver.findElement(By.id("secondpassword")).sendKeys("password2");


        System.out.println(driver.findElement(By.id("Button1")).isEnabled());
        System.out.println(driver.findElements(By.name("radiooptions")).get(1).isSelected());
        System.out.println(driver.getTitle());
        
    }
}
