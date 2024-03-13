package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class RegistryPage extends TestBase{

	public RegistryPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	

	
	
@FindBy(xpath = "(//button[@class = 'wt-btn wt-btn--secondary wt-btn--small wt-width-full'])[3]")
public WebElement NewRegistry;

/*@FindBy(xpath = "//input[@id='occasion_type_"+other+"']")
public WebElement SelectType;	*/

@FindBy(xpath = "//select[@id='day-gift']")
public WebElement DropDay;
	
@FindBy(xpath = "//select[@id='month-gift']")
public WebElement DropMonth;

@FindBy(xpath = "//select[@id='year-gift']")
public WebElement DropYear;

@FindBy (xpath = "//input[@id='primary_first_name-gift']")
public WebElement RegistryFirstName;

@FindBy (xpath = "//input[@id='primary_last_name-gift']")
public WebElement RegistryLastName;


@FindBy(xpath = "(//button[@class = 'wt-btn wt-btn--filled reg-create-next'])[3]")
public WebElement Next;


@FindBy (xpath = ("//span[@class='wt-ml-xs-1']"))
public WebElement AddNewAddress;


@FindBy (xpath = "//select[@id='country_id2-select']")
public WebElement DropCountry;

@FindBy(xpath = "//label[@for='address-915798823679-']")
public WebElement Address;

@FindBy(xpath = "//h1[contains(text(),\"Devika's Gift Registry\")]")
public WebElement VerifyRegistryCreated;

@FindBy (linkText = "Manage your registry")
public WebElement RegistryManage;

@FindBy(xpath = "//button[@class = 'wt-btn wt-btn--filled reg-create-done']")
public WebElement Done;








public void CreateNewRegistry(String name, String privacy, String day, String month, String year, String firstname, String lasname) throws InterruptedException {
	
	Thread.sleep(5000);
	
	NewRegistry.click();
	
	Thread.sleep(5000);
	
	WebElement getstarted = driver.findElement(By.xpath("//input[@id='occasion_type_"+name+"']"));
	jse.executeScript("arguments[0].click();", getstarted);
	Next.click();
	
	Select d = new Select(DropDay);
	d.selectByValue(day);
	Select m = new Select(DropMonth);
	m.selectByVisibleText(month);
	Select y = new Select(DropYear);
	y.selectByValue(year);
	Next.click();
	
	Thread.sleep(5000);
	
	RegistryFirstName.sendKeys(firstname);
	RegistryLastName.sendKeys(lasname);
	Next.click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//label[@for = 'privacy_level_"+privacy+"-gift']")).click();
	Next.click();
	
	Thread.sleep(5000);
	
	Address.click();
	Done.click();
		
	
}
	  

public boolean VerifyRegistryCreated () throws InterruptedException {
     
	Thread.sleep(5000);
	
	RegistryManage.click();
	boolean i = VerifyRegistryCreated.isDisplayed();
	
	return i;	
	
}

	
}
