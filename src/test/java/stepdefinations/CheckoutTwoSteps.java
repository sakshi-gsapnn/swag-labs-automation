package stepdefinations;

import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutTwoSteps {

	@Given("I am on the Checkout Two page")
	public void iAmOnTheCheckoutTwoPage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-two.html"),
				"Expected to be on checkout step two page but was: " + currentUrl);
	}

	@When("I click Finish button")
	public void iClickFinishButton() {

		WebDriverFactory.getCheckout_TwoDriver().clickFinish();
	}

	@Then("I will go to the checkout complete page")
	public void iWillGoToTheCheckoutCompletePage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-complete.html"),
				"Expected to be on checkout complete page but was: " + currentUrl);
	}

	@When("I click menu button")
	public void iClickmenubutton() throws InterruptedException {
		WebDriverFactory.getCheckout_TwoDriver().clickmenubutton();
		Thread.sleep(5000);
	}

	@And("I click Allpages")
	public void iClickAllpages() throws InterruptedException {
		WebDriverFactory.getCheckout_TwoDriver().clickonAllitems();
		// Thread.sleep(5000);
	}

	@And("I click About")
	public void iClickonAbout() {
		WebDriverFactory.getCheckout_TwoDriver().clickonAbout();
	}

	@And("I click Logout")
	public void iClickonLogout() {
		WebDriverFactory.getCheckout_TwoDriver().clickonlogout();
	}

	@And("I click ResetAppState")
	public void iClickonResetAppstate() {
		WebDriverFactory.getCheckout_TwoDriver().clickResetApp();
	}

	@Then("I will go to sauce main website")
	public void iWillGotoSaucewebsite() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("saucelabs"),
				"Expected to be on inventory item page but was: " + currentUrl);
	}

	@Then("I will go to login page")
	public void iWillGotoLoginpage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("saucedemo.com"),
				"Expected to be on inventory item page but was: " + currentUrl);
	}
}
