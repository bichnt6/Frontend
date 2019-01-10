package StepDefinitions.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
WebDriver driver;
	
	@FindBy (css="div.col-sm-9 > input[type=email]")
	public WebElement txtemail;
	
	@FindBy(css="div.mod-input.error > div:nth-child(3) > span")
	public WebElement Erremail;
	
	@FindBy(css="button.next-btn-primary")
	public WebElement btnDangky;
	
	@FindBy(css="#popover b")
	public WebElement Extraform;
	
	@FindBy(css="div.popover-body input[type=text]")
	public WebElement txtfullname;		
	
	@FindBy(css="div.popover-body div.error")
	public WebElement Errfullname;
	
	@FindBy(css="#allow-button")
	public WebElement btnDongy;
	
	public PageObject (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
