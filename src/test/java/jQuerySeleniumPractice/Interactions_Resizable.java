package jQuerySeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class Interactions_Resizable extends BaseTest {

	@Test
	public void Resizable() {
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions a = new Actions(driver);
		WebElement resizeHandle = driver.findElement(By.cssSelector(".ui-resizable-se"));
		a.clickAndHold(resizeHandle).moveByOffset(150, 150).release().perform();
	}
}
