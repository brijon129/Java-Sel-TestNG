package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject_imgur.Header;
import pageObject_imgur.Popup;
import pageObject_imgur.Url;

public class TestNG_imgur {
	public WebDriver driver;

	/*
	 * Test 1: Step 1 - Go to https://www.imgur.com/ Step 2 - Click new post. Step 3
	 * - Upload URL. Step 4 - Assert you are taken to the image link
	 */

	@Test(priority = 0)
	public void test_1() throws InterruptedException {

		Header.btn_upload(driver).click();
		Thread.sleep(1000);
		Popup.txtbx_upload(driver, "https://i.ytimg.com/vi/hSVbzhT-Is4/maxresdefault.jpg").sendKeys(" ");
		Thread.sleep(1000);
		Assert.assertTrue(Url.get_url(driver) != "https://www.imgur.com/" );
	}

	@BeforeMethod

	public void beforeMethod() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.imgur.com/"); // target page

	}

	@AfterMethod

	public void afterMethod() {

		driver.quit();

	}
}
