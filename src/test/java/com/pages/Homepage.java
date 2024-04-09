package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class Homepage extends Base {
	public WebDriver driver;

    @FindBy(xpath = "//li//a[@class='nav-link-hed']")
    private WebElement solutionsLink;

    @FindBy(xpath = "//li//a[text()='Why OrangeHRM']")
    private WebElement whyOrangeHRMLink;

    @FindBy(xpath = "//li//a[text()='Resources']")
    private WebElement resourcesLink;

    @FindBy(xpath = "//li//a[@class='Company']")
    private WebElement companyLink;

    public void HomepagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSolutionsLinkText() {
        return solutionsLink.getText();
    }

    public String getWhyOrangeHRMLinkText() {
        return whyOrangeHRMLink.getText();
    }

    public String getResourcesLinkText() {
        return resourcesLink.getText();
    }

    public String getCompanyLinkText() {
        return companyLink.getText();
    }
}
	
	

