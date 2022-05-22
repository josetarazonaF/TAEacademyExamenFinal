package com.globant.pages;

import com.globant.data.ProfileInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(id = "InputFirstName")
    private WebElement firstNameInput;
    @FindBy(id = "InputLastName")
    private WebElement lastNameInput;
    @FindBy(id = "InputEmail")
    private WebElement emailInput;
    @FindBy(id = "password-new")
    private WebElement passwordInput;
    @FindBy(id = "BtnSubmit")
    private WebElement SignUpButton;
    @FindBy(css = "h2[data-testid='Title']")
    private WebElement signUpTitle;
    @FindBy(css = "button[data-testid='REGISTRATION-close']")
    private WebElement closeXButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void sendProfileInfoSignUpKeys(ProfileInfo profileInfo) {
        sendKeys(firstNameInput, profileInfo.getFirstName());
        sendKeys(lastNameInput, profileInfo.getLastName());
        sendKeys(emailInput, profileInfo.getEmail());
        sendKeys(passwordInput, profileInfo.getPassword());
    }

    public HomePage goToHomepageSignedUp() {
        clickElement(SignUpButton);
        switchDefaultContent();
        return new HomePage(getDriver());
    }

    public boolean isSignUpTitleDisplayed() {
        return signUpTitle.isDisplayed();
    }

    public boolean isFirstNameInputDisplayed() {
        return firstNameInput.isDisplayed();
    }

    public boolean isLastNameInputDisplayed() {
        return lastNameInput.isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isDisplayed();
    }

    public boolean isSignUpButtonDisplayed() {
        return SignUpButton.isDisplayed();
    }

    public boolean isCloseXButtonDisplayed() {
        return closeXButton.isDisplayed();
    }


}
