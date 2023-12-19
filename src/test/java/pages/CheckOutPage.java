package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement cbtn;
	
	@FindBy(xpath="//span[contains(text(),'Checkout: Your Information')]")
	WebElement info;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean infoPage()
	{
		return cbtn.isDisplayed();
	}
	
	public void provideDetails()
	{
		firstName.sendKeys("test");
		lastName.sendKeys("data");
		postalCode.sendKeys("533005");
		cbtn.click();
	}
}
