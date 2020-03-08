package com.cucumberFramework.testBase;

import com.cucumberFramework.pageObject.Homepage;
import com.cucumberFramework.pageObject.LoginPage;

public interface AllObjects {
	
	
	static LoginPage loginPage = new LoginPage(TestBase.driver);
	static Homepage homePage = new Homepage(TestBase.driver);

}
