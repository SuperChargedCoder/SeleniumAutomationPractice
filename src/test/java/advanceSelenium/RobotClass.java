package advanceSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import expandTestingSeleniumPractice.BaseTest;

public class RobotClass extends BaseTest {
	
	@Test
	public void FileUpload() throws AWTException {
		driver.get("https://practice.expandtesting.com/upload");
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\BMW.jpg";
		driver.findElement(By.cssSelector(".form-control")).click();
		
		Robot robot = new Robot();
		StringSelection filePathSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        // Press Enter to upload the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
