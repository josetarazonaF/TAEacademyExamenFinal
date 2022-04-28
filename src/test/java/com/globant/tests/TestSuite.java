package com.globant.tests;

import com.globant.data.Data;
import com.globant.data.ProfileInfo;
import com.globant.pages.HomePage;
import com.globant.pages.LoginIframe;
import com.globant.pages.SettingsProfileIframe;
import com.globant.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    HomePage homePage;
    LoginIframe loginIframe;
    SignUpPage signUpPage;
    SettingsProfileIframe settingsProfileIframe;

    @BeforeMethod(alwaysRun = true)
    public void SignInAccount(Object[] profileInfoData) {
        ProfileInfo profileInfo = (ProfileInfo) profileInfoData[0];

        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking login button");
        loginIframe = homePage.clickLoginButton();
        log.info("Clicking signup button");
        signUpPage = loginIframe.clickSignUpButton();
        log.info("sending profile info keys to signup");
        signUpPage.sendProfileInfoSignUpKeys(profileInfo);
        log.info("Clicking signup button");
        signUpPage.clickSignUpButton();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking logout button");
        homePage.clickLogoutButton();
    }


    @Test(description = "Login Test", dataProviderClass = Data.class, dataProvider = "ProfileInfo", groups = {"t1"})
    public void loginTest(ProfileInfo profileInfo) {
        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking login button");
        loginIframe = homePage.clickLoginButton();
        log.info("sending profile info keys to login");
        loginIframe.sendProfileInfoLoginKeys(profileInfo);
        log.info("Clicking login button");
        loginIframe.clickLoginButton();
        homePage.clickUserButton();
        Assert.assertFalse(homePage.isLoginButtonDisplayed(), "Login Button is not displayed");
        Assert.assertTrue(homePage.isSettingsProfileButtonDisplayed(), "Settings Profile Button is not displayed");
    }

    @AfterMethod(groups = {"t1"})
    public void afterLogin() {
        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking logout button");
        homePage.clickLogoutButton();
        homePage.clickUserButton();
        Assert.assertFalse(homePage.isSettingsProfileButtonDisplayed(), "Settings Profile Button is displayed");
    }

    @BeforeMethod(groups = {"t2"})
    public void beforeLoginTest(Object[] profileInfoData) {
        ProfileInfo profileInfo = (ProfileInfo) profileInfoData[0];
        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking login button");
        loginIframe = homePage.clickLoginButton();
        log.info("sending profile info keys to login");
        loginIframe.sendProfileInfoLoginKeys(profileInfo);
        log.info("Clicking login button");
        loginIframe.clickLoginButton();

    }

    @Test(description = "Logout Test", dataProviderClass = Data.class, dataProvider = "ProfileInfo", groups = {"t2"})
    public void logoutTest(ProfileInfo profileInfo) {
        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking logout button");
        homePage.clickLogoutButton();

    }

    @Test(description = "Cancel Account Test", dataProviderClass = Data.class, dataProvider = "ProfileInfo", groups = {"t3"})
    public void cancelAccountTest(ProfileInfo profileInfo) {
        homePage = getHomePage();
        log.info("Clicking user button");
        homePage.clickUserButton();
        log.info("Clicking settings profile button");
        settingsProfileIframe = homePage.clickSettingsProfileButton();
        log.info("Clicking delete account tag");
        settingsProfileIframe.clickDeleteAccountTag();
        log.info("Clicking confirm delete account button");
        settingsProfileIframe.clickConfirmDeleteAccountButton();

    }

}
