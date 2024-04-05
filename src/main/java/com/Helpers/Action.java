package com.Helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.base.Base;

public class Action extends Base {

	public void click(WebElement element) {

		WebElement ELEMENT = wait.withMessage("Element is Not Clickable")
				.until(ExpectedConditions.elementToBeClickable(element));
		ELEMENT.click();
	}

	public void type(WebElement element, String Testdata) {
		try {
			WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(element));
			ELEMENT.clear();
			ELEMENT.sendKeys(Testdata);
		} catch (NullPointerException e) {
			System.err.println("Element is Null" + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void typeandEnter(WebElement elemnt, String Testdata, Keys key) {
		WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOf(elemnt));
		ELEMENT.clear();
		ELEMENT.sendKeys(Testdata, key);
	}

	public boolean Selectbyvalue(WebElement element, String value) {
		boolean flag = false;

		try {
			Select select = new Select(element);
			select.selectByValue(value);
			flag = true;
			return true;
		} catch (NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
			return false;
		} finally {
			if (flag) {
				System.out.println("Option is selected");
			} else {
				System.err.println("Option is not selected");
			}
		}

	}

	public boolean selectbyText(WebElement element, String value) {
		boolean flag = false;

		try {
			Select select = new Select(element);
			select.deselectByVisibleText(value);
			flag = true;
			return true;

		} catch (NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
			return false;
		} finally {
			if (flag) {
				System.out.println("Option is selected");
			} else {
				System.err.println("Option is not selected");
			}
		}
	}

	public boolean selectbyIndex(WebElement element, int position) {

		boolean flag = false;

		try {
			Select select = new Select(element);
			select.selectByIndex(position);
			flag = true;
			return true;

		} catch (NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
			return false;
		} finally {
			if (flag) {
				System.out.println("Option is selected");
			} else {
				System.err.println("Option is not selected");
			}
		}
	}
	public String  Getcurrenturl() {
		
           return driver.getCurrentUrl();
	}

}
