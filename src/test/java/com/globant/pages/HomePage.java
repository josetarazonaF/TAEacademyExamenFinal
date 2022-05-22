package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    Actions action = new Actions(getDriver());

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;
    @FindBy(css = "ul.tools ul.account-management a[tref *='login']")
    private WebElement loginButton;
    @FindBy(css = "a[onclick *= 'logout()']")
    private WebElement logoutButton;
    @FindBy(css = "li[class= 'pillar watch']")
    private WebElement watchButton;
    @FindBy(css = "li.display-user")
    private WebElement usernameLabel;


    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WatchPage goToWatchPage() {
        clickElement(watchButton);
        return new WatchPage(getDriver());
    }

    public void clickUserButton() {
        try {
            clickElement(userButton);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            this.userButton = getDriver().findElement(By.id("global-user-trigger"));
            clickElement(userButton);
        }
    }

    public LogInPage goToLoginPage() {
        clickElement(loginButton);
        getDriver().switchTo().frame("oneid-iframe");
        return new LogInPage(getDriver());
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    public boolean isLoginButtonDisplayed() {
        waitElementVisibility(loginButton);
        return loginButton.isDisplayed();
    }

    public boolean validateUsernameNavText(String username) {
        String defaultText = String.format("Welcome %s!", username);
        return defaultText.equalsIgnoreCase(usernameLabel.getText());
    }


    public boolean validateNoUsernameLoggedOut() {
        return usernameLabel.getText().equalsIgnoreCase("Welcome!");
    }

    public void performMouseHoverToUserIcon() {
        waitElementVisibility(userButton);
        waitElementClickable(userButton);
        action.moveToElement(userButton).perform();
    }

}
