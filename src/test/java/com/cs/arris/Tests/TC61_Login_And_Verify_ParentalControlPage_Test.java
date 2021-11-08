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
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;
import com.cs.arris.Workflows.TC61_Login_And_Verify_ParentalControl_Workflow;

public class TC61_Login_And_Verify_ParentalControlPage_Test extends ParentClass {
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String phoneToPause;
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
			utils.log().info("Loading...Test Data");
			super.loadTestData(dataFileName);

			this.firstName = properties.getProperty("firstname");
			utils.log().info("First Name : " + this.firstName);

			this.lastName = properties.getProperty("lastname");
			utils.log().info("Last Name : " + this.lastName);

			this.email = properties.getProperty("email");
			utils.log().info("Email address : " + this.email);

			this.udid = properties.getProperty("udid");
			utils.log().info("UDID : " + this.udid);
			
			this.phoneToPause = properties.getProperty("phoneToPauseInternet");
			utils.log().info("Phone To Pause Internet : " + this.phoneToPause);

			utils.log().info("Retrieved...Test Data");
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
		TC61_Login_And_Verify_ParentalControl_Workflow.getStartedPage(getStarted -> {
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
				if (home.okButton.isDisplayed()) {
					home.clickOkButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
			if(home.isAt()) {
				super.pause(3);
				home.getFooterIconsPageObject().clickParentalButton();
			}
			}).parentalControlWithProfilesPage(profiles -> {
				profiles.disableParentalControl();
				profiles.clickBackButton();
			}).homePage(home -> {
				home.clickCurrentlyBlockedDevicesImage();
			}).blankBloxkedDevicesPage(blankBlockedDevices -> {
				if(blankBlockedDevices.isAt())
				{
					blankBlockedDevices.getDeviceBlockedCountText();
					blankBlockedDevices.clickCloseIcon();
				}
			}).homePage(home -> {
				home.getFooterIconsPageObject().clickParentalButton();
			}).parentalControlWithProfilesPage(profiles -> {
				if(profiles.isAt())
				{
					profiles.clickHelpIcon();
					super.pause(3);
				}
			}).parentalControlHelpPage(helpPage ->{
				if(helpPage.isAt())
				{
					helpPage.verifyUIOnParentalControlOverviewHelpPage();
					helpPage.clickCloseButton();
				}
			}).parentalControlWithProfilesPage(profiles -> {
				if(profiles.isAt())
				{
					profiles.clickBackButton();
					super.pause(3);
				}
			}).homePage(home -> {
				home.getFooterIconsPageObject().clickParentalButton();
			}).parentalControlWithProfilesPage(profiles -> {
				if(profiles.isAt())
				{
					profiles.verifyUIOnParentalControlProfilesPage();
					profiles.enableParentalControl();
					
					for (int i = 1 ; i <=5 ; i ++)
					{
						profiles.clickAddProfilesLink();
						profiles.getAddProfileDialogObject().enterProfileName();
						profiles.getAddProfileDialogObject().clickCreateProfileButton();
					}
					
					profiles.verifyUserProfile();
					profiles.clickOnUserProfile();
					
					if(profiles.getUserProfilePageObject().isAt())
					{
						profiles.getUserProfilePageObject().verifyUIOnUserProfilePage();
						profiles.getUserProfilePageObject().clickHelpIcon();
						super.pause(3);
						if(profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject().isAt())
						{
							profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject().verifyUIOnUserProfilePage();
							profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject().clickCloseButton();
						}
						profiles.getUserProfilePageObject().getExistingUserName();
						profiles.getUserProfilePageObject().clickUserProfileNameEditButton();
						if(profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt())
						{
							profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().verifyUIOnEditUserProfileDialog();
							profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName();
							profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton();
							super.pause(3);
						}
						profiles.getUserProfilePageObject().validateUserProfileEditedName();
						profiles.getUserProfilePageObject().clickAddDeviceLink();
						if(profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt())
						{
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickHelpIcon();
							if(profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().isAt())
							{
								profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().verifyUIOnAddDeviceHelpPage();
								profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().clickCloseButton();
							}
							
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyandSelectDevice(this.phoneToPause);
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton();
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDeviceCountAfterAssociatingToUser();
						}
						
					}
				}
		});
	}
}