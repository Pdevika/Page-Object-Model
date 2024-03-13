package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.qa.pages.HomePage;
import com.qa.pages.SignInPage;

public class SignInTest extends TestBase{
	
	SignInPage sp;
	HomePage hp;
	
	public SignInTest() throws IOException {
		
		super();
	}
	
	
 @Test (priority = 1)
 public void SignInPageTitleTest() throws InterruptedException {
	 
 String title = sp.validateLoginPageTitle();
 Assert.assertEquals(title, "Etsy Canada - Shop for handmade, vintage, custom, and unique gifts for everyone");
	 
 }
  
  
  @Test (priority = 2)
  public void validateLogo() throws InterruptedException {
	  
	  boolean flag = sp.validateLogo();
	  Assert.assertTrue(flag);
  }
  
  
  @Test (priority = 3)
  public void SignIn() throws InterruptedException, IOException{
	  
	hp = sp.SignIn(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  
  @BeforeMethod
  public void setUp() throws IOException {
	  
	  initialisationmethod();
	   sp = new SignInPage();
	  
  }
  

  @AfterMethod
  public void closeBrowser() {
	  
	
		  driver.quit();
	  
	  
	  
  }




}
