import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class demo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		File sr=new File("src");
		File fs=new File(sr,"General-Store.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		
				
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Vicky_Emulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

	}

}
