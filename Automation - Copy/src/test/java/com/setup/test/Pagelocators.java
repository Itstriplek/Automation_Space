package com.setup.test;

public class Pagelocators {

		public String pickup_location_box= "//div[@class='col-lg-12 res-inputFldFst ']//input[@id='PicLoc_value']";
		public String date_picker_pickup= "//input[@id='from']";
		public String date_picker_drop= "//input[@id='to']";
		public String pickup_date= "//table[contains(@class,'ui-datepicker-calendar uitable ui-datepicker-table-first')]//a[@class='ui-state-default'][contains(text(),'dynamic')]";
		public String drop_date= "//table[contains(@class,'ui-datepicker-calendar uitable ui-datepicker-table-first')]//a[@class='ui-state-default'][contains(text(),'dynamic')]";
		public String calender_close= "//button[@id='calendarclose']";
		public String select_my_car= "//button[@id='res-home-select-car']";
		public String pickup_loaction_confirmation= "//div[@class='col-sm-6 col-md-4 source']//div[@class='location-info']";
		public String pickup_date_time= "//div[@class='col-sm-6 col-md-4 source']//div[@class='day-time-info']";
		public String drop_location_confirmation= "//div[@class='col-sm-6 col-md-4 destination hidden-xs']//div[@class='location-info']";
		public String drop_date_time= "//div[@class='col-sm-6 col-md-4 destination hidden-xs']//div[@class='day-time-info']";
		public String vehicle_filter= "//div[@class='pull-left veh-LtR-gtPad-Null']";
		public String selecting_SUVs= "//div[@class='col-sm-12 vehListRule']//span[contains(text(),'SUVs & Wagons')]";
		public String sort_by=  "//div[@class='pull-left veh-Select-Style veh-LtR-gtPad-Null dropdown']";
		public String low_to_high= "//div[@class='stepTwo-partial']//li[1]//a[1]";
		public String Select_this_location= "(//a[contains(text(),'Select This Location')])[1]";
		public String total_seats = "(//div[@class='col-lg-7 col-sm-6 col-xs-12 avlcarimagetab']//span[@class='four-seats-feat'])[dynamic]";
		public String total_doors = "(//div[@class='col-lg-7 col-sm-6 col-xs-12 avlcarimagetab']//span[@class='four-door-feat'])[dynamic]";
		public String vehicle_information= "(//*[@id=\"res-vehicles-details\"])[dynamic]";
		public String rate = "(//p[@class='payamntr'])[dynamic]";
		public String rate_final= "//div[@class='optBaseRateRow']//span[@class='pull-right']";
		public String fee_tax= "//div[@class='optTaxesRow']/span[2]";
		public String estimated= "//span[@class='pull-right est-total']";
		public String vehicle= "(//div[@class='col-sm-5 col-xs-12 avilcardtl dualPayOption']//h3)[1]";
		public String pay_now= "(//*[@id=\"res-vehicles-pay-now\"])[dynamic]";
		public String vehicle_choice= "//div[@class='vehicle-text-info']//div[@class='vehicle-name']";
		public String continue_button= "//button[@id='res-extras-continue-top']";
		public String pay_validation= "(//div[@class='amazon-rental-space additional optCouponMessageRow']//following::div)[1]";

	}

	

