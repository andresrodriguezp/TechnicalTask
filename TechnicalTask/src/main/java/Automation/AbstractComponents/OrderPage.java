package Automation.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {
	

	
	WebDriver driver;
	

	public OrderPage(WebDriver driver)
	{

		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(css= "tr td:nth-child(3)")
	List<WebElement> orders;
	

	public Boolean orderItems(String productName)
	{
		Boolean match = orders.stream().anyMatch(orderproduct-> orderproduct.getText().equalsIgnoreCase(productName));
		return match;
		}
	
}
