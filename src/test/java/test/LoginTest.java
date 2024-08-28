package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardHeaderText = "Dashboard";
	String expextedUsernameAlertMessage = "Please enter your user name";
	String expextedPasswordAlertMessage = "Please enter your password";

	// Test pages will call classes and can create objects of the pages
		@Test
		public void validUserShouldBeAbleToLogin() {
			driver = BrowserFactory.init();
			// LoginPage loginpage1 = new LoginPage();
			// have to use this version to create an object of the pages
			// explanation of how this works is on the 04/06 video at 2:28:00
			// make sure you can explain how pagefactory workds

			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

			loginpage.insertUserName(userName);
			loginpage.insertPassword(password);
			loginpage.clickButton();
			
			DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);

			dashboardpage.validateDashboardPage(dashboardHeaderText);

			BrowserFactory.teardown();

		}
	
	@Test
	public void validateAlertMessages() {
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.clickButton();
		loginpage.validateUsernameErrorMsg(expextedUsernameAlertMessage);
		loginpage.insertUserName(userName);
		loginpage.clickButton();
		loginpage.validatePasswordErrorMsg(expextedPasswordAlertMessage);
		
		BrowserFactory.teardown();
		
	}
	
}
