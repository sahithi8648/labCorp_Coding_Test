package com.labcorp.automation.implementaion;

import com.labcorp.automation.base.Base;
import com.labcorp.automation.pages.*;
import com.labcorp.automation.utils.Elements;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


public class Implementation extends Elements{
	public static Logger log=Logger.getLogger(Implementation.class);
	LoginPage loginPo=new LoginPage();
	HomePage homePo=new HomePage();
	PostPage postPage = new PostPage();
	ProfilePage profilePage = new ProfilePage();
	SearchJobPage jobPage = new SearchJobPage();
	WebDriverWait w = new WebDriverWait(Base.driver,40);
	String parent=new String();
	JobSite jobSite = new JobSite();
	private static final String BASE_URL = "https://api.publicapis.org/entries";
	private static Response response;





















	public void clickCareersLink(){
         try{
            Thread.sleep(3000);

			 JavascriptExecutor js = (JavascriptExecutor) Base.driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", homePo.careers);
             clickObject(homePo.careers,"Careers");
			 parent=Base.driver.getWindowHandle();

		 }catch (InterruptedException e){
         	log.error("Getting exception while clicking CarrersLink");
		 }

	}

	public void doApplyJobandValidatedFields(){
    	try {
			jobPage.applyNow.click();
			Thread.sleep(30000);
			jobSite.closebutton.click();
			Assert.assertEquals("#21-85987", jobSite.jobId.getText());
			Assert.assertEquals("Burlington, NC", jobSite.location.getText());
			Assert.assertEquals("License/Certification/Education: Normally requires a B.S. Degree in Computer Science w/5-7 years of experience.\n" +
					"  Experience in a medical reference or genetic laboratory setting preferred", jobSite.shift.get(11).getText());
			Assert.assertEquals("1", jobSite.shift.get(9).getText());
			Assert.assertEquals("Senior Software QA Analyst", jobSite.title.getText());
			jobSite.returntoJobSearch.click();

	}catch (InterruptedException e){
		log.error("Getting exception while entered Desired jobTitle");
	}

	}

	public  void doEnteredDesiredJobTitle(){
		try{
			Thread.sleep(3000);
			Set<String> getwindows =Base.driver.getWindowHandles();
			System.out.println(getwindows);
			Iterator<String> I1= getwindows.iterator();

			while(I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					Base.driver.switchTo().window(child_window);
					System.out.println(Base.driver.switchTo().window(child_window).getTitle());
				}
			}
			Thread.sleep(5000);
			if(jobPage.accept.isEnabled()) {
				jobPage.accept.click();
			}
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) Base.driver;
			js.executeScript("arguments[0].scrollIntoView(true);", jobPage.keywordSearch);

			jobPage.keywordSearch.sendKeys("QA Analyst");
            jobPage.jobLocation.clear();
			jobPage.submit.click();

			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-results-list\"]/ul/li[1]/a/h2")));
			clickObject(jobPage.clickFirstTitle,"clickFirstTitle");

		//	Assert.assertEquals("#21-85987", jobSite.jobId.getText());
		//	Assert.assertEquals("Burlington, NC", jobPage.availalbeJobLocation.getText());
		//	Assert.assertEquals("License/Certification/Education: Normally requires a B.S. Degree in Computer Science w/5-7 years of experience.\n" +
				//	"  Experience in a medical reference or genetic laboratory setting preferred", jobSite.shift.get(11).getText());
//			Assert.assertEquals("1", jobSite.shift.get(9).getText());
//			Assert.assertEquals("Senior Software QA Analyst", jobSite.title.getText());

			System.out.println("Job location"+jobPage.availalbeJobLocation.getText());
			System.out.println("Job Title"+jobPage.jobDesc.getText());

			System.out.println("Shift De"+jobPage.ShiftDesc.getText());
			System.out.println("Requirement Des"+jobPage.RequirementsDesc.getText());

		}catch (InterruptedException e){
			log.error("Getting exception while entered Desired jobTitle");
		}

	}


  public void dotestPubliAPI(){
	  RestAssured.baseURI = BASE_URL;
	  RequestSpecification request = RestAssured.given();

	  request.header("Content-Type", "application/json");
	  response = request.get("https://api.publicapis.org/entries");
	  String jsonString = response.asString();
	  System.out.println(jsonString);
	  Assert.assertEquals(200, response.getStatusCode());





  }

}
