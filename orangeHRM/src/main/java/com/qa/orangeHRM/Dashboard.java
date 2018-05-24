package com.qa.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement pimTab;
	
	@FindBy(id = "menu_pim_addEmployee")
	private WebElement addEmployeeTab;
	

	public void ClickPIM() {
		pimTab.click();
	}
	
	public void ClickAddEmployee() {
		addEmployeeTab.click();
	}
		

}
