package KavyaSaiAcadamey.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import KavyaSaiAcadamey.pageobject.CartPage;
import KavyaSaiAcadamey.pageobject.CheckoutPage;
import KavyaSaiAcadamey.pageobject.ConfirmationPage;

import KavyaSaiAcadamey.pageobject.MyOrders;
import KavyaSaiAcadamey.pageobject.ProductCatalogue;
import KavyaSaiAcademy.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {

	String productName = "IPHONE 13 PRO";
	String countryName = "India";

	@Test(dataProvider = "getData", groups = { "Purchase" })

	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginCredentials(input.get("email"), input.get("password"));

		List<WebElement> productsList = productCatalogue.getProductList();
		productCatalogue.getAddToCart(input.get("products"));
		CartPage cartPage = productCatalogue.clickOnCart();

		Boolean match = cartPage.getCartItems(input.get("products"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.getClickCheckout();
		checkoutPage.getCountry(countryName);
		ConfirmationPage confirmationPage = checkoutPage.getOrder();
		String confirmName = confirmationPage.getName();

		Assert.assertTrue(confirmName.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })

	public void verifyOrder() throws IOException {

		ProductCatalogue productCatalogue = landingPage.loginCredentials("Yuvaanyuvi@gmail.com", "Yuvaan2018");
		MyOrders myOrders = productCatalogue.goToOrders();
		Assert.assertTrue(myOrders.ordersListWebElements(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\\\src\\\\test\\\\java\\\\KavyaSaiAcademy\\\\data\\\\Purchaseorder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
//Other way To use HashMap
//HashMap<String,String> map=new HashMap<String,String>();
//map.put("email", "Yuvaanyuvi@gmail.com");
//map.put("password", "Yuvaan2018");
//map.put("products", "IPHONE 13 PRO");
//HashMap<Object,Object> map1=new HashMap<Object,Object>();
//map1.put("email", "Sai009@gmail.com");
//map1.put("password", "Sai009014");
//map1.put("products", "ZARA COAT 3");
