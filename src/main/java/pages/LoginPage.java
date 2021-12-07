package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public static By email = By.id("email");
    public static By password = By.id("password");
    public static By loginButton = By.id("loginButton");
    public static By error = By.className("error");
    public static By newCustomerLink = By.id("newCustomerLink");

    public LoginPage() {
        super();
    }

    private void enterUserNameAndPassword(String uName, String pass) {
        enterText(email, uName);
        enterText(password, pass);
        click(loginButton);
    }

    public HomePage loginWithValidCredentials(String uName, String pass) {
        enterUserNameAndPassword(uName, pass);
        return new HomePage();
    }

    public String loginWithInValidCredentials(String uName, String pass) {
        enterUserNameAndPassword(uName, pass);
        return findElement(error).getText();
    }

    public UserRegistrationPage navigateToRegisterNewUserPage() {
        click(newCustomerLink);
        return new UserRegistrationPage();
    }
}
