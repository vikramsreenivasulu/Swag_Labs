package Swag_ActionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
			
				public String getRandomUser() {
				
				    String text = swag_labs_locators.swag_labs_locators
				                    .swag_labs_loginpage.loginCredentials.getText();
				
				    String[] users = text.split("\n");
				
				    List<String> userList = new ArrayList<>();
				    
				    for(int i = 1; i < users.length; i++) {
				        userList.add(users[i].trim());
				    }
				
				    Random rand = new Random();
				    int randomIndex = rand.nextInt(userList.size());
				
				    String randomUser = userList.get(randomIndex);
				
				    System.out.println("Selected User: " + randomUser);
				
				    swag_labs_locators.swag_labs_locators.swag_labs_loginpage.SendUserId.sendKeys(randomUser);
				    
				    return randomUser;
				 
				}
			
			public void Password() {
				String text = swag_labs_locators.swag_labs_locators.swag_labs_loginpage.Password.getText();
				
				String[] parts = text.split("\n");
				String password = parts[1];

				System.out.println("Password: "+password);
				
				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.SendPassword.sendKeys(password);
			}
			public void ClickLoginBotton() {
				swag_labs_locators.swag_labs_locators.swag_labs_loginpage.LoginButton.click();
			}
			
			
		}
		
		
		
		
	}//Swag_Labs_Methods
	
	
	
	
	
	
}//LoginPage_Methods
