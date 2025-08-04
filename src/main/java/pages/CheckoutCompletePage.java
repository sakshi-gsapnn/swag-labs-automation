package pages;

import org.openqa.selenium.By;

import driver.WebDriverFactory;

public class CheckoutCompletePage {
	private By backHomeButton = By.id("back-to-products");
	private By cartIcon = By.className("shopping_cart_link");

	public void clickBackHome() {
		WebDriverFactory.getDriver().findElement(backHomeButton).click();
	}

	public void clickCartIcon() {
		WebDriverFactory.getDriver().findElement(cartIcon).click();
	}

}
