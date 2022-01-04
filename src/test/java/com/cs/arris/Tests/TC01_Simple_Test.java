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
import com.cs.arris.Pages.AddDeviceAccessCameraDialog;
import com.cs.arris.Pages.AddDeviceActivateYourDeviceWithServiceProviderPage;
import com.cs.arris.Pages.AddDeviceChooseInternetServiceProviderPage;
import com.cs.arris.Pages.AddDeviceCongratulationsPage;
import com.cs.arris.Pages.AddDeviceEnterMACAddressManuallyPage;
import com.cs.arris.Pages.AddDeviceEstablishingConnectionPage;
import com.cs.arris.Pages.AddDeviceHomePage;
import com.cs.arris.Pages.AddDeviceLetsStartWithDeviceConnectionPage;
import com.cs.arris.Pages.AddDeviceRegistrationFailedPage;
import com.cs.arris.Pages.AddDeviceScanBarCodePage;
import com.cs.arris.Pages.AddDeviceSelectDevice1Page;
import com.cs.arris.Pages.AddDeviceSelectDevice2Page;
import com.cs.arris.Pages.AddDeviceStepsForActivationPage;
import com.cs.arris.Pages.AddDeviceSuccessPage;
import com.cs.arris.Pages.AppRatingDialog;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SpeedTestPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
 


