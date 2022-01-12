package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
import com.cs.arris.Pages.AppRatingDialog;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
 


public class TC03_Complex_Test extends ParentClass
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
	
	//Parental Control
	public TC010_Login_And_Test_Parental_Control_Page getParentalControlPageTestObject() {
		TC010_Login_And_Test_Parental_Control_Page parentalPageTest = new TC010_Login_And_Test_Parental_Control_Page();
		return parentalPageTest;
	}
	
	//Network
	public TC011_Login_And_Test_Network_Page getNetworkTestObject() {
		TC011_Login_And_Test_Network_Page networkPageTest = new TC011_Login_And_Test_Network_Page();
		return networkPageTest;
	}
	
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
//		  TC52_Login_And_Verify_HomePage_Workflow.getStartedPage(getStarted -> {
//			  getStarted.clickGetStartedButton();
//		  }).grantPermissionsPage(grantPermission -> {
//			  grantPermission.clickContinueButton();
//		  }).deviceLocationPage(deviceLocation -> {
//			  deviceLocation.clickOnlyThisTimeLink();
//		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			  super.pause(3);
//			  accessResoucesOnDevice.clickAllowLink();
//		  }).selectYourDevicePage(selectDevice -> {
//			  selectDevice.selectSurfboardMaxOption();
//			  selectDevice.clickNextButton();
//		  }).selectYourDevicePage2(selectDevice2 -> {
//			  selectDevice2.selectMaxProAX11000RadioButton();
//			  selectDevice2.clickNextButton();
//			  super.pause(3);
//		  }).welcomeSigninPage(signin -> {
//			  signin.enterEmailAddress(email);
//			  signin.clickSigninButton();
//			  super.pause(12);
//		  }).getOTPCode(getOTP -> {
//			  passCode = getOTP.getValidOTP();
//	  		}).enterOTPPage(otpverify -> {
//			  otpverify.enterValidPassCode(passCode);
//	  		 }).codeVerifiedPage(codeVerified -> {
//				  codeVerified.getCodeVerifiedText();
//				  codeVerified.clickNextButton();
//				  super.pause(3);
//				  try
//				  {
//					  if(codeVerified.continueOnBoardingButton.isDisplayed())
//					  {
//						  codeVerified.clickContinueOnboardingButton();
//					  }
//				  }catch(Exception e)
//				  {
//					  e.getMessage();
//				  }
//			  }).setupWifi(setupwifi ->{
//				  setupwifi.clickskipTutorialButton();
//				  super.pause(3);
//		  }).homePage(home -> {
//			  try
//			  {
//				  if(home.okButton.isDisplayed())
//				  {
//					  home.clickOkButton();
//				  }
//			  }catch(Exception e)
//			  {
//				  e.getMessage();
//			  }
//		  });
	  }
	  
	  @Test(priority = 2, dependsOnMethods = {"Login_And_Onboard" })
		public void Verify_Parental_Control_UI_Page() {
			SoftAssert softcontrol2 = new SoftAssert();
			AssertJUnit.assertTrue(new HomePage().getFooterIconsPageObject().clickParentalButton());
			if(new ParentalControlWithProfilesPage().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().verifyUIOnParentalControlProfilesPage());
			softcontrol2.assertAll();
		}
		
		@Test(priority = 3, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Add_Profile_Page() {
			SoftAssert softcontrol3 = new SoftAssert();
			
			if(new ParentalControlWithProfilesPage().isAt())
			try {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().enableParentalControl());	
				super.pause(2);
				if(new ParentalControlWithProfilesPage().getAppRatingDialogObject().isAt())
					AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAppRatingDialogObject().clickRemindMeLaterLink());
			}catch(Exception e) {utils.log().info("App Rating Dialog did not appear");}
			super.pause(5);
			
			if(new ParentalControlWithProfilesPage().isAt()) {
				for(int i = 1; i <= 4; i++)	{
					AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
					super.pause(2);
					AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
					super.pause(2);
					AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
					super.pause(3);
					
					try {
						if(new ParentalControlWithProfilesPage().getAddProfileDialogObject().profileNameExists.isDisplayed())
							AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCloseIcon());
						if(i == 4)
						{
							AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
							super.pause(2);
							AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
							super.pause(2);
							AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
							super.pause(3);
						}
					}catch(Exception e) {}
				}
			}
			
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().deleteUserProfile());
			super.pause(5);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().verifyUIForGlobalSettingsOnProfilesPage());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().verifyUserProfile());
			
			softcontrol3.assertAll();
		}
		
		@Test(priority = 4, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_User_Profile_Page() {
			SoftAssert softcontrol4 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickOnUserProfile());
			super.pause(5);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyUIOnUserProfilePage());
			
			softcontrol4.assertAll();
		}
		
		@Test(priority = 5, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_User_Profile_Help_Page() {
			SoftAssert softcontrol5 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickHelpIcon());
			super.pause(3);
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().isAt()){
				//softcontrol5.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().verifyUIOnUserProfilePage());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().clickCloseButton());
			}
			
			softcontrol5.assertAll();
		}
		
		@Test(priority = 6, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Edit_User_Profile_Name() {
			SoftAssert softcontrol6 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getExistingUserName());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickUserProfileNameEditButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt()){
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().verifyUIOnEditUserProfileDialog());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton());
				super.pause(3);
			}
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().validateUserProfileEditedName());
			softcontrol6.assertAll();
		}
		
		@Test(priority = 7, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Device_To_User_Profile() {
			SoftAssert softcontrol7 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
			super.pause(25);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDevicesInAddDevicePage());
				
				utils.log().info("Clicking on Add Device button without selecting any device");
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				
				if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.isDisplayed()) {
					utils.log().info("An Alert message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.getText()+ "  is displayed");
					//softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickCloseButtonOnAlertDialog());	
				}
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				super.pause(5);
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
				super.pause(25);
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				super.pause(5);
				//softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDeviceCountAfterAssociatingToUser());
			}
			
			softcontrol7.assertAll();
		}
		
		@Test(priority = 8, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Add_Device_Help_Page() {
			SoftAssert softcontrol8 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
			super.pause(25);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickHelpIcon());
			
			if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().isAt()) 
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickBackButton());
			super.pause(5);
			softcontrol8.assertAll();
		}
		
		@Test(priority = 9, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Devices_Associated_With_User_Profile() {
			SoftAssert softcontrol9 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickDeviceListExpandButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyAssociatedDeviceList());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().deleteAssociatedDevice());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickDeviceListExpandButton());
			
			softcontrol9.assertAll();
		}
		
		@Test(priority = 10, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Rule_Help_Page() {
			SoftAssert softcontrol10 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddRuleLink());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickHelpIcon());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getParentalAddRuleHelpPageObject().clickCloseButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());}
				
			softcontrol10.assertAll();
		}
		
		@Test(priority = 11, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_EveryDay_Schedule_To_Rule() {
			SoftAssert softcontrol11 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) 
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnAddInternetBlockingScheduleDialog());
			
			utils.log().info("                                  ");
			utils.log().info("Selecting same start and stop time");
			utils.log().info("----------------------------------");
			
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.isDisplayed()) 
				utils.log().info("Alert dialog with message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.getText() + " - is displayed");
			
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCloseButton());

			softcontrol11.assertAll();
		}
		
		@Test(priority = 12, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Select_Start_Time_For_EveryDay_Schedule() {
			SoftAssert softcontrol12 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) 
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickEveryDayButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());}
			
			softcontrol12.assertAll();
		}
		
		@Test(priority = 13, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Select_Stop_Time_For_EveryDay_Schedule() {
			SoftAssert softcontrol13 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().selectMinutes());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			super.pause(3);

			softcontrol13.assertAll();
		}
		
		@Test(priority = 14, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})  
		public void Verify_Add_Custom_Schedule_To_Rule() {
			SoftAssert softcontrol14 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCustomButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnCustomClick());	}

			softcontrol14.assertAll();
		}
		
		@Test(priority = 15, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_DOW() {
			SoftAssert softcontrol15 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSunday());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickTuesday());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickThrusday());

			softcontrol15.assertAll();
			}
		
		@Test(priority = 16, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_Start_Time() {
			SoftAssert softcontrol16 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			softcontrol16.assertAll();
			}
		
		@Test(priority = 17, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_Stop_Time() {
			SoftAssert softcontrol17 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().selectMinutes());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			super.pause(3);
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			super.pause(3);
			
			softcontrol17.assertAll();
		}
		
		@Test(priority = 18, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Enable_Schedule_Time_UI_Page() {
			SoftAssert softcontrol18 = new SoftAssert();

		//	new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().verifyUIonEnableScheduleTimePage();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickBackButton());
			super.pause(5);
			softcontrol18.assertAll();
		}
		
		@Test(priority = 19, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Delete_Rules_Associated_With_User() {
			SoftAssert softcontrol19 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
			//softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyRulesAssociatedWithUser());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().deleteAssociatedRulesList());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickBackButton());
			
			softcontrol19.assertAll();
		}
		
//		@Test(priority = 20, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
//		public void Verify_Pause_Internet_For_Selected_Users() {
//			SoftAssert softcontrol20 = new SoftAssert();
//			if(new ParentalControlWithProfilesPage().isAt()) 
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().pauseInternetForSelectedUsers());
//			
//			softcontrol20.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
//
//			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//			}
//
//			softcontrol20.assertAll();
//		}
//		
//		@Test(priority = 21, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
//		public void Verify_Resume_Internet_For_Selected_Users() {
//			SoftAssert softcontrol21 = new SoftAssert();
//			
//			if(new ParentalControlWithProfilesPage().isAt()) 
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().resumeInternetForSelectedUsers());
//			
//			softcontrol21.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
//
//			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//			}
//			softcontrol21.assertAll();
//		}
		
		@Test(priority = 22, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Pause_Internet_For_All_Users() {
			SoftAssert softcontrol20 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickGlobalSettingExpandButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().enablePauseAllProfiles());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickYesPauseInternetButton());
				super.pause(5);
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().verifyPauseInternetAccessForAllUserProfile());
			}
			softcontrol20.assertAll();
		}
		
		@Test(priority = 23, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Currently_Blocked_Profiles() {
			SoftAssert softcontrol21 = new SoftAssert();
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());

			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
			}
			softcontrol21.assertAll();
		}
		
		@Test(priority = 24, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Resume_Internet_For_All_Users() {
			SoftAssert softcontrol22 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().disablePauseAllProfiles());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickYesResumeInternetButton());
