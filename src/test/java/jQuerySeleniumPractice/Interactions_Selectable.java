package jQuerySeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class Interactions_Selectable extends BaseTest {

	@Test (description = "Selecting one at a time")
	public void SelectOne() throws InterruptedException {
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		List<WebElement> totalItem = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		for (WebElement webElement : totalItem) {
			webElement.click();
			Thread.sleep(500);
		}
	}
	
	@Test (description = "Selecting all")
	public void SelectAll() {
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions a = new Actions(driver);
		a.clickAndHold(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"))).moveToElement(driver.findElement(By.xpath("//ol[@id='selectable']/li[7]"))).release().build().perform();
	}
}
