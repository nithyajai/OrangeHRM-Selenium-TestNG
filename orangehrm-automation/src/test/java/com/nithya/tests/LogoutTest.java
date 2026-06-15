package com.nithya.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutTest {
	public static void main(String[] args) {
//Launch Browser		
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//Login
        driver.findElement(By.name("username"))
        .sendKeys("Admin");

  driver.findElement(By.name("password"))
        .sendKeys("admin123");

  driver.findElement(By.xpath("//button[@type='submit']"))
        .click();

  System.out.println("Login Successful");
  

wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//h6[text()='Dashboard']")));
  
  //click profilepicture
  wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//span[@class='oxd-userdropdown-tab']")));
  
  driver.findElement(
	        By.xpath("//img[@alt='profile picture']"))
	        .click();
  
  //Logout
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//a[text()='Logout']")));

	driver.findElement(
	        By.xpath("//a[text()='Logout']"))
	        .click();
  
	  System.out.println("Logout Successful");

  
 
	}
}
