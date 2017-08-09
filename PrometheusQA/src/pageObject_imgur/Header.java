package pageObject_imgur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
	private static WebElement element = null;

	public static WebElement btn_upload(WebDriver driver) {
		
		element = driver.findElement(By.className("upload-btn-text"));
		
		return element;

	}
}
