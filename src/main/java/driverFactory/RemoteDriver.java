package driverFactory;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver {


    private static MutableCapabilities getCapability(String browser) {
        MutableCapabilities mutableCapabilities;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());

        switch (driverManagerType) {

            case CHROME:
                mutableCapabilities = defaultChromeOptions();
                break;
            case FIREFOX:
                mutableCapabilities = new FirefoxOptions();
                break;
            case OPERA:
                mutableCapabilities = new OperaOptions();
                break;
            case EDGE:
                mutableCapabilities = new EdgeOptions();
                break;
            case IEXPLORER:
                mutableCapabilities = new InternetExplorerOptions();
                break;
            case SAFARI:
                mutableCapabilities = new SafariOptions();
                break;
            default:
                throw new RuntimeException(driverManagerType.toString());
        }

        return mutableCapabilities;
    }

    private static MutableCapabilities defaultChromeOptions() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");

        return capabilities;
    }

    public WebDriver getDriver(String browserName) {
        RemoteWebDriver remoteWebDriver = null;

        try {
            // a composition of the target grid address and port
            String gridURL = String.format("http://%s:%s/wd/hub", "localhost", "4444");
            MutableCapabilities cap = getCapability(browserName);
            cap.setCapability("version", "96.0.4664.45");
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), cap);
        } catch (MalformedURLException e) {
        } catch (IllegalArgumentException e) {
        }

        return remoteWebDriver;

    }

}
