package com.qa.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	@FindBy(id = "firstName")
	private WebElement firstNameBox;
	
	@FindBy(id = "lastName")
	private WebElement lastNameBox;
	
	@FindBy(id = "chkLogin")
	private WebElement createLoginCheckbox;
	
	@FindBy(id = "user_name")
	private WebElement usernameBox;
	
	@FindBy(id = "user_password")
	private WebElement userPasswordBox;
	
	@FindBy(id = "re_password")
	private WebElement confirmPasswordBox;
	
	@FindBy(id = "btnSave")
	private WebElement saveButton;
	
	
	
	public void enterFirstName(String fName) {
		firstNameBox.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastNameBox.sendKeys(lName);
	}
	
	public void CreateLoginDetails() {
		createLoginCheckbox.click();
	}
	
	public void createUsername(String username) {
		usernameBox.sendKeys(username);
	}
	
	public void createPassword(String password) {
		userPasswordBox.sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		confirmPasswordBox.sendKeys(password);
	}
	
	public void clickSave() {
		saveButton.click();
	}
	
	
}
