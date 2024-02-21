package StepDefinitionImplementation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import KavyaSaiAcadamey.pageobject.CartPage;
import KavyaSaiAcadamey.pageobject.CheckoutPage;
import KavyaSaiAcadamey.pageobject.ConfirmationPage;
import KavyaSaiAcadamey.pageobject.LandingPage;
import KavyaSaiAcadamey.pageobject.ProductCatalogue;
import KavyaSaiAcademy.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	public LandingPage landingPage;
	public  ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I Landed on ECommerce Website")
	public void I_Landed_on_ECommerce_Website() throws IOException
	{
		landingPage =	launchApplication();
}
	 @Given("^Logged in to the Ecommerce Website with (.+) and (.+)$")
	 public void Logged_in_ECommerce_with_username_and_password(String uname,String password)
	 {
		productCatalogue= landingPage.loginCredentials(uname,password);
	 }
	 @When("^I added the (.+) to the cart$") 
	 public void I_added_to_the_cart(String productname) throws InterruptedException
	 {
		 List<WebElement> productsList = productCatalogue.getProductList();
			productCatalogue.getAddToCart(productname);
	 }
	 @And("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_order(String productname) throws InterruptedException
	 {
		 CartPage cartPage = productCatalogue.clickOnCart();

			Boolean match = cartPage.getCartItems(productname);
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = cartPage.getClickCheckout();
			checkoutPage.getCountry("India");
			 confirmationPage = checkoutPage.getOrder();
	 }
	 @Then("Verify {string} message on the Confirmation Page")
	 public void Verify_message_on_Confirmation_page(String string)
	 {
		 String confirmName = confirmationPage.getName();

			Assert.assertTrue(confirmName.equalsIgnoreCase(string));
			driver.close();
	 }
	 @Then("{string} message is displayed.")
	  public void Error_message_is_displayed(String string)
	  {
		 Assert.assertEquals(string, landingPage.getErrorMessage());
		 driver.close();
	  }
}