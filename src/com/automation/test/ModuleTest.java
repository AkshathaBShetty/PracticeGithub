package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Login;
import com.automation.platform.Module;
import com.automation.platform.Module.chaptercreationtype;
import com.automation.platform.Module.moduletype;
import com.automation.platform.Talk;

public class ModuleTest {
	
	 static Logger log = Logger.getLogger(TalkTestOwner.class);
     TestDataInput launch = new TestDataInput();
     Utilities util=new Utilities();
     
//	public  String[] files={launch.getDocFile(),launch.getPdfFile(),
//			launch.getAviFile(),launch.getMp3File(),launch.getMp4File(),launch.getXlsFile(),launch.getPptFile(),launch.getPngFile(),launch.getJpgFile(),};
     
     
     @BeforeClass
     public void setUp() throws Exception{
         DOMConfigurator.configure("log4j.xml");
         launch.setSystemFileName("tuto.properties");    
         launch.loadProperties();
         util.initDriver();
         Login login = new Login(driver);
         login.login("PRODUCER");
         
     }
     
    
 	
     
   //  @Test(priority=1)
     public void CreateChapterWithoutQuiz() throws InterruptedException, IOException{ 
         
         Module chapter = new Module(driver);
         chapter.createChapter("chapter",chaptercreationtype.ADDNEW,true,launch.getJpgFile());
       
        }
     
     
     @Test(priority=2)
     public void CreateModuleWithChaptersFromComputer() throws InterruptedException, IOException{ 
         
    	 String[] files={launch.getDocFile(),launch.getMp3File(),launch.getMp4File(),launch.getPptFile(),launch.getJpgFile()};
    	     
    	     
         Module chapter = new Module(driver); 
        
         for(int i=0;i<files.length;i++)
        	 System.out.println("file="+files[i]);
         chapter.createModule("module",moduletype.BEGINNER,"COMPUTER",files);
       
        }
     
     

}
