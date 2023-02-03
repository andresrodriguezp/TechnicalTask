package Automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponents;


public class ProductCatalogue extends AbstractComponents {
	

	
	WebDriver driver;
	

	public ProductCatalogue(WebDriver driver)
	{

		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(css= ".mb-3")
	List<WebElement> products;
	

	By prodyctsBy = By.cssSelector(".mb-3");
	

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	

	By toastContainer = By.cssSelector("#toast-container");
	

	@FindBy(css= ".ng-animating")
	WebElement animating;
	

	public List<WebElement> getProductList()
	{
		waitForElementToAppear(prodyctsBy);
		return products;
	}
	

	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	

	
	public void addProductToCar(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDissapear(animating);
	}
	
	
	}
