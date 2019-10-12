package com.automation.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;







import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.automation.test.LoginTest;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.Cell;
import org.testng.annotations.DataProvider;

public class TestDataInput {  
	String user;
	public static String username;
	public static String password;
	private static String prUser;
	private static String prPwd;
	private static String user0;
	private static String pwd0;
	private static String user1;
	private static String pwd1;
	private static String user2;
	private static String pwd2;
	private static String user3;
	private static String pwd3;
	private static String user4;
	private static String pwd4;
	private static String user5;
	private static String pwd5;
	private static String invalidUser;
	private static String invalidPwd;
	private static String noUser;
        private static String noPwd;
	public static String assignToUser0;
	public static String assignToUser1;
	public static String assignToUser2;
	public static String assignToUser3;
	public static String assignToUser4;
	public static String submitToUser;
	public static String processCommonId;
	public static String surveyCommonId;
	public static String moduleCommonId;
	public static String chapterCommonId;
	public static String weeklyCutOffDay;
	public static String dailyCutOffHour;
	public static String invalidCutOffHour;
	public static String invalidCutOffMinute;
	public static String invalidCutOff;
	public static String monthlyCutOffDays;
	public static String qrtrlyCutOffDays;
	public static String halfYrlyCutOffDays;
	public static String yrlyCutOffDays;
	public static String cyclicRepeatDays;
	public static String weekStartDay;
	public static String qrtrStartMonth;
	public static String halfAnnualStartMonth;
	public static String annualStartMonth;
	public static String cycleIdentifier;
	private String systemFileName;
	public static String testDataFile;
	public static String processSheetName;
	public static String surveySheetName;
	public static String moduleSheetName;
	public static String moduleStartTC;
	public static String prSanityStartTC;
	public static String prRegrnStartTC;
	public static String pdfFile;
	public static String jpgFile;
	public static String pngFile;
	public static String wavFile;
	public static String aviFile;
	public static String docFile;
	public static String txtFile;
	public static String xlsFile;
	public static String pptFile;
	public static String swfFile;
	public static String mp4File;
//	public static String filePath = "/root/workspace/automation/web/testdata-fileformats/";
	public static String filePath = "C:\\Users\\wooqer\\workspace_0211\\NewUIAutomation\\Files\\";
//public static String sikuliPath = "/root/workspace/automation/src/main/com/automation/platform/sikuli.sikuli/";
	public static String sikuliPath = "C:\\Users\\wooqer\\workspace_0211\\NewUIAutomation\\src\\main\\com\\automation\\platform\\sikuli.sikuli\\";
	public static String successMsg = "Looking up our guest list";
	public static String errorMsg = "Wrong Password. Try again." + '\n' + "Note: Passwords are case sensitive.";
	public static String forgotPwdInvalidUsrMsg = "Wrong Username."+'\n'+" It is the Email ID or Mobile number used for registration.";
	public static String  forgotPwdvalidUsrMsg = " Email sent to " + LoginTest.validEmail ;
	 
	public static HSSFSheet ExcelWSheet;
	public static HSSFWorkbook ExcelWBook;
	public static HSSFCell Cell;
	public static HSSFRow Row;
	private static String mp3File;
	
	
	public static String getPrSanityStartTC() {
		return prSanityStartTC;
	}

	public void setPrSanityStartTC(String prSanityStartTC) {
		TestDataInput.prSanityStartTC = prSanityStartTC;
	}

	public static String getPrRegrnStartTC() {
		return prRegrnStartTC;
	}

	public void setPrRegrnStartTC(String prRegrnStartTC) {
		TestDataInput.prRegrnStartTC = prRegrnStartTC;
	}

	public static String getSubmitToUser() {
		return submitToUser;
	}

	public void setSubmitToUser(String submitToUser) {
		TestDataInput.submitToUser = submitToUser;
	}	

	public static String getProcessCommonId() {
                return processCommonId;
        }

