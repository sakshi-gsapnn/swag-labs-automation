package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.InventoryItemPage;
import pages.InventoryPage;
import pages.LoginPages;

public class WebDriverFactory {

	static ThreadLocal<WebDriver> TLDriver = new ThreadLocal<WebDriver>();
	static ThreadLocal<LoginPages> LoginDriver = new ThreadLocal<LoginPages>();
	static ThreadLocal<CartPage> CartDriver = new ThreadLocal<CartPage>();
	static ThreadLocal<InventoryPage> InventoryDriver = new ThreadLocal<InventoryPage>();
	static ThreadLocal<InventoryItemPage> InventoryItemPageDriver = new ThreadLocal<InventoryItemPage>();
	static ThreadLocal<CheckoutOnePage> CheckONEDriver = new ThreadLocal<CheckoutOnePage>();
	static ThreadLocal<CheckoutTwoPage> CheckTWODriver = new ThreadLocal<CheckoutTwoPage>();
	static ThreadLocal<CheckoutCompletePage> CompleteDriver = new ThreadLocal<CheckoutCompletePage>();

	public static void initDriver() {
		if (TLDriver.get() == null) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
			TLDriver.set(driver);
		}
	}

	public static WebDriver getDriver() {
		if (TLDriver.get() == null) {
			throw new IllegalStateException("WebDriver is not initialized. Call initDriver() first.");
		}
		return TLDriver.get();
	}

	public static void quitDriver() {
		if (TLDriver.get() != null) {
			TLDriver.get().quit();
			TLDriver.remove();
		}
	}

	public static LoginPages getloginDriver() {
		if (LoginDriver.get() == null) {
			LoginDriver.set(new LoginPages());
		}
		return LoginDriver.get();
	}

	public static CartPage getcartDriver() {
		if (CartDriver.get() == null) {
			CartDriver.set(new CartPage());
		}
		return CartDriver.get();
	}

	public static InventoryPage getInventoryDriver() {
		if (InventoryDriver.get() == null) {
			InventoryDriver.set(new InventoryPage());
		}
		return InventoryDriver.get();
	}

	public static InventoryItemPage getInventoryItemPageDriver() {
		if (InventoryItemPageDriver.get() == null) {
			InventoryItemPageDriver.set(new InventoryItemPage());
		}
		return InventoryItemPageDriver.get();
	}

	public static CheckoutOnePage getCheckout_OneDriver() {
		if (CheckONEDriver.get() == null) {
			CheckONEDriver.set(new CheckoutOnePage());
		}
		return CheckONEDriver.get();
	}

	public static CheckoutTwoPage getCheckout_TwoDriver() {
		if (CheckTWODriver.get() == null) {
			CheckTWODriver.set(new CheckoutTwoPage());
		}
		return CheckTWODriver.get();
	}

	public static CheckoutCompletePage getCheckoutCompleteDriver() {
		if (CompleteDriver.get() == null) {
			CompleteDriver.set(new CheckoutCompletePage());
		}
		return CompleteDriver.get();
	}

}