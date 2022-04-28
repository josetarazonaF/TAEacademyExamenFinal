package com.globant.tests;

import com.globant.driver.Driver;
import com.globant.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public Logger log = Logger.getLogger(BaseTest.class);
    private Driver driver;
    private HomePage homePage;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver(), url);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.closeDriver();
    }

    public void switchDefaultContent() {
        driver.getDriver().switchTo().defaultContent();
    }

    public HomePage getHomePage() {
        return homePage;
    }

}
