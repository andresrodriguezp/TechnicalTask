package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Automation.AbstractComponents.AbstractComponents;


public class ItemsAdded extends AbstractComponents {
	

	
	WebDriver driver;
	

	public ItemsAdded(WebDriver driver)
	{

		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id= ".cartSection h3")
	List<WebElement> addedItems;
	

	@FindBy(css= ".totalRow button")
	WebElement checkout;
	
	By itemsAdded = By.cssSelector(".cartSection h3");
	

	public List<WebElement> itemsAdded()
	{
		waitForElementToAppear(itemsAdded);
		List<WebElement> cardproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		return cardproducts;
	}
	

	public Boolean correctItems(String productName)
	{
		List<WebElement> cardproducts = itemsAdded();
		Boolean match = cardproducts.stream().anyMatch(cardproduct-> cardproduct.getText().equalsIgnoreCase(productName));
		return match;
		}
	

	public placeOrder checkout()
	{
		checkout.click();
		placeOrder placeorder = new placeOrder(driver); 
		return placeorder;
	}
	}
