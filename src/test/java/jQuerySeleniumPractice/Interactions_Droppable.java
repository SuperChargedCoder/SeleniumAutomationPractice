package jQuerySeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class Interactions_Droppable extends BaseTest{
	
	@Test
	public void Droppable() {
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement dragItem = driver.findElement(By.id("draggable"));
		WebElement dropItem = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(dragItem, dropItem).build().perform();
	}
}
