package com.globant.tests;

import com.globant.data.Data;
import com.globant.data.ProfileInfo;
import com.globant.pages.HomePage;
import com.globant.pages.LogInPage;
import com.globant.pages.SignUpPage;
import com.globant.pages.WatchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    @Test(description = "ESPN FINAL TESTING", dataProviderClass = Data.class, dataProvider = "ProfileInfo")
    public void testESPN(ProfileInfo profileInfo) {

        //step 1
        HomePage homePage = getHomePage();

        //step 2
        homePage.clickUserButton();
        LogInPage logInPage = homePage.goToLoginPage();
        Assert.assertTrue(logInPage.isESPNLogoDisplayed(), "ESPN logo not displayed");
        Assert.assertTrue(logInPage.isLoginButtonDisplayed(), "LogIn button not displayed");
        Assert.assertTrue(logInPage.isSignUpButtonDisplayed(), "SignUp button not displayed");

        //step 3
        SignUpPage signUpPage = logInPage.goToSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpTitleDisplayed(), "SignUp title not displayed");
        Assert.assertTrue(signUpPage.isFirstNameInputDisplayed(), "FirstName input not displayed");
        Assert.assertTrue(signUpPage.isLastNameInputDisplayed(), "LastName input not displayed");
        Assert.assertTrue(signUpPage.isEmailInputDisplayed(), "Email input not displayed");
        Assert.assertTrue(signUpPage.isPasswordInputDisplayed(), "Password input not displayed");
        Assert.assertTrue(signUpPage.isSignUpButtonDisplayed(), "SignUp button not displayed");
        Assert.assertTrue(signUpPage.isCloseXButtonDisplayed(), "Close X button not displayed");

        //step 4
        signUpPage.sendProfileInfoSignUpKeys(profileInfo);
        homePage = signUpPage.goToHomepageSignedUp();

        //step 5
        WatchPage watchPage = homePage.goToWatchPage();
        Assert.assertTrue(watchPage.isAtLeastOneCarouselDisplayed(), "no carousel is displayed");
        Assert.assertTrue(watchPage.isTitleAndDescriptionDisplayedForEachCard(), "no title or description is displayed for each card");

        //step 6
        watchPage.clickCarouselCardTwo();
        Assert.assertTrue(watchPage.isCardCloseXButtonDisplayed(), "Close X button not displayed in card");

        //step 7
        watchPage.clickCardCloseXButton();

        //step 8
        homePage = watchPage.goToHomePage();

        //step 9
        homePage.performMouseHoverToUserIcon();
        Assert.assertTrue(homePage.validateUsernameNavText(profileInfo.getFirstName()), "Username not displayed");

        //step 10
        homePage.clickLogoutButton();
        homePage.performMouseHoverToUserIcon();
        Assert.assertTrue(homePage.validateNoUsernameLoggedOut(), "Username is still displayed");

    }

}


