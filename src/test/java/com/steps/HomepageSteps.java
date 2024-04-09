package com.steps;

import com.Helpers.Action;
import com.Helpers.Assertion;
import com.Helpers.TextConstants;
import com.base.Base;
import com.base.Locators;
import com.pages.Homepage;

public class HomepageSteps extends Base {

    private Homepage homepagePage;

    public HomepageSteps() {
        homepagePage = new Homepage();  
    }

    public void displayedOnHeaders() throws Exception {
        String solutionsText = homepagePage.getSolutionsLinkText();  
        Assertion.expectToEqual(solutionsText, TextConstants.COMPANY.getText(), "Solution link text is incorrect");

        String whyOrangeHRMText = homepagePage.getWhyOrangeHRMLinkText();
        Assertion.expectToEqual(whyOrangeHRMText, "Why OrangeHRM", "Why OrangeHRM link text is incorrect");

        String resourcesText = homepagePage.getResourcesLinkText();
        Assertion.expectToEqual(resourcesText, "Resources", "Resources link text is incorrect");

        String companyText = homepagePage.getCompanyLinkText();
        Assertion.expectToEqual(companyText, "Company", "Company link text is incorrect");
    }

}