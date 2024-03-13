package com.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import com.qa.base.TestBase;
import com.qa.utilities.TestUtil;

public class SignInPage extends TestBase {
	
	
	//Page Factory or Object Repository
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	public WebElement SignInOption;
	
	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "password")
	public WebElement password;

	@FindBy(name = "submit_attempt")
	public WebElement signIn;

	@FindBy(id = "aria-join_neu_email_field-error")
	public WebElement wrongEmailErr;

	@FindBy(id = "aria-join_neu_password_field-error")
	public WebElement wrongPasswordErr;

	@FindBy(xpath = "//button[@disabled = '' and @value = 'sign-in']")
	public List<WebElement> SignInDisabled;
	
	@FindBy(id = "logo")
	public WebElement Logo;
	
	

	public SignInPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.WAIT, TimeUnit.SECONDS);
		return driver.getTitle();
		
	}
	
	
	public boolean validateLogo() throws InterruptedException {
		
		Thread.sleep(5000);
	return	Logo.isDisplayed();
		
	}
	
	
   public HomePage SignIn(String a, String b) throws InterruptedException, IOException {
	
	   Thread.sleep(10000);
	   SignInOption.click();
	   email.sendKeys(a);
	   password.sendKeys(b);
	   signIn.click();
	   
		return new HomePage();
	}
   
   
   
   
   
}
