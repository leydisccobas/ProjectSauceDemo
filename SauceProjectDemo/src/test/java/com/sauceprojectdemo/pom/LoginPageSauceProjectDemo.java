package com.sauceprojectdemo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;


public class LoginPageSauceProjectDemo extends BaseSauceProjectDemo{

	By userNameLocator = By.id("user-name");
	By passwordLocator = By.id("password");
	By loginBtnLocator = By.id("login-button");
	
	By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
	
	By homePageTitleLocator = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	
	public LoginPageSauceProjectDemo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("Begin the browser")
	public void start() {
		goToURL("https://www.saucedemo.com/");
	}
	@Step("Login with standard_user")
	public void loginStandardUser() {
		if(isDisplayed(userNameLocator)) {
			type("standard_user", userNameLocator);
			type("secret_sauce", passwordLocator);
			click(loginBtnLocator);
		}
		else {
			System.out.println("Login page was not found");
		}
	}
	@Step("Check if the home page is displayed")
	public boolean isHomePageDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		if(isDisplayed(homePageTitleLocator)) {
			System.out.println("Login successful");
			return true;
		}
		else {
			System.out.println("Login unsuccessful");
			return false;
		}		
	}
}
