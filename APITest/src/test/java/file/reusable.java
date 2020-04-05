package file;

import io.restassured.path.json.JsonPath;

public class reusable {

	public static JsonPath rawToJson(String response){
		JsonPath js=new JsonPath(response);
		return js;
	}
}
