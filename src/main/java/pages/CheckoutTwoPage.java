package pages;

import org.openqa.selenium.By;

import driver.WebDriverFactory;

public class CheckoutTwoPage {
	private By finishButton = By.id("finish");
	private By cancelButton = By.id("cancel");
	private By cartIcon = By.className("shopping_cart_link");
	private By menubutton = By.id("react-burger-menu-btn");
	private By allItems = By.id("inventory_sidebar_link");
	private By About = By.id("about_sidebar_link");
	private By logoutbtn = By.id("logout_sidebar_link");
	private By ResetAppState = By.id("reset_sidebar_link");

	public void clickFinish() {
		WebDriverFactory.getDriver().findElement(finishButton).click();
	}

	public void clickCancel() {
		WebDriverFactory.getDriver().findElement(cancelButton).click();
	}

	public void clickCartIcon() {
		WebDriverFactory.getDriver().findElement(cartIcon).click();
	}

	public void clickmenubutton() {
		WebDriverFactory.getDriver().findElement(menubutton).click();
	}

	public void clickonAllitems() throws InterruptedException {
		WebDriverFactory.getDriver().findElement(allItems).click();
		Thread.sleep(7000);
	}

	public void clickonAbout() {
		WebDriverFactory.getDriver().findElement(About).click();
	}

	public void clickonlogout() {
		WebDriverFactory.getDriver().findElement(logoutbtn).click();
	}

	public void clickResetApp() {
		WebDriverFactory.getDriver().findElement(ResetAppState).click();
	}

}