        public void setProcessCommonId(String processCommonId) {
                TestDataInput.processCommonId = processCommonId;
        }

        public static String getSurveyCommonId() {
                return surveyCommonId;
        }

        public void setSurveyCommonId(String surveyCommonId) {
                TestDataInput.surveyCommonId = surveyCommonId;
        }

        public static String getModuleCommonId() {
                return moduleCommonId;
        }

        public void setModuleCommonId(String moduleCommonId) {
                TestDataInput.moduleCommonId = moduleCommonId;
        }

        public static String getChapterCommonId() {
                return chapterCommonId;
        }

        public void setChapterCommonId(String chapterCommonId) {
                TestDataInput.chapterCommonId = chapterCommonId;
        }

        public static String getSwfFile() {
		return swfFile;
	}

	public void setSwfFile(String swfFile) {
		TestDataInput.swfFile = swfFile;
	}
	
	public void setMp3File(String mp3File) {
		TestDataInput.mp3File = mp3File;
	}
	
	public static String getMp3File() {
		System.out.println("mp3File= " + mp3File);
		return mp3File;
	}
	
	

	//edited added pritn stmt
	public static String getPdfFile() {
		System.out.println("pdfFile= " + pdfFile);
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		TestDataInput.pdfFile = pdfFile;
	}

	public static String getJpgFile() {
		return jpgFile;
	}

	public void setJpgFile(String jpgFile) {
		TestDataInput.jpgFile = jpgFile;
	}

	public static String getPngFile() {
		return pngFile;
	}

	public void setPngFile(String pngFile) {
		TestDataInput.pngFile = pngFile;
	}

	public static String getWavFile() {
		return wavFile;
	}

	public void setWavFile(String wavFile) {
		TestDataInput.wavFile = wavFile;
	}

	public static String getAviFile() {
		return aviFile;
	}

	public void setAviFile(String aviFile) {
		TestDataInput.aviFile = aviFile;
	}

	public static String getMp4File() {
                return mp4File;
        }

        public void setMp4File(String mp4File) {
                TestDataInput.mp4File = mp4File;
        }
        
	public static String getDocFile() {
		return docFile;
	}

	public void setDocFile(String docFile) {
		TestDataInput.docFile = docFile;
	}

	public static String getTxtFile() {
		return txtFile;
	}

	public void setTxtFile(String txtFile) {
		TestDataInput.txtFile = txtFile;
	}

	public static String getXlsFile() {
		return xlsFile;
	}

	public void setXlsFile(String xlsFile) {
		TestDataInput.xlsFile = xlsFile;
	}

	public static String getPptFile() {
		return pptFile;
	}

	public void setPptFile(String pptFile) {
		TestDataInput.pptFile = pptFile;
	}

	public static String getProcessSheetName() {
		return processSheetName;
	}

	public void setProcessSheetName(String processSheetName) {
		TestDataInput.processSheetName = processSheetName;
	}
	
	public static String getSurveySheetName() {
                return surveySheetName;
        }

        public void setSurveySheetName(String surveySheetName) {
                TestDataInput.surveySheetName = surveySheetName;
        }

        public static String getModuleSheetName() {
                return moduleSheetName;
        }

        public void setModuleSheetName(String moduleSheetName) {
                TestDataInput.moduleSheetName = moduleSheetName;
        }

        public static String getTestDataFile() {
		return testDataFile;
	}

	public void setTestDataFile(String testDataFile) {
		TestDataInput.testDataFile = testDataFile;
	}
	

	public static String getModuleStartTC() {
		return moduleStartTC;
	}

	public void setModuleStartTC(String moduleStartTC) {
		TestDataInput.moduleStartTC = moduleStartTC;
	}

	public static String getAssignToUser0() {
		return assignToUser0;
	}

	public void setAssignToUser0(String assignToUser0) {
		TestDataInput.assignToUser0 = assignToUser0;
	}

	public static String getAssignToUser1() {
		return assignToUser1;
	}

	public void setAssignToUser1(String assignToUser1) {
		TestDataInput.assignToUser1 = assignToUser1;
	}

	public static String getAssignToUser2() {
		return assignToUser2;
	}

	public void setAssignToUser2(String assignToUser2) {
		TestDataInput.assignToUser2 = assignToUser2;
	}

	public static String getAssignToUser3() {
		return assignToUser3;
	}

	public void setAssignToUser3(String assignToUser3) {
		TestDataInput.assignToUser3 = assignToUser3;
	}

	public static String getAssignToUser4() {
		return assignToUser4;
	}

	public void setAssignToUser4(String assignToUser4) {
		TestDataInput.assignToUser4 = assignToUser4;
	}

	public static String getWeeklyCutOffDay() {
		return weeklyCutOffDay;
	}

	public void setWeeklyCutOffDay(String weeklyCutOffDay) {
		TestDataInput.weeklyCutOffDay = weeklyCutOffDay;
	}

	public static String getDailyCutOffHour() {
		return dailyCutOffHour;
	}

	public void setDailyCutOffHour(String dailyCutOffHour) {
		TestDataInput.dailyCutOffHour = dailyCutOffHour;
	}
	
	public static String getInvalidCutOffHour() {
                return invalidCutOffHour;
        }

        public void setInvalidCutOffHour(String invalidCutOffHour) {
                TestDataInput.invalidCutOffHour = invalidCutOffHour;
        }
        
        public static String getInvalidCutOffMinute() {
                return invalidCutOffMinute;
        }

        public void setInvalidCutOffMinute(String invalidCutOffMinute) {
                TestDataInput.invalidCutOffMinute = invalidCutOffMinute;
        }
	
	public static String getInvalidCutOff() {
                return invalidCutOff;
        }

        public void setInvalidCutOff(String invalidCutOff) {
                TestDataInput.invalidCutOff = invalidCutOff;
        }

        public static String getMonthlyCutOffDays() {
                return monthlyCutOffDays;
        }

        public void setMonthlyCutOffDays(String monthlyCutOffDays) {
                TestDataInput.monthlyCutOffDays = monthlyCutOffDays;
        }

        public static String getQrtrlyCutOffDays() {
                return qrtrlyCutOffDays;
        }

        public void setQrtrlyCutOffDays(String qrtrlyCutOffDays) {
                TestDataInput.qrtrlyCutOffDays = qrtrlyCutOffDays;
        }

        public static String getHalfYrlyCutOffDays() {
                return halfYrlyCutOffDays;
        }

        public void setHalfYrlyCutOffDays(String halfYrlyCutOffDays) {
                TestDataInput.halfYrlyCutOffDays = halfYrlyCutOffDays;
        }

        public static String getYrlyCutOffDays() {
                return yrlyCutOffDays;
        }

        public void setYrlyCutOffDays(String yrlyCutOffDays) {
                TestDataInput.yrlyCutOffDays = yrlyCutOffDays;
        }

        public static String getCyclicRepeatDays() {
                return cyclicRepeatDays;
        }

        public void setCyclicRepeatDays(String cyclicRepeatDays) {
                TestDataInput.cyclicRepeatDays = cyclicRepeatDays;
        }
        
        public static String getWeekStartDay() {
                return weekStartDay;
        }

        public void setWeekStartDay(String weekStartDay) {
                TestDataInput.weekStartDay = weekStartDay;
        }

        public static String getQrtrStartMonth() {
                return qrtrStartMonth;
        }

        public void setQrtrStartMonth(String qrtrStartMonth) {
                TestDataInput.qrtrStartMonth = qrtrStartMonth;
        }

        public static String getHalfAnnualStartMonth() {
                return halfAnnualStartMonth;
        }

        public void setHalfAnnualStartMonth(String halfAnnualStartMonth) {
                TestDataInput.halfAnnualStartMonth = halfAnnualStartMonth;
        }

