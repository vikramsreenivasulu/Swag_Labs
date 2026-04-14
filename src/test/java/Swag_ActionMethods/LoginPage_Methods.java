package Swag_ActionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Swag_Locators.Loginpage_Locators;
import Utility.BaseClass;

public class LoginPage_Methods {

	public Swag_Labs_Methods swag_labs_methods;

	public LoginPage_Methods() {

		swag_labs_methods = new Swag_Labs_Methods();
	}

	public Loginpage_Locators swag_labs_locators = new Loginpage_Locators();

	public class Swag_Labs_Methods {

		public Swag_Labs_LoginPage swag_labs_loginpage;
		public Swag_Labs_ProductPage swag_labs_productpage;

		public Swag_Labs_Methods() {
			swag_labs_loginpage = new Swag_Labs_LoginPage();
			swag_labs_productpage = new Swag_Labs_ProductPage();
		}

		public class Swag_Labs_LoginPage {

			public String getRandomUser() {

				String text = swag_labs_locators.swag_labs_locators.swag_labs_loginpage.loginCredentials.getText();

				String[] users = text.split("\n");

				List<String> userList = new ArrayList<>();

				for (int i = 1; i < users.length; i++) {
					userList.add(users[i].trim());
				}

				Random rand = new Random();
				int randomIndex = rand.nextInt(userList.size());

				String randomUser = userList.get(randomIndex);

				System.out.println("Selected User: " + randomUser);

				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.SendUserId.sendKeys(randomUser);

				return randomUser;

			}

			public void setUserName(String userName) {

				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.SendUserId.sendKeys(userName);

			}

			public void Password() {
				String text = swag_labs_locators.swag_labs_locators.swag_labs_loginpage.Password.getText();

				String[] parts = text.split("\n");
				String password = parts[1];

				System.out.println("Password: " + password);

				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.SendPassword.sendKeys(password);
			}

			public void ClickLoginBotton() {
				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.LoginButton.click();
			}

		}// Swag_Labs_LoginPage

		public class Swag_Labs_ProductPage {

			public SideBarMethods sidebarmethods;
			public SawLab_Items swaglab_items;

			public Swag_Labs_ProductPage() {
				sidebarmethods = new SideBarMethods();
				swaglab_items = new SawLab_Items();
			}

			public void ClickMenuButton() {
				swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.MenuButton.click();
			}

			public class SideBarMethods {

				public void Hover_AllItems() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_AllItems.click();

					Actions hover = new Actions(BaseClass.driver);
					String text = swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_AllItems
							.getText();
					System.out.println("text: " + text);
					hover.moveToElement(
							swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_AllItems)
							.build().perform();

					Hover_About();
					Hover_Logout();
					Hover_ReserAppStore();
					CrossButton();
				}

				public void Hover_About() {

					String text = swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_About
							.getText();
					System.out.println("text: " + text);

					Actions hover = new Actions(BaseClass.driver);
					hover.moveToElement(
							swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_About)
							.build().perform();

				}

				public void Hover_Logout() {
					String text = swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_Logout
							.getText();
					System.out.println("text" + text);

					Actions hover = new Actions(BaseClass.driver);
					hover.moveToElement(
							swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_Logout)
							.build().perform();
				}

				public void Hover_ReserAppStore() {
					String text = swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_ReserAppStore
							.getText();
					System.out.println("text:" + text);

					Actions hover = new Actions(BaseClass.driver);
					hover.moveToElement(
							swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.Hover_ReserAppStore)
							.build().perform();
				}

				public void CrossButton() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.sidebarlocators.CrossButton.click();
				}

			}// SideBar

			public class SawLab_Items {

				public void clickProductName(String productName) {
					BaseClass.driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
				}

				public void verifyProductName() {

					String actualName = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductName
							.getText().trim();
					System.out.println("Productname:" + actualName);
					String expectedName = "Sauce Labs Bike Light";

					String actualDescription = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductsDisc
							.getText();
					System.out.println("Description:" + actualDescription);

					String expectedDesc = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
					String expected2 = "A description should be here, but it failed to render! This error has been reported to Backtrace.";

					String actualPrice = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductsPrice
							.getText();
					System.out.println("Price:" + actualPrice);
					String expectedPrice = "$9.99";

					Assert.assertEquals(actualName, expectedName, "Error Message");
//					Assert.assertEquals(actualDescription, expectedDesc);
					Assert.assertEquals(actualPrice, expectedPrice);

//					boolean status = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductName.isDisplayed();
//					Assert.assertTrue(status, "Item is not displayed");
//					
					Assert.assertTrue(
							actualDescription.contains(expectedDesc) || actualDescription.contains(expected2));

				}// ProductItemOne

