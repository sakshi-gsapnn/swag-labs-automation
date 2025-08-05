package stepdefinations;

import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutCompleteSteps {

	@Given("I am on the Checkout Complete page")
	public void iAmOnTheCheckoutCompletePage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-complete.html"),
				"Expected to be on checkout complete page but was: " + currentUrl);
	}

	@When("I click back home button")
	public void iClickBackHomeButton() {

		WebDriverFactory.getCheckoutCompleteDriver().clickBackHome();
	}

	@Then("I will go to the Inventory Page")
	public void iWillGoToTheInventoryPage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"),
				"Expected to be on inventory page but was: " + currentUrl);
	}

	@When("I click cart icon")
	public void iClickCartIcon() {

		WebDriverFactory.getCheckoutCompleteDriver().clickCartIcon();
	}

	@Then("I will go to the Your Cart page")
	public void iWillGoToTheYourCartPage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("cart.html"), "Expected to be on cart page but was: " + currentUrl);
	}

	@Then("the cart will be empty")
	public void theCartWillBeEmpty() {

		int itemCount = WebDriverFactory.getcartDriver().getCartItems().size();
		Assert.assertEquals(itemCount, 0, "Expected cart to be empty but found " + itemCount + " items");
	}

	@Then("the order placed should be displayed")
	public void iwillbecompleteBooking() {
		String Actualtext = WebDriverFactory.getCheckoutCompleteDriver().getThetextCompleted();
		Assert.assertTrue(Actualtext.contains("Thank you for your order!"), "The Text Expected  was: " + Actualtext);
	}

	@When("I click menu button on Checkout Complete page")
	public void iClickmenubutton() throws InterruptedException {
		WebDriverFactory.getCheckoutCompleteDriver().clickmenubutton();

	}

	@And("I click Allpages on Checkout Complete page")
	public void iClickAllpages() throws InterruptedException {
		WebDriverFactory.getCheckoutCompleteDriver().clickonAllitems();

	}

	@And("I click About on Checkout Complete page")
	public void iClickonAbout() {
		WebDriverFactory.getCheckoutCompleteDriver().clickonAbout();
	}

	@And("I click Logout on Checkout Complete page")
	public void iClickonLogout() {
		WebDriverFactory.getCheckoutCompleteDriver().clickonlogout();
	}

	@And("I click ResetAppState on Checkout Complete page")
	public void iClickonResetAppstate() {
		WebDriverFactory.getCheckoutCompleteDriver().clickResetApp();
	}

}
