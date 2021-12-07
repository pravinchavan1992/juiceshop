package driverFactory;

import org.openqa.selenium.WebDriver;
import utility.ReadPropertyFile;

import java.util.Objects;
import java.util.Optional;

public class Driver {
    private static WebDriver driver;

    public Driver() {

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver getDriver(String browserName) {
        String target = Optional.of(System.getProperty("target")).orElse(ReadPropertyFile.getProperty("target"));
        switch (target.toUpperCase()) {
            case "LOCAL":
                driver = new LocalDriver().getDriver(browserName);
                break;

            case "REMOTE":
                driver = new RemoteDriver().getDriver(browserName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }

        return driver;

    }

    public static void quiteDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
        }
    }
}
