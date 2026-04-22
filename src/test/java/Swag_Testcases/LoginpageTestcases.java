package Swag_Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Swag_ActionMethods.LoginPage_Methods;
import Utility.BaseClass;
import Utility.Report;

public class LoginpageTestcases {
	public LoginPage_Methods loginpage_methods;

	@BeforeSuite()
	public void Beforesuit() {
		
		BaseClass.startDriver();
		Report.startReport();
		loginpage_methods = new LoginPage_Methods();
		
	}
	
	@Test()
	public void Attest() throws InterruptedException {
		
		Report.createTest("Add to Cart TestCase");
		BaseClass.Sleep();
//		loginpage_methods.swag_labs_methods.swag_labs_loginpage.getRandomUser();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.setUserName("standard_user");
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.Password();
		BaseClass.Sleep();
		
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.ClickLoginBotton();
		BaseClass.Sleep();
		Report.pass("Login_Successfull");
		
		loginpage_methods.swag_labs_methods.swag_labs_productpage.ClickMenuButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sidebarmethods.Hover_AllItems();
		BaseClass.Sleep();
		Report.logInfo("Verify_Hover");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickProductName("Sauce Labs Bike Light");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.verifyProductName();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickBackToProductButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickAddToCartButton("Sauce Labs Backpack");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickCartIcon();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickContinueShoppingBotton();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickAddToCartButton("Sauce Labs Bolt T-Shirt");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickCartIcon();
	
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyProductdetailsinCart(0);
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyProductdetailsinCart(1);
		Report.logInfo("Verify_Cart_Details");
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickCheckOut();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.CheckOutDetails("vikram", "sreenivas", "517589");
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickContinueButton();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyOverDetails();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.PaymentInformation();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ShippingInformation();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.TotalPrice();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickFinishButton();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyThnxOrder();
//		
//		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickBackHome();
//		
	}
	
	@AfterSuite()
	public void AfterSuite(ITestResult result) {
		BaseClass.StopDriver();
		Report.getResult(result);
		Report.flush();

	}
	
}//LoginpageTestcases
