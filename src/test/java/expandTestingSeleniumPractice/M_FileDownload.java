package expandTestingSeleniumPractice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class M_FileDownload {

	public WebDriver driver;

	@BeforeMethod(onlyForGroups = { "defaultDriver" })
	public void SetUp() {
		EdgeOptions options = new EdgeOptions();
		//Blocking Browser popup adds
        options.setExperimentalOption("prefs", Map.of(
            "profile.default_content_setting_values.popups", 2,
            "profile.default_content_setting_values.notifications", 2
        ));
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
		//Using JavaScript for browser add blocking
		js.executeScript("document.querySelectorAll('[id*=\"ads\"], [class*=\"ads\"], iframe').forEach(el => el.remove());");
		driver.findElement(By.linkText("xpath-css.png")).click();
		js.executeScript("document.querySelectorAll('[id*=\"ads\"], [class*=\"ads\"], iframe').forEach(el => el.remove());");
		Thread.sleep(3000);
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
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/download");
		// Click the download link/button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.linkText("cdct.jpg")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
