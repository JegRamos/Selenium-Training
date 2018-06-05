package com.jegramos.junit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class MultipleSelect {
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
	void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement multipleSelect = driver.findElement(By.id("multiple-select-example"));
		Select selMultipleSelect = new Select(multipleSelect);
		
		selMultipleSelect.deselectAll();
		
		selMultipleSelect.selectByValue("apple");
		Thread.sleep(2000);
		
		selMultipleSelect.deselectByValue("apple");
		Thread.sleep(2000);
		
		selMultipleSelect.selectByValue("orange");
		Thread.sleep(2000);
		
		selMultipleSelect.selectByValue("peach");
		Thread.sleep(2000);
		
		List<WebElement> selOptions = selMultipleSelect.getAllSelectedOptions();
		for (WebElement option : selOptions) {
			System.out.println(option.getText());
		}
	}

	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
