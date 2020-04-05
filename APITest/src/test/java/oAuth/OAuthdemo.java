package oAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OAuthdemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Udemy\\General Automation\\ChromeDriver\\chromedriver_80.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signin/oauth/identifier?client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&as=SYs7sbuCPUW2UQBxx2XQxA&destination=https%3A%2F%2Frahulshettyacademy.com&approval_state=!ChRvaWZYb1RhSFVTa0xZVGQ5eTNPWhIfa3h3a3Z5ck1kN3NXOEhuU1JuY2dubXEtSDlpU0ZCYw%E2%88%99AF-3PDcAAAAAXorV-9J1e0qeXFWix5KCeNwt_5LiWFOZ&oauthgdpr=1&xsrfsig=ChkAeAh8TxofG5SbJM17T89lsXchkluj3Z"
						+ "crEg5hcHByb3ZhbF9zdGF0ZRILZGVzdGluYXRpb24SBXNvYWN1Eg9vYXV0aHJpc2t5c2NvcGU&flowName=GeneralOAuthFlow");
		driver.findElement(By.id("identifierId")).sendKeys("vickybhu2036");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(15000);
		String URL = driver.getCurrentUrl();
		System.out.println("URL: " + URL);
		String partialcode = URL.split("code=")[1];
		String Code = partialcode.split("&scope")[0];
		System.out.println("Code: " + Code);
		driver.quit();

		// Accesstoken
		String AccessTokenjs = given().urlEncodingEnabled(false).queryParams("code", Code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println("AccessToken :" + AccessTokenjs);

		JsonPath js = new JsonPath(AccessTokenjs);
		String AccessToken = js.getString("access_token");

		String response = given().queryParam("access_token", AccessToken).when()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();

		System.out.println("Response :" + response);

	}

}
