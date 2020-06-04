package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.ResultPage;
import utils.Snapshot;

public class TestOne extends BaseClass {
	WebDriver driver;
	HomePage home;
	CreateAccountPage acc;
	ResultPage res;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) {
		driver = BaseClass.lanuchBrowser(browser); 
	}
	
	@Test(priority = 0)
	public void viewHomePage() {
		home = new HomePage(driver);
		home.signIn();
	}
	
	@Test(priority = 1)
	public void viewAccountPage() {
		acc = new CreateAccountPage(driver);
		try {
			acc.createAccount();
		} 
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void displayMessage() {
		res = new ResultPage(driver);
		res.dispResult();
	}
	
	@Parameters("browser")
	@AfterTest
	public void closure(String browser) throws IOException, InterruptedException {
		try {
			Snapshot.captureScreenshot(driver, "TestOne-"+browser);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		driver.	close();
	}
}