//				softcontrol22.assertTrue(new ParentalControlWithProfilesPage().verifyResumeInternetAccessForAllUserProfile());
			}
			softcontrol22.assertAll();
		}
		
		@Test(priority = 25, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Currently_Blocked_Users_After_Resuming_Internet_For_All_Users() {
			SoftAssert softcontrol23 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
			
			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyNoBlockedProfileMessages());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickGlobalSettingExpandButton());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().disableParentalControl());
			}
			softcontrol23.assertAll();
		}
		
		@Test(priority = 26, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Parental_Control_Help_Page() {
			SoftAssert softcontrol24 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickHelpIcon());
			super.pause(3);
				
			if(new ParentalControlWithProfilesPage().getParentalHelpPageObject().isAt()) {
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalHelpPageObject().clickCloseButton());
				super.pause(3);
			}
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getFooterIconsPageObject().clickHomeButton());

			softcontrol24.assertAll();
		}	
			
		
	  
		@Test(priority = 27, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Network_UI_Page() {
			utils.log().info("                     ");
			utils.log().info("*********************");
			utils.log().info("Test: Network Page   ");
			utils.log().info("*********************");
			SoftAssert softnet2 = new SoftAssert();
			AssertJUnit.assertTrue(new HomePage().getFooterIconsPageObject().clickNetworkButton());
			AssertJUnit.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
			AssertJUnit.assertTrue(new NetworkPage().verifyUIOnNetworkPage());
			softnet2.assertAll();
		}

		@Test(priority = 28, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Newtork_Help_Page() {
			SoftAssert softnet3 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().clickHelpButton());
			AssertJUnit.assertTrue(new NetworkPage().getNetworkHelpPageObject().clickCloseButton());
			softnet3.assertAll();
		}

		@Test(priority = 29, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Newtork_Test_Connection_Speed_Page() {
			SoftAssert softnet4 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().clickTestConnectionSpeedButton());
			AssertJUnit.assertTrue(new NetworkPage().getSpeedTestPageObject().performSpeedTest());
			AssertJUnit.assertTrue(new NetworkPage().getSpeedTestPageObject().clickBackButton());
			softnet4.assertAll();
		}

		@Test(priority = 30, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_WAN_Settings_UI_Page() {
			SoftAssert softnet5 = new SoftAssert();
//			softnet5.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
//			super.swipeUp();
			AssertJUnit.assertTrue(new NetworkPage().clickWANSettings());
			
			try {
				if(new AppRatingDialog().isAt())
					new AppRatingDialog().clickRemindMeLaterLink();
			}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
				
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().verifyUIOnWANSettingsPage());

			softnet5.assertAll();
		}

		@Test(priority = 31, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_Help_Page() {
			SoftAssert softnet6 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickHelpButton());
			if (new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton());
			softnet6.assertAll();
		}

		@Test(priority = 32, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page",})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page() {
			SoftAssert softnet7 = new SoftAssert();
			new NetworkPage().getWANSettingsPageObject().clickWANIPConfigurationLink();
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP());
			softnet7.assertAll();
		}

		@Test(priority = 33, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page() {
			SoftAssert softnet8 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static());
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().validationOnWANIPv4Static_MandatoryFields());
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().validationOnWANIPv4Static_InvalidWANIPAddress());
			softnet8.assertAll();
		}

		@Test(priority = 34, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page() {
			SoftAssert softnet9 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab());
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful());
			softnet9.assertAll();
		}

		@Test(priority = 35, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page() {
			SoftAssert softnet10 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless());
//			softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
			softnet10.assertAll();
		}

		@Test(priority = 36, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_Help_Page() {
			SoftAssert softnet11 = new SoftAssert();
			new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
				try {
					if(new AppRatingDialog().isAt())
						new AppRatingDialog().clickRemindMeLaterLink();
				}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
			}
			softnet11.assertAll();
		}
		
		@Test(priority = 37, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page() 
		{
			SoftAssert softnet12 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickDNSConfigurationLink());
			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic());
			softnet12.assertAll();
		}
		
		@Test(priority = 38, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page() 
		{
			SoftAssert softnet13 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static());
//			softnet13.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().validationOnWANIPv4Static_InvalidDNSIPAddress());
			softnet13.assertAll();
		}
		
		@Test(priority = 39, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page() 
		{
			SoftAssert softnet14 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab());
			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic());
			softnet14.assertAll();
		}
		
		@Test(priority = 40, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page() 
		{
			SoftAssert softnet15 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Static());
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");}
		//	softnet15.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
			softnet15.assertAll();
		}
		
