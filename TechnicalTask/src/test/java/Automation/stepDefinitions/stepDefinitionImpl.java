package Automation.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Automation.TestComponents.BaseTest;
import Automation.pageobjects.ConfirmationPage;
import Automation.pageobjects.ItemsAdded;
import Automation.pageobjects.LandingPage;
import Automation.pageobjects.ProductCatalogue;
import Automation.pageobjects.placeOrder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl extends BaseTest {
	
	public LandingPage landingpage;
	public ProductCatalogue productscatalogue;
	public ConfirmationPage confirmationpage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingpage = launchApplication();
	}
	

	@Given("^user login to URL with username (.+) and password (.+)$")
	
	public void Logged_in_with_username_and_password(String username, String password)
	{
		
		productscatalogue = landingpage.LogginApplication(username, password);
	}
	
	@When("^user adds to the cart one item (.+) from the product page$")
	public void I_add_product_from_cart(String productName)
	{
		
		List<WebElement> products = productscatalogue.getProductList();
				
		
		productscatalogue.addProductToCar(productName);
	}
	
	@And("^checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		
				ItemsAdded itemsadded =productscatalogue.goingToCar();
						
				

				Boolean match = itemsadded.correctItems(productName);
				Assert.assertTrue(match);
				
						
			
				placeOrder placeorder = itemsadded.checkout();
				
				
				placeorder.SelectingCountry("co");
				
				
				confirmationpage = placeorder.placeOrder();
	}
	
	
	@Then("{string} message is displayed in the confirmation page")
	public void message_is_displayed_in_the_confirmation_page(String string)
	{
		
		String confirmation = confirmationpage.confirmationPaid();
		Assert.assertTrue(confirmation.equalsIgnoreCase(string));
		driver.quit();
	}

}
