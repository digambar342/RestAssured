package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req; // Static because 1 instance to be created for all round of execution
	public static PrintStream log;
	public static RequestSpecification requestSpecification() throws IOException {
		//RestAssured.baseURI= "https://reqres.in/";
		
		if(req==null) {
		log=new PrintStream(new FileOutputStream("logging.txt"));
		req= new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURL"))
				.addHeader("Content-Type","application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return req;
		}
		return req;
	}
	
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\DIGAMBAR\\workspace_Oxygen\\RestAutomation_Framework\\src\\test\\java\\resources\\globalValues.properties");
		prop.load(fis);
		System.out.println(prop.getProperty(key));
		return prop.getProperty(key);
	}
}
