package Swag_Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Swag_ActionMethods.LoginPage_Methods;
import Utility.BaseClass;
import Utility.Report;
import Utility.Verify;

public class LoginpageTestcases {
	public LoginPage_Methods loginpage_methods;

	@BeforeMethod()
	public void Beforesuit() {

		BaseClass.startDriver();
		Report.startReport();
		Verify.restAssertion();
		loginpage_methods = new LoginPage_Methods();

	}

	@Test()
	public void Attest() throws InterruptedException {

		Report.createTest("Items Add to Cart TestCase");
		Report.createNode("SwagLabs Login");
		BaseClass.Sleep();
//		loginpage_methods.swag_labs_methods.swag_labs_loginpage.getRandomUser();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.setUserName("standard_user");
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_loginpage.Password();
		BaseClass.Sleep();

		loginpage_methods.swag_labs_methods.swag_labs_loginpage.ClickLoginBotton();
		BaseClass.Sleep();
		Report.pass("Login_Successfull");
		Report.logInfo("login successfully......");

		Report.createNode("SwagLabs Order");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.ClickMenuButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.sidebarmethods.Hover_AllItems();
		BaseClass.Sleep();
		Report.pass("hovering");
		Report.logInfo("Verify_Hover");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items
				.clickProductName("Sauce Labs Bike Light");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items
				.verifyProductName("sSauce Labs Bike Light");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyDescription(
				"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VeirfyPrice("$9.99");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickBackToProductButton();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items
				.clickAddToCartButton("Sauce Labs Backpack");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickCartIcon();
		BaseClass.Sleep();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickContinueShoppingBotton();
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items
				.clickAddToCartButton("Sauce Labs Bolt T-Shirt");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.clickCartIcon();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.Verifyproductname(0,
				"auce Labs Backpack");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyproductDiscription(0,
				"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyproductPrice(0, "$29.99");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.Verifyproductname(1,
				"Sauce Labs Bolt T-Shirt");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyproductDiscription(1,
				"Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.");
		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyproductPrice(1, "$15.99");

		Report.pass("Cart Deatails Verified");
		Report.logInfo("Verify_Cart_Details");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickCheckOut();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.CheckOutDetails("vikram", "sreenivas",
				"517589");
		Report.pass("Checkout Details Verified");
		Report.logInfo("Checkout_Details");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickContinueButton();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyOverDetails();
		Report.pass("VerifyOver Details Verified");
		Report.logInfo("VerifyOver_Details");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.PaymentInformation();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ShippingInformation();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.TotalPrice();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickFinishButton();

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.VerifyThnxOrder();
		Report.pass("order details");
		Report.logInfo("Verify_thnx_Order");

		loginpage_methods.swag_labs_methods.swag_labs_productpage.swaglab_items.ClickBackHome();

		Verify.assertAll();

	}

//	@AfterMethod
//	public void captureResult(ITestResult result) {
//
//		Report.testResult = result;
//
//	}

	@AfterMethod()
	public void AfterSuite(ITestResult result) {

		
		Report.getResult(result);
		BaseClass.StopDriver();
		Report.flush();

	}

}// LoginpageTestcases
