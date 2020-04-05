package sample;

import file.payload;
import file.reusable;
import io.restassured.path.json.JsonPath;

public class getNodeTest {

	public static void main(String[] args) {
		
		JsonPath js=reusable.rawToJson(payload.Courseprice());
		// Count of Course
		int count =js.getInt("courses.size()");
		System.out.println("count: "+count);
		// Print purchase amount
		int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println("totalAmount: "+totalAmount);
		// Print Title of First
		String FirstTitle=js.getString("courses[0].title");
		System.out.println("FirstTitle: "+FirstTitle);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		//Print all Course Title
		for (int i=0;i<count;i++){
			String Title=js.getString("courses["+i+"].title");
			int Price=js.get("courses["+i+"].price");
			System.out.println("Title: "+Title);
			System.out.println("Price: "+Price);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		for (int i=0;i<count;i++){
			String Title=js.getString("courses["+i+"].title");
			if(Title.equalsIgnoreCase("RPA")){
				int copies=js.getInt("courses["+i+"].copies");
				System.out.println("Title: "+Title);
				System.out.println("copies: "+copies);
				break;
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			
		}
	}

}
