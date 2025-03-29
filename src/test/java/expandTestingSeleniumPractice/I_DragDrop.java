package expandTestingSeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class I_DragDrop extends BaseTest{
	
	@Test
	public void DragDrop() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("column-a"));
		WebElement destination = driver.findElement(By.id("column-b"));
		Thread.sleep(1500);
		a.dragAndDrop(source, destination).build().perform();;
		//a.dragAndDropBy(source, 200, 0).build().perform();
	}
	
}
