package jbkProjectFramework.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class UtilTest {

	public static WebDriver urlOpen(WebDriver driver,String browser,String url)
	{

		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\drivers\\chromedriver.exe");

			driver= new ChromeDriver();
			driver.get(url);
			return driver;


		case "firefox":
			System.setProperty("webdriver..driver", "D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\drivers\\chromedriver.exe");

			driver= new FirefoxDriver();
			driver.get(url);
			return driver;
		case "safari":
			//System.setProperty("webdriver.chrome.driver", "D:\\java jdk\\jbkProjectFramework\\src\\main\\java\\jbkProjectFramework\\drivers\\chromedriver.exe");

			driver= new SafariDriver();
			driver.get(url);
			return driver;
		}
		return null;
	}

	public static void sendKeysValue(WebDriver driver,String locator,String locatorValue,String textValue)
	{

		switch(locator)

		{
		case "id":
			driver.findElement(By.id(locatorValue)).sendKeys(textValue);
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).sendKeys(textValue);
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).sendKeys(textValue);
			break;
		case "linkText":
			driver.findElement(By.linkText(locatorValue)).sendKeys(textValue);
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(textValue);
			break;
		case "className":
			driver.findElement(By.className(locatorValue)).sendKeys(textValue);
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(textValue);
			break;
		case "tagName":
			driver.findElement(By.tagName(locatorValue)).sendKeys(textValue);
			break;

		}
	}

	public static void clickElement(WebDriver driver,String locator,String locatorValue)
	{



		switch(locator)

		{
		case "id":
			driver.findElement(By.id(locatorValue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(locatorValue)).click();
			break;
		case "name":
			driver.findElement(By.name(locatorValue)).click();
			break;
		case "linkText":
			driver.findElement(By.linkText(locatorValue)).click();
			break;
		case "cssSelector":
			driver.findElement(By.cssSelector(locatorValue)).click();
			break;
		case "className":
			driver.findElement(By.className(locatorValue)).click();
			break;
		case "partialLinkText":
			driver.findElement(By.partialLinkText(locatorValue)).click();
			break;
		case "tagName":
			driver.findElement(By.tagName(locatorValue)).click();
			break;

		}

	}
	public static String getElementTitle(WebDriver driver,String locator,String locatorValue)
	{
		driver.findElement(By.id("email_error")).getText();
		String title;
		switch(locator)

		{
		case "id":
			title=driver.findElement(By.id(locatorValue)).getText();
			return title;

		case "xpath":
			title=	driver.findElement(By.xpath(locatorValue)).getText();
			return title;


		case "name":
			title=driver.findElement(By.name(locatorValue)).getText();
			return title;
		case "linkText":
			title=driver.findElement(By.linkText(locatorValue)).getText();
			return title;
		case "cssSelector":
			title=driver.findElement(By.cssSelector(locatorValue)).getText();
			return title;
		case "className":
			title=driver.findElement(By.className(locatorValue)).getText();
			return title;
		case "partialLinkText":
			title=	driver.findElement(By.partialLinkText(locatorValue)).getText();
			return title;
		case "tagName":
			title=driver.findElement(By.tagName(locatorValue)).getText();
			return title;

		}

		return null;

	}
}
