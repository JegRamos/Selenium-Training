package com.jegramos.junit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jegramos.junit.helpers.Helpers;

class GenericMethod {
	private WebDriver driver;
	private String baseUrl;
	private Helpers gm;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/com/jegramos/browser/drivers/geckodriver");
		driver = new FirefoxDriver();
		gm = new Helpers(driver);
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement loginButton = gm.getElement("xpath", "//a[@href='/sign_in']");
		loginButton.click();
		Thread.sleep(2000);
		
		gm.goBack();
		Thread.sleep(2000);
		
		gm.elementIsPresent("xpath", "//div[@id='radio-btn-example']//input[@type='radio' and @name='cars']");
		
		List<WebElement> radioButtons = gm.getElementList("xpath", "//div[@id='radio-btn-example']"
				+ "//input[@type='radio' and @name='cars']");
		int iterations = 2;
		while(iterations > 0) {
			for(int i = 0;  i < radioButtons.size(); i++) {
				radioButtons.get(i).click();
				System.out.println(radioButtons.get(i).getAttribute("value") + " was selected!");
				Thread.sleep(2000);
			}
			iterations--;
		}
		System.out.println("Size of the ElementList is " + radioButtons.size());
		radioButtons.size();
		
}
	
	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
