package pageObject;

import org.openqa.selenium.*;

public class Search_Bar {
	private static WebElement element = null;

	public static WebElement txtbx_SearchBar(WebDriver driver) {

		element = driver.findElement(By.id("searchInput"));

		return element;

	}

	public static WebElement btn_Search(WebDriver driver) {

		element = driver.findElement(By.className("pure-button"));
		
		return element;

	}
	

	public static WebElement select_dropdown(WebDriver driver, String searchPhrase) {
		String xpathlink = "//a[contains(@href,'" + searchPhrase + "')]";
		element = driver.findElement(By.xpath(xpathlink));
		return element;
	}
}
