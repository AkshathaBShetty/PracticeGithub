package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Approval;
import com.automation.platform.Login;

public class ApprovalTestOwner {
	static Logger log=Logger.getLogger(ApprovalTestOwner.class);
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
	
 @Test(priority=1)
		public void HomeApproval() throws IOException, InterruptedException 
		{
			Approval Approval=new Approval(driver);
			Approval.CreateApproval(true,false,null,false,true);
		}
 @Test(priority=0)
		public void HomeApprovalAttachment() throws IOException, InterruptedException 
		{
			Approval Approval=new Approval(driver);
	        Approval.CreateApproval(true,true,set.getJpgFile(),true,false);
		}

  @Test(priority=2)
	public void ToDoApprovalAttachment() throws IOException, InterruptedException  
	   {
		Approval Approval=new Approval(driver);
     Approval.CreateApproval(false,true,set.getJpgFile(),false,true);
	   }
// @Test(priority=3)
	public void TodoApproval() throws IOException, InterruptedException
	{
		Approval Approval=new Approval(driver);
      Approval.CreateApproval(false,false,null,true,false);
	}
	
//   @Test(priority=4)
    public void AssigneeLogin(){
	   Approval Approval=new Approval(driver); 
	   Approval.Creatorlogout();
	   Login login = new Login(driver);
	   login.login("USER2");
       }
   
// @Test(priority=5)
   public void completeApproval() {
	   Approval Approval=new Approval(driver); 
	   Approval.CompleteApproval(false);
	   }
     
//   @Test(priority=6)
  public void OwnerLogin() {
	 Approval Approval=new Approval(driver);
	 Approval.Creatorlogout();
	 Login login = new Login(driver);
	   login.login("PRODUCER");
	 Approval.OwnerValidation();
	   
 }
 
 
 
}
	

