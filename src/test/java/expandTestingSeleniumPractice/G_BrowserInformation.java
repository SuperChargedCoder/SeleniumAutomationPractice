package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class G_BrowserInformation extends BaseTest {
	
	@Test
	public void GetBrowserDetails() {
		driver.get("https://practice.expandtesting.com/my-browser");
		driver.findElement(By.id("browser-toggle")).click();
		WebElement broswerName = driver.findElement(By.id("browser-name"));
		Assert.assertEquals(broswerName.getText().toString(), "Google Chrome");
		Assert.assertEquals(broswerName.isDisplayed(), true);
		driver.findElement(By.id("browser-toggle")).click();
	}
}
