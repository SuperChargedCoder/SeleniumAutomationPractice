package prioritySeleniumTopics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDowns {
	
	WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void AutoSuggestiveDropDown() {
		
	}
	
}
