package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC55_Login_And_Verify_HomeSpeedTestHistoryPage_Workflow;
 


public class TC55_Login_And_Verify_HomeSpeedTestHistoryPage_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String countOfDeviceSignalStrength;
	String countOfDevicesSpeedHistory;
	String countOfDevicesBlocked;
	String downloadSpeed;
	String uploadSpeed;
	int totalCountOfDevices;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  
			  this.firstName = properties.getProperty("firstname");
			  utils.log().info("First Name : " + this.firstName);

			  this.lastName = properties.getProperty("lastname");
			  utils.log().info("Last Name : " + this.lastName);
			  
			  this.email = properties.getProperty("email");
			  utils.log().info("Email address : " + this.email);
			  
			  this.udid = properties.getProperty("udid");
			  utils.log().info("UDID : " + this.udid);
			  
			  utils.log().info("Retrieved...Sign Up Test Data");
			} catch(Exception e) {
			 e.printStackTrace();
		} 
     }
	
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		   utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  
	  @Test(priority = 1)
	  public void Verify_Home_Speed_Test_History_Page()
	  {
		  TC55_Login_And_Verify_HomeSpeedTestHistoryPage_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickAllowLink();
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
		  }).welcomeSigninPage(signin -> {
			  signin.enterEmailAddress(email);
			  signin.clickSigninButton();
			  super.pause(12);
		  }).getOTPCode(getOTP -> {
			  passCode = getOTP.getValidOTP();
	  		}).enterOTPPage(otpverify -> {
			  otpverify.enterValidPassCode(passCode);
	  		 }).codeVerifiedPage(codeVerified -> {
				  codeVerified.getCodeVerifiedText();
				  codeVerified.clickNextButton();
				  super.pause(3);
				  try
				  {
					  if(codeVerified.continueOnBoardingButton.isDisplayed())
					  {
						  codeVerified.clickContinueOnboardingButton();
					  }
				  }catch(Exception e)
				  {
					  e.getMessage();
				  }
			  }).setupWifi(setupwifi ->{
				  setupwifi.clickskipTutorialButton();
	  		}).homePage(home -> {
			  try
			  {
				  if(home.okButton.isDisplayed())
				  {
					  home.clickOkButton();
				  }
			  }catch(Exception e)
			  {
				  e.getMessage();
			  }
			 if(home.isAt())
			 {
				 super.pause(2);
				 home.clickNavigationButton();
				 if(home.getHamburgerMenuPageObject().isAt())
				 {
					 if(home.getHamburgerMenuPageObject().speedTest.isDisplayed())
					{
						home.getHamburgerMenuPageObject().clickSpeedTestButton();
					}else {utils.log().info("Speed Test Option is not available on Hamburger Menu");}
				 }
			 }
			 }).speedTestPage(speedTest -> {
				 if(speedTest.isAt())
				 {
					 speedTest.verifyUIOnSpeedTestPage();
					 
					 for (int i = 0; i < 3; i++)
					 {
						 speedTest.performSpeedTest();
					 }
					 speedTest.clickBackIcon();
				 }
			 }).homePage(home -> {
				 if(home.isAt())
				 {
					 home.clickSpeedTestHistoryImage();
				 }
	  		}).homeSpeedTestHistoryPage(speedTestHistory -> {
	  			if(speedTestHistory.isAt())
	  			{
	  				speedTestHistory.verifyHomeSpeedTestHistory();
	  				speedTestHistory.getFooterIconsPageObject().clickNetworkButton();
	  				if (speedTestHistory.getNetworkPageObject().isAt())
	  				{
	  					speedTestHistory.getNetworkPageObject().clickBackButton(); 
	  				}
	  			}
	  			if(speedTestHistory.getHomePageObject().isAt())
	  			{
	  				speedTestHistory.getHomePageObject().clickSpeedTestHistoryImage();
	  			}
	  			if(speedTestHistory.isAt())
	  			{
	  				speedTestHistory.getFooterIconsPageObject().clickParentalButton();
	  				if (speedTestHistory.getParentalControlPageObject().isAt())
	  					{
	  						speedTestHistory.getParentalControlPageObject().clickBackButton();
	  					}
	  			}
		  });
	  }
}