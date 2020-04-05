package sample;

import org.testng.annotations.Test;

import file.payload;
import file.reusable;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Sumvalidation {
int Sum =0;
	@Test
	void SumOfCourses(){
		JsonPath js=reusable.rawToJson(payload.Courseprice());
		int ActualPrice =js.getInt("dashboard.purchaseAmount");
		int count =js.getInt("courses.size()");
		for (int i=0;i<count;i++){
			int Price=js.get("courses["+i+"].price");
			int Copies=js.get("courses["+i+"].copies");
			Sum=Sum+(Price*Copies);
		}
		System.out.println("Sum:"+Sum);
		Assert.assertEquals(Sum, ActualPrice);
	}
}
