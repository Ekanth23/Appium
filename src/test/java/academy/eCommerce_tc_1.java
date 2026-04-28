package academy;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {
	
	//Fill Form Test
	
	@Test
	public void FillForm() throws InterruptedException
	{
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ekanth"); 
		driver.hideKeyboard(); 
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click(); 
	
		driver.findElement(By.id("android:id/text1")).click();
		
		scrollToText("Argentina");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click(); 

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
		
		Thread.sleep(2000);
	//Toast Message tag name: //android.widget.Toast
	//Toast attribute is name attribute
		@Nullable
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
	
	}
	
	

}
