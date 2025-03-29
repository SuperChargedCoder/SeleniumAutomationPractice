package expandTestingSeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class P_Autocomplete extends BaseTest {
	
	@Test
	public void AutoComplete() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/autocomplete");
		driver.findElement(By.id("country")).sendKeys("Ind");
		List<WebElement> findElements = driver.findElements(By.cssSelector("div[class='autocomplete-items'] div"));
		for (WebElement webElement : findElements) {
			if (webElement.getText().toString().equalsIgnoreCase("India")) {
				webElement.click();
				break;
			}
		}
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
}