        public static String getAnnualStartMonth() {
                return annualStartMonth;
        }

        public void setAnnualStartMonth(String annualStartMonth) {
                TestDataInput.annualStartMonth = annualStartMonth;
        }

        public static String getCycleIdentifier() {
                return cycleIdentifier;
        }

        public void setCycleIdentifier(String cycleIdentifier) {
                TestDataInput.cycleIdentifier = cycleIdentifier;
        }

        public static String getPrUser() {
		return prUser;
	}

	public void setPrUser(String prUser) {
		TestDataInput.prUser = prUser;
	}

	public static String getPrPwd() {
		return prPwd;
	}

	public void setPrPwd(String prPwd) {
		TestDataInput.prPwd = prPwd;
	}

	public static String getUser0() {
		return user0;
	}

	public void setUser0(String user0) {
		TestDataInput.user0 = user0;
	}

	public static String getPwd0() {
		return pwd0;
	}

	public void setPwd0(String pwd0) {
		TestDataInput.pwd0 = pwd0;
	}

	public static String getUser3() {
		return user3;
	}

	public void setUser3(String user3) {
		TestDataInput.user3 = user3;
	}

	public static String getPwd3() {
		return pwd3;
	}

	public void setPwd3(String pwd3) {
		TestDataInput.pwd3 = pwd3;
	}

	public static String getUser4() {
		return user4;
	}

	public void setUser4(String user4) {
		TestDataInput.user4 = user4;
	}

	public static String getPwd4() {
		return pwd4;
	}

	public void setPwd4(String pwd4) {
		TestDataInput.pwd4 = pwd4;
	}

	public static String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		TestDataInput.user2 = user2;
	}

	public static String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		TestDataInput.pwd2 = pwd2;
	}	

	public static String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		TestDataInput.user1 = user1;
	}

	public static String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		TestDataInput.pwd1 = pwd1;
	}
	  
	public static String getInvalidUser() {
                return invalidUser;
        }

        public void setInvalidUser(String invalidUser) {
                TestDataInput.invalidUser = invalidUser;
        }

        public static String getInvalidPwd() {
                return invalidPwd;
        }

        public void setInvalidPwd(String invalidPwd) {
                TestDataInput.invalidPwd = invalidPwd;
        }

        public static String getNoUser() {
                return noUser;
        }

        public void setNoUser(String noUser) {
                TestDataInput.noUser = noUser;
        }

        public static String getNoPwd() {
                return noPwd;
        }

        public void setNoPwd(String noPwd) {
                TestDataInput.noPwd = noPwd;
        }

        public String getSystemFileName() {
		return systemFileName;
	}

	public void setSystemFileName(String fileName) {
		this.systemFileName = fileName;
	}

    public void loadProperties(){
		try {
			FileInputStream fis = new FileInputStream(this.getSystemFileName());
			System.out.println("System Properties file name is " + this.getSystemFileName());
			System.out.println("Image file path is " + filePath);
			System.out.println("Sikuli file path is " + sikuliPath);
			Properties property = new Properties();
			property.load(fis);
			System.out.println("Loaded properties from file: " + fis);
			Utilities.setBrowser(property.getProperty("browser"));
			Utilities.setUrl(property.getProperty("siteURL"));
			this.setWeeklyCutOffDay(property.getProperty("weeklycutoff"));
			this.setDailyCutOffHour(property.getProperty("dailycutoffTime"));
			this.setInvalidCutOffHour(property.getProperty("invalidcutoffhour"));
			this.setInvalidCutOffMinute(property.getProperty("invalidcutoffmin"));
			this.setInvalidCutOff(property.getProperty("invalidcutoff"));
			this.setMonthlyCutOffDays(property.getProperty("monthlycutoff"));
			this.setQrtrlyCutOffDays(property.getProperty("quarterlycutoff"));
			this.setHalfYrlyCutOffDays(property.getProperty("halfyearlycutoff"));
			this.setYrlyCutOffDays(property.getProperty("yearlycutoff"));
			this.setCyclicRepeatDays(property.getProperty("cycleInterval"));
			this.setWeekStartDay(property.getProperty("week.start.day"));
			this.setQrtrStartMonth(property.getProperty("quarter.start.month"));
			this.setHalfAnnualStartMonth(property.getProperty("halfannual.start.month"));
			this.setAnnualStartMonth(property.getProperty("annual.start.month"));
			this.setCycleIdentifier(property.getProperty("cycleId"));
			this.setTestDataFile(property.getProperty("testdata.process.filepath"));
			this.setProcessSheetName(property.getProperty("process.excel.sheetname"));
			this.setSurveySheetName(property.getProperty("survey.excel.sheetname"));
			this.setModuleSheetName(property.getProperty("module.excel.sheetname"));
			this.setModuleStartTC(property.getProperty("module.start.testcase"));
			this.setPrSanityStartTC(property.getProperty("process.sanity.start.testcase"));
			this.setPrRegrnStartTC(property.getProperty("process.regression.start.testcase"));
			this.setPdfFile(filePath + property.getProperty("pdf.file"));
			this.setJpgFile(filePath + property.getProperty("jpg.file"));
			this.setPngFile(filePath + property.getProperty("png.file"));
			this.setWavFile(filePath + property.getProperty("wav.file"));
			this.setAviFile(filePath + property.getProperty("avi.file"));
			this.setMp4File(filePath + property.getProperty("mp4.file"));
			this.setDocFile(filePath + property.getProperty("doc.file"));
			this.setTxtFile(filePath + property.getProperty("txt.file"));
			this.setXlsFile(filePath + property.getProperty("xls.file"));
			this.setPptFile(filePath + property.getProperty("ppt.file"));
			this.setSwfFile(filePath + property.getProperty("swf.file"));
			this.setMp3File(filePath + property.getProperty("mp3.file"));
			this.setAssignToUser0(property.getProperty("lvl0user"));
			this.setAssignToUser1(property.getProperty("lvl1user"));
			this.setAssignToUser2(property.getProperty("lvl2user"));
			this.setAssignToUser3(property.getProperty("lvl3user"));
			this.setAssignToUser4(property.getProperty("lvl4user"));
			this.setSubmitToUser(property.getProperty("submit.to.user"));
			this.setProcessCommonId(property.getProperty("process.common.identifier"));
			this.setSurveyCommonId(property.getProperty("survey.common.identifier"));
			this.setModuleCommonId(property.getProperty("module.common.identifier"));
			this.setChapterCommonId(property.getProperty("chapter.common.identifier"));
			this.setPrUser(property.getProperty("producer.username"));
			this.setPrPwd(property.getProperty("producer.password"));
			this.setInvalidUser(property.getProperty("invalid.username"));
            this.setInvalidPwd(property.getProperty("invalid.password"));
            this.setNoUser(property.getProperty("nonexisting.username"));
            this.setNoPwd(property.getProperty("nonexisting.password"));
			this.setUser0(property.getProperty("lvl0.user.username"));
			this.setPwd0(property.getProperty("lvl0.user.password"));
			this.setUser1(property.getProperty("lvl1.user.username"));
			this.setPwd1(property.getProperty("lvl1.user.password"));
			this.setUser2(property.getProperty("lvl2.user.username"));
			this.setPwd2(property.getProperty("lvl2.user.password"));
			this.setUser3(property.getProperty("lvl3.user.username"));
			this.setPwd3(property.getProperty("lvl3.user.password"));
			this.setUser4(property.getProperty("lvl4.user.username"));
			this.setPwd4(property.getProperty("lvl4.user.password"));
		} catch (FileNotFoundException e) {
			// File Not found exception
			System.out.println("Cannot find the file " + this.getSystemFileName());
			e.printStackTrace();
		} catch (IOException e) {
			// IO Exception
			System.out.println("Seems like the file " + this.getSystemFileName() + " is already in use by another application.");
			e.printStackTrace();
		}
	  }
	
    
  @DataProvider(name = "SurveyDS")
  public static Object[][] dataProvider1() throws Exception {
	System.out.println("Inside data provider");
	Object[][] testData = getTableArray(getTestDataFile(),getSurveySheetName(),16,8);
    return(testData);
  }
 
  @DataProvider(name = "ProcessDS")
  public static Object[][] dataProvider2() throws Exception {
        Object[][] retObjArr = getTableArray(getTestDataFile(),getProcessSheetName(),10,18);
      return(retObjArr);
  }
  
  @DataProvider(name = "ModuleDS")
  public static Object[][] dataProvider3() throws Exception {
        System.out.println("Inside data provider");
        Object[][] testData = getTableArray(getTestDataFile(),getModuleSheetName(),10,2);
    return(testData);
  }
