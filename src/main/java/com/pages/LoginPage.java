package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private By userId=By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.className("btn-lg-r");
	private By forgotPassword = By.className("pink-text");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPassword).isDisplayed();
	}
	
	public void enterLoginId(String username) {
		driver.findElement(userId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void waitForLoginScreen() {
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userId));
	}


}
