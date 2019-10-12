package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.BulkUpload;
import com.automation.platform.BulkUploadResult;
import com.automation.platform.Login;


public class BulkUploadResultTest {
	static Logger log=Logger.getLogger(BulkUploadResultTest.class);
	TestDataInput set=new TestDataInput();
	Utilities utily=new Utilities();
	
	
	
	@BeforeTest
    public void setUp() {
	DOMConfigurator.configure("log4j.xml");
	set.setSystemFileName("tuto.properties");
	set.loadProperties();
    utily.initDriver();
    Login login = new Login(driver);
    login.login("PRODUCER");
	}
	//@Test
	public void BulkUserView() throws IOException
	{
		BulkUploadResult Bulk=new BulkUploadResult(driver);
		Bulk.BulkUserUploadedReport(3697);
	}
	//@Test
	public void BulkStoresView() throws IOException {
		BulkUploadResult Bulk=new BulkUploadResult(driver);
		Bulk.BulkStoreUploadedReport(20);
	}
	@Test
	public void BulkRolesView() throws IOException {
		BulkUploadResult Bulk=new BulkUploadResult(driver);
		Bulk.BulkRoleUploadedReport(2);	
	}

}
