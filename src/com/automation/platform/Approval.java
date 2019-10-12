package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.common.Utilities;
import static com.automation.common.Utilities.waitForElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class Approval {
Logger log=Logger.getLogger(Approval.class);
Login login = new Login(driver);
String HomePageApproval="Sunday"+ Utilities.getCurrentTimeStamp();
char[] Autouser= {'A','k','s','h','a','t','h','a',' ','S','h','e'};
static String RequiredId;




 @FindBy(xpath="//div[@id='home-icon']")
 WebElement HomeIcon;
 @FindBy(id="close-flash-popup")
 WebElement FlashPlayer;
 @FindBy(xpath="/html[1]/body[1]/div[18]/div[2]/div[4]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]")
 WebElement PlusIcon;
 //@FindBy(xpath="/html[1]/body[1]/div[18]/div[1]/div[8]/div[2]/div[1]/div[7]")
 @FindBy(css="div#h_todo")
 WebElement ToDoIcon;
 @FindBy(id="plusIconContainer")
 WebElement Create;
 @FindBy(css="#new-appr")
 WebElement NewApproval;
 @FindBy(css="input[placeholder='Approval name']")
 WebElement ApprovalName;
 @FindBy(css="textarea[placeholder='Details of the Approval. Attach files if needed.']")
 WebElement ApprovalDescription;
 @FindBy(css="#createApprovalForm > div > div:nth-child(3) > div.header-input-rp-wrap > label")
 WebElement UploadFile;
 @FindBy(id="search-name-popup-approval")
 WebElement SelectApprover;
 @FindBy(xpath="//div[text()='Ashu ']")
 WebElement Fav;
 @FindBy(id="search-res-text-approval")
 WebElement Autosug;
 @FindBy(css="div[class='create-approval-button']")
 WebElement SaveApproval;
 @FindBy(id="rpwo-sec")
 WebElement Pendinglist;
 @FindBy(xpath="html[1]/body[1]/div[3]/div[20]/div[4]/div[7]/div[3]/div[1]/div[1]/div[2]")
 WebElement Approvalclick;
 @FindBy(xpath="//div[@class='jq-toast-single jq-has-icon jq-icon-success']")
 WebElement Successmessage;
 @FindBy(xpath="//div[text()='APPROVAL']")
 WebElement Clickonapproval;
 @FindBy(xpath="//textarea[@placeholder='Enter your comments here']")
 WebElement ToDocomment;
 @FindBy(xpath="//button[text()='Comment']")
 WebElement Clickcomment;
 @FindBy(css="img.user-icon")
 WebElement Profile;
 @FindBy(id="h_profile_logout")
 WebElement Signout;
 @FindBy(id="dropdownSelectedArea")
 WebElement TodoFilter;
 @FindBy(id="sort-type")
 WebElement Type;
 @FindBy(xpath="//div[text()='Approval']")
 WebElement SelectApproval;
 @FindBy(xpath="//div[@class='tiles-todo-wrap clearfix approval approval-today']")
 WebElement ClickApproval;
 @FindBy(xpath="//button[text()='Approve']")
 WebElement Approve;
 @FindBy(xpath="//div[text()='Reject']")
 WebElement Reject;
 @FindBy(xpath="//textarea[@placeholder='Leave a comment']")
 WebElement Withcomment;
 @FindBy(xpath="//button[text()='Done']")
 WebElement Done;
 @FindBy(id="filled-sec")
 WebElement Filled;
 @FindBy(css="div.task-completed-text")
 WebElement CompletedText;
 WebDriverWait d=new WebDriverWait(driver,100);
 
 
  
 public Approval(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this); 
	 }
 
 @SuppressWarnings("unchecked")
public WebDriver CreateApproval(Boolean isHome,Boolean isAttachmentPresent,String filepath,Boolean isfavpresent,Boolean iscommentrequired ) throws IOException, InterruptedException {
	 Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		prop.load(fis);
	 if(isHome) 
	     {
	    // try {
		      pauseForTime(8000);
		      if(waitForElement(HomeIcon,60).isDisplayed()) {
			  HomeIcon.click();
			 }
		 /*}
	    catch(NoSuchElementException ex) m mm m
	         {
		      log.error("HomeIcon is not found on the page"); 
	         }*/
	     try {
		      pauseForTime(5000);
		      if(waitForElement(FlashPlayer,80).isDisplayed())
		     {
			  waitForElement(FlashPlayer,80).click();
			 }
		 }
	    catch(NoSuchElementException ex) 
	         {
		      log.error("FlashPlayer close button is not found on the page"); 
	         }
	     try {
		      if(waitForElement(PlusIcon,60).isDisplayed()) {
			  waitForElement(PlusIcon,60).click();
			 }
		 }
	    catch(NoSuchElementException ex)
	        {
		     log.error("PlusIcon is not found on Home page"); 
	        }
	     }
 else
	   { 
	 pauseForTime(5000);
		d.until(ExpectedConditions.visibilityOf(ToDoIcon));
		
			pauseForTime(5000);
			 if(waitForElement(ToDoIcon,60).isDisplayed()) {
				 waitForElement(ToDoIcon,60).click();
				 }
		
			 
		 
//		 catch(NoSuchElementException ex){
//			 log.error("ToDoIcon Icon is not found in Home page "); 
//	 }
		 try {
			 pauseForTime(3000);
			 if(waitForElement(Create,60).isDisplayed()) {
				 waitForElement(Create,60).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("Create button is not found in Home page "); 
		    }
		 }
	 try {
		 if(waitForElement(NewApproval,60).isDisplayed()) {
			 waitForElement(NewApproval,60).click();
	        }
		 }
	  catch(NoSuchElementException ex){
		 log.error("NewApproval option is not found in Home page "); 
	     }
	 try {
		 if(waitForElement(ApprovalName,60).isDisplayed()) {
			 ApprovalName.clear();
             waitForElement(ApprovalName,60).sendKeys(HomePageApproval);
			 }
		 }
	 
	 catch(NoSuchElementException ex){
		 log.error("ApprovalName text box is not found in NewApproval Page "); 
	 }
	 try {
		 if(waitForElement(ApprovalDescription,60).isDisplayed()) {
			 ApprovalDescription.clear();
             waitForElement(ApprovalDescription,60).sendKeys(prop.getProperty("ApprovalDes") + Utilities.getCurrentTimeStamp());
			 }
		 }
	 
	 catch(NoSuchElementException ex){
		 log.error("ApprovalDescription text box is not found in NewApproval Page "); 
	    }
if(isAttachmentPresent) {
	try {
		 if(waitForElement(UploadFile,60).isDisplayed()) {
			 UploadFile.click();
			 pauseForTime(3000);
			 Runtime.getRuntime().exec("C:\\Users\\wooqer\\Desktop\\AutoiT\\Fileupload1.exe");
			 log.info("Attachment is added");
             }
		 }
	  catch(NoSuchElementException ex){
		 log.error("UploadFile icon  is not found in NewApproval Page "); 
		 }
	    }
	  try {
		 if(waitForElement(SelectApprover,60).isDisplayed()) {
			 SelectApprover.click();
             }
		 }
	 catch(NoSuchElementException ex){
		 log.error("SelectApprover text box is not found in NewApproval Page "); 
	    }
 
 if(isfavpresent) {
	   try {
		 if(waitForElement(Fav,60).isDisplayed()) {
			 Fav.click();
             }
		 }
	 catch(Exception ex){
		 log.error("User doesn't exist in Fav list of NewApproval Page "); 
		 }
	   }
else
	   {
		 try {
			 for(int i=0;i<Autouser.length;i++)
			 {	SelectApprover.sendKeys(String.valueOf(Autouser[i]));
			    pauseForTime(1000);
			 }
			 d.until(ExpectedConditions.visibilityOf(Autosug));
			 if(waitForElement(Autosug,60).isDisplayed()) {
				 pauseForTime(3000);
				 waitForElement(Autosug,60).click();
				  }
			 }
		 catch(NoSuchElementException ex) {
			 log.error("Autosug user is not found in the page");
		      }
		 }
	 try {
		 if(waitForElement(SaveApproval,30).isDisplayed()) {
			 SaveApproval.click();
           }
		 }
	  catch(NoSuchElementException ex){
		 log.error("SaveApproval button is not found in NewApproval Page "); 
	    }
	 
	try {
		 if(waitForElement(Successmessage,60).isDisplayed()) {
			 String a=Successmessage.getText();
			 if(a.contains(HomePageApproval)){
			 log.info("Approval is created successfully");
			 }
		   }
		 }
	  catch(NoSuchElementException ex){
		 log.error("Approval is not created"); 
	    }
if(iscommentrequired) {
	d.until(ExpectedConditions.visibilityOf(ToDoIcon));
		  try {
			  pauseForTime(5000);
				 if(waitForElement(ToDoIcon,60).isDisplayed()){
					 ToDoIcon.click();
					 }
			}
	        catch(NoSuchElementException ex) {
					 log.error("ToDoIcon is not found");
				 }
		try {
			pauseForTime(4000);
			 if(waitForElement(Pendinglist,60).isDisplayed()){
				Pendinglist.click();
				 }
		}
        catch(NoSuchElementException ex) {
				 log.error("pending list is not found");
			 }
		}
		 try
		 {
		    d.until(ExpectedConditions.visibilityOf(Clickonapproval));
			if( waitForElement(Clickonapproval,60).isDisplayed()) {
		    waitForElement(Clickonapproval,60).click();
			log.info("Required approval is clicked");
		  }
	   }
		     catch(NoSuchElementException ex) {
			     log.error("Approval is not found");
			     }
		      
	  try
		 {  pauseForTime(4000);
		    if( waitForElement(ToDocomment,60).isDisplayed()) {
		    	String ApprovalID = ToDocomment.getAttribute("id");
	    	 RequiredId=ApprovalID.substring(21);
		    	 log.info(RequiredId);
		    waitForElement(ToDocomment,60).sendKeys(prop.getProperty("Owner") + Utilities.getCurrentTimeStamp());
		    }
	     }
		     catch(NoSuchElementException ex) {
			     log.error("ToDocomment text box is not found");
			     }
	 try
		 {
		    if( waitForElement(Clickcomment,60).isDisplayed()) {
		    waitForElement(Clickcomment,60).click();
		    log.info("Commented on approval successfully");
		    }
	     }
		     catch(NoSuchElementException ex) {
			     log.error("Comment button is not found");
			     }
	     return driver;
	     }
 public WebDriver Creatorlogout(){
	 try {
		 pauseForTime(4000);
		 if(waitForElement(Profile,60).isDisplayed()) {
		    waitForElement(Profile,60).click();
		    }}
		 catch(NoSuchElementException ex) {
			 log.error("Profile button is not found");
		   }
	  try {
		 if(waitForElement(Signout,60).isDisplayed()) {
		    waitForElement(Signout,60).click();
		    }}
		 catch(NoSuchElementException ex) {
			 log.error("Signout button is not found");
		   }
		return driver;
      }
 
 
 public WebDriver CompleteApproval(Boolean isapprove) {
	 try {
		 if(waitForElement(FlashPlayer,60).isDisplayed()) {
		    waitForElement(FlashPlayer,60).click();
		    }}
		 catch(NoSuchElementException ex) {
			 log.error("FlashPlayer button is not found");
		   }
	 
	 try {
		 d.until(ExpectedConditions.visibilityOf(ToDoIcon));
		 if(waitForElement(ToDoIcon,60).isDisplayed()) {
		    waitForElement(ToDoIcon,60).click();																																									
		    }}
		 catch(Exception e) {
			 log.error("ToDoIcon button is not found");
		   }
	 try {
		 d.until(ExpectedConditions.visibilityOf(TodoFilter));
		 if(waitForElement(TodoFilter,60).isDisplayed()) {
		    waitForElement(TodoFilter,60).click();
		    }}
		 catch(Exception e) {
			 log.error("TodoFilter button is not found");
		   }
	 try {
		 if(waitForElement(Type,60).isDisplayed()) {
		    waitForElement(Type,60).click();
		    }
		   }
		 catch(Exception e) {
			 log.error("Type filter is not found");
		 }
	
	 try {
		 pauseForTime(4000);
			 driver.findElement(By.id("APPROVAL-TODAY-"+RequiredId)).click();
			 log.info("latest approval is identified");
		   }
			  
     catch(NoSuchElementException ex)
	    {
		 log.error("unable to find the required approval");
	    }
if(isapprove) {
	 try {
		 pauseForTime(3000);
		 if(waitForElement(Approve,60).isDisplayed()) {
		    waitForElement(Approve,60).click();
		    }
		   }
		 catch(Exception e) {
			 log.error("Approve button is not found");
		 }
	 try {
		 if(waitForElement(Withcomment,60).isDisplayed()) {
		    waitForElement(Withcomment,60).sendKeys("Approved");
		    }
		   }
		 catch(Exception e) {
			 log.error("comment textarea is not found");
		 }
	 try {
		 if(waitForElement(Done,60).isDisplayed()) {
		    waitForElement(Done,60).click();
		    log.info("Approval is approved");
		    }
		   }
		 catch(Exception e) {
			 log.error("Done button is not found");
		 }
	   }
else {
	  try {
			 pauseForTime(3000);
			 if(waitForElement(Reject,60).isDisplayed()) {
			    waitForElement(Reject,60).click();
			    }
			   }
			 catch(Exception e) {
				 log.error("Reject button is not found");
			 }
		 try {
			 if(waitForElement(Done,60).isDisplayed()) {
			    waitForElement(Done,60).click();
			    log.info("Approval is rejected without comment");
			    }
			   }
			 catch(Exception e) {
				 log.error("Done button is not found");
			 }
           } return driver;
		 } 
 
 public WebDriver OwnerValidation() {
		 try {
			 if(waitForElement(ToDoIcon,60).isDisplayed()) {        
			    waitForElement(ToDoIcon,60).click();
			    log.info(RequiredId);
			 }
		 }
	   catch(Exception e) {
				 log.error("ToDoIcon button is not found");
			 }
	 try {
		 pauseForTime(4000);
			 if(waitForElement(Filled,60).isDisplayed()) {      
			    waitForElement(Filled,60).click();
			 }
		 }
	   catch(Exception e) {
				 log.error("Filled is not found");
			 }
	   
	 try {
		 pauseForTime(8000);
			 driver.findElement(By.id("APPROVAL-FILLED-"+RequiredId)).click();    
		   }
			  
     catch(NoSuchElementException ex)
	    {
		 log.error("unable to find the required approval");
	    }
	 
	 try {
		 if(waitForElement(CompletedText,60).isDisplayed()) {      
		   String Text = CompletedText.getText();
		   log.info(Text);
		   if(Text.equalsIgnoreCase("Approved by ")) {
			   log.info("Approved by the approver");
		   }else if(Text.equalsIgnoreCase("Rejected by")) {
			   log.info("Rejected by the approver");
		   }
		   
		 }	   
		
	 }
   catch(Exception e) {
			 log.error("Owner is not able to find the required approver");
		 }
	 
	 
	return driver;
  
}
}


