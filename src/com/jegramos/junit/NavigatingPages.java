package com.jegramos.junit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class NavigatingPages {
	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		baseUrl = "https://letskodeit.teachable.com/";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_"
				+ "purchase_session=1";
		
		driver.navigate().to(urlToNavigate);
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
}
