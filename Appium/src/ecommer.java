import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommer extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

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
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		int count2=driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		int sum=count2-count;
		System.out.println(sum);
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i+sum).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(500);
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println(lastpageText);
		Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}
}
