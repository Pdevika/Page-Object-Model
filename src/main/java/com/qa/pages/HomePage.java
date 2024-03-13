package com.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utilities.TestUtil;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Devika")
	@CacheLookup
	public WebElement UsernameLabel;
	
	@FindBy(linkText = "Shop Deals")
	public WebElement ShopDeals;
	
	
	@FindBy(linkText = "Registry")
	public WebElement Registry;
	
	@FindBy(xpath = "//span[@class='etsy-icon wt-mr-xs-1 wt-icon--smaller']")
	public WebElement DropDown;
	
	@FindBy(xpath = "//div[@role = 'menu']//a")
	public List<WebElement> dropdownlist;
	
	public String validateHomePageTitle() throws InterruptedException {
		
		Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(TestUtil.WAIT, TimeUnit.SECONDS);
		return driver.getTitle();
		
	}
	
	public boolean verifyUsername() throws InterruptedException {
		Thread.sleep(5000);
	return	UsernameLabel.isDisplayed();
	}
	
	public ShopDealsPage clickOnShopDeals () throws IOException {
		
		jse.executeScript("arguments[0].click();", ShopDeals);
		return new ShopDealsPage();
	}
	

public RegistryPage clickOnRegistry () throws IOException {
		
	jse.executeScript("arguments[0].click();", Registry);
		return new RegistryPage();
	}
	
public int validateDropDownList () throws InterruptedException {
		
	
	jse.executeScript("arguments[0].click();", DropDown);
    int i =	dropdownlist.size();
    return i;
		
}

}
 