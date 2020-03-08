package com.cucumberFramework.steepDefinations;
import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObject.LoginPage;
import com.cucumberFramework.testBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginstepDefinations extends TestBase{
	
	LoginPage loginpage=new LoginPage(driver);
	WaitHelper Waithelper;
	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	    Waithelper=new WaitHelper(driver);
	    Waithelper.WaitForElement(loginpage.setUserName(), 60);
	}

	@Then("^I should see Log In Page$")
	public void i_should_see_Log_In_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.setUserName().isDisplayed();
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.GetUserName(arg1);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.EnterPasswprd(arg1);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.ClickLogin();
	}

}
