package com.qa.tests;

import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.RegistryPage;
import com.qa.pages.SignInPage;
import com.qa.utilities.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class RegistryPageTest extends TestBase {
	
	
	public RegistryPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	SignInPage sp;
	HomePage hp;
	RegistryPage rp;
	
	String sheetname = "registryinfo";
	
 @DataProvider
 public Object[][] getEtsyTestData() {
	 Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	 
 }
	
  @Test (priority = 1 , dataProvider = "getEtsyTestData")
  public void createnewregistry(String name,String privacy,String day, String month, String year, String firstname,  String lastname) throws InterruptedException {
	  
	  rp.CreateNewRegistry(name,privacy, day, month, year,firstname,lastname);
	  
  }
  
  
  @Test (priority = 2)
  public void veriftregistrycreated() throws InterruptedException {
	  
	Assert.assertTrue(rp.VerifyRegistryCreated());
	  
  }
  
  
  @BeforeMethod
public void setUp() throws IOException, InterruptedException {
	  
	 initialisationmethod();
	 sp = new SignInPage();
	 rp = new RegistryPage();
	 hp =  sp.SignIn(prop.getProperty("username"), prop.getProperty("password"));
	 Thread.sleep(120000);
	 rp = hp.clickOnRegistry();
	 
  }

  @AfterMethod
  public void closeBrowser() {
	  driver.quit();  
}
}
