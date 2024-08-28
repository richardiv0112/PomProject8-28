package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//pages have attributes and methods
	
	//Attributes
//	WebElement;
//	By;
	@FindBy(how = How.XPATH, using = "//*[@id=\"user_name\"]") WebElement userName1; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement passwordElement; 
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_submit\"]") WebElement signinButtonElement; 
	
	//Method
	//individual
	
	
	public void insertUserName(String userName) {
		userName1.sendKeys(userName);
	}
	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void clickButton() {
		signinButtonElement.click();
	}
	//combine
	public void performLogin(String userName, String password) {
		userName1.sendKeys(userName);
		passwordElement.sendKeys(password);
		signinButtonElement.click();
	}
	
	public void validateUsernameErrorMsg(String expected) {
		String actual = driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected, "Username alert message error");
		driver.switchTo().alert().accept();
	}
	public void validatePasswordErrorMsg(String expected) {
		String actual = driver.switchTo().alert().getText();
		Assert.assertEquals(actual, expected, "Password alert message error");
		driver.switchTo().alert().accept();
	}
}
