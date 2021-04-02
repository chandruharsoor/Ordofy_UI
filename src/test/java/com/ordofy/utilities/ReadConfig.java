package com.ordofy.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try
		{
			FileInputStream file= new FileInputStream(src);
			pro= new Properties();
			pro.load(file);
		}
		catch (Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("URL");
		return url;
	}
	public String getUserName()
	{
		String Username=pro.getProperty("Email");
		return Username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("Password");
		return password;
	}
	public String getchromepath()
	{
		String chropath=pro.getProperty("chromepath");
		return chropath;
	}
	public String getFirefoxpath()
	{
		String firepath=pro.getProperty("Firefoxpath");
		return firepath;
	} 

}
		 
		
	



 