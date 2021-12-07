package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public static By banner = By.id("mat-dialog-0");
    public static By closeBanner = By.cssSelector("button[aria-label='Close Welcome Banner']");
    public static By accountButton = By.id("navbarAccount");
    public static By loginButton = By.id("navbarLoginButton");
    public static By logoutButton = By.id("navbarLogoutButton");
    public static By loggedInUserName = By.xpath("//button[@id='navbarLogoutButton']//preceding-sibling::button[last()]//span");
    public HomePage() {
        super();
    }

    public HomePage checkBanner() {
        skipBannerIfPresent();
        return this;
    }

    public LoginPage navigateToLoginPage() {
        findElement(accountButton).click();
        findElement(loginButton).click();
        return new LoginPage();
    }

    public boolean checkIsBannerDisplayed() {
        return findElement(closeBanner).isDisplayed();
    }

    public HomePage skipBannerIfPresent() {
        if (checkIsBannerDisplayed()) {
            findElement(closeBanner).click();
        }
        return this;
    }

    public boolean isUserLoggedIn(String userName) {
        click(accountButton);
        boolean logoutButtonDisplayed = findElement(logoutButton).isDisplayed();
        boolean loggedInUserNameDisplayed = findElement(loggedInUserName).getText().trim().equals(userName);
        return logoutButtonDisplayed && loggedInUserNameDisplayed;
    }

    public HomePage logOut() {
        click(HomePage.accountButton);
        click(logoutButton);
        return new HomePage();
    }
}
