package runner;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepdefinations", plugin = { "pretty",
		"html:target/cucumber.html" }, monochrome = true

)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}