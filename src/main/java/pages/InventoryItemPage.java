package pages;

import org.openqa.selenium.By;
import driver.WebDriverFactory;

public class InventoryItemPage {

	private By itemImage = By.className("inventory_details_img");
	private By itemName = By.className("inventory_details_name");
	private By itemDescription = By.className("inventory_details_desc");
	private By itemPrice = By.className("inventory_details_price");
	private By addToCartButton = By.cssSelector("button.btn_inventory");
	private By backButton = By.id("back-to-products");

	public String getItemName() {
		return WebDriverFactory.getDriver().findElement(itemName).getText();
	}

	public String getItemDescription() {
		return WebDriverFactory.getDriver().findElement(itemDescription).getText();
	}

	public String getItemPrice() {
		return WebDriverFactory.getDriver().findElement(itemPrice).getText();
	}

	public String getItemImageSrc() {
		return WebDriverFactory.getDriver().findElement(itemImage).getAttribute("src");
	}

	public void clickAddToCart() {
		WebDriverFactory.getDriver().findElement(addToCartButton).click();
	}

	public void clickBackToProducts() {
		WebDriverFactory.getDriver().findElement(backButton).click();
	}

	public void meanuButton() {

	}
}
