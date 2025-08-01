package expandTestingAppsAutomation;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class SecurePasswordCheck extends BaseTest {
	
	@Test (description = "Password security check")
	public void CheckAcceptablePassword () {
		driver.get("https://practice.expandtesting.com/secure-password-checker");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Password : ");
		String inputPassword = scan.nextLine();
		driver.findElement(By.cssSelector(".password")).sendKeys(inputPassword);
		List<WebElement> issues = driver.findElements(By.xpath("//ul[@class='helper-text']/li"));
		issues.stream().forEach(a-> System.out.println(a.getText()));
	}

}
