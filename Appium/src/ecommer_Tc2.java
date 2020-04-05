import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.*;
import static io.appium.java_client.touch.LongPressOptions.*;
import static io.appium.java_client.touch.offset.ElementOption.*;
import static java.time.Duration.ofSeconds;

public class ecommer_Tc2 extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		double sum = 0;
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		// As we clicked the first add to card the name will be changed to added to cart
		// so nxt will be get(0)
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(500);
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for (int i = 0; i < count; i++) {
			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			double amount = getAmount(amount1);
			sum = sum + amount;
		}
		System.out.println("Calculated Value: " + sum);
		String totalact = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		totalact = totalact.substring(1);
		double dbtotalact = Double.parseDouble(totalact);
		System.out.println("Actual Value: " + dbtotalact);

		Assert.assertEquals(sum, dbtotalact, 1);
		// Mobile Gestures
		
		WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t= new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement Terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(Terms)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

	public static double getAmount(String Value) {
		Value = Value.substring(1);
		double amount = Double.parseDouble(Value);
		return amount;

	}

}
