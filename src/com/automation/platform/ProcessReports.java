package com.automation.platform;

import org.apache.commons.lang.UnhandledException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFDateAxis;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.Click;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.common.Utilities;
import com.automation.platform.Talk.assigntype;
import com.automation.test.TalkTestOwner;
import com.google.protobuf.ByteString.Output;
import com.sun.org.apache.bcel.internal.generic.ConstantPushInstruction;
//<<<<<<< .mine

//=======
//import com.sun.xml.internal.ws.api.server.SDDocumentFilter;
//>>>>>>> .r34409



import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class ProcessReports {

	static Logger log = Logger.getLogger(Task.class);
	static Login login = new Login(driver);

	static final String DB_URL = "jdbc:mysql://13.126.247.160/wooqer";

	static final String USER = "root";
	static final String PASS = "Wooqer@123";
	
	public enum periodicityType {
		SINGLE, DAILY, WEEKLY, MONTHLY, QUARTERLY, HALFANNUALLY, ANNUALLY, CYCLIC
	};

	

	/*--------Process reports - Excel export validation--------*/
	@FindBy(how = How.LINK_TEXT, using = "Process")
	public static WebElement procRepFrmDashboard;
	@FindBy(how = How.ID, using = "h_report")
	public static WebElement reportsIcon;
	@FindBy(how = How.LINK_TEXT, using = "Process Reports")
	public static WebElement procRepFrmDropdown;
	@FindBy(how = How.ID, using = "evaluationSearch")
	public static WebElement repSearchBar;
	@FindBy(how = How.ID, using = "excelExportIcon")
	public static WebElement excelExportIcon;
	@FindBy(how = How.ID, using = "dateRange")
	public static WebElement periodicityFilter;
	@FindBy(how = How.ID, using = "submissionDateInput")
	public static WebElement submissionFilter;
	@FindBy(how = How.ID, using = "dumpSd")
	public static WebElement periodStrtDate;
	@FindBy(how = How.ID, using = "dumpEd")
	public static WebElement periodEndDate;
	@FindBy(how = How.ID, using = "submissionStartDate")
	public static WebElement submissionStartDate;
	@FindBy(how = How.ID, using = "submissionEndDate")
	public static WebElement submissionEndDate;
	@FindBy(how = How.ID, using = "dumpMsgDiv")
	public static WebElement emailNotifMsg;
	@FindBy(how = How.ID, using = "emptyListRow")
	public static WebElement wrongProcessName;
	@FindBy(how = How.CLASS_NAME, using = "grayBoldTextBig")
	public static WebElement getTextDisplayed;
	@FindBy(how = How.ID, using = "date-error")
	public static WebElement dateRangeError;
	
	

	public ProcessReports(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebDriver excelExport(String processName, boolean submissionDate, String filterStrtDate, String filterEndDate,periodicityType periodicity, String strtyear, String endyear)
			throws IOException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		try{
			log.info("Starting db connection for fetching process id using process name");
			System.out.println("db connection for id using process name");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		     
			Connection conn = DriverManager.getConnection("jdbc:mysql://13.126.247.160/wooqer", "root", "Wooqer@123");
			System.out.println("CONNECTION ESTABLISHED");
			Statement stmnt = conn.createStatement();
			
			PreparedStatement p = conn.prepareStatement("select id from evaluations where name = (?);");
			p.setString(1, processName);
			
			System.out.println("PREPARED STMNT");
			ResultSet rs = p.executeQuery();
			System.out.println("RESULT SET");
			while(rs.next()){
		       int evalId = rs.getInt("id");
		       System.out.println("EVAL ID IS FETCHED");
		       Utilities.writeToPropertiesFile("output.properties", "Process_id", String.valueOf(evalId));
				System.out.println("Process eval_id is " + evalId);
				log.info("db opertaion for fetching the process eval id is completed.Eval id is " +evalId);
		}
		}catch(SQLException e){
			
		}
		
		
		try {
			if (procRepFrmDashboard.isDisplayed()) {
				procRepFrmDashboard.click();
			}
			log.info("Process Reports link  is clicked from dashboards");
		} catch (NoSuchElementException e) {
			log.error("Process Reports link is not present");
		}

		
		try {
			if (repSearchBar.isDisplayed()) {
				repSearchBar.click();
				repSearchBar.clear();
				repSearchBar.sendKeys(processName);
				pauseForTime(3000);
			}
			log.info("Search bar is clicked and given process name is entered");
		} catch (NoSuchElementException e) {
			log.error("search bar is not present and process name is not entered");
		}
		
		try{
			if(wrongProcessName.isDisplayed()){
				System.out.println("The given process name do not exist please provide a correct process name.Find the platform error message below");
				System.out.println(getTextDisplayed.getText());
				log.error("The given process name do not exist please provide a correct process name.Find the platform error message below" + getTextDisplayed.getText());
				System.exit(0);
			}
			
			}catch(NoSuchElementException e){
			log.info("Process name is correct and can go ahead with the testcase");
		}

		try {
			String eval_id = Utilities.readFromPropertiesFile("output.properties", "Process_id");
			String repId = "reportAnalyze" + eval_id;
			 driver.findElement(By.id(repId)).click();
			log.info("reports analyze button is clicked");
		} catch (NoSuchElementException e) {
			log.info("report button is not clicked");
		}

		/*try {
			pauseForTime(4000);
			String url1 = driver.getCurrentUrl();
			String id1 = url1.split("&")[1];
			String eval_id = id1.substring(2);
			Utilities.writeToPropertiesFile("output.properties", "Process_id", eval_id);
			System.out.println("Process eval_id is " + eval_id);
			

		} catch (NoSuchElementException e) {

		}*/
		try {
			pauseForTime(5000);
			if (excelExportIcon.isDisplayed()) {
				excelExportIcon.click();
				pauseForTime(5000);
			}
			log.info("Excel export icon is present on the screen");

		} catch (NoSuchElementException e) {
			log.error("Excel export icon is not found on the screen");
		}
		
		
		try{
			Utilities.writeToPropertiesFile("output.properties", "PeriodStrt1", filterStrtDate);
			Utilities.writeToPropertiesFile("output.properties", "PeriodEnd2", filterEndDate);
			
		}catch(IOException e){
			log.error("Counld not write provided start dates and end dates to output.properties file");
		}
		
		if(submissionDate){
			try{
				pauseForTime(3000);
				if (submissionFilter.isDisplayed()) {
					submissionFilter.click();
					pauseForTime(3000);
				}
				log.info("Periodicity based excel filter is present on the screen");

			} catch (NoSuchElementException e) {
				log.error("Periodicity based excel filter is not found on the screen");
			}

			try {
				
				submissionStartDate.clear();
				pauseForTime(2000);
				submissionStartDate.sendKeys(filterStrtDate);
				
				pauseForTime(3000);

				submissionEndDate.clear();
				pauseForTime(2000);
				submissionEndDate.sendKeys(filterEndDate);
				
				pauseForTime(3000);

				
			} catch (NoSuchElementException e) {
				log.error("export button is not clciked");
			}
				
			
		}else{
			
			switch (periodicity) {
			
			case SINGLE :
				try {
					pauseForTime(3000);
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}

				try {
					periodStrtDate.clear();
					pauseForTime(2000);
					periodStrtDate.sendKeys(filterStrtDate);
					
					pauseForTime(3000);

					periodEndDate.clear();
					pauseForTime(2000);
					periodEndDate.sendKeys(filterEndDate);
					
					pauseForTime(3000);

					
				} catch (NoSuchElementException e) {
					log.error("Daily process - filter Range is not set");
				}
				
			break;
			
			
			case DAILY :
				try {
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}

				try {
					periodStrtDate.clear();
					pauseForTime(2000);
					periodStrtDate.sendKeys(filterStrtDate);
					
					pauseForTime(3000);

					periodEndDate.clear();
					pauseForTime(2000);
					periodEndDate.sendKeys(filterEndDate);
					
					pauseForTime(3000);

					
				} catch (NoSuchElementException e) {
					log.error("Daily process - filter Range is not set");
				}
				
			break;
			
		case WEEKLY :
			try {
				if (periodicityFilter.isDisplayed()) {
					periodicityFilter.click();
				}
				log.info("Periodicity based excel filter is present on the screen");

			} catch (NoSuchElementException e) {
				log.error("Periodicity based excel filter is not found on the screen");
			}
				try{
				
				List<WebElement> strtWeek1 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
				System.out.println(strtWeek1.size());
				if (strtWeek1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				} else {
					for (int i = 0; i <= 40; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-from']/div/div[1]")).click();
						List<WebElement> strtWeek2 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
						System.out.println(strtWeek2.size());
						if (strtWeek2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
							i = 42;
						}
					}

				}

				List<WebElement> endWeek1 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
				if (endWeek1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-to']/div/div[1]")).click();
						List<WebElement> endWeek2 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
						System.out.println(endWeek2.size());
						if (endWeek2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
							i = 12;
						}
					}

				}
				}catch(NoSuchElementException e){
					log.error("Weekly process : range is not set");
				}
				
				break;
				
			case MONTHLY:
				try {
					pauseForTime(3000);
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}
				try{
					
				WebElement year = driver.findElement(By.className("header-name-text-view"));
				System.out.println(year.getText());
				System.out.println(strtyear);
				String yearText = year.getText();
				if (!yearText.equalsIgnoreCase(strtyear)) {
					int yearNo = Integer.parseInt(yearText);
					int strtNo = Integer.parseInt(strtyear);
					if (yearNo > strtNo) {
						pauseForTime(2000);
						driver.findElement(By.xpath("//div[@class = 'monthly-view-from']/div/div[1]")).click();
						
						driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
					} else {
						driver.findElement(By.xpath("//div[@class = 'monthly-view-from']/div/div[3]")).click();
						// mm/dd/yyyy
						driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
					}
				} else {
					String date = "01/01/2019"; // mm/dd/yyyy
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				}

				if (!yearText.equalsIgnoreCase(endyear)) {
					int yearNo = Integer.parseInt(yearText);
					int endNo = Integer.parseInt(endyear);
					if (yearNo > endNo) {
						pauseForTime(2000);
						driver.findElement(By.xpath("//div[@class = 'monthly-view-to']/div/div[1]")).click();
						 // mm/dd/yyyy
						driver.findElement(By.xpath("//div[@lang= '" +filterEndDate + "']")).click();
					} else {
						driver.findElement(By.xpath("//div[@class = 'monthly-view-to']/div/div[3]")).click();
						 // mm/dd/yyyy
						driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
					}
				} else {
					 // mm/dd/yyyy
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				}
				}catch(NoSuchElementException e){
					log.error("Monthly process : date range is not set");
				}
				
				break;
			case QUARTERLY:
				try {
					pauseForTime(3000);
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}
				try{
				List<WebElement> strtDate1 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
				System.out.println(strtDate1.size());
				if (strtDate1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-from']/div/div[1]")).click();
						List<WebElement> strtDate2 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
						System.out.println(strtDate2.size());
						if (strtDate2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
							i = 12;
						}
					}

				}

				List<WebElement> endDate1 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
				if (endDate1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-to']/div/div[1]")).click();
						List<WebElement> endDate2 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
						System.out.println(endDate2.size());
						if (endDate2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
							i = 12;
						}
					}

				}
				}catch(NoSuchElementException e){
					log.error("Quarterly process : date range is not set");
				}
				
				break;
			case HALFANNUALLY :
				try {
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}
				try{
				List<WebElement> strtHalf1 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
				System.out.println(strtHalf1.size());
				if (strtHalf1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-from']/div/div[1]")).click();
						List<WebElement> strtHalf2 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
						System.out.println(strtHalf2.size());
						if (strtHalf2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
							i = 12;
						}
					}

				}

				List<WebElement> endHalf1 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
				if (endHalf1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-to']/div/div[1]")).click();
						List<WebElement> endHalf2 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
						System.out.println(endHalf2.size());
						if (endHalf2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
							i = 12;
						}
					}

				}
				}catch(NoSuchElementException e){
					log.error("Half-annually process : date range is not set");
				}
				
				break;
				
			case ANNUALLY :
				try {
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}
				try{
				List<WebElement> strtAnn1 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
				System.out.println(strtAnn1.size());
				if (strtAnn1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-from']/div/div[1]")).click();
						List<WebElement> strtAnn2 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
						System.out.println(strtAnn2.size());
						if (strtAnn2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
							i = 12;
						}
					}

				}

				List<WebElement> endAnn1 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
				if (endAnn1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-to']/div/div[1]")).click();
						List<WebElement> endAnn2 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
						System.out.println(endAnn2.size());
						if (endAnn2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
							i = 12;
						}
					}

				}
				}catch(NoSuchElementException e){
					log.error("Annually process : date range is not set");
				}
				
				break;
				
			case CYCLIC :
				
				try {
					if (periodicityFilter.isDisplayed()) {
						periodicityFilter.click();
					}
					log.info("Periodicity based excel filter is present on the screen");

				} catch (NoSuchElementException e) {
					log.error("Periodicity based excel filter is not found on the screen");
				}
				try{
				List<WebElement> strtCyc1 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
				System.out.println(strtCyc1.size());
				if (strtCyc1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-from']/div/div[1]")).click();
						List<WebElement> strtCyc2 = driver.findElements(By.xpath("//div[@lang= '" + filterStrtDate + "']"));
						System.out.println(strtCyc2.size());
						if (strtCyc2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterStrtDate + "']")).click();
							i = 12;
						}
					}

				}

				List<WebElement> endCyc1 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
				if (endCyc1.size() > 0) {
					driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
				} else {
					for (int i = 0; i <= 10; i++) {
						driver.findElement(By.xpath("//div[@class = 'other-view-to']/div/div[1]")).click();
						List<WebElement> endCyc2 = driver.findElements(By.xpath("//div[@lang= '" + filterEndDate + "']"));
						System.out.println(endCyc2.size());
						if (endCyc2.size() == 1) {
							driver.findElement(By.xpath("//div[@lang= '" + filterEndDate + "']")).click();
							i = 12;
						}
					}

				}
				}catch(NoSuchElementException e){
					log.error("Cyclic process : date range is not set");
				}
				
				break;
				
		}
		}
	
		try{
			driver.findElement(By.id("exportBtn")).click();
			pauseForTime(5000);
			log.info("export button is clicked");
			
			
		}catch(NoSuchElementException e){
			log.error("export button is not clicked");
		}
		
		try{
			if(dateRangeError.isDisplayed()){
				System.out.println("The filterstrt and filter end dates provided are incorrect please check again.Could'nt download the file with the given date range");
				System.out.println(dateRangeError.getText());
				log.error("The filterstrt and filter end dates provided are incorrect please check again.Could'nt download the file with the given date range" + dateRangeError.getText());
				driver.findElement(By.id("cancelExport")).click();
				System.exit(0);
			}
			
			
		}catch(NoSuchElementException e){
			log.info("File gets downloaded.No issue with the date range as such");
		}
		
		
		try{
			if(emailNotifMsg.isDisplayed()){
				System.out.println("Cannot download the file as the date range is too large.Find the info attached below");
				System.out.println(emailNotifMsg.getText());
				log.error("Cannot download the file as the date range is too large.Find the info attached below" + emailNotifMsg.getText());
				driver.findElement(By.id("cancelExport")).click();
				System.exit(0);
			}
			
			
		}catch(NoSuchElementException e){
			log.info("File gets downloaded.No issue with the date range as such");
		}
		
		//Returning to dashboard for next test case
		try{
			driver.findElement(By.linkText("Dashboard")).click();
			pauseForTime(7000);
			log.info("Dashboard button is clicked");
			
			
		}catch(NoSuchElementException e){
			log.error("Dashboard button is not clicked");
		}
		
		
		try {

			String strtDate1 = Utilities.readFromPropertiesFile("output.properties", "PeriodStrt1");
			String EndDate1 = Utilities.readFromPropertiesFile("output.properties", "PeriodEnd2");
			String eval_id1 = Utilities.readFromPropertiesFile("output.properties", "Process_id");
			int eval_id = Integer.parseInt(eval_id1);

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			Date strtDate = sdf.parse(strtDate1);
			Date endDate = sdf.parse(EndDate1);

			
			System.out.println(strtDate);
			System.out.println(endDate);
			
			java.sql.Date sqlDate1 = new java.sql.Date(strtDate.getTime());
			java.sql.Date sqlDate2 = new java.sql.Date(endDate.getTime());
			
			System.out.println(sqlDate1);
			System.out.println(sqlDate2);

			System.out.println("starting db connection");
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection conn = DriverManager.getConnection("jdbc:mysql://13.126.247.160/wooqer", "root", "Wooqer@123");

			System.out.println("connection established");
			pauseForTime(3000);
			Statement stmnt = conn.createStatement();
			System.out.println("stmnt created ");
			pauseForTime(2000);
			
			if(submissionDate){
				PreparedStatement p = conn.prepareStatement(
						"select count(id) As count from evaluation_reports where evaluations_id=(?) and  created >=(?) and created <= (?);");
				p.setInt(1, eval_id);
				p.setDate(2, sqlDate1);
				p.setDate(3, sqlDate2);
				System.out.println("prepared stmnt");
				

				ResultSet rs = p.executeQuery();
				

				while (rs.next()) {
					int expectedRecords = rs.getInt("count");

					Utilities.writeToPropertiesFile("output.properties", "ExpectedRecords",
							String.valueOf(expectedRecords));
					System.out.println("Expected records are " + expectedRecords);

				
			}
			}else{
			PreparedStatement p = conn.prepareStatement(
					"select count(id) As count from evaluation_reports where evaluations_id=(?) and  eval_date >=(?) and eval_date <= (?);");
			p.setInt(1, eval_id);
			p.setDate(2, sqlDate1);
			p.setDate(3, sqlDate2);
			System.out.println("prepared stmnt");
			

			ResultSet rs = p.executeQuery();
			

			while (rs.next()) {
				int expectedRecords = rs.getInt("count");

				Utilities.writeToPropertiesFile("output.properties", "ExpectedRecords",
						String.valueOf(expectedRecords));
				System.out.println("Expected records are " + expectedRecords);

			}
			}
		} catch (SQLException e) {
			log.error("db connection code failed");
		}

		return driver;
	}

	
	public void verifyExpectedFileName(boolean submissionDate1 ,String downloadPath) throws IOException, ParseException {

		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		Utilities.writeToPropertiesFile("output.properties", "downloadedFileName", fileName);
		
		System.out.println(fileName);
		
		String fileName1 = Utilities.readFromPropertiesFile("output.properties", "downloadedFileName");
		String filePath = "C:\\Users\\wooqer\\Downloads\\" + fileName1;
		String strtDate1 = Utilities.readFromPropertiesFile("output.properties", "PeriodStrt1");
		String EndDate1 = Utilities.readFromPropertiesFile("output.properties", "PeriodEnd2");
		String ExpectedRecords = Utilities.readFromPropertiesFile("output.properties", "ExpectedRecords");
		System.out.println("expected records fecthed from out.prop file " + ExpectedRecords);
		System.out.println(filePath);
		try (FileInputStream fis = new FileInputStream(filePath)) {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Read a cell the first cell on the sheet.

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			System.out.println("Total number of records = " + rowCount);

			int expecRec = Integer.parseInt(ExpectedRecords);
			if (rowCount == expecRec) {
				System.out
						.println("Number of records present in the downloaded file are equal to the expected records.");
				log.info("Number of records present in the downloaded file are equal to the expected records.");
			} else {
				System.out.println(
						"Number of records present in the downloaded file are not equal to the expected records.");
				log.error("Number of records present in the downloaded file are not equal to the expected records.");
			}
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date strtDate = sdf.parse(strtDate1);
			Date endDate = sdf.parse(EndDate1);

			int validRecordCount = 0;
			int inValidRecordCount = 0;
			
			
			if(submissionDate1){
			Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()){
                	 Cell cell = cellIterator.next();
                	 //To filter column headings
                	 if(cell.getStringCellValue().equals("Submission Date (UTC +05:30) (dd/mm/yyyy)")){
                        	int col = cell.getColumnIndex();// To match column index
                        	System.out.println("got submission column");
                        	
                        	for (int i = 1; i <= rowCount; i++) {
                				XSSFCell cell1 = sheet.getRow(i).getCell(col);

                				//if (HSSFDateUtil.isCellDateFormatted(cell)) {
                				
                				DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
                				
                				 String dateValue = formatter.formatCellValue(cell1);
                				 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                					Date cellDate = sdf1.parse(dateValue);
                					
                					
                					System.out.println("after parsing the date is" +cellDate);
                					//System.out.println("Row No.: " + cell1.getRowIndex() + " " + cell1.getStringCellValue());

                					System.out.println("Date in excel row is " + cellDate);
                					System.out.println("Date being compared to  " + strtDate);

                					if ((cellDate.after(strtDate) || cellDate.equals(strtDate)) && (cellDate.before(endDate) ||  cellDate.equals(endDate))) {
                						validRecordCount++;
                						System.out.println("Valid record is present");
                					} else {
                						inValidRecordCount++;
                						System.out.println("Invalid record is present");
                					}
                     	

                        	}
                			System.out.println("Valid Record count = " + validRecordCount);
                			log.info("Valid Record count = " + validRecordCount);
                			System.out.println("InValid Record count = " + inValidRecordCount);
                			log.info("InValid Record count = " + inValidRecordCount);

                			workbook.close();
                       
                        	}
                        	
                        	}
                       
                break;
                        }
			}else{
                        	for (int i = 1; i <= rowCount; i++) {

				XSSFCell cell = sheet.getRow(i).getCell(0);

				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date cellDate = cell.getDateCellValue();

					System.out.println("Row No.: " + cell.getRowIndex() + " " + cell.getDateCellValue());

					System.out.println("Date in excel row is " + cellDate);
					System.out.println("Date being compared to  " + strtDate);

					if ((cellDate.after(strtDate) || cellDate.equals(strtDate)) && (cellDate.before(endDate) ||  cellDate.equals(endDate))) {
						validRecordCount++;
						System.out.println("Valid record is present");
					} else {
						inValidRecordCount++;
						System.out.println("Invalid record is present");
					}
				} else {
					System.out.println("Date field is not present in the fisrt cell of the row");
				}

			}
			System.out.println("Valid Record count = " + validRecordCount);
			log.info("Valid Record count = " + validRecordCount);
			System.out.println("InValid Record count = " + inValidRecordCount);
			log.info("InValid Record count = " + inValidRecordCount);

			workbook.close();
                        }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

/*
 * try{ log.info(""); }catch(NoSuchElementException e){ log.error(""); }
 * 
 * 
 * 
 */
