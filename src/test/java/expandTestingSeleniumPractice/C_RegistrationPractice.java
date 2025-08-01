package expandTestingSeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import extentReporter.RetryFleakyTests;

public class C_RegistrationPractice extends BaseTest {
	
	@Test (invocationCount = 2, retryAnalyzer = RetryFleakyTests.class)
	public void UserRegistration() {
		driver.get("https://practice.expandtesting.com/register");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelectorAll('[id*=\"ads\"], [class*=\"ads\"], iframe').forEach(el => el.remove());");
		
		driver.findElement(By.id("username")).sendKeys("TestAutomationEngineer");
		driver.findElement(By.id("password")).sendKeys("testing");
		driver.findElement(By.id("confirmPassword")).sendKeys("testing");
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("confirmPassword")));
		
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[id='flash'] b"))));
		WaitForVisibility(driver.findElement(By.cssSelector("div[id='flash'] b")), driver);
		
		if (driver.findElement(By.cssSelector("div[id='flash'] b")).getText() == "Successfully registered, you can log in now.") {
			Assert.assertEquals(driver.findElement(By.cssSelector("div[id='flash'] b")).getText(), "Successfully registered, you can log in now.");
			Assert.assertEquals(driver.getCurrentUrl().toString(), "https://practice.expandtesting.com/login");
		} else {
			Assert.assertEquals(driver.findElement(By.cssSelector("div[id='flash'] b")).getText(), "An error occurred during registration. Please try again.");
			Assert.assertEquals(driver.getCurrentUrl().toString(), "https://practice.expandtesting.com/register");
		}
	}
}
