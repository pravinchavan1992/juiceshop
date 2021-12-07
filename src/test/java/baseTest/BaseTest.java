package baseTest;

import driverFactory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.ReadPropertyFile;


public class BaseTest {
    public BaseTest() {
    }

    @BeforeMethod
    public void initializeTest() {
        WebDriver driver = Driver.getDriver(ReadPropertyFile.getProperty("browser"));
        driver.get(ReadPropertyFile.getProperty("url"));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        Driver.quiteDriver();
    }
}
