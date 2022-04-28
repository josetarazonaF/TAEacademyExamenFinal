package com.globant.pages;

import com.globant.data.ProfileInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(css = "input[name = 'firstName']")
    private WebElement firstNameInput;
    @FindBy(css = "input[name = 'lastName']")
    private WebElement lastNameInput;
    @FindBy(css = "input[name = 'email']")
    private WebElement emailInput;
    @FindBy(css = "input[name = 'newPassword']")
    private WebElement passwordInput;
    @FindBy(css = "button[did-translate = 'create.SIGN_UP']")
    private WebElement SignUpButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void sendProfileInfoSignUpKeys(ProfileInfo profileInfo) {
        sendKeys(firstNameInput, profileInfo.getFirstName());
        sendKeys(lastNameInput, profileInfo.getLastName());
        sendKeys(emailInput, profileInfo.getEmail());
        sendKeys(passwordInput, profileInfo.getPassword());
    }

    public void clickSignUpButton() {
        clickElement(SignUpButton);
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSignUpButton() {
        return SignUpButton;
    }
}
