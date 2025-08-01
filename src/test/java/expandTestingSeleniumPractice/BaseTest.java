package expandTestingSeleniumPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters("headless")
	@BeforeMethod
	public void SetUp(@Optional("false") String headless) {
		EdgeOptions options = new EdgeOptions();
		
		if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new"); // Use "--headless" if using Chrome < 109
            options.addArguments("--window-size=1920,1080");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");
        
      //Blocking Browser popup adds
        options.setExperimentalOption("prefs", Map.of(
            "profile.default_content_setting_values.popups", 2,
            "profile.default_content_setting_values.notifications", 2
        ));
		
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String TakeScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + testName +  ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "\\ScreenShot\\" + testName +  ".png";
	}
	
	public WebElement WaitForVisibility(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Boolean WaitForInVisibility(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
}
