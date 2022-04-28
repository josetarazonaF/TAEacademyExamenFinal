package com.globant.pages;

import com.globant.data.ProfileInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIframe extends BasePage {


    @FindBy(css = "input[placeholder ='Username or Email Address']")
    private WebElement emailInput;
    @FindBy(css = "input[placeholder= 'Password (case sensitive)']")
    private WebElement passwordInput;
    @FindBy(css = "button[did-translate= 'login.label.SIGNIN']")
    private WebElement loginButton;
    @FindBy(css = "a[did-translate= 'login.label.CREATE_ACCOUNT']")
    private WebElement signUpButton;


    public LoginIframe(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public SignUpPage clickSignUpButton() {
        clickElement(this.signUpButton);
        return new SignUpPage(getDriver());
    }

    public void sendProfileInfoLoginKeys(ProfileInfo profileInfo) {
        sendKeys(emailInput, profileInfo.getEmail());
        sendKeys(passwordInput, profileInfo.getPassword());
    }

    public void switchDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }


}
