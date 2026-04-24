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

public class DragAndDropDemo extends BaseTest{
	
	@Test
	public void DragAndDropTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
			
		
		//appium github gestures
		//click on views 
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 620,
			    "endY", 628
			));
		
		Thread.sleep(2000);
	
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "Dropped!");
 
	}

}


































