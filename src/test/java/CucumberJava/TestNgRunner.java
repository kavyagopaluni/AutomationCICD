package CucumberJava;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src\\test\\java\\CucumberJava" ,glue ="StepDefinitionImplementation" ,monochrome =true,tags=("@Error"),plugin = {"html:target\\cucumber.html"})
public class TestNgRunner extends AbstractTestNGCucumberTests {
	

}
