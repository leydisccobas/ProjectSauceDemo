package com.sauceprojectdemo.test;

import org.testng.annotations.Test;

import com.sauceprojectdemo.pom.LoginPageSauceProjectDemo;
import com.sauceprojectdemo.pom.homePageSauceProjectDemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HomeTest {

	LoginPageSauceProjectDemo loginPage;
	homePageSauceProjectDemo homepage;
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		loginPage = new LoginPageSauceProjectDemo(driver);
		driver = loginPage.connectionChromeDriver();
		loginPage.start();
		loginPage.loginStandardUser();
	}
	/*
	@Test(priority = 1)
	public void isProductDisplayedTest() throws InterruptedException {
		Assert.assertTrue(homepage.isProductDisplayed(), "Product displayed");
	}
*/
	@Test(priority = 2)
	public void addProductToCartTest() throws InterruptedException {
		homepage.addProductToCart();
		Assert.assertTrue(homepage.isProductAddToCart(), "Product added to the cart");
	}
/*
	@Test(priority = 3)
	public void isProductAddToCartTest() throws InterruptedException {
		Assert.assertTrue(homepage.isProductAddToCart(), "Product added to the cart");
	}
*/
	@AfterTest
	public void afterTest() {
		//driver.quit();
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
