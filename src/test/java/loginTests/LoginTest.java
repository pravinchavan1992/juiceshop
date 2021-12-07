package loginTests;

import baseTest.BaseTest;
import driverFactory.Driver;
import modal.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utility.Random;
import utility.ReadPropertyFile;


public class LoginTest extends BaseTest {
    String pass = ReadPropertyFile.getProperty("pass");

    @Test
    public void RegisterNewUser() {
        HomePage homePage = new HomePage();
        String uname = Random.getRandomEmail();
        ReadPropertyFile.setProperty("uname", uname);
        Customer customerData = new Customer.CustomerBuilder().setEmail(uname).setPassword(pass).setSecurityQuestion("Mother's maiden name?").setAns("test").build();
        homePage.checkBanner().navigateToLoginPage().navigateToRegisterNewUserPage().registerNewCustomer(customerData);
        Assert.assertEquals(ReadPropertyFile.getProperty("url") + "/#/login", Driver.getDriver().getCurrentUrl());
    }

    @Test(dependsOnMethods = "RegisterNewUser")
    public void LoginToJuiceAppUsingValidCredentials() {
        HomePage homePage = new HomePage();
        String uname = ReadPropertyFile.getProperty("uname");
        homePage.checkBanner().navigateToLoginPage().loginWithValidCredentials(uname, pass).isUserLoggedIn(uname);
    }

    @Test
    public void LoginToJuiceAppUsingInValidCredentials() {
        HomePage homePage = new HomePage();
        String uname = ReadPropertyFile.getProperty("uname");
        String errorText = homePage.checkBanner().navigateToLoginPage().loginWithInValidCredentials(uname, pass + "123");
        Assert.assertEquals(errorText, "Invalid email or password.");
    }

}
