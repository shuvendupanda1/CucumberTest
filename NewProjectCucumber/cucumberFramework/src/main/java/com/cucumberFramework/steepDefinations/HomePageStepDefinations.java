package com.cucumberFramework.steepDefinations;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObject.Homepage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Then;

public class HomePageStepDefinations  extends TestBase{
	
	Homepage homepage=new Homepage(driver);
	WaitHelper waithelper=new WaitHelper(driver);;
	
	@Then("^I sould see application homepage$")
	public void i_sould_see_application_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage.getAdministrator().isDisplayed();
	}

	@Then("^I sould see administrator text message on home Page$")
	public void i_sould_see_administrator_text_message_on_home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homepage.getAdministrator().isDisplayed();
	}
}
