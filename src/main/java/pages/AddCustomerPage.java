package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong")
	WebElement addCustomerHeader;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[1]/div/input")
	WebElement fullNameElement;
	
	
	public void validateAddCustomerPage(String addCustomerHeaderText) {
		Assert.assertEquals(addCustomerHeader.getText(), addCustomerHeaderText, "page not available");
	}
	
	public void insertFullName(String firstName) {
		fullNameElement.sendKeys(firstName);
	}
	
	
}
