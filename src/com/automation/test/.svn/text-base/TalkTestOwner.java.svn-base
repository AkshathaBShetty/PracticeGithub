package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Login;
import com.automation.platform.Talk;
import com.automation.platform.Talk.assigntype;

import static com.automation.common.TestDataInput.successMsg;
import static com.automation.common.TestDataInput.errorMsg;

public class TalkTestOwner {
        static Logger log = Logger.getLogger(TalkTestOwner.class);
        TestDataInput launch = new TestDataInput();
        Utilities util=new Utilities();
        
        String msgtext="Talk";
        String commenttext="comment on public talk";
        String user="Anuja Swetha";
        String role="Lead";
        String store="Adidas Ahmedabad";
        String city="Bengaluru";
        String resource="chinnu resource";
        String team="Team Team";
        
        
        
        @BeforeClass
        public void setUp() throws Exception{
            DOMConfigurator.configure("log4j.xml");
            launch.setSystemFileName("tuto.properties");    
            launch.loadProperties();
            util.initDriver();
            Login login = new Login(driver);
            login.login("PRODUCER");
            
        }

       
        @Test(priority=1)
        public void CreatePublicTalkTest() throws InterruptedException, IOException{ 
            
            Talk talk = new Talk(driver);
            talk.createTalk("Public "+ msgtext,true,false,null);
          
           }
        
        
        @Test(priority=2)
        public void CreateTeamTalkTest() throws InterruptedException, IOException{ 
            
            Talk talk = new Talk(driver);
            talk.createTalk("Team "+msgtext+" ",true,assigntype.TEAM,team,false,null);
          
           }  
        
        
        
        
        
        @Test(priority=3)
        public void commentOnPublicTalkTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
            talk.commentOnTalk(talkid,"commented on public talk");
           
         
           } 
        
        
       @Test(priority=4)
        public void endorsePublicTalkTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
            talk.endorseTalk(talkid);
           
          
           } 
        
        @Test(priority=5)
        public void CreatePublicTalkWithImage() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            
            talk.createTalk("IMAGE "+ msgtext,true,true,launch.getJpgFile());
          
           } 
        
        
        @Test(priority=6)
        public void CreatePrivateTalkToUserTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            talk.createTalk("Private "+msgtext+" to user",true,assigntype.USER,user,false,null);
           
          
           } 
        
        
        @Test(priority=7)
        public void endorsePrivateTalkTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.endorseTalk(talkid);
           
          
           } 
        
        @Test(priority=8)
        public void sharePrivateTalkToUserTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.shareTalk(talkid,assigntype.USER,"Anuja s");
           
          
           } 
        
        
        @Test(priority=8)
        public void sharePrivateTalkToRoleTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.shareTalk(talkid,assigntype.ROLE,role);
           
          
           } 
        
        @Test(priority=9)
        public void sharePrivateTalkToStoreTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.shareTalk(talkid,assigntype.STORE,store);
           
          
           } 
        
        @Test(priority=10)
        public void sharePrivateTalkToCityTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.shareTalk(talkid,assigntype.CITY,city);
           
          
           } 
        
        @Test(priority=11)
        public void sharePrivateTalkToResourceTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.shareTalk(talkid,assigntype.RESOURCE,resource);
           
          
           } 
        
        @Test(priority=12)
        public void unfollowTalkTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","privatetalkid");
            talk.unfollowTalk(talkid);
           
          
           } 
        
       @Test(priority=13)
        public void CreatePrivateTalkToRoleTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            talk.createTalk("Private"+msgtext+"to role",true,assigntype.ROLE,role,true,launch.getJpgFile());
          
           } 

        @Test(priority=14)
        public void CreatePrivateTalkToStoreTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            talk.createTalk("Private"+msgtext+"to store",true,assigntype.STORE,store,true,launch.getDocFile());
          
           } 
        
        @Test(priority=15)
        public void CreatePrivateTalkToCityTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            talk.createTalk("Private"+msgtext+"to city",true,assigntype.CITY,city,true,launch.getMp3File());
          
           } 
        
        
        @Test(priority=16)
        public void CreatePrivateTalkToResourceTest() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            talk.createTalk("Private"+msgtext+"to resource",true,assigntype.RESOURCE,resource,true,launch.getMp4File());
        
           } 
        
        
        
        @Test(priority=17)
        public void CreatePublicTalkWithDoc() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            
            talk.createTalk("DOCUMENT " + msgtext,true,true,launch.getDocFile());
          
           } 
        
        @Test(priority=18)
        public void CreatePublicTalkWithMp3() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            
            talk.createTalk("AUDIO "+ msgtext,true,true,launch.getMp3File());
          
           } 
        
        
        @Test(priority=19)
        public void ConcludePublicTalk() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            String talkid=Utilities.readFromPropertiesFile("output.properties","publictalkid");
            talk.concludeTalk(talkid);
          
           } 
        
        @Test(priority=20)
        public void CreatePublicTalkWithMp4() throws InterruptedException, IOException{ 
          
            Talk talk = new Talk(driver);
            
            talk.createTalk("VIDEO "+msgtext,true,true,launch.getMp4File());
          
           } 
        
        
        
       
        @AfterClass
        public void tearDown() throws Exception{
          //TO DO
        }
        
}
