import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class chromeauto extends basereal {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("https://www.facebook.com");
//		driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("Heello");
//		driver.findElementByXPath("//*[@id='m_login_password']").sendKeys("Hime");
//		driver.findElementByXPath("//button[@name='login']").click();
		
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		   jse.executeScript("window.scrollBy(0,900)", "");
		  System.out.println(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
	}

}
