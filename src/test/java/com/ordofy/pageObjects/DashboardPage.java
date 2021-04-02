package com.ordofy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	 WebDriver driver=null;
	 
	 By Account_circle= By.xpath("/html/body/app-root/div/app-seller-layout/seller-header/div[1]/div[2]/div[1]/div[2]/div[2]/span/i");
	 
	 public DashboardPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void Click_on_accountCircle()
	 {
	    driver.findElement(Account_circle).click();
	 }

}
