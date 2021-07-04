package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	private By Navigation=By.xpath("//span[@class='name ng-star-inserted']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public int getNavigationCount() {
		return driver.findElements(Navigation).size();
	}
	
	public List<String> getNAvigationList() {
		List<String> navList = new ArrayList<>();
		List<WebElement> NavigationList=driver.findElements(Navigation);
		for(WebElement e: NavigationList) {
			String text =e.getText();
			System.out.println(text);
			navList.add(text);
		}
		return navList;
	}
	
	public String getHomePageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public String pageURLCheck() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public void waitforPageLoad() {
		wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Navigation));
	}

}
