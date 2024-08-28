package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div/header/div/strong")
	WebElement dashboardHeader;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a/span")
	WebElement customerButtonElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"customers\"]/li[2]/a/span")
	WebElement addCustomerButtonElement;
	
	public void validateDashboardPage(String dashboardHeaderText) {
		Assert.assertEquals(dashboardHeader.getText(), dashboardHeaderText, "page not available");
	}
	public void clickOnCustomersButton() {
		customerButtonElement.click();
	}
	public void clickOnAddCustomersButton() {
		addCustomerButtonElement.click();
	}
	
}
