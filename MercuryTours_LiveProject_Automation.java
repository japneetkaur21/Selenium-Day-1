package LiveProject_Automation_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MercuryTours_LiveProject_Automation {

    WebDriver driver;


    @BeforeSuite
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Maven_Project_1/Folder_1/chromedriver");
        driver = new ChromeDriver();
    }


    @BeforeClass
    public void SuccessfulRegistration() throws IOException {
        driver.get("http://newtours.demoaut.com/mercurysignon.php");

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);


        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
        driver.findElement(By.name("firstName")).sendKeys(properties.getProperty("Fname"));
        driver.findElement(By.name("lastName")).sendKeys(properties.getProperty("Lname"));
        driver.findElement(By.name("phone")).sendKeys(properties.getProperty("phone"));
        driver.findElement(By.id("userName")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.name("address1")).sendKeys(properties.getProperty("address1"));
        driver.findElement(By.name("address2")).sendKeys(properties.getProperty("address2"));
        driver.findElement(By.name("city")).sendKeys(properties.getProperty("city"));
        driver.findElement(By.name("state")).sendKeys(properties.getProperty("state"));
        driver.findElement(By.name("postalCode")).sendKeys(properties.getProperty("postalCode"));

        WebElement registerdropdown = driver.findElement(By.name("country"));
        Select dropdown = new Select(registerdropdown);
        dropdown.selectByVisibleText(properties.getProperty("country"));

        driver.findElement(By.name("email")).sendKeys(properties.getProperty("username"));
        driver.findElement(By.name("password")).sendKeys(properties.getProperty("passw"));
        driver.findElement(By.name("confirmPassword")).sendKeys(properties.getProperty("cpassw"));

        driver.findElement(By.xpath("//input[@src='/images/forms/submit.gif']")).click();

        String expected = "Dear " + properties.getProperty("Fname") + " " + properties.getProperty("Lname") + ",";
        String actual = driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals(expected, actual);


    }

    @BeforeMethod
    public void Login() throws IOException {
        driver.get("http://newtours.demoaut.com/mercurysignon.php");

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);


        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(properties.getProperty("username"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("passw"));
        driver.findElement(By.xpath("//input[@name='login']")).click();
        String actual = driver.getCurrentUrl();
        System.out.println(actual);
        String expected = "http://newtours.demoaut.com/mercuryreservation.php";
        Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void BookFlight() throws IOException {

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);
        String type = properties.getProperty("FlightType");
        type = type.replace(" ", "").toLowerCase();
        driver.findElement(By.xpath("//input[@value='" + type + "']")).click();


        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passCount);
        passenger.selectByVisibleText(properties.getProperty("Passengers"));

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingCity = new Select(fromPort);
        departingCity.selectByVisibleText(properties.getProperty("DepartingCity"));

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonth = new Select(fromMonth);
        onMonth.selectByVisibleText(properties.getProperty("OnMonth"));

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDay = new Select(fromDay);
        onDay.selectByVisibleText(properties.getProperty("OnDate"));

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(toPort);
        arrivalCity.selectByVisibleText(properties.getProperty("ArrivalCity"));

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnMonth = new Select(toMonth);
        returnMonth.selectByVisibleText(properties.getProperty("ReturnMonth"));

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returnDate = new Select(toDay);
        returnDate.selectByVisibleText(properties.getProperty("ReturnDate"));

        driver.findElement(By.xpath("//input[@value='" + properties.getProperty("Class") + "']")).click();

        driver.findElement(By.xpath("//input[@name='findFlights']")).click();


        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys(properties.getProperty("Fname"));
        driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys(properties.getProperty("Lname"));

        WebElement meal = driver.findElement(By.xpath("//select[@name='pass.0.meal']"));
        Select mealPrefer = new Select(meal);
        mealPrefer.selectByVisibleText(properties.getProperty("Meal"));


        WebElement creditCard = driver.findElement(By.xpath("//select[@name='creditCard']"));
        Select card = new Select(creditCard);
        card.selectByVisibleText(properties.getProperty("Card"));

        driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys(properties.getProperty("CreditNumber"));

        WebElement expiryDate = driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']"));
        Select expiryD = new Select(expiryDate);
        expiryD.selectByVisibleText(properties.getProperty("ExpiryDate"));

        WebElement expiryYear = driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']"));
        Select expiryY = new Select(expiryYear);
        expiryY.selectByVisibleText(properties.getProperty("ExpiryYear"));

        driver.findElement(By.xpath("//input[@name='cc_frst_name']")).sendKeys(properties.getProperty("Fname"));
        driver.findElement(By.xpath("//input[@name='cc_last_name']")).sendKeys(properties.getProperty("Lname"));
        driver.findElement(By.xpath("//input[@name='billAddress1']")).sendKeys(properties.getProperty("address1"));
        driver.findElement(By.xpath("//input[@name='billCity']")).sendKeys(properties.getProperty("city"));
        driver.findElement(By.xpath("//input[@name='billState']")).sendKeys(properties.getProperty("state"));
        driver.findElement(By.xpath("//input[@name='billZip']")).sendKeys(properties.getProperty("postalCode"));


        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();

        String actual = driver.findElement(By.xpath("//b")).getText();
        String expected = "Your itinerary has been booked!";
        System.out.println();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Flight_Departure_Arrival_City() throws IOException {

        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);



        String type = properties.getProperty("FlightType");
        type = type.replace(" ", "").toLowerCase();
        driver.findElement(By.xpath("//input[@value='" + type + "']")).click();


        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passCount);
        passenger.selectByVisibleText(properties.getProperty("Passengers"));

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingCity = new Select(fromPort);
        departingCity.selectByVisibleText(properties.getProperty("DepartingCity"));

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonth = new Select(fromMonth);
        onMonth.selectByVisibleText(properties.getProperty("OnMonth"));

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDay = new Select(fromDay);
        onDay.selectByVisibleText(properties.getProperty("OnDate"));

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(toPort);
        arrivalCity.selectByVisibleText(properties.getProperty("DepartingCity"));

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnMonth = new Select(toMonth);
        returnMonth.selectByVisibleText(properties.getProperty("ReturnMonth"));

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returnDate = new Select(toDay);
        returnDate.selectByVisibleText(properties.getProperty("ReturnDate"));

        driver.findElement(By.xpath("//input[@value='" + properties.getProperty("Class") + "']")).click();
        String expected = "http://newtours.demoaut.com/mercuryreservation2.php";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Flight_Arrival_Departure_date() throws IOException {
        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);



        String type = properties.getProperty("FlightType");
        type = type.replace(" ", "").toLowerCase();
        driver.findElement(By.xpath("//input[@value='" + type + "']")).click();


        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passCount);
        passenger.selectByVisibleText(properties.getProperty("Passengers"));

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingCity = new Select(fromPort);
        departingCity.selectByVisibleText(properties.getProperty("DepartingCity"));

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonth = new Select(fromMonth);
        onMonth.selectByVisibleText(properties.getProperty("ReturnMonth"));

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDay = new Select(fromDay);
        onDay.selectByVisibleText(properties.getProperty("OnDate"));

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(toPort);
        arrivalCity.selectByVisibleText(properties.getProperty("ArrivalCity"));

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnMonth = new Select(toMonth);
        returnMonth.selectByVisibleText(properties.getProperty("OnMonth"));

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returnDate = new Select(toDay);
        returnDate.selectByVisibleText(properties.getProperty("ReturnDate"));


        driver.findElement(By.xpath("//input[@value='" + properties.getProperty("Class") + "']")).click();
        String expected = "http://newtours.demoaut.com/mercuryreservation2.php";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void BookFlight_with_empty_passenger_details() throws IOException {
        Properties properties = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/LiveProject_Automation_Scripts/MercuryRegister.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);



        driver.findElement(By.xpath("//input[@name='findFlights']")).click();

        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
        String current_url=driver.getCurrentUrl();
        String current_url2="http://newtours.demoaut.com/mercurypurchase2.php";
        Assert.assertNotEquals(current_url,current_url2);


    }
}

