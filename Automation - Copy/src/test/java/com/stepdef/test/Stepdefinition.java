package com.stepdef.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import com.setup.test.*;

public class Stepdefinition {
	
	testSetup testObject= new testSetup();
	
	@Given("^I am in budget.com home page$")
    public void i_am_in_budgetcom_home_page(){
	
     testObject.launchSite();
    }
	
	@And("^I enter the pick up location, select the pickup and drop date$")
    public void i_enter_the_pick_up_location() throws IOException{
    	testObject.travelDetails();
    }

    @When("^I click on select my car button$")
    public void i_click_on_select_my_car_button() throws IOException{
    	
    	testObject.callSelection();
      
    }

    @Then("^I get a dialouge box to confirm the location$")
    public void i_get_a_dialouge_box_to_confrim_the_location() throws IOException{
    	
    	testObject.confirmSelection();
        
    }
   

    @And("^selecting SUV cars sorting the prices from low to high$")
    public void sorting_the_prices_from_low_to_high() throws IOException  {
        
    	testObject.reservation();
    }

    @And("^I click on view vehicle information and paynow$")
    public void i_click_on_view_vehicle_information_to_check_the_specifications() throws IOException {
    	testObject.carDetails(); 
    }
    
    @Then("^Summary is displayed for the selected car and amount to be paid is verified$")
    public void after_clicking_paynow_the_payment_summary_is_displayed() throws IOException{
        testObject.finalValidation();
    }


    



}
