package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class A_WebInputPractice extends BaseTest {
	
	@Test
	public void provideData () {
		driver.get("https://practice.expandtesting.com/inputs");
		driver.findElement(By.id("input-number")).sendKeys("1234");
		driver.findElement(By.id("input-text")).sendKeys("Shubham");
		driver.findElement(By.id("input-password")).sendKeys("SeleniumPractice@TestNG");
		driver.findElement(By.id("input-date")).sendKeys("28-07-1999");
		driver.findElement(By.className("btn-outline-primary")).click();
	}
}
