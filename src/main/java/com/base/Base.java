package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    long Timeouts = 30;
    long MaxwaitTime = 10;
    public static WebDriver driver;
    public WebDriverWait wait;

    public void browseropen() {
    	 WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
        driver.get("https://www.orangehrm.com/");
    }

    public void setup(Browser browsername, String url) {
        try {
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
            driver.get(url);
        } catch (Exception e) {
            System.err.println("Error during driver setup: " + e.getMessage());
            e.printStackTrace();  
        }
    }
    public static WebElement element(Locators type, By value) {

		try {
			switch (type) {
			case ID:
				return driver.findElement(value);

			case NAME:
				return driver.findElement(value);

			case CLASSNAME:
				return driver.findElement(value);

			case TAGNAME:
				return driver.findElement(value);

			case XPATH:
				return driver.findElement(value);

			case CSS:
				return driver.findElement(value);
			default:
				break;
			}
		} catch (NoSuchElementException E) {
			System.err.println("Element is Not Found" + E.getMessage());
			throw new NoSuchElementException("Element not found");
		}

		return null;
	}

    
    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }
    
    }




	
	



