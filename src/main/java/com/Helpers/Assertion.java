package com.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base;
import com.base.Locators;

import org.testng.Assert;

public class Assertion extends Base {
       
	
	 public static void expectToEqual(Object result, Object expectedResult, String errorMessage) {
		
	        Assert.assertEquals(result, expectedResult, errorMessage);
	    }

	    public static void expectToNotEqual(Object result, Object expectedResult, String errorMessage) {
	        Assert.assertNotEquals(result, expectedResult, errorMessage);
	    }

	    public static void expectToDisplay(WebElement element, String errorMessage) throws Exception {
	        Assert.assertTrue(element.isDisplayed(), errorMessage);
	    }
	    
	    public static void expectToDisplay(Locators type, By value, String errorMessage) throws Exception {
	        WebElement element = element(type, value); 
	        Assert.assertTrue(element.isDisplayed(), errorMessage);
	    }

	    public static void expectToNotDisplay(WebElement element, String errorMessage) throws Exception {
	        Assert.assertFalse(element.isDisplayed(), errorMessage);
	    }
	    
	    public static void expectToBeEnabled(WebElement element, String errorMessage) throws Exception {
	        Assert.assertTrue(element.isEnabled(), errorMessage);
	    }

	    public static void expectToBeDisabled(WebElement element, String errorMessage) throws Exception {
	        Assert.assertFalse(element.isEnabled(), errorMessage);
	    }

	
	
}

