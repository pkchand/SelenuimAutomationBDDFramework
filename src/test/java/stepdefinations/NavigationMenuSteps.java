package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuSteps {
	private LoginPage login= new LoginPage(DriverFactory.getDriver());
	private HomePage home;
	private String title;
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable credTable) {
		List<Map<String, String>> CredList=credTable.asMaps();
		String un=CredList.get(0).get("Username");
		String pass=CredList.get(0).get("Password");
		DriverFactory.getDriver().get("https://es.dev.juice.net/");
		login.waitForLoginScreen();
		home = login.doLogin(un, pass);

	}

	@Given("user is on project page")
	public void user_is_on_project_page() {
		home.waitforPageLoad();
		String pageUrl=home.pageURLCheck();
		System.out.println("Page url is :"+pageUrl);
		Assert.assertTrue(pageUrl.contains("projects"));
	}
	
	@When("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		title=home.getHomePageTitle();
	    System.out.println("Page title is "+title);
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String PageTitle) {
	    Assert.assertEquals(title, PageTitle);
	}

	@Then("user gets the navigation section")
	public void user_gets_the_navigation_section(DataTable navigationTable) {
	
		List<String> expectedMenuList=navigationTable.asList();
		System.out.println("Expected List :"+expectedMenuList);
		List<String> actualMenuList=home.getNAvigationList();
		System.out.println("Actual List "+actualMenuList);
		Assert.assertTrue(expectedMenuList.containsAll(actualMenuList));
	
	}

	@Then("Navigation count should be {int}")
	public void navigation_count_should_be(Integer int1) {
		Assert.assertTrue(home.getNavigationCount()==int1);

	}
}
