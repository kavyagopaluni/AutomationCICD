package KavyaSai.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import KavyaSaiAcadamey.pageobject.CartPage;
import KavyaSaiAcadamey.pageobject.MyOrders;
import KavyaSaiAcadamey.pageobject.ProductCatalogue;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement clickCart;
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement myOrders;
			

	public void waitUntilElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitUntilElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void waitUntilWebElementtoAppear(List<WebElement> eles)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(eles));
	}

	public CartPage clickOnCart() {
		clickCart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public MyOrders goToOrders()
	{
		myOrders.click();
		MyOrders myOrders=new MyOrders(driver);
		return myOrders;
	}

}
