package academy;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppium extends BaseTest{
	
	@Test
	public void MiscellaneousTest() throws MalformedURLException, URISyntaxException
	{
//App package & App Activity
		
//		Activity activity = new Activity(); 

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		//click on the wifi checkbox 
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
//Rotate	
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		
		driver.rotate(landscape); 
		
		//click on the wifisetting
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		//assert the popup wifi window
		String wifiAlertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiAlertTitle, "WiFi settings");
//copy paste
//copy to clipboard - past it to clipboard 
		driver.setClipboardText("Ekanth wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//click on the ok wifi setting 
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
//press key
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
 
	}

}


































