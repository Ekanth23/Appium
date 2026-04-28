package academy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest {
	
	//Asset the more than one product total amount 
	
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
		Thread.sleep(2000);
		
		//Hybrid app - Google page 
		
		
		
		
		
		
	
	
	}
	
	

}
