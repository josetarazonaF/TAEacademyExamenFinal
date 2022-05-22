package com.globant.pages;

import com.globant.data.ProfileInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {


    @FindBy(css = "input[placeholder ='Username or Email Address']")
    private WebElement emailInput;
    @FindBy(css = "input[placeholder= 'Password (case sensitive)']")
    private WebElement passwordInput;
    @FindBy(id = "BtnSubmit")
    private WebElement logInButton;
    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css = "div[data-testid= 'login-logo']")
    private WebElement logoESPN;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickElement(logInButton);
    }

    public SignUpPage goToSignUpPage() {
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


    public boolean isESPNLogoDisplayed() {
        return logoESPN.isDisplayed();
    }


    public boolean isLoginButtonDisplayed() {
        return logInButton.isDisplayed();
    }


    public boolean isSignUpButtonDisplayed() {
        return signUpButton.isDisplayed();
    }

}
