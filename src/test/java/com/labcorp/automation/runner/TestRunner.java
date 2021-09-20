package com.labcorp.automation.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:FeatureFiles/labcorp.feature"}, glue={"classpath:com.labcorp.automation.stepdef","classpath:com.labcorp.automation.base"}, plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})
public class TestRunner {

}
