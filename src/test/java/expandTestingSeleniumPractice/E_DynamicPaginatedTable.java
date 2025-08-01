package expandTestingSeleniumPractice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E_DynamicPaginatedTable extends BaseTest {
	
	@Test
	public void TestingTableShorting() {
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
		//Getting the details of last in order shorted by 'Student Name'
		driver.findElement(By.xpath("//th[text()='Student Name']")).click();
		String lastShortedStudent = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//ul[@class='pagination']/li[not(@id)][4]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText(), lastShortedStudent);
	}
}
