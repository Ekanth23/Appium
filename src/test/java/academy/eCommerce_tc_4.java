package academy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4 extends BaseTest {
	
	//handling Hybrid app and switching to WebView 
	
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ekanth"); 
		driver.hideKeyboard(); 
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); 
		driver.findElement(By.id("android:id/text1")).click();
		scrollToText("Argentina");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); 
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
		
		Thread.sleep(2000);
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		////ADD TO CART will turn into ADDED TO CART so again in 0th index the next product will be there
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click(); 
		
		Thread.sleep(2000);
			
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		ww.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> priceList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = priceList.size(); 
		
		double total=0; 
		
		for (int i=0; i<count; i++)
		{
			String priceString = priceList.get(i).getText();
			double price = Double.parseDouble(priceString.substring(1));
			total = total + price; 
		}
		
		System.out.println(total);
		
		String displayedPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double dislayedAmount = getStringToDouble(displayedPrice);
		Assert.assertEquals(total, dislayedAmount);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click(); 
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click(); 
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		//Hybrid app - Google page 
		Set<String> contexts = driver.getContextHandles();
		
		for(String context:contexts)
		{
			System.out.println(context);
//			if (context.contains("WEBVIEW"))
//		    {
//		        driver.context(context);
//		        break;
//		    }
		}
//		"WEBVIEW_com.androidsample.generalstore"
		driver.context("WEBVIEW_com.androidsample.generalstore"); 
		driver.findElement(By.name("q")).sendKeys("Ekanth"); 
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); 
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
		
		
	
	
	}
	
	
	
	

}
