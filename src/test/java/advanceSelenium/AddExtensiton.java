package advanceSelenium;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AddExtensiton {
	
	@Test
	public void AddExtensionInAutomatedBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Shubham Chaurasia\\Downloads\\Edge Downloads\\SelectorsHub.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://booking.com");
	}
}
