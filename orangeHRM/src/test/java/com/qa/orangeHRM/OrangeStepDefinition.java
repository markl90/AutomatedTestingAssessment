package com.qa.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;
	


public class OrangeStepDefinition {
		
	WebDriver driver;
	HomePage homepage;
	Dashboard dashpage;
	AddEmployeePage addemployee;
	EmployeeListPage employeelist;
	
	private String username;
	private String password = "pass";
	private String firstname = "mark";
	private String lastname = "led";
	
	ExtentReports report = new ExtentReports("C:\\Users\\Admin\\Desktop\\ATassessment\\OrangeTestReport.html", true);
	ExtentTest test;
	
	@Before	
	public void setup() {
		
		
		int rand = (int) (99 + Math.random()*26);
		char ranC = (char) rand;
		String myName = ranC + "hdg" + ranC;
		username = myName;
		
		test = report.startTest("Verify application Title ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\web files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		
	}
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.goToPage(driver, "http://opensource.demo.orangehrmlive.com/index.php/dashboard");
		assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", homepage.getURL(driver));
		if (homepage.getURL(driver).equals("http://opensource.demo.orangehrmlive.com/index.php/dashboard")) {
			test.log(LogStatus.PASS, "Accessed the home page");
		}
		else {
			test.log(LogStatus.FAIL, "Did not access home page");
		}
		homepage.enterUsername("Admin");
		homepage.enterPassword("admin");
		
		dashpage = PageFactory.initElements(driver, Dashboard.class);
		dashpage.ClickPIM();
		dashpage.ClickAddEmployee();
		assertEquals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee", homepage.getURL(driver));
		
		if (homepage.getURL(driver).equals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee")) {
			test.log(LogStatus.PASS, "Successfully navigated to add employee");
		}
		else {
			test.log(LogStatus.FAIL, "Did not Successfully navigate to add employee");
		}
			
	}
	
	

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {
		addemployee = PageFactory.initElements(driver, AddEmployeePage.class);
		addemployee.enterFirstName(firstname);
		test.log(LogStatus.INFO, "Adding first name: " + firstname);
		addemployee.enterLastName(lastname);
		test.log(LogStatus.INFO, "Adding last name: " + lastname);
		
	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		addemployee.CreateLoginDetails();
		
	   
	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly()  {
		addemployee.createUsername(username);
		addemployee.createPassword(password);
		addemployee.confirmPassword(password);
		test.log(LogStatus.INFO, "Generated random username: " + username);
		test.log(LogStatus.INFO, "Adding password: " + password);
	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button()  {
		addemployee.clickSave();
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user()  {
		employeelist = PageFactory.initElements(driver, EmployeeListPage.class);
		System.out.println(employeelist.checkOnDetailsPage());
		assertEquals(employeelist.checkOnDetailsPage(),(firstname + " " + lastname));
		if (employeelist.checkOnDetailsPage().equals(firstname + " " + lastname)) {
			test.log(LogStatus.PASS, "New user details displayed");
		}
		else {
			test.log(LogStatus.FAIL, "New user details not displayed");
		}
		
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		report.endTest(test);
		report.flush();
	}
}
