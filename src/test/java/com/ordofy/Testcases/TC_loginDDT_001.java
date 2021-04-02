package com.ordofy.Testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.ordofy.pageObjects.LoginPage;
import com.ordofy.utilities.XLUtils;

public class TC_loginDDT_001 extends BaseClass
{

	
	@Test(dataProvider="LoginData")
	public void DDTlogin(String USERNAME,String PASSWORD) throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.Enter_text_in_Username_feild(USERNAME);
		logger.info("entered username");
		lp.Enter_text_in_Password_feild(PASSWORD);
		logger.info("entered password");
		lp.Click_Login_button();
		logger.info("user LOGGED IN");
		
		if(driver.getCurrentUrl().equals("https://www.ordofy.com/sellerDashboard"))
		{
			Assert.assertTrue(true);
			logger.info("Login testcase passed");
		    lp.Click_on_accountCircle();
			logger.info("Clicked on Account cirlce");
			lp.Click_Login_button();
			logger.info("Logged out sucessfully");
			
		}
		else
		{
			captureScreenshot(driver,"testcases");
			Assert.assertTrue(false);
			logger.info("Login testcase failed");
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ordofy/Testdata/Sheet1.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
}
