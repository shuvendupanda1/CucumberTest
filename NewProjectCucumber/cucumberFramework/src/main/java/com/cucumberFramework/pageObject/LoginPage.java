package com.cucumberFramework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.WaitHelper;

public class LoginPage  {
	

	//Deceleration
	@FindBy(name="user_name")
	private WebElement UNTB;
	
	@FindBy(name="user_password")
	private WebElement PasswordTB;
	
	@FindBy(id="submitButton")
	private WebElement LoginBTN;
	
	WaitHelper waitHelper;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	    waitHelper=new WaitHelper(driver);
		//waitHelper.WaitForElement(UNTB, 60);
	}
	public WebElement setUserName()
	{
		return UNTB;	
	}

	public void GetUserName(String userName)
	{
		 this.UNTB.sendKeys(userName);
		// return userName;
	}
	
	public WebElement setPasswprd(){
		return PasswordTB;
	}
	
	public void  EnterPasswprd(String password){
		this.PasswordTB.sendKeys(password);
	}
	
	public void ClickLogin(){
		LoginBTN.click();
	}
	
}
