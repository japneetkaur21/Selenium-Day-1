package LiveProject_Automation_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Login_and_Book_Flight {
    @Test(dependsOnMethods ={"SuccessfulRegistration"})
    public void Login_and_Book_Flight() throws IOException {

        System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercurysignon.php");

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);

        String type = properties.getProperty("FlightType");
        type = type.replace(" ","").toLowerCase();
        driver.findElement(By.xpath("//input[@value='"+type+"']")).click();


    }


}
