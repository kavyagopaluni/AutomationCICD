package KavyaSaiAcadamey.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KavyaSai.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(id = "userEmail")
	WebElement emailId;

	private @FindBy(id = "userPassword")
	WebElement pass;
	private @FindBy(id = "login")
	WebElement submit;
	private @FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage ;
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	
	
	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductCatalogue loginCredentials(String email, String password) {
		emailId.sendKeys(email);
		pass.sendKeys(password);

		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
}