//		@Test(priority = 41, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page"})
//		public void Verify_WAN_Settings_DNS_Configuration_Help_Page() 
//		{
//			SoftAssert softnet16 = new SoftAssert();
//			softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickHelpButton());
//			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().getNetworkWANDNSConfigurationHelpPageObject().isAt())
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().getNetworkWANDNSConfigurationHelpPageObject().clickCloseButton());
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
//				try{
//					if(new NetworkPage().getAppRatingPageObject().isAt())
//						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//				}catch(Exception e) {
//					utils.log().info("App Rating Dialog did not appear");}
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
//				softnet16.assertAll();
//		}
		
		@Test(priority = 42, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_LAC_Alert_Dialog() 
		{
			SoftAssert softnet17 = new SoftAssert();
			if (new NetworkPage().getWANSettingsPageObject().isAt()) 
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickLacInfoIcon());
				if(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog());
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
			softnet17.assertAll();
		}
		
		@Test(priority = 43, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_LAN_Settings_UI_Page() 
		{
			SoftAssert softnet18 = new SoftAssert();
			if (new NetworkPage().isAt()) {
				//softnet18.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
				//super.pause(3);
				AssertJUnit.assertTrue(new NetworkPage().clickLANSettings());
				try{
					if(new NetworkPage().getAppRatingPageObject().isAt())
						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
				}catch(Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
			}
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().verifyUIOnLANSettingsPage());
			softnet18.assertAll();
		}
		
		@Test(priority = 44, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Page() 
		{
			SoftAssert softnet19 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANIPResevationLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyUIOnNetworkLANIPReservationPage());
			softnet19.assertAll();
		}
		
		@Test(priority = 45, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page() 
		{
			SoftAssert softnet20 = new SoftAssert();
			new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
			super.pause(10);
			new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
			{
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().verifyUIOnReserveLANIP());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice(1));
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton());
				softnet20.assertAll();
			}
		}
		
		@Test(priority = 46, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Rules() 
		{
			SoftAssert softnet21 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyRulesOnLAPIPReservationPage());
			softnet21.assertAll();
		}
		
		@Test(priority = 47, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Rules"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Edit_Page() 
		{
			SoftAssert softnet22 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickEditLAPIPReservation());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().isAt())
			{
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().verifyUIOnEditReserveLANIP());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editRuleName());
				super.pause(3);
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editIPAddress());
				super.pause(3);
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().clickSaveButton());
			}
			softnet22.assertAll();
		}

		@Test(priority = 48, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page() {
			SoftAssert softnet23 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton());
			if (new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton());
			}
			softnet23.assertAll();
		}
		
		@Test(priority = 49, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page() 
		{
			SoftAssert softnet24 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANSubnetLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyUIOnLANSubnetConfigurationPage());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyDHCPIPAddressRangeForSelectedSubnet());
			}
			softnet24.assertAll();
		}
		
		@Test(priority = 50, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page() 
		{
			SoftAssert softnet25 = new SoftAssert();
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForFirstSubnet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForSecondSubnet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForThirdSubnet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And255());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterDHCPRangeBtw1And255.getText() + " is displayed");
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And2552());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidDHCPRangeBtw1And255.getText() + " is displayed");
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix2());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickResetToDefaultButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());

			softnet25.assertAll();
		}
		
		@Test(priority = 51, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Edit_LAN_Subnet_Configuration_Octets() 
		{
			SoftAssert softnet26 = new SoftAssert();
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyFirstLANSubnetConfigurationWithInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText1.getText() + " is displayed");
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifySecondLANSubnetConfigurationWithInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText2.getText() + " is displayed");

			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText3.getText() + " is displayed");
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithSecondInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressTex16_31.getText() + " is displayed");
			
			softnet26.assertAll();
		}
		
		@Test(priority = 52, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page() 
		{
			SoftAssert softnet27 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickHelpButton());
				if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().isAt()) {
					AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().clickCloseButton());
					AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickBackButton());
				softnet27.assertAll();
			}
		}
		
		@Test(priority = 53, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page() 
		{
			SoftAssert softnet28 = new SoftAssert();	
				if(new NetworkPage().getLANSettingsPageObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickDHCPLeaseTimeLink());
				if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyUIOnLANLeaseTimePage());
				softnet28.assertAll();
		}
		
		@Test(priority = 54, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page"})
		public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page() 
		{
			SoftAssert softnet29 = new SoftAssert();
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt()){
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().verifyUIOnLANEditLeaseTimePage());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickCloseButton());}

			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithMinutesTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickHourlyRadioButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithHourlyTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickDaysRadioButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithDaysTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickWeeklyRadioButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithWeeklyTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
//				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickForeverRadioButton());
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithForeverTimeUnit());
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickSaveLeaseTimeButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
//				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifySameLeaseTimeForAnyUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
				}
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
			
			softnet29.assertAll();
		}
		
//		@Test(priority = 55, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page"})
//		public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Help_Page() 
//		{
//			SoftAssert softnet30 = new SoftAssert();
//			softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickHelpButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().isAt())
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().clickCloseButton());
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
//				try{
//					if(new NetworkPage().getAppRatingPageObject().isAt())
//						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//				}catch(Exception e) {
//					utils.log().info("App Rating Dialog did not appear");
//					}
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
//				softnet30.assertAll();
//		}
		
		@Test(priority = 56, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_UI_Page() 
		{
			SoftAssert softnet31 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().clickDevicePrioritySettings());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
			{
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().enableDevicePrioritySettings());
				try{
					if(new NetworkPage().getAppRatingPageObject().isAt())
						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
				}catch(Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
				
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnDevicePrioritySettingsPage());
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
				super.pause(25);
			}
			softnet31.assertAll();
		}
		
		@Test(priority = 57, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_UI_Page() 
		{
			SoftAssert softnet32 = new SoftAssert();
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyUIOnAddDevicePage());
				softnet32.assertAll();
			}
		}
		
		@Test(priority = 58, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_UI_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_Page() 
		{
			SoftAssert softnet33 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyDeviceListForPrioritization());
			utils.log().info("Clicking on Add Device button without selecting a device ");
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.isDisplayed())
				utils.log().info(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.getText() + " error message is displayed");

			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			super.pause(3);
			
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
			super.pause(25);
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			super.pause(5);

			softnet33.assertAll();
		}

		@Test(priority = 59, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_Page"})
		public void Verify_Device_Priority_Settings_Added_Device_Page() 
		{
			SoftAssert softnet34 = new SoftAssert();
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
			{
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnNetworkPrioritizedDevices());
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyTwoDevicesWithHighestPriority());
				
				if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().clickOkButton());
				super.pause(3);
			}
			softnet34.assertAll();
		}
		
		@Test(priority = 60, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_Help_Page() 
		{
			SoftAssert softnet35 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickHelpButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickBackButton());
			softnet35.assertAll();
		}
		
		@Test(priority = 61, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_Help_Page() 
		{
			SoftAssert softnet36 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickHelpButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickBackButton());
			softnet36.assertAll();
		}
		
		@Test(priority = 62, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Time_Zone_Settings_UI_Page() 
		{
			SoftAssert softnet37 = new SoftAssert();
			super.swipeUp();
			AssertJUnit.assertTrue(new NetworkPage().clickTimeZone());
			if(new NetworkPage().getTimeZoneSettingsPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().verifyUIOnTimeZonePage());
			AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickAtlanticTimeZone());
			AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickSaveButton());
			softnet37.assertAll();
		}
		
		@Test(priority = 63, dependsOnMethods = {"Login_And_Onboard", "Verify_Time_Zone_Settings_UI_Page"})
		public void Verify_Time_Zone_Settings_Help_Page() 
		{
			SoftAssert softnet38 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().clickTimeZone());
			AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHelpButton());
			if (new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickBackButton());
			softnet38.assertAll();
		}
		
		@Test(priority = 64, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_General_Settings_UI_Page() 
		{
			SoftAssert softnet39 = new SoftAssert();
			new NetworkPage().clickGeneralSettings(); 
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {}
			
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().verifyUIOnGeneralSettingsPage());
			softnet39.assertAll();
		}
		
		@Test(priority = 65, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_UPnP_Settings() 
		{
			SoftAssert softnet40 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().disableUPnP());
			
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().enableUPnP());
			super.pause(15);
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickUPNPInfoIcon());
			
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().clickCloseButton());
			softnet40.assertAll();
		}
		
		@Test(priority = 66, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_IPv6_Enable_Settings() 
		{
			SoftAssert softnet39 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickIPv6InfoIcon());
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().clickCloseButton());
			softnet39.assertAll();
		}
		
		@Test(priority = 67, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_Bridge_Mode_Settings() 
		{
			SoftAssert softnet42 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBridgeModeInfoIcon());
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().clickCloseButton());
			softnet42.assertAll();
		}
		
		@Test(priority = 68, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_Port_Forwarding_Settings() 
		{
			SoftAssert softnet43 = new SoftAssert();
			new NetworkPage().getGeneralSettingsPageObject().clickPortForwardingink();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().verifyUIOnPortForwardingPage());
			softnet43.assertAll();
		}
		
		@Test(priority = 69, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Page() 
		{
			SoftAssert softnet44 = new SoftAssert();
			new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
			{
				//super.getDriver().hideKeyboard();
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyUIOnPortForwardingAddRulePage());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickCloseButton());
			}
			softnet44.assertAll();
		}
		
		@Test(priority = 70, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Add_Rules() 
		{
			SoftAssert softnet45 = new SoftAssert();
//			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
//			{
			for(int i = 1 ; i <=3 ; i++)
			{
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectTCP());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
				
				try {
				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().allFieldsAreMandatoryError.isDisplayed()) {
					AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
					AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed()) {
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed()) {
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
						
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed()) {
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed()) {
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
					utils.log().info("All Port details are valid");
					AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
					super.pause(15);
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
								.getPortRuleEditFailedDialogObject().clickOKButton());
					}catch(Exception e) {
							utils.log().info("Port Rule Edit Failed Dialog did not appear");
					}
			}
			softnet45.assertAll();
		}
	

		@Test(priority = 71)
		public void Verify_General_Settings_Port_Forwarding_Edit_Rules() 
		{
			SoftAssert softnet46 = new SoftAssert();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
			{
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickEditPortFowardingRuleIcon());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectUDP());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());

					try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().allFieldsAreMandatoryError.isDisplayed())
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
					}catch(Exception e) {}
					
					try {
					 if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
					}catch(Exception e) {}
					
					try {
					 if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
					}catch(Exception e) {}
					
					try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
						AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
					}catch(Exception e) {}
				
					try {
						if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
							AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
					}catch(Exception e) {}

					utils.log().info("All Port details are valid");
					AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
				
				super.pause(15);
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
					AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
							.getPortRuleEditFailedDialogObject().clickOKButton());
					}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
			}
			softnet46.assertAll();
		}
