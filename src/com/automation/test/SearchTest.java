package com.automation.test;

import static com.automation.common.Utilities.driver;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.common.TestDataInput;
import com.automation.common.Utilities;
import com.automation.platform.Login;
import com.automation.platform.Search;

public class SearchTest {
	static Logger log=Logger.getLogger(SearchTest.class);
	TestDataInput set=new TestDataInput();
	Utilities utily=new Utilities();
	
	@BeforeTest
    public void setUp() {
	DOMConfigurator.configure("log4j.xml");
	set.setSystemFileName("tuto.properties");
	set.loadProperties();
    utily.initDriver();
    Login login = new Login(driver);
    login.login("PRODUCER");
	}
	
	@Test
	public void ProducersideSearch() throws IOException
	{
		Search search=new Search(driver);
		search.ProdsideSearch(false,false,false,false,false,false,false,true,true,true,true,true);
	}

  }

