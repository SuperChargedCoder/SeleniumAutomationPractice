package expandTestingSeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Y_MouseHover extends BaseTest {

	@Test
	public void MouseAction() {
		driver.get("https://practice.expandtesting.com/hovers");
		Actions a = new Actions(driver);
		WebElement userProfile = driver.findElement(By.xpath("//div[@class='figure'][3]"));
		a.moveToElement(userProfile).build().perform();
		a.click(driver.findElement(By.xpath("//div[@class='figure'][3]/div/a"))).build().perform();
		
	}
}
