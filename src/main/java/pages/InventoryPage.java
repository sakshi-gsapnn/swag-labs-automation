package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.WebDriverFactory;

public class InventoryPage {
	WebDriver driver = WebDriverFactory.getDriver();
	private By itemImages = By.cssSelector(".inventory_item .inventory_item_img");
	private By itemNames = By.cssSelector(".inventory_item .inventory_item_name");
	private By itemPrices = By.cssSelector(".inventory_item .inventory_item_price");
	private By itemDescriptions = By.cssSelector(".inventory_item .inventory_item_desc");
	private By sortSelect = By.className("product_sort_container");
	private By facebookIcon = By.xpath("//a[contains(@href,'facebook.com')]");
	private By linkedinIcon = By.xpath("//a[contains(@href,'linkedin.com')]");
	private By twitterIcon = By.xpath("//a[contains(@href,'twitter.com')]");
	private By addToCartButtons = By.cssSelector("button[id^='add-to-cart']");
	private By removeButtons = By.cssSelector("button[id^='remove']");
	private By cartBadge = By.className("shopping_cart_badge");
	private By cartIcon = By.className("shopping_cart_link");
	private By inventoryContainer = By.className("inventory_container");

	public void open() {
		getDriver().get("https://www.saucedemo.com/inventory.html");
		getWait().until(ExpectedConditions.presenceOfElementLocated(inventoryContainer));
		getWait().until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
	}

	private WebDriver getDriver() {
		return WebDriverFactory.getDriver();
	}

	private WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	public void clickCartIcon() {
		getWait().until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}

	public void clickItemImage(int index) {
		List<WebElement> images = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemImages));
		if (index >= images.size()) {
			throw new RuntimeException(
					"Item image index " + index + " is out of bounds. Found " + images.size() + " images.");
		}
		images.get(index).click();
	}

	public void clickItemName(int index) {
		List<WebElement> names = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemNames));
		if (index >= names.size()) {
			throw new RuntimeException(
					"Item name index " + index + " is out of bounds. Found " + names.size() + " names.");
		}
		names.get(index).click();
	}

	public String getPrice(int index) {
		List<WebElement> prices = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemPrices));
		if (prices.isEmpty()) {
			throw new RuntimeException(
					"No price elements found on the page. Make sure you're on the inventory page and logged in.");
		}
		if (index >= prices.size()) {
			throw new RuntimeException(
					"Price index " + index + " is out of bounds. Found " + prices.size() + " prices.");
		}
		return prices.get(index).getText();
	}

	public String getName(int index) {
		List<WebElement> names = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemNames));
		if (names.isEmpty()) {
			throw new RuntimeException(
					"No name elements found on the page. Make sure you're on the inventory page and logged in.");
		}
		if (index >= names.size()) {
			throw new RuntimeException("Name index " + index + " is out of bounds. Found " + names.size() + " names.");
		}
		return names.get(index).getText();
	}

	public String getImageSrc(int index) {
		List<WebElement> images = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemImages));
		if (images.isEmpty()) {
			throw new RuntimeException(
					"No image elements found on the page. Make sure you're on the inventory page and logged in.");
		}
		if (index >= images.size()) {
			throw new RuntimeException(
					"Image index " + index + " is out of bounds. Found " + images.size() + " images.");
		}
		WebElement img = images.get(index).findElement(By.tagName("img"));
		return img.getAttribute("src");
	}

	public String getDescription(int index) {
		List<WebElement> descriptions = getWait()
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemDescriptions));
		if (descriptions.isEmpty()) {
			throw new RuntimeException(
					"No description elements found on the page. Make sure you're on the inventory page and logged in.");
		}
		if (index >= descriptions.size()) {
			throw new RuntimeException("Description index " + index + " is out of bounds. Found " + descriptions.size()
					+ " descriptions.");
		}
		return descriptions.get(index).getText();
	}

	public void clickFacebookIcon() {
		getWait().until(ExpectedConditions.elementToBeClickable(facebookIcon)).click();
	}

	public void clickLinkedinIcon() {
		getWait().until(ExpectedConditions.elementToBeClickable(linkedinIcon)).click();
	}

	public void clickTwitterIcon() {
		getWait().until(ExpectedConditions.elementToBeClickable(twitterIcon)).click();
	}

	public void sortByNameAZ() {
		new Select(getWait().until(ExpectedConditions.elementToBeClickable(sortSelect)))
				.selectByVisibleText("Name (A to Z)");
	}

	public void sortByNameZA() {
		new Select(getWait().until(ExpectedConditions.elementToBeClickable(sortSelect)))
				.selectByVisibleText("Name (Z to A)");
	}

	public void sortByPriceLowHigh() {
		new Select(getWait().until(ExpectedConditions.elementToBeClickable(sortSelect)))
				.selectByVisibleText("Price (low to high)");
	}

	public void sortByPriceHighLow() {
		new Select(getWait().until(ExpectedConditions.elementToBeClickable(sortSelect)))
				.selectByVisibleText("Price (high to low)");
	}

	public boolean isNameSortedAsc() {
		List<WebElement> elements = WebDriverFactory.getDriver().findElements(itemNames);
		List<String> actual = new ArrayList<>();
		for (WebElement e : elements) {
			actual.add(e.getText());
		}
		List<String> expected = new ArrayList<>(actual);
		Collections.sort(expected);
		return actual.equals(expected);
	}

	public boolean isNameSortedDesc() {
		List<WebElement> elements = WebDriverFactory.getDriver().findElements(itemNames);
		List<String> actual = new ArrayList<>();
		for (WebElement e : elements) {
			actual.add(e.getText());
		}
		List<String> expected = new ArrayList<>(actual);
		Collections.sort(expected, Collections.reverseOrder());
		return actual.equals(expected);
	}

	public boolean isPriceSortedAsc() {
		List<WebElement> elements = WebDriverFactory.getDriver().findElements(itemPrices);
		List<Double> actual = new ArrayList<>();
		for (WebElement e : elements) {
			actual.add(Double.parseDouble(e.getText().replace("$", "")));
		}
		List<Double> expected = new ArrayList<>(actual);
		Collections.sort(expected);
		return actual.equals(expected);
	}

	public boolean isPriceSortedDesc() {
		List<WebElement> elements = WebDriverFactory.getDriver().findElements(itemPrices);
		List<Double> actual = new ArrayList<>();
		for (WebElement e : elements) {
			actual.add(Double.parseDouble(e.getText().replace("$", "")));
		}
		List<Double> expected = new ArrayList<>(actual);
		Collections.sort(expected, Collections.reverseOrder());
		return actual.equals(expected);
	}

	public void clickAddToCart(int index) {
		List<WebElement> buttons = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(addToCartButtons));
		if (index >= buttons.size()) {
			throw new RuntimeException(
					"Add to cart button index " + index + " is out of bounds. Found " + buttons.size() + " buttons.");
		}
		buttons.get(index).click();
	}

	public void clickRemove(int index) {
		List<WebElement> buttons = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(removeButtons));
		if (index >= buttons.size()) {
			throw new RuntimeException(
					"Remove button index " + index + " is out of bounds. Found " + buttons.size() + " buttons.");
		}
		buttons.get(index).click();
	}

	public boolean isRemoveButtonVisible(int index) {
		List<WebElement> buttons = WebDriverFactory.getDriver().findElements(removeButtons);
		return index < buttons.size() && buttons.get(index).isDisplayed();
	}

	public boolean isAddButtonVisible(int index) {
		List<WebElement> buttons = WebDriverFactory.getDriver().findElements(addToCartButtons);
		return index < buttons.size() && buttons.get(index).isDisplayed();
	}

	public int getCartBadgeCount() {
		try {
			String text = getWait().until(ExpectedConditions.presenceOfElementLocated(cartBadge)).getText();
			return Integer.parseInt(text);
		} catch (Exception e) {
			return 0;
		}
	}

	public int getTotalItems() {
		return WebDriverFactory.getDriver().findElements(addToCartButtons).size();
	}
}