package KavyaSaiAcadamey.Tests;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import KavyaSaiAcadamey.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String prodName="IPHONE 13 PRO";
		String countryName="India";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage landingPage=new LandingPage(driver);

		driver.findElement(By.id("userEmail")).sendKeys("Yuvaanyuvi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Yuvaan2018");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=	cartItems.stream().anyMatch(Item->Item.getText().equals(prodName));
	Assert.assertTrue(match);
	driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
	Actions a =new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),countryName ).build().perform();
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector("..btnn ")).click();
	String confirmName=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmName.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();

			
     
	}
}


