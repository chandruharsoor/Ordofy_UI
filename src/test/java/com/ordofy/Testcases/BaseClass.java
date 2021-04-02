package com.ordofy.Testcases;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.ordofy.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig RConfig= new ReadConfig();
	
	public String URL=RConfig.getApplicationURL();
	public String Email=RConfig.getUserName();
	public String Password=RConfig.getPassword();
	public static WebDriver driver;  
	public static Logger logger;
		
	@Parameters({"browser"})
	@BeforeClass
		public void setup(String br)
{
					
		logger= Logger.getLogger("ORDOFY");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver",RConfig.getchromepath());
		    driver= new ChromeDriver();
		}
		else if(br.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver",RConfig.getFirefoxpath());
			driver= new FirefoxDriver();
		}
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		

		
	}
	public void captureScreenshot(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	

} 
