package expandTestingSeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert")))).getText();
		System.out.println(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert")))).getText());
		
	}
}
