package academy;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException
	{
		//code to start the server programmatically 
			
		//id, xpath, accessibilityid, classname, androidUIAutomator
		//configureAppium() method to start server will be executed first 
		//click Preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		//click on the wifi checkbox 
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
		//click on the wifisetting
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//xpath syntax
		//tagName[@attribu
	
 
	}

}


































