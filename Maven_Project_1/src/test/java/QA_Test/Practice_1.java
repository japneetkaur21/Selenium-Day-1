package QA_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Practice_1 {

    @Test
    public void abc(){
        System.out.println("Some text");
        String a= "B";
        String b= "A";
        Assert.assertEquals(a, b);
    }

    @Test(description= "Test First" , priority = 2)
    public void firstM()
    {
        System.out.println("First Method");
    }

    @Test(description = "Test Third")
    public void thirdM()
    {
        System.out.println("Third Method");
    }

    @Test(description = "Test Second" , priority = 1)
    public void secondM()
    {
        System.out.println("Second Method");
    }


//    public static void main(String[] args) throws IOException {
//
//        Properties properties = new Properties();
//        File f = new File("/home/ttn/IdeaProjects/Maven_Project_1/src/test/java/QA_Test/prop.properties");
//        FileInputStream fip = new FileInputStream(f);
//        properties.load(fip);
//        System.out.println(properties.getProperty("Fname") + " " + properties.getProperty("Lname"));
//

    }
