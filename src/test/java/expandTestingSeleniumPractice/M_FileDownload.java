package expandTestingSeleniumPractice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class M_FileDownload {

	public WebDriver driver;

	@BeforeMethod(onlyForGroups = { "defaultDriver" })
	public void SetUp() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://practice.expandtesting.com/download");
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(groups = {"defaultDriver"})
	public void DownloadFileAtDefaultLocation() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.linkText("xpath-css.png")).click();
	}

	@Test
	public void DownloadFileAtCustomLocation() throws InterruptedException {
		// Set download directory
		String downloadFilepath = System.getProperty("user.dir") + "\\src\\test\\java\\resources";
		// Configure ChromeOptions to disable pop-ups
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadFilepath);
		prefs.put("download.prompt_for_download", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		// Launch Chrome with options
		driver = new ChromeDriver(options);
		driver.get("https://practice.expandtesting.com/download"); // Replace with actual URL
		// Click the download link/button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.linkText("xpath-css.png")).click();
		// Wait for download to complete (optional)
		try {
			Thread.sleep(5000); // Add WebDriverWait for better handling
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
