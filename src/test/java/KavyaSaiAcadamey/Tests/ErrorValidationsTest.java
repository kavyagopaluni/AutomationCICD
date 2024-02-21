package KavyaSaiAcadamey.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import KavyaSaiAcadamey.pageobject.CartPage;
import KavyaSaiAcadamey.pageobject.ProductCatalogue;
import KavyaSaiAcademy.TestComponents.BaseTest;
import KavyaSaiAcademy.TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest {
	@Test(groups = { "ErrorHandling" },retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {

		ProductCatalogue productCatalogue = landingPage.loginCredentials("Yuvaanyuvi@gmail.com", "Yuvaan12018");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	public void productErrorValidation() throws IOException, InterruptedException {

		String productName = "IPHONE 13 PRO";

		
		ProductCatalogue productCatalogue = landingPage.loginCredentials("Yuvaanyuvi@gmail.com", "Yuvaan2018");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.getAddToCart(productName);
		CartPage cartPage = productCatalogue.clickOnCart();

		Boolean match = cartPage.getCartItems("IPHONE 14 PRO");
		Assert.assertFalse(match);
	}
}
