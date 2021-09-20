package com.labcorp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobSite  extends BasePage {

    @FindBy(xpath = "//*[@id=\"ae-main-content\"]/div/div/div[1]/button")
    public WebElement returntoJobSearch;

    @FindBy(xpath = "//button[contains(@class,'close closebutton ae-button')]")
    // @FindBy(xpath="//*[contains(text(),'×')]")
    public WebElement closebutton;

    @FindBy(xpath = "*")
    public List<WebElement> allelements;

    @FindBy(xpath = "//span[contains(@class,'title')]")
    public  WebElement title;

     @FindBy(xpath = "//span[contains(@class,'resultfootervalue')]")
     public WebElement location;

     @FindBy(xpath = "//span[contains(@class,'jobnum')]")
      public  WebElement jobId;

     @FindBy(xpath = "//div[contains(@class,'content')]")
     public  List<WebElement> shift;

     @FindBy(xpath = "//div[contains(text(),'Requirements')]")
    public  WebElement Requirements;



}
