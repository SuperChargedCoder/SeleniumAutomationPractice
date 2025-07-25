package advanceSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import expandTestingSeleniumPractice.BaseTest;

public class BrokenLinkCheck extends BaseTest {
	
	@Test
	public void AmazonBrokenLinkTest() throws MalformedURLException, IOException {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		SoftAssert a = new SoftAssert();
		for (WebElement link : links) {
			String weblink = link.getAttribute("href");
			HttpURLConnection con = (HttpURLConnection)(new URL(weblink).openConnection());
			con.setRequestMethod("GET");
			con.connect();
			int responseCode = con.getResponseCode();
			a.assertTrue(responseCode<400);
		}
		a.assertAll();
	}
}
