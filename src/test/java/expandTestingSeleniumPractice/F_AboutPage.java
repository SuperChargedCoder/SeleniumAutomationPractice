package expandTestingSeleniumPractice;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F_AboutPage extends BaseTest {
	
	@Test
	public void SendEmailToDev() {
		driver.get("https://practice.expandtesting.com/about");
		String emailId = driver.findElement(By.cssSelector(".text-bg-info")).getText();
		driver.navigate().to("https://practice.expandtesting.com/forgot-password");
		driver.findElement(By.id("email")).sendKeys(emailId);
		driver.findElement(By.xpath("//button[text()='Retrieve password']")).click();
	}
	
}
