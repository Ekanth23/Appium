import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {

	@Test
	public void IOSBasicsTest() {

		// Xpath, classname, IOS, iosClassChain, IOSPredicateString, accessibility id,
		// id

		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

		// Xpath - XML language - App source
		// driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text
		// Entry']")).click();

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello world");

		driver.findElement(AppiumBy.accessibilityId("OK")).click();

		// driver.findElement(AppiumBy.iOSNsPredicateString(
		// "type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"
		// ));

		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'"))
				.click();

		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

		// driver.findElement(AppiumBy.iOSNsPredicateString(
		// "type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"
		// ));
	}
}