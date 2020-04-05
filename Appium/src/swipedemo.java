import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static java.time.Duration.ofSeconds;

public class swipedemo extends base {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		TouchAction t= new TouchAction(driver);
		// longpress for 2 sec then move to another element and release it
		WebElement strt=driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement stp=driver.findElement(By.xpath("//*[@content-desc='45']"));
		t.longPress(longPressOptions().withElement(element(strt)).withDuration(ofSeconds(2)))
		.moveTo(element(stp)).release().perform();
	}
}
