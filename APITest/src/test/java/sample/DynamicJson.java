package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import file.payload;
import file.reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	// Add Book

	@Test(dataProvider="BooksData")
	public void addBook(String isbn , String alise){
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.AddBook(isbn,alise))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=reusable.rawToJson(response);
		String ID=js.getString("ID");
		System.out.println("ID: "+ID);
		
		// Delete book
		
		
	}
	
		
	@DataProvider(name="BooksData")
	public Object[][] getData(){
		return new Object[][]{{"suny","50"},{"buny","60"},{"any","70"}};
	}
}
