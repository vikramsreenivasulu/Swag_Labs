package Swag_Locators;

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

		public Swag_Labs_Locators() {
			PageFactory.initElements(BaseClass.driver, this);
		}
	
		@FindBy(xpath="//input[@class='submit-button btn_action']")
		public WebElement xxx;
	
	}
}
