package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payload {
	
	public static String AddPlace() {
		
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383493,\r\n" + 
				"    \"lng\": 33.427363\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 51,\r\n" + 
				"  \"name\": \"Vicky housesws\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3999\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 120\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe parkns\",\r\n" + 
				"    \"shops\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://vicky.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
		
	}
	
	public static String UpdatePlace(){
		
		return "{\r\n" + 
				"\"place_id\":\"ac49706efa7dfc4c270a01277e741e95\",\r\n" + 
				"\"address\":\"70 Summer walk 123, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	
	public static String Courseprice(){
		
		return "{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
	}
	
	public static String AddBook(String isbn, String aisle){
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with allan\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
	}
	
	public static String convertJsontfiletoString(String filepath) throws IOException{
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	

}
