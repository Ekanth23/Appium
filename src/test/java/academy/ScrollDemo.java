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

public class ScrollDemo extends BaseTest{
	
	@Test
	public void scrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
			
		//appium github gestures
		//click on views 
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//UI automator method for sroll 
		//this scroll is by google engine
		scrollToText("WebView");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
//		scrollToEndAction();
		Thread.sleep(2000);
 
	}

}


































