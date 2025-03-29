package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class J_DragDrapInContainer extends BaseTest {
	
	@Test
	public void DragDrop() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/drag-and-drop-circles");
		Actions a = new Actions(driver);
		WebElement redSource = driver.findElement(By.className("red"));
		WebElement greenSource = driver.findElement(By.className("green"));
		WebElement blueSource = driver.findElement(By.className("blue"));
		WebElement destination = driver.findElement(By.id("target"));
		Thread.sleep(1500);
		a.dragAndDrop(redSource, destination).build().perform();;
		a.dragAndDrop(greenSource, destination).build().perform();;
		a.dragAndDrop(blueSource, destination).build().perform();;
		//a.dragAndDropBy(source, 200, 0).build().perform();
	}
}
