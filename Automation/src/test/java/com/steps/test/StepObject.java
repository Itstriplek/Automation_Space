package com.steps.test;

import java.io.IOException;

import com.setup.test.BaseTest;

import net.thucydides.core.annotations.Step;

public class StepObject {
	
	BaseTest base= new BaseTest();
@Step
public void launchSite() {		
		base.launchHomeURL();		
	}

@Step
public void travelDetails() throws IOException {
	base.travelInformation();
}

@Step
public void callSelection() throws IOException {
	base.carSelection();
}

@Step
public void confirmSelection() {
	base.selectionConfirm();
}

@Step
public void reservation() throws IOException {
	base.carReservation();
}

@Step
public void carDetails() throws IOException {
	base.carSpecs();
}

@Step
public void finalValidation() throws IOException {
	base.confirmation();
}

}