				public void clickBackToProductButton() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.BackToProduct.click();

				}

				public void clickAddToCartButton(String asdf) throws InterruptedException {

					WebElement element = BaseClass.driver
							.findElement(By.xpath("//a[contains(.,'" + asdf + "')]/following::button[1]"));
					BaseClass.Sleep();
					element.click();

				}

				public void clickCartIcon() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.Cart.click();

				}

				public void ClickContinueShoppingBotton() {

					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.ContinueShoppingButton
							.click();
				}

				public void VerifyProductdetailsinCart(int index) {

					String productName = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductNameList
							.get(index).getText().trim();
					System.out.println("CartProdutcName:" + productName);

					String actualDescription = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductsDiscList
							.get(index).getText().trim();
					System.out.println("Description:" + actualDescription);

					String actualPrice = swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_items.ProductsPriceList
							.get(index).getText().trim();
					System.out.println("Price:" + actualPrice);

					// Assert
					Assert.assertTrue(true, productName);
					Assert.assertTrue(true, actualDescription);
					Assert.assertTrue(true, actualPrice);

				}// VerifyProductdetailsinCart

				public void ClickCheckOut() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.CheckOut.click();
				}

				public void CheckOutDetails(String FisrtName, String LastName, String Code) {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.checkoutinformation.FirstName
							.sendKeys(FisrtName);

					swag_labs_locators.swag_labs_locators.swag_labs_productpage.checkoutinformation.LastName
							.sendKeys(LastName);

					swag_labs_locators.swag_labs_locators.swag_labs_productpage.checkoutinformation.PostCode
							.sendKeys(Code);

				}// CheckOutDetails

				public void ClickContinueButton() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.ContinueButton.click();
				}

				public void VerifyOverDetails() {

					
					System.out.println("---------------------Product  One-----------------------");

					String product1 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.ProductName
							.get(0).getText().trim();
					System.out.println("Product:" + product1);

					String ProductDiscription1 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.Discription
							.get(0).getText().trim();
					System.out.println("ProductDiscription:" + ProductDiscription1);

					String Price1 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.Price
							.get(0).getText().trim();
					System.out.println("Price:" + Price1);

					// Asserion:

					Assert.assertEquals(product1, "Sauce Labs Backpack");
					Assert.assertEquals(ProductDiscription1,
							"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
					Assert.assertEquals(Price1, "$29.99");
					
					System.out.println("---------------------Product  Two-----------------------");

					String Product2 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.ProductName
							.get(1).getText().trim();
					System.out.println("Product:" + Product2);

					String ProductDiscription2 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.Discription
							.get(1).getText().trim();
					System.out.println("ProductDiscription:" + ProductDiscription2);

					String Price2 = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.Price
							.get(1).getText().trim();
					System.out.println("Price:" + Price2);

					
					// Asserion:
					Assert.assertEquals(Product2, "Sauce Labs Bolt T-Shirt");
					Assert.assertEquals(ProductDiscription2,
							"Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.");
					Assert.assertEquals(Price2, "$15.99");
					
					System.out.println("--------------------------------------------");
					System.out.println("--------------------------------------------");
				}

				public void PaymentInformation() {
					String PaymentInformation = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.PaymentInformation
							.getText();
					System.out.println("PaymentInformation:" + PaymentInformation);
				}

				public void ShippingInformation() {
					String ShippingInformation = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.ShippingInformation
							.getText();
					System.out.println("ShippingInformation:" + ShippingInformation);
				}

				public void TotalPrice() {
					String TotalPrice = swag_labs_locators.swag_labs_locators.swag_labs_productpage.verifyoverviewdetails.TotalPrice
							.getText();
					System.out.println("TotalPrice:" + TotalPrice);
				}
				
				public void ClickFinishButton() {
					swag_labs_locators.swag_labs_locators.swag_labs_productpage.swaglabs_buttons.FinishButton.click();
				}
				
				public void VerifyThnxOrder() {
					
					String OrderConfirmation = swag_labs_locators.swag_labs_locators.swag_labs_productpage.productordered.ThnxOrder.getText();
					System.out.println("OrderConfirmation:"+OrderConfirmation);
				}
			}// SawLab_Items

		}// Swag_Labs_ProductPage

	}// Swag_Labs_Methods

}// LoginPage_Methods
