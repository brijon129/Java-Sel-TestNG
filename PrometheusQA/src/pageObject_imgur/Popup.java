package pageObject_imgur;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Popup {
	private static WebElement element = null;
/*
 * JavaScript required to paste data into the input box.
 */
	public static WebElement txtbx_upload(WebDriver driver, String image_link) {

		element = driver.findElement(By.id("paste-url-input"));
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='" + image_link + "'", element);

		return element;
	}

}
