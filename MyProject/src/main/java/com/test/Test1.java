package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	public WebDriver driver;
	String expectedURL = "http://demo.guru99.com/test/newtours/";
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	@Test
	public void accessURL() {
		
		driver.get(expectedURL);
		String urL=driver.getCurrentUrl();
		Assert.assertEquals(urL,expectedURL);
		System.out.println("Test case is executed");
	}
	
	@Test
	public void login() {
		
		//String errorMessage = "Enter your userName and password correct";
		
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("adminUser");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[name='submit']")).click();
	}
	
}
