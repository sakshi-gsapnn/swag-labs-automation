package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryItemPage;
import pages.InventoryPage;

import pages.LoginPages;

public class InventoryBrowsingSteps {
	private WebDriver driver = WebDriverFactory.getDriver();
	private InventoryPage inventory = WebDriverFactory.getInventoryDriver();;
	private InventoryItemPage itemPage = WebDriverFactory.getInventoryItemPageDriver();
	private int currentIndex;
	private int itemsInCartBeforeAction = 0;

	private LoginPages loginpage = WebDriverFactory.getloginDriver();

	// Constructor ensures proper setup
	public InventoryBrowsingSteps() {
		ensureLoggedInAndOnInventory();
	}

	private void ensureLoggedInAndOnInventory() {
		String currentUrl = driver.getCurrentUrl();

		if (!currentUrl.contains("inventory.html")) {
			driver.get("https://www.saucedemo.com");
			loginpage.enterUsername("standard_user");
			loginpage.enterPassword("secret_sauce");
			loginpage.clickLogin();
		}

		if (!driver.getCurrentUrl().contains("inventory.html")) {
			inventory.open();
		}
	}

	@When("I click the product image {int}")
	public void clickProductImage(int idx) {
		ensureLoggedInAndOnInventory(); // Ensure setup before each action
		currentIndex = idx;
		inventory.clickItemImage(idx);

	}

	@When("I click the product name {int}")
	public void clickProductName(int idx) {
		ensureLoggedInAndOnInventory(); // Ensure setup before each action
		currentIndex = idx;
		inventory.clickItemName(idx);

	}

	@Then("I get into the product information page")
	public void verifyOnItemPage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("inventory-item.html"), "Expected item details but was: " + url);
	}

	@Then("The price matches the product")
	public void priceMatches() {
		Assert.assertNotNull(itemPage, "Item page not initialized");
		String itemPagePrice = itemPage.getItemPrice();
		String inventoryPrice = inventory.getPrice(currentIndex);
		Assert.assertEquals(itemPagePrice, inventoryPrice,
				"Price mismatch: Item page shows '" + itemPagePrice + "' but inventory shows '" + inventoryPrice + "'");
	}

	@Then("The product name matches the link")
	public void nameMatches() {
		Assert.assertNotNull(itemPage, "Item page not initialized");
		String itemPageName = itemPage.getItemName();
		String inventoryName = inventory.getName(currentIndex);
		Assert.assertEquals(itemPageName, inventoryName,
				"Name mismatch: Item page shows '" + itemPageName + "' but inventory shows '" + inventoryName + "'");
	}

	@Then("The product image matches the link")
	public void imageMatches() {
		Assert.assertNotNull(itemPage, "Item page not initialized");
		String itemPageImage = itemPage.getItemImageSrc();
		String inventoryImage = inventory.getImageSrc(currentIndex);
		Assert.assertEquals(itemPageImage, inventoryImage,
				"Image mismatch: Item page shows '" + itemPageImage + "' but inventory shows '" + inventoryImage + "'");
	}

	@Then("The product description matches the link")
	public void descriptionMatches() {
		Assert.assertNotNull(itemPage, "Item page not initialized");
		String itemPageDescription = itemPage.getItemDescription();
		String inventoryDescription = inventory.getDescription(currentIndex);
		Assert.assertEquals(itemPageDescription, inventoryDescription, "Description mismatch: Item page shows '"
				+ itemPageDescription + "' but inventory shows '" + inventoryDescription + "'");
	}

	// Sorting steps - UNCHANGED
	@When("I select sort name A to Z from the dropdown list")
	public void sortNameAToZ() {
		inventory.sortByNameAZ();
	}

	@When("I select sort name Z to A from the dropdown list")
	public void sortNameZToA() {
		inventory.sortByNameZA();
	}

	@When("I select sort price low to high from the dropdown list")
	public void sortPriceLowToHigh() {
		inventory.sortByPriceLowHigh();
	}

	@When("I select sort price high to low from the dropdown list")
	public void sortPriceHighToLow() {
		inventory.sortByPriceHighLow();
	}

	@Then("All item sort in ascending order with its name")
	public void verifySortedNameAsc() {
		Assert.assertTrue(inventory.isNameSortedAsc());
	}

	@Then("All item sort in descending order with its name")
	public void verifySortedNameDesc() {
		Assert.assertTrue(inventory.isNameSortedDesc());
	}

	@Then("All item sort in ascending order with its price")
	public void verifySortedPriceAsc() {
		Assert.assertTrue(inventory.isPriceSortedAsc());
	}

	@Then("All item sort in descending order with its price")
	public void verifySortedPriceDesc() {
		Assert.assertTrue(inventory.isPriceSortedDesc());
	}

	// Cart steps - FIXED LOGIC
	@When("I click add to cart button {int}")
	public void clickAddToCart(int idx) {
		ensureLoggedInAndOnInventory();
		currentIndex = idx;
		try {
			itemsInCartBeforeAction = inventory.getCartBadgeCount();
		} catch (Exception e) {
			itemsInCartBeforeAction = 0;
		}
		inventory.clickAddToCart(idx);
	}

	@When("I click remove button {int}")
	public void clickRemove(int idx) {
		ensureLoggedInAndOnInventory();
		currentIndex = idx;
		try {
			itemsInCartBeforeAction = inventory.getCartBadgeCount();
		} catch (Exception e) {
			itemsInCartBeforeAction = 0;
		}
		inventory.clickRemove(idx);
	}

	@Then("{int} button shows remove")
	public void verifyButtonShowsRemove(int idx) {
		Assert.assertTrue(inventory.isRemoveButtonVisible(idx));
	}

	@Then("{int} button shows add to cart")
	public void verifyButtonShowsAdd(int idx) {
		Assert.assertTrue(inventory.isAddButtonVisible(idx));
	}

	@Then("The cart icon show plus one product")
	public void verifyCartCountIncremented() {
		int expectedCount = itemsInCartBeforeAction + 1;
		int actualCount = inventory.getCartBadgeCount();
		Assert.assertEquals(actualCount, expectedCount);
	}

	@Then("The cart icon shows all product amount")
	public void verifyCartAllCount() {
		Assert.assertEquals(inventory.getCartBadgeCount(), inventory.getTotalItems());
	}

	// Missing step patterns from your feature files
	@When("I click add to cart or remove button {int}")
	public void clickAddToCartOrRemove(int idx) {
		clickAddToCart(idx);
	}

	@When("I click {int} add to cart or remove button")
	public void clickIndexedAddToCart(int idx) {
		clickAddToCart(idx);
	}

	@When("I click all products add to cart button")
	public void clickAllAddToCart() throws InterruptedException {
		ensureLoggedInAndOnInventory();
		for (int i = 0; i < inventory.getTotalItems(); i++) {
			inventory.clickAddToCart(i);
			// Thread.sleep(3000);
		}
	}
}