////
////		@Test(priority = 72)
////		public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Validations() 
////		{
////			SoftAssert softnet47 = new SoftAssert();
////			new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
////			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
////			{
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterPortForwardingRuleName());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortStart());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyInternalPortStartLessThenPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortStart());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyExternalPortStartLessThenPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterValidIPAddress());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInValidIPAddress());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
////				try {
////					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().portNameDialogError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
////					else
////						utils.log().info("All Port details are valid");
////					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
////				}catch(Exception e) {utils.log().info("All Port details are valid");}
////				
////				super.pause(20);
////				try {
////				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
////					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
////							.getPortRuleEditFailedDialogObject().clickOKButton());
////					}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
////			}
////			softnet47.assertAll();
////		}
//		
		@Test(priority = 73, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Help_Page() 
		{
			SoftAssert softnet48 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickHelpButton());
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBackButton());
			AssertJUnit.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
			softnet48.assertAll();
		}
		
		@Test(priority = 74, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Existing_Guest_WiFi_Network() 
		{
			SoftAssert softnet49 = new SoftAssert();
			try {
				if (new NetworkPage().guestNetworkExpandIcon.isDisplayed())
					new NetworkPage().verifyGuestWifiNetwork();
				}catch(Exception e) {utils.log().info("Guest Wifi Network is not created");}
		}
		
		
		@Test(priority = 75, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_New_Guest_WiFi_Network() 
		{
			SoftAssert softnet49 = new SoftAssert();
			
			if(new NetworkPage().isGuestWifiDisabled()) 
			{
				AssertJUnit.assertTrue(new NetworkPage().enableGuestWifiNetwork());
				try {
					if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
						AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
					super.pause(40);
					
					if(new NetworkPage().joinButton.isDisplayed())
						AssertJUnit.assertTrue(new NetworkPage().clickJoinButton());
					super.pause(15);
				}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
						AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
						AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
						AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
						AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
						
						if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
							AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
						}
						super.pause(30);
					}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
					
					try {
						if(new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
							AssertJUnit.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
							AssertJUnit.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
								if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
									AssertJUnit.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
									AssertJUnit.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); 
									try {
										if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
											AssertJUnit.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
										super.pause(35);
										if(new NetworkPage().joinButton.isDisplayed()) {
											AssertJUnit.assertTrue(new NetworkPage().clickJoinButton());
										super.pause(20);}
									}catch(Exception e) {utils.log().info("Guest Network Alert dialog did not appear");}
								}
							AssertJUnit.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());}
					}catch(Exception e) {utils.log().info("Guest Network is not Created");}
			}

			softnet49.assertAll();
		}
		
		@Test(priority = 76, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Extended_WiFi_Settings_Page() 
		{
			SoftAssert softnet50 = new SoftAssert();
			AssertJUnit.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
			
			AssertJUnit.assertTrue(new NetworkPage().enable5GHzWidebandMode());
			try {
				if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickOKButton());
					super.pause(15);
			}catch(Exception e) {}
			
//			softnet50.assertTrue(new NetworkPage().clickfiveGHzWidebandInfoIcon());
//			if(new NetworkPage().get5GHzWidebandModeDialogObject().isAt())
//				softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeDialogObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().enableBandSteeringMode());
			try {
				if(new NetworkPage().getBandSteeringModeAlertDialogObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getBandSteeringModeAlertDialogObject().clickOKButton());
			}catch(Exception e) {}
				
			AssertJUnit.assertTrue(new NetworkPage().clickBandSteeringInfoIcon());
			if(new NetworkPage().getBandSteeringModeDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getBandSteeringModeDialogObject().clickCloseButton());
			
			AssertJUnit.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
			softnet50.assertAll();
		}
}




