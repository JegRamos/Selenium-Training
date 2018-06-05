package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class RadioBtns_CheckBoxes {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void test() {
		driver.get(baseUrl);
		WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
		bmwRadio.click();
		
		WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
		bmwCheck.click();
		
		WebElement benzCheck = driver.findElement(By.id("benzcheck"));
		benzCheck.click();
		
		WebElement hondaCheck = driver.findElement(By.id("hondacheck"));
		
		System.out.println("BMW Radion Button: " + bmwRadio.isSelected());
		System.out.println("BMW Checkbox: " + bmwCheck.isSelected());
		System.out.println("Benz Checkbox: " + benzCheck.isSelected());
		System.out.println("Honda Checkbox: " + hondaCheck.isSelected());	
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
