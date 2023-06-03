package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.LoginPage;

public class BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./driverexe/chromedriver.exe");	
	}
	
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
		FileLib f=new FileLib();
		String url=f.getPropertyData("url");
		String un=f.getPropertyData("username");
		String pw=f.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un,pw);
		
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
	}
	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("close browser", true);
		driver.close();
	}
	
}
