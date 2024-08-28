package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	String userName = "demo@codefios.com";
	String fullName = "selenium";
	String password = "abc123";
	String dashboardHeaderText = "Dashboard";
	String addCustomerHeaderText = "New Customer";
	String expextedUsernameAlertMessage = "Please enter your user name";
	String expextedPasswordAlertMessage = "Please enter your password";

	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardHeaderText);
		dashboardpage.clickOnCustomersButton();
		dashboardpage.clickOnAddCustomersButton();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.validateAddCustomerPage(addCustomerHeaderText);
		addcustomerpage.insertFullName(fullName);

		BrowserFactory.teardown();

	}
}
