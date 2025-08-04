package stepdefinations;

import driver.WebDriverFactory;

import io.cucumber.java.After;

import io.cucumber.java.Before;

public class Hooks {

	@Before

	public void setup() {

		WebDriverFactory.initDriver();

	}

	@After

	public void tearDown() {

		WebDriverFactory.quitDriver();

	}

}
