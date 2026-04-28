package academy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_2 extends BaseTest {
	
	//add to cart test
	
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
		
		scrollToText("Jordan 6 Rings");
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i=0; i<productCount; i++)
		{
			String prodName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(prodName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/counterText")).click(); 
		
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		ww.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String prodinCart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		Assert.assertEquals(prodinCart, "Jordan 6 Rings");
	
	
	
	}
	
	

}
