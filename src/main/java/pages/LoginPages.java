package pages;

import org.openqa.selenium.By;

import driver.WebDriverFactory;

public class LoginPages {

	private By userField = By.id("user-name");

	private By passField = By.id("password");

	private By loginButton = By.id("login-button");

	public void enterUsername(String username) {

		WebDriverFactory.getDriver().findElement(userField).sendKeys(username);

	}

	public void enterPassword(String password) {

		WebDriverFactory.getDriver().findElement(passField).sendKeys(password);

	}

	public void clickLogin() {

		WebDriverFactory.getDriver().findElement(loginButton).click();

	}

}
