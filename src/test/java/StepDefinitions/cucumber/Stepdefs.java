package StepDefinitions.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	WebDriver driver;
	PageObject pageobject;

	public Stepdefs() {
		this.driver = Hook.driver;
		this.pageobject = new PageObject(Hook.driver);
	}

	@Given("^I vist Registration page$")
	public void i_vist_Registration_page() throws Exception {
		this.driver.get("http://testmaster.vn/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^I input invalid email$")
	public void i_input_invalid_email() throws Exception {
		pageobject.txtemail.sendKeys("abc");
	}

	@When("^I click button Dang ky$")
	public void i_click_button_Dang_ky() throws Exception {
		pageobject.btnDangky.click();
	}

	@Then("^Show message invalid email$")
	public void show_message_invalid_email() throws Exception {
		assertEquals("* Email không đúng định dạng", pageobject.Erremail.getText());
	}

	@When("^I input blank email$")
	public void i_input_blank_email() throws Exception {
		pageobject.txtemail.clear();
	}

	@When("^I input valid email$")
	public void i_input_valid_email() throws Exception {
		pageobject.txtemail.sendKeys("test57485@gmail.com");
	}

	@Then("^Show extra form$")
	public void show_extra_form() throws Exception {
		assertNotNull(pageobject.Extraform);
	}

	@Given("^I vist extra form$")
	public void i_vist_extra_form() throws Exception {
		this.driver.get("http://testmaster.vn/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pageobject.txtemail.sendKeys("test45756568@gmail.com");
		pageobject.btnDangky.click();
	}

	@When("^I input blank Ho va ten$")
	public void i_input_blank_Ho_va_ten() throws Exception {
		pageobject.txtfullname.clear();
	}

	@When("^I click button Dong y$")
	public void i_click_button_Dong_y() throws Exception {
		pageobject.btnDongy.click();
	}

	@Then("^Show message required field$")
	public void show_message_required_field() throws Exception {
		assertEquals("This is required field", pageobject.Errfullname.getText());
	}

	@When("^I input valid Ho va ten$")
	public void i_input_valid_Ho_va_ten() throws Exception {
		pageobject.txtfullname.sendKeys("test 343");
	}

	@When("^I choose gender is Nu$")
	public void i_choose_gender_is_Nu() throws Exception {
		driver.findElement(By.id("ddlGender")).sendKeys("Nữ");
		//Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ddlGender\"]")));
		//select.selectByValue("Nữ");
	
		

	}

	@When("^I choose news type is Nhan tat ca loai tin$")
	public void i_choose_news_type_is_Nhan_tat_ca_loai_tin() throws Exception {
		driver.findElement(By.id("ddlNewsType")).sendKeys("Nhận tất cả các loại tin");
		//Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ddlNewsType\"]")));
		//select.selectByVisibleText("Nhận tất cả các loại tin");
	}

	@When("^I click bttuon Dong y$")
	public void i_click_bttuon_Dong_y() throws Exception {
		pageobject.btnDongy.click();
	}

	@Then("^Show message registration success$")
	public void show_message_registration_success() throws Exception {
		assertEquals("Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký", driver.findElement(By.xpath("//*[@id=\"popover\"]/div[1]/div[2]")).getText());
	}

}