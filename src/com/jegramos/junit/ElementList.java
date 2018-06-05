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

class ElementList {
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
		List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='radio-btn-example']"
				+ "//input[@type='radio' and @name= 'cars']"));
		
		System.out.println("size of the list: " + radioButtons.size());
		int iterations = 2;
		while(iterations > 0) {
			for(int i = 0; i < radioButtons.size(); i++) {
				if(!radioButtons.get(i).isSelected()) {
					radioButtons.get(i).click();
					Thread.sleep(2000);
				}
			}
		iterations--;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
