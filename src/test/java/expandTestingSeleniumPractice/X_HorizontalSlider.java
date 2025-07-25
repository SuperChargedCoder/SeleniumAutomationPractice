package expandTestingSeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class X_HorizontalSlider extends BaseTest {
	
	@Test (enabled = false)
	public void HorizontalStepSlider() {
		driver.get("https://practice.expandtesting.com/horizontal-slider#google_vignette");
		Actions a = new Actions(driver);
		driver.findElement(By.cssSelector("input[type='range']")).click();
		while (!(driver.findElement(By.id("range")).getText().toString()=="3.5")) {
			a.moveToElement(driver.findElement(By.cssSelector("input[type='range']"))).keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).build().perform();
		}
	}
	

	@Test (enabled = false)
	public void HorizontalSlider() {
		driver.get("https://www.fitpeo.com/revenue-calculator");
		Actions a = new Actions(driver);
		a.clickAndHold(driver.findElement(By.cssSelector(".MuiSlider-thumb"))).moveByOffset(120, 0).build().perform();
		driver.findElement(By.cssSelector(".MuiSlider-thumb")).click();
		while (!(driver.findElement(By.cssSelector(".MuiInputBase-input")).getText().toString()=="1111")) {
			a.moveToElement(driver.findElement(By.cssSelector(".MuiSlider-thumb"))).keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).build().perform();
		}
	}
}
