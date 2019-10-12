package com.automation.platform;

import static com.automation.common.Utilities.driver;
import static com.automation.common.Utilities.pauseForTime;
import static com.automation.common.Utilities.waitForElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
	Logger log=Logger.getLogger(Search.class);
	Login login = new Login(driver);
	@FindBy(xpath="//td[@id='contentTabLink']")
	WebElement content;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	WebElement Modules;
	@FindBy(id="searchString")
	WebElement Searchbox;
	@FindBy(xpath="//td[@class='pinkBoldText']")
	WebElement Modrecord;
	@FindBy(id="moduleType")
	WebElement filter;
	@FindBy(xpath="//a[contains(text(),'All modules')]")
	WebElement Allmodules;
	@FindBy(xpath="//a[contains(text(),'Deleted modules')]")
	WebElement Deletedmodules;
	@FindBy(id="dashboardTabLink")
	WebElement Dashboard;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[2]")
	WebElement Chapters;
	@FindBy(xpath="//td[@class='pinkBoldText chapterDetailsRow']")
	WebElement Chaprecord;
	@FindBy(id="contentType")
	WebElement ChapFilter;
	@FindBy(xpath="//a[contains(text(),'All chapters')]")
	WebElement Allchapters;
	@FindBy(xpath="//a[contains(text(),'Deleted chapters')]")
	WebElement DeletedChapters;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[4]")
	WebElement Survey;
	@FindBy(xpath="//input[@value='Inactive surveys']")
	WebElement Surveyfilter;
	@FindBy(xpath="//a[contains(text(),'Surveys in progress')]")
	WebElement surveyinprogress;
	@FindBy(xpath="//a[contains(text(),'Completed surveys')]")
	WebElement CompletedSurvey;
	@FindBy(xpath="//a[contains(text(),'All surveys')]")
	WebElement Allsurvey;
	@FindBy(xpath="//a[contains(text(),'Deleted surveys')]")
	WebElement DeletedSurvey;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[5]")
	WebElement Process;
	@FindBy(xpath="//span[@class='pinkBoldText']")
	WebElement Procrecord;
	@FindBy(xpath="//input[@value='My processes']")
	WebElement ProcessFilter;
	@FindBy(xpath="//a[contains(text(),'My processes')]")
	WebElement MyProcess;
	@FindBy(xpath="//a[contains(text(),'Deleted processes')]")
	WebElement DeletedProcess;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[6]")
	WebElement Users;
	@FindBy(xpath="//td[@class='pinkBoldText viewStore']")
	WebElement SearchedUser;
	@FindBy(xpath="//input[@value='Active Users']")
	WebElement UserFilter;
	@FindBy(xpath="//a[contains(text(),'Inactive Users')]")
	WebElement InactiveUsers;
	@FindBy(xpath="//a[contains(text(),'All users')]")
	WebElement Allusers;
	@FindBy(xpath="/html[1]/body[1]/div[11]/div[2]/div[3]/div[4]/table[1]/tbody[1]/tr[1]/td[2]/a[7]")
	WebElement Stores;
	@FindBy(xpath="//input[@value='Active']")
	WebElement StoreFilter;
	@FindBy(xpath="//a[contains(text(),'Inactive Stores')]")
	WebElement InactiveStores;
	@FindBy(xpath="//a[contains(text(),'Active Stores')]")
	WebElement ActiveStore;
	@FindBy(id="switchPiTabLink")
	WebElement ManagePI;
	@FindBy(linkText="Resources")
	WebElement Resources;
	@FindBy(xpath="//td[@class='pinkBoldText']/span")
	WebElement Result;
	@FindBy(id="evaluateeSearch")
	WebElement Searchbox2;
	@FindBy(xpath="//td[class='pinkBoldText']/span[1]")
	WebElement Searchedrecord;
	@FindBy(id="resourceFilter")
	WebElement Resourcefilter;
	@FindBy(xpath="//a[contains(text(),'My resources')]")
	WebElement MyResource;
	@FindBy(linkText="Roles")
	WebElement Roles;
	@FindBy(id="chapterSearch")
	WebElement Rolesearchbox;
	@FindBy(id="progressTabLink")
	WebElement Reports;
	@FindBy(id="reportTypes")
	WebElement ProgressFilter;
	@FindBy(xpath="//a[contains(text(),'Store')]")
	WebElement Storeprogress;
	@FindBy(xpath="//a[contains(text(),'User')]")
	WebElement Userprogress;
	@FindBy(xpath="//a[contains(text(),'City')]")
	WebElement CityProgress;
	@FindBy(xpath="//a[contains(text(),'Resource')]")
	WebElement ResourceProgress;
	@FindBy(id="searchReports")
	WebElement Storesearch;
	@FindBy(linkText="Survey")
	WebElement Surveyreport;
	@FindBy(id="statusSelect")
	WebElement SurveyFilter;
	@FindBy(xpath="//a[contains(text(),'All surveys')]")
	WebElement AllsurveyReport;
	@FindBy(linkText="Process")
	WebElement ProcessReport;
	@FindBy(id="evaluationSearch")
	WebElement ProcessSearchbox;
	@FindBy(xpath="//a[contains(text(),'All processes')]")
	WebElement Allprocessfilter;
	@FindBy(xpath="//tr[@class='list_separator']/td[1]")
	WebElement Processrecord;
	@FindBy(xpath="//table[@class='paddedTable']")
	WebElement tablelist;
	@FindBy(xpath="//tr[@class='list_separator listHighlight-inactive']")
	WebElement tablerows;
	@FindBy(id="h_talk")
	WebElement Talk;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[10]/div[1]/div[11]/div[4]/div[2]/div[1]/div[1]")
	WebElement SearchIcon;
	@FindBy(xpath="//input[@type='text']")
	WebElement Searchfield;
	@FindBy(xpath="//div[@class='user-comment-text-talk-wrap search-comment-wrap']")
	WebElement matchingtalks;
	WebDriverWait d=new WebDriverWait(driver, 100);
	
	
	public Search(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
	 }
	
	public WebDriver ProdsideSearch(Boolean isModule,Boolean ischapter,Boolean isSurvey,Boolean isProcess,Boolean isUsers,Boolean isStores,Boolean isResource,Boolean isRole,Boolean isProgressReport,Boolean isSurveyReport,Boolean isProcessReport,Boolean isTalk ) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\wooqer\\eclipse-workspace2\\NewUIAutomation\\input.properties");
		prop.load(fis);
		
	//MODULE
		
   if(isModule) {
	   try {
			pauseForTime(4000);
			 if(waitForElement(Modules,60).isDisplayed()) {
				 Modules.click();
		  }}
	  catch(Exception ex) {
			log.error("Modules option is not found");
		}
	  try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.sendKeys(prop.getProperty("Mymodule"));
			Searchbox.sendKeys(Keys.ENTER);
	    } }
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	   }
	
	  try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("Mymodule"))){
				log.info("existing module is successfully searched from My modules list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing module is not searched");
	   }
	
	  try {
		if(waitForElement(filter,60).isDisplayed()) {
			filter.click();
	    }
		
	    }catch(Exception ex) {
		log.error("filter is not found");  
	    }
	 try {
		if(waitForElement(Allmodules,60).isDisplayed()) {
			Allmodules.click();
	    }
	   }
	 catch(Exception ex) {
		log.error("Allmodules is not found"); 
	   }
	  try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("AllModule"));
			Searchbox.sendKeys(Keys.ENTER);
		}
		}
	  catch(Exception ex) {
		log.error("Searchbox is not found");
	    }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("AllModule"))){
				log.info("existing module is successfully searched from All modules list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing module is not searched in All module list");
	    }
	try {
		if(waitForElement(filter,60).isDisplayed()) {
			filter.click();
	    }
		}
	   catch(Exception ex) {
		log.error("filter is not found");  
		}
	try {
		if(waitForElement(Deletedmodules,60).isDisplayed()) {
			Deletedmodules.click();
	   }
	 }
	 catch(Exception ex) {
	 	log.error("Deletedmodules is not found"); 
	  }
	try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("DeletedModule"));
			Searchbox.sendKeys(Keys.ENTER);
		}
		}catch(Exception ex) {
		log.error("Searchbox is not found");
	    }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("DeletedModule"))){
				log.info("existing module is successfully searched from Deleted modules list");
			}}
		}
	 catch(Exception ex) {
		log.error("Existing module is not searched");
	   }
	try {pauseForTime(2000);
		if(waitForElement(Dashboard,60).isDisplayed()){
			Dashboard.click();
		}
	}
	catch(Exception ex) {
		log.error("dashboard tab is not found");
	}
		}
   
  //CHAPTER
   
if(ischapter) {
	try {
		if(waitForElement(Chapters,60).isDisplayed()){
			Chapters.click();
		}
	}
	catch(Exception ex) {
		log.error("chapters option is not found");
	}
	try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.sendKeys(prop.getProperty("MyChapter"));
			Searchbox.sendKeys(Keys.ENTER);
	    } }
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Chaprecord,60).isDisplayed()) {
			String text=Chaprecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("MyChapter"))){
				log.info("existing chapter is successfully searched from My chapter list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing chapter is not searched in My chapter list");
	   }
	try {
		if(waitForElement(ChapFilter,60).isDisplayed()){
			ChapFilter.click();
		}
	}
	catch(Exception ex) {
		log.error("ChapFilter dropdown is not found");
	}
	try {
		if(waitForElement(Allchapters,60).isDisplayed()){
			Allchapters.click();
		}
	}
	catch(Exception ex) {
		log.error("Allchapter option is not found");
	}
	try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("AllChapter"));
			Searchbox.sendKeys(Keys.ENTER);
	    } }
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Chaprecord,60).isDisplayed()) {
			String text=Chaprecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("AllChapter"))){
				log.info("existing chapter is successfully searched from All chapter list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing chapter is not searched in All chapter list");
	   }
	try {
		if(waitForElement(ChapFilter,60).isDisplayed()){
			ChapFilter.click();
		}
	}
	catch(Exception ex) {
		log.error("ChapFilter dropdown is not found");
	}
	try {
		if(waitForElement(DeletedChapters,60).isDisplayed()){
			DeletedChapters.click();
		}
	}
	catch(Exception ex) {
		log.error("DeletedChapters option is not found");
	}
	try {
	if(waitForElement(Searchbox,60).isDisplayed()) {
		Searchbox.clear();
		Searchbox.sendKeys(prop.getProperty("DeletedChapter"));
		Searchbox.sendKeys(Keys.ENTER);
    }
	}
   catch(Exception ex) {
	log.error("Searchbox is not found");
  }
	try {
		pauseForTime(3000);
		if(waitForElement(Chaprecord,60).isDisplayed()) {
			String text=Chaprecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("DeletedChapter"))){
				log.info("existing chapter is successfully searched from deleted chapter list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing chapter is not searched in deleted chapter list");
	   }
	try {pauseForTime(2000);
	   if(waitForElement(Dashboard,60).isDisplayed()){
		Dashboard.click();
	  }
   }
    catch(Exception ex) {
	log.error("dashboard tab is not found");
     }
   }

//SURVEY

if(isSurvey) {
	try {
		pauseForTime(2000);
	   if(waitForElement(Survey,60).isDisplayed()){
		   Survey.click();
	  }
    }
 catch(Exception ex) {
	log.error("Survey option is not found");
    }
	try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("Inactivesurvey"));
			Searchbox.sendKeys(Keys.ENTER);
			}
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("Inactivesurvey"))){
				log.info("existing survey is successfully searched from inactive surveys list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing survey is not searched in inactive surveys list");
	   }
	
	try {
		pauseForTime(2000);
		if(waitForElement(Surveyfilter,60).isDisplayed()){
			log.error("identified filter");
			Surveyfilter.click();
		}
	}
	catch(Exception ex) {
		log.error("SurveyFilter dropdown is not found");
	}
	try {
		if(waitForElement(surveyinprogress,60).isDisplayed()){
			surveyinprogress.click();
		}
	}
	catch(Exception ex) {
		log.error("surveyinprogress option is not found");
	}
	try {
		pauseForTime(2000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("Activesurvey"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("Activesurvey"))){
				log.info("existing survey is successfully searched from SurveyinProgress list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing survey is not searched in SurveyinProgress list");
	   }
	try {
		pauseForTime(2000);
		if(waitForElement(Surveyfilter,60).isDisplayed()){
			Surveyfilter.click();
		}
	}
	catch(Exception ex) {
		log.error("SurveyFilter dropdown is not found");
	}
	
	try {
		if(waitForElement(CompletedSurvey,60).isDisplayed()){
			CompletedSurvey.click();
		}
	}
	catch(Exception ex) {
		log.error("CompletedSurvey filter option is not found");
	}
	try {
		pauseForTime(2000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("Completedsurvey"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("Completedsurvey"))){
				log.info("existing survey is successfully searched from CompletedSurveys list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing survey is not searched in CompletedSurveys list");
	   }
	try {
		pauseForTime(2000);
		if(waitForElement(Surveyfilter,60).isDisplayed()){
			Surveyfilter.click();
		}
	}
	catch(Exception ex) {
		log.error("SurveyFilter dropdown is not found");
	}
	try {
		pauseForTime(2000);
		if(waitForElement(Allsurvey,60).isDisplayed()){
			Allsurvey.click();
		}
	}
	catch(Exception ex) {
		log.error("Allsurvey filter option is not found");
	}
	try {
		pauseForTime(4000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("Allsurvey"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("Allsurvey"))){
				log.info("existing survey is successfully searched from AllSurveys list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing survey is not searched in AllSurveys list");
	   }
	try {
		pauseForTime(2000);
		if(waitForElement(Surveyfilter,60).isDisplayed()){
			Surveyfilter.click();
		}
	}
	catch(Exception ex) {
		log.error("SurveyFilter dropdown is not found");
	}
	try {
		pauseForTime(2000);
		if(waitForElement(DeletedSurvey,60).isDisplayed()){
			DeletedSurvey.click();
		}
	}
	catch(Exception ex) {
		log.error("DeletedSurvey filter option is not found");
	}
	try {
		pauseForTime(2000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("DeletedSurvey"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(3000);
		if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("DeletedSurvey"))){
				log.info("existing survey is successfully searched from DeletedSurveys list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing survey is not searched in DeletedSurveys list");
	   }
	try {pauseForTime(2000);
	   if(waitForElement(Dashboard,60).isDisplayed()){
		Dashboard.click();
	  }
   }
    catch(Exception ex) {
	log.error("dashboard tab is not found");
     }
	}
//PROCESS

if(isProcess) {
	try {
	   if(waitForElement(Process,60).isDisplayed()){
		Process.click();
	  }
     }
    catch(Exception ex) {
	log.error("Process option is not found");
    }
	try {
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("AllProcess"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
	
		if(waitForElement(Procrecord,60).isDisplayed()) {
			String text=Procrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("AllProcess"))){
				log.info("existing Process is successfully searched from All Process list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing Process is not searched in All Process list");
	    }
	
	try {
		   if(waitForElement(ProcessFilter,60).isDisplayed()){
			ProcessFilter.click();
		  }
	     }
	    catch(Exception ex) {
		log.error("ProcessFilter box  is not found");
	    }
	try {
		pauseForTime(1000);
		   if(waitForElement(MyProcess,60).isDisplayed()){
			MyProcess.click();
		  }
	     }
	    catch(Exception ex) {
		log.error("MyProcess filter option  is not found");
	    }
	try {
		pauseForTime(2000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("MyProcess"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(2000);
		if(waitForElement(Procrecord,60).isDisplayed()) {
			String text=Procrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("MyProcess"))){
				log.info("existing Process is successfully searched from My Process list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing Process is not searched in My Process list");
	    }
	try {
		   if(waitForElement(ProcessFilter,60).isDisplayed()){
			ProcessFilter.click();
		  }
	     }
	    catch(Exception ex) {
		log.error("ProcessFilter box  is not found");
	    }
	try {
		pauseForTime(3000);
		   if(waitForElement(DeletedProcess,60).isDisplayed()){
			DeletedProcess.click();
		  }
	     }
	    catch(Exception ex) {
		log.error("DeletedProcess filter option is not found");
	     }
	try {
		pauseForTime(1000);
		if(waitForElement(Searchbox,60).isDisplayed()) {
			Searchbox.clear();
			Searchbox.sendKeys(prop.getProperty("DeletedProcess"));
			Searchbox.sendKeys(Keys.ENTER);
	      }  
		}
	   catch(Exception ex) {
		log.error("Searchbox is not found");
	  }
	try {
		pauseForTime(2000);
		if(waitForElement(Procrecord,60).isDisplayed()) {
			String text=Procrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("DeletedProcess"))){
				log.info("existing Process is successfully searched from Deleted Process list");
			}}
		}
	   catch(Exception ex) {
		log.error("Existing Process is not searched in Deleted Process list");
	    }
	try {pauseForTime(2000);
	   if(waitForElement(Dashboard,60).isDisplayed()){
	 	Dashboard.click();
	      }
        }
      catch(Exception ex) {
	     log.error("dashboard tab is not found");
       }
       }

//USERS

if(isUsers) {
		try {pauseForTime(2000);
		   if(waitForElement(Users,60).isDisplayed()){
		 	Users.click();
		      }
	        }
	      catch(Exception ex) {
		     log.error("Users button is not found");
	       }
		try {
			if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("ActiveUser"));  
				Searchbox.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
		try {
			pauseForTime(2000);
			if(waitForElement(SearchedUser,60).isDisplayed()) {
				String text=SearchedUser.getText();
				log.info(text);
				if(text.contains(prop.getProperty("ActiveUser"))){
					log.info("existing User is successfully searched from Active User list");
				}}
			}
		   catch(Exception ex) {
			log.error("Existing user is not searched in Active User list");
		    }
		try {
			pauseForTime(1000);
			   if(waitForElement(UserFilter,60).isDisplayed()){
				UserFilter.click();
			  }
		     }
		    catch(Exception ex) {
			log.error("User filter option  is not found");
		    }
		try {
			pauseForTime(1000);
			if(waitForElement(InactiveUsers,60).isDisplayed()) {
				InactiveUsers.click();
		      }  
			}
		   catch(Exception ex) {
			log.error("InactiveUser filter option is not found");
		  }
		try {
			if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("InactiveUser"));  
				Searchbox.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
		try {
			pauseForTime(2000);
			if(waitForElement(SearchedUser,60).isDisplayed()) {
				String text=SearchedUser.getText();
				log.info(text);
				if(text.contains(prop.getProperty("InactiveUser"))){
					log.info("existing User is successfully searched from InActive User list");
				}}
			}
		   catch(Exception ex) {
			log.error("Existing user is not searched in InActive User list");
		    }
		try {
			pauseForTime(1000);
			   if(waitForElement(UserFilter,60).isDisplayed()){
				UserFilter.click();
			  }
		     }
		    catch(Exception ex) {
			log.error("User filter option  is not found");
		    }
		try {
			pauseForTime(1000);
			if(waitForElement(Allusers,60).isDisplayed()) {
				Allusers.click();
		      }  
			}
		   catch(Exception ex) {
			log.error("AllUser filter option is not found");
		  }
		try {
			if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("AllUser"));  
				Searchbox.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
		try {
			pauseForTime(2000);
			if(waitForElement(SearchedUser,60).isDisplayed()) {
				String text=SearchedUser.getText();
				log.info(text);
				if(text.contains(prop.getProperty("AllUser"))){
					log.info("existing User is successfully searched from All User list");
				}}
			}
		   catch(Exception ex) {
			log.error("Existing user is not searched in All User list");
		    }
		try {pauseForTime(2000);
		if(waitForElement(Dashboard,60).isDisplayed()){
			Dashboard.click();
		}
	   }
	catch(Exception ex) {
		log.error("dashboard tab is not found");
	   }
	 }

//STORE

if(isStores) {
		try {
			pauseForTime(1000);
			if(waitForElement(Stores,60).isDisplayed()) {
				Stores.click();
		      }  
			}
		   catch(Exception ex) {
			log.error("Store option is not found");
		  }
	  
	try {
		 if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("AllStore"));  
				Searchbox.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
		try {
			pauseForTime(2000);
			if(waitForElement(Modrecord,60).isDisplayed()) {
				String text=Modrecord.getText();
				log.info(text);
				if(text.contains(prop.getProperty("AllStore"))){
					log.info("Existing Store is successfully searched from All stores list");
				}}
			 }
		   catch(Exception ex) {
			log.error("Existing Store is not searched in All Store list");
		     }
		  try {
				if(waitForElement(StoreFilter,60).isDisplayed()) {
					StoreFilter.click();
			  }
				
			   }
		  catch(Exception ex) {
				log.error("Storefilter is not found");  
			    }
		  try {
				pauseForTime(1000);
				if(waitForElement(InactiveStores,60).isDisplayed()) {
					InactiveStores.click();
			      }  
				}
			   catch(Exception ex) {
				log.error("InactiveStore filter option is not found");
			  }
		  try {
				if(waitForElement(Searchbox,60).isDisplayed()) {
					Searchbox.clear();
					Searchbox.sendKeys(prop.getProperty("InactiveStore"));  
					Searchbox.sendKeys(Keys.ENTER);
			        }
				}
			   catch(Exception ex) {
				log.error("Searchbox is not found");
			  }
		  try {
				pauseForTime(2000);
				if(waitForElement(Modrecord,60).isDisplayed()) {
					String text=Modrecord.getText();
					log.info(text);
					if(text.contains(prop.getProperty("InactiveStore"))){
						log.info("Existing Store is successfully searched from Inactive stores list");
					}}
				 }
			   catch(Exception ex) {
				log.error("Existing Store is not searched in Inactive Store list");
			     }
		  try {
				if(waitForElement(StoreFilter,60).isDisplayed()) {
					StoreFilter.click();
			  }
				
			   }
		  catch(Exception ex) {
				log.error("Storefilter is not found");  
			    }
		  try {
				pauseForTime(1000);
				if(waitForElement(ActiveStore,60).isDisplayed()) {
					ActiveStore.click();
			      }  
				}
			   catch(Exception ex) {
				log.error("ActiveStore filter option is not found");
			  }
		  try {
				if(waitForElement(Searchbox,60).isDisplayed()) {
					Searchbox.clear();
					Searchbox.sendKeys(prop.getProperty("ActiveStore"));  
					Searchbox.sendKeys(Keys.ENTER);
			        }
				}
			   catch(Exception ex) {
				log.error("Searchbox is not found");
			  }
		  try {
				pauseForTime(2000);
				if(waitForElement(Modrecord,60).isDisplayed()) {
					String text=Modrecord.getText();
					log.info(text);
					if(text.contains(prop.getProperty("ActiveStore"))){
						log.info("Existing Store is successfully searched from active stores list");
					}}
				 }
			   catch(Exception ex) {
				log.error("Existing Store is not searched in active Store list");
			     }
               }
	   try {
			pauseForTime(2000);
		      if(waitForElement(Dashboard,60).isDisplayed()){
			Dashboard.click();
		    }
	        }
	         catch(Exception ex) {
		    log.error("dashboard tab is not found");
	        }
	
 //RESOURCE
	   
  if(isResource) {
		    try {
				pauseForTime(2000);
			      if(waitForElement(ManagePI,60).isDisplayed()){
				   ManagePI.click();
			     }
		        }
		         catch(Exception ex) {
			    log.error("ManagePI option is not found");
		        }
		    try {
				pauseForTime(2000);
			      if(waitForElement(Resources,60).isDisplayed()){
				   Resources.click();
			     }
		        }
		         catch(Exception ex) {
			    log.error("Resource option is not found");
		        }
	    try {
			if(waitForElement(Searchbox2,60).isDisplayed()) {
				Searchbox2.clear();
				Searchbox2.sendKeys(prop.getProperty("AllResource"));  
				Searchbox2.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
	/*    try {log.info("entered try block");
			if(waitForElement(Result,60).isDisplayed()) {
				log.info("required resource is successfully searched");
		        }
			}
		   catch(Exception ex) {
			log.error("Resource is not found");
		  }*/
  try {
	    	  if(waitForElement(tablelist, 60).isDisplayed()){
	    				log.info("identified table");
	    				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator ']")).size();
	    				log.info(rows);
	    				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator '] td:nth-child(1)")).size();
	    				log.info(name);
	    				for(int i=3;i<name;i++) {
	    			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
	    			    String s=driver.findElement(By.xpath(textPath)).getText();
	    			    if(s.contains(prop.getProperty("AllResource"))) {
	    			     log.info("Resource is searched from All resource list");
	    			     break;
	    			     }}
	    				}
	    				}catch(Exception ex) {
	    					log.error("Resource is not searched from All resource list");
	    				}
	    				
	   try {
			pauseForTime(2000);
		      if(waitForElement(Resourcefilter,60).isDisplayed()){
			   Resourcefilter.click();
		     }
	        }
	         catch(Exception ex) {
		    log.error("Resourcefilter option is not found");
	        }
	    try {
			pauseForTime(2000);
		      if(waitForElement(MyResource,60).isDisplayed()){
			   MyResource.click();
		     }
	        }
	         catch(Exception ex) {
		    log.error("MyResource option is not found");
	        }
	    try {
			if(waitForElement(Searchbox2,60).isDisplayed()) {
				Searchbox2.clear();
				Searchbox2.sendKeys(prop.getProperty("MyResource"));  
				Searchbox2.sendKeys(Keys.ENTER);
		        }
			}
		   catch(Exception ex) {
			log.error("Searchbox2 is not found");
			}
	    try {
	    	  if(waitForElement(tablelist, 60).isDisplayed()){
	    				log.info("identified table");
	    				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator ']")).size();
	    				log.info(rows);
	    				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator '] td:nth-child(1)")).size();
	    				log.info(name);
	    				for(int i=3;i<name;i++) {
	    			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
	    			    String s=driver.findElement(By.xpath(textPath)).getText();
	    			    if(s.contains(prop.getProperty("MyResource"))) {
	    			     log.info("Resource is searched from My resource list");
	    			     break;
	    			     }}
	    				}
	    				}catch(Exception ex) {
	    					log.error("Resource is not searched from My resource list");
	    				}
	    				
	    try {
	       pauseForTime(2000);
	      if(waitForElement(Dashboard,60).isDisplayed()){
		   Dashboard.click();
	        }
          }
       catch(Exception ex) {
	     log.error("dashboard tab is not found");
         }
  }
	  
  
  //ROLE
  
   if(isRole) {
	   try {
			pauseForTime(2000);
		      if(waitForElement(ManagePI,60).isDisplayed()){
			   ManagePI.click();
		     }
	        }
	         catch(Exception ex) {
		    log.error("ManagePI option is not found");
	        }
	   try {
			pauseForTime(2000);
		      if(waitForElement(Roles,60).isDisplayed()){
			   Roles.click();
		     }
	        }
	         catch(Exception ex) {
		    log.error("Role option is not found");
	        }
	   try {
			if(waitForElement(Rolesearchbox,60).isDisplayed()) {
				Rolesearchbox.clear();
				Rolesearchbox.sendKeys(prop.getProperty("AllRole"));  
				Rolesearchbox.sendKeys(Keys.ENTER);
		        }
			 }
		   catch(Exception ex) {
			log.error("Rolesearchbox is not found");
			}
	   try {
	    	  if(waitForElement(tablelist, 60).isDisplayed()){
	    				log.info("identified table");
	    				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator listHighlight']")).size();
	    				log.info(rows);
	    				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator listHighlight'] td:nth-child(1)")).size();
	    				log.info(name);
	    				for(int i=3;i<name;i++) {
	    			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
	    			    String s=driver.findElement(By.xpath(textPath)).getText();
	    			    if(s.contains(prop.getProperty("AllRole"))) {
	    			     log.info("Role is searched from All roles list");
	    			     break;
	    			     }}
	    				}
	    				}catch(Exception ex) {
	    					log.error("Role is not searched from All roles list");
	    				}
	   try {
	       pauseForTime(2000);
	      if(waitForElement(Dashboard,60).isDisplayed()){
		   Dashboard.click();
	        }
          }
       catch(Exception ex) {
	     log.error("dashboard tab is not found");
         }
	  }
   
   //MODULE REPORT
   
   if(isProgressReport) {
         try {
           pauseForTime(2000);
           if(waitForElement(Reports,60).isDisplayed()){
	       Reports.click();
         }
        }
       catch(Exception ex) {
           log.error("Report tab is not found");
         }
	   try {
		  if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("ReportTypeModule"));  
				Searchbox.sendKeys(Keys.ENTER);
			     }
				}
			   catch(Exception ex) {
				log.error("Searchbox is not found");
			  }
	  try {
		  pauseForTime(2000);
		  if(waitForElement(Modrecord,60).isDisplayed()) {
		   String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("ReportTypeModule"))){
			log.info("Existing progress report is successfully searched from Report type Module");
			}}
			 }
	catch(Exception ex) {
			log.error("Existing Progress report is not searched in Report type Module");
			     }
			 try {
		           pauseForTime(2000);
		           if(waitForElement(ProgressFilter,60).isDisplayed()){
			       ProgressFilter.click();
		         }
		        }
		       catch(Exception ex) {
		           log.error("Progress filter is not found");
		         }
			 try {
		           pauseForTime(2000);
		           if(waitForElement(Storeprogress,60).isDisplayed()){
		        	   Storeprogress.click();
		         }
		        }
		       catch(Exception ex) {
		           log.error("Store filter option is not found");
		         }
			 try {
				
				  if(waitForElement(Storesearch,60).isDisplayed()) {
					  Storesearch.clear();
					  Storesearch.sendKeys(prop.getProperty("ReportTypeStore"));  
					  Storesearch.sendKeys(Keys.ENTER);
					     }
						}
					   catch(Exception ex) {
						log.error("Searchbox is not found");
					  }
			 try {
			  	  if(waitForElement(tablelist, 60).isDisplayed()){
			  				log.info("identified table");
			  				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator']")).size();
			  				log.info(rows);
			  				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator'] td:nth-child(1)")).size();
			  				log.info(name);
			  				for(int i=3;i<name;i++) {
			  			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
			  			    String s=driver.findElement(By.xpath(textPath)).getText();
			  			    if(s.contains(prop.getProperty("ReportTypeStore"))) {
			  			     log.info("Store report is searched from Report Type Store list");
			  			     break;
			  			     }}
			  				}
			  				}catch(Exception ex) {
			  					log.error("Store report is not searched from Report Type Store list");
			  				}
					 try {
				           pauseForTime(2000);
				           if(waitForElement(ProgressFilter,60).isDisplayed()){
					       ProgressFilter.click();
				         }
				        }
				       catch(Exception ex) {
				           log.error("Progress filter is not found");
				         }
					 try {
				           pauseForTime(2000);
				           if(waitForElement(Userprogress,60).isDisplayed()){
					       Userprogress.click();
				         }
				        }
				       catch(Exception ex) {
				           log.error("User filter option is not found");
				         }
					 try {
						  if(waitForElement(Searchbox,60).isDisplayed()) {
								Searchbox.clear();
								Searchbox.sendKeys(prop.getProperty("ReportTypeUser"));  
								Searchbox.sendKeys(Keys.ENTER);
							     }
								}
							   catch(Exception ex) {
								log.error("Searchbox is not found");
							  }
							try {
								pauseForTime(2000);
								if(waitForElement(Modrecord,60).isDisplayed()) {
									String text=Modrecord.getText();
									log.info(text);
									if(text.contains(prop.getProperty("ReportTypeUser"))){
										log.info("Existing user report is successfully searched from Report type user");
									}}
								 }
							   catch(Exception ex) {
								log.error("Existing user report is not searched in Report type user");
							     }
					        try {
						           pauseForTime(2000);
						           if(waitForElement(ProgressFilter,60).isDisplayed()){
							       ProgressFilter.click();
						         }
						        }
						       catch(Exception ex) {
						           log.error("Progress filter is not found");
						         }
							 try {
						           pauseForTime(2000);
						           if(waitForElement(CityProgress,60).isDisplayed()){
						        	   CityProgress.click();
						         }
						        }
						       catch(Exception ex) {
						           log.error("City filter option is not found");
						         }
							 try {
								  if(waitForElement(Storesearch,60).isDisplayed()) {
									  Storesearch.clear();
									  Storesearch.sendKeys(prop.getProperty("ReportTypeCity"));  
									  Storesearch.sendKeys(Keys.ENTER);
									     }
										}
									   catch(Exception ex) {
										log.error("Searchbox is not found");
									  }
							 try {
							  	  if(waitForElement(tablelist, 60).isDisplayed()){
							  		log.info("identified table");
							  		int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator']")).size();
							  		log.info(rows);
							  		int name=tablelist.findElements(By.cssSelector("tr[class='list_separator'] td:nth-child(1)")).size();
							  		log.info(name);
							  		for(int i=3;i<name;i++) {
							  	    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
							  		String s=driver.findElement(By.xpath(textPath)).getText();
							  	    if(s.contains(prop.getProperty("ReportTypeCity"))) {
							  	    log.info("City report is searched from Report Type City list");
							  	     break;
							  		}}
							  		 }
							    }
							 catch(Exception ex) {
							  	    log.error("City report is not searched from Report Type City list");
							  		}
		                     try {
								   pauseForTime(2000);
								    if(waitForElement(ProgressFilter,60).isDisplayed()){
									ProgressFilter.click();
								   }
								    }
							catch(Exception ex) {
								 log.error("Progress filter is not found");
								  }
						    try {
								  pauseForTime(2000);
								  if(waitForElement(ResourceProgress,60).isDisplayed()){
								  ResourceProgress.click();
								 }
								  }
					     catch(Exception ex) {
								log.error("Resource filter option is not found");
								   }
					        try {
										  if(waitForElement(Storesearch,60).isDisplayed()) {
											  Storesearch.clear();
											  Storesearch.sendKeys(prop.getProperty("ReportTypeResource"));  
											  Storesearch.sendKeys(Keys.ENTER);
											     }
												}
											   catch(Exception ex) {
												log.error("Searchbox is not found");
											  }
									 try {
									  	  if(waitForElement(tablelist, 60).isDisplayed()){
									  		log.info("identified table");
									  		int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator']")).size();
									  		log.info(rows);
									  		int name=tablelist.findElements(By.cssSelector("tr[class='list_separator'] td:nth-child(1)")).size();
									  		log.info(name);
									  		for(int i=3;i<name;i++) {
									  	    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
									  		String s=driver.findElement(By.xpath(textPath)).getText();
									  	    if(s.contains(prop.getProperty("ReportTypeResource"))) {
									  	    log.info("Resource report is searched from Report Type Resource list");
									  	     break;
									  		}}
									  		 }
									    }
									 catch(Exception ex) {
									  	    log.error("Resource report is not searched from Report Type Resource list");
									  		}
				
		try {pauseForTime(2000);
				   if(waitForElement(Dashboard,60).isDisplayed()){
					Dashboard.click();
				  }
			   }
			    catch(Exception ex) {
				log.error("dashboard tab is not found");
			     }
	   }
   
  //SURVEY REPORT
   
 if(isSurveyReport) {
	   try {
           pauseForTime(2000);
           if(waitForElement(Surveyreport,60).isDisplayed()){
        	   Surveyreport.click();
         }
        }
       catch(Exception ex) {
           log.error("Survey  option is not found");
         }
	   
	   try {
           pauseForTime(2000);
           if(waitForElement(Surveyreport,60).isDisplayed()){
        	   Surveyreport.click();
         }
        }
       catch(Exception ex) {
           log.error("Survey  option is not found");
         }
	   try {
			if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("ActiveSurveyReport"));
				Searchbox.sendKeys(Keys.ENTER);
				}
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
	   try {
			pauseForTime(2000);
			if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("ActiveSurveyReport"))){
			log.info("Existing Survey report is successfully searched from Active survey report list");
			}}
		}
	 catch(Exception ex) {
	log.error("Existing Survey is not searched in Active survey report list");
	    }
	   try {
           if(waitForElement(SurveyFilter,60).isDisplayed()){
        	   SurveyFilter.click();
         }
        }
       catch(Exception ex) {
           log.error("Survey filter option is not found");
         }
	   try {
           pauseForTime(2000);
           if(waitForElement(AllsurveyReport,60).isDisplayed()){
        	   AllsurveyReport.click();
         }
        }
       catch(Exception ex) {
           log.error("AllsurveyReport filter option is not found");
         }
	   try {
			if(waitForElement(Searchbox,60).isDisplayed()) {
				Searchbox.clear();
				Searchbox.sendKeys(prop.getProperty("AllSurveyReport"));
				Searchbox.sendKeys(Keys.ENTER);
				}
			}
		   catch(Exception ex) {
			log.error("Searchbox is not found");
		  }
	   try {
			pauseForTime(2000);
			if(waitForElement(Modrecord,60).isDisplayed()) {
			String text=Modrecord.getText();
			log.info(text);
			if(text.contains(prop.getProperty("AllSurveyReport"))){
			log.info("Existing Survey report is successfully searched from All survey report list");
			}}
		}
		 catch(Exception ex) {
		log.error("Existing Survey is not searched in All survey report list");
		 }
	    }
 
 //PROCESS
 
 if(isProcessReport) {
	 try {
         if(waitForElement(ProcessReport,60).isDisplayed()){
      	   ProcessReport.click();
       }
      }
     catch(Exception ex) {
         log.error("Process report option is not found");
       }
    try {
         if(waitForElement(ProcessSearchbox,60).isDisplayed()){
      	   ProcessSearchbox.clear();
       	 ProcessSearchbox.sendKeys(prop.getProperty("ActiveProcessReport"));
      	ProcessSearchbox.sendKeys(Keys.ENTER);
       }
      }
     catch(Exception ex) {
         log.error("Process Searchbox is not found");
       }
    try {
  	  if(waitForElement(tablelist, 60).isDisplayed()){
  				log.info("identified table");
  				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator']")).size();
  				log.info(rows);
  				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator'] td:nth-child(1)")).size();
  				log.info(name);
  				for(int i=3;i<name;i++) {
  			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
  			    String s=driver.findElement(By.xpath(textPath)).getText();
  			    if(s.contains(prop.getProperty("ActiveProcessReport"))) {
  			     log.info("process is searched from Active process report");
  			     break;
  			     }}
  				}
  				}catch(Exception ex) {
  					log.error("process is not searched from Active process list");
  				}
  				
	try {
         if(waitForElement(SurveyFilter,60).isDisplayed()){
      	   SurveyFilter.click();
       }
      }
     catch(Exception ex) {
         log.error("Survey filter option is not found");
       }
	   try {
         pauseForTime(2000);
         if(waitForElement(Allprocessfilter,60).isDisplayed()){
        	 Allprocessfilter.click();
       }
      }
     catch(Exception ex) {
         log.error("Allprocessfilter filter option is not found");
       }
	   try {
	         if(waitForElement(ProcessSearchbox,60).isDisplayed()){
	      	   ProcessSearchbox.clear();
	      	 ProcessSearchbox.sendKeys(prop.getProperty("AllProcessReport"));
	      	ProcessSearchbox.sendKeys(Keys.ENTER);
	       }
	      }
	     catch(Exception ex) {
	         log.error("Process Searchbox is not found");
	       }
	   try {
	  if(waitForElement(tablelist, 60).isDisplayed()){
				log.info("identified table");
				int rows=tablelist.findElements(By.cssSelector("tr[class='list_separator']")).size();
				log.info(rows);
				int name=tablelist.findElements(By.cssSelector("tr[class='list_separator'] td:nth-child(1)")).size();
				log.info(name);
				for(int i=3;i<name;i++) {
			    String textPath = "/html[1]/body[1]/div[11]/div[2]/div[3]/table[2]/tbody[1]/tr[" + String.valueOf(i) + "]/td[1]";
			    String s=driver.findElement(By.xpath(textPath)).getText();
			    if(s.contains(prop.getProperty("AllProcessReport"))) {
			     log.info("process is searched from All process report");
			     break;
			     }}
				}
				}catch(Exception ex) {
					log.error("process is not searched from all process list");
				}
 }
				

 //Talk

 if(isTalk) {
	 try {
	 if(waitForElement(Talk,60).isDisplayed()){
		 Talk.click();
		 }
	 }
	 catch(Exception ex) {
		 log.info("talk icon is not identified");
	 }
	 try {
		 pauseForTime(1000);
		 if(waitForElement(SearchIcon,60).isDisplayed()){
			 SearchIcon.click();
			 }
		 }
		 catch(Exception ex) {
			 log.info("Search icon is not identified");
		 }
	 try {
		 if(waitForElement(Searchfield,60).isDisplayed()){
			 Searchfield.sendKeys(prop.getProperty("Talksearch"));
			 Searchfield.sendKeys(Keys.ENTER);
			 }
		 }
		 catch(Exception ex) {
			 log.info("Search field is not identified");
		 }
	 try {
		 if(waitForElement(matchingtalks,60).isDisplayed()){
			 log.info("hi");
			 String matchedtext=matchingtalks.getText();
			 if(matchedtext.contains(prop.getProperty("Talksearch")))	{
				 log.info("talk is successfully searched");
				 }
			 }
		 
		 }
		 catch(Exception ex) {
			 log.info("Search field is not identified");
		 }
	 
		 
		 
}
	
 
 return driver;
           
      
}
}
	
