/*
 * @author Brian Li
 * @version 1.0 8/7/2017
 */

package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.Panel;
import pageObject.Search_Bar;
import pageObject.Title_Page;

public class TestNG_wikipedia {

	public WebDriver driver;

	/*
	 * Test 1: Basic Search Bar Test Step 1 - Go to https://www.wikipedia.org/ Step
	 * 2 - Type “Puppies” into the Search Bar Step 3 - Click on the Search Button
	 * Assert - You are on the wikipedia page for Puppies
	 */
	@Test(priority = 0)

	public void test_1() throws InterruptedException {

		Search_Bar.txtbx_SearchBar(driver).sendKeys("puppy");
		Search_Bar.btn_Search(driver).click();
		String pageTitle = Title_Page.txt_title(driver);
		Assert.assertTrue(pageTitle.toLowerCase().contains("puppy"));

	}

	/*
	 * Test 2 - Hide Contents Test Step 1 - On the Puppies page, find the “Contents”
	 * panel. Step 2 - Click the button to hide the panel Assert - The Panel is
	 * hidden
	 */
	@Test(priority = 1)

	public void test_2() throws InterruptedException {

		Search_Bar.txtbx_SearchBar(driver).sendKeys("puppy");
		Search_Bar.btn_Search(driver).click();
		Panel.btn_Content(driver).click();
		String linkText = Panel.content_is_hidden(driver);
		Assert.assertTrue(linkText.toLowerCase().contains("show"));
		Thread.sleep(2000);

	}

	/*
	 * Test 3 - Auto complete Search Test Step 1 - On the Puppies page, find the
	 * Search bar. Step 2 - Type “Franc” into the Search bar. Step 3 - The auto
	 * complete should drop down, Click on “France” Assert - You are taken to the
	 * page for France
	 */
	@Test(priority = 2)

	public void test_3() throws InterruptedException {

		Search_Bar.txtbx_SearchBar(driver).sendKeys("puppy");
		Search_Bar.btn_Search(driver).click();
		Search_Bar.txtbx_SearchBar(driver).sendKeys("Franc");
		Search_Bar.select_dropdown(driver, "France").click();
		String pageTitle = Title_Page.txt_title(driver);
		Assert.assertTrue(pageTitle.toLowerCase().contains("france"));

	}

	@BeforeMethod

	public void beforeMethod() {

		// System.setProperty("webdriver.gecko.driver",
		// "/Users/bli/selenium-java/geckodriver"); // gecko required for firefox
		// testing
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/"); // target page

	}

	@AfterMethod

	public void afterMethod() {

		driver.quit();

	}

}