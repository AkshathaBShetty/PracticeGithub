package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Login;
import com.automation.platform.Talk;

public class TalkTestAssignee {
	
	static Logger log = Logger.getLogger(TalkTestOwner.class);
    TestDataInput launch = new TestDataInput();
    Utilities util=new Utilities();
    
    @BeforeClass
    public void setUp() throws Exception{
        DOMConfigurator.configure("log4j.xml");
        launch.setSystemFileName("tuto.properties");    
        launch.loadProperties();
        util.initDriver();
        Login login = new Login(driver);
        login.login("USER0");
        
    }
    
   
    
    
    @Test(priority=1)
    public void commentAsAssigneeOnPublicTalkTest() throws InterruptedException, IOException{ 
      
        Talk talk = new Talk(driver);
        String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
        talk.commentOnTalk(talkid,"commented on public talk as assignee");
       
     
       } 
    
    
   @Test(priority=2)
    public void contestAsAssigneeOnPublicTalkTest() throws InterruptedException, IOException{ 
      
        Talk talk = new Talk(driver);
        String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
        talk.contestTalk(talkid);
       
      
       } 
   
   @Test(priority=3)
   public void followPublicTalkTest() throws InterruptedException, IOException{ 
     
       Talk talk = new Talk(driver);
       String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
       talk.followTalk(talkid);
      
     
      } 
   
   @Test(priority=4)
   public void reportPublicTalkTest() throws InterruptedException, IOException{ 
     
       Talk talk = new Talk(driver);
       String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
       talk.reportTalk(talkid);
      
     
      } 
   
   
   @Test(priority=5)
   public void commentAsAssigneeOnPrivateTalkTest() throws InterruptedException, IOException{ 
     
       Talk talk = new Talk(driver);
       String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
       talk.commentOnTalk(talkid,"commented on private talk as assignee");
      
    
      } 

}