public class TC01_Simple_Test extends ParentClass
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
	
	//HomePage
	public TC003_Login_And_Test_Home_Page getHomePageTestObject() {
		TC003_Login_And_Test_Home_Page homePageTest = new TC003_Login_And_Test_Home_Page();
		return homePageTest;
	}
	//Hamburger Menu And Settings About Help Page
	public TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page getSettingsAboutHelpTestObject() {
		TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page  settingsAboutHelpTest = new TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page();
		return settingsAboutHelpTest;
	}
	
	//Hamburger Menu Amazon Feature
	public TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature getAmazonFeatureTestObject() {
		TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature  amazonFeatureTest = new TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature();
		return amazonFeatureTest;
	}
	//Add And Remove Devices
	public TC013_Login_And_Test_Add_And_Remove_Device getAddRemoveDeviceTestObject() {
		TC013_Login_And_Test_Add_And_Remove_Device  addRemoveDeviceTest = new TC013_Login_And_Test_Add_And_Remove_Device();
		return addRemoveDeviceTest;
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
//			utils.log().info("                        ");
//			utils.log().info("************************");
//			utils.log().info("Test: Login And Onboard ");
//			utils.log().info("************************");
//		  TC52_Login_And_Verify_HomePage_Workflow.getStartedPage(getStarted -> {
//			  getStarted.clickGetStartedButton();
//		  }).grantPermissionsPage(grantPermission -> {
//			  grantPermission.clickContinueButton();
//		  }).deviceLocationPage(deviceLocation -> {
//			  deviceLocation.clickWhileUsingAppLink();
//		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			  accessResoucesOnDevice.clickOkButton();
//		  }).selectYourDevicePage(selectDevice -> {
//			  selectDevice.selectSurfboardMaxOption();
//			  selectDevice.clickNextButton();
//		  }).selectYourDevicePage2(selectDevice2 -> {
//			  selectDevice2.selectMaxProAX11000RadioButton();
//			  selectDevice2.clickNextButton();
//			  super.pause(3);
//		  }).welcomeSigninPage(signin -> {
//			  signin.clearEmailAddress();
//			  signin.enterEmailAddress(email);
//			  signin.clickSigninButton();
//			  super.pause(12);
//		  }).getOTPCode(getOTP -> {
//			  passCode = getOTP.getValidOTP();
//	  		}).enterOTPPage(otpverify -> {
//			  otpverify.enterValidPassCode(passCode);
//			  super.pause(5);
//	  		}).codeVerifiedPage(codeVerified -> {
//				  codeVerified.getCodeVerifiedText();
//				  codeVerified.clickNextButton();
//				  super.pause(35);
//				  try{
//					  if(codeVerified.continueOnBoardingButton.isDisplayed()){
//						  codeVerified.clickContinueOnboardingButton();}
//				  }catch(Exception e){ e.getMessage();}
//			  }).setupWifi(setupwifi ->{
//				  setupwifi.clickskipTutorialButton();
//				  super.pause(5);
//		  }).homePage(home -> {
//			  try {
//				  if(home.okButton.isDisplayed())
//					  home.clickOkButton();
//			  }catch(Exception e) {
//				  e.getMessage(); }
//		  });
	  }
		  
	    @Test(priority = 2 , dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Home_UI_Page() {
			SoftAssert softhome2 = new SoftAssert();
			softhome2.assertTrue(new HomePage().verifyUIOnHomePage());
			try {
				if(new AppRatingDialog().isAt())
					new AppRatingDialog().clickRemindMeLaterLink();
			}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
			softhome2.assertAll();
		}
		
		@Test(priority = 3, dependsOnMethods = { "Login_And_Onboard", "Verify_Home_UI_Page" })
		public void Verify_Home_Device_Signal_Strength_Navigation() {
			SoftAssert softhome3 = new SoftAssert();
			super.swipeUp();
			softhome3.assertTrue(new HomePage().clickDeviceSignalStrengthImage());
			if(new HomePage().getDeviceSignalStrengthPageObject().isAt())
				softhome3.assertTrue(new HomePage().getDeviceSignalStrengthPageObject().clickCloseIcon());
			softhome3.assertAll();
		}
		
		@Test(priority = 4, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Home_Speed_Test_History_Navigation() {
			SoftAssert softhome4 = new SoftAssert();
			super.swipeUp();
			softhome4.assertTrue(new HomePage().clickSpeedTestHistoryImage());
			if(new HomePage().getBlankSpeedTestHistoryPageObject().isAt())
				softhome4.assertTrue(new HomePage().getBlankSpeedTestHistoryPageObject().clickCloseIcon());
			softhome4.assertAll();
		}
		
//		@Test(priority = 5, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Home_Currently_Blocked_Devices_Navigation() {
//			SoftAssert softhome5 = new SoftAssert();
//			softhome5.assertTrue(new HomePage().clickCurrentlyBlockedDevicesImage());
//			if(new HomePage().getBlankBlockedDevicesPageObject().isAt())
//				softhome5.assertTrue(new HomePage().getBlankBlockedDevicesPageObject().clickCloseIcon());
//			softhome5.assertAll();
//		}
		
		@Test(priority = 6, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Home_Main_Devices_Navigation() {
			SoftAssert softhome6 = new SoftAssert();
			super.swipeDown();
			softhome6.assertTrue(new HomePage().clickMainDeviceImage());
			if(new HomePage().getMainDeviceAllTabPageObject().isAt())
				softhome6.assertTrue(new HomePage().getMainDeviceAllTabPageObject().clickBackButton());
			softhome6.assertAll();
		}
		
		@Test(priority = 7, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Home_Total_Devices_Navigation() {
			SoftAssert softhome7 = new SoftAssert();
			softhome7.assertTrue(new HomePage().clickDevicesImage());
			if(new HomePage().getDevicesPageObject().isAt())
				softhome7.assertTrue(new HomePage().getDevicesPageObject().clickBackButton());
			softhome7.assertAll();
		}
		
		@Test(priority = 8, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Home_Hamburger_Navigation() {
			SoftAssert softhome8 = new SoftAssert();
			softhome8.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) {
				//softhome8.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
				softhome8.assertTrue(new HomePage().getHamburgerMenuPageObject().clickCloseButton());}
			softhome8.assertAll();
		}
		
		@Test(priority = 9, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Home_Notifications_Navigation() {
			SoftAssert softhome9= new SoftAssert();
			softhome9.assertTrue(new HomePage().clickNotificationsIcon());
			if(new HomePage().getNotificationPageObject().isAt())
				softhome9.assertTrue(new HomePage().getNotificationPageObject().clickBackButton());
			softhome9.assertAll();
		}
 
		//TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page
		@Test(priority = 10, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Menu_Page() {
			utils.log().info("                                            ");
			utils.log().info("********************************************");
			utils.log().info("Test: Hamburger Menu - Settings Menu Option ");
			utils.log().info("********************************************");
			SoftAssert softburger2 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger2.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger2.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
			
			softburger2.assertAll();
		}
		
		@Test(priority = 11, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Menu_Settings_UI_Page() {
			SoftAssert softburger3 = new SoftAssert();
			softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSettingsButton());
			if(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().isAt())
				softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().verifyUIOnSettingsPage());

			softburger3.assertAll();
		}
		
		@Test(priority = 12)	
		public void Verify_Hamburger_Menu_Settings_Help_Page() {
			SoftAssert softburger5 = new SoftAssert();
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().clickHelpIcon());
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().getSettingsHelpPageObject().clickCloseButton());
			
			softburger5.assertAll();
		}
		
		@Test(priority = 13, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Menu_Settings_Sign_Out() {
			SoftAssert softburger4 = new SoftAssert();
			String userEmail = new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().getUserEmailAddress();
			softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().clickSignOutButton());
			super.pause(5);

			try {
				if(userEmail.equals(new SiginPage().emailAddressTextBox.getText())) {
					softburger4.assertTrue(new SiginPage().clickSigninButton());
					super.pause(5);	}
			}catch(Exception e) {}
			
			softburger4.assertAll();
		}
		
		@Test(priority = 14, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Menu_About_UI_Page() {
		utils.log().info("                                         ");
		utils.log().info("*****************************************");
		utils.log().info("Test: Hamburger Menu - About Menu Option ");
		utils.log().info("*****************************************");
			SoftAssert softburger6 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger6.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAboutAppButton());
			
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt())
				softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().verifyUIOnAboutPage());
			
			softburger6.assertAll();
		}
		
		@Test(priority = 15, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Menu_About_License_Page() {
			SoftAssert softburger7 = new SoftAssert();
			softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickLicenseButton());
			super.pause(3);
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getLicensesPageObject().isAt())
			{
				//softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getLicensesPageObject().verifyUIOnLicensesPage());
				softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getLicensesPageObject().clickCloseButton());
			}
			softburger7.assertAll();
		}
		
		@Test(priority = 16, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Get_Another_Max_Page() {
			SoftAssert softburger8 = new SoftAssert();
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt())
				softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickGetAnotherMaxRouterButton());
			//softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
				
			softburger8.assertAll();
		}
		
		@Test(priority = 17, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_About_Help_Page() {
			SoftAssert softburger9 = new SoftAssert();
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt()) {
			softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickHelpIcon());
			softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getAboutHelpPageObject().clickCloseButton());
			softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickBackButton());}
			
			softburger9.assertAll();
		}
		
		@Test(priority = 18)
		public void Verify_Hamburger_Surfboard_Help_UI_Page() {
		utils.log().info("                                        ");
		utils.log().info("****************************************");
		utils.log().info("Test: Hamburger Menu - Help Menu Option ");
		utils.log().info("****************************************");
			SoftAssert softburger10 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger10.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().clickHelpMenuButton());
			
			if(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().isAt())
				softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().verifyUIOnHelpPage());
			
			softburger10.assertAll();
		}
			
		@Test(priority = 19, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Surfboard_FAQ_Help_Page() {
			SoftAssert softburger11 = new SoftAssert();
			softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickFAQButton());
			
			if(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().isAt()) {
				softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().verifyUIOnFAQHelpPage());
				softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().clickBackButton());}
			
			softburger11.assertAll();
		}
		
		@Test(priority = 20, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Surfboard_Self_Help_Page() {
			SoftAssert softburger12 = new SoftAssert();
			softburger12.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickSelfHelp());
			
			softburger12.assertAll();
		}
		
		@Test(priority = 21, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Hamburger_Surfboard_Chat_With_US_Page() {
			SoftAssert softburger13 = new SoftAssert();
			softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickLiveChatHelp());
			softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickBackButton());
			
			softburger13.assertAll();
		}	
		
		
		//TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature
		@Test(priority = 22, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Amazon_Features_UI_Page() {
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Test: Hamburger Menu - Amazon Features Menu Option ");
		utils.log().info("***************************************************");
			SoftAssert softfeatures3 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softfeatures3.assertTrue(new HomePage().clickNavigationButton());
			softfeatures3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAmazonFeaturesButton());
			if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().isAt())
				softfeatures3.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().verifyUIOnAFFSPage());
		}
		
		@Test(priority = 23, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Get_Alexa_Skills_Drop_Down_Box() {
			SoftAssert softfeatures4 = new SoftAssert();
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickGetAlexaSkillsButton());
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().alexaSkillsContent.isDisplayed());
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsButtonAgain());
		}
		
		@Test(priority = 24, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Show_Password_Button() {
			SoftAssert softfeatures5 = new SoftAssert();
			softfeatures5.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButton());
			//softfeatures5.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getPasswordText());
			softfeatures5.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButtonAgain());

		}
		
		@Test(priority = 25, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Copy_Password() {
			SoftAssert softfeatures6 = new SoftAssert();
			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordButton());
			if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordOKButton());
		}
		
		@Test(priority = 26)
		public void Verify_Amazon_Alexa_Skills_Link() {
			SoftAssert softfeatures7 = new SoftAssert();
			softfeatures7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsLink());
		}
		
		@Test(priority = 27)
		public void Verify_Please_Tap_Here_Link() {
			SoftAssert softfeatures6 = new SoftAssert();
			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickPleaseTapHereLink());
		}

		@Test(priority = 28, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Enable_AFFS_Feature() {
			SoftAssert softfeatures9 = new SoftAssert();
			softfeatures9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().enableAFFS());
			if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAmazonWifiSimpleSetupPageObject().isAt())
				softfeatures9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAmazonWifiSimpleSetupPageObject().clickCloseButton());
		}
		
