package com.qa.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage {
	
	@FindBy(xpath = "//*[@id=\"profile-pic\"]/h1")
	private WebElement employeeDetailsHeader;
	
	public String checkOnDetailsPage() {
		String detailsHeader = employeeDetailsHeader.getText();
		return detailsHeader;
	}
	

}
