package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
//WebResponsive
//appium inspecter only for mobile apps 
public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void browserTest() throws InterruptedException
	{
//		driver.get("http://google.com");
//		System.out.println( driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("Ekanth"); 
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); 
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click(); 
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		//scroll mobile web
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		
		Thread.sleep(2000);
		Assert.assertEquals(text, "Devops");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
