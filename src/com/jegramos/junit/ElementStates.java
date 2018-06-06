package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class ElementStates {
	WebDriver driver;
	String baseUrl;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://www.google.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		WebElement googleSearchBox = driver.findElement(By.id("lst-ib"));
		googleSearchBox.sendKeys("Jeg Ramos");
		System.out.println(googleSearchBox.isDisplayed());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
