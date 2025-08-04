package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutOneSteps {

	@Given("I am on the Checkout One page")
	public void iAmOnTheCheckoutOnePage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-one.html"),
				"Expected to be on checkout step one page but was: " + currentUrl);
	}

	@When("I enter my first name {string}")
	public void iEnterMyFirstName(String firstName) {

		WebDriverFactory.getCheckout_OneDriver().enterFirstName(firstName);
	}

	@When("I enter my last name {string}")
	public void iEnterMyLastName(String lastName) {
		WebDriverFactory.getCheckout_OneDriver().enterLastName(lastName);
	}

	@When("I enter my postal code {string}")
	public void iEnterMyPostalCode(String postalCode) {

		WebDriverFactory.getCheckout_OneDriver().enterPostalCode(postalCode);
	}

	@When("I click Continue button")
	public void iClickContinueButton() {

		WebDriverFactory.getCheckout_OneDriver().clickContinue();
	}

	//
	@When("I leaves First Name blank")
	public void leavesFirstNameBlank() {

		WebDriverFactory.getCheckout_OneDriver().enterFirstName("");

	}

	@When("I leaves Last Name blank")
	public void leavesLastNameBlank() {

		WebDriverFactory.getCheckout_OneDriver().enterLastName("");

	}

	@And("leaves Zip Code blank")
	public void leavesZipBlank() {

		WebDriverFactory.getCheckout_OneDriver().enterPostalCode("");

	}

	@Then("the error message {string} should be displayed")
	public void verifyErrorMessage(String msg) {

		String actualError = WebDriverFactory.getDriver().findElement(By.cssSelector("h3[data-test='error']"))
				.getText();
		Assert.assertEquals(msg, actualError);

	}

	@When("I click Cancel button")
	public void iClickCancelButton() {

		WebDriverFactory.getCheckout_OneDriver().clickCancel();
	}

	@Then("I will go to the Checkout Two page")
	public void iWillGoToTheCheckoutTwoPage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-two.html"),
				"Expected to be on checkout step two page but was: " + currentUrl);
	}
}

