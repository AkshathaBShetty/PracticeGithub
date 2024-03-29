package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.sikuli.script.SikuliException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.BulkUpload;
import com.automation.platform.Login;
import com.automation.platform.Search;

public class BulkUploadTest {
	static Logger log=Logger.getLogger(BulkUploadTest.class);
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
	public void BulkUserUpload1() throws IOException, FindFailed
	{
		BulkUpload Bulk=new BulkUpload(driver);
		Bulk.BulkUserCreation(true,100,true,true,true,true,true,true,true,true,true,true,true,true,true);
	}
	
	//@Test
	public void BulkUserUpload2() throws IOException, FindFailed
	{
		BulkUpload Bulk=new BulkUpload(driver);
		Bulk.BulkUserCreation(true,10,false,true,true,true,true,true,true,false,true,true,true,true,false);
	}
	@Test
	public void Bulkstoreupload() throws SikuliException, IOException  {
		BulkUpload Bulk=new BulkUpload(driver);
		Bulk.BulkStoreCreation(100,true,true,true,true,false,false,false,false);
	}
    //@Test
    public void RoleBulkupload() throws IOException, SikuliException {
	 BulkUpload Bulk=new BulkUpload(driver);
	 Bulk.RoleBulkupload(100);
 }
}
