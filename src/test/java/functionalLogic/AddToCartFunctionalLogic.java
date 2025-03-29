package functionalLogic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartFunctionalLogic {

	static WebDriver driver;

	@BeforeMethod
	public void InitializeBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test
	public void AddItemToCartBasicLogic() {
		String[] addToCart = { "Cucumber", "Orange", "Beetroot", "Mushroom", "Beans", "Capsicum", "Corn", "Banana",
				"Pomegranate", "Strawberry" };
		List<String> toBeOrdered = new ArrayList<>(Arrays.asList(addToCart));
		List<WebElement> availableItems = driver.findElements(By.className("product-name"));
		int j = 0;
		for (int i = 0; i < availableItems.size(); i++) {
			String product = availableItems.get(i).getText().split(" ")[0];
			if (toBeOrdered.contains(product)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == toBeOrdered.size()) {
					break;
				}
			}
		}
	}

	@Test
	public void AddItemToCartAdvanceLogic() {
		String[] cart = { "Cucumber", "Orange", "Beetroot", "Mushroom", "Beans", "Capsicum", "Corn", "Banana", "Pomegranate", "Strawberry" };
		List<String> vegDemand = new ArrayList<>(Arrays.asList(cart));
		ArrayList<String> availableProducs = GetAvailavbleProductName(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i < vegDemand.size(); i++) {
			if (availableProducs.contains(vegDemand.get(i))) {
				int j = availableProducs.indexOf(vegDemand.get(i));
				try {
					// Scroll the element into view before clicking
					WebElement elementToClick = driver.findElements(By.cssSelector("div[class='product-action'] button")).get(j);
					scrollIntoView(elementToClick);

					// Wait for the element to be ready for click and then click
					WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
					clickableElement.click();
					System.out.println(vegDemand.get(i) + " added to cart at index " + j);
				} catch (Exception e) {
					// If the regular click fails, use JavaScript to click the element
					System.out.println("Click intercepted, trying JavaScript click for " + vegDemand.get(i));
					WebElement elementToClick = driver.findElements(By.cssSelector("div[class='product-action'] button")).get(j);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", elementToClick);
					System.out.println(vegDemand.get(i) + " added to cart at index " + j + " using JavaScript click.");
				}
			}
		}
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static ArrayList<String> GetAvailavbleProductName(WebDriver driver) {
		List<WebElement> availableProductsWebElement = driver.findElements(By.className("product-name"));
		ArrayList<String> productList = new ArrayList<>();
		for (WebElement product : availableProductsWebElement) {
			String name = product.getText().replace(" ", "").split("-")[0];
			productList.add(name);
		}
		return productList;
	}
}
