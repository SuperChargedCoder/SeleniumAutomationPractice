package expandTestingSeleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D_DynamicTable extends BaseTest {
	
	@Test
	public void DynamicTableHandle() {
		driver.get("https://practice.expandtesting.com/dynamic-table");
		String chromeCPU = driver.findElement(By.id("chrome-cpu")).getText();
		String chromeCPUValue = chromeCPU.split(" ")[2];
		Assert.assertEquals(chromeCPUValue, GetDataFromDynamicTable(driver));
	}
	
	public static String GetDataFromDynamicTable(WebDriver driver) {
		return driver.findElement(By.xpath("//tbody/tr["+getIndexOfChrome(driver)+"]/td[" + getIndexOfCPU(driver) + "]")).getText();
	}
	
	
	public static int getIndexOfCPU(WebDriver driver) {
		List<WebElement> columnWebElement = driver.findElements(By.xpath("//thead/tr/th"));
		ArrayList<String> columnNames = new ArrayList<>();
		for (WebElement a : columnWebElement) {
			columnNames.add(a.getText().toString());
		}
		return columnNames.indexOf("CPU") + 1;
	}
	
	public static int getIndexOfChrome(WebDriver driver) {
		List<WebElement> rowWebElement = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		ArrayList<String> rowNames = new ArrayList<>();
		for (WebElement a : rowWebElement) {
			rowNames.add(a.getText().toString());
		}
		return rowNames.indexOf("Chrome") + 1;
	}
}
