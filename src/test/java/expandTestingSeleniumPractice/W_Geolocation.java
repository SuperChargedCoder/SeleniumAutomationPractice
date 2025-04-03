package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class W_Geolocation extends BaseTest {

	@Test
	public void GetLocation() {
		driver.get("https://practice.expandtesting.com/geolocation");
		driver.findElement(By.id("geoBtn")).click();
		WaitForVisibility(driver.findElement(By.id("lat-value")), driver);
		String latitude = driver.findElement(By.id("lat-value")).getText().toString();
		String longitude = driver.findElement(By.id("long-value")).getText().toString();
		System.out.println("Latitude : " + latitude + "\n" + "Longitude : " + longitude);
	}
}
