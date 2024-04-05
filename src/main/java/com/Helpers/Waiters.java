package com.Helpers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class Waiters extends Base {
	
	public static long MaxwaitTime = 10;
    public static WebDriverWait wait = new WebDriverWait(driver, MaxwaitTime);
	public void waitwithsleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void waitForElementToBeDisplayed(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
