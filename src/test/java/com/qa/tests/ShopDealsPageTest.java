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

public class ShopDealsPageTest extends TestBase {
  public ShopDealsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
  
    SignInPage sp;
	HomePage hp;
	ShopDealsPage sd;

@Test (priority = 1)
public void ShopDealsPageTitleTest() throws InterruptedException {
	 
String title = sd.validateShopealsPageTitle();
Assert.assertEquals(title, "BEST deals – up to 40% off");
	 
}



@Test (priority = 2)
public void verifyShopDealsPage() throws InterruptedException {

Assert.assertTrue(sd.verifyShopDealsPage());

}
  
@Test (priority = 3)
public void VerifySearchList() throws InterruptedException, IOException {
    
	int i = sd.VerifySearchList(prop.getProperty("object"));
    Assert.assertEquals(i, 5);
 
}



  @BeforeMethod
public void setUp() throws IOException, InterruptedException {
	  
	  initialisationmethod();
	 sp = new SignInPage();
	 sd = new ShopDealsPage();
	 hp =  sp.SignIn(prop.getProperty("username"), prop.getProperty("password"));
	 sd = hp.clickOnShopDeals();
	 
  }

  @AfterMethod
  public void closeBrowser() {
	  driver.quit();  
}

}
