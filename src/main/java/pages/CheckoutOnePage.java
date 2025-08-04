package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.WebDriverFactory;

public class CheckoutOnePage {

	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By postalCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By cancelButton = By.id("cancel");

	public void enterFirstName(String firstName) {
		WebDriverFactory.getDriver().findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		WebDriverFactory.getDriver().findElement(lastNameField).sendKeys(lastName);
	}

	public void enterPostalCode(String postalCode) {
		WebDriverFactory.getDriver().findElement(postalCodeField).sendKeys(postalCode);
	}

	public void clickContinue() {
		WebDriverFactory.getDriver().findElement(continueButton).click();
	}

	public void clickCancel() {
		WebDriverFactory.getDriver().findElement(cancelButton).click();
	}

}
