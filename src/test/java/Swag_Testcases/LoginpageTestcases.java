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
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.getRandomUser();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.Password();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.ClickLoginBotton();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.ClickMenuButton();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sidebarmethods.Hover_AllItems();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.ProductItemOne("Sauce Labs Bike Light");
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.AddToCart("Sauce Labs Backpack");
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sawlab_items.AddToCart("Sauce Labs Bolt T-Shirt");
	
		
	}
	
}//LoginpageTestcases
