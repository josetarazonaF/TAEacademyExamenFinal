package com.globant.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "ProfileInfo")
    public Object[][] createProfileInfo() {
        return new Object[][]{{new ProfileInfo()}};
    }
}
