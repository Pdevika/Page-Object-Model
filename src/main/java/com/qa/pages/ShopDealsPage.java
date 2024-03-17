package com.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utilities.TestUtil;

public class ShopDealsPage extends TestBase{

	public ShopDealsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//h1[@class='wt-text-display wt-pb-xs-2 wt-text-white']")
	public WebElement ShopDealsIdentifier;
	
	@FindBy (xpath = "//div[@data-id='search-suggestions-trigger']//input")
	public WebElement SearchBar;
	
	@FindBy (xpath = "//ul[@role = 'listbox']//li")
	public List<WebElement> SearchListOptions;
	


	
public String validateShopealsPageTitle() throws InterruptedException {
		
	Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(TestUtil.WAIT, TimeUnit.SECONDS);
		return driver.getTitle();
		
	}
	

public boolean verifyShopDealsPage() throws InterruptedException {
	
return	ShopDealsIdentifier.isDisplayed();
}


public int VerifySearchList(String object) throws InterruptedException {
	Thread.sleep(5000);
	jse.executeScript("arguments[0].value='"+object+"';",SearchBar);
    SearchBar.click();
	int i = SearchListOptions.size();
	
	return i;	
	
}


}
