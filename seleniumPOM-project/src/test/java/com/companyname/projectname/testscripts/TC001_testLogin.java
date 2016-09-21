package com.companyname.projectname.testscripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.companyname.projectname.pagelibrary.SignIn;
import com.companyname.projectname.report.ReportUtil;
import com.companyname.projectname.testbase.TestBase;

public class TC001_testLogin extends TestBase{
	SignIn signIn;

	
	
	@BeforeClass
	public void setUP() throws IOException{
		init();
	}
	
	@Test
	public void testlogin() throws InterruptedException, IOException{
		
		
		String TCStatus = "Pass";
		try{
			signIn = new SignIn(driver);
			signIn.loginToApplication();
			Thread.sleep(3000);
		}
		catch(Exception e){
			// take the screenshot
			String filename = "testlogin";
			TestBase.getScreenShot(filename);
			
			TCStatus = "Fail";
			// report error
			ReportUtil.addKeyword("Test Login Failed", "keyword", TCStatus, "screenshots/"+filename+".jpg");
			String endTime = TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa");
			ReportUtil.addTestCase("Login Test", startTime, endTime, TCStatus);
			
		}
		//ReportUtil.addKeyword("Test Login Pass", "keyword", "PASS", null);
		String endTime = TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa");
		ReportUtil.addTestCase("Login Test", startTime, endTime, TCStatus);
		updateResult(indexSI++, "Login Test", "Pass", "Login Test");
		ReportUtil.endSuite();
		//ReportUtil.updateEndTime(TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa"));
		
	}
	
	@AfterClass
	public void quitBrowser(){
		closeBrowser();
	}

}
