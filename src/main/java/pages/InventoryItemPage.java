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
	private By MeanuButton = By.xpath("//*[@type ='button']");
    private By MenuOptions = By.xpath("//*[@class ='bm-item-list']");
    private By aboutButton = By.xpath("//*[@id ='about_sidebar_link']");
    private By loggoutButton = By.xpath("//*[contains(@id,'logout_sidebar_link')]");
    private By ContinueShoppingBTN = By.xpath("//button[@id='continue-shopping']");
    private By cartIcon = By.xpath("//*[@class='shopping_cart_link']");


	public String getItemName() {
		return WebDriverFactory.getDriver().findElement(itemName).getText();
	}

	
	 // description for products
		public String getItemDescription() {
			return WebDriverFactory.getDriver().findElement(itemDescription).getText();
		}
	       // getting iTEam iteam Prise
		public String getItemPrice() {
			return WebDriverFactory.getDriver().findElement(itemPrice).getText();
		}
	        //getting iteam Image
		public String getItemImageSrc() {
			return WebDriverFactory.getDriver().findElement(itemImage).getAttribute("src");
		}
	       //getting addto cart icon
		public void clickAddToCart() {
			WebDriverFactory.getDriver().findElement(addToCartButton).click();
		}
	      //getting backbutton
		public void clickBackToProducts() {
			WebDriverFactory.getDriver().findElement(backButton).click();
		}
	    //getting meanubutton
		public void meanuButton() {//throws InterruptedException {
			WebDriverFactory.getDriver().findElement(MeanuButton).click();
			//Thread.sleep(7000);

		}
		//getting meanu options
		public void menuOptions() {
			WebDriverFactory.getDriver().findElement(MenuOptions).isDisplayed();
			
		}
		//getting aboutbutton
	public void AboutOptions() {// throws InterruptedException {
		WebDriverFactory.getDriver().findElement(aboutButton).click();
		//Thread.sleep(2000);
	  }
	   //getting loggout
	public void LoggoutButton() {
		WebDriverFactory.getDriver().findElement(loggoutButton).click();
	 }
	   //getting ContinueShoppingButton
	public void ContinueShoppingbutton() {
		WebDriverFactory.getDriver().findElement(ContinueShoppingBTN).click();
	}  
	  //getting addto cartIcon
	  public void AddCartIcon() {
		  WebDriverFactory.getDriver().findElement(cartIcon).click();
	  }
	}

	

