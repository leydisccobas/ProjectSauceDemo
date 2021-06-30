package com.sauceprojectdemo.test;

import com.sauceprojectdemo.pom.LoginPageSauceProjectDemo;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class loginTestNG {
	
	LoginPageSauceProjectDemo loginPage;
	private WebDriver driver;
	
	public loginTestNG(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeTest
	public void beforeTest() {
		loginPage = new LoginPageSauceProjectDemo(driver);
		driver = loginPage.connectionChromeDriver();
		loginPage.start();
	}
	@Test (priority = 1, description=" Login con usuario estandar")
	public void loginTest() throws InterruptedException {
		loginPage.loginStandardUser();
		Assert.assertTrue(loginPage.isHomePageDisplayed(), "Login successful");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
