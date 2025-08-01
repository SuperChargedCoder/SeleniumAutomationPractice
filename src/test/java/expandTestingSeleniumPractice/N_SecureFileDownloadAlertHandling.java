package expandTestingSeleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class N_SecureFileDownloadAlertHandling extends BaseTest {

	@Test (description = "Using Robot Class")
	public void AletPopupHandling() throws InterruptedException, AWTException {
		driver.get("https://practice.expandtesting.com/download-secure");
		Thread.sleep(2000);
		Robot robot = new Robot();
		
		typeText(robot, "practice");
        robot.keyPress(KeyEvent.VK_TAB); // Move to password field
        robot.keyRelease(KeyEvent.VK_TAB);
        
        typeText(robot, "SuperSecretPassword");
        robot.keyPress(KeyEvent.VK_TAB); // Move to password field
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER); // Press Enter to login
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	private static void typeText(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
	
	@Test (description = "Parameterised URL")
	public void ParameterisedURL () throws InterruptedException {
		String userName = "practice";
		String passKey = "SuperSecretPassword!";
		String baseURL = "https://practice.expandtesting.com/download-secure";
		String authURL = "https://" + userName + ":" + passKey + "@"  +baseURL.replace("https://", "");
		driver.get(authURL);
		System.out.println(driver.getCurrentUrl());
	}
}
