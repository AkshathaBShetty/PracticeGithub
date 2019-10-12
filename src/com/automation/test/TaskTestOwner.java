package com.automation.test;

import static com.automation.common.Utilities.driver;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Login;
import com.automation.platform.Talk;
import com.automation.platform.Talk.assigntype;
import com.automation.platform.Task;

import static com.automation.common.TestDataInput.successMsg;
import static com.automation.common.TestDataInput.errorMsg;

public class TaskTestOwner {

	static Logger log = Logger.getLogger(TaskTestOwner.class);
	TestDataInput launch = new TestDataInput();
	Utilities util = new Utilities();
	String filepath1 = "C:\\Users\\wooqer\\workspace_0211\\NewUIAutomation\\Files\\mcsi1.exe";
	//C:\Users\wooqer\workspace_0211\NewUIAutomation\Files
	

	String user = "Anuja Swetha";
	String role = "Advertising Agency";
	String city = "Bengaluru";
	String store = "Adidas Bangalore";
	String msgtext = "Talk";

	@BeforeClass
	public void setUp() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		launch.setSystemFileName("tuto.properties");
		launch.loadProperties();
		util.initDriver();
		Login login = new Login(driver);
		login.login("PRODUCER");

	}

   @Test(priority=7)
	public void createTaskfromToDo() {

		Task task = new Task(driver);
		task.createTask(false, false, null);

	}

	@Test(priority=1)
	public void createTaskfromHomePage() {

		Task task = new Task(driver);
		task.createTask(true, false, null);

	}

	//@Test(priority=2)
	public void createTaskfromHomePagewithAttachment() {

		Task task = new Task(driver);
		task.createTask(true, true, filepath1);

	}

	//@Test(priority=3)
	public void createTaskBrowseUser() {
		Task task = new Task(driver);
		task.createTask(true, assigntype.USER, user, false, null);
	}

	@Test(priority=4)
	public void createTaskBrowseRole() {
		Task task = new Task(driver);
		task.createTask(true, assigntype.ROLE, role, false, null);
	}

	@Test(priority=5)
	public void createTaskBrowseStore() {
		Task task = new Task(driver);
		task.createTask(true, assigntype.STORE, store, false, null);
	}

	//@Test(priority=6)
	public void createTaskBrowseCity() {
		Task task = new Task(driver);
		task.createTask(true, assigntype.CITY, city, false, null);
	}
	
	@Test(priority=0)
	public void createTaskfromToDoPagewithAttachment() {

		Task task = new Task(driver);
		task.createTask(false, true, filepath1);

	}
	
	
	
	
	
	@AfterClass
	public void logout() throws InterruptedException{
		driver.close();
		
	}
	
	
	
	

}
