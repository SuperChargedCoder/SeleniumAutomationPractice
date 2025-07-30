package expandTestingAppsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class BMICalculator extends BaseTest {
	
	/*TRY USING PAGE OBJECT AUTOMATION STYLE*/
	
	@Test (description = "WebApplication calculating BMI on user input")
	public void BMI() {
		driver.get("https://practice.expandtesting.com/bmi");
		WebElement gender = driver.findElement(By.xpath("//select[@id='gender']"));
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@id='age']")).clear();
		driver.findElement(By.xpath("//input[@id='height']")).clear();
		driver.findElement(By.xpath("//input[@id='weight']")).clear();
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("27");
		driver.findElement(By.xpath("//input[@id='height']")).sendKeys("180");
		driver.findElement(By.xpath("//input[@id='weight']")).sendKeys("80");
		driver.findElement(By.xpath("//button[text()='Calculate']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@id='BMI']")).getText().toString());
		System.out.println(driver.findElement(By.xpath("//span[@id='bfat']")).getText().toString());
	}
}
