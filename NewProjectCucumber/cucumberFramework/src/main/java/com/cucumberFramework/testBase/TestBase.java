package com.cucumberFramework.testBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.cucumberFramework.utlity.DateTimeHelper;
import com.cucumberFramework.utlity.ResourceHelper;
import com.cucumberFramework.configreader.ObjectRepo;
import com.cucumberFramework.configreader.PropertyFileReader;
import com.cucumberFramework.enums.Browser;
import com.cucumberFramework.enums.Os;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.Browser.ChromeBrowser;
import com.cucumberFramework.helper.Browser.FirefoxBrowser;
import com.cucumberFramework.helper.Browser.IExploreBrowser;
//import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class TestBase  {

	private final Logger log =LoggerHelper.getLogger(TestBase.class);
	public static WebDriver driver;

	public WebDriver SelectBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(Os.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browser.CHROME.name())) {
				String currDir = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver",
						currDir+"/src/test/resources/Driver/chromedriver.exe");
				log.info("*************Lunch Chrome Browser**********");
				driver=new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "src\\test\\resources\\Driver\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
		}
		if (System.getProperty("os.name").toLowerCase().contains(Os.MAC.name().toLowerCase())) {
			if (browser.contains(Browser.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "src\\test\\resources\\Driver\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase(Browser.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "src\\test\\resources\\Driver\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
		}
		return driver;
	}
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.until(elementLocated(element));
	}
	private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
		return new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				log.debug("Waiting for Element : " + element);
				return element.isDisplayed();
			}
		};
	}
	public String takeScreenShot(String name) throws IOException {

		File destDir = new File(ResourceHelper.getResourcePath("screenshots/") + DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
		log.info(destPath.getAbsolutePath());
		return destPath.getAbsolutePath();
	}

	public WebElement getElement(By locator) {
		log.info(locator);
		if (IsElementPresentQuick(locator))
			return driver.findElement(locator);

		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			log.error(re);
			throw re;
		}
	}
	public WebElement getElementWithNull(By locator) {
		log.info(locator);
		try {
			return driver.findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public boolean IsElementPresentQuick(By locator) {
		boolean flag = driver.findElements(locator).size() >= 1;
		log.info(flag);
		return flag;
	}
	public WebDriver getBrowserObject(Browser bType) throws Exception {
		try {
			log.info(bType);

			switch (bType) {

			case CHROME:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case FIREFOX:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());

			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore.getIExplorerCapabilities());
			default:
				throw new Exception(" Driver Not Found : " + new PropertyFileReader().getBrowser());
			}
		} catch (Exception e) {
			log.equals(e);
			throw e;
		}
	}
	
	public void setUpDriver(Browser bType) throws Exception {
		
		driver = getBrowserObject(bType);
		log.debug("InitializeWebDrive : " + driver.hashCode());
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	/*@Before()
	public void before() throws Exception {
		ObjectRepo.reader = new PropertyFileReader();
		setUpDriver(ObjectRepo.reader.getBrowser());
		log.info(ObjectRepo.reader.getBrowser());
	}*/

	private void setUpDriver(BrowserType browser) {
		// TODO Auto-generated method stub
		
	}
	/*@After()
	public void after(Scenario scenario) throws Exception {
		//driver.quit();
		log.info("");
	}*/
}
