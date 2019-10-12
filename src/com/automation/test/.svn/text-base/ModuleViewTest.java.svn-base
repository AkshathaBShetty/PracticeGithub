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
import com.automation.platform.Survey;
import com.automation.platform.Module.chaptercreationtype;
import com.automation.platform.Module.moduletype;
import com.automation.platform.Talk;

public class ModuleViewTest {
	
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
     public void ViewModuleFromUserSide() throws InterruptedException, IOException{ 
         
        
         try {
				String modulename=Utilities.readFromPropertiesFile("output.properties", "modulename");
				 Module chapter = new Module(driver);
		         chapter.viewModule(modulename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
      
       
        }

}
