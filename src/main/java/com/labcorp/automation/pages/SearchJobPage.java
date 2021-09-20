package com.labcorp.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchJobPage extends BasePage {


    @FindBy(xpath = "/html/body/div/main/div[1]/div[2]/div/div/form/div/p[1]/input")
   // @FindBy(xpath = "//*[@id=\"search-keyword-854e4d1d03\"]")
    public WebElement keywordSearch;

    @FindBy(xpath = "//*[@id=\"search-results-list\"]/ul/li[1]/a/h2")
    public WebElement clickFirstTitle;

    @FindBy(css = "#content > div.jd-main-wrapper > section.job-description > div.job-description__info-items > span.job-id.job-info")
    public WebElement jobid;

    @FindBy(xpath = "/html/body/div/main/div[1]/div[2]/div/div/form/div/p[2]/input[1]")
    public WebElement jobLocation;

    @FindBy(css="#content > div.jd-main-wrapper > section.job-description > div.job-description__info-items > span.job-location.job-info")
    public  WebElement availalbeJobLocation;

    @FindBy(css = "#search-location-8e2091c64a")
    public WebElement jobTitle;

    @FindBy(xpath = "//*[@id=\"search-location-8e2091c64a\"]")
    public WebElement locationtext;

    @FindBy(xpath="//html/body/div/main/div[1]/div[2]/div/div/form/div/button")
    public WebElement submit;

    @FindBy(css="#content > div.jd-main-wrapper > section.job-description > h1")
    public  WebElement jobDesc;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/section[2]/div[2]/div[5]/span/div[1]")
    public WebElement RequirementsDesc;

    @FindBy(css="#content > div.jd-main-wrapper > section.job-description > div.ats-description > div:nth-child(7) > span > div:nth-child(4) > span")
    public  WebElement ShiftDesc;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/section[2]/a")
    public WebElement applyNow;

    @FindBy(xpath = "//html/body/div[2]/button")
    public  WebElement accept;
}