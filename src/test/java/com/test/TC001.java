package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Base;
import com.base.Browser;
import com.steps.HomepageSteps;

public class TC001 	extends Base {
	private HomepageSteps homepageSteps;

    @BeforeTest
    public void setupTest() {
        browseropen();
         
    }

    @Test (description = "Confirm All Headers displayed in Webpage ", priority= 1)
    public void HeaderVerify() throws Exception {
    	homepageSteps = new HomepageSteps(); 
        homepageSteps.displayedOnHeaders();
    }

    @AfterTest
    public void tearDownTest() {
        quit();  
    }
	
}
