package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class U_ContextMenus extends BaseTest {

	@Test
	public void ContextClick() {
		driver.get("https://practice.expandtesting.com/context-menu");
		WebElement box = driver.findElement(By.id("hot-spot"));
		Actions a = new Actions(driver);
		a.contextClick(box).build().perform();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "You selected a context menu");
		driver.switchTo().alert().accept();
	}
}
