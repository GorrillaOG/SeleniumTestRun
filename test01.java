/**
 * Automated Selenium Test Run
 * perfromed on youtube, google and wikipedia
 * Please follow instructions attached
 * 
 * @author  GORRILLA SOFT - Dmitriy F.
 * @version 1.0
 */
package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class test01 {

	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
    
// please Use The proper directory path where you have unzipped the chromedriver.exe file.

		System.setProperty("webdriver.chrome.driver",
				"C:chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();

		// Launch youtube
		driver.navigate().to("http://www.youtube.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		// search mozart on youtube
		WebElement element = driver.findElement(By.name("search_query"));

		element.sendKeys("mozart");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.sendKeys(Keys.RETURN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// clear the search query
		driver.findElement(By.name("search_query")).clear();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//search for mozard requiem instead
		driver.findElement(By.name("search_query")).sendKeys("mozart requiem");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.sendKeys(Keys.RETURN);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//open specific mozard requiem composition
		driver.findElement(By.xpath(
				"/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[2]/div[1]/div/div[1]/div/h3/a"))
				.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//check for ads on you tube
		if (driver.findElement(By.xpath(
				"/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[17]/div/div[3]/div/div[1]/span")) != null) {

			System.out.println("Adds. Adds can make this test brake.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
// if we have adds SKIP adds
			driver.findElement(By.xpath(
					"/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[17]/div/div[3]/div/div[2]/span/button/span"))
					.click();

		} else {
			System.out.println("No adds.");
			driver.findElement(By.xpath(
					"/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[17]/div/div[3]/div/div[2]/span/button/span"))
					.click();
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
// print put in Eclpise IDE console that we found searched composition.
		if (driver.getTitle().equals("Mozart - Requiem in D minor (Complete/Full) [HD] - YouTube")) {
			System.out.println("We found Mozart on youtube and listened to the music for a few seconds");

		} else {
			System.out.println("No Mozart Here...");
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
// end first operation
		driver.quit();
		System.out.println("Youtube run complete.");

		WebDriver driver1 = new ChromeDriver();

		driver1.manage().window().maximize();
//lunch google
		driver1.navigate().to("http://www.google.com/");
// search for mozard on internet
		WebElement element1 = driver1.findElement(By.name("q"));

		element1.sendKeys("mozart");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element1.sendKeys(Keys.RETURN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//open mozart page
		driver1.findElement(
				By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/a/h3"))
				.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//check for title of page
		if (driver1.getTitle().equals("Wolfgang Amadeus Mozart - Wikipedia")) {
			System.out.println("We found Mozart on internet. Lets get some facts about him");

		} else {
			System.out.println("No Mozart Here...");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//click on early life link, check if its there by text
		driver1.findElement(By.xpath("//a[@href='#Early_life']")).click();

		WebElement text1 = driver1.findElement(By.xpath("//*[text()='Early life']"));
		String text2 = "Early life";
		String text3 = text1.getText();

		if (text3.equals(text2)) {
//print data in Eclipse IDE, searched element and some text
			System.out.println("Element with getText(): " + text1.getText());
			System.out.println("Early years of Mozarts life section here.");
		} else {
			System.out.println("no mozart here..");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
// check vienna years, and print out found element
		driver1.findElement(By.xpath("//a[@href='#Vienna']")).click();

		WebElement text4 = driver1.findElement(By.xpath("//*[text()='Vienna']"));
		String text5 = "Vienna";
		String text6 = text4.getText();

		if (text6.equals(text5)) {

			System.out.println("Element with getText(): " + text4.getText());
			System.out.println("Time in Vienna spent by Mozart");
		} else {
			System.out.println("no mozart here..");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//check 1782 years, and print out found element
		driver1.findElement(By.xpath("//a[@href='#1782–87']")).click();

		WebElement text7 = driver1.findElement(By.xpath("//*[text()='1782–87']"));
		String text8 = "1782-87";
		String text9 = text7.getText();

		if (text8.equals(text9)) {

			System.out.println("Element with getText(): " + text7.getText());
			System.out.println("Mid life of Mozart");
		} else {
			System.out.println("no mozart here..");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
// check for last section, later years, if there print out in console again.
		driver1.findElement(By.xpath("//a[@href='#Later_years']")).click();

		WebElement text10 = driver1.findElement(By.xpath("//*[text()='Later years']"));
		String text11 = "Later years";
		String text12 = text10.getText();

		if (text11.equals(text12)) {

			System.out.println("Element with getText(): " + text10.getText());
			System.out.println("Almost at the end..");
		} else {
			System.out.println("no mozart here..");
		}

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver1.quit();
		System.out.println("Thank you for running with us! The END");
	}
}



