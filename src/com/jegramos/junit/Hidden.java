package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class Hidden {
	WebDriver driver;
	String baseUrl;
	String baseUrl2;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		baseUrl2 = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void testLetskodeit() throws InterruptedException {
		driver.get(baseUrl);
		WebElement textbox = driver.findElement(By.id("displayed-text"));
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		
		hideButton.click();
		System.out.println("Clicked on hide button");
		System.out.println("textbox is dispalyed: " + textbox.isDisplayed());
		Thread.sleep(2000);
		
		showButton.click();
		System.out.println("Clicked on show button");
		System.out.println("textbox is displayed: " + textbox.isDisplayed());
		Thread.sleep(2000);
		
		if(textbox.isDisplayed()) {
			textbox.sendKeys("Jeg Ramos");
			System.out.println(textbox.getText());
		} else {
			System.out.println("Textbox is not displayed!");
		}
	}
	
//	@Test
//	void testExpedia() {
//		driver.get(baseUrl2);
//		WebElement element = driver.findElement(By.id("tab-package-tab-hp"));
//		element.click();
//	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
