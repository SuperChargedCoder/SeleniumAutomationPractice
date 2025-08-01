package expandTestingSeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import extentReporter.RetryFleakyTests;

public class S_JavaScriptDialogs extends BaseTest {
	
	@Test (priority = 0)
	public void SwitchToAlert() {
		driver.get("https://practice.expandtesting.com/js-dialogs");
		driver.findElement(By.id("js-alert")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test (priority = 1)
	public void JsAlert() {
		driver.get("https://practice.expandtesting.com/js-dialogs");
		driver.findElement(By.id("js-alert")).click();
//		driver.switchTo().alert().accept();
		/*Using Alert class object and methods*/
		Alert a = new Alert() {
			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return driver.switchTo().alert().getText();
			}
			@Override
			public void dismiss() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void accept() {
				driver.switchTo().alert().accept();
				
			}
			@Override
			public void sendKeys(String keysToSend) {
				// TODO Auto-generated method stub
				
			}
		};
		Assert.assertEquals(a.getText(), "I am a Js Alert");
		a.accept();
		Assert.assertEquals(driver.findElement(By.id("dialog-response")).getText().toString(), "OK");
	}
	
	@Test (priority = 2, retryAnalyzer = RetryFleakyTests.class)
	public void JsConfirm() {
		driver.get("https://practice.expandtesting.com/js-dialogs");
		driver.findElement(By.id("js-confirm")).click();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a Js Confirm");
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.id("dialog-response")).getText().toString(), "Ok");
		driver.findElement(By.id("js-confirm")).click();
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(driver.findElement(By.id("dialog-response")).getText().toString(), "Cancel");
	}
	
	@Test (priority = 3)
	public void JsPrompt() {
		driver.get("https://practice.expandtesting.com/js-dialogs");
		driver.findElement(By.id("js-prompt")).click();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a Js prompt");
		driver.switchTo().alert().sendKeys("Testing");
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.id("dialog-response")).getText().toString(), "Testing");
		driver.findElement(By.id("js-prompt")).click();
		Assert.assertEquals(driver.switchTo().alert().getText().toString(), "I am a Js prompt");
		driver.switchTo().alert().sendKeys("Testing");
		driver.switchTo().alert().dismiss();
		Assert.assertEquals(driver.findElement(By.id("dialog-response")).getText().toString(), "");
	}
}
