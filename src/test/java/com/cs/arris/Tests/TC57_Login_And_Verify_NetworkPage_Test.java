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
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC56_Login_And_Verify_MainDevicesPage_Workflow;
import com.cs.arris.Workflows.TC57_Login_And_Verify_NetworkPage_Workflow;

public class TC57_Login_And_Verify_NetworkPage_Test extends ParentClass {
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
		utils.log().info("****** starting test:" + m.getName() + "******");
	}

	@Test(priority = 1)
	public void Login_To_Verify_Network_Page() 
	{
		SoftAssert softnet1 = new SoftAssert();
		TC57_Login_And_Verify_NetworkPage_Workflow.getStartedPage(getStarted -> {
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
		}).homePage(home -> {
			try {
				if (home.okButton.isDisplayed()) {
					home.clickOkButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
			if (home.isAt()) {
				home.getFooterIconsPageObject().clickNetworkButton();
			}
//		}).networkPage(network -> {
//			if (network.isAt())
//			{
//				this.Verify_Newtork_Page_UI(network);
//			}
		});
	}
	
	@Test(priority = 2)
	public void Verify_Newtork_UI_Page(NetworkPage network) {
		SoftAssert softnet2 = new SoftAssert();
		try {
			if(network.isAt())
			{
				network.verifyUIOnNetworkPage();
			}
		}catch(Exception e) {		
			e.printStackTrace();
			softnet2.fail();
		}
	}
	
	@Test(priority = 3)
	public void Verify_Newtork_Help_Page(NetworkPage network) {
		SoftAssert softnet3 = new SoftAssert();
		try {
			network.clickHelpButton();
			network.getNetworkHelpPageObject().clickCloseButton();
		} catch(Exception e) {
			e.printStackTrace();
			softnet3.fail();
		}
	}
	
	@Test(priority = 4)
	public void Verify_Newtork_Test_Connection_Speed_Page(NetworkPage network) 
	{
		SoftAssert softnet4 = new SoftAssert();
		try {
			network.clickTestConnectionSpeedButton();
			network.getSpeedTestPageObject().performSpeedTest();
			network.getSpeedTestPageObject().clickBackIcon();
		} catch(Exception e) {
			e.printStackTrace();
			softnet4.fail();
		}
	}
	
	@Test(priority = 5)
	public void Verify_WAN_Settings_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet5 = new SoftAssert();
		try {
			network.clickWANSettings();
			if (network.getAppRatingPageObject().isAt())
			{
				network.getAppRatingPageObject().clickRemindMeLaterLink();
				network.getWANSettingsPageObject().verifyUIOnWANSettingsPage();
				network.getSpeedTestPageObject().clickBackIcon();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet5.fail();
		}
	}
	
	@Test(priority = 6)
	public void Verify_WAN_Settings_Help_Page(NetworkPage network) 
	{
		SoftAssert softnet6 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().verifyUIOnNetworWANSettingsHelpPage();
				network.getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet6.fail();
		}
	}
	
	@Test(priority = 7)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet7 = new SoftAssert();
		try {
			network.getWANSettingsPageObject().clickWANIPConfigurationLink();
			if (network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet7.fail();
		}
	}
	
	@Test(priority = 8)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet8 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet8.fail();
		}
	}
	
	@Test(priority = 9)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet9 = new SoftAssert();
		try {
			network.getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab();
			if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet9.fail();
		}
	}
	
	@Test(priority = 10)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet10 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet10.fail();
		}
	}
	
	@Test(priority = 11)
	public void Verify_WAN_Settings_WAN_IP_Configuration_Help_Page(NetworkPage network) 
	{
		SoftAssert softnet11 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
				if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt())
					network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton();
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet11.fail();
		}
	}
	
	@Test(priority = 12)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet12 = new SoftAssert();
		try {
			network.getWANSettingsPageObject().clickDNSConfigurationLink();
			if (network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet12.fail();
		}
	}
	
	@Test(priority = 13)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet13 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet13.fail();
		}
	}
	
	@Test(priority = 14)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet14 = new SoftAssert();
		try {
			network.getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab();
			if (network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet14.fail();
		}
	}
	
	@Test(priority = 15)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet15 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickStaticRadioButton();

			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet15.fail();
		}
	}
	
	@Test(priority = 16)
	public void Verify_WAN_Settings_DNS_Configuration_Help_Page(NetworkPage network) 
	{
		SoftAssert softnet16 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
				if (network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt())
					network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton();
				network.getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet16.fail();
		}
	}
	
	@Test(priority = 17)
	public void Verify_WAN_Settings_LAC_Alert_Dialog(NetworkPage network) 
	{
		SoftAssert softnet17 = new SoftAssert();
		try {
			if (network.getWANSettingsPageObject().isAt()) 
			{
				network.getWANSettingsPageObject().clickLacAlertIcon();
				if(network.getWANSettingsPageObject().getLACAlertDialogObject().isAt())
					network.getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog();
				network.getWANSettingsPageObject().clickBackButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet17.fail();
		}
	}
	
	@Test(priority = 18)
	public void Verify_LAN_Settings_UI_Page(NetworkPage network) 
	{
		SoftAssert softnet18 = new SoftAssert();
		try {
			if (network.isAt()) 
			{
				network.clickLANSettings();
				try
				{
					if(network.getAppRatingPageObject().isAt())
						network.getAppRatingPageObject().clickRemindMeLaterLink();
				} catch (Exception exp) {
					utils.log().info("App Rating Dialog did not appear");
				}
				network.getLANSettingsPageObject().verifyUIOnLANSettingsPage();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet18.fail();
		}
	}
	
	@Test(priority = 19)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Page(NetworkPage network) 
	{
		SoftAssert softnet19 = new SoftAssert();
		try {
			network.getLANSettingsPageObject().clickLANIPResevationLink();
			if(network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().isAt())
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyUIOnNetworkLANIPReservationPage();
		} catch(Exception e) {
			e.printStackTrace();
			softnet19.fail();
		}
	}
	
	@Test(priority = 19)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page(NetworkPage network) 
	{
		SoftAssert softnet19 = new SoftAssert();
		try {
			network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
			if(network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
				{
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().verifyUIOnReserveLANIP();
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName();
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress();
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice();
					network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton();
				}
		} catch(Exception e) {
			e.printStackTrace();
			softnet19.fail();
		}
	}
	
	@Test(priority = 20)
	public void Verify_LAN_Settings_LAN_IP_Reservation_For_Devices_Page(NetworkPage network) 
	{
		SoftAssert softnet20 = new SoftAssert();
		try {
			network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyDevicesOnLAPIPReservationPage();
		} catch(Exception e) {
			e.printStackTrace();
			softnet20.fail();
		}
	}
	
	@Test(priority = 20)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Edit_Devices_Page(NetworkPage network) 
	{
		SoftAssert softnet20 = new SoftAssert();
		try {
			network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickEditLAPIPReservation();
			if(network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().isAt())
			{
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().verifyUIOnEditReserveLANIP();
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editRuleName();
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editIPAddress();
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().clickSaveButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet20.fail();
		}
	}
	
	@Test(priority = 21)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page(NetworkPage network) 
	{
		SoftAssert softnet21 = new SoftAssert();
		try {
			network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton();
			if(network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt())
			{
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton();
				network.getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton();
			}
		} catch(Exception e) {
			e.printStackTrace();
			softnet21.fail();
		}
	}
}





//				}
				
//				network.clickNetworkSettingsExpandButton();


			
			// network.clickBackButton(); //goes back to home page



