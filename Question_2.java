package Scripts_Day_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Question_2 {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Selenium_day_1/src/Scripts_Day_3/Register.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);


        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ttn/Downloads/Registration.html");
        driver.findElement(By.xpath("//*[@ng-model='FirstName']")).sendKeys(properties.getProperty("Fname"));
        driver.findElement(By.xpath("//*[@ng-model='LastName']")).sendKeys(properties.getProperty("Lname"));
        driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys(properties.getProperty("Address"));
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys(properties.getProperty("EmailId"));
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys(properties.getProperty("ContactNo"));

        List<WebElement> radioList = driver.findElements(By.name("radiooptions"));
        for (int i= 0; i<radioList.size(); i++){
            if (radioList.get(i).getAttribute("value").equals(properties.getProperty("Gender"))){
                driver.findElements(By.name("radiooptions")).get(i).click();
            }
        }

        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int j=0; j<checkboxList.size(); j++){
            if (checkboxList.get(j).getAttribute("value").equals(properties.getProperty("Ch1"))){
                driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).click();
            }
            if (checkboxList.get(j).getAttribute("value").equals(properties.getProperty("Ch2"))) {
                driver.findElements(By.xpath("//input[@type='checkbox']")).get(j).click();
            }
        }

        driver.findElement(By.id("firstpassword")).sendKeys(properties.getProperty("passw1"));
        driver.findElement(By.id("secondpassword")).sendKeys(properties.getProperty("passw2"));


    }
}