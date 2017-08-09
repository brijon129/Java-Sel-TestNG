package pageObject_imgur;

import org.openqa.selenium.WebDriver;

public class Url {

	public static String get_url(WebDriver driver) {

		String url = driver.getCurrentUrl();
		return url;
	}
}