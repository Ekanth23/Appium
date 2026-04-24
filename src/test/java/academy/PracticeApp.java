package academy;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class PracticeApp extends BaseTest{
	
	@Test
	public void swipeDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
			
		//appium github gestures
		//click on views 
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();

		String alertMessage = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		System.out.println(alertMessage);
		
		
		
		
	}

}


