//@Test(priority = 74, dependsOnMethods = {"Login_And_Onboard"})
//public void Verify_Guest_WiFi_Network_Page() 
//{
//	SoftAssert softnet49 = new SoftAssert();
//	try {
//		if (new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//			new NetworkPage().verifyGuestWifiNetwork();}
//	}catch(Exception e) {}
//	
//	try {
//		if(! new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//			softnet49.assertTrue(new NetworkPage().enableGuestWifiNetwork());
//			try {
//				if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//				super.pause(40);
//				
//				if(new NetworkPage().joinButton.isDisplayed())
//					softnet49.assertTrue(new NetworkPage().clickJoinButton());
//				super.pause(15);
//			}catch(Exception e) {}
//			
//			try {
//				if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
//					//softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().validateGuestNetworkPage());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
//				
//					if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//					}
//					super.pause(30);
//				}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
//			
//			try {
//				if(new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
//						if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
//							softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
//							softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); 
//							try {
//								if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//									softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//								super.pause(35);
//								if(new NetworkPage().joinButton.isDisplayed()) {
//									softnet49.assertTrue(new NetworkPage().clickJoinButton());
//								super.pause(20);}
//							}catch(Exception e) {utils.log().info("Guest Network Alert dialog did not appear");}
//						}
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());}
//			}catch(Exception e) {utils.log().info("Guest Network is not Created");}
//		}
//	}catch(Exception e) {}
//
//	softnet49.assertAll();
//}