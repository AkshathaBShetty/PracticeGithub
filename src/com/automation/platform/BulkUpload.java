	package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import com.automation.common.Utilities;

public class BulkUpload {
	
	
	
	int i;
	Logger log=Logger.getLogger(BulkUpload.class);
	Login login = new Login(driver);
	@FindBy(id="switchPiTabLink")
	WebElement ManagePI;
	@FindBy(xpath="//a[@title='Create Bulk Users']")
	WebElement Createbulk;
	@FindBy(xpath="//a[text()='  New users']")
	WebElement Newusers;
	@FindBy(xpath="//a[@id='chooseFile']")
	WebElement choosefile;
	@FindBy(id="uploadExcel")
	WebElement Submit;
	@FindBy(id="errorMessage")
	WebElement resultmsg;
	@FindBy(xpath="//a[text()='Units']")
	WebElement Store;
	@FindBy(xpath="//a[@title='Create Bulk  Unit']")
	WebElement Bulkstore;
	@FindBy(xpath="//a[text()='  New Units']")
	WebElement Download;
	@FindBy(xpath="//a[text()='Roles']")
	WebElement Roles;
	@FindBy(xpath="//a[@title='Create Bulk Roles']")
	WebElement BulkRole;
	@FindBy(xpath="//a[text()='  New roles']")
	WebElement DownloadRole;
	@FindBy(xpath="//img[@titl")
	WebDriverWait d=new WebDriverWait(driver,100);
	
	
	
	public BulkUpload(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	 }
	
		
	
