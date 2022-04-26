package com.globant.tests;

import com.globant.pages.HomePage;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    HomePage homePage;

    @Test
    public void Test() {
        homePage = getHomePage();
        homePage.clickElement(homePage.getUserButton());
    }

}
