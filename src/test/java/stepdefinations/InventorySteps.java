package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InventoryPage;

public class InventorySteps {

	WebDriver driver = WebDriverFactory.getDriver();
	InventoryPage inventoryPage = WebDriverFactory.getInventoryDriver();
	private String originalHandle;

	@Given("I am on the INVENTORY page")
	public void iAmOnTheInventoryPage() {

		// Ensure we're logged in and on inventory page
		if (!driver.getCurrentUrl().contains("inventory.html")) {

			WebDriverFactory.getDriver().get("https://www.saucedemo.com");
			WebDriverFactory.getloginDriver().enterUsername("standard_user");
			WebDriverFactory.getloginDriver().enterPassword("secret_sauce");
			WebDriverFactory.getloginDriver().clickLogin();
		}

		// Verify we're on inventory page
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"),
				"Expected to be on inventory page but was: " + currentUrl);

		// Store original window handle for social media navigation
		originalHandle = driver.getWindowHandle();
	}

	@When("I click on FACEBOOK icon")
	public void iClickOnFacebookIcon() {

		inventoryPage.clickFacebookIcon();
		switchToNewTab();
	}

	@When("I click on LINKEDIN icon")
	public void iClickOnLinkedinIcon() {

		inventoryPage.clickLinkedinIcon();
		switchToNewTab();
	}

	@When("I click on TWITTER icon")
	public void iClickOnTwitterIcon() {

		inventoryPage.clickTwitterIcon();
		switchToNewTab();
	}

	@Then("I will go to the FACEBOOK page")
	public void iWillGoToTheFacebookPage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("facebook.com"), "Expected to be on Facebook but was: " + currentUrl);
		closeCurrentTabAndSwitchBack();
	}

	@Then("I will go to the LINKEDIN page")
	public void iWillGoToTheLinkedinPage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("linkedin.com"), "Expected to be on LinkedIn but was: " + currentUrl);
		closeCurrentTabAndSwitchBack();
	}

	@Then("I will go to the TWITTER page")
	public void iWillGoToTheTwitterPage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("x.com"), // FIXED: Changed from "twitter.com" to "x.com"
				"Expected to be on Twitter/X but was: " + currentUrl);
		closeCurrentTabAndSwitchBack();
	}

	private void switchToNewTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Wait until a new tab appears
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				return;
			}
		}
		throw new IllegalStateException("Expected a new tab, but none found");
	}

	private void closeCurrentTabAndSwitchBack() {
		driver.close();
		driver.switchTo().window(originalHandle);
	}

}
