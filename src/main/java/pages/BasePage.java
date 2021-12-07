package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;

public class BasePage {
    public WebDriver driver;
    Predicate<WebElement> isElementLocated = WebElement::isDisplayed;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public WebElement findElement(By by) {
        await().atMost(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .ignoreExceptions()
                .until(() -> isElementLocated.test(driver.findElement(by)));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        await().atMost(ofSeconds(20))
                .pollInterval(ofSeconds(1))
                .until(() -> driver.findElement(by).isDisplayed());
        return driver.findElements(by);
    }

    public void enterText(By by, String text) {
        WebElement element = findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By by) {
        WebElement element = findElement(by);
        element.click();
    }

    public void select(By dropdownLocator, By dropdownValueLocator, String value) {
        click(dropdownLocator);
        WebElement webelement = findElements(dropdownValueLocator).stream().filter(x -> x.getText().trim().equals(value)).collect(Collectors.toList()).get(0);
        webelement.click();
    }

}
