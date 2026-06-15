package com.nithya.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class LoginTestNG {

	WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setup()
    {
    driver=new ChromeDriver();
    
    driver.manage().window().maximize();
    
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    System.out.println("Browser Opened");
    }
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {

            {"Admin", "admin123"},
            {"Admin", "wrong123"},
            {"wronguser", "admin123"}

        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username")));

        driver.findElement(By.name("username"))
              .sendKeys(username);

        driver.findElement(By.name("password"))
              .sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']"))
              .click();
        
        Thread.sleep(3000);

        System.out.println("Current URL = " + driver.getCurrentUrl());

        try {

            wait.until(ExpectedConditions.urlContains("dashboard"));

            System.out.println("Login Successful for : " + username);

            Assert.assertTrue(true);

        } catch (Exception e) {

            System.out.println("Login Failed for : " + username);

            Assert.fail("Login Failed");
        }
    }
    	
    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }	
    	
    	
    

}
    
    
	
	
	
	
	
	

