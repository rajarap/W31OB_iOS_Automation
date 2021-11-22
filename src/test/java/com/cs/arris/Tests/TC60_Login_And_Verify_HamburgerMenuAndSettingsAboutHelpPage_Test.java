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
import com.cs.arris.Pages.MainDeviceAllTabPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;

public class TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Test extends ParentClass {
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
	public void beforeClass() throws Exception {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	}

	@Test(priority = 1)
	public void Verify_HamburgerMEnu_And_Settings_About_Help_Pages() {
		TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow.getStartedPage(getStarted -> {
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
			try {
				if (codeVerified.continueOnBoardingButton.isDisplayed()) {
					codeVerified.clickContinueOnboardingButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}).setupWifi(setupwifi -> {
			setupwifi.clickskipTutorialButton();
			super.pause(3);
		}).homePage(home -> {
			  try {
				  if(home.okButton.isDisplayed())
					  home.clickOkButton();
			  }catch(Exception e) {
				  e.getMessage();  }
		  });
	}
	
	@Test(priority = 2)
	public void Verify_Hamburger_Menu_Page() {
		SoftAssert softburger2 = new SoftAssert();
		softburger2.assertTrue(new HomePage().clickNavigationButton());
		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			softburger2.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
	}
	
	@Test(priority = 3)
	public void Verify_Hamburger_Menu_Settings_UI_Page() {
		SoftAssert softburger3 = new SoftAssert();
		softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSettingsButton());
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAt())
			softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnSettingsPage());
	}
	
	@Test(priority = 4)
	public void Verify_Hamburger_Menu_Settings_Help_Page() {
		SoftAssert softburger4 = new SoftAssert();
		softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickHelpIcon());
		softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getSettingsHelpPageObject().clickCloseButton());
		softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
	}
	
	@Test(priority = 5)
	public void Verify_Hamburger_Menu_About_UI_Page() {
		SoftAssert softburger5 = new SoftAssert();
		softburger5.assertTrue(new HomePage().clickNavigationButton());
		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAboutAppButton());
		
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtAboutPage())
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnAboutPage());
	}
	
	@Test(priority = 6)
	public void Verify_Hamburger_Menu_About_License_Page() {
		SoftAssert softburger6 = new SoftAssert();
		softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickLicenseButton());
		super.pause(3);
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().isAt())
		{
			softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().verifyUIOnLicensesPage());
			softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().clickCloseButton());
		}
	}
	
	@Test(priority = 7)
	public void Verify_Hamburger_Get_Another_Max_Page() {
		SoftAssert softburger7 = new SoftAssert();
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtAboutPage())
			softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickGetAnotherMaxRouterButton());
			super.pause(3);
			softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
	}
	
	@Test(priority = 8)
	public void Verify_Hamburger_About_Help_Page() {
		SoftAssert softburger8 = new SoftAssert();
		softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickHelpIcon());
		softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getAboutHelpPageObject().clickCloseButton());
		softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
	}
	
	@Test(priority = 9)
	public void Verify_Hamburger_Surfboard_Help_UI_Page() {
		SoftAssert softburger9 = new SoftAssert();
		softburger9.assertTrue(new HomePage().clickNavigationButton());
		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().clickHelpMenuButton());
		
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtHelpPage())
			softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnHelpPage());
	}
		
	@Test(priority = 10)
	public void Verify_Hamburger_Surfboard_FAQ_Help_Page() {
		SoftAssert softburger10 = new SoftAssert();
		softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickFAQButton());
		
		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().isAt())
			softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().verifyUIOnFAQHelpPage());
			softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().clickBackButton());
	}
	
	@Test(priority = 11)
	public void Verify_Hamburger_Surfboard_Self_Help_Page() {
		SoftAssert softburger11 = new SoftAssert();
		softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickSelfHelp());
	}
	
	@Test(priority = 12)
	public void Verify_Hamburger_Surfboard_Chat_With_US_Page() {
		SoftAssert softburger12 = new SoftAssert();
		softburger12.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickLiveChatHelp());
		softburger12.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
	}	
}