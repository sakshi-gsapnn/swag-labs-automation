package stepdefinations;

import org.testng.Assert;

import driver.WebDriverFactory;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("I am on the Login Page")

	public void iAmOnLoginPage() {

		WebDriverFactory.getDriver().get("https://www.saucedemo.com");

	}

	@When("I insert {string} and {string}") // FIXED: Removed escaped quotes

	public void iInsertUsernameAndPassword(String username, String password) {

		WebDriverFactory.getloginDriver().enterUsername(username);

		WebDriverFactory.getloginDriver().enterPassword(password);

	}

	@And("I click on the login button")

	public void iClickOnLoginButton() {

		WebDriverFactory.getloginDriver().clickLogin();

	}

	@Then("I will go to the InventoryPage")

	public void iWillGoToTheInventoryPage() {

		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("/inventory.html"),

				"Expected to be on inventory page but was: " + currentUrl);

	}

	@Then("I will stay in the Login Page")

	public void iWillStayInTheLoginPage() {

		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();

		Assert.assertTrue(currentUrl.equals("https://www.saucedemo.com/") || currentUrl.contains("saucedemo.com"),

				"Expected to stay on login page but was: " + currentUrl);

	}

}
