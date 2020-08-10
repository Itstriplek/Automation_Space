package com.setup.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Webactions {

	public Boolean pickupFlag = true;
	public static WebDriver driver;
	
	  public Webactions(WebDriver driver) { 
		  this.driver=driver;
	  
	  }
	 

		
		  public void takeSnapshot(String file) throws IOException {
		  
		  TakesScreenshot scrShot = ((TakesScreenshot) driver);
		  
		  File SourceFile = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  File DestFile = new File(file);
		  
		  FileUtils.copyFile(SourceFile, DestFile);
		  
		  }
		 

	public String getFutureDate() {
		Calendar today = Calendar.getInstance();

		DateFormat day_date = new SimpleDateFormat("dd");

		if (pickupFlag) {
			today.add(Calendar.DAY_OF_YEAR, 7);
			pickupFlag = false;
		} else
			today.add(Calendar.DAY_OF_YEAR, 14);
		String required_date = day_date.format(today.getTime());

		return required_date;
	}

}
