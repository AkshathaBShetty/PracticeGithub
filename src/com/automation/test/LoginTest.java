package com.automation.test;

import static com.automation.common.Utilities.driver;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.platform.Login;
import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import static com.automation.common.TestDataInput.successMsg;
import static com.automation.common.TestDataInput.errorMsg;

public class LoginTest {
        static Logger log = Logger.getLogger(LoginTest.class);
        Utilities util = new Utilities();
        TestDataInput launch = new TestDataInput();
        String invalidEmail = "abc@xyzw.com";
        public static String validEmail = "swetha@wooqer.com";
        String forgotPwdInvalidUsrMsg = "We don't recognise this Username.";
        String forgotPwdValidUsrMsg = "An email has been sent to your id allowing you to change your password.";
        
        @BeforeClass
        public void setUp() throws Exception{
                DOMConfigurator.configure("log4j.xml");
                launch.setSystemFileName("tuto.properties");    
                launch.loadProperties();
                util.initDriver();
            }
        
 // @Test(priority=1)
        public void verifyLogin(){ 
           try{    
                  Login login = new Login(driver);                  
                  /*try{
                        login.validateLogin("INVALID", errorMsg);
                        log.info("Test Case 2 InvalidCredentials: Passed");
                  }catch(Exception e){
                        log.error("Test Case 2 InvalidCredentials: Failed");  
                  }*/
                  try{
                        login.validateLogin("NOUSER", errorMsg);
                        log.info("Test Case 3 NonExistingUserLogin: Passed");
                  }catch(Exception e){
                        log.error("Test Case 3 NonExistingUserLogin: Failed");  
                  }                                   
                 /* try{
                        login.validateLogin("PRODUCER", successMsg);
                        log.info("Test Case 4 ValidLogin: Passed");
                        login.logout();
                  }catch(Exception e){
                        log.error("Test Case 4 ValidLogin: Failed");  
                  }*/
                  
                  Utilities.quitDriver();                 
           }catch(Exception exp){
                  exp.printStackTrace();
           }
        }

        
      @Test(priority=2)
        public void verifyForgotPassword(){               
           try{
                  util.initDriver();
                  Login login = new Login(driver);
                  try{
                      login.forgotPassword(invalidEmail, forgotPwdInvalidUsrMsg,false);
                      log.info("Test Case 5 ForgotPassword Invalid User: Passed");
                }catch(Exception e){
                        log.error("Test Case 5 ForgotPassword Invalid User: Failed");  
                }
                  try{
                      login.forgotPassword(validEmail, forgotPwdValidUsrMsg,true);
                      log.info("Test Case 6 ForgotPassword Valid User: Passed");
                }catch(Exception e){
                      log.error("Test Case 6 ForgotPassword Valid User: Failed");  
                }
                  
                 
           }catch(Exception exp){
                  exp.printStackTrace();       
           }          
        }
        
        
       
        
        
        @AfterClass
        public void tearDown() throws Exception{
        }
        
}