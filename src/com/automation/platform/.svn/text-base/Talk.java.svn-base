package com.automation.platform;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.common.Utilities;
import com.automation.test.TalkTestOwner;
import com.thoughtworks.selenium.Wait;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Talk {
	
	static Logger log = Logger.getLogger(Talk.class);
	static Login login = new Login(driver);
	public enum assigntype{USER,ROLE,STORE,CITY,RESOURCE,TEAM};
	private String talkRootHtml = "html/body/div[2]/div/div/div[4]/div[2]/div/table/tbody/tr";
	private String talkContent1;
	private String talkContent2;
	private static String publicTalkContent = "Auto Web Public Talk ";
	private static String privateTalkContent = "Auto Web Private Talk ";
	private static String comment1 = "Auto Comment ";
	private static String postComment = "Auto Comment on post thread ";
	private static String concludeComment = "Auto Comment: This talk is concluded";
	private static String blockUserName;
	
	// ================================ Talk on user landing page ====================================
	     @FindBy(how = How.ID, using = "h_talk")
	     public static WebElement talkIcon;
		 @FindBy(how = How.ID, using = "talk-add-user")
		  public static WebElement searchtoadd;
		 @FindBy(how = How.ID, using = "select-everyone")
		 public static WebElement selectEveryone;
		 @FindBy(how = How.ID, using = "talk-textarea")
		  public static WebElement messageText;
		 @FindBy(how = How.ID, using = "add-talk-button")
		  public static WebElement addTalk;
		 @FindBy(how = How.ID, using = "wooqNowSubmit")
		  public static WebElement msgSubmitBtn;
		  @FindBy(how = How.ID, using = "search-result-popup")
		  public static WebElement searchresult;
		  @FindBy(how = How.ID, using = "upload-file-input")
		  public static WebElement uploadfile;
		  @FindBy(how = How.ID, using = "ajax-load-content")
		  public static WebElement socialfeed;
		  @FindBy(how = How.ID, using = "browse-add-user")
		  public static WebElement search_browserandselect;
		  @FindBy(how = How.ID, using = "browse-search-result-popup")
		  public static WebElement browsersearchresult;
		  @FindBy(how = How.ID, using = "share-more-users")
		  public static WebElement confirmshare;
		  @FindBy(how = How.ID,using ="close-flash-popup")
		  public static WebElement FlashPlayer;
		  WebDriverWait wait = new WebDriverWait(driver, 200);
		 
	
	 public Talk(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver createTalk(String content,Boolean ispublic,Boolean isAttachmentPresent,String filepath) throws IOException{
		 
		 String messagetext;
		 messagetext=content + Utilities.getCurrentTimeStamp();
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 try{
             if(waitForElement(messageText, 60).isDisplayed()){
            	 messageText.clear();
            	  
                     waitForElement(messageText,60).sendKeys(messagetext);
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
         pauseForTime(2000);
         try{
             if(waitForElement(searchtoadd, 60).isDisplayed()){
                 waitForElement(searchtoadd,60).click();
             }
         }catch(Exception exp){
             log.error("selectUser is not found on Talk page");    
         }
         try{
             if(waitForElement(selectEveryone, 60).isDisplayed()){
                 waitForElement(selectEveryone,60).click();
             }
         }catch(Exception exp){
             log.error("selectEveryone is not found on Talk page");    
         }
         
         pauseForTime(500);
         
         if(isAttachmentPresent)
         {
        	 try{
             
            	     System.out.println("attachment");
                     uploadfile.sendKeys(filepath);
             }
        	 catch(Exception exp){
                 log.error("addTalk button is not found on Talk page");    
             }
        	 
         }
         
         
          try{
             if(waitForElement(addTalk,60).isDisplayed()){
                     waitForElement(addTalk,60).click();
             }
         }catch(Exception exp){
             log.error("addTalk button is not found on Talk page");    
         }
          
         if(isAttachmentPresent)
         pauseForTime(2000);
         else
        pauseForTime(1000);	 
        
         
         driver=getTalkId(false,messagetext);
         
         
         
         try{
        /*    Assert.assertTrue(waitForElement(firstRowTalkText,60).isDisplayed());
            log.info("The newly added public talk is displayed on first row of Talk page"); 
            System.out.println("First row talk text: " + firstRowTalkText.getText().trim());
            talkContent1 = firstRowTalkText.getText().trim();*/
         }catch(Exception exp){
            log.error("The newly added public talk is NOT displayed on Talk page");     
         }
         pauseForTime(1000);
      
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver createTalk(String msg,Boolean isprivate,assigntype privatetype,String value,Boolean isAttachmentPresent,String filepath) throws IOException{
		 //CLICK ON TALK ICON IN HOME PAGE
		 
		 String messagetext;
		 messagetext=msg + Utilities.getCurrentTimeStamp();
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 
		 //ENTER TEXT ON TALK CREATION
		 
		 try{
             if(waitForElement(messageText, 60).isDisplayed()){
            	 messageText.clear();
                     waitForElement(messageText,60).sendKeys(messagetext);
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
         pauseForTime(2000);
         
         //ENTERING SUGGESTIONS
         
         try{
             if(waitForElement(searchtoadd, 60).isDisplayed()){
                 waitForElement(searchtoadd,60).click();
             }
         }catch(Exception exp){
             log.error("selectUser is not found on Talk page"); 
          }
         
         //CLICKING ON THE SUGGESTION
         
         assigntype a;
         a=privatetype;
         try{
             if(waitForElement(searchtoadd, 60).isDisplayed()){
            	 char[] val=value.toCharArray();
            	 for(int i=0;i<val.length;i++)
                 {  searchtoadd.sendKeys(String.valueOf(val[i]));
                     pauseForTime(100);
                 }
             }
         }catch(Exception exp){
             log.error("searchtoadd is not found on Talk page");  
         }
         switch(a)
         {
         case USER:
        	 List <WebElement> people = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-People')]"));
        	 pauseForTime(500);
        	for(int i=0;i<people.size();i++)
        	{ 
        		WebElement p=people.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
        	    if(p.getText().contains(value))
        	    {
        	    	p.click();
        	    	break;
        	    }
        	    
        	    pauseForTime(500);
        	}
        	    
        	 System.out.println("Clicked the user");
        	 break;
        	 
         
         case ROLE:
        	 List <WebElement> role = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-Roles')]"));
        	 pauseForTime(700);
        	 for(int i=0;i<role.size();i++)
         	{ 
        		 
         		WebElement r=role.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         	    if(r.getText().contains(value))
         	    {
         	    	r.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(1000);
         	}
        	 System.out.println("Clicked the role");
        	 break;
        	 
         case STORE:
        	 List <WebElement> store = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-Stores')]"));
        	 pauseForTime(1000);
        	 for(int i=0;i<store.size();i++)
         	{ 
         		WebElement s=store.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         	    if(s.getText().contains(value))
         	    {
         	    	s.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(500);
         	}
         	
        	 System.out.println("Clicked the store");
        	 break;
        	 
         case CITY:
        	 List <WebElement> city = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-Cities')]"));
        	 for(int i=0;i<city.size();i++)
         	{ 
         		WebElement c=city.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         		pauseForTime(500);
         	    if(c.getText().contains(value))
         	    {
         	    	c.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(500);
         	}
         	
        	 System.out.println("Clicked the city");
        	 break;
        	 
         case RESOURCE:
        	 List <WebElement> resource = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-Groups')]"));
        	 for(int i=0;i<resource.size();i++)
         	{ 
         		WebElement c=resource.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         		pauseForTime(1000);
         	    if(c.getText().contains(value))
         	    {
         	    	c.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(1000);
         	}
         	
        	 System.out.println("Clicked the resource");
        	 break;
        	 
         case TEAM:
        	 List <WebElement> team = searchresult.findElements(By.xpath("//div[contains(@lang, 'type-Team')]"));
        	 pauseForTime(500);
        	for(int i=0;i<team.size();i++)
        	{ 
        		WebElement t=team.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
        	    if(t.getText().contains(value))
        	    {
        	    	t.click();
        	    	break;
        	    }
        	    
        	    pauseForTime(500);
        	}
        	    
        	 System.out.println("Clicked the team");
        	 break;
        	 
         }
         
         //ADDING ATTACHMENT
         
         if(isAttachmentPresent)
         {
        	 try{
             
            	     System.out.println("attachment");
                     uploadfile.sendKeys(filepath);
             }
        	 catch(Exception exp){
                 log.error("addTalk button is not found on Talk page");    
             }
        	 
         }
         
         //ADD TALK
         try{
             if(waitForElement(addTalk,60).isDisplayed()){
                     waitForElement(addTalk,60).click();
             }
         }catch(Exception exp){
             log.error("addTalk button is not found on Talk page");    
         }
         
         if(isAttachmentPresent)
         pauseForTime(2000);
         else
         pauseForTime(1000);	 
         
         driver=getTalkId(true,messagetext);
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver commentOnTalk(String talkid,String comment) throws IOException{
		 
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 WebElement commentbox=driver.findElement(By.id("add-comment-textarea-"+talkid));
		 WebElement commentbutton=driver.findElement(By.id("parent-talk-"+talkid));
		 commentbox.sendKeys(comment+Utilities.getCurrentTimeStamp());
		 commentbutton.click();
		 
		 
		 
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver shareTalk(String talkid,assigntype privatetype,String value){
		 
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 
		 WebElement shareicon=driver.findElement(By.id("share-action-"+talkid));
		 shareicon.click();
		 
		 assigntype a;
         a=privatetype;
         try{
             if(waitForElement(search_browserandselect, 60).isDisplayed()){
            	 char[] val=value.toCharArray();
            	 for(int i=0;i<val.length;i++)
            	 {
                 waitForElement(search_browserandselect,60).sendKeys(String.valueOf(val[i]));
                 pauseForTime(100);
                 }
             }
         }catch(Exception exp){
             log.error("search_browserandselect is not found on Talk page");  
         }
         switch(a)
         {
         case USER:
        	 List <WebElement> people = browsersearchresult.findElements(By.xpath("//div[contains(@lang, 'type-People')]"));
        	 pauseForTime(500);
        	 System.out.println(people.size());
        	for(int i=0;i<people.size();i++)
        	{ 
        		wait.until(ExpectedConditions.visibilityOf(people.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"))));
        		WebElement p=people.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
        		System.out.println(p.getText());
        		System.out.println(value);
        	    if(p.getText().contains(value))
        	    {
        	    	System.out.println("entered1");
        	    	p.click();
        	    	break;
        	    }
        	    
        	    pauseForTime(500);
        	}
        	    
        	 System.out.println("Clicked the user");
        	 break;
        	 
         
         case ROLE:
        	 List <WebElement> role = browsersearchresult.findElements(By.xpath("//div[contains(@lang, 'type-Roles')]"));
        	 pauseForTime(500);
        	 for(int i=0;i<role.size();i++)
         	{ 
         		WebElement r=role.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         	    if(r.getText().contains(value))
         	    {
         	    	r.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(1000);
         	}
        	 System.out.println("Clicked the role");
        	 break;
        	 
         case STORE:
        	 List <WebElement> store = browsersearchresult.findElements(By.xpath("//div[contains(@lang, 'type-Stores')]"));
        	 pauseForTime(500);
        	 for(int i=0;i<store.size();i++)
         	{ 
         		WebElement s=store.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         	    if(s.getText().contains(value))
         	    {
         	    	s.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(500);
         	}
         	
        	 System.out.println("Clicked the store");
        	 break;
        	 
         case CITY:
        	 List <WebElement> city = browsersearchresult.findElements(By.xpath("//div[contains(@lang, 'type-Cities')]"));
        	 for(int i=0;i<city.size();i++)
         	{ 
         		WebElement c=city.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         		pauseForTime(500);
         	    if(c.getText().contains(value))
         	    {
         	    	c.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(1000);
         	}
         	
        	 System.out.println("Clicked the city");
        	 break;
        	 
         case RESOURCE:
        	 List <WebElement> resource = browsersearchresult.findElements(By.xpath("//div[contains(@lang, 'type-Groups')]"));
        	 for(int i=0;i<resource.size();i++)
         	{ 
         		WebElement c=resource.get(i).findElement(By.xpath("//span[contains(@class, 'search-res-bold-text')]"));
         		pauseForTime(500);
         	    if(c.getText().contains(value))
         	    {
         	    	c.click();
         	    	break;
         	    }
         	    
         	    pauseForTime(1000);
         	}
         	
        	 System.out.println("Clicked the resource");
        	 break;
         }
         
         try{
             if(waitForElement(confirmshare,60).isDisplayed()){
                     waitForElement(confirmshare,60).click();
             }
         }catch(Exception exp){
             log.error("confirmmembers button is not found on Talk page");    
         }
         
		 
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver endorseTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 WebElement endorseicon=driver.findElement(By.id("talk-endorse-"+talkid));
		 endorseicon.click();
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver contestTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 WebElement contesticon=driver.findElement(By.id("talk-contest-"+talkid));
		 contesticon.click();
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver reportTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("talk-report-abuse-"+talkid))));
		 WebElement reporttalkicon=driver.findElement(By.id("talk-report-abuse-"+talkid));
		 reporttalkicon.click();
	      return driver;
		 
		}
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver followTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("talk-follow-"+talkid+"-true"))));
		 WebElement followicon=driver.findElement(By.id("talk-follow-"+talkid+"-true"));
		 followicon.click();
	      return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver unfollowTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("talk-follow-"+talkid+"-false"))));
		 WebElement unfollowicon=driver.findElement(By.id("talk-follow-"+talkid+"-false"));
		 unfollowicon.click();
	      return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver blockUserOnTalk(String user){
		  return driver;
	 }
	 
	
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver endorseComment(String user){
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver contestComment(String user){
		  return driver;
	 }
	 
	 @SuppressWarnings("incomplete-switch")
     public WebDriver concludeTalk(String talkid){
		 try {
			 pauseForTime(5000);
			 if(waitForElement(FlashPlayer,80).isDisplayed()) {
				 waitForElement(FlashPlayer,80).click();
				 }
			 }
		 
		 catch(NoSuchElementException ex){
			 log.error("FlashPlayer close button is not found on the page"); 
		 }
		 
		 try{
             if(waitForElement(talkIcon, 60).isDisplayed()){
            	 waitForElement(talkIcon,60).click();
             }
         }catch(Exception exp){
             log.error("Talk text box is not found on Talk page");    
         }
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("talk-"+talkid))));
		 WebElement concludeicon=driver.findElement(By.xpath("//*[@id=\"talk-"+talkid+"\"]/div[2]/div/div[1]/div[3]/div[1]/div[3]/span[1]"));
		 concludeicon.click();
		 pauseForTime(200);
	//	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("parent-talk-"+talkid))));
		 WebElement conclude=driver.findElement(By.xpath("//*[@id=\"conclude-comment-"+talkid+"\"]/button[1]"));
		 conclude.click();
	      return driver;
		 
		  
	 }
	 
	 
	 public WebDriver getTalkId(Boolean isprivate,String messagetext) throws IOException
	 {
		 List<WebElement> allvisibletalks= socialfeed.findElements(By.className("single-talk-wrap"));
         List<WebElement> allinnertalks= socialfeed.findElements(By.className("user-comment-text-talk-wrap"));
         System.out.println("no.of talks="+allvisibletalks.size());
         pauseForTime(1000);
         
        
         for(int i=0;i<allvisibletalks.size();i++)
         {
        	 String value;
        	 String talktext=null;
        	 String talktext1=null;
             pauseForTime(5000);
    WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[10]/div[1]/div[11]/div[4]/div[2]/div[2]/div[2]"
    		+ "/div[" + String.valueOf(i+1) + "]/div[2]/div[1]/div[1]/div[2]/span[1]"));
        	 
        //	 talktext=temp.getText();
        	 talktext1=temp.getText();
        	// System.out.println("talktext="+talktext);
        	// System.out.println("talktext1="+talktext1);
        	 if(talktext1.equals(messagetext))
        		{ 
        		  System.out.println("entered into this loop");
        		  WebElement temp1=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[10]/div[1]/div[11]/div[4]/div[2]/div[2]/div[2]"
    		+ "/div[" + String.valueOf(i+1) + "]"));
        		  value=temp1.getAttribute("id");
        		 
        		  if(!isprivate)
        		  Utilities.writeToPropertiesFile("output.properties", "publictalkid", value.substring(5));
        		  else
        		  Utilities.writeToPropertiesFile("output.properties", "privatetalkid", value.substring(5));
        		}
 		} 
         
         return driver;
	 }
	
}

