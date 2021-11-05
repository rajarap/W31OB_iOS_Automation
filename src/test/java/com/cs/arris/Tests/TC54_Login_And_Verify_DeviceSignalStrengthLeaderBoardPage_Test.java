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
import com.cs.arris.Workflows.TC54_Login_And_Verify_DeviceSignalStrengthLeaderBoardPage_Workflow;

public class TC54_Login_And_Verify_DeviceSignalStrengthLeaderBoardPage_Test extends ParentClass {
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
	public void Verify_DevicesPage() {
		TC54_Login_And_Verify_DeviceSignalStrengthLeaderBoardPage_Workflow.getStartedPage(getStarted -> {
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
			if (home.isAt()) {
				super.pause(5);
				home.clickDeviceSignalStrengthImage();
			}
		}).deviceSignalStrengthPage(deviceSignalStrength -> {
			if (deviceSignalStrength.isAt()) {
				deviceSignalStrength.verifyUIOnDeviceSignalStrengthPage();
				deviceSignalStrength.verifySignalStrengthForDevices();
				deviceSignalStrength.sortWeakToStrong();
				deviceSignalStrength.sortStrongToWeak();
				deviceSignalStrength.getFooterIconsPageObject().clickHomeButton();		
//				if (deviceSignalStrength.getHomePageObject().isAt()) {
//					super.pause(5);
//					deviceSignalStrength.getHomePageObject().clickDeviceSignalStrengthImage();
			}
		});
	}
}

//if (deviceSignalStrength.isAt()) {
//	deviceSignalStrength.getFooterIconsPageObject().clickNetworkButton();
//	if (deviceSignalStrength.getNetworkPageObject().isAt()) {
//		deviceSignalStrength.getNetworkPageObject().clickBackButton();
//	}
//}
//if (deviceSignalStrength.getHomePageObject().isAt()) {
//	deviceSignalStrength.getHomePageObject().clickDeviceSignalStrengthImage();
//}
//if (deviceSignalStrength.isAt()) {
//	deviceSignalStrength.getFooterIconsPageObject().clickParentalButton();
//	if (deviceSignalStrength.getParentalControlPageObject().isAt()) {
//		deviceSignalStrength.getParentalControlPageObject().clickBackButton();
//	}
//}
//if (deviceSignalStrength.getHomePageObject().isAt()) {
//	deviceSignalStrength.getHomePageObject().clickDeviceSignalStrengthImage();
//}
