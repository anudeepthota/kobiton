package com.kobiton.testng;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import com.kobiton.config.Configs;

public class AndroidWebTest {
	public static AndroidDriver<WebElement> driver = null;
	String wrongUsernameMsg = "Your username is invalid!";
	String wrongPasswordMsg = "Your password is invalid!";
	String successMsg = "You logged into a secure area!";

	@BeforeTest
	public void Setup() {
		driver = new AndroidDriver<WebElement>(Configs.kobitonServerUrl(), Configs.desiredCapabilitiesAndroidWeb());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterTest
	public void Teardown() {
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "should return error when we input wrong username")
	public void testInvalidUsername() {
		login("anudeep", "SuperSecretPassword!");
		Assert.assertTrue(getMessage().contains(wrongUsernameMsg));
	}

	@Test(priority = 2, description = "should return error when we input wrong password")
	public void testInvalidPassword() {
		login("tomsmith", "TestPassword");
		Assert.assertTrue(getMessage().contains(wrongPasswordMsg));
	}
	
	@Test(priority = 3, description = "should return error when we input wrong username and password")
	public void testInvalidUserNameAndPassword() {
		login("anudeep", "testpassword");
		Assert.assertTrue(getMessage().contains(wrongUsernameMsg));
	}

	
	@Test(priority = 4, description = "should run test successfully with correct username and password")
	public void testLoginSuccessfully() {
		login("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(getMessage().contains(successMsg));
	}

	public void login(String userName, String password) {
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByXPath("//*[@id='login']/button").click();
	}

	public String getMessage() {
		return driver.findElementById("flash").getText();
	}
}
