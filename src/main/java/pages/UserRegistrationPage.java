package pages;

import driverFactory.Driver;
import modal.Customer;
import org.openqa.selenium.By;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

public class UserRegistrationPage extends BasePage {
    public static By emailIdTextField = By.id("emailControl");
    public static By passwordTextField = By.id("passwordControl");
    public static By repeatPasswordField = By.id("repeatPasswordControl");
    public static By securityQuestionsDropDown = By.id("mat-select-2");
    public static By securityQuestions = By.xpath("//*[starts-with(@id,'mat-option-')]//span");
    public static By securityAnswer = By.id("securityAnswerControl");
    public static By registerButton = By.id("registerButton");
    public UserRegistrationPage() {
        super();
    }

    public void registerNewCustomer(Customer customer) {
        enterText(emailIdTextField, customer.getEmail());
        enterText(passwordTextField, customer.getPassword());
        enterText(repeatPasswordField, customer.getRepeatPassword());
        select(securityQuestionsDropDown, securityQuestions, customer.getSecurityQuestion());
        enterText(securityAnswer, customer.getAns());
        click(registerButton);
        await().atMost(ofSeconds(3)).pollInterval(ofSeconds(1))
                .until(() -> Driver.getDriver().getCurrentUrl().endsWith("login"));
    }

}
