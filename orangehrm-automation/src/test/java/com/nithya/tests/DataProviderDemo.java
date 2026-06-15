package com.nithya.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider(name="loginData")
	 public Object[][] getData() {

        return new Object[][] {

            {"Admin","admin123"},
            {"Admin","wrong123"},
            {"WrongUser","admin123"}

        };
    }
    @Test(dataProvider="loginData")
    public void loginTest(String username,String password) {

        System.out.println(username + " : " + password);

    }
}
