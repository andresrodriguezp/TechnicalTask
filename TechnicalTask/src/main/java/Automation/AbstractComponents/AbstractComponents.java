package Automation.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.pageobjects.ItemsAdded;

public class AbstractComponents {
	

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(driver, this);

		
	}
	

	@FindBy(css= "button[routerlink=\"/dashboard/cart\"]")
	WebElement toCar;
	

	@FindBy(css= "button[routerlink='/dashboard/myorders']")
	WebElement toOrders;
	

	public void waitForElementToAppear(By findBy)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	

	public void waitForElement(WebElement element)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDissapear (WebElement animating)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(animating));
	}
	
	
	public ItemsAdded goingToCar()
	{
		toCar.click();

		ItemsAdded itemsadded = new ItemsAdded(driver);
		return itemsadded;
	}
	
	public OrderPage goingToOrders()
	{
		toOrders.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}

}
