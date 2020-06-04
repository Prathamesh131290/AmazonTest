package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelSheetData;

public class CreateAccountPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//input[@id='ap_customer_name']") private WebElement name;
	@FindBy (xpath = "//input[@id='ap_phone_number']") private WebElement mobile;
	@FindBy (xpath = "//input[@id='ap_email']") private WebElement email;
	@FindBy (xpath = "//input[@id='ap_password']") private WebElement password;
	@FindBy (xpath = "//input[@id='continue']") private WebElement cont;
	
	
	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	public void createAccount() throws EncryptedDocumentException, IOException {
		String nm = ExcelSheetData.fetchData("Sheet1", 1, 0); 
		name.sendKeys(nm);
		String mob = ExcelSheetData.fetchData("Sheet1", 1, 1); 
		mobile.sendKeys(mob);
		String em = ExcelSheetData.fetchData("Sheet1", 1, 2); 
		email.sendKeys(em);
		String pwd = ExcelSheetData.fetchData("Sheet1", 1, 3); 
		password.sendKeys(pwd);
		cont.click();
	}
}