	@SuppressWarnings("deprecation")
	public WebDriver BulkUserCreation(Boolean isBulkUser,int numberofUsers,Boolean isloginemail,Boolean isloginMobile,Boolean isWooqStore,Boolean isWooqRole,Boolean isManagerloginid,Boolean isActive,Boolean isContent,Boolean isViewReport,Boolean isHrView,Boolean ismsgInbox,Boolean ismediaMngmt,Boolean isusermngmt,Boolean isAdmin) throws IOException {
		 Properties prop=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		prop.load(fi);
			if(isBulkUser) {
				   try {
						 if(waitForElement(ManagePI,60).isDisplayed()) {
							 ManagePI.click();
					  }}
				  catch(Exception ex) {
						log.error("ManagePI tab is not found");
					}
				   try {
						 if(waitForElement(Createbulk,60).isDisplayed()) {
							 Createbulk.click();
					  }
						 }
				  catch(Exception ex) {
						log.error("Createbulk option is not found");
					}
			    pauseForTime(3000);
			  try {
					 if(waitForElement(Newusers,60).isDisplayed()) {
						 Newusers.click();
				  }
					 }
			  catch(Exception ex) {
					log.error("Newusers button is not found");
				}
			  File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
				String fileName = getLatestFile.getName();
				System.out.println(fileName);
			   pauseForTime(5000);
			   FileInputStream fis=new FileInputStream(prop.getProperty("downloadPath")+fileName);
			   XSSFWorkbook XWB=new XSSFWorkbook(fis);
			   XSSFSheet sheet=XWB.getSheetAt(0);
			   for(i=2;i<numberofUsers;i++) {
			        	sheet.createRow(i);
			        	Iterator<Row>row=sheet.iterator();
			    			Row row0=row.next();
			    			Iterator<Cell> cell=row0.cellIterator();
			                Cell cell0=cell.next();
			                
			    			if(cell0.getStringCellValue().equalsIgnoreCase("fname")) {
			    				sheet.getRow(i).createCell(0).setCellValue(prop.getProperty("UFN"));
			    			
			    			}
			    			
			    			Cell cell1=cell.next();
			    			if(cell1.getStringCellValue().equalsIgnoreCase("lname")) {
			    				sheet.getRow(i).createCell(1).setCellValue(prop.getProperty("ULN")+i);
			    				
			    			}
			    			Cell cell2=cell.next();
			    			DataFormatter df = new DataFormatter();
			    			String value = df.formatCellValue(cell2);
			    			if(value.equalsIgnoreCase("loginType")) {
		     if(isloginemail) {
			    				sheet.getRow(i).createCell(2).setCellValue("1");
			    }else {
			    					sheet.getRow(i).createCell(2).setCellValue("2");
			    				}
			    				}
			    			Cell cell3=cell.next();
			    			if(cell3.getStringCellValue().equalsIgnoreCase("employeeId")) {
			    				sheet.getRow(i).createCell(3).setCellValue("");
			    			}
			    			
		   
			    			Cell cell4=cell.next();
			 if(isloginemail) {
			    			if(cell4.getStringCellValue().equalsIgnoreCase("email")) {
			    				sheet.getRow(i).createCell(4).setCellValue(Utilities.getCurrentTimeStamp()+prop.getProperty("Email"));
			    			}}
		   
			    			Cell cell5=cell.next();
			 if(isloginMobile) {
			    			DataFormatter df1 = new DataFormatter();
			    			String value1 = df1.formatCellValue(cell5);
                            if(value1.equalsIgnoreCase("countryCode")) {
                            	sheet.getRow(i).createCell(5).setCellValue("91");
			    			}
			    				}
			    				
			    			Cell cell6=cell.next();
			  if(isloginMobile) {
			    			DataFormatter df2 = new DataFormatter();
			    			String value2 = df2.formatCellValue(cell6);
			    			if(value2.equalsIgnoreCase("mobile")){
		                     sheet.getRow(i).createCell(6).setCellValue("9786767"+i+"87");
			    			}
			    			}
			    			Cell cell7=cell.next();
			    			DataFormatter df3 = new DataFormatter();
			    			String value3 = df3.formatCellValue(cell7);
			    			if(value3.equalsIgnoreCase("storeCode")) {
			    				sheet.getRow(i).createCell(7).setCellValue("");
			    			}
			    			Cell cell8=cell.next();
			  if(isWooqStore) {
			    			DataFormatter df4= new DataFormatter();
			    			String value4 = df4.formatCellValue(cell8);
			    			if(value4.equalsIgnoreCase("wooqStoreId")) {
			    				sheet.getRow(i).createCell(8).setCellValue(prop.getProperty("WSId1"));
			    			}
			         }else {
			    				DataFormatter df4= new DataFormatter();
				    			String value4 = df4.formatCellValue(cell8);
				    			if(value4.equalsIgnoreCase("wooqStoreId")) {
				    				sheet.getRow(i).createCell(8).setCellValue(prop.getProperty("WSId2"));
			    			}
			            }
			    			Cell cell9=cell.next();
			    			if(cell9.getStringCellValue().equalsIgnoreCase("roleCode")) {
			    				sheet.getRow(i).createCell(9).setCellValue("");
			    			}
			    			Cell cell10=cell.next();
			 if(isWooqRole) {
			    			DataFormatter df5= new DataFormatter();
			    			String value5 = df5.formatCellValue(cell10);
			    			if(value5.equalsIgnoreCase("wooqRoleId")) {
			    				sheet.getRow(i).createCell(10).setCellValue(prop.getProperty("WRId1"));
			    			}
			    }else {
			    				DataFormatter df5= new DataFormatter();
				    			String value5 = df5.formatCellValue(cell10);
				    			if(value5.equalsIgnoreCase("wooqRoleId")) {
				    				sheet.getRow(i).createCell(10).setCellValue(prop.getProperty("WRId2"));
				    			}
			    	    }
			    			Cell cell11=cell.next();
			  if(isManagerloginid) {
			    			if(cell11.getStringCellValue().equalsIgnoreCase("managerLoginId")) {
			    				sheet.getRow(i).createCell(11).setCellValue(prop.getProperty("MLId1"));
			    			}
			    	}else {
			    				if(cell11.getStringCellValue().equalsIgnoreCase("managerLoginId")) {
				    				sheet.getRow(i).createCell(11).setCellValue(prop.getProperty("MLId2"));
			    			   }
			    			}
			    			Cell cell12=cell.next();
			    			if(cell12.getStringCellValue().equalsIgnoreCase("managerWooqUserId")) {
			    				sheet.getRow(i).createCell(12).setCellValue("");
			    			}
			  
			    			Cell cell13=cell.next();
			    			if(cell13.getStringCellValue().equalsIgnoreCase("managerEmployeeId")) {
			    				sheet.getRow(i).createCell(13).setCellValue("");
			                }
			    			Cell cell14=cell.next();
			    			DataFormatter df6= new DataFormatter();
			    			String value6 = df6.formatCellValue(cell14);
			    			if(value6.equalsIgnoreCase("level")) {
			    				sheet.getRow(i).createCell(14).setCellValue("2");
			               }
			    			Cell cell15=cell.next();
			  if(isActive) {
			    			DataFormatter df7= new DataFormatter();
			    			String value7 = df7.formatCellValue(cell15);
			    			if(value7.equalsIgnoreCase("active")) {
			    				sheet.getRow(i).createCell(15).setCellValue("1");
			               }
			    	 }else {
			    	    	  DataFormatter df7= new DataFormatter();
				    			String value7 = df7.formatCellValue(cell15);
				    			if(value7.equalsIgnoreCase("active")) {
				    				sheet.getRow(i).createCell(15).setCellValue("0");
				    			}
			    	      }
			  
			    			Cell cell16=cell.next();
			    if(isContent) {
			    			DataFormatter df8= new DataFormatter();
			    			String value8 = df8.formatCellValue(cell16);
			    			if(value8.equalsIgnoreCase("createContent")) {
			    				sheet.getRow(i).createCell(16).setCellValue("1");
			               }
			     } else {
			    	 DataFormatter df8= new DataFormatter();
		    			String value8 = df8.formatCellValue(cell16);
		    			if(value8.equalsIgnoreCase("createContent")) {
		    				sheet.getRow(i).createCell(16).setCellValue("0");
		               }
				  
			       }
			    	  Cell cell17=cell.next();
			  if(isViewReport) {
			    			DataFormatter df9= new DataFormatter();
			    			String value9 = df9.formatCellValue(cell17);
			    			if(value9.equalsIgnoreCase("viewReport")) {
			    				sheet.getRow(i).createCell(17).setCellValue("1");
			                 }
			    			}else {
			    				DataFormatter df9= new DataFormatter();
				    			String value9 = df9.formatCellValue(cell17);
				    			if(value9.equalsIgnoreCase("viewReport")) {
				    				sheet.getRow(i).createCell(17).setCellValue("0");
				    			}  
			               }
			    			Cell cell18=cell.next();
			   if(isHrView) {
			    			DataFormatter df10= new DataFormatter();
			    			String value10= df10.formatCellValue(cell18);
			    			if(value10.equalsIgnoreCase("hrView")) {
			    				sheet.getRow(i).createCell(18).setCellValue("1");
			                 }
			    }else {
			    				DataFormatter df10= new DataFormatter();
				    			String value10= df10.formatCellValue(cell18);
				    			if(value10.equalsIgnoreCase("hrView")) {
				    				sheet.getRow(i).createCell(18).setCellValue("0");
				               }
			            	}
			    			Cell cell19=cell.next();
		  if(ismsgInbox) {
			    			DataFormatter df11= new DataFormatter();
			    			String value11= df11.formatCellValue(cell19);
			    			if(value11.equalsIgnoreCase("msgInbox")) {
			    				sheet.getRow(i).createCell(19).setCellValue("1");
			               }
			    }else {
			    				DataFormatter df11= new DataFormatter();
				    			String value11= df11.formatCellValue(cell19);
				    			if(value11.equalsIgnoreCase("msgInbox")) {
				    				sheet.getRow(i).createCell(19).setCellValue("0");
			    				
			    			}
			       }
			    			Cell cell20=cell.next();
			 if(ismediaMngmt) {
			    			DataFormatter df12= new DataFormatter();
			    			String value12= df12.formatCellValue(cell20);
			    			if(value12.equalsIgnoreCase("mediaMngmt")) {
			    				sheet.getRow(i).createCell(20).setCellValue("1");
			               }
			   }else {
			    				DataFormatter df12= new DataFormatter();
				    			String value12= df12.formatCellValue(cell20);
				    			if(value12.equalsIgnoreCase("mediaMngmt")) {
				    				sheet.getRow(i).createCell(20).setCellValue("0");
				               }
			    	}
			    			Cell cell21=cell.next();
		if(isusermngmt) {
			    			DataFormatter df13= new DataFormatter();
			    			String value13= df13.formatCellValue(cell21);
			    			if(value13.equalsIgnoreCase("userMngmt")) {
			    				sheet.getRow(i).createCell(21).setCellValue("1");
			               }
			    }else {
			    				DataFormatter df13= new DataFormatter();
				    			String value13= df13.formatCellValue(cell21);
				    			if(value13.equalsIgnoreCase("userMngmt")) {
				    				sheet.getRow(i).createCell(21).setCellValue("0");
				               }
			    			}
			    			Cell cell22=cell.next();
		if(isAdmin) {
			    			DataFormatter df14= new DataFormatter();
			    			String value14= df14.formatCellValue(cell22);
			    			if(value14.equalsIgnoreCase("admin")) {
			    				sheet.getRow(i).createCell(22).setCellValue("1");
			               }
			  }else {
			    				DataFormatter df14= new DataFormatter();
				    			String value14= df14.formatCellValue(cell22);
				    			if(value14.equalsIgnoreCase("admin")) {
				    				sheet.getRow(i).createCell(22).setCellValue("0");
				               }
			    				
			    			}
			    			Cell cell23=cell.next();
			    			if(cell23.getStringCellValue().equalsIgnoreCase("takeAction")) {
			    				sheet.getRow(i).createCell(23).setCellValue("CREATE");
			               }
                          }
			          	FileOutputStream outputStream = new FileOutputStream(prop.getProperty("downloadPath")+fileName);		
			    			XWB.write(outputStream);  
			    			
			    			d.until(ExpectedConditions.visibilityOf(choosefile));
							 if(waitForElement(choosefile,60).isDisplayed()) {
								 choosefile.click();
								 Screen s=new Screen();
								 Pattern FileInputbox=new Pattern(prop.getProperty("UserElement1"));
								 Pattern FileOpenbox=new Pattern(prop.getProperty("UserElement2"));
								 s.wait(FileInputbox,200);
								 s.type(FileInputbox,prop.getProperty("downloadPath")+fileName);
								 s.click(FileOpenbox);
							 }
			    			
			    			try {
								 if(waitForElement(Submit,60).isDisplayed()) {
									 Submit.click();
							  }}
						  catch(Exception ex) {	
								log.error("Submit button is not found");
							}
			    			try {
								 if(waitForElement(resultmsg,60).isDisplayed()) {
									String UserRefNum =resultmsg.getText();
									log.info(UserRefNum);
							  }}
						  catch(Exception ex) {
								log.error("Submit button is not found");
							}
			    			
		       }
		
			    		return driver;
	    }
	     public WebDriver BulkStoreCreation(int numberofStores,Boolean isZip,Boolean isPhone,Boolean isMobile,Boolean isEmail,Boolean isKeycontact,Boolean islatitude,Boolean islongitude,Boolean isperimeter) throws IOException, FindFailed {
	    	 Properties prop=new Properties();
		     FileInputStream fis=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
			prop.load(fis);
		      try {
			 if(waitForElement(ManagePI,60).isDisplayed()) {
				 ManagePI.click();
		         }}
	             catch(Exception ex) {
			log.error("ManagePI tab is not found");
		         }
	         try {
			 if(waitForElement(Store,60).isDisplayed()) {
				 Store.click();
		         }}
	         catch(Exception ex) {
			  log.error("Store tab is not found");
	         	}
	        try {
			 if(waitForElement(Bulkstore,60).isDisplayed()) {
				 Bulkstore.click();
		        }}
	         catch(Exception ex) {
			log.error("Create bulk store button is not found");
		        }
	        try {
			 if(waitForElement(Download,60).isDisplayed()) {
				 Download.click();
		         }}
	         catch(Exception ex) {
			log.error("Store download option is not found");
		         }
	        File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
			String fileName = getLatestFile.getName();
			System.out.println(fileName);
	       pauseForTime(5000);
	        FileInputStream Sfile=new FileInputStream(prop.getProperty("downloadPath")+fileName);
	        
	        XSSFWorkbook Xwb=new XSSFWorkbook(Sfile);
	        XSSFSheet Sheet=Xwb.getSheetAt(0);
	        Iterator<Row> Row=Sheet.iterator();
	        Row r=Row.next();
	        for(i=1;i<numberofStores;i++) {
	        Sheet.createRow(i);
            Iterator<Cell> Cell= r.cellIterator();
	        Cell C=Cell.next();
	        if(C.getStringCellValue().equalsIgnoreCase("name")) {
				Sheet.getRow(i).createCell(0).setCellValue(prop.getProperty("SN")+i);
			  }
	        Cell C1=Cell.next();
	        if(C1.getStringCellValue().equalsIgnoreCase("addr")) {
				Sheet.getRow(i).createCell(1).setCellValue(prop.getProperty("SAddress")+Utilities.getCurrentTimeStamp());
			  }
	        Cell C2=Cell.next();
	        if(C2.getStringCellValue().equalsIgnoreCase("area")) {
				Sheet.getRow(i).createCell(2).setCellValue(prop.getProperty("Area"));
			  }
	        Cell C3=Cell.next();
	        if(C3.getStringCellValue().equalsIgnoreCase("cityId")) {
				Sheet.getRow(i).createCell(3).setCellValue(prop.getProperty("CityId"));
			  }
	        Cell C4=Cell.next();
	 if(isZip) {
	        if(C4.getStringCellValue().equalsIgnoreCase("zip")) {
				Sheet.getRow(i).createCell(4).setCellValue(prop.getProperty("Zipcode"));
			  }
	        }
	  else {
	        	if(C4.getStringCellValue().equalsIgnoreCase("zip")) {
					Sheet.getRow(i).createCell(4).setCellValue("");
				  }
	        }
	        
	        	
	        Cell C5=Cell.next();
    if(isPhone) {
	        if(C5.getStringCellValue().equalsIgnoreCase("phone")) {
				Sheet.getRow(i).createCell(5).setCellValue("989"+i+"345786");
			  }
	   }else {
	        	if(C5.getStringCellValue().equalsIgnoreCase("phone")) {
					Sheet.getRow(i).createCell(5).setCellValue("");
				  }
	        	}
	        Cell C6=Cell.next();
	        if(C6.getStringCellValue().equalsIgnoreCase("fax")) {
				Sheet.getRow(i).createCell(6).setCellValue("");
			  }
	        Cell C7=Cell.next();
     if(isMobile) {
	        if(C7.getStringCellValue().equalsIgnoreCase("mobile")) {
				Sheet.getRow(i).createCell(7).setCellValue("989"+i+"345786");
			  }
	        }
	 else {
	        if(C7.getStringCellValue().equalsIgnoreCase("mobile")) {
			Sheet.getRow(i).createCell(7).setCellValue("");
			}	
	       }
	        Cell C8=Cell.next();
	  if(isEmail) {
	        if(C8.getStringCellValue().equalsIgnoreCase("email")) {
				Sheet.getRow(i).createCell(8).setCellValue(prop.getProperty("Email"));
			  }
	   }else {
	        	if(C8.getStringCellValue().equalsIgnoreCase("email")) {
					Sheet.getRow(i).createCell(8).setCellValue("");
				  }	
	       }
	        Cell C9=Cell.next();
	    if(isKeycontact) {
	        if(C9.getStringCellValue().equalsIgnoreCase("keyContact")) {
				Sheet.getRow(i).createCell(9).setCellValue(prop.getProperty("Contact"));
			  }
	    }else {
	    	 if(C9.getStringCellValue().equalsIgnoreCase("keyContact")) {
					Sheet.getRow(i).createCell(9).setCellValue("");
				  }
	    }
	        Cell C10=Cell.next();
	        if(C10.getStringCellValue().equalsIgnoreCase("storeCode")) {
				Sheet.getRow(i).createCell(10).setCellValue("");
			  }
	        Cell C11=Cell.next();
	 if(islatitude) {
	        if(C11.getStringCellValue().equalsIgnoreCase("latitude")) {
				Sheet.getRow(i).createCell(11).setCellValue(prop.getProperty("Latitude"));
			  }
	   }else {
	        	if(C11.getStringCellValue().equalsIgnoreCase("latitude")) {
					Sheet.getRow(i).createCell(11).setCellValue("");
				  }
	        }
	        Cell C12=Cell.next();
	   if(islongitude) {
	        if(C12.getStringCellValue().equalsIgnoreCase("longitude")) {
				Sheet.getRow(i).createCell(12).setCellValue(prop.getProperty("Longitude"));
			  }
	   }else {
		   if(C12.getStringCellValue().equalsIgnoreCase("longitude")) {
				Sheet.getRow(i).createCell(12).setCellValue("");
			  } 
	       }
	        Cell C13=Cell.next();
	  if(isperimeter) {
	        if(C13.getStringCellValue().equalsIgnoreCase("perimeter")) {
				Sheet.getRow(i).createCell(13).setCellValue(prop.getProperty("Perimeter"));
			  }
	   }else {
	        	if(C13.getStringCellValue().equalsIgnoreCase("perimeter")) {
					Sheet.getRow(i).createCell(13).setCellValue("");
				  }	
	        }

	        }  
	    	FileOutputStream outputStream = new FileOutputStream(prop.getProperty("downloadPath")+fileName);		
	    	Xwb.write(outputStream);
	    	
	    	
				d.until(ExpectedConditions.visibilityOf(choosefile));
				 if(waitForElement(choosefile,60).isDisplayed()) {
					 choosefile.click();
					 Screen s=new Screen();
					 Pattern FileInputbox=new Pattern(prop.getProperty("ElementPath1"));
					 Pattern FileOpenbox=new Pattern(prop.getProperty("ElementPath2"));
					 s.wait(FileInputbox,200);
					 s.type(FileInputbox,prop.getProperty("downloadPath")+fileName);
					 s.click(FileOpenbox);
				 }
				 
				 try {
					 if(waitForElement(Submit,60).isDisplayed()) {
						 Submit.click();
				  }}
			  catch(Exception ex) {	
					log.error("Submit button is not found");
				}
    			try {
					 if(waitForElement(resultmsg,60).isDisplayed()) {
						String StoreRefNum =resultmsg.getText();
						log.info(StoreRefNum);
				  }}
			  catch(Exception ex) {
					log.error("Submit button is not found");
				}
    			
	        return driver;
	        }
	     
	  public WebDriver RoleBulkupload(int numberofRoles) throws IOException, SikuliException {
		    Properties prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		    prop.load(fis);
		  
		  try {
				 if(waitForElement(ManagePI,60).isDisplayed()) {
					 ManagePI.click();
			         }}
		  catch(Exception ex) {
				log.error("ManagePI tab is not found");
			         } 
		  try {
				 if(waitForElement(Roles,60).isDisplayed()) {
					 Roles.click();
			         }}
		 catch(Exception ex) {
				log.error("Role button is not found");
			         } 
		  try {
				 if(waitForElement(BulkRole,60).isDisplayed()) {
					 BulkRole.click();
			         }}
		   catch(Exception ex) {
				log.error("BulkRole creation button is not found");
			         } 
		  try {
				 if(waitForElement(DownloadRole,60).isDisplayed()) {
					 DownloadRole.click();
			         }}
		   catch(Exception ex) {
				log.error("Download new role option is not found");
			         } 
		  File getLatestFile = getLatestFilefromDir(prop.getProperty("downloadPath"));
			String fileName = getLatestFile.getName();
			System.out.println(fileName);
		   pauseForTime(5000);
		    FileInputStream Rfile=new FileInputStream(prop.getProperty("downloadPath")+fileName);
		    XSSFWorkbook XWb=new XSSFWorkbook(Rfile);
		    XSSFSheet RSheet=XWb.getSheetAt(0);
		    Iterator<Row> RR=RSheet.rowIterator();
		    Row R=RR.next();
		    for(i=1;i<numberofRoles;i++ ) {
		    	RSheet.createRow(i);
		    	Iterator<Cell> C=R.cellIterator();
		    	Cell C0=C.next();
		    	if(C0.getStringCellValue().equalsIgnoreCase("name")) {
					RSheet.getRow(i).createCell(0).setCellValue(prop.getProperty("RName")+i);
				  }
		    	Cell C1=C.next();
		    	if(C1.getStringCellValue().equalsIgnoreCase("functionId")) {
					RSheet.getRow(i).createCell(1).setCellValue(prop.getProperty("FunctionId"));
				  }
		    }
		    FileOutputStream FOS=new FileOutputStream(prop.getProperty("downloadPath")+fileName);
		    XWb.write(FOS);
		      
		    d.until(ExpectedConditions.visibilityOf(choosefile));
			 if(waitForElement(choosefile,60).isDisplayed()) {
				 choosefile.click();
				 Screen s=new Screen();
				 Pattern FileInputbox=new Pattern(prop.getProperty("RoleElement1"));
				 Pattern FileOpenbox=new Pattern(prop.getProperty("RoleElement2"));
				 s.wait(FileInputbox,200);
				 s.type(FileInputbox,prop.getProperty("downloadPath")+fileName);
				 s.click(FileOpenbox);
			 }
			 
			 try {
				 if(waitForElement(Submit,60).isDisplayed()) {
					 Submit.click();
			  }}
		  catch(Exception ex) {	
				log.error("Submit button is not found");
			}
			 try {
				 if(waitForElement(resultmsg,60).isDisplayed()) {
					String RoleRefNum =resultmsg.getText();
					log.info(RoleRefNum);
			  }}
		  catch(Exception ex) {
				log.error("Submit button is not found");
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
	

