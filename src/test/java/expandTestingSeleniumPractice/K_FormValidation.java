package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class K_FormValidation extends BaseTest {
	
	@Test
	public void FormFill() {
		driver.get("https://practice.expandtesting.com/form-validation");
		driver.findElement(By.id("validationCustom01")).clear();
		driver.findElement(By.id("validationCustom01")).sendKeys("Shubham");
		driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("012-3456789");
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("28-07-1999");
		Select s = new Select(driver.findElement(By.id("validationCustom04")));
		s.selectByVisibleText("card");
		driver.findElement(By.cssSelector("button[type='submit']")).click();;
		System.out.println(WaitForVisibility(driver.findElement(By.cssSelector(".alert")), driver).getText());
	}
}
