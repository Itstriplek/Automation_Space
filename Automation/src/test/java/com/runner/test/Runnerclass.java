package com.runner.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="com.stepdef.test",
		tags= "@tag1")
public class Runnerclass {
	
	

}
