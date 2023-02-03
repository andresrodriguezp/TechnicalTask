package Automation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Automation.TestComponents.BaseTest;
import Automation.pageobjects.ConfirmationPage;
import Automation.pageobjects.ItemsAdded;
import Automation.pageobjects.ProductCatalogue;
import Automation.pageobjects.placeOrder;


public class SubmitOrderTest extends BaseTest {
	
	

	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> Input) throws IOException {
		// TODO Auto-generated method stub
		
	    String country = "co";
		

		ProductCatalogue productscatalogue = landingpage.LogginApplication(Input.get("email"), Input.get("password"));
		

		List<WebElement> products = productscatalogue.getProductList();
		

		productscatalogue.addProductToCar(Input.get("productName"));
		

		ItemsAdded itemsadded =productscatalogue.goingToCar();
				


		Boolean match = itemsadded.correctItems(Input.get("productName"));
		Assert.assertTrue(match);
		
				

		placeOrder placeorder = itemsadded.checkout();
		

		placeorder.SelectingCountry(country);
		

		ConfirmationPage confirmationpage = placeorder.placeOrder();

		

		String confirmation = confirmationpage.confirmationPaid();
		Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException
	{
				List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Automation//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}};

	}

}
