package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.generic.WebDriverCommonLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;


public class CustomerModule extends BaseClass{

	@Test
	public void testcreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("create customer",true);
		WebDriverCommonLib w =new WebDriverCommonLib();
		w.implicitlyWait(driver);
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.setAddNewButton();
		t.setNewCustomerOptn();
		WebElement popupele=t.getPopupTitle();
		w.visiblityOfPopupTitle(driver,popupele);
		t.setCustomernametbx();
		t.setCustomerDestbx();
		t.setSelectCustomerDD();
		t.setOurCompanyoptn(driver);
		t.getCreateCustomerbtn().click();
		FileLib f=new FileLib();
		String expCustomerName=f.getExcelData("CreateCustomer", 1, 3);
		w.textPresentInElement(driver, t.getCustomerName(), expCustomerName);
		String actCustomerName=t.getCustomerName().getText();
		Assert.assertEquals(actCustomerName, expCustomerName, "Customer is created");
	}
	


}
