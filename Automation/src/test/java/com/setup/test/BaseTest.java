package com.setup.test;

import java.io.IOException;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.additionals.test.Driversetup;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;



public class BaseTest extends Driversetup {
	
	
	Pagelocators locators = new Pagelocators();
	WebDriverWait wait;
	WebDriver driver;
	String browser = "firefox"; 
	String expected_pickup_location = "Austin Bergstrom Intl Airport, Austin, Texas";
	String base_rate;
	String vehicle_type;

	public  void launchHomeURL()
	{

		driver=launchBrowser(browser);
		new Driversetup();
		driver.get("https://www.budget.com/");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.pickup_location_box)));
		driver.manage().window().maximize();
		
	}

	public void travelInformation() throws IOException
	{

		driver.findElement(By.xpath(locators.pickup_location_box)).sendKeys(expected_pickup_location);
		driver.findElement(By.xpath(locators.pickup_location_box)).click(); 
		  
		pickupFlag=true;  
		driver.findElement(By.xpath(locators.date_picker_pickup)).click();
		driver.findElement(By.xpath(locators.pickup_date.replaceAll("dynamic", ""+getFutureDate()))).click();
		driver.findElement(By.xpath(locators.calender_close)).click();
		
		driver.findElement(By.xpath(locators.date_picker_drop)).click();
		driver.findElement(By.xpath(locators.drop_date.replaceAll("dynamic", ""+getFutureDate()))).click();
		driver.findElement(By.xpath(locators.pickup_location_box)).click();
		
	}
	

	public void carSelection() throws IOException {
		

		this.takeSnapshot( System.getProperty("user.dir")+"\\Screenshot\\page_one.png");
		driver.findElement(By.cssSelector("#res-home-select-car")).click();
		
		  if(driver.findElement(By.cssSelector("#res-home-select-car")).isDisplayed()) 
		  { 
			  driver.findElement(By.xpath(locators.pickup_location_box)).click();
			  driver.findElement(By.xpath(locators.select_my_car)).click(); 
			   
		 }
		
	}

	public void selectionConfirm() {
				  

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.Select_this_location)));
		driver.findElement(By.xpath(locators.Select_this_location)).click();
		
	}
	
	public void carReservation() throws IOException
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.pickup_loaction_confirmation)));
		String actual_pickup_location = driver.findElement(By.xpath(locators.pickup_loaction_confirmation)).getText();

		String actual_drop_location = driver.findElement(By.xpath(locators.drop_location_confirmation)).getText();
		
		if ((actual_pickup_location.contains("Austin Bergstrom Intl Airport"))
				&& (actual_drop_location.contains("Austin Bergstrom Intl Airport"))) {
			driver.findElement(By.xpath(locators.vehicle_filter)).click();
			driver.findElement(By.xpath(locators.selecting_SUVs)).click();
			
			driver.findElement(By.xpath(locators.sort_by)).click();
			driver.findElement(By.xpath(locators.low_to_high)).click();
			
			this.takeSnapshot( System.getProperty("user.dir")+"\\Screenshot\\page_two.png");
		}
		else
			System.out.println("Locations do not match, please check your input and output");
	}
	
	public void carSpecs() throws IOException
	{

		List<WebElement> iterator = driver.findElements(By.xpath("//*[@id=\"res-vehicles-details\"]"));

		for (int x = 1; x < iterator.size(); x++) {
			
			driver.findElement(By.xpath(locators.vehicle_information.replace("dynamic", ""+x))).click();
					
			String seats = driver.findElement(By.xpath(locators.total_seats.replace("dynamic", ""+x))).getText();
			String doors = driver.findElement(By.xpath(locators.total_doors.replace("dynamic", ""+x))).getText();
			System.out.println("Total seats "+seats);
			if ((seats.equals("5 seats")) && (doors.equals("4 Doors"))) 
			{
				base_rate = driver.findElement(By.xpath(locators.rate.replace("dynamic", ""+x))).getText();
				vehicle_type = driver.findElement(By.xpath(locators.vehicle.replace("dynamic", ""+x))).getText();
				driver.findElement(By.xpath(locators.pay_now.replace("dynamic", ""+x))).click();
				break;

			} else
				System.out.println("Condition is not matching, moving the nest car");

	}

}
	
	public void confirmation() throws IOException
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.continue_button)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.pay_validation)));
		String Final_rate= driver.findElement(By.xpath(locators.rate_final)).getText();
		String fees_taxes= driver.findElement(By.xpath(locators.fee_tax)).getText();
		String estimated_total= driver.findElement(By.xpath(locators.estimated)).getText();
		String vehicle_name= driver.findElement(By.xpath(locators.vehicle_choice)).getText();
		if((base_rate.substring(1)).equals(Final_rate.substring(2))&&(vehicle_type.equals(vehicle_name)))
		{
			double amount = Double.parseDouble(Final_rate.substring(2));
			double fee = Double.parseDouble(fees_taxes.substring(1));
			double total = amount+fee;
            double est_total = Double.parseDouble(estimated_total.substring(1));

			
				if (total==est_total) 
				{
					System.out.println("Validation completed, Estimated total is "+total+" and amount prepaid matches is "+est_total);		
					System.out.println("Test case passed");
					this.takeSnapshot( System.getProperty("user.dir")+"\\Screenshot\\page_three.png");
				}
				else
					System.out.println("Totals do not match please check"+total+" "+est_total);
			
		}
		else
		System.out.println(Final_rate.length());

	}
	}
