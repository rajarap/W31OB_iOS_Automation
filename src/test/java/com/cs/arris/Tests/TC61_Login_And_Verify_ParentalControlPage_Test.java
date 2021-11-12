package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
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
	public void Verify_Parental_Control() {
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
				if (home.okButton.isDisplayed())
					home.clickOkButton();
			} catch (Exception e) {
				e.getMessage();
			}
			if (home.isAt()) {
				home.getFooterIconsPageObject().clickParentalButton();
			}
		}).parentalControlWithProfilesPage(profiles -> {
			profiles.disableParentalControl();
			try {
				if (profiles.getAppRatingDialogObject().isAt())
					profiles.getAppRatingDialogObject().clickRemindMeLaterLink();
			} catch (Exception e) {
				utils.log().info("App Rating Dialog is not displayed");
			}
			profiles.clickBackButton();
			super.pause(3);
		}).homePage(home -> {
			home.clickCurrentlyBlockedDevicesImage();
		}).blankBlockedDevicesPage(blankBlockedDevices -> {
			if (blankBlockedDevices.isAt()) {
				blankBlockedDevices.getDeviceBlockedCountText();
				blankBlockedDevices.clickCloseIcon();
			}
		}).homePage(home -> {
			home.getFooterIconsPageObject().clickParentalButton();
		}).parentalControlWithProfilesPage(profiles -> {
			if (profiles.isAt()) {
				profiles.clickHelpIcon();
				super.pause(3);
				if (profiles.getParentalHelpPageObject().isAt()) {
					profiles.getParentalHelpPageObject().verifyUIOnParentalControlOverviewHelpPage();
					profiles.getParentalHelpPageObject().clickCloseButton();
					super.pause(2);
					profiles.clickBackButton();
					super.pause(3);
				}
			}
		}).homePage(home -> {
			home.getFooterIconsPageObject().clickParentalButton();
		}).parentalControlWithProfilesPage(profiles -> {
			if (profiles.isAt()) {
				profiles.verifyUIOnParentalControlProfilesPage();
				profiles.enableParentalControl();
				super.pause(5);
				if (profiles.getAppRatingDialogObject().isAt())
					profiles.getAppRatingDialogObject().clickRemindMeLaterLink();
//				for (int i = 1; i <= 5; i++) {
//					profiles.clickAddProfilesLink();
//					profiles.getAddProfileDialogObject().enterProfileName();
//					profiles.getAddProfileDialogObject().clickCreateProfileButton();
//				}
				profiles.verifyUserProfile();
				profiles.clickOnUserProfile();

				if (profiles.getUserProfilePageObject().isAt()) {
					profiles.getUserProfilePageObject().verifyUIOnUserProfilePage();
					profiles.getUserProfilePageObject().clickHelpIcon();
					super.pause(3);
					if (profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject().isAt()) {
						profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject()
								.verifyUIOnUserProfilePage();
						profiles.getUserProfilePageObject().getParentalUserProfileHelpPageObject().clickCloseButton();
					}
					profiles.getUserProfilePageObject().getExistingUserName();
					profiles.getUserProfilePageObject().clickUserProfileNameEditButton();
					if (profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt()) {
						profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().verifyUIOnEditUserProfileDialog();
						profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName();
						profiles.getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton();
						super.pause(3);
					}
					profiles.getUserProfilePageObject().validateUserProfileEditedName();

					// Add Device
					profiles.getUserProfilePageObject().clickAddDeviceLink();
					if (profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) {
						profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickHelpIcon();
						if (profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
								.getParentalAddDeviceHelpPageObject().isAt()) {
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
									.getParentalAddDeviceHelpPageObject().verifyUIOnAddDeviceHelpPage();
							profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
									.getParentalAddDeviceHelpPageObject().clickCloseButton();
						}
						profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
								.verifyandSelectDevice(this.phoneToPause);
						profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
								.clickAddDeviceButton();
						profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
								.verifyDeviceCountAfterAssociatingToUser();
						profiles.getUserProfilePageObject().getParentalUserProfileAddDevicePageObject()
								.clickBackButton();
						profiles.getUserProfilePageObject().verifyAssociatedDeviceList();
						profiles.getUserProfilePageObject().clickDeviceListExpandButton();
					}

					// Add Rule
//					profiles.getUserProfilePageObject().clickAddRuleLink();
//					if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) 
//					{
//						profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickHelpIcon();
//						if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getParentalAddRuleHelpPageObject().isAt()) {
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getParentalAddRuleHelpPageObject().verifyUIOnAddRuleHelpPage();
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getParentalAddRuleHelpPageObject().clickCloseButton();
//						}
//
//						profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton();
//						if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().isAt()) {
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject()
//									.verifyUIOnAddInternetBlockingScheduleDialog();
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().clickEveryDayButton();
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().clickStartTimeLink();
//
//							if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) {
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//										.verifyUIOnDatePickerDialog();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//										.pickHour();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//										.pickMinute();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//										.pickMedian();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.pickYourTime();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//										.clickOkButton();
//							}
//
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().clickStopTimeLink();
//
//							if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) {
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.pickHour();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.pickMinute();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.pickMedian();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.pickYourTime();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//								.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//								.clickOkButton();
//							}
//
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().clickSaveChangesButton();
//							super.pause(3);
//							profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.clickAddScheduleButton();
//
//							if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//									.getInternetBlockingScheduleDialogObject().isAt()) {
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().clickCustomButton();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().verifyUIOnCustomClick();
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().clickSunday(); // take a argument and change source to switch statement
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().clickStartTimeLink();
//								if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) {
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.verifyUIOnDatePickerDialog();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickHour();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickMinute();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickMedian();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.clickOkButton();
//								}
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().clickStopTimeLink();
//								if (profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) {
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickHour();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickMinute();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.pickMedian();
//									profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//											.getInternetBlockingScheduleDialogObject().getDatePickerDialogObject()
//											.clickOkButton();
//								}
//
//								profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject()
//										.getInternetBlockingScheduleDialogObject().clickSaveChangesButton();
//								super.pause(3);
//							}
//						}
//					}
//					profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject().verifyUIonAddRuleEnableScheduleTimePage();
//					profiles.getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickBackButton();
				}
				profiles.getUserProfilePageObject().clickRuleListExpandButton();
				profiles.getUserProfilePageObject().verifyAssociatedRulesList();
				profiles.getUserProfilePageObject().clickRuleListExpandButton();
				profiles.getUserProfilePageObject().clickBackButton();
			}
			if(profiles.isAt())
			{
				profiles.enablePauseInternetAccessForAllUserProfiles();
				profiles.verifyPauseInternetAccessForAllUserProfile();
				super.pause(3);
				profiles.clickCurrentlyBlockedTab();
				if(profiles.getParentalControlCurrentlyBlockedTabPageObject().isAt())
				{
					profiles.getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles();
					profiles.getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab();
				}
				profiles.disablePauseInternetAccessForAllProfiles();
				profiles.verifyResumeInternetAccessForAllUserProfile();
				super.pause(3);
				profiles.clickCurrentlyBlockedTab();
				if(profiles.getParentalControlCurrentlyBlockedTabPageObject().isAt())
				{
					profiles.getParentalControlCurrentlyBlockedTabPageObject().verifyNoBlockedProfileMessages();
					profiles.getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab();
				}
				profiles.clickBackButton();	
				//Pause internet for all the profiles.  switch should be ON.
				//click Currently blocked tab and check if all the blocked user profiles are listed 
				//switch off for child 1
				//come back to proflies tab and verify is the pause all profiles switch is OFF.
			}
		});
	}
}