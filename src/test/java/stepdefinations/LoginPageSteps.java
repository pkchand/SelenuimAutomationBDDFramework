package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private String title;
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    DriverFactory.getDriver().get("https://es.dev.juice.net");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginPage.waitForLoginScreen();
	    title=loginPage.loginPageTitle();
	    System.out.println("Page title is: "+title);
	}

	@Then("Title should be {string}")
	public void title_should_be(String expectedTitle) {
	    Assert.assertTrue(title.equals(expectedTitle));
	}

	@Then("Forgot password link should be displaying")
	public void forgot_password_link_should_be_displaying() {
		loginPage.waitForLoginScreen();
	    Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.waitForLoginScreen();
	    loginPage.enterLoginId(username);
	}

	@When("user enters password {string}")
	public void user_enters_password_pass1(String pwd) {
	    loginPage.enterPassword(pwd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expTitle) {
	    Assert.assertTrue(title.equals(expTitle));
	}

}
