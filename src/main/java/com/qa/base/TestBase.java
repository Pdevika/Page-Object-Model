package com.qa.base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utilities.TestUtil;
import com.qa.utilities.WebEventListener;

public class TestBase {

	
public	static WebDriver driver;
public	static Properties prop;
public static JavascriptExecutor jse;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
	
	public TestBase() throws IOException {
		FileInputStream file = new FileInputStream("C:\\QA\\Testing\\config.properties");
		prop = new Properties();
		prop.load(file);
	}
//initialisation 
	public static void initialisationmethod() throws IOException {
		
	String browserName = prop.getProperty("browser");	
	System.setProperty( "webdriver.gecko.driver", "C:/QA/SeleniumJars/geckodriver.exe");
	if (browserName.equals("firefox")) {
	    driver = new FirefoxDriver();
	} else if(browserName.equals("Chrome")){
		driver = new ChromeDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.WAIT, TimeUnit.SECONDS);
	
	
	driver.get(prop.getProperty("url"));
	
	jse = (JavascriptExecutor)driver;
	
	}
	
	
	
	
}
