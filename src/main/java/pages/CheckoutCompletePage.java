package pages;

import org.openqa.selenium.By;

import driver.WebDriverFactory;

public class CheckoutCompletePage {
	private By backHomeButton = By.id("back-to-products");
	private By cartIcon = By.className("shopping_cart_link");
	private By getTextmsg = By.className("complete-header");
	private By menubutton = By.id("react-burger-menu-btn");
	private By allItems = By.id("inventory_sidebar_link");
	private By About = By.id("about_sidebar_link");
	private By logoutbtn = By.id("logout_sidebar_link");
	private By ResetAppState = By.id("reset_sidebar_link");

	public void clickBackHome() {
		WebDriverFactory.getDriver().findElement(backHomeButton).click();
	}

	public void clickCartIcon() {
		WebDriverFactory.getDriver().findElement(cartIcon).click();
	}

	public String getThetextCompleted() {

		String text = WebDriverFactory.getDriver().findElement(getTextmsg).getText();
		return text;

	}

	public void clickmenubutton() {
		WebDriverFactory.getDriver().findElement(menubutton).click();
	}

	public void clickonAllitems() throws InterruptedException {
		WebDriverFactory.getDriver().findElement(allItems).click();

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
