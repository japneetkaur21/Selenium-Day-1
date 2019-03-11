package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launch_firefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Folder_1/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tothenew.com/");
    }
}