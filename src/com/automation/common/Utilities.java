package com.automation.common;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.openqa.selenium.Dimension;
import org.testng.ITestResult;

import static org.testng.Assert.assertTrue;

public class Utilities {
	static Logger log = Logger.getLogger(Utilities.class);
	public static WebDriver driver = null;
	public static String baseUrl;
	private static String url;
	private static String browser;
	
	public String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Utilities.url = url;
	}
	
	public static String getBrowser() {
		return browser;
	}
 
	public static void setBrowser(String browser) {
		Utilities.browser = browser;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver setDriver(WebDriver driver) {
		Utilities.driver = driver;
		return driver;
	}
	public WebDriver initDriver(){
	        baseUrl = this.getUrl();
	        System.out.println("Launched app on " + baseUrl);
	 
		if(this.getBrowser().equalsIgnoreCase("chrome")){
			File file = new File("C:\\Users\\wooqer\\Documents\\chromedriver_win32 (2)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
		}else if(this.getBrowser().equalsIgnoreCase("ie")){
			File file = new File("C:\\Users\\wooqer\\Downloads\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver(ieCapabilities);
			System.out.println("Created IE instance");
		}else if(this.getBrowser().equalsIgnoreCase("firefox")){
			FirefoxProfile profile = new FirefoxProfile();
		  	profile.setAssumeUntrustedCertificateIssuer(false);
			profile.setAcceptUntrustedCertificates(true);
			profile.setPreference("webdriver.load.strategy", "unstable");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xml, text/csv, text/plain, text/log, application/vnd.ms-excel, application/vnd.ms-word, application/vnd.ms-powerpoint, application/pdf, video/quicktime, video/x-msvideo, video/mpeg, audio/x-wav, audio/x-midi, audio/x-aiff, application/zlib, application/x-gzip, application/x-compressed, application/x-gtar, multipart/x-gzip, application/tgz, application/gnutar, application/x-tar, application/gzip");
			profile.setEnableNativeEvents(true);
			driver = new FirefoxDriver(profile);
			driver.switchTo().defaultContent();
		}
		driver.get(this.getUrl());
		System.out.println("Loaded url");
		driver.manage().window().maximize();
		System.out.println("Initialized driver");
	
		return driver;
	}
	
	
	public static String getCurrentTimeStamp(){
		Date dt = new Date();
		String timeStamp = new SimpleDateFormat("yyMddhhmmssSSS").format(dt);
		return timeStamp;
	}
	
	
	public static String toDate() {
	        Date date = new Date();
	        String dateValue = new SimpleDateFormat("d").format(date);
	        return dateValue;
	}
	

	/** Wait for a web element to be displayed and enabled on the page
	 * @param wElement
	 * @param iTime
	 */

	public static WebElement waitForElement(final WebElement wElement, int iTime){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(iTime, TimeUnit.SECONDS)
        .pollingEvery(1, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
		
		return wait.until( 
				new ExpectedCondition<WebElement>() 
				{
			      	public WebElement apply(WebDriver driver) {
			          return elementIfVisibleNEnabled(wElement);
			        }
				}
		 ); 
	  }
	  
	 /**
	 * Method to pause for specified number of seconds
	 * 
	 * @param iTime
	 *            - Time in milliseconds to pause
	 * @return
	 */
	
	
	  public static void pauseForTime(long iTime) {
		 try {
		 	Thread.sleep(iTime);
		 } catch (Exception e) {
		 	log.error(e.getMessage());
		 }
	  }

	  //Defining fluent wait for element to load
	  public static WebElement fluentWait(final By locator) {
		    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		            .withTimeout(60, TimeUnit.SECONDS)
		            .pollingEvery(1, TimeUnit.SECONDS)
		            .ignoring(NoSuchElementException.class);

		    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		        public WebElement apply(WebDriver driver) {
		            return driver.findElement(locator);
		        }
		    });

		    return  foo;
		};

		
	  //Defining fluent wait for page to load
	  public static Boolean isPageLoaded() {

			final String javaScriptFunction = "function f(){return document.readyState;} return f();";
			// We describe the condition to wait- Wait until the page load is
			// "Complete"

			Function<WebDriver, Boolean> condition = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver d) {
					String result = (String) ((JavascriptExecutor) d)
							.executeScript(javaScriptFunction);
					log.debug("The page is in " + result + " state");
					if (result.equalsIgnoreCase("complete"))
						return true;

					return false;
				}
			};

			/*
			 * if(driver instanceof FirefoxDriver){
			 * log.debug("Skipping the is pageLoaded function"); return true; }
			 */


			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(5, TimeUnit.SECONDS)
					.withTimeout(200, TimeUnit.SECONDS)
					.ignoring(RuntimeException.class);
			try {
				return wait.until(condition);
			}

			catch (TimeoutException err) {
				System.out
						.println("THE PAGE IS NOT LOADED EVEN AFTER THE TIMEOUT, OF 180 SECONDS");
				// log.warn("Trying Alternative options");
				// Keys.chord(Keys.ESCAPE);
				return false;
			}
	  }
	  
	  public static String getTitle() {
			return driver.getTitle();
	  }
	
	  public static boolean isElementPresent(WebElement element, List list) {
			if (element.isDisplayed()) {
				log.info(element.getText().trim() + "Is Visible");
				list.add(element.getText().trim());
				log.info("List of elements are:-" + list);
				return true;
			} else {
				log.error(element + "Is Not Visible");
				return false;
			}

		}

	  public static boolean isElementPresent(WebElement element) {
			if (element.isDisplayed()) {
				//log.info(element.getText().trim() + " is Visible");
				return true;
			} else {
				//log.error(element + " is Not Visible");
				return false;
			}
		}
	  
	  public static boolean isElementSelected(WebElement element) {
			if (element.isSelected()) {
				//log.info(element.getAttribute("value") + " is selected");
				return true;
			} else {
				//log.info(element.getAttribute("value") + " is not selected");
				return false;
			}

		}

	  public static WebElement elementIfVisibleNEnabled(WebElement element) {
			if (element.isDisplayed() && element.isEnabled()) {
				//log.info((element.getText().trim()) + " is Visible and Clickable");
			} else {
				//log.error(element + " is either not Visible or not Clickable");
			}
			return element;
	  }


	
	public static void maximizeBrowser() {
		((JavascriptExecutor) driver)
				.executeScript("if(window.screen){window.moveTo(0,0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);};");
	}
	

	public static void maximise() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenResolution = new Dimension((int) toolkit
				.getScreenSize().getWidth(), (int) toolkit.getScreenSize()
				.getHeight());
		driver.manage().window().setSize(screenResolution);
	}
	
	
	
	public static void quitDriver() {
		
		if (driver != null) {
			driver.quit();
			System.out.println("quit successfully");
			log.info("The web driver is quit successfully");
		}
	}
	
	public static void updateTestResult(String methodName, ITestResult result) {
		String strResult = null;
		if (result != null)
			strResult = "PASS";
		else
			strResult = "FAIL";	
		log.info(methodName + ":" + strResult);
	}

	
	
	public static void writeToFile(String fileName,String id) throws IOException 
	{
		try {
			File file = new File("C:\\Users\\wooqer\\workspace_0211\\APIautomation\\"+fileName);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(id);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void writeToPropertiesFile(String fileName,String variable,String value) throws IOException 
	{
		Properties prop = new Properties();
		 FileOutputStream fileOut = null;
		FileInputStream fileIn = null;

		try {

			
			fileIn = new FileInputStream(fileName);
			prop.load(fileIn);
            fileOut = new FileOutputStream(fileName);

			// set the properties value
			prop.setProperty(variable, value);
			

			// save properties to project root folder
			prop.store(fileOut, fileName);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	  }
	
	
	public static String readFromPropertiesFile(String fileName,String key) throws IOException 
	{	
	
	File file = new File(fileName);
	  
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return prop.getProperty(key);
	
	}
	
}

	
