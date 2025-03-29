package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class V_KeyPresses extends BaseTest {

	@Test
	public void KeyPress() {
		driver.get("https://practice.expandtesting.com/key-presses?");
		driver.findElement(By.id("target")).sendKeys(Keys.ESCAPE);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("target"))).keyDown(Keys.F1).build().perform();
	}
}
