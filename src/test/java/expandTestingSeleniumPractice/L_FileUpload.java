package expandTestingSeleniumPractice;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class L_FileUpload extends BaseTest {
	
	@Test
	public void UploadWithSendKey() {
		driver.get("https://practice.expandtesting.com/upload");
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\BMW.jpg";
		driver.findElement(By.id("fileInput")).sendKeys(filePath);
		driver.findElement(By.id("fileSubmit")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container']/h1")).getText().toString(), "File Uploaded!");
	}
	
	public void UploadWithRobotClass() throws AWTException {
		// Click to open file dialog
        driver.findElement(By.id("fileInput")).click();

        // Use Robot Class to type file path
        StringSelection filePath = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\BMW.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        Robot robot = new Robot();
        robot.delay(2000);

        // Paste file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
