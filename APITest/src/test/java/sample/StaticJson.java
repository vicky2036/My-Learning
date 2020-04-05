package sample;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import file.payload;
import file.reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson {
	
	@Test
	public void addBook() throws IOException{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(payload.convertJsontfiletoString("Response.json"))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=reusable.rawToJson(response);
		String ID=js.getString("ID");
		System.out.println("ID: "+ID);
		
		// Delete book
		
		
	}
	

}
