package com.qa.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	private String url;
	
	@FindBy(id = "txtUsername")
	private WebElement usernameBox;
	
	@FindBy(id = "txtPassword")
	private WebElement passwordBox;
	
	@FindBy(id = "btnLogin")
	private WebElement submitButton;
	
	public void goToPage(WebDriver driver, String URL) {
		driver.get(URL);
		}
	
	public String getURL(WebDriver driver) {
		url = driver.getCurrentUrl();
		return url;
		}
	
	public void enterUsername(String userName) {
		usernameBox.sendKeys(userName);
		usernameBox.submit();
	}

	public void enterPassword(String password) {
		passwordBox.sendKeys(password);
		passwordBox.submit();
	}
	
}