//		@Test(priority = 29)
//		public void Verify_Disable_AFFS_Feature() {
//			SoftAssert softfeatures10 = new SoftAssert();
//			softfeatures10.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().disableAFFS());
//		}
			
		@Test(priority = 30, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Amazon_Feature_Help_Page() {
			SoftAssert softfeatures11 = new SoftAssert();
			softfeatures11.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickHelpIcon());
			
			if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAFFSHelpPageObject().isAt())
				softfeatures11.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAFFSHelpPageObject().clickCloseButton());
			
			softfeatures11.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickBackButton());
		}
//
//	  //TC013_Login_And_Test_Add_And_Remove_Device
//		@Test(priority = 31, dependsOnMethods = { "Login_And_Onboard" })
//		public void Verify_Add_Device_Menu() {
//			utils.log().info("                                             ");
//			utils.log().info("*********************************************");
//			utils.log().info("Test: Hamburger Menu - Add and Remove Device ");
//			utils.log().info("*********************************************");
//			
//			SoftAssert softhome2 = new SoftAssert();
//			
//			new HomePage().getFooterIconsPageObject().clickHomeButton();
//			
//			if(new HomePage().isAt())
//				softhome2.assertTrue(new HomePage().clickNavigationButton());
//			
//			if(new HomePage().getHamburgerMenuPageObject().isAt())
//				softhome2.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAddDeviceButton());
//			
//			if(new AddDeviceSelectDevice1Page().isAt()) {
//				softhome2.assertTrue(new AddDeviceSelectDevice1Page().selectISPCableRadioButton());
//				softhome2.assertTrue(new AddDeviceSelectDevice1Page().clickNextButton());}
//			
//			if(new AddDeviceSelectDevice2Page().isAt()) {
//				softhome2.assertTrue(new AddDeviceSelectDevice2Page().selectT25RadioButton());
//				softhome2.assertTrue(new AddDeviceSelectDevice2Page().clickNextButton());
//				super.pause(5);}
//			
//			if(new AddDeviceStepsForActivationPage().isAt())
//				softhome2.assertTrue(new AddDeviceStepsForActivationPage().clickStartButton());
//			super.pause(5);
//			
//			if(new AddDeviceLetsStartWithDeviceConnectionPage().isAt())
//				softhome2.assertTrue(new AddDeviceLetsStartWithDeviceConnectionPage().clickNextButton());
//			super.pause(5);
//			
//			if(new AddDeviceChooseInternetServiceProviderPage().isAt())
//				softhome2.assertTrue(new AddDeviceChooseInternetServiceProviderPage().clickNextButton());
//			super.pause(5);
//			
//			if(new AddDeviceActivateYourDeviceWithServiceProviderPage().isAt())
//				softhome2.assertTrue(new AddDeviceActivateYourDeviceWithServiceProviderPage().clickSkipButton());
//			super.pause(5);
//			
//			if(new AddDeviceEstablishingConnectionPage().isAt())
//				softhome2.assertTrue(new AddDeviceEstablishingConnectionPage().clickOnlineButton());
//			super.pause(5);
//			
//			if(new AddDeviceSuccessPage().isAt())
//				softhome2.assertTrue(new AddDeviceSuccessPage().clickNextButton());
//			super.pause(5);
//			
//			if(new AddDeviceScanBarCodePage().isAt())
//				softhome2.assertTrue(new AddDeviceScanBarCodePage().clickScanButton());
//			super.pause(5);
//			
//			if(new AddDeviceAccessCameraDialog().isAt())
//				softhome2.assertTrue(new AddDeviceAccessCameraDialog().clickEnterManuallyButton());
//			super.pause(5);
//			
//			if(new AddDeviceEnterMACAddressManuallyPage().isAt()) {
//				softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterSerialNumber());
//				softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterMACAddress());
//				softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().clickNextButton());
//				super.pause(15);}
//			
//			if(new AddDeviceRegistrationFailedPage().isAt())
//				softhome2.assertTrue(new AddDeviceRegistrationFailedPage().clickContinueButton());
//			super.pause(10);
//			
//			if(new AddDeviceCongratulationsPage().isAt())
//				softhome2.assertTrue(new AddDeviceCongratulationsPage().clickContinueButton());
//			super.pause(5);
//			softhome2.assertAll();
//		}
//			
////		@Test(priority = 32, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Cable_Modem_Tab() {
////			SoftAssert softhome0 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome0.assertTrue(new AddDeviceHomePage().verifyUIOnHomePage());
////			
////			softhome0.assertAll();
////		}
////		
////		@Test(priority = 33, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Max_Router_Tab() {
////			SoftAssert softhome3 = new SoftAssert();
////			softhome3.assertTrue(new AddDeviceHomePage().clickMaxRouterTab());
////			softhome3.assertTrue(new AddDeviceHomePage().getHomePageObject().verifyUIOnHomePage());
////			softhome3.assertTrue(new AddDeviceHomePage().clickCableModemTab());
////			
////			softhome3.assertAll();
////		}
////		
////		@Test(priority = 34, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Device_Details_Page() {
////			SoftAssert softhome4 = new SoftAssert();
////			softhome4.assertTrue(new AddDeviceHomePage().clickDeviceDetailsText());
////			if(new AddDeviceHomePage().getDeviceDetailsPageObject().isAt()) {
////				softhome4.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().verifyDeviceDetailsUI());
////				softhome4.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().clickCloseButton());
////			}
////			
////			softhome4.assertAll();
////		}
////		
////		@Test(priority = 35, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Specifications_Page() {
////			SoftAssert softhome5 = new SoftAssert();
////			softhome5.assertTrue(new AddDeviceHomePage().clickSpecificationsText());
////			super.pause(5);
////			if(new AddDeviceHomePage().getDeviceSpecificationsPageObject().isAt())
////				softhome5.assertTrue(new AddDeviceHomePage().getDeviceSpecificationsPageObject().clickBackButton());
////			
////			softhome5.assertAll();
////		}
////		
////		@Test(priority = 36, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Add_Additional_Device() {
////			SoftAssert softhome6 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome6.assertTrue(new AddDeviceHomePage().clickNavigationButton());
////				
////			if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
////				softhome6.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickAddDeviceButton());
////				
////			if(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().isAt())
////				softhome6.assertTrue(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().clickOkButton());
////			
////			softhome6.assertAll();
////		}
////		
////		@Test(priority = 37, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Notifications_Page() {
////			SoftAssert softhome7 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome7.assertTrue(new AddDeviceHomePage().clickNotificationsIcon());
////			
////			if(new AddDeviceHomePage().getNotificationsPageObject().isAt())
////				softhome7.assertTrue(new AddDeviceHomePage().getNotificationsPageObject().clickBackButton());
////			
////			softhome7.assertAll();
////		}
////		
////		@Test(priority = 38, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_User_Guide_Page() {
////			SoftAssert softhome8 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome8.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickUserGuideButton());
////			super.pause(3);
////
////			if(new AddDeviceHomePage().getUserGuidePageObject().isAt())
////				super.swipeUp();
////			
////			softhome8.assertAll();
////		}
////		
////		@Test(priority = 39, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_FAQ_Page() {
////			SoftAssert softhome9 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome9.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickFAQButton());
////			super.pause(3);
////			
////			if(new AddDeviceHomePage().getFAQPageObject().isAt())
////				super.swipeUp();
////			softhome9.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickHomeButton());
////			softhome9.assertAll();
////		}
////		
////		@Test(priority = 40, dependsOnMethods = { "Login_And_Onboard" })
////		public void Verify_Remove_Device_Page() {
////			SoftAssert softhome10 = new SoftAssert();
////			if(new AddDeviceHomePage().isAt())
////				softhome10.assertTrue(new AddDeviceHomePage().clickNavigationButton());
////				
////			if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
////				softhome10.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickRemoveDeviceButton());
////			
////			if(new AddDeviceHomePage().getRemoveDevicePageObject().isAt()) {
////				softhome10.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().selectDeviceToRemove());
////				softhome10.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().clickNextButton());
////				super.pause(3);}
////				
////			softhome10.assertAll();
////		}
}