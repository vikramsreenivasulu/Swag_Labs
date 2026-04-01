package Swag_ActionMethods;

import java.util.List;

import org.openqa.selenium.WebElement;

import Swag_Locators.Loginpage_Locators;

public class LoginPage_Methods {

	public Swag_Labs_Methods swag_labs_methods;
	
	
	public LoginPage_Methods() {
		
		swag_labs_methods = new Swag_Labs_Methods();
	}
	
	public Loginpage_Locators swag_labs_locators = new Loginpage_Locators();
	public class Swag_Labs_Methods{
		
		public Swag_Labs_LoginPage swag_labs_loginpage;
		public Swag_Labs_Methods() {
			swag_labs_loginpage = new Swag_Labs_LoginPage();
		}
		public class Swag_Labs_LoginPage{
			
			public void UserIds() {
			
				String text = swag_labs_locators.swag_labs_locators.swag_labs_loginpage.loginCredentials.getText();

				// Split by new line
				String[] users = text.split("\n");

				// First line is heading → skip it
				for(int i = 1; i < users.length; i++) {
				    System.out.println(users[i]);
				}

				Password();
			}
			
			public void Password() {
				String text = swag_labs_locators.swag_labs_locators.swag_labs_loginpage.Password.getText();
				
				String[] parts = text.split("\n");
				String password = parts[1];

				System.out.println("Password: "+password);
			}
			public void ClickLoginBotton() {
				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.LoginButton.click();
			}
			
			
		}
		
		
		
		
	}//Swag_Labs_Methods
	
	
	
	
	
	
}//LoginPage_Methods
