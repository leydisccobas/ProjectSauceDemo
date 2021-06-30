package com.sauceprojectdemo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class homePageSauceProjectDemo extends BaseSauceProjectDemo {

	By productLocator = By.xpath("//*[@id=\"item_4_title_link\"]/div");
	By addToCartBtnLocator = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
	By cartBtnLocator = By.className("shopping_cart_badge");

	public homePageSauceProjectDemo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("Verify if there is a product in the home page")
	public boolean isProductDisplayed() {
		if (isDisplayed(productLocator)) {
			System.out.println("Product found");
			return true;
		}
		else {
			System.out.println("Porduct not found");
			return false;
		}
	}
	@Step("Add the product to the cart")
	public void addProductToCart() {
			click(addToCartBtnLocator);
	}
	@Step("Verify if the product was added to the cart")
	public boolean isProductAddToCart() throws InterruptedException {
		click(cartBtnLocator);
		Thread.sleep(2000);
		if (isDisplayed(productLocator)) {
			System.out.println("The product added to the cart");
			return true;
		}
		else {
			System.out.println("The product didn't add to the cart");
			return false;
		}
		
	}
}
