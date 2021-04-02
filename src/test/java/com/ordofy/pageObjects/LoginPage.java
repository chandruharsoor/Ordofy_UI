package com.ordofy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author CHANDRASHEKAR
 *
 */

public class LoginPage {

	 WebDriver driver=null;

	 By UsernametextBox= By.id("userName");
	 By PasswordtextBox= By.xpath("//input[@type='password']");
	 By Login_buton= By.xpath("//input[@value='LOG IN']");
	 By Signup_button=By.xpath("/html/body/app-root/div/app-login/div[1]/div/div/div[2]/form/div/div[3]/input[2]");
	 By forgot_pass_link = By.xpath("/html/body/app-root/div/app-login/div[1]/div/div/div[2]/form/div/div[2]/div");
	 By Logout_Button= By.xpath("/html/body/app-root/div/app-seller-layout/seller-header/div[1]/div[2]/div[1]/div[2]/div[2]/div/ul/li[4]/a");
	 By Account_circle= By.xpath("/html/body/app-root/div/app-seller-layout/seller-header/div[1]/div[2]/div[1]/div[2]/div[2]/span/i");
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void Enter_text_in_Username_feild(String text)
	 {
	    driver.findElement(UsernametextBox).sendKeys(text);  
	 }
	
	 public void Enter_text_in_Password_feild(String text)
	 {
		 driver.findElement(PasswordtextBox).sendKeys(text);
	 }
	 
	 public void Click_Login_button()
	 {
		 driver.findElement(Login_buton).click(); 
	 }
	 
	 public void Click_Signup_button()
	 {
		 driver.findElement(Signup_button).click();
	 }
	 
	 public void Click_Link()
	 {
		 driver.findElement(forgot_pass_link).click();
	 }
	 public void Click_logout()
	 {
		 driver.findElement(Logout_Button).click();
	 }
	 public void Click_on_accountCircle()
	 {
	    driver.findElement(Account_circle).click();
	 }

}
