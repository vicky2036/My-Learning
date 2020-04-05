import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;

public class Draganddrop extends base {
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		
		TouchAction t= new TouchAction(driver);
		// longpress for 2 sec then move to another element and release it
		WebElement strt=driver.findElementsByClassName("android.view.View").get(0);
		WebElement stp=driver.findElementsByClassName("android.view.View").get(2);
		t.longPress(longPressOptions().withElement(element(strt)))
		.moveTo(element(stp)).release().perform();
		
	}
}
