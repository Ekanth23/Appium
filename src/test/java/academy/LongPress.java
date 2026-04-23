package academy;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress extends BaseTest{
	
	@Test
	public void longPressGestore() throws MalformedURLException, URISyntaxException, InterruptedException
	{
			
		//Gestures
		//click on views 
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//click on the expandabe list 
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		
		//custom developer 
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//google search
		//appium github gestures
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration", 2000));
		
		Thread.sleep(2000);
		
		
 
	}

}


































