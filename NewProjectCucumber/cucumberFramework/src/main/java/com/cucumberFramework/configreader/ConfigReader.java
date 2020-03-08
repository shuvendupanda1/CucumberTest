package com.cucumberFramework.configreader;

import org.openqa.selenium.remote.BrowserType;

public interface ConfigReader {

	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}
