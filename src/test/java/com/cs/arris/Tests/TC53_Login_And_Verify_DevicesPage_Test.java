package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

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
 


public class TC53_Login_And_Verify_DevicesPage_Test extends ParentClass
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
	  public void Verify_DevicesPage()
	  {
		  TC53_Login_And_Verify_DevicesPage_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  super.pause(3);
			  accessResoucesOnDevice.clickAllowLink();
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
			  super.pause(3);
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
				  super.pause(3);
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
				 home.clickDevicesImage();
			 }
		  }).devicesPage(devices -> {
			 if(devices.isAt())
			 {
				 devices.verifyUIOnDevicesPage();
				 devices.clickBackButton();
				 if (devices.getHomePageObject().isAt())
				 {
					 devices.getHomePageObject().clickDevicesImage();
				 }
			 }
//			 if(devices.isAt())
//			 {
//				 devices.clickHelpButton();
//				 super.pause(5);
//				 if (devices.getDevicesHelpPageObject().isAt())
//				 {
//					 devices.getDevicesHelpPageObject().verifyHelpText();
//					 devices.clickCloseButton();
//				 }
//			 }
			 if(devices.isAt())
			 {
				 devices.getTotalCountOfDevices();		 
				 if (devices.getOnlineDeviceCount() > 0)
				 {
					 devices.verifyOnlineDeviceDetails();
				 }
				 if (devices.getOfflineDeviceCount() > 0)
				 {
					 devices.verifyOfflineDeviceDetails();
				 }
			 }
			 if(devices.isAt())
			 {
				 devices.getFooterIconsPageObject().clickHomeButton();
				 if (devices.getHomePageObject().isAt())
				 {
					 devices.getHomePageObject().clickDevicesImage();
				 }
			 }
			 if(devices.isAt())
			 {
				 devices.getFooterIconsPageObject().clickNetworkButton();
				 if (devices.getNetworkPageObject().isAt())
				 {
					 devices.getNetworkPageObject().clickBackButton(); //Change this to clickBackIcon() which will go to HomePage instead of Devices page
				 }
			 }
			 if(devices.getHomePageObject().isAt())
			 {
				 devices.getHomePageObject().clickDevicesImage();
			 }
//			 if(devices.isAt())
//			 {
//				 devices.getFooterIconsPageObject().clickParentalButton();
//				 if (devices.getParentalControlPageObject().isAt())
//				 {
//					 devices.getParentalControlPageObject().clickBackButton(); 
//				 }
//			 }

		  });
	  }
}