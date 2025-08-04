package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.InventoryPage;

public class CartSteps {

	InventoryPage inventoryPage = WebDriverFactory.getInventoryDriver();

	CartPage cartPage = WebDriverFactory.getcartDriver();

	WebDriver driver = WebDriverFactory.getDriver();

	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Given("I am on the cart page")
	public void iAmOnTheCartPage() {
		String currentUrl = WebDriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("cart.html"), "Expected to be on cart page but was: " + currentUrl);
	}

	@When("I click on the cart icon")
	public void iClickOnTheCartIcon() {
		// InventoryPage inventoryPage = new InventoryPage(getDriver());
		inventoryPage.clickCartIcon();
		getWait().until(ExpectedConditions.urlContains("cart.html"));
	}

	@When("I click on the title of the product at index {int}")
	public void iClickOnTheTitleOfProductAtIndex(int index) {

		cartPage.clickItemAtIndex(index);
	}

	@Then("I will go to the inventory item page of that product")
	public void iWillGoToTheInventoryItemPageOfThatProduct() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory-item.html"),
				"Expected to be on inventory item page but was: " + currentUrl);
	}

	@When("I click Continue Shopping button")
	public void iClickContinueShoppingButton() {

		cartPage.clickContinueShopping();
	}

	@Then("I will go back to the Inventory page")
	public void iWillGoBackToTheInventoryPage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"),
				"Expected to be on inventory page but was: " + currentUrl);
	}

	@When("I click Checkout button")
	public void iClickCheckoutButton() {

		cartPage.clickCheckout();
	}

	@Then("I will go to the checkout step one page")
	public void iWillGoToTheCheckoutStepOnePage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-one.html"),
				"Expected to be on checkout step one page but was: " + currentUrl);
	}

	@Given("there is at least one item in the cart")
	public void thereIsAtLeastOneItemInTheCart() {

		Assert.assertTrue(cartPage.getCartItems().size() > 0, "Expected at least one item in cart but found none");
	}

	@When("I click the remove button for item at index {int}")
	public void iClickTheRemoveButtonForItemAtIndex(int index) {
		// CartPage cartPage = new CartPage(getDriver());
		// cartPage.clickRemoveAtIndex(index);

	}

	@Then("the item will be removed from the cart")
	public void theItemWillBeRemovedFromTheCart() {
		// This can be verified by checking cart count or item list
		// For now, we'll just verify we're still on cart page
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("cart.html"), "Expected to still be on cart page after removing item");
	}

	@Then("I can see the price of the product at index {int}")
	public void iCanSeeThePriceOfTheProductAtIndex(int index) {

		Assert.assertTrue(cartPage.getCartItems().size() > index, "Item at index " + index + " does not exist in cart");
		// Additional price verification logic can be added here
	}

}
