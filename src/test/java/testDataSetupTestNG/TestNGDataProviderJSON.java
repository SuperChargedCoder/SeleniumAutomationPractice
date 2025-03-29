package testDataSetupTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestNGDataProviderJSON {
	
	String testDataFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\testDataSetupTestNG\\Automation.json";
	
	@Test (dataProvider = "JSONDataReader")
	public void PrintJSONData(HashMap<String, String> input) {
		System.out.println("ToolUserd : " + input.get("functional"));
		System.out.println("Framework : " + input.get("framework"));
		System.out.println("CodingLanguage : " + input.get("programingLanguage"));
		System.out.println("");
	}
	
	@DataProvider (name = "JSONDataReader")
	public Object[][] TestData() throws IOException {
		List<HashMap<String, String>> jsonTestData = ReadJSON(testDataFilePath);
		return new Object[][] {{jsonTestData.get(0)}, {jsonTestData.get(1)}, {jsonTestData.get(2)}};
	}
	
	public List<HashMap<String, String>> ReadJSON(String filepath) throws IOException {
		String json2string = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(json2string, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}
}
