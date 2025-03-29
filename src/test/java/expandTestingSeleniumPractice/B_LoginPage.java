package expandTestingSeleniumPractice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(extentReporter.Listener.class)
public class B_LoginPage extends BaseTest {
	
	@Test
	public void UserLogin() throws IOException {
		driver.get("https://practice.expandtesting.com/login");
		String username = driver.findElement(By.xpath("//ul/li[1]/b")).getText();
		String password = driver.findElement(By.xpath("//ul/li[2]/b")).getText();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("subheader"))));
		Assert.assertEquals(driver.findElement(By.className("subheader")).getText().toString(), "Welcome to the Secure Area. When you are done click logout below.");
	}
}
