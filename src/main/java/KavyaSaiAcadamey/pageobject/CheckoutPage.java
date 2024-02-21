package KavyaSaiAcadamey.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KavyaSai.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(css = "[placeholder='Select Country']")
	 WebElement country;
	private @FindBy(css = ".action__submit")
	  WebElement submit;

	private @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	 WebElement countrySelected;

	//By results = By.cssSelector(".ta-results");

	public void getCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitUntilElementToAppear(By.cssSelector(".ta-results"));
		countrySelected.click();

	}

	public ConfirmationPage getOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.action__submit').click()");
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
		
}
}
