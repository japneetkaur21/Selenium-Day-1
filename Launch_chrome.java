package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch_chrome {
    public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "Folder_1/chromedriver");
    WebDriver driver= new ChromeDriver();
    driver.get("http://www.tothenew.com/");

}
}