package com.labcorp.automation.stepdef;

import com.labcorp.automation.base.Base;
import com.labcorp.automation.implementaion.Implementation;
import com.labcorp.automation.utils.Elements;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef{
	Implementation impl=new Implementation();
	Elements element=new Elements();

	@Given("^I navigate and login to LabCorp website$")
	public void i_NavigateToApplication() throws Throwable {
		Base.navigateToLabCorpSite();
	}

	@And("^I clicked careers section$")
	public void doCLickedCarrersLink(){
		impl.clickCareersLink();
	}

	@Then("I entered desired job Title")
	public void doEnteredDesiredJobTitle(){
		impl.doEnteredDesiredJobTitle();
	}
	@Then("I applied job and validated fields")
	public  void doApplyJobandValidatedFields(){
		impl.doApplyJobandValidatedFields();
	}

	@Given("I Test public API")
	public  void testPubliAPI(){
		impl.dotestPubliAPI();
	}













	
	
	
	
	

}
