package expandTestingSeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import extentReporter.RetryFleakyTests;

public class O_NotificationMessage extends BaseTest {
	
	@Test (description = "This Functionality is inconsistent", retryAnalyzer = RetryFleakyTests.class)
	public void HandlingNotificationMessage() {
		driver.get("https://practice.expandtesting.com/notification-message-rendered");
		LoadNewMessage(driver);
		WebElement notificationMessage = driver.findElement(By.id("flash"));
		Assert.assertEquals(WaitForVisibility(notificationMessage, driver).getText().toString(), "Action successful");
		do {
			LoadNewMessage(driver);
		} while (WaitForVisibility(notificationMessage, driver).getText().toString().equalsIgnoreCase("Action unsuccessful, please try again"));
		try {
			Assert.assertEquals(notificationMessage.getText().toString(), "Action unsuccessful, please try again");
		} catch (Exception e) {
			System.out.println(WaitForVisibility(notificationMessage, driver).getText());
		}
	}
	
	public static WebElement WaitForElementToAppear(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void LoadNewMessage(WebDriver driver) {
		driver.findElement(By.linkText("Click here")).click();
	}
}
