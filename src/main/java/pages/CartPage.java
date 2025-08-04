package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.WebDriverFactory;

public class CartPage {
	private By cartItems = By.className("cart_item");
	private By removeButtons = By.xpath("//button[contains(@id,'remove')]");
	private By continueShopping = By.id("continue-shopping");
	private By checkoutButton = By.id("checkout");

	/**
	 * Clicks the inventory item link at the given index in the cart
	 */
	public void clickItemAtIndex(int index) {
		List<WebElement> names = WebDriverFactory.getDriver().findElements(By.className("inventory_item_name"));
		names.get(index).click();
	}

	public List<WebElement> getCartItems() {
		return WebDriverFactory.getDriver().findElements(cartItems);
	}

	public void clickRemoveAtIndex(int index) {
		WebDriverFactory.getDriver().findElements(removeButtons).get(index).click();
	}

	public void clickContinueShopping() {
		WebDriverFactory.getDriver().findElement(continueShopping).click();
	}

	public void clickCheckout() {
		WebDriverFactory.getDriver().findElement(checkoutButton).click();
	}

	// Add to your existing CartPage.java
	public String getItemPrice(int index) {
		List<WebElement> prices = WebDriverFactory.getDriver().findElements(By.className("inventory_item_price"));
		return prices.get(index).getText();
	}

	public String getItemName(int index) {
		List<WebElement> names = WebDriverFactory.getDriver().findElements(By.className("inventory_item_name"));
		return names.get(index).getText();
	}

}
