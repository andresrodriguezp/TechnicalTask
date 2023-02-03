package Automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Automation.AbstractComponents.AbstractComponents;


public class placeOrder extends AbstractComponents {
	
	//here im creating a local variable "driver"
	
	WebDriver driver;
	

	public placeOrder(WebDriver driver)
	{

		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(css= "input[placeholder= 'Select Country']")
	WebElement country;
	

	@FindBy(xpath= "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	

	@FindBy(css= ".action__submit")
	WebElement placeOrder;
	

	By countryBy = By.cssSelector(".ta-results");
	

	public void SelectingCountry(String countryToSet)
	{
		Actions action = new Actions(driver);
		
		action.sendKeys(country, countryToSet).build().perform();
		waitForElementToAppear(countryBy);
		

		selectCountry.click();
		
	}
	

	public ConfirmationPage placeOrder()
	{
		placeOrder.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver); 
		return confirmationpage;
	}
	
	}
