package Swag_Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class Loginpage_Locators {
	
	public Swag_Labs_Locators swag_labs_locators;
	

	public Loginpage_Locators() {
		
		swag_labs_locators = new Swag_Labs_Locators();
		
	}
	
	public class Swag_Labs_Locators{

		public Swag_Labs_LoginPage swag_labs_loginpage;
		public Swag_Labs_ProductPage swag_labs_productpage;
		public Swag_Labs_Locators() {
			
			PageFactory.initElements(BaseClass.driver, this);
			swag_labs_loginpage = new Swag_Labs_LoginPage();
			swag_labs_productpage = new Swag_Labs_ProductPage();
		}
	
		public class Swag_Labs_LoginPage{
			
			public Swag_Labs_LoginPage() {
				PageFactory.initElements(BaseClass.driver, this);
			}
			
			@FindBy(xpath = "//div[@id='login_credentials']")
			public WebElement loginCredentials;
			
			@FindBy(xpath="//div[@class='login_password']")
			public WebElement Password;
			
			@FindBy(xpath="(//input[contains(@class,'input_error form_input')])[1]")
			public WebElement SendUserId;
			
			@FindBy(xpath="(//input[@class='input_error form_input'])[2]")
			public WebElement SendPassword;
			
			@FindBy(xpath="//input[@class='submit-button btn_action']")
			public WebElement LoginButton;
			
			
		}//Swag_Labs_LoginPage
		
	
		public class Swag_Labs_ProductPage{
			
			public SideBarLocators sidebarlocators;
			public SwagLabs_Buttons swaglabs_buttons;
			public SwagLabs_Items swaglabs_items;
			public Swag_Labs_ProductPage() {
				PageFactory.initElements(BaseClass.driver, this);
				sidebarlocators = new SideBarLocators();
				swaglabs_buttons = new SwagLabs_Buttons();
				swaglabs_items = new SwagLabs_Items();
			}
			
			public class SwagLabs_Buttons{
				
				public SwagLabs_Buttons() {
					PageFactory.initElements(BaseClass.driver, this);
				}
				
				@FindBy(id="react-burger-menu-btn")
				public WebElement MenuButton;
			}
			
			
			public class SideBarLocators{
				
				public SideBarLocators() {
					PageFactory.initElements(BaseClass.driver, this);
				}
				
				@FindBy(xpath="//a[@id='inventory_sidebar_link']")
				public WebElement Hover_AllItems;
				
				@FindBy(id="about_sidebar_link")
				public WebElement Hover_About;
				
				@FindBy(id="logout_sidebar_link")
				public WebElement Hover_Logout;
				
				@FindBy(id="reset_sidebar_link")
				public WebElement Hover_ReserAppStore;
				
				@FindBy(id="react-burger-cross-btn")
				public WebElement CrossButton;
				
			}//SidebarLocators
			
			public class SwagLabs_Items{
				
				public SwagLabs_Items() {
					PageFactory.initElements(BaseClass.driver, this);
				}
				
				
				@FindBy(xpath="//div[@data-test='inventory-item-name']")
				public WebElement ProductName;
				
				@FindBy(xpath="//div[@data-test='inventory-item-desc']")
				public WebElement ProductsDisc;
				
				@FindBy(xpath="//div[@data-test='inventory-item-price']")
				public WebElement ProductsPrice;
				
				
				@FindBy(id="back-to-products")
				public WebElement BackToProduct;
				
			}//SwagLabs_Items
			
			
			
			
			
			
		}//Swag_Labs_ProductPage
		
		
		
		
	}//Swag_Labs_Locators
}
