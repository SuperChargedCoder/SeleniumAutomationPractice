package expandTestingSeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ZA_Tooltips extends BaseTest {
	@Test
	public void GetTooltips() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/tooltips");
		Thread.sleep(3000); //So that page become stable
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("btn3"))).build().perform();
	}
}
