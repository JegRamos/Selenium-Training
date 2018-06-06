package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class UsefulMethods {
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
		WebElement openTabButton = driver.findElement(By.id("opentab"));
		// get text
		System.out.println(openTabButton.getText());
		
		// get attribute value
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		String attributeValue = bmwRadioButton.getAttribute("name");
		System.out.println("Attribute value of bmw radion button is: " + attributeValue);
	}

	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
