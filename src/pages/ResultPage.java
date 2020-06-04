package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ResultPage {

	WebDriver driver;
	
	@FindBy (xpath = "(//h4[@class='a-alert-heading'])[2]") private WebElement errorMsg;
	
	public ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	public void dispResult() {
		System.out.println("Error message: "+errorMsg.getText());
		Assert.assertEquals("Mobile number already in use", errorMsg.getText()); 
	}
}
