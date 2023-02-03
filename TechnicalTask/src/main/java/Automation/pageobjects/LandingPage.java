package Automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Automation.AbstractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents {
	

	
	WebDriver driver;
	

	public LandingPage(WebDriver driver)
	{

		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id= "userEmail")
	WebElement useremail;
	
	@FindBy(id= "userPassword")
	WebElement userPassword;
	
	@FindBy(id= "login")
	WebElement login;
	
	@FindBy(css= "[class*='flyInOut']")
	WebElement errorMessage;
	

	public ProductCatalogue LogginApplication (String email, String password )
	{
		useremail.clear();
		useremail.sendKeys(email);
		userPassword.clear();
		userPassword.sendKeys(password);
		login.click();

		ProductCatalogue productscatalogue = new ProductCatalogue(driver);
		return productscatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForElement(errorMessage);
		String message = errorMessage.getText();
		return message;
		
	}
	

	public void goTo ()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	}
