package jiraAutomate;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;

public class jira {
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8080";
		//login to create cookie
		SessionFilter session=new SessionFilter();
		String response= given().header("Content-Type","application/json")
		.body("{ \"username\": \"vickybhu2036\", \"password\": \"20365890\" }").filter(session).when().post("rest/auth/1/session")
		.then().log().all().extract().response().asString();
		
		//Add Comment
		String Message= "Comment passed to JIRA no:2";
		String CommentJS=given().pathParam("key", "10001").log().all().header("Content-Type","application/json")
		.body("{\r\n" + 
				"    \"body\": \""+Message+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(session).when().post("rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		JsonPath js=new JsonPath(CommentJS);
		String CommentID=js.getString("id");
	
		// Add Attachment
	/*given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10001")
		.header("Content-Type","multipart/form-data")
		.multiPart("file",new File("Jiratest.txt"))
		.when().post("rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		*/
		
		//Get Issue
		
		String IssueDetails= given().filter(session).pathParam("key", "10001").queryParam("fields", "comment")
		.when().get("rest/api/2/issue/{key}")
		.then().log().all().extract().response().asString();
		
		System.out.println("IssueDetails: " + IssueDetails);
		
		JsonPath js1=new JsonPath(IssueDetails);
		int cnt=js1.getInt("fields.comment.comments.size()");
		System.out.println("Count: "+cnt);
		for(int i=0;i<cnt;i++){
			String cntid=js1.get("fields.comment.comments["+i+"].id").toString();
			if(cntid.equalsIgnoreCase(CommentID)){
				String Commenttxt=js1.get("fields.comment.comments["+i+"].body").toString();
				System.out.println("Message: "+Commenttxt);
				Assert.assertEquals(Message, Commenttxt);
				break;
			}
		}
	}
}
