package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableTest {
	public class Approval {
		Logger log=Logger.getLogger(Approval.class);
		Login login = new Login(driver);
		@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[4]")
		 WebElement SurveyList;
		 @FindBy(id="listTable")
		 WebElement tablelist;
		 @FindBy(xpath="/html[1]/body[1]/div[18]/div[2]/div[4]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]")
		 WebElement PlusIcon;
		 
		 public WebDriver Identifysurvey() {
			 
			 try {
			      pauseForTime(5000);
			      if(waitForElement(SurveyList,80).isDisplayed())
			     {
				  waitForElement(SurveyList,80).click();
				 }
			 }
		    catch(NoSuchElementException ex) 
		         {
			      log.error("SurveyList close button is not found on the page"); 
		         } 
	      
		   try {
		  if(waitForElement(tablelist, 60).isDisplayed()){
					log.info("identified table");
					int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator listHighlight-inactive']")).size();
					log.info(rows);
					int name=tablelist.findElements(By.cssSelector("tr[class='list_separator listHighlight-inactive'] td:nth-child(7)")).size();
					log.info(name);
					/*for(int i=3;i<name;i++) {
				    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
				    String s=driver.findElement(By.xpath(textPath)).getText();
				    if(s.contains(prop.getProperty("AllProcessReport"))) {
				     log.info("process is searched from All process report");
				     break;
				     }*/
				     }
					}
					catch(Exception ex) {
						log.error("process is not searched from all process list");
					}
	 
	
			 
			 
			 
			 
			 
			return driver;
			 
		 }
		
		
		
		
		
		
		
		
	}

}
