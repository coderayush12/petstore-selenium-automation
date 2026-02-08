package com.petstore.tests;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.petstore.pages.CartPage;
import com.petstore.pages.CheckoutPage;
import com.petstore.pages.HomePage;
import com.petstore.pages.LoginPage;
import com.petstore.pages.SearchPage;

public class CheckoutTest extends BaseTest {
	@DataProvider(name = "productData")
    public Object[][] getData() {
        return new Object[][] {
        	{"DOGS", "K9-BD-01"},
            {"DOGS", "K9-PO-02"},
            {"DOGS", "K9-DL-01"},
            {"DOGS", "K9-RT-01"},
            {"DOGS", "K9-RT-02"},
            {"DOGS", "K9-CW-01"},
            {"FISH", "FI-SW-01"},
            {"FISH", "FI-SW-02"},
            {"FISH", "FI-FW-01"},
            {"FISH", "FI-FW-02"},
            {"CATS", "FL-DSH-01"},
            {"CATS", "FL-DLH-02"},
            {"REPTILES", "RP-SN-01"},
            {"REPTILES", "RP-LI-02"},
            {"BIRDS", "AV-CB-01"},
            {"BIRDS", "AV-SB-02"}

        };
	}
	
	@Test(dataProvider="productData")
	public void verifyCheckoutFlow(String Category,String ProductId) throws InterruptedException {
		
		//Login
		LoginPage login=new LoginPage(driver);
		login.loginToApplication("j2ee", "j2ee");

		//verify login
		HomePage home=new HomePage(driver);
		Assert.assertTrue(home.returnTrueIfLoggedIn(),"Login failed");
		//add product to cart
		SearchPage search=new SearchPage(driver);
		search.openCategory(Category);
		search.selectProductById(ProductId);
		search.addToCart();
		
		//verify item in cart
		CartPage cart=new CartPage(driver);
		Assert.assertTrue(cart.isItemAddedToCart(),"Item Not added to cart");
		
		//Checkout
		CheckoutPage checkout=new CheckoutPage(driver);
		checkout.clickProceedToCheckout();
		checkout.clickConfirmOrder();
		checkout.clickConfirm();
		
		//verify order success 
		Assert.assertTrue(checkout.isOrderPlacedSuccessfully(),"Order was not placed successfully");
		checkout.clickReturnToMainMenu();
	}
}
