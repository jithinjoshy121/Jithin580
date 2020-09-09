package tests;

import org.testng.annotations.Test;

import data.DataFile;
import utilities.Xls_Reader;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	

	LoginPage lp=new LoginPage();
	DataFile df=new DataFile();
	
    
    

	@Test
	public void loginWithWrongPasswordTest() throws InterruptedException {
		lp.enterEmail(df.correctEmail);
		
		lp.enterPassword(df.wrongPassword);
		//String msg = lp.readPasswordError();
		Assert.assertEquals(df.passwdErrMsg, lp.readPasswordError());
	}
  
  @Test
  public void loginWithWrongEmailTest() throws InterruptedException 
  {
	  lp.enterEmail(df.wrongEmail);
   
	  //String msg = lp.readEmailError();
	  Assert.assertEquals(df.emailErrMsg, lp.readEmailError());
  }
  
  @Test
  public void loginWithEmptyEmailTest() throws InterruptedException 
  {
	  lp.enterEmail(df.emptyEmail);
   
		//String msg=lp.readEmailError();
		Assert.assertEquals(df.emailErrMsg, lp.readEmailError());
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	lp.openBrowser();
		lp.openYahoo();

  }

  @AfterMethod
  public void afterMethod() {
	 lp.closeBrowser();
  }

}
