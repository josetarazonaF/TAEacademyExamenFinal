package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public WebElement getUserButton() {
        return userButton;
    }
}
