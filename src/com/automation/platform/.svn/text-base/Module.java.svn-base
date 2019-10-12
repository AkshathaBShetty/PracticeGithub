package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.waitForElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Module {

	static Logger log = Logger.getLogger(Module.class);
	static Login login = new Login(driver);
	

	public enum chaptercreationtype {
		DRAGNDROP, COMPUTER, ADDNEW
	};
	
	public enum moduletype {
		BEGINNER, ADVANCED, SPOTLIGHT
	};
	
	

	String summarytext = "This is the summary of the chapter";
	String closingtext = "Thank you for visiting this chapter";
	public static final int MAXOPTIONS = 4;
	WebDriverWait wait = new WebDriverWait(driver, 50000);
	public String actualmodulename=null;
	public String [] chapternames = new String [10];
	public String chapter2id=null;
	int j=0;
	ArrayList<String> chapterslist=new ArrayList<String>();
	
	@FindBy(how = How.ID, using = "chapterName")
	public static WebElement chapterName;
	@FindBy(how = How.ID, using = "summary")
	public static WebElement summary;
	@FindBy(how = How.NAME, using = "qqfile")
	public static WebElement browse;
	@FindBy(how = How.ID, using = "closingText")
	public static WebElement closetext;
	@FindBy(how = How.ID, using = "contentSource")
	public static WebElement contentsrc;
	@FindBy(how = How.ID, using = "tagSuggestionInput")
	public static WebElement tag;
	@FindBy(how = How.LINK_TEXT, using = "Chapter")
	public static WebElement createchapter;
	@FindBy(how = How.LINK_TEXT, using = "addChapter")
	public static WebElement a;
	@FindBy(how = How.ID, using = "question")
	public static WebElement questiontext;
	@FindBy(how = How.ID, using = "addChapter")
	public static WebElement addnewquestion;
	@FindBy(how = How.ID, using = "questionSubmit")
	public static WebElement submitquestion;
	@FindBy(how = How.ID, using = "tempUploadInput")
	public static WebElement savechapter;
	@FindBy(how = How.ID, using = "newModule")
	public static WebElement newmodule;
	@FindBy(how = How.ID, using = "name")
	public static WebElement modulename;
	@FindBy(how = How.ID, using = "objective")
	public static WebElement moduleobjective;
	@FindBy(how = How.ID, using = "summary")
	public static WebElement modulesummary;
	@FindBy(how = How.LINK_TEXT, using = "Wooqer")
	public static WebElement fromwooqer;
	@FindBy(how = How.ID, using = "searchString")
	public static WebElement searchforchapter;
	@FindBy(how = How.XPATH, using = "//*[@id='moduleSearchForm']/div/input[2]")
	public static WebElement modulesearchicon;
	@FindBy(how = How.XPATH, using = "//*[@id='chapterSearchForm']/div/input[2]")
	public static WebElement searchicon;
	@FindBy(how = How.NAME, using = "qqfile")
	public static WebElement fromcomputer;
	@FindBy(how = How.NAME, using = "setTheChapterName")
	public static WebElement renamechapter;
	@FindBy(how = How.ID, using = "moduleFormSubmitButton")
	public static WebElement moduleformsubmit;
	@FindBy(how = How.XPATH, using = "/html/body/div[14]/div[3]/button[1]")
	public static WebElement assign;
	@FindBy(how = How.CSS, using = "div.whiteSectionContent tr.table-control-panel td:nth-child(4) form:nth-child(1) div.search-ctr > input.icon-ctr.i-search.pink-pr.ilight:nth-child(2)")
	public static WebElement searchpinkicon;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[3]/tbody[1]/tr[6]/td[5]/a[1]")
	public static WebElement selectassignee;
	@FindBy(how = How.ID, using = "activateDeactivateModule")
	public static WebElement activatemodule;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[18]/div[2]/div[4]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]")
	public static WebElement usermodule;
	
	@FindBy(how = How.XPATH, using = "//button[@class='module-button']")
	public static WebElement startbutton;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[11]/div[2]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	public static WebElement backtomodulelist;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[11]/div[2]/div[5]/table[2]/tbody[1]/tr[6]/td[5]/a[1]")
	public static WebElement modulechapterlist;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Adobe website')]")
	public static WebElement adobewebsite;
	@FindBy(how = How.ID, using = "close-flash-popup")
	public static WebElement closeflashpopup;
	//@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[18]/div[2]/div[4]/div[1]/div[2]/div[1]/div[1]/div[6]/div[2]/div[1]")
	//public static WebElement modulesearchicon;
	@FindBy(how = How.ID, using = "home-search")
	public static WebElement homesearch;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[18]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/span[1]")
	public static WebElement moduleresult;
	@FindBy(how = How.ID, using = "PopupTriggerId_1")
	  public static WebElement enableCommentsLink;
	@FindBy(how = How.LINK_TEXT, using = "change")
	  public static WebElement commentOnOffLink;
	@FindBy(how = How.ID, using = "finishButton")
	 public static WebElement donebutton;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[6]/td[4]/table[1]/tbody[1]/tr[2]/td[1]/img[1]")
	 public static WebElement enableDownloadLink;
	
	@FindBy(how = How.LINK_TEXT, using = "change")
	 public static WebElement changeLink;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[18]/div[2]/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[3]/a[1]/span[1]")
	 public static WebElement downloadicon;
	
	
	  

	public Module(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	
	@SuppressWarnings("incomplete-switch")
	public WebDriver viewModule(String name)
			throws IOException {

		
		closeflashpopup.click();
		 	
	       
	/*	Set<String> windowids= driver.getWindowHandles();
		 Iterator<String> itr=windowids.iterator();
		String mainWindowId=windowids.iterator().next();
		String popupWindowId=windowids.iterator().next();
		driver.switchTo().window(popupWindowId);*/
	//	wait.until(ExpectedConditions.visibilityOf(adobewebsite)).click();
		pauseForTime(5000);
	/*	 Alert alert = driver.switchTo().alert();
		 alert.accept();*/
 		
	      
		
	//	modulesearchicon.click();
	//	homesearch.sendKeys(name);
	//	wait.until(ExpectedConditions.visibilityOf(moduleresult)).click();
	 //   pauseForTime(5000);
		

		usermodule.click();
		startbutton.click();
		downloadicon.click();
		
		return driver;

	}
	
	
	
	@SuppressWarnings("incomplete-switch")
	public WebDriver createModule(String name, moduletype mtype, String chapterfrom,String[] filepath)
			throws IOException {

		name = name + Utilities.getCurrentTimeStamp();
		int count_of_chapters=filepath.length;
		actualmodulename=name;
		try {
			Utilities.writeToPropertiesFile("output.properties", "modulename", name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(newmodule)).click();
		wait.until(ExpectedConditions.visibilityOf(modulename)).sendKeys(name);
		moduleobjective.sendKeys("This is the objective");
		modulesummary.sendKeys("This is the summary of the module");
		System.out.println("filepath="+filepath[0]);
		for(int i=0;i<1;i++)
		{ addChapter("COMPUTER",filepath[i]);
		     pauseForTime(2000);
		}
		
		
		
		pauseForTime(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollTop = arguments[1];",moduleformsubmit, 250); 
		
		
		wait.until(ExpectedConditions.visibilityOf(moduleformsubmit)).click();
		wait.until(ExpectedConditions.visibilityOf(assign)).click();
		wait.until(ExpectedConditions.visibilityOf(searchforchapter)).sendKeys("swetha");
		
		searchpinkicon.click();
		pauseForTime(1000);
		System.out.println("Found table");
		WebElement assignTable = Utilities.fluentWait(By.id("assignTable"));
	  	List<WebElement> assignRows = assignTable.findElements(By.tagName("tr"));
			System.out.println(assignRows.size());
			selectassignee.click();
			activatemodule.click();
			pauseForTime(5000);
			backtomodulelist.click();
			pauseForTime(10000);
			enableComments(name);
			enableDownload();
			
		
		return driver;
		
	}
	
	
	//Enable Download flag for chapters
	public WebDriver enableDownload() throws IOException
	{
		WebElement chapterspage=driver.findElement(By.xpath("//a[contains(text(), 'Chapters')]"));
		chapterspage.click();
		
		wait.until(ExpectedConditions.visibilityOf(searchforchapter)).sendKeys(chapterslist.get(0));
		searchicon.click();
		pauseForTime(5000);
		enableDownloadLink.click();
		pauseForTime(5000);
		waitForElement(changeLink,120).click();
		
		return driver;
		
	}
	
	
	//Enable Comments For Chapters In Module
	
	public WebDriver enableComments(String modulename) throws IOException
	{
		viewChaptersInModule(modulename);
		
		WebElement chaptertable=driver.findElement(By.id("recordsTableId"));
		List<WebElement> rows = chaptertable.findElements(By.tagName("tr"));
		System.out.println("rows="+rows.size());
		for(int i=3;i<4;i++)
		{
		
		WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[5]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/span[1]"));
		temp.click();
		commentOnOffLink.click();
		pauseForTime(2000);
		
		}
		driver.navigate().to(driver.getCurrentUrl());
		pauseForTime(5000);
		donebutton.click();
		
		return driver;
	}
	
	public WebDriver viewChaptersInModule(String modulename)
			throws IOException {
	
	WebElement chapterlist=null;
	WebElement modulespage=driver.findElement(By.xpath("//a[contains(text(), 'Modules')]"));
	modulespage.click();
	pauseForTime(2000);
	searchforchapter.sendKeys(modulename);
	pauseForTime(1000);
	modulesearchicon.click();
	WebElement moduletable=driver.findElement(By.id("listTable"));
	List<WebElement> rows = moduletable.findElements(By.tagName("tr"));
	for(int i=6;i<rows.size();i++)
	{
	
	WebElement temp=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[5]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]"));
	System.out.println("text="+temp.getText());
	if(temp.getText().contains(modulename))
	{
		System.out.println("entered");
		chapterlist=driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[2]/div[5]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[5]/a[1]"));
		pauseForTime(2000);
		chapterlist.click();
		break;
	}
	
	}
	
	return driver;                     
	}
	
	
	
	
	
	public WebDriver addChapter(String chapterfrom,String filepath)
			throws IOException {
	
	switch(chapterfrom)
	{
	case "WOOQER":
	fromwooqer.click();
	wait.until(ExpectedConditions.visibilityOf(searchforchapter)).sendKeys("safaripdf");
	searchicon.click();
	
	WebElement assignTable=driver.findElement(By.id("listTable"));
	break;
	case "COMPUTER":
	fromcomputer.sendKeys(filepath);
	WebElement moduleform=driver.findElement(By.id("moduleForm"));
	pauseForTime(500);
	String[] filename;
	String delims;
	
	delims = "[/]+";
	filename = filepath.split(delims);
	
//	try{
	
	 
		
	//filename[6]+Utilities.getCurrentTimeStamp();
		moduleform.findElement(By.linkText("Rename")).click();
		System.out.println("j="+j);
		chapterslist.add(filename[6]+Utilities.getCurrentTimeStamp());
		System.out.println("chaptername="+chapterslist.get(j));
		renamechapter.sendKeys(chapterslist.get(j));j++;
		moduleform.findElement(By.className("saveRenamedFile")).click();
/*	}
	catch(Exception e)
	{
		//do nothing
	}*/
	
	
	
	break;
	}
	
	return driver;
	
	}

	@SuppressWarnings("incomplete-switch")
	public WebDriver createChapter(String name, chaptercreationtype ctype, Boolean isQuiz, String filepath)
			throws IOException {

		name = name + Utilities.getCurrentTimeStamp();

		try {
			if (waitForElement(createchapter, 60).isDisplayed()) {
				waitForElement(createchapter, 60).click();
			}
		} catch (Exception exp) {
			log.error("create chapter link is not found on landing page");
		}

		chapterName.sendKeys(name);
		summary.sendKeys(summarytext);
		browse.sendKeys(filepath);
		
		pauseForTime(10000);
		if (isQuiz) {
			createQuestion("MCSA", MAXOPTIONS);
			pauseForTime(500);
			createQuestion("MCMA", MAXOPTIONS);
			pauseForTime(500);
			createQuestion("SA", 0);
			pauseForTime(500);
			createQuestion("DA", 0);
			// createQuestion("MCSI");
			// createQuestion("MCMI");

		}
		closetext.sendKeys(closingtext);

		return driver;

	}

	public WebDriver createQuestion(String questiontype, int noofoptions) {
		WebElement rightanswer=null;
		wait.until(ExpectedConditions.visibilityOf(addnewquestion)).click();
		pauseForTime(5000);
		Select question = new Select(driver.findElement(By.id("thisone")));
		switch (questiontype) {
		case "MCSA":
			question.selectByVisibleText("Multiple Choice Single Answer");
			pauseForTime(1000);
			questiontext.sendKeys("Multiple Choice Single Answer?");
			//pauseForTime(1000);
			for (int i = 0; i < noofoptions; i++)
				driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
			
			rightanswer=driver.findElement(By.xpath("//*[@id='radioAnswers']/div[1]/label"));
			rightanswer.click();
			break;
		case "MCMA":
			question.selectByVisibleText("Multiple Choice Multiple Answers");
			pauseForTime(1000);
			questiontext.sendKeys("Multiple Choice Multiple Answer?");
			
			for (int i = 0; i < noofoptions; i++)
				driver.findElement(By.id("answer" + (i+1))).sendKeys("answer" + (i+1));
			driver.findElement(By.xpath("//*[@id='checkAnswers']/div[1]/label")).click();
			driver.findElement(By.xpath("//*[@id='checkAnswers']/div[2]/label")).click();
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
			questiontext.sendKeys("short answer?");
			break;
		case "DA":
			question.selectByVisibleText("Descriptive Answer");
			pauseForTime(1000);
			questiontext.sendKeys("Descriptive answer?");
			break;

		}
		
		submitquestion.click();

		return driver;

	}

}
