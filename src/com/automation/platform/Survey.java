
	
	package com.automation.platform;

	import static com.automation.common.Utilities.driver;
	import static com.automation.common.Utilities.waitForElement;

	import java.io.IOException;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import com.automation.platform.Module;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PauseAction;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

	import static com.automation.common.Utilities.pauseForTime;
	import com.automation.common.Utilities;

	public class Survey {

		static Logger log = Logger.getLogger(Module.class);
		static Login login = new Login(driver);
		

		
		

		String summarytext = "This is the summary of the chapter";
		String closingtext = "Thank you for visiting this chapter";
		public static final int MAXOPTIONS = 4;
		WebDriverWait wait = new WebDriverWait(driver, 50000);
		public String actualmodulename=null;
		public String chapter1id=null;
		public String chapter2id=null;
		String exturl="https://www.w3schools.com/xml/plant_catalog.xml";
		String queryexpression="/CATALOG/PLANT/LIGHT";
		public static String surveyname;
		public static String surveyid;
		String timestamp=Utilities.getCurrentTimeStamp();
		
		@FindBy(how = How.ID, using = "searchString")
		public static WebElement searchforsurvey;
		@FindBy(how = How.XPATH, using = "//*[@id='surveySearchForm']/div/input[2]")
		public static WebElement searchicon;
		@FindBy(how = How.XPATH, using = "//span[@title='Click to create a new survey']")
		public static WebElement addnew;
		@FindBy(how = How.ID, using = "cn")
		public static WebElement surveynametextbox;
		@FindBy(how = How.ID, using = "continueContent")
		public static WebElement continuebutton;
		@FindBy(how = How.ID, using = "module.objective")
		public static WebElement surveyobjective;
		@FindBy(how = How.ID, using = "module.summary")
		public static WebElement introduction;
		@FindBy(how = How.ID, using = "question")
		public static WebElement questiontextbox;
		@FindBy(how = How.ID, using = "addChapter")
		public static WebElement addnewquestion;
		@FindBy(how = How.ID, using = "questionSubmit")
		public static WebElement submitquestion;
		@FindBy(how = How.ID, using = "addMore")
		public static WebElement addmorequestions;
		@FindBy(how = How.ID, using = "addMoreElement")
		public static WebElement addmoreelements;
		@FindBy(how = How.ID, using = "sourceUrl")
		public static WebElement urltextbox;
		@FindBy(how = How.ID, using = "queryExpression")
		public static WebElement queryexpress;
		@FindBy(how = How.ID, using = "chapter.summary")
		public static WebElement instructions;
		@FindBy(how = How.ID, using = "passPercentage")
		public static WebElement completionpercent;
		@FindBy(how = How.ID, using = "moduleFormSubmitButton")
		public static WebElement surveyformsubmit;
		@FindBy(how = How.ID, using = "assignTypeBox")
		public static WebElement assigneetype;
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'User')]")
		public static WebElement selectuser;
		@FindBy(how = How.XPATH, using = "//html[1]/body[1]/div[11]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
		public static WebElement backtosurveylst;
		@FindBy(how = How.XPATH, using = "//*[@id='userModuleSearchForm']/div/input[2]")
		public static WebElement assignsearch;
		@FindBy(how = How.ID, using = "h_todo")
		public static WebElement todo;
		@FindBy(how = How.ID, using = "close-flash-popup")
		public static WebElement closeflashpopup;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/i[1]")
		public static WebElement surveystate;
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'All surveys')]")
		public static WebElement allsurveys;
		@FindBy(how = How.XPATH, using = "//button[@class='start-tdo start_survey']")
		public static WebElement startsurvey;
		@FindBy(how = How.XPATH, using = "//*[@id='chapterTest']/div/div[2]/div[1]/div/div[3]/div/div/div[1]/label")
		public static WebElement mcsaanswer1;
		@FindBy(how = How.XPATH, using = "//*[@id='chapterTest']/div/div[2]/div[2]/div/div[3]/div/div/div[1]/label")
		public static WebElement mcmaanswer1;
		@FindBy(how = How.XPATH, using = "//*[@id='chapterTest']/div/div[2]/div[2]/div/div[3]/div/div/div[2]/label")
		public static WebElement mcmaanswer2;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/input[1]")
		public static WebElement saanswer;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[4]/div[1]/div[3]/div[1]/div[1]/textarea[1]")
		public static WebElement daanswer;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[5]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/label[1]")
		public static WebElement ratingele1answer1;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[5]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/label[1]")
		public static WebElement ratingele2answer1;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[5]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]/label[1]")
		public static WebElement ratingele3answer1;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[5]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/label[1]")
		public static WebElement ratingele4answer1;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[6]/div[1]/div[3]/div[1]/div[1]/input[1]")
		public static WebElement extquerybox;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[6]/div[1]/div[3]/div[1]/div[2]/a[1]")
		public static WebElement extqueryvalue;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[7]/div[1]/div[3]/div[1]/div[1]/input[1]")
		public static WebElement intquerybox;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[7]/div[1]/div[3]/div[1]/div[2]/a[1]")
		public static WebElement intqueryvalue;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[12]/div[1]/form[1]/div[1]/div[2]/div[8]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/label[1]")
		public static WebElement npsvalue;
		@FindBy(how = How.ID, using = "submitAnswers")
		public static WebElement submitsurveyform;
		@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[9]/div[2]/div[3]/div[1]/span[1]")
		public static WebElement gotofilled;

		
		
		
		 public Survey(WebDriver driver) {
		 		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		 	}
		 	
		
		
		public WebDriver searchForSurvey(String surveyname)
		{
			WebElement modulespage=driver.findElement(By.xpath("//a[contains(text(), 'Surveys')]"));
			modulespage.click();
			wait.until(ExpectedConditions.visibilityOf(searchforsurvey)).sendKeys(surveyname);
			searchicon.click();
			WebElement surveyTable = Utilities.fluentWait(By.id("listTable"));
		  	List<WebElement> listRows = surveyTable.findElements(By.tagName("tr"));
		  	System.out.println(listRows.size());
		  	for(int i=6;i<(6+listRows.size());i++)
		  	{
		  		WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]/span[1]"));
		  	    if(temp.getText().equals(surveyname))
		  	    {
		  	    	System.out.println("search result found");
		  	    	break;
		  	    }
		  	}
		  	return driver;
			
		}
		
		
		public WebDriver createSurvey(String content,String periodicity,String closingrule)
		{
			WebElement modulespage=driver.findElement(By.xpath("//a[contains(text(), 'Surveys')]"));
			modulespage.click();
			surveyname="survey"+timestamp;
			wait.until(ExpectedConditions.visibilityOf(addnew)).click();
		    wait.until(ExpectedConditions.visibilityOf(surveynametextbox)).sendKeys(surveyname);
		    continuebutton.click();
		    surveyobjective.sendKeys("This is the objective of the summary");
		    introduction.sendKeys("This survey is created for automation purpose to validate whether survey is working or not");
		    createSurveyQuestion("MCSA", MAXOPTIONS);
			pauseForTime(1000);
			createSurveyQuestion("MCMA", MAXOPTIONS);
			pauseForTime(1000);
			createSurveyQuestion("SA", 0);
			pauseForTime(1000);
			createSurveyQuestion("DA", 0);
			pauseForTime(1000);
			createSurveyQuestion("RATING", MAXOPTIONS);
			pauseForTime(1000);
		    createSurveyQuestion("EXT", 0);
			pauseForTime(1000);
			createSurveyQuestion("INT", 0);
			pauseForTime(1000);
			createSurveyQuestion("NPS", 0);
			pauseForTime(1000);
			
		/*	JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(250,350)");*/
			wait.until(ExpectedConditions.visibilityOf(instructions)).sendKeys("These are the instrcutions given for filling the survey.Carefully read them before filling the survey");
			
			if(closingrule.equals("COMPLETION%"))
				completionpercent.sendKeys("50");
			
			surveyformsubmit.click();
			
			activateSurvey(surveyname);
		  	return driver;
			
		}
	
		
		public WebDriver createSurveyQuestion(String questiontype, int noofoptions) {
			WebElement rightanswer=null;
			wait.until(ExpectedConditions.visibilityOf(addnewquestion)).click();
			pauseForTime(5000);
			
			Select question = new Select(driver.findElement(By.id("thisone")));
			switch (questiontype) {
			case "MCSA":
				question.selectByVisibleText("Multiple Choice Single Answer");
				pauseForTime(1000);
				questiontextbox.sendKeys("Multiple Choice Single Answer "+timestamp+"?");
				//pauseForTime(1000);
				for (int i = 0; i < 2; i++)
					driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
				for(int i=2;i<noofoptions;i++)
				{
					addmorequestions.click();
					driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
				}
				break;
			case "MCMA":
				question.selectByVisibleText("Multiple Choice Multiple Answers");
				pauseForTime(1000);
				questiontextbox.sendKeys("Multiple Choice Multiple Answer "+timestamp+"?");
				
				for (int i = 0; i < 2; i++)
					driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
				for(int i=2;i<noofoptions;i++)
				{
					addmorequestions.click();
					driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
					
				}
				break;
			case "RATING":
				question.selectByVisibleText("Rating");
				pauseForTime(1000);
				questiontextbox.sendKeys("Rate the following elements "+timestamp+"?");
				for (int i = 0; i < 2; i++)
				driver.findElement(By.xpath("//*[@id='questionForm']/div[1]/div[3]/div[1]/div[1]/div[2]/div[" + String.valueOf(i+1) + "]/input[1]")).sendKeys("element" + (i+1));
				for(int i=2;i<noofoptions;i++)
				{
				addmoreelements.click();
				driver.findElement(By.xpath("//*[@id='questionForm']/div[1]/div[3]/div[1]/div[1]/div[2]/div[" + String.valueOf(i+1) + "]/input[1]")).sendKeys("element" + (i+1));
				}
				for (int i = 0; i < 3; i++)
				{
					WebElement element = driver.findElement(By.id("answer" + (i+1)));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					pauseForTime(500);
					element.sendKeys("answer" + (i+1));
				}
				for(int i=3;i<noofoptions;i++)
				{
					addmorequestions.click();
					WebElement element = driver.findElement(By.id("answer" + (i+1)));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					pauseForTime(500);
					element.sendKeys("answer" + (i+1));
					
				}
				
				break;
			case "MCSI":
				question.selectByVisibleText("Multiple Choice Single Answer (Image)");
				pauseForTime(1000);
				break;
			case "MCMI":
				question.selectByVisibleText("Multiple Choice Multiple Answer (Image)");
				pauseForTime(1000);
				break;
			case "SA":
				question.selectByVisibleText("Short Answer");
				pauseForTime(1000);
				questiontextbox.sendKeys("short answer "+timestamp+"?");
				break;
			case "DA":
				question.selectByVisibleText("Descriptive Answer");
				pauseForTime(1000);
				questiontextbox.sendKeys("Descriptive answer "+timestamp+"?");
				break;
			case "EXT":
				question.selectByVisibleText("External Query");
				pauseForTime(1000);
				questiontextbox.sendKeys("External Query "+timestamp+"?");
				urltextbox.sendKeys(exturl);
				queryexpress.sendKeys(queryexpression);
				break;
			case "INT":
				question.selectByVisibleText("Internal Query");
				pauseForTime(1000);
				questiontextbox.sendKeys("Internal Query "+timestamp+"?");
				break;
			case "NPS":
				question.selectByVisibleText("Net Promoter Score @ Wooqer");
				pauseForTime(1000);
				break;

			}
			
			submitquestion.click();
			
			

			return driver;

		}
		
		
		
		public WebDriver assignSurvey(String surveyname,String user)
		{
			
			
			WebElement modulespage=driver.findElement(By.xpath("//a[contains(text(), 'Surveys')]"));
			modulespage.click();
			pauseForTime(2000);
			wait.until(ExpectedConditions.visibilityOf(surveystate)).click();
			wait.until(ExpectedConditions.visibilityOf(allsurveys)).click();
			wait.until(ExpectedConditions.visibilityOf(searchforsurvey)).sendKeys(surveyname);
			searchicon.click();
			WebElement surveyTable = Utilities.fluentWait(By.id("listTable"));
		  	List<WebElement> listRows = surveyTable.findElements(By.tagName("tr"));
		  	System.out.println(listRows.size());
		  	for(int i=6;i<(6+listRows.size());i++)
		  	{
		  		WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]/span[1]"));
		  	    if(temp.getText().equals(surveyname))
		  	    {
		  	    	WebElement assign=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[7]/a[1]/span[1]"));
		  	    	assign.click();
		  	    	break;
		  	    }
		  	}
		  	
		  	assigneetype.click();
		  	wait.until(ExpectedConditions.visibilityOf(selectuser)).click();
		  	searchforsurvey.sendKeys(user);
		  	pauseForTime(500);
		  	assignsearch.click();
		  	pauseForTime(1000);
		  	WebElement assignUserTable = Utilities.fluentWait(By.id("assignTable"));
		  	List<WebElement> assignRows = assignUserTable.findElements(By.tagName("tr"));
		  	System.out.println(assignRows.size());
		  	for(int i=6;i<(6+assignRows.size());i++)
		  	{
		  		WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[3]/table[3]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]"));
		  	    if(temp.getText().equals(user))
		  	    {
		  	    	System.out.println("entered");
		  	    	WebElement invite=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[3]/table[3]/tbody[1]/tr[" + String.valueOf(i) + "]/td[5]/a[1]"));
		  	    	invite.click();
		  	    	break;
		  	    }
		  	}
		  	
		  	pauseForTime(1000);
		  	backtosurveylst.click();
		  	
		  	return driver;
			
		}
		
		public WebDriver activateSurvey(String surveyname)
		{
			
		/*	WebElement modulespage=driver.findElement(By.xpath("//a[contains(text(), 'Surveys')]"));
			modulespage.click();*/
			
			wait.until(ExpectedConditions.visibilityOf(searchforsurvey)).sendKeys(surveyname);
			searchicon.click();
			WebElement surveyTable = Utilities.fluentWait(By.id("listTable"));
		  	List<WebElement> listRows = surveyTable.findElements(By.tagName("tr"));
		  	System.out.println(listRows.size());
		  	pauseForTime(2000);
		  	
		  	for(int i=6;i<(6+listRows.size());i++)
		  	{
		  		WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]/span[1]"));
		  	    if(temp.getText().equals(surveyname))
		  	    {
		  	    	surveyid=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[3]/span[1]")).getText();
		  	    	WebElement activate=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[7]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[4]/a[1]"));
		  	    	activate.click();
		  	    	break;
		  	    }
		  	}
		  	System.out.println("surveyid="+surveyid);
		  	try {
				Utilities.writeToPropertiesFile("output.properties", "surveyid", surveyid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	return driver;
		}
		
		public WebDriver fillSurvey(String surveyid)
		{
			
			closeflashpopup.click();
			wait.until(ExpectedConditions.visibilityOf(todo)).click();
			pauseForTime(5000);
			WebElement element= driver.findElement(By.id("SURVEY-TODAY-"+surveyid));
	       	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			wait.until(ExpectedConditions.visibilityOf(startsurvey)).click();
			wait.until(ExpectedConditions.visibilityOf(mcsaanswer1)).click();
			wait.until(ExpectedConditions.visibilityOf(mcmaanswer1)).click();
			wait.until(ExpectedConditions.visibilityOf(mcmaanswer2)).click();
			wait.until(ExpectedConditions.visibilityOf(saanswer)).sendKeys("short answer question answered");
			wait.until(ExpectedConditions.visibilityOf(daanswer)).sendKeys("descriptive answer question answered");
			wait.until(ExpectedConditions.visibilityOf(ratingele1answer1)).click();
			wait.until(ExpectedConditions.visibilityOf(ratingele2answer1)).click();
			wait.until(ExpectedConditions.visibilityOf(ratingele3answer1)).click();
			wait.until(ExpectedConditions.visibilityOf(ratingele4answer1)).click();
			wait.until(ExpectedConditions.visibilityOf(extquerybox)).click();
			wait.until(ExpectedConditions.visibilityOf(extqueryvalue)).click();
			wait.until(ExpectedConditions.visibilityOf(intquerybox)).click();
			wait.until(ExpectedConditions.visibilityOf(intqueryvalue)).click();
			wait.until(ExpectedConditions.visibilityOf(npsvalue)).click();
			submitsurveyform.click();
			wait.until(ExpectedConditions.visibilityOf(gotofilled)).click();
	     //  driver.findElement(By.id("SURVEY-TODAY-"+surveyid)).click();
			return driver;
		}
			
	
}
