package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsProfileIframe extends BasePage {

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountTag;

    @FindBy(css = "section[class *= 'workflow-deactivate'] button[ng-click='vm.confirm()']")
    private WebElement confirmDeleteAccountButton;

    public SettingsProfileIframe(WebDriver driver) {
        super(driver);
    }

    public WebElement getDeleteAccountTag() {
        return deleteAccountTag;
    }

    public void clickDeleteAccountTag() {

        try {
            clickElement(deleteAccountTag);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            clickElement(deleteAccountTag);
        }

    }

    public void clickConfirmDeleteAccountButton() {

        try {
            clickElement(confirmDeleteAccountButton);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            clickElement(confirmDeleteAccountButton);
        }
        clickElement(confirmDeleteAccountButton);

    }

    public WebElement getConfirmDeleteAccountButton() {
        return confirmDeleteAccountButton;
    }
}

