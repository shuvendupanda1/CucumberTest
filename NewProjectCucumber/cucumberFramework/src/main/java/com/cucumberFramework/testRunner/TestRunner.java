package com.cucumberFramework.testRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = "src/test/resources/features",tags={"@sanity1"}, 
glue = {"com\\cucumberFramework\\steepDefinations"},
                 plugin = { "pretty",
				"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt" })
public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void SetUpClass() 
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Run all Cucumber features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	@DataProvider
	public Object[][] features() {
			return testNGCucumberRunner.provideFeatures();
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		testNGCucumberRunner.finish();
	}
}
// at first i create a testNG suit file and what ever test case name same name should be feature file
// name then it will trigger TestRunner class, inside that we are defined @CucumberOptions it contains 
//features(features location ,glue=step definitions location and Reports like Html,json & text ) 
//create one method SetUpClass and tearDown
//What are Hooks in Cucumber?
/*Cucumber supports hooks, which are blocks of code that run before or after each scenario. 
 * You can define them anywhere in your project or step definition layers,
 *  using the methods @Before and @After. Cucumber Hooks allows us to better manage the code workflow and 
 *  helps us to reduce the code redundancy. We can say that it is an unseen step, which allows us to perform our scenarios or tests.
Why Cucumber Hooks?
In the world of testing, you must have encountered the situations where you need to perform the prerequisite 
steps before testing any test scenario. This prerequisite can be anything from:
Starting a webdriver
Setting up DB connections
Setting up test data
Setting up browser cookies
Navigating to certain page
or anything before the test
In the same way there are always after steps as well of the tests like:
Killing the webdriver
Closing DB connections
Clearing the test data
Clearing browser cookies
Logging out from the application
Printing reports or logs
Taking screenshots on error
or anything after the test*/

//ServicesHooks
//in ServicesHooks first of all i will create one object testBase in side that i will create two methods
// like initializeTest method is used lunching the browser and defined @before ,This will run before the Scenario
// second one endTest method is used it will run after the Scenario

//Reember
/*An important thing to note about the after hook is that even in case of test fail, after hook will execute for sure.
Method name can be anything, need not to be beforeScenario() or afterScenario(). can also be named as setUp() and tearDown().
Make sure that the package import statement should be import cucumber.api.java.After; & import cucumber.api.java.Before;*/













