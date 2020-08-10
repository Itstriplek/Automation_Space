package com.additionals.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.setup.test.Webactions;

public class Driversetup extends Webactions {

	public  Driversetup() {
		// TODO Auto-generated method stub
		super(driver);
	}
	public static WebDriver driver;
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		 {
		 case "chrome":
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
			 driver = new ChromeDriver();
			 break;
			 
		 case "firefox":
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//geckodriver.exe");
			 driver = new FirefoxDriver();
			 break;
			 
		 case "edge":
			 System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//msedgedriver.exe");
			 driver = new EdgeDriver();
			 break;
			 
		 case "phanthom":
			 System.setProperty("phantomjs.binary.path", System.getProperty("user.dir")+"//src//test//resources//drivers//phanthomjs.exe");
			 driver = new PhantomJSDriver();
			 break;
			 
		default:
			System.out.println("invalid input");
				 
		 }
		return driver;

	}

}
