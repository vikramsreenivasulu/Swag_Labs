package Swag_Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Swag_ActionMethods.LoginPage_Methods;
import Utility.BaseClass;

public class LoginpageTestcases {
	public LoginPage_Methods loginpage_methods;

	@BeforeSuite()
	public void Beforesuit() {
		
		BaseClass.startDriver();
		loginpage_methods = new LoginPage_Methods();
		
	}
	
	@Test()
	public void Attest() throws InterruptedException {
		
		BaseClass.Sleep();
//		loginpage_methods.swag_labs_methods.swag_labs_loginpage.getRandomUser();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.setUserName("standard_user");
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.Password();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.ClickLoginBotton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.ClickMenuButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sidebarmethods.Hover_AllItems();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickProductName("Sauce Labs Bike Light");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.verifyProductName();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickBackToProductButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickAddToCartButton("Sauce Labs Backpack");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickCartIcon();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.ClickContinueShoppingBotton();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickAddToCartButton("Sauce Labs Bolt T-Shirt");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.clickCartIcon();
	
		
	}
	
}//LoginpageTestcases
