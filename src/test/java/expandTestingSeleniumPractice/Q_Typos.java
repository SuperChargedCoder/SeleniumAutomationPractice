package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Q_Typos extends BaseTest{
	
	@Test
	public void FindTypo() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/typos");
		String correctText = "Sometimes you'll see a typo, other times you won't.";
		WebElement typoText = driver.findElement(By.xpath("//div[@class='page-layout']/div/p[2]"));
		while (!correctText.equalsIgnoreCase(typoText.getText().toString())) {
			driver.navigate().refresh();
			Thread.sleep(3000);
			typoText = driver.findElement(By.xpath("//div[@class='page-layout']/div/p[2]"));
		}
		Assert.assertEquals(typoText.getText().toString(), correctText);
	}

}
