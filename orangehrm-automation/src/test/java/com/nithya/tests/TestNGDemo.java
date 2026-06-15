package com.nithya.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	
@BeforeMethod 
public void setup()
{
	
    System.out.println("Browser Open");

}

@Test	
public void Logintest() {
	
	
    System.out.println("Login Executed");

}

@AfterMethod
public void teardown()
{
	
    System.out.println("Browser Closed");

}
	
	

}
