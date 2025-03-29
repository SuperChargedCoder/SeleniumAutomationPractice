package testDataSetupTestNG;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderHashMap {

	@Test (dataProvider = "UserAddress")
	public void ReadTestData(HashMap<Object, Object> input) {
		System.out.println(input.get("name") + "***" + input.get("address") + "***" + input.get("age"));
	}
	
	@DataProvider (name = "UserAddress")
	public Object[][] TestDataProvider() {
		HashMap<Object, Object> mapOne = new HashMap<Object, Object>();
		mapOne.put("name", "Shubham");
		mapOne.put("address", "Gorakhpur");
		mapOne.put("age", 25);
		HashMap<Object, Object> mapTwo = new HashMap<Object, Object>();
		mapTwo.put("name", "Deepak");
		mapTwo.put("address", "Allahabad");
		mapTwo.put("age", 26);
		return new Object[][] {{mapOne}, {mapTwo}};
	}
}
