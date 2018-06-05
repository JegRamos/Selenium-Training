package com.jegramos.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jegramos.junit.helpers.WaitTypes;

class ExplicitWait {
	private WebDriver driver;
	private String baseUrl;
	private WaitTypes wt;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		wt = new WaitTypes(driver);
		baseUrl = "https://letskodeit.teachable.com/p/practice/";
		driver.manage().window().maximize();
	}

	@Test
	void test() {
		driver.get(baseUrl);
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='navbar']//a[@href='/sign_in']"));
		loginButton.click();

		WebElement emailInputBox = wt.waitAndGetElement(By.id("user_email"), 5);
		emailInputBox.sendKeys("jegramos.pa@gmail.com");
		
		wt.clickWhenReady(By.name("commit"), 5);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
