package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	}
	
	@When("User opens URL {string}")
	public void user_opens_URL(String string) {
		driver.get(string);
	}
	
	@When("User enters Email as {string} and Password as {string1}")
	public void user_enters_Email_and_Password(String email,String pwd) {
		lp.setUserName(email);
		lp.setPassword(pwd);
	}
	
	@When("Click on Login")
		public void click_on_Login() {
			lp.clickLogin();
	}
	
	@Then("Page Title should be {string}")
	public void page_Title_should_be(String string) {
		if(driver.getPageSource().contains("Login was unsuccessful")){
			driver.close();
			Assert.assertTrue(false);			
		}
		else 
		{
			Assert.assertEquals(string,driver.getTitle());
		}
			
	}
	
	@When("User Click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}
	
	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
}
	

