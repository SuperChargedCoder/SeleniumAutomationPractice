package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import extentReporter.RetryFleakyTests;

public class T_JQueryUiMenus extends BaseTest {

	@Test (retryAnalyzer = RetryFleakyTests.class)
	public void DownloadExcel() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/jqueryui/menu");
		WebElement enabled = driver.findElement(By.xpath("//ul[@id='menu']/li[2]"));
		WebElement download = driver.findElement(By.xpath("//a[text()='Downloads']"));
		WebElement pdf = driver.findElement(By.xpath("//a[text()='PDF']"));
		Actions a = new Actions(driver);
		a.moveToElement(enabled).build().perform();
		Thread.sleep(1000);
		a.moveToElement(download).build().perform();
		Thread.sleep(1000);
		a.moveToElement(pdf).click().build().perform();
		Thread.sleep(5000);
	}
}
