package com.sauceprojectdemo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class homePageSauceProjectDemo extends BaseSauceProjectDemo {

	By productLocator = By.xpath("//*[@id=\"item_4_title_link\"]/div");
	By addToCartBtnLocator = By.id("add-to-cart-sauce-labs-backpack");
	By cartBtnLocator = By.className("shopping_cart_badge");

	public homePageSauceProjectDemo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("Verify if there is a product in the home page")
	public boolean isProductDisplayed() throws InterruptedException {
		Thread.sleep(8000);
		if (isDisplayed(productLocator)) {
			System.out.println("Product displayed");
			return true;
		}
		else {
			System.out.println("Porduct not displayed");
			return false;
		}
	}
	@Step("Add the product to the cart")
	public void addProductToCart() throws InterruptedException {
		Thread.sleep(4000);	
		click(addToCartBtnLocator);
	}
	@Step("Verify if the product was added to the cart")
	public boolean isProductAddToCart() throws InterruptedException {
		click(cartBtnLocator);
		Thread.sleep(2000);
		if (isDisplayed(productLocator)) {
			System.out.println("Product added to the cart");
			return true;
		}
		else {
			System.out.println("Product didn't add to the cart");
			return false;
		}
		
	}
}
