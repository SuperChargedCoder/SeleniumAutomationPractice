package jQuerySeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class Interactions_Sortable extends BaseTest {

	@Test (description = "Move item 3 to item 5 location")
	public void Sort() throws InterruptedException {
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions a = new Actions(driver);
		a.clickAndHold(driver.findElement(By.xpath("//ul[@id='sortable']/li[2]"))).moveToElement(driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"))).moveByOffset(0, 10).release().build().perform();
		// .moveByOffset(0, 10) -- Slightly offset to ensure drop happens
	}
}
