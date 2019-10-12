package com.automation.test;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.*;
import com.automation.platform.ProcessReports.periodicityType;

import static com.automation.common.TestDataInput.successMsg;
import static com.automation.common.TestDataInput.errorMsg;


public class ProcessReportsTest {

	static Logger log = Logger.getLogger(TaskTestOwner.class);
	TestDataInput launch = new TestDataInput();
	Utilities util = new Utilities();
	
	String dailyProcName = "$$Monthly_CutOff_AllowAfterCutOff_Scroll";
	String downloadsPath = "C:\\Users\\wooqer\\Downloads";
	/*
	 * //very imp ** - For all periodic processes the strt date and the end date
	 * should be the exact strt and end date of the respective periods which
	 * are being provided.The sanctity of the WOOQER Periodicities has to be
	 * maintained.
	 */
	String periodFilterDate1 = "01/01/2018";     //
	String periodFilterDate2 = "03/31/2020";
	
	@BeforeClass
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		launch.setSystemFileName("tuto.properties");
		launch.loadProperties();
		util.initDriver();
		Login login = new Login(driver);
		login.login("PRODUCER");

	}
	
	
	//submissionDate filter
	@Test(priority=0)
	public void submissionDateExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport(dailyProcName, true, periodFilterDate1, periodFilterDate2,periodicityType.MONTHLY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(true,downloadsPath);
		}
	
	//Monthly process
	@Test(priority=1)
	public void monthlyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport(dailyProcName, false, periodFilterDate1, periodFilterDate2,periodicityType.MONTHLY,"2018", "2020");  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Single process
	@Test(priority=2)
	public void singleExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$Single-DC-Users", false, periodFilterDate1, periodFilterDate2,periodicityType.SINGLE,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Daily process
	@Test(priority=3)
	public void dailyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$Daily_CutOff_Module", false, "07/01/2018", periodFilterDate2,periodicityType.DAILY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Weekly process
	@Test(priority=4)
	public void weeklyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$WeeklyImported", false, "09/09/2018", "02/09/2019",periodicityType.WEEKLY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Quarterly process
	//@Test(priority=5)
	public void quarterlyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$Quarterly-cutoff", false, periodFilterDate1, periodFilterDate2,periodicityType.QUARTERLY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Half-Annually process
	//@Test(priority=6)
	public void halfAnnuallyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$HalfAnnually_w/oCutOff_MLRA", false, "12/01/2016", "11/30/2017",periodicityType.HALFANNUALLY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Annually process
	//@Test(priority=7)
	public void annuallyExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$Annually_W/oCutOff_mlra", false, "06/01/2018", "05/31/2019",periodicityType.ANNUALLY,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	//Cyclic process
	//@Test(priority=8)
	public void cyclicExcel() throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ProcessReports rep = new ProcessReports(driver);
		rep.excelExport("$$Cyclic_w/oCutOff_mlra", false, "02/13/2018", "01/23/2019",periodicityType.CYCLIC,null, null);  // mm/dd/yyyy 
		rep.verifyExpectedFileName(false,downloadsPath);
		}
	
	
	
	//@AfterClass
		public void logout() throws InterruptedException{
			driver.close();
			
		}
}
