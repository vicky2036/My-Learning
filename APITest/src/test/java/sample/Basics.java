package sample;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import file.payload;
import file.reusable;

public class Basics {

	public static void main(String[] args) {
		
		// Add place--> Update Place with new Address--> Get Place to validate if New address is in 
		//given - all input details
		//when - submit the API - resource ,http methods
		// then - validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response: \n"+ response);
		JsonPath js=reusable.rawToJson(response);
		String placeId = js.getString("place_id");
		System.out.println("placeId : " +placeId);
		
		//Update place
		String NewAddress="70 Summer walk 123, USA52";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+NewAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		// Get Place
		
		String getplaceResponse =given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		.extract().response().asString();
		
		JsonPath js1=reusable.rawToJson(response);
		String NewAddressval=js1.get("address");
		System.out.println("Address : \n"+NewAddressval);
		Assert.assertEquals(NewAddressval, NewAddress);
	}

}
