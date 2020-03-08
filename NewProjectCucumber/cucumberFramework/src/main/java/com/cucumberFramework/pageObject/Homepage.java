package com.cucumberFramework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.WaitHelper;

 public class Homepage {
	
	    private WebDriver driver;
		WaitHelper WaitHelper;
	//declaration
	@FindBy(xpath="//span[contains(text(),' Administrator')]")
	 WebElement Administrator;
	
	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Leads']")
	WebElement leadsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Organizations']")
	WebElement organizationsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//table[@class='hdrTabBg']/tbody/tr//td/a[text()='Opportunities']")
	WebElement opportunitiesLInk;

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	WebElement leadsButton;
	//Initialization
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    WaitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(Administrator, 60);
	}
	//Utilization
	public WebElement getAdministrator() {
		WaitHelper.WaitForElement(Administrator, Constants.getExplicitwait());
		return Administrator;
	}
	public void setAdministrator(WebElement administrator) {
		this.Administrator = administrator;
	}
	
	/*public WebElement getAdmi(String a){
		return Administrator;	
	}
	
	public void setAdmi(WebElement a){
		this.Administrator=a;	
	}*/
	public LeadsCreationsPage navigateToLeads() {
		leadsLink.click();
		return new LeadsCreationsPage(driver);
	}

	public Organizations navigateToOrganizations() {
		organizationsLink.click();
		return new Organizations(driver);
	}

	public void navigateToContacts() {
		contactsLink.click();
	}

	public void navigateToOpportunities() {
		opportunitiesLInk.click();
	}

	
}
