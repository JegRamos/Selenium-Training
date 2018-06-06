package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxDemo {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "https://letskodeit.teachable.com/";
	}

	@Test
	void test() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).click();
		driver.findElement(By.id("user_email")).sendKeys("jegramos.pa@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("049111525");
		driver.findElement(By.name("commit")).click();
		System.out.println("clicked submit");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.quit();
	}
	
}
