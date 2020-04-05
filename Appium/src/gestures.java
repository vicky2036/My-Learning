import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static java.time.Duration.ofSeconds;

public class gestures extends base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//Tap
		TouchAction t= new TouchAction(driver);
		WebElement expandList=driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		WebElement longpr=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(longpr)).withDuration(ofSeconds(2))).release().perform();
		
	}

}
