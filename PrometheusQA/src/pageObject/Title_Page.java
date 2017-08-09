package pageObject;

import org.openqa.selenium.*;

public class Title_Page {
	public static String txt_title(WebDriver driver) {
		String bodyText = driver.findElement(By.id("firstHeading")).getText();
		return bodyText;
	}
}
