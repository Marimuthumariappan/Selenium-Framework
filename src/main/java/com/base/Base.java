package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base  {

	long Timeouts = 30;
	long MaxwaitTime = 10;
	protected static RemoteWebDriver driver = null;
	public WebDriverWait wait = null;

	public void browseropen(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, MaxwaitTime);

	}

	public void setup(Browser browsername, String url) {
		switch (browsername) {
		case CHROME:
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		case EDGE:
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Driver is not defined");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public WebElement element(Locators type, String value) {

		try {
			switch (type) {
			case id:
				return driver.findElementById(value);

			case name:
				return driver.findElementByName(value);

			case classname:
				return driver.findElementByClassName(value);

			case tagname:
				return driver.findElementByTagName(value);

			case xpath:
				return driver.findElementByXPath(value);

			case css:
				return driver.findElementByCssSelector(value);
			default:
				break;
			}
		} catch (NoSuchElementException E) {
			System.err.println("Element is Not Found" + E.getMessage());
			throw new NoSuchElementException("Element not found");
		}

		return null;
	}



	
	


}
