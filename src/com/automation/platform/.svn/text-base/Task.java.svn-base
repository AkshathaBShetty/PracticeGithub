package com.automation.platform;

import org.apache.commons.lang.UnhandledException;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.Click;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.common.Utilities;
import com.automation.platform.Talk.assigntype;
import com.automation.test.TalkTestOwner;
import com.sun.org.apache.bcel.internal.generic.ConstantPushInstruction;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Random;

public class Task {

	static Logger log = Logger.getLogger(Task.class);
	static Login login = new Login(driver);

	public enum assignType {
		USER, ROLE, STORE, CITY
	};

	private static String taskNameText = "Automated Task Name-Complete the science assignment!"
			+ new Random().nextInt(100000);
	private static String taskDescpText = "Automated Descp-The first science assignmnet should be completed in 10 days from today."
			+ new Random().nextInt(100000);
	private static String taskWithFile = "Automated task with image file as attachment";

	// ----------------------Task from ToDo
	// page----------------------------------//

	@FindBy(how = How.ID, using = "home-icon")
	private static WebElement homeIcon;
	@FindBy(how = How.ID, using = "close-flash-popup")
	public static WebElement closeFlashpopup;
	@FindBy(how = How.XPATH, using = "/html/body/div[18]/div[2]/div[4]/div[3]/div[2]/div[1]/div/div[4]/div[1]")
	public static WebElement homePlusIcon;
	@FindBy(how = How.ID, using = "h_todo")
	private static WebElement toDoIcon;
	@FindBy(how = How.ID, using = "plusIconContainer")
	private static WebElement toDoPlusIcon;
	@FindBy(how = How.ID, using = "new-task")
	private static WebElement newTask;
	@FindBy(how = How.CLASS_NAME, using = "popup-rp-header")
	private static WebElement newTaskPopup;
	@FindBy(how = How.ID, using = "task-title-text")
	private static WebElement newTaskTitleText;
	@FindBy(how = How.ID, using = "task-detail-text")
	private static WebElement newTaskDetailText;
	@FindBy(how = How.XPATH, using = "//*[@id='createTaskForm']/div/div[3]/div[2]/label")
	private static WebElement newTaskAttachmentIcon;
	@FindBy(how = How.ID, using = "createTaskForm")
	private static WebElement newTaskAttachmentIconid;
	@FindBy(how = How.ID, using = "talk-add-user")
	private static WebElement newTaskAssignees;
	@FindBy(how = How.XPATH, using = "//div[text()='Anuja Swetha ']")
	private static WebElement favUser;
	@FindBy(how = How.ID, using = "browse-link-text-task")
	private static WebElement newTaskBrowse;
	@FindBy(how = How.ID, using = "add-participants")
	private static WebElement newTaskAddUsers;
	@FindBy(how = How.ID, using = "task-due-date")
	private static WebElement newTaskDueDate;
	@FindBy(how = How.XPATH, using = "//a[@class='ui-state-default ui-state-highlight ui-state-hover']")
	public static WebElement currentDate;
	@FindBy(how = How.CLASS_NAME, using = "create-task-button")
	private static WebElement newTaskCreate;
	@FindBy(how = How.ID, using = "talk-add-user")
	public static WebElement searchUser;
	@FindBy(how = How.ID, using = "search-res-id-194348") // amruta
	public static WebElement searchresClick;
	@FindBy(how = How.ID, using = "search-result-popup")
	public static WebElement searchresult;
	@FindBy(how = How.ID, using = "browse-link-text-task")
	public static WebElement taskBrowseSelect;
	@FindBy(how = How.ID, using = "selected-city-text")
	public static WebElement cityDropdown;
	@FindBy(how = How.ID, using = "selected-store-text")
	public static WebElement storeDropdown;
	@FindBy(how = How.ID, using = "selected-role-text")
	public static WebElement roleDropdown;
	@FindBy(how = How.ID, using = "cities-suggestion-input")
	public static WebElement citiesSugn;
	@FindBy(how = How.ID, using = "select-all-text")
	public static WebElement citiesSelectAll;
	@FindBy(how = How.ID, using = "stores-suggestion-input")
	public static WebElement storesSugn;
	@FindBy(how = How.ID, using = "roles-suggestion-input")
	public static WebElement rolesSugn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']")
	public static WebElement toastTab;
	@FindBy(how = How.LINK_TEXT, using = "To Do page>Pending with Others")
	public static WebElement pendingwithOthersLink;

