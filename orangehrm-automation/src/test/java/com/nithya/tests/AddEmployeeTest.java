package com.nithya.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeeTest {
	 
	public static void main(String[] args) throws InterruptedException  {

		 WebDriver driver = new ChromeDriver();
	       
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        driver.manage().window().maximize();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

	        driver.findElement(By.name("username"))
	        .sendKeys("Admin");

	  driver.findElement(By.name("password"))
	        .sendKeys("admin123");

	  driver.findElement(By.xpath("//button[@type='submit']"))
	        .click();

	  System.out.println("Login Successful");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
	 
	  driver.findElement(By.xpath("//span[text()='PIM']")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//a[text()='Add Employee']")));

		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.name("firstName")));

		driver.findElement(By.name("firstName"))
		      .sendKeys("Nithya");

		driver.findElement(By.name("lastName"))
		      .sendKeys("Tester");
		
		driver.findElement(By.xpath("//button[@type='submit']"))
	      .click();
		
		System.out.println("Employee Added Successfully");
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
		 
		  driver.findElement(By.xpath("//span[text()='PIM']")).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//a[text()='Employee List']")));

			driver.findElement(By.xpath("//a[text()='Employee List']")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//h5[text()='Employee Information']")));

			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			
			Thread.sleep(3000);	
			
			driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"))
		      .sendKeys("Nithya Tester");
			
		    driver.findElement(By.xpath("//button[@type='submit']"))
		      .click();
		    
		    Thread.sleep(3000);
		    
		    System.out.println("Search Executed Successfully");
	
		    String pageHeader = driver.findElement(
		            By.xpath("//h5[text()='Employee Information']"))
		            .getText();

		    System.out.println(pageHeader);
		
		
	    }
}
