package com.cucumberFramework.configreader;

import java.util.Properties;

import org.openqa.selenium.remote.BrowserType;

import com.cucumberFramework.utlity.ResourceHelper;

public class PropertyFileReader implements ConfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return prop.getProperty("Username");
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return prop.getProperty("Password");
	}

	public String getWebsite() {
		// TODO Auto-generated method stub
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public BrowserType getBrowser() {
		// TODO Auto-generated method stub
		return null;
	}
}
