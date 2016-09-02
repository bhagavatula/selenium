package com.companyname.projectname.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.testbase.TestBase;

public class TC001_testLogin extends TestBase{
	SignIn signIn;
	
	@BeforeClass
	public void setUP() throws IOException{
		init();
	}
	
	@Test
	public void testlogin() throws InterruptedException{
		signIn = new SignIn(driver);
		signIn.loginToApplication();
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
