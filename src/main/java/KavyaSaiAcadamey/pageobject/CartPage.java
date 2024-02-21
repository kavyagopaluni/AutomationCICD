package KavyaSaiAcadamey.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KavyaSai.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;
	private @FindBy(xpath = "//li[@class='totalRow']/button")
	WebElement checkout;

	public Boolean getCartItems(String productName) {
		Boolean match = cartItems.stream().anyMatch(Item -> Item.getText().equals(productName));

		return match;

	}

	public CheckoutPage getClickCheckout() {
		checkout.click();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		return checkoutPage;
	}

}
