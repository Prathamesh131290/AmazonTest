package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//a[@id='nav-link-accountList']") private WebElement signin;
	@FindBy (xpath = "//a[@id='createAccountSubmit']") private WebElement createAccount;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	public void signIn() {
		signin.click();
		createAccount.click();
	}
}
