package com.labcorp.automation.pages;

import com.labcorp.automation.base.Base;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public BasePage() {
		PageFactory.initElements(Base.driver, this);
	}

}
