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
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC56_Login_And_Verify_MainDevicesPage_Workflow;
import com.cs.arris.Workflows.TC57_Login_And_Verify_NetworkPage_Workflow;

public class TC011_Login_And_Test_Network_Page extends ParentClass {
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
		utils.log().info("\n" + "\n" + "****** starting test :  " + m.getName() + "  ******" + "\n");
	}

	@Test(priority = 1)
	public void Login_And_Onboard() {
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
		}).networkPage(network -> {
			network.isAt();
		});
	}

	@Test(priority = 2)
	public void Verify_Newtork_UI_Page() {
		SoftAssert softnet2 = new SoftAssert();
		softnet2.assertTrue(new NetworkPage().verifyUIOnNetworkPage());
		softnet2.assertAll();
	}

	@Test(priority = 3)
	public void Verify_Newtork_Help_Page() {
		SoftAssert softnet3 = new SoftAssert();
		softnet3.assertTrue(new NetworkPage().clickHelpButton());
		softnet3.assertTrue(new NetworkPage().getNetworkHelpPageObject().clickCloseButton());
		softnet3.assertAll();
	}

	@Test(priority = 4)
	public void Verify_Newtork_Test_Connection_Speed_Page() {
		SoftAssert softnet4 = new SoftAssert();
		softnet4.assertTrue(new NetworkPage().clickTestConnectionSpeedButton());
		softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().performSpeedTest());
		softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().clickBackButton());
		softnet4.assertAll();
	}

	@Test(priority = 5)
	public void Verify_WAN_Settings_UI_Page() {
		SoftAssert softnet5 = new SoftAssert();
		softnet5.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
		super.swipeUp();
		softnet5.assertTrue(new NetworkPage().clickWANSettings());
		if (new NetworkPage().getAppRatingPageObject().isAt()) {
			softnet5.assertTrue(new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink());
			softnet5.assertTrue(new NetworkPage().getWANSettingsPageObject().verifyUIOnWANSettingsPage());
		}
		softnet5.assertAll();
	}

	@Test(priority = 6)
	public void Verify_WAN_Settings_Help_Page() {
		SoftAssert softnet6 = new SoftAssert();
		if (new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt())
			softnet6.assertTrue(new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton());
		softnet6.assertAll();
	}

	@Test(priority = 7)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page() {
		SoftAssert softnet7 = new SoftAssert();
		new NetworkPage().getWANSettingsPageObject().clickWANIPConfigurationLink();
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt())
			softnet7.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP());
		softnet7.assertAll();
	}

	@Test(priority = 8)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page() {
		SoftAssert softnet8 = new SoftAssert();
		softnet8.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static());
		softnet8.assertAll();
	}

	@Test(priority = 9)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page() {
		SoftAssert softnet9 = new SoftAssert();
		softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab());
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt())
			softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful());
		softnet9.assertAll();
	}

	@Test(priority = 10)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page() {
		SoftAssert softnet10 = new SoftAssert();
		softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless());
		softnet10.assertAll();
	}

	@Test(priority = 11)
	public void Verify_WAN_Settings_WAN_IP_Configuration_Help_Page() {
		SoftAssert softnet11 = new SoftAssert();
		new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt()) {
			softnet11.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
			softnet11.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
		}
		softnet11.assertAll();
	}
	
	@Test(priority = 12)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page() 
	{
		SoftAssert softnet12 = new SoftAssert();
		softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().clickDNSConfigurationLink());
		if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
			softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic());
		softnet12.assertAll();
	}
	
	@Test(priority = 13)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page() 
	{
		SoftAssert softnet13 = new SoftAssert();
		softnet13.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static());
		softnet13.assertAll();
	}
	
	@Test(priority = 14)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page() 
	{
		SoftAssert softnet14 = new SoftAssert();
		softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab());
		if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
			softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic());
		softnet14.assertAll();
	}
	
	@Test(priority = 15)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page() 
	{
		SoftAssert softnet15 = new SoftAssert();
		softnet15.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Static());
		softnet15.assertAll();
	}
	
	@Test(priority = 16)
	public void Verify_WAN_Settings_DNS_Configuration_Help_Page() 
	{
		SoftAssert softnet16 = new SoftAssert();
		softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton());
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt())
			softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
			softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			softnet16.assertAll();
	}
	
	@Test(priority = 17)
	public void Verify_WAN_Settings_LAC_Alert_Dialog() 
	{
		SoftAssert softnet17 = new SoftAssert();
		if (new NetworkPage().getWANSettingsPageObject().isAt()) 
			softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().clickLacAlertIcon());
			if(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().isAt())
				softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog());
				softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
		softnet17.assertAll();
	}
	
	@Test(priority = 18)
	public void Verify_LAN_Settings_UI_Page() 
	{
		SoftAssert softnet18 = new SoftAssert();
		if (new NetworkPage().isAt()) {
			softnet18.assertTrue(new NetworkPage().clickLANSettings());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			softnet18.assertTrue(new NetworkPage().getLANSettingsPageObject().verifyUIOnLANSettingsPage());
		}
		softnet18.assertAll();
	}
	
	@Test(priority = 19)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Page() 
	{
		SoftAssert softnet19 = new SoftAssert();
		softnet19.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANIPResevationLink());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().isAt())
			softnet19.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyUIOnNetworkLANIPReservationPage());
		softnet19.assertAll();
	}
	
	@Test(priority = 20)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page() 
	{
		SoftAssert softnet20 = new SoftAssert();
		new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
		{
			softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().verifyUIOnReserveLANIP());
			softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName());
			softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress());
			softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice(2));
			softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton());
			softnet20.assertAll();
		}
	}
	
	@Test(priority = 21)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Rules() 
	{
		SoftAssert softnet21 = new SoftAssert();
		softnet21.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyRulesOnLAPIPReservationPage());
		softnet21.assertAll();
	}
	
	@Test(priority = 22)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Edit_Devices_Page() 
	{
		SoftAssert softnet22 = new SoftAssert();
		softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickEditLAPIPReservation());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().isAt())
		{
			softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().verifyUIOnEditReserveLANIP());
			softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editRuleName());
			softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editIPAddress());
			softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().clickSaveButton());
		}
		softnet22.assertAll();

	}

	@Test(priority = 23)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page() {
		SoftAssert softnet23 = new SoftAssert();
		softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton());
		if (new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt()) {
			softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton());
			softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton());
		}
		softnet23.assertAll();
	}
	
	@Test(priority = 24)
	public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page() 
	{
		SoftAssert softnet24 = new SoftAssert();
		softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANSubnetLink());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().isAt()) {
			softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyUIOnLANSubnetConfigurationPage());
			softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyDHCPIPAddressRangeForSelectedSubnet());
		}
		softnet24.assertAll();
	}
	
	@Test(priority = 25)
	public void Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page() 
	{
		SoftAssert softnet25 = new SoftAssert();
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForFirstSubnet());
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForSecondSubnet());
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForThirdSubnet());
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And255());
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().clickCloseButton());
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix());
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().clickCloseButton());
		
		softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickResetToDefaultButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());

		softnet25.assertAll();
	}
	
	@Test(priority = 26)
	public void Edit_LAN_Subnet_Configuration_Octets() 
	{
		SoftAssert softnet26 = new SoftAssert();
		
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyFirstLANSubnetConfigurationWithInvalidOctet());
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText1.getText() + " is displayed");
		
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifySecondLANSubnetConfigurationWithInvalidOctet());
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText2.getText() + " is displayed");

		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithInvalidOctet());
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText3.getText() + " is displayed");
		
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithSecondInvalidOctet());
		softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressTex16_31.getText() + " is displayed");
		
		softnet26.assertAll();
	}
	
	@Test(priority = 27)
	public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page() 
	{
		SoftAssert softnet27 = new SoftAssert();
		softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickHelpButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().isAt()) {
				softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().clickCloseButton());
				softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickBackButton());
			softnet27.assertAll();
		}
	}
	
	@Test(priority = 28)
	public void Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page() 
	{
		SoftAssert softnet28 = new SoftAssert();
			if(new NetworkPage().getLANSettingsPageObject().isAt())
				softnet28.assertTrue(new NetworkPage().getLANSettingsPageObject().clickDHCPLeaseTimeLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().isAt())
				softnet28.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyUIOnLANLeaseTimePage());
			softnet28.assertAll();
	}
	
	@Test(priority = 29)
	public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page() 
	{
		SoftAssert softnet29 = new SoftAssert();
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt()){
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().verifyUIOnLANEditLeaseTimePage());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());}
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithMinutesTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickHourlyRadioButton());
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithHourlyTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickDaysRadioButton());
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithDaysTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickWeeklyRadioButton());
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithWeeklyTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickForeverRadioButton());
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithForeverTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
		softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifySameLeaseTimeForAnyUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedSameChangesDialogObject().isAt())
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedSameChangesDialogObject().clickOKButton());
		
		softnet29.assertAll();
	}
	
	@Test(priority = 30)
	public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Help_Page() 
	{
		SoftAssert softnet30 = new SoftAssert();
		softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickHelpButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().isAt())
			softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().clickCloseButton());
			softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
			softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
			softnet30.assertAll();
	}
	
	@Test(priority = 31)
	public void Verify_Device_Priority_Settings_UI_Page() 
	{
		SoftAssert softnet31 = new SoftAssert();
		softnet31.assertTrue(new NetworkPage().clickDevicePrioritySettings());
		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
		{
			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().enableDevicePrioritySettings());
			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnDevicePrioritySettingsPage());
			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
		}
		softnet31.assertAll();
	}
	
	@Test(priority = 32)
	public void Verify_Device_Priority_Settings_Add_Device_UI_Page() 
	{
		SoftAssert softnet32 = new SoftAssert();
		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().isAt()) {
			softnet32.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyUIOnAddDevicePage());
			softnet32.assertAll();
		}
	}
	
	@Test(priority = 33)
	public void Verify_Device_Priority_Settings_Add_Device_Page() 
	{
		SoftAssert softnet33 = new SoftAssert();
		softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyDeviceListForPrioritization());
		softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
		softnet33.assertAll();

	}
	
	@Test(priority = 34)
	public void Verify_Device_Priority_Settings_Added_Device_Page() 
	{
		SoftAssert softnet34 = new SoftAssert();
		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt()) {
			softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnNetworkPrioritizedDevices());
			softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyTwoDevicesWithHighestPriority());}
		softnet34.assertAll();
	}
	
	@Test(priority = 35)
	public void Verify_Device_Priority_Settings_Add_Device_Help_Page() 
	{
		SoftAssert softnet35 = new SoftAssert();
		softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickHelpButton());
		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().isAt())
			softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().clickCloseButton());
		softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickBackButton());
		softnet35.assertAll();
	}
	
	@Test(priority = 36)
	public void Verify_Device_Priority_Settings_Help_Page() 
	{
		SoftAssert softnet36 = new SoftAssert();
		softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickHelpButton());
		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().isAt())
			softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().clickCloseButton());
		softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickBackButton());
		softnet36.assertAll();
	}
	
	@Test(priority = 37)
	public void Verify_Time_Zone_Settings_UI_Page() 
	{
		SoftAssert softnet37 = new SoftAssert();
		super.swipeUp();
		softnet37.assertTrue(new NetworkPage().clickTimeZone());
		if(new NetworkPage().getTimeZoneSettingsPageObject().isAt())
			softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().verifyUIOnTimeZonePage());
		softnet37.assertAll();
	}
	
	@Test(priority = 38)
	public void Verify_Time_Zone_Settings_Help_Page() 
	{
		SoftAssert softnet38 = new SoftAssert();
		softnet38 .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHelpButton());
		if (new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().isAt())
			softnet38 .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().clickCloseButton());
		softnet38 .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickBackButton());
		softnet38 .assertAll();
	}
	
	@Test(priority = 39)
	public void Verify_General_Settings_UI_Page() 
	{
		SoftAssert softnet39 = new SoftAssert();
		softnet39.assertTrue(new NetworkPage().clickGeneralSettings());
		if(new NetworkPage().getGeneralSettingsPageObject().isAt())
			softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().verifyUIOnGeneralSettingsPage());
		softnet39.assertAll();
	}
	
	@Test(priority = 40)
	public void Verify_General_Settings_UPnP_Settings() 
	{
		SoftAssert softnet40 = new SoftAssert();
		softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().disableUPnP());
		softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().enableUPnP());
		softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickUPNPInfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().isAt())
			softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().clickCloseButton());
		softnet40.assertAll();
	}
	
	@Test(priority = 41)
	public void Verify_General_Settings_IPv6_Enable_Settings() 
	{
		SoftAssert softnet39 = new SoftAssert();
		softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickIPv6InfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().isAt())
			softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().clickCloseButton());
		softnet39.assertAll();
	}
	
	@Test(priority = 42)
	public void Verify_General_Settings_Bridge_Mode_Settings() 
	{
		SoftAssert softnet42 = new SoftAssert();
		softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBridgeModeInfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().isAt())
			softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().clickCloseButton());
		softnet42.assertAll();
	}
	
	@Test(priority = 43)
	public void Verify_General_Settings_Port_Forwarding_Settings() 
	{
		SoftAssert softnet43 = new SoftAssert();
		new NetworkPage().getGeneralSettingsPageObject().clickPortForwardingink();
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt())
			softnet43.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().verifyUIOnPortForwardingPage());
		softnet43.assertAll();
	}
	
	@Test(priority = 44)
	public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Page() 
	{
		SoftAssert softnet44 = new SoftAssert();
		new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
		{
			super.getDriver().hideKeyboard();
			softnet44.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyUIOnPortForwardingAddRulePage());
		}
		softnet44.assertAll();
	}
	
	@Test(priority = 45)
	public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Validations() 
	{
		SoftAssert softnet45 = new SoftAssert();
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterPortForwardingRuleName());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortStart());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortEnd());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyInternalPortStartLessThenPortEnd());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortStart());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortEnd());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterValidIPAddress());
		softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInValidIPAddress());
		
		softnet45.assertAll();
	}
	
	@Test(priority = 46)
	public void Verify_General_Settings_Port_Forwarding_Help_Page() 
	{
		SoftAssert softnet46 = new SoftAssert();
		softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickHelpButton());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().isAt())
			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().clickCloseButton());
		
		softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickBackButton());
		softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBackButton());
		softnet46.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
		softnet46.assertAll();
	}
	
	@Test(priority = 47)
	public void Verify_Guest_WiFi_Network_Page() 
	{
		SoftAssert softnet47 = new SoftAssert();
		softnet47.assertTrue(new NetworkPage().enableGuestWifiNetwork());
		
		try {
			if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
				softnet47.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOKButton());
			super.pause(20);
		}catch(Exception e) {}
		
		try {
			if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt())
			super.getDriver().hideKeyboard();
			softnet47.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
			softnet47.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickCloseButton());
			}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
		
		try {
			softnet47.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
			softnet47.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
			if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
				softnet47.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
				softnet47.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); }
			softnet47.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
		}catch(Exception e) {utils.log().info("Guest Network is not Created");}
		
		softnet47.assertAll();
	}
	
	@Test(priority = 48)
	public void Verify_Extended_WiFi_Settings_Page() 
	{
		SoftAssert softnet48 = new SoftAssert();
		softnet48.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
		softnet48.assertTrue(new NetworkPage().enable5GHzWidebandMode());
		if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
			softnet48.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickOKButton());
		softnet48.assertTrue(new NetworkPage().clickfiveGHzWidebandInfoIcon());
		
		if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
			softnet48.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickCloseButton());
		
		softnet48.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
		softnet48.assertTrue(new NetworkPage().clickBackButton());
		softnet48.assertAll();
	}
}

