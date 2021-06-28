package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties prop;
	//read the property file
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.init_prop();
	}
	
	//launch browser from driver factory
	@Before(order=1)
	public void launchBrowser() {
		String browserName=prop.getProperty("browser");
		driverFactory= new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	//closing browser session
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	//taking screen shot and attaching with scenario
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
		TakesScreenshot ts= (TakesScreenshot)driver;
		byte[] sourcePath= ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