/*
  @DataProvider(name = "ProcessRegressionDS")
  public static Object[][] dataProvider3() throws Exception {
      Object[][] retObjArr = getExcelData(getTestDataFile(),getExcelSheetName(),getPrRegrnStartTC().trim());
      return(retObjArr);
  }
*/  
  public static Object[][] getTableArray(String FilePath, String SheetName, int rowCount, int colCount) throws Exception {  
          String[][] tabArray = null;
          try {
                  FileInputStream ExcelFile = new FileInputStream(FilePath);
                  //Access the required test data sheet
                  ExcelWBook = new HSSFWorkbook(ExcelFile);
                  ExcelWSheet = ExcelWBook.getSheet(SheetName);
                  int startRow = 1;
                  int startCol = 1;
                  int ci,cj;
                  //int totalRows = ExcelWSheet.getLastRowNum();
                  int totalRows = rowCount;
                  int totalCols = colCount;
                  tabArray=new String[totalRows][totalCols];
                  ci=0;
                  for (int i=startRow;i<=totalRows;i++, ci++) {             
                          cj=0;
                          for (int j=startCol;j<=totalCols;j++, cj++){
                                  tabArray[ci][cj]=getCellData(i,j);
                                  //System.out.println("Data: " + tabArray[ci][cj]);
                          }
                  }
          }catch (FileNotFoundException e){
                  System.out.println("Could not read the Excel sheet");
                  e.printStackTrace();
          }catch (IOException e){
                  System.out.println("Could not read the Excel sheet");
                  e.printStackTrace();
          }
          return(tabArray);

  }
  
  public static String getCellData(int RowNum, int ColNum) throws Exception {
          try{
                  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                 // Cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                  String CellData = Cell.getStringCellValue();
                  return CellData;
          }catch (Exception e){
                  System.out.println(e.getMessage());
                  throw (e);
          }
  }          


  
  /*
  // jxl implementation
  public static String[][] getExcelData(String filePath, String sheetName, String tableName) throws Exception{
      String[][] tabArray=null;
      Workbook workbook = Workbook.getWorkbook(new FileInputStream(filePath));
      Sheet sheet = workbook.getSheet(sheetName); 
      int startRow,startCol, endRow, endCol,ci,cj;
      Cell tableStart=sheet.findCell(tableName);
      System.out.println("Start pointer is " + tableName);
      System.out.println("Table start is " + tableStart);
      startRow=tableStart.getRow();
      startCol=tableStart.getColumn();
      Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                
      endRow=tableEnd.getRow();
      endCol=tableEnd.getColumn();
      System.out.println("startRow="+startRow+", endRow="+endRow+", " +
      "startCol="+startCol+", endCol="+endCol);
      tabArray=new String[endRow-startRow-1][endCol-startCol-1];
      ci=0;

      for (int i=startRow+1;i<endRow;i++,ci++){
         cj=0;
         for (int j=startCol+1;j<endCol;j++,cj++){
            tabArray[ci][cj]=sheet.getCell(j,i).getContents();
              }
          }
      return(tabArray);
  }
  */
  
}