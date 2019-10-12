package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BulkUploadResult {
	Logger log=Logger.getLogger(BulkUploadResult.class);
	Login login = new Login(driver);
	@FindBy(id="switchPiTabLink")
	WebElement ManagePI;
	@FindBy(xpath="//a[@title='View Bulk Users Uploaded Report']")
	WebElement ViewUserReport;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]")
	WebElement DownloadReport;
	@FindBy(xpath="//a[text()='Stores']")
	WebElement Store;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[1]/div[2]/span[2]/a[1]/img[1]")
	WebElement ViewStoreReport;
	@FindBy(xpath="//a[text()='Roles']")
	WebElement Roles;
	@FindBy(xpath="//a[@title='View Bulk Functions / Roles Uploaded Report']")
	WebElement ViewRoleReport;
	
	public BulkUploadResult(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	 }
	public WebDriver BulkUserUploadedReport(int numberofUsers) throws IOException {
		    Properties prop=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		    prop.load(fi);
		
			   try {
					 if(waitForElement(ManagePI,60).isDisplayed()) {
						 ManagePI.click();
				  }}
			  catch(Exception ex) {
					log.error("ManagePI tab is not found");
				}
			   try {
					 if(waitForElement(ViewUserReport,60).isDisplayed()) {
						 ViewUserReport.click();
				  }
					 }
			  catch(Exception ex) {
					log.error("View Report option is not found");
				}
			   
			  try {
					 if(waitForElement(DownloadReport,60).isDisplayed()) {
						 DownloadReport.click();
						 log.info("Users generated report is downloaded");
				  }
					}
			 catch(Exception ex) {
					log.error("Bulk User uploaded report is not been generated yet");
				}
			  File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
				String fileName = getLatestFile.getName();
				System.out.println(fileName);
			   pauseForTime(5000);
			   FileInputStream fis=new FileInputStream(prop.getProperty("downloadPath")+fileName);
			   XSSFWorkbook XWB=new XSSFWorkbook(fis);
			   XSSFSheet sheet=XWB.getSheetAt(0);
			  Iterator<Row> R=sheet.iterator();
			  Row R0=R.next();
			  Iterator<Cell> C=R0.cellIterator();
			  Cell Status=R0.getCell(28);
			  if(Status.getStringCellValue().equalsIgnoreCase("Status")){
				  for(int i=1;i<numberofUsers;i++) {
			   Row R1=R.next();
			   Cell Value=R1.getCell(28);
			  if(Value.getStringCellValue().equalsIgnoreCase("successful")){
				  log.info("user is created successfully");
			  }else {
				 Cell Comment1=R1.getCell(29);
				 log.error(Comment1);
			  }
			   }
				 }
		return driver;
		}
	
	public WebDriver BulkStoreUploadedReport(int numberofStores) throws IOException {
		 Properties prop=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		prop.load(fi);
		         try {
					 if(waitForElement(ManagePI,60).isDisplayed()) {
						 ManagePI.click();
				  }
					 }
			  catch(Exception ex) {
					log.error("ManagePI tab is not found");
				}
			   
			   try {
					 if(waitForElement(Store,60).isDisplayed()) {
						 Store.click();
				  }
					 }
			  catch(Exception ex) {
					log.error("Store option is not found");
		           }
			   
			   try {
					 if(waitForElement(ViewStoreReport,60).isDisplayed()) {
						 ViewStoreReport.click();
				  }
					 }
			  catch(Exception ex) {
					log.error("View Report option is not found");
		           }
			   try {
					 if(waitForElement(DownloadReport,60).isDisplayed()) {
						 DownloadReport.click();
						 log.info("Stores generated report is downloaded");
				  }
					}
			 catch(Exception ex) {
					log.error("Bulk Store uploaded report is not been generated yet");
				}
			   File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
				String fileName = getLatestFile.getName();
				System.out.println(fileName);
			  pauseForTime(5000);
			   FileInputStream fis=new FileInputStream(prop.getProperty("downloadPath")+fileName);
			   XSSFWorkbook XWB=new XSSFWorkbook(fis);
			   XSSFSheet sheet=XWB.getSheetAt(0);
			  Iterator<Row> R=sheet.iterator();
			  Row R0=R.next();
			  Iterator<Cell> C=R0.cellIterator();
			  Cell Status=R0.getCell(12);
			  if(Status.getStringCellValue().equalsIgnoreCase("longitude")){
				  for(int i=1;i<numberofStores;i++) {
			   Row R1=R.next();
			   Cell Value=R1.getCell(12);
			  if(Value.getStringCellValue().equalsIgnoreCase("successful")){
				  log.info("Store is created successfully");
			  }else {
				 Cell Reason=R1.getCell(13);
				 log.error(Reason);
			  }
			   }
			}
			  
		return driver;
		
	     }
	public WebDriver BulkRoleUploadedReport(int numberofRoles) throws IOException {
		 Properties prop=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		prop.load(fi);
		try {
			 if(waitForElement(ManagePI,60).isDisplayed()) {
				 ManagePI.click();
		  }
			 }
	  catch(Exception ex) {
			log.error("ManagePI tab is not found");
		}
	   
	   try {
			 if(waitForElement(Roles,60).isDisplayed()) {
				 Roles.click();
		  }
			 }
	  catch(Exception ex) {
			log.error("Role option is not found");
          }
	   
	   try {
			 if(waitForElement(ViewRoleReport,60).isDisplayed()) {
				 ViewRoleReport.click();
		  }
			 }
	  catch(Exception ex) {
			log.error("View Report option is not found");
          }
	   try {
			 if(waitForElement(DownloadReport,60).isDisplayed()) {
				 DownloadReport.click();
				 log.info("Roles generated report is downloaded");
		  }
			}
	 catch(Exception ex) {
			log.error("Bulk Roles uploaded report is not been generated yet");
		}
	   File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
		String fileName = getLatestFile.getName();
		System.out.println(fileName);
	  pauseForTime(5000);
	   FileInputStream fis=new FileInputStream(prop.getProperty("downloadPath")+fileName);
	   XSSFWorkbook XWB=new XSSFWorkbook(fis);
	   XSSFSheet sheet=XWB.getSheetAt(0);
	  Iterator<Row> R=sheet.iterator();
	  Row R0=R.next();
	  Iterator<Cell> C=R0.cellIterator();
	  Cell Status=R0.getCell(4);
	  if(Status.getStringCellValue().equalsIgnoreCase("Status")){
		  for(int i=0;i<numberofRoles;i++) {
	   Row R1=R.next();
	   Cell Value=R1.getCell(4);
	  if(Value.getStringCellValue().equalsIgnoreCase("successful")){
		  log.info("Store is created successfully");
	  }else {
		 Cell Reason=R1.getCell(5);
		 log.error(Reason);
	  }
	   }
	}
	   return driver;
		
	}
	  
		private File getLatestFilefromDir(String dirPath) {
			File dir = new File(dirPath);
			File[] files = dir.listFiles();
			if (files == null || files.length == 0) {
				return null;
			}

			File lastModifiedFile = files[0];
			for (int i = 1; i < files.length; i++) {
				if (lastModifiedFile.lastModified() < files[i].lastModified()) {
					lastModifiedFile = files[i];
				}
			}
			return lastModifiedFile;
		}
	
}
