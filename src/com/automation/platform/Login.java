package com.automation.platform;

import com.automation.common.Utilities;

import com.automation.common.TestDataInput;

import static com.automation.common.Utilities.waitForElement;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.driver;
import static com.automation.common.TestDataInput.username;
import static com.automation.common.TestDataInput.password;
import static com.automation.common.TestDataInput.successMsg;
import static com.automation.common.TestDataInput.errorMsg;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {
	public enum AccountType{PRODUCER,USER0,USER1,USER2,USER3,USER4,INVALID,NOUSER};
	static Logger log = Logger.getLogger(Login.class);
	
	// ============ Login page =============
	 @FindBy(how = How.CLASS_NAME, using = "homepageTitle")
	  public static WebElement welcomeText;
	 @FindBy(how = How.CLASS_NAME, using = "homepageLoginTitle")
	  public static WebElement loginSectionHeader;
	 @FindBy(how = How.ID, using = "j_username")
	  public static WebElement useridText;
	 @FindBy(how = How.CLASS_NAME, using = "loginHeader")
	  public static WebElement useridLabel;
	 @FindBy(how = How.ID, using = "j_password")
	  public static WebElement passwordText;
	 @FindBy(how = How.ID, using = "loginSubImg1")
	  public static WebElement loginButton;
	 @FindBy(how = How.ID, using = "forgot-pass")
          public static WebElement forgotPwdLink;
	 @FindBy(how = How.ID, using = "forgotPassword1")
     public static WebElement sendvcode;
	 @FindBy(how = How.ID, using = "loginHelp")
          public static WebElement needHelpLink;
	 @FindBy(how = How.ID, using = "username-for-forgot-pswd")
	  public static WebElement userEmail;
	 @FindBy(how = How.ID, using = "forgotSubImg")
	 public static WebElement forgotSubmitBtn;
	 @FindBy(how = How.ID, using = "forgotPasswordMessage")
	  public  WebElement forgotPwdMsg;
	@FindBy(how = How.ID, using = "user-name-for-display")
	public static WebElement otppageusername;
	 @FindBy(how = How.ID, using = "backToLogin")
	  public static WebElement backBtn;
	 @FindBy(how = How.XPATH, using = "//div[3]/div[2]/a")
          public static WebElement forgotPwdHelpLink;
	 @FindBy(how = How.XPATH, using = "//input[@id='backToLogin']")
          public static WebElement backToLoginPageBtn;
	 @FindBy(how = How.CLASS_NAME, using = "rememberMeDiv")
          public static WebElement signedInChkBox;
	 @FindBy(how = How.CLASS_NAME, using = "loginMessageDiv")
	  public static WebElement loginMsg;
	 @FindBy(how = How.XPATH, using = ".//*[@id='headerPref']/a")
	  public static WebElement preferencesLink;
	 //@FindBy(how = How.ID, using = "profileDropDownTitle")
         @FindBy(how = How.XPATH, using = "//div[@id='profileDropDownTitle']/span")
	  public static WebElement profileDropDown;
	 //@FindBy(how = How.ID, using = "logoutLink")
         @FindBy(how = How.XPATH, using = "//div[@id='logoutLink']/span")
	  public static WebElement logoutLink;

		
        
	 
	 public Login(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	 }	
		  
	
	  
	
	@SuppressWarnings("incomplete-switch")
        public WebDriver login(String user){
	        try{
	            AccountType accType = AccountType.valueOf(user);
	            switch(accType){
	                case PRODUCER:
                    username = TestDataInput.getPrUser();
	                password = TestDataInput.getPrPwd();
	                break;                          
	                case USER0:
	                username = TestDataInput.getUser0();
	                password = TestDataInput.getPwd0();
	                break;
	                case USER1:
	                username = TestDataInput.getUser1();
	                password = TestDataInput.getPwd1();
	                break; 
	                case USER2:
	                username = TestDataInput.getUser2();
	                password = TestDataInput.getPwd2();
	                break; 
	                case USER3:
	                username = TestDataInput.getUser3();
	                password = TestDataInput.getPwd3();
	                break; 
	                case USER4:
	                username = TestDataInput.getUser4();
	                password = TestDataInput.getPwd4();
	                break; 
	            }        
	            pauseForTime(3000);
	            //waitForElement(useridText,240).clear();
	            waitForElement(useridText,300).sendKeys(username);
	            pauseForTime(3000);
	            //waitForElement(passwordText,120).clear();
	            waitForElement(passwordText,150).sendKeys(password);
	            waitForElement(loginButton,150).click();
	            pauseForTime(3000);
	            
	        }catch(NoSuchElementException exp){
                        log.error("username/password fields not found on page");
                }
	        
	        return driver;
	            
	}
	 
	
        public void validateLogin(String user, String message){
		try{
			AccountType accType = AccountType.valueOf(user);
			try{			
				switch(accType){
				 case PRODUCER:
				         System.out.println("Producer account: " + TestDataInput.getPrUser());
					 username = TestDataInput.getPrUser();
					 password = TestDataInput.getPrPwd();
					 break;				 
				 case USER0:
					 username = TestDataInput.getUser0();
					 password = TestDataInput.getPwd0();
					 break;
				 case USER1:
					 username = TestDataInput.getUser1();
					 password = TestDataInput.getPwd1();
					 break;	
				 case USER2:
					 username = TestDataInput.getUser2();
					 password = TestDataInput.getPwd2();
					 break;	
				 case USER3:
					 username = TestDataInput.getUser3();
					 password = TestDataInput.getPwd3();
					 break;	
				 case USER4:
					 username = TestDataInput.getUser4();
					 password = TestDataInput.getPwd4();
					 break;	
				 case INVALID:
                     username = TestDataInput.getInvalidUser();
                     password = TestDataInput.getInvalidPwd();
                     break;
                 case NOUSER:
                     System.out.println("no user case\n");
                     username = TestDataInput.getNoUser();
                     password = TestDataInput.getNoPwd();
                     break;
				}	 
			}catch(NoSuchElementException exp){
				log.error("username/password fields not found on page");
			}
			System.out.println("till this point");
			waitForElement(useridText,60).clear();
			waitForElement(useridText,60).sendKeys(username);
			waitForElement(passwordText,60).clear();
			waitForElement(passwordText,60).sendKeys(password);
			waitForElement(loginButton,60).click();
			pauseForTime(1000);
			try{
				
				switch(accType){
				case INVALID: Assert.assertEquals(waitForElement(loginMsg,120).getText(), message);
				              break;
				case NOUSER:  Assert.assertEquals(waitForElement(loginMsg,120).getText(), message);
				             break;
				default:      log.info("Login successful");
				
				}
			       
			        pauseForTime(1000);
			        try{
			            if(loginMsg.isDisplayed()){
			                Assert.assertEquals(loginMsg.getText(), message);
			                log.info("'" + loginMsg.getText() + "'" + " message is displayed to user");
			            }
			        }catch(Exception e){
			                log.info("'" + successMsg + "'" + " message is displayed to user");
			                log.info("Logged in to PI as " + username);
			        }
			}catch(Exception exp){
			        log.error("Incorrect/No message is displayed to user");
			}
			
		}catch(NoSuchElementException exp){
			log.error("username/password fields not found on page");
		}
	 }
	 
        
         public void forgotPassword(String email, String msg,Boolean valid){
                try{
                    forgotPwdLink.click();
                    Assert.assertTrue(Utilities.isElementPresent(waitForElement(userEmail,30)));
                    userEmail.clear();
                    userEmail.sendKeys(email);
                    sendvcode.click();
                    if(valid)
                    Assert.assertEquals(otppageusername.getText(), email);
                    else
                    Assert.assertEquals(forgotPwdMsg.getText(), msg);
                   
                }catch(Exception exp){
                    log.error("Forgot Password section is not displayed");
                }
                 
         }
         
       
        
	 public WebDriver logout() throws InterruptedException {
		try{
		        //pauseForTime(2000);
		        waitForElement(profileDropDown,120).click();
			waitForElement(logoutLink,120).click();
			log.info("Logged out of app");
		}catch(WebDriverException exp){
			pauseForTime(5000);
			logoutLink.click();
			System.out.println("not visible\n");
		}catch (Exception genExp){
			log.error("Logout link is not visible");
		}
		
		return driver;
	}
	
}