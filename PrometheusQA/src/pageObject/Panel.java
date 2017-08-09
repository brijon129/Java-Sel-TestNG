package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Panel {
	private static WebElement element = null;
	
	public static WebElement btn_Content(WebDriver driver) {

		element = driver.findElement(By.className("togglelink"));
		
		return element;

	}
	
	public static String content_is_hidden(WebDriver driver) {
		String linkText = driver.findElement(By.className("togglelink")).getText();
		return linkText;

	}	
	
}
