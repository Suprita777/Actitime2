package com.actitime.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;

public class TaskListPage extends BaseClass {
	
	@FindBy (xpath="//div[text()='Add New']")
	private WebElement addNewButton;
	
	@FindBy (xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerOptn;
	
	@FindBy (xpath="//span[text()='Create New Customer']")
	private WebElement popupTitle;
	
	@FindBy (xpath="//input[@placeholder='Enter Customer Name' and contains(@class, 'Placeholder')]")
	private WebElement customernametbx;
	
	@FindBy (xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerDestbx;
	
	@FindBy  (xpath="//span//div[@class='dropdownButton']")
	private WebElement SelectCustomerDD;
	
	@FindBy (xpath="//div[text()='Our company' and contains(@class,'itemRow')]")
	private WebElement ourCompanyoptn;
	
	@FindBy (xpath="//div[text()='Create Customer']")
	private WebElement createCustomerbtn;
	
	@FindBy (xpath="//div[@class='titleEditButtonContainer']/child::div[1]")
	private WebElement customerName;

	public TaskListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public void setAddNewButton() {
		addNewButton.click();
	}

	public void setNewCustomerOptn() {
		newCustomerOptn.click();
	}
	
	
	public WebElement getPopupTitle() {
		return popupTitle;
	}

	public void setPopupTitle(WebElement popupTitle) {
		this.popupTitle = popupTitle;
	}

	public void setCustomernametbx() throws EncryptedDocumentException, IOException {
		FileLib f=new FileLib();
		String customername = f.getExcelData("CreateCustomer", 1, 3);
		customernametbx.sendKeys(customername);
	}

	public void setCustomerDestbx() throws EncryptedDocumentException, IOException {
		FileLib f=new FileLib();
		String customerDes = f.getExcelData("CreateCustomer", 1, 4);
		customerDestbx.sendKeys(customerDes);
	}

	public void setSelectCustomerDD() {
		SelectCustomerDD.click();
	}

	public void setOurCompanyoptn(WebDriver driver) {
		Actions a=new Actions(driver);
		a.moveToElement(ourCompanyoptn).pause(200).click().perform();
	}

	public WebElement getCreateCustomerbtn() {
		return createCustomerbtn;
	}

	public WebElement getCustomerName() {
		return customerName;
	}
}
