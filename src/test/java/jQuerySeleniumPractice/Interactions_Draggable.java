package jQuerySeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class Interactions_Draggable extends BaseTest {
	
	@Test 
	public void DragAround() {
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement item = driver.findElement(By.id("draggable"));
		Actions a = new Actions(driver);
		a.dragAndDropBy(item, 391, 221).build().perform();
	}
}
