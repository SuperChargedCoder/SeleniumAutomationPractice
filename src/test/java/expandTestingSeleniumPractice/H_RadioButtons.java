package expandTestingSeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class H_RadioButtons extends BaseTest {
	
	@Test
	public void FavSportColour() {
		driver.get("https://practice.expandtesting.com/radio-buttons");
		driver.findElement(By.id("yellow")).click();
		driver.findElement(By.id("football")).click();
	}
	
	@Test
	public void DefaultValue() {
		driver.get("https://practice.expandtesting.com/radio-buttons");
		List<WebElement> radioButton = driver.findElements(By.cssSelector(".form-check-input"));
		
		for (int i = 0; i < radioButton.size(); i++) {
			if (radioButton.get(i).isSelected()) {
				System.out.println(driver.findElements(By.cssSelector(".form-check-label")).get(i).getText());
			}
		}
	}
}
