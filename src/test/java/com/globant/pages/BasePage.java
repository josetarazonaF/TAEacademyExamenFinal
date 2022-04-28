package com.globant.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public Logger log = Logger.getLogger(BasePage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 20);
    }

    public void waitElementVisibility(WebElement webElement) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public void clickElement(WebElement webElement) {
        this.waitElementVisibility(webElement);
        this.waitElementClickable(webElement);
        webElement.click();
    }

    public void waitElementClickable(WebElement webElement) {
        this.wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void sendKeys(WebElement webElement, String keys) {
        this.waitElementVisibility(webElement);
        webElement.sendKeys(keys);
    }

    public void reload(String url) {
        this.driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void switchDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

}
