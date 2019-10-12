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
import com.automation.platform.Module;
import com.automation.platform.Module.chaptercreationtype;
import com.automation.platform.Module.moduletype;
import com.automation.platform.Survey;
import com.automation.platform.Talk;

public class SurveyTest {
	
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
         login.login("PRODUCER");
         
     }
     
     
     
 //    @Test(priority=1)
     public void SearchForSurvey() throws InterruptedException, IOException{ 
         
         Survey survey = new Survey(driver);
         survey.searchForSurvey(Survey.surveyname);
       
        }
     
  //   @Test(priority=2)
     public void createSurveyTest() throws InterruptedException, IOException{ 
         
         Survey survey = new Survey(driver);
         survey.createSurvey(null,"SINGLE","COMPLETION%");
       
        }
     
    
     
     @Test(priority=3)
     public void assignSurveyTest() throws InterruptedException, IOException{ 
         
         Survey survey = new Survey(driver);
         survey.assignSurvey("survey190120500016","swetha");
       
        }

}