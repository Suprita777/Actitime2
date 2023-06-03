package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {

	public void implicitlyWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void visiblityOfPopupTitle(WebDriver driver,WebElement ele) {
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void textPresentInElement(WebDriver driver,WebElement ele, String text) {
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
		}
}
