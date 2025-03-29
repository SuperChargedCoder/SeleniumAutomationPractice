package testDataSetupTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderMultiDimentionalArray {

	@Test (dataProvider = "UserAddress")
	public void ReadTestData(String name, String address) {
		System.out.println(name + "***" + address);
	}
	
	@DataProvider (name = "UserAddress")
	public Object[][] TestDataProvider() {
		Object[][] testData = new Object[3][2]; // 3 test record with 2 values in each record
		testData[0][0] = "Shubham";
		testData[0][1] = "Gorakhpur";
		testData[1][0] = "Deepak";
		testData[1][1] = "Allahabad";
		testData[2][0] = "Pranesh";
		testData[2][1] = "Jaipur";
		/*OR*/
		Object[][] testDataWayTwo = new Object[][] {{"Shubham", "Gorakhpur"},{"Deepak", "Allahabad"}, {"Pranesh", "Jaipur"}};
		return testDataWayTwo;
	}

}
