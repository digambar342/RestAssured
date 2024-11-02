package restAssured.RestAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getGlobalValues("baseURL");
	}
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\DIGAMBAR\\workspace_Oxygen\\RestAutomation_Framework\\src\\test\\java\\resources\\globalValues.properties");
		prop.load(fis);
		System.out.println(prop.getProperty(key));
		return prop.getProperty(key);
		
		
	}

}
