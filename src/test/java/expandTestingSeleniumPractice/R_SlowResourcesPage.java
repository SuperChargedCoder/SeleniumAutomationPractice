package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class R_SlowResourcesPage extends BaseTest {

	@Test
	public void snipperTimer() {
		driver.get("https://practice.expandtesting.com/slow");
		WebElement snipper = driver.findElement(By.cssSelector(".spinner-border"));
		String delayedText = "The slow task has finished. Thanks for waiting!";
		Assert.assertTrue(WaitForInVisibility(snipper, driver));
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-info")).getText().toString(), delayedText);
	}
}