	public Task(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebDriver createTask(Boolean isHomeScreen, Boolean isAttachmentPresent, String filepath) {

		// Checking if Task is to be created from HomePage or ToDoPage as per
		// the boolean set(isHomeScreen)
		if (isHomeScreen) {
			try {
				pauseForTime(4000);
				if (waitForElement(homeIcon, 30).isDisplayed()) {
					waitForElement(homeIcon, 30).click();
					pauseForTime(3000);
					waitForElement(closeFlashpopup, 60).click();
					pauseForTime(3000);
					waitForElement(homePlusIcon, 6000).click();
					log.info("Home page icon is dispalyed and is clicked");
				}
			} catch (NoSuchElementException e) {
				log.error("Home page icon is not available from producer side Dashboard");
			}
		} else {
			try {
				pauseForTime(9000);
				if (waitForElement(toDoIcon, 30).isDisplayed()) {
					waitForElement(toDoIcon, 30).click();
					pauseForTime(4000);
					waitForElement(toDoPlusIcon, 120).click();
					log.info("ToDo icon is dispalyed and is clicked");
				}
			} catch (NoSuchElementException e) {
				log.error("ToDo icon is not available from producer side Dashboard");
			}

		}

		// Selecting New task from the + icon dropdown
		try {
			if (waitForElement(newTask, 30).isDisplayed()) {
				waitForElement(newTask, 30).click();
				log.info("NewTask icon is clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("New Task icon is not displayed");
		}

		// Adding NewTask title text
		try {
			if (waitForElement(newTaskTitleText, 30).isDisplayed()) {
				newTaskTitleText.click();
				newTaskTitleText.clear();
				newTaskTitleText.sendKeys(taskNameText);
				log.info("Task title field is clicked and entered as " + taskNameText);
			}
		} catch (NoSuchElementException e) {
			log.error("Task title field is not displayed");
		}

		// Adding NewTask Details Text
		try {
			if (waitForElement(newTaskDetailText, 30).isDisplayed()) {
				newTaskDetailText.click();
				newTaskDetailText.clear();
				newTaskDetailText.sendKeys(taskDescpText);
				log.info("Task description field is clicked and entered as " + taskDescpText);
			}
		} catch (NoSuchElementException e) {
			log.error("Task description field is not displayed");
		}

		// Attaching a file if 'isAttachmentPresent' boolean is set to true -
		// Right now using autoIt tool
		if (isAttachmentPresent) {
			try {
				if (waitForElement(newTaskAttachmentIcon, 30).isDisplayed()) {
					newTaskAttachmentIcon.click();
					pauseForTime(3000);
					log.info("this");
					pauseForTime(4000);
					try {
						Runtime.getRuntime().exec(filepath);
					} catch (IOException e) {
						log.error("autoit script failed");
					}
					pauseForTime(3000);
					log.info("Attachment icon is present and file is attached.");
				}

			} catch (NoSuchElementException e) {
				log.error("Attachment icon is not present and file is not attached.");
			}

		}

		// Select assignees field is clicked - browse and select is clicked &
		// selecting users from a city
		try {
			if (waitForElement(newTaskAssignees, 30).isDisplayed()) {
				newTaskAssignees.click();
				pauseForTime(4000);
				favUser.click();
				pauseForTime(2000);
				log.info("Select assignees clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("City dropdown is not present");
		}

		// DueDate - Current date is being picked
		try {
			if (waitForElement(newTaskDueDate, 30).isDisplayed()) {
				newTaskDueDate.click();
				currentDate.click();
				log.info("Due date is selected from the calendar");
			}
		} catch (NoSuchElementException e) {
			log.error("Due Date calendar is not displayed");
		}

		try {
			if (waitForElement(newTaskCreate, 30).isEnabled()) {
				newTaskCreate.click();
				log.info("Create task button is clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("Create task button is not displayed");
		}

		//log.info("Task is created with title " + taskNameText);

		// Asserting the task creation from Toast message
		try {
			
			if(waitForElement(toastTab, 100).isDisplayed()){
				String toastText = toastTab.getText();
				if (toastText.contains(taskNameText)) {
					System.out.println("Task is created successfully");
				}
				log.info("the succcess toast msg - task created is as follows" + toastText);
				System.out.println(toastText);
			}
		} catch (NoSuchElementException e) {
			System.out.println("exited try block and entered catch block");
			log.error("Issues in task success toast message");
		}
		
		System.out.println("out of assertion block");

		return driver;
	}

	// Browse and select detail testcases
	public WebDriver createTask(Boolean isHomeScreen, assigntype privateType, String value, Boolean isAttachmentPresent,
			String filepath) {

		if (isHomeScreen) {
			try {
				pauseForTime(4000);
				if (waitForElement(homeIcon, 30).isDisplayed()) {
					waitForElement(homeIcon, 30).click();
					pauseForTime(3000);
					waitForElement(closeFlashpopup, 60).click();
					;
					pauseForTime(3000);
					waitForElement(homePlusIcon, 6000).click();
					log.info("Home page icon is dispalyed and is clicked");
				}
			} catch (NoSuchElementException e) {
				log.error("Home page icon is not available from producer side Dashboard");
			}
		} else {
			try {
				pauseForTime(9000);
				if (waitForElement(toDoIcon, 30).isDisplayed()) {
					waitForElement(toDoIcon, 30).click();
					pauseForTime(4000);
					waitForElement(toDoPlusIcon, 120).click();
					log.info("ToDo icon is dispalyed and is clicked");
				}
			} catch (NoSuchElementException e) {
				log.error("ToDo icon is not available from producer side Dashboard");
			}

		}

		try {
			if (waitForElement(newTask, 30).isDisplayed()) {
				waitForElement(newTask, 30).click();
				log.info("NewTask icon is clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("New Task icon is not displayed");
		}

		try {
			if (waitForElement(newTaskTitleText, 30).isDisplayed()) {
				newTaskTitleText.click();
				newTaskTitleText.clear();
				newTaskTitleText.sendKeys(taskNameText);
				log.info("Task title field is clicked and entered as " + taskNameText);
			}
		} catch (NoSuchElementException e) {
			log.error("Task title field is not displayed");
		}

		try {
			if (waitForElement(newTaskDetailText, 30).isDisplayed()) {
				newTaskDetailText.click();
				newTaskDetailText.clear();
				newTaskDetailText.sendKeys(taskDescpText);
				log.info("Task description field is clicked and entered as " + taskDescpText);
			}
		} catch (NoSuchElementException e) {
			log.error("Task description field is not displayed");
		}

		if (isAttachmentPresent) {
			try {
				if (waitForElement(newTaskAttachmentIcon, 30).isDisplayed()) {
					newTaskAttachmentIcon.click();
					pauseForTime(3000);
					log.info("this");
					// newTaskAttachmentIconid.sendKeys(filepath);
					pauseForTime(4000);
					try {
						Runtime.getRuntime().exec(filepath);
					} catch (IOException e) {
						log.error("autoit script failed");
					}
					pauseForTime(3000);
					log.info("Attachment icon is present and file is attached.");
				}

			} catch (NoSuchElementException e) {
				log.error("Attachment icon is not present and file is not attached.");
			}

		}

		// Browse and select

		assigntype b;
		b = privateType;
		try {
			if (waitForElement(newTaskAssignees, 30).isDisplayed()) {
				newTaskAssignees.click();
				pauseForTime(3000);
				waitForElement(taskBrowseSelect, 30).click();
				log.info("Select assignees clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("select assignees pop-up is not displayed");
		}

		switch (b) {
		case USER:
			pauseForTime(3000);
			driver.findElement(By.id("browse-add-user")).click();
			driver.findElement(By.id("browse-add-user")).sendKeys(value);
			pauseForTime(2000);
			driver.findElement(By.className("search-res-bold-text")).click();
			waitForElement(newTaskAddUsers, 30).click();
			pauseForTime(4000);
			newTaskDetailText.click();
			break;

		case ROLE:
			try {
				waitForElement(roleDropdown, 30).click();
				waitForElement(rolesSugn, 30).sendKeys(value);
				driver.findElement(By.id("browse-filter-suggest-78")).click(); // Advertising
																				// agency
				pauseForTime(3000);
				waitForElement(citiesSelectAll, 3000).click();
				waitForElement(newTaskAddUsers, 30).click();
				pauseForTime(4000);
				newTaskDetailText.click();
			} catch (NoSuchElementException e) {

			}
			break;
		case STORE:
			try {
				waitForElement(storeDropdown, 30).click();

				waitForElement(storesSugn, 30).sendKeys(value);
				pauseForTime(3000);
				driver.findElement(By.id("browse-filter-suggest-48282")).click(); // Adidas
																					// Bangalore
				pauseForTime(3000);
				waitForElement(citiesSelectAll, 3000).click();
				waitForElement(newTaskAddUsers, 30).click();
				pauseForTime(4000);
				newTaskDetailText.click();

			} catch (NoSuchElementException e) {

			}
			break;
		case CITY:
			try {
				waitForElement(cityDropdown, 30).click();
				waitForElement(citiesSugn, 30).sendKeys(value);
				pauseForTime(3000);
				driver.findElement(By.id("browse-filter-suggest-10")).click();// Bangalore
				pauseForTime(3000);
				waitForElement(citiesSelectAll, 3000).click();
				waitForElement(newTaskAddUsers, 30).click();
				pauseForTime(4000);
				newTaskDetailText.click();

			} catch (NoSuchElementException e) {
				log.error("City dropdown is not present");
			}
			break;
		}

		try {
			if (waitForElement(newTaskDueDate, 30).isDisplayed()) {
				newTaskDueDate.click();
				currentDate.click();
				log.info("Due date is selected from the calendar");
			}
		} catch (NoSuchElementException e) {
			log.error("Due Date calendar is not displayed");
		}

		try {
			if (waitForElement(newTaskCreate, 30).isEnabled()) {
				newTaskCreate.click();
				log.info("Create task button is clicked");
			}
		} catch (NoSuchElementException e) {
			log.error("Create task button is not displayed");
		}

		//log.info("Task is created with title " + taskNameText);

		// Asserting task creation from toast message
		try {
			if (waitForElement(toastTab, 4000).isDisplayed()) {
				// driver.findElement(By.linkText("To Do page>Pending with
				// Others")).isDisplayed();
				String toastText = toastTab.getText();
				if (toastText.contains(taskNameText)) {
					System.out.println("Task is created successfully");
				}
                log.info("the succcess toast msg - task created is as follows" + toastText);
				System.out.println(toastText);
			}
		} catch (NoSuchElementException e) {
			log.error("Issues in task success toast message");
		}

		return driver;
	}
	
	
}
