package com.ordofy.Testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import com.ordofy.pageObjects.LoginPage;

public class TC_loginpage extends BaseClass
{
	
	@Test
	public void testcases() throws IOException, InterruptedException
	{
		driver.get(URL);
		logger.info("URL opened");
	
		LoginPage Lp = new LoginPage(driver);
		Lp.Enter_text_in_Username_feild(Email);
		logger.info("entered username");
		
		Lp.Enter_text_in_Password_feild(Password);
		logger.info("enterd password");
		Lp.Click_Login_button();
		Thread.sleep(5000);
		String Currenturl= driver.getCurrentUrl();
		System.out.println(Currenturl);
		
	
		
		if(driver.getCurrentUrl().equals("https://www.ordofy.com/sellerDashboard"))
		{
			Assert.assertTrue(true);
			logger.info("Login testcase passed");
		}
		else
		{
			captureScreenshot(driver,"testcases");
			Assert.assertTrue(false);
			logger.info("Login testcase failed");
		}
	}
	
}

