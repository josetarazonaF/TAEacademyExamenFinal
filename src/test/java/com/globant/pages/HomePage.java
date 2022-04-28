package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;
    @FindBy(css = "ul.tools ul.account-management a[tref *='login']")
    private WebElement loginButton;
    @FindBy(css = "a[onclick *= 'logout()']")
    private WebElement logoutButton;
    @FindBy(css = "a[tref *= 'modifyAccount']")
    private WebElement settingsProfileButton;


    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public LoginIframe switchLoginIframe() {
        getDriver().switchTo().frame("disneyid-iframe");
        return new LoginIframe(getDriver());
    }

    public SettingsProfileIframe clickSettingsProfileButton() {
        clickElement(settingsProfileButton);
        getDriver().switchTo().frame("disneyid-iframe");
        return new SettingsProfileIframe(getDriver());
    }

    public void clickUserButton() {
        try {
            clickElement(userButton);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            this.userButton = getDriver().findElement(By.id("global-user-trigger"));
            clickElement(userButton);
        }
    }

    public LoginIframe clickLoginButton() {
        clickElement(loginButton);
        this.switchLoginIframe();
        return new LoginIframe(getDriver());
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }


    public boolean isLoginButtonDisplayed() {
        waitElementVisibility(loginButton);
        return loginButton.isDisplayed();
    }

    public boolean isSettingsProfileButtonDisplayed() {
        waitElementVisibility(settingsProfileButton);
        return settingsProfileButton.isDisplayed();
    }

    public WebElement getUserButton() {
        return userButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSettingsProfileButton() {
        return settingsProfileButton;
    }
}
