package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
 


public class TC003_Login_And_Test_Home_Page extends ParentClass
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
		   utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	  }
	  
	  	  @Test(priority = 1)
	  public void Login_And_Onboard()
	  {
		  TC52_Login_And_Verify_HomePage_Workflow.getStartedPage(getStarted -> {
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
		  });
	  }
	  
		@Test(priority = 2)
		public void Verify_Home_UI_Page() {
			SoftAssert softhome2 = new SoftAssert();
			softhome2.assertTrue(new HomePage().verifyUIOnHomePage());
			softhome2.assertAll();
		}
		
		@Test(priority = 3)
		public void Verify_Home_Device_Signal_Strength_Navigation() {
			SoftAssert softhome3 = new SoftAssert();
			softhome3.assertTrue(new HomePage().clickDeviceSignalStrengthImage());
			if(new HomePage().getDeviceSignalStrengthPageObject().isAt())
				softhome3.assertTrue(new HomePage().getDeviceSignalStrengthPageObject().clickCloseIcon());
			softhome3.assertAll();
		}
		
		@Test(priority = 4)
		public void Verify_Home_Speed_Test_History_Navigation() {
			SoftAssert softhome4 = new SoftAssert();
			softhome4.assertTrue(new HomePage().clickSpeedTestHistoryImage());
			if(new HomePage().getBlankSpeedTestHistoryPageObject().isAt())
				softhome4.assertTrue(new HomePage().getBlankSpeedTestHistoryPageObject().clickCloseIcon());
			softhome4.assertAll();
		}
		
		@Test(priority = 5)
		public void Verify_Home_Currently_Blocked_Devices__Navigation() {
			SoftAssert softhome5 = new SoftAssert();
			softhome5.assertTrue(new HomePage().clickCurrentlyBlockedDevicesImage());
			if(new HomePage().getBlankBlockedDevicesPageObject().isAt())
				softhome5.assertTrue(new HomePage().getBlankBlockedDevicesPageObject().clickCloseIcon());
			softhome5.assertAll();
		}
		
		@Test(priority = 6)
		public void Verify_Home_Main_Devices_Navigation() {
			SoftAssert softhome6 = new SoftAssert();
			softhome6.assertTrue(new HomePage().clickMainDeviceImage());
			if(new HomePage().getMainDeviceAllTabPageObject().isAt())
				softhome6.assertTrue(new HomePage().getMainDeviceAllTabPageObject().clickBackButton());
			softhome6.assertAll();
		}
		
		@Test(priority = 7)
		public void Verify_Home_Total_Devices_Navigation() {
			SoftAssert softhome7 = new SoftAssert();
			softhome7.assertTrue(new HomePage().clickDevicesImage());
			if(new HomePage().getDevicesPageObject().isAt())
				softhome7.assertTrue(new HomePage().getDevicesPageObject().clickBackButton());
			softhome7.assertAll();
		}
		
		@Test(priority = 8)
		public void Verify_Home_Hamburger_Navigation() {
			SoftAssert softhome8 = new SoftAssert();
			softhome8.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt())
				softhome8.assertTrue(new HomePage().getHamburgerMenuPageObject().clickCloseButton());
			softhome8.assertAll();
		}
		
		@Test(priority = 9)
		public void Verify_Home_Notifications_Navigation() {
			SoftAssert softhome9= new SoftAssert();
			softhome9.assertTrue(new HomePage().clickNotificationsIcon());
			if(new HomePage().getNotificationPageObject().isAt())
				softhome9.assertTrue(new HomePage().getNotificationPageObject().clickBackButton());
			softhome9.assertAll();
		}
}
//			  if(home.isAt())
//			  {
//			  	home.verifyUIOnHomePage();
//			  	
//			  	home.clickDeviceSignalStrengthImage();
//			  	if(home.getDeviceSignalStrengthPageObject().isAt())
//			  	{
//			  		home.getDeviceSignalStrengthPageObject().clickCloseIcon();
//			  	}
//			  	home.clickSpeedTestHistoryImage();
//			    if(home.getBlankSpeedTestHistoryPageObject().isAt())
//			    {
//				   home.getBlankSpeedTestHistoryPageObject().clickCloseIcon();
//			    }
//			  	home.clickCurrentlyBlockedDevicesImage();
//			  	if(home.getBlankBlockedDevicesPageObject().isAt())
//			  	{
//			  		home.getBlankBlockedDevicesPageObject().clickCloseIcon();
//			  	}
//			  }
//		  });
//	  }
//}
				 
				 
				 

//				 totalCountOfDevices = home.getTotalCountOfDevices();
//				 utils.log().info("Total Number of Devices connected are : " + totalCountOfDevices);
//				 
//				 countOfDeviceSignalStrength = home.getBitRateDevices();
//				 utils.log().info("Count of Devices Signal Strength : " + countOfDeviceSignalStrength);
//				 
//				 countOfDevicesSpeedHistory = home.getSpeedTestDevices();
//				 utils.log().info("Count of Devices Speed Test History : " + countOfDevicesSpeedHistory);
//				 //add count of blocked devices here.  Deferred
				 
//				 Assert.assertEquals(home.getHomeTitleText(), getStrings().get("home_page_title"));
//				 utils.log().info("Verified Home Page Title Text : " + home.getHomeTitleText());
//				 
//				 Assert.assertEquals(home.getNetworkSpeedText(), getStrings().get("home_page_text"));
//				 utils.log().info("Verified Home Page Network Speed Text : " + home.getNetworkSpeedText());
//				 
//				 Assert.assertEquals(home.getDownloadText(), getStrings().get("home_page_download"));
//				 utils.log().info("Verified Home Page Download Text : " + home.getDownloadText());
//				 
//				 Assert.assertEquals(home.getUploadText(), getStrings().get("home_page_upload"));
//				 utils.log().info("Verified Home Page Upload Text : " + home.getUploadText());
//				 
//				 Assert.assertEquals(home.getMainDeviceName(), getStrings().get("home_page_main"));	
//				 utils.log().info("Verified Home Page Main Device Name : " + home.getMainDeviceName());
//				 
//				 Assert.assertEquals(home.getDeviceSignalStrengthLeaderBoardText(), getStrings().get("home_page_leader_board"));
//				 utils.log().info("Verified Home Page Device Signal Strength Leader Board Text : " + home.getDeviceSignalStrengthLeaderBoardText());
//				 
//				 Assert.assertEquals(home.getSpeedTestHistoryText(), getStrings().get("home_page_speed_test_history"));
//				 utils.log().info("Verified Home Page Speed Test History Text : " + home.getSpeedTestHistoryText());
//				 
////				 Assert.assertEquals(home.getCurrentlyBlockedDevicesText(), getStrings().get("home_page_blocked_devices"));
//				 Assert.assertEquals(home.getHomeButtonText(), getStrings().get("home_page_home_button"));
//				 utils.log().info("Verified Home Page Home Button Text : " + home.getHomeButtonText());
//				 
//				 Assert.assertEquals(home.getNetworkButtonText(), getStrings().get("home_page_network_button"));
//				 utils.log().info("Verified Home Page Network Button Text : " + home.getNetworkButtonText());
//				 
//				 Assert.assertEquals(home.getParentalButtonText(), getStrings().get("home_page_parental"));
//				 utils.log().info("Verified Home Page Parental Button Text : " + home.getParentalButtonText());


