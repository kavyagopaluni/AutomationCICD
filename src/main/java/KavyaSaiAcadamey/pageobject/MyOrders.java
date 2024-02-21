package KavyaSaiAcadamey.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KavyaSai.AbstractComponents.AbstractComponent;

public class MyOrders extends AbstractComponent {
	WebDriver driver;

	public MyOrders(WebDriver driver)
	{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	private @FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderList;
	public Boolean ordersListWebElements(String productName)
	{
	Boolean match=	orderList.stream().anyMatch(order->order.getText().equals(productName));
	return match;
	}

}
