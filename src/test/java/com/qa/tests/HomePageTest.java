package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.RegistryPage;
import com.qa.pages.ShopDealsPage;
import com.qa.pages.SignInPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	SignInPage sp;
	HomePage hp;
	ShopDealsPage sd;
	RegistryPage rp;
	
  public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
  

  @BeforeMethod
public void setUp() throws IOException, InterruptedException {
	  
	  initialisationmethod();
	   sp = new SignInPage();
	  sd = new ShopDealsPage();
	  rp = new RegistryPage();
	 hp =  sp.SignIn(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  
  @Test (priority = 1)
  public void HomePageTitleTest() throws InterruptedException {
 	 
  String title = hp.validateHomePageTitle();
  Assert.assertEquals(title, "Etsy Canada - Shop for handmade, vintage, custom, and unique gifts for everyone", "HomePageTitle not matched");
 	 
  }

  @Test (priority = 2)
  public void verifyUsername() throws InterruptedException {

  Assert.assertTrue(hp.verifyUsername());
  
  }
  
  @Test (priority = 3)
  public void verifyShopDeals() throws InterruptedException, IOException {

  sd =  hp.clickOnShopDeals();
  
  }
  
  @Test (priority = 4)
  public void verifyRegistryPage() throws InterruptedException, IOException {

  rp = hp.clickOnRegistry();
   
  }
  
  @Test (priority = 5)
  public void verifyDropdownList() throws InterruptedException, IOException {

	  int i = hp.validateDropDownList();
Assert.assertEquals(i, 17);
   
  }
  
  
  

  @AfterMethod
  public void closeBrowser() {
	  driver.quit();  
}

}
