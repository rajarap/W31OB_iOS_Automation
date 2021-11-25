package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NetworkLANSubnetDHCPRangeConfigurationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement lanSubnetConfigurationTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/textView")
	public MobileElement configureSubnetLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_rb_ipaddress_one_digit_1")
	public MobileElement firstRadiodButtonFirstDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_one_digit_2")
	public MobileElement firstRadioButtonSecondDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_one_digit_3")
	public MobileElement firstRadioButtonThridDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_tv_ipaddress_one_digit_4")
	public MobileElement firstRadioButtonFourthDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_rb_ipaddress_two_digit_1")
	public MobileElement secondRadioFirstDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_two_digit_2")
	public MobileElement secondRadioButtonSecondDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_two_digit_3")
	public MobileElement secondRadioButtonThridDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_tv_ipaddress_two_digit_4")
	public MobileElement secondRadioButtonFourthDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_rb_ipaddress_three_digit_1")
	public MobileElement thirdRadioFirstDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_three_digit_2")
	public MobileElement thirdRadioButtonSecondDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_three_digit_3")
	public MobileElement thirdRadioButtonThridDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_tv_ipaddress_three_digit_4")
	public MobileElement thirdRadioButtonFourthDigit;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/linear_dhcp_range")
	public MobileElement dncpRangeLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Starting IP']")
	public MobileElement startingIPLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/sub_net_start_ip_prefix")
	public MobileElement startingIPPrefix;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/et_starting_ip_digit_4")
	public MobileElement startingIPSuffix;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ending IP']")
	public MobileElement endingIPLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/sub_net_end_ip_prefix")
	public MobileElement endingIPPrefix;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/et_ending_ip_digit_4")
	public MobileElement endingIPSuffix;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Subnet Mask']")
	public MobileElement subnetMaskIPLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/et_subnet_mask")
	public MobileElement subnetMask;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/save_subnet_configure")
	public MobileElement saveButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rest_subnet_configure")
	public MobileElement resetSubnetButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_one_et_error")
	public MobileElement enterValidIPAddressText1;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_two_et_error")
	public MobileElement enterValidIPAddressText2;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_three_et_error")
	public MobileElement enterValidIPAddressText3;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_three_et_error")
	public MobileElement enterValidIPAddressTex16_31;

	
	public NetworkLANSubnetDHCPRangeConfigurationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}

	public NetworkLANSubnetDHCPConfigurationHelpPage getLANSubnetRangeHelpPageObject() {
		NetworkLANSubnetDHCPConfigurationHelpPage lanSubnetRangeHelp = new NetworkLANSubnetDHCPConfigurationHelpPage();
		return lanSubnetRangeHelp;
	}
	
	public NetworkLANDHCPIPRangeBetween1And255AlertDialog getLANDHCPBetween1And255DialogObject() {
		NetworkLANDHCPIPRangeBetween1And255AlertDialog landhcpRange1To255 = new NetworkLANDHCPIPRangeBetween1And255AlertDialog();
		return landhcpRange1To255;
	}
	
	public NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog getLANDHCPChangeRangeIPDialogObject() {
		NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog lanChangedhcpRange = new NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog();
		return lanChangedhcpRange;
	}
	
	public NetworkLANDHCPIPRangeEmptyOctetAlertDialog getLANDHCPEmptyOCtetDialogObject() {
		NetworkLANDHCPIPRangeEmptyOctetAlertDialog landhcpEmptyOctet = new NetworkLANDHCPIPRangeEmptyOctetAlertDialog();
		return landhcpEmptyOctet;
	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickSaveButton() {
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save Changes button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}

	public boolean clickResetToDefaultButton() {
		if (resetSubnetButton.isDisplayed()) {
			click(resetSubnetButton);
			utils.log().info("Clicked on Reset To Default button");
			return true;
		} else {
			utils.log().info("Reset To Default button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANSubnetConfigurationPage() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Verifying UI Elements on LAN Subnet Configuration Page ");
		utils.log().info("*******************************************************");

		try
		{
			if (lanSubnetConfigurationTitle.isDisplayed())
				utils.log().info(lanSubnetConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");
			
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (configureSubnetLabel.isDisplayed())
				utils.log().info(configureSubnetLabel.getText() + " label is displayed");
			else
				utils.log().info("Help Icon is not displayed");
		
			if (firstRadiodButtonFirstDigit.isDisplayed() && firstRadioButtonSecondDigit.isDisplayed() && 
					firstRadioButtonThridDigit.isDisplayed() && firstRadioButtonFourthDigit.isDisplayed())
				utils.log().info("First Subnet IP address Radion button option : " + firstRadiodButtonFirstDigit.getText() + "." + firstRadioButtonSecondDigit.getText()
				+ "." + firstRadioButtonThridDigit.getText() + "." + firstRadioButtonFourthDigit.getText());
			else
				utils.log().info("First Subnet IP address Radion button option is not displayed");
			
			if (secondRadioFirstDigit.isDisplayed() && secondRadioButtonSecondDigit.isDisplayed() && 
					secondRadioButtonThridDigit.isDisplayed() && secondRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Second Subnet IP address Radion button option : " + secondRadioFirstDigit.getText() + "." + secondRadioButtonSecondDigit.getText()
				+ "." + secondRadioButtonThridDigit.getText() + "." + secondRadioButtonFourthDigit.getText());
			else
				utils.log().info("Second Subnet IP address Radion button option is not displayed");
			
			if (thirdRadioFirstDigit.isDisplayed() && thirdRadioButtonSecondDigit.isDisplayed() && 
					thirdRadioButtonThridDigit.isDisplayed() && thirdRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + "." + thirdRadioButtonSecondDigit.getText()
				+ "." + thirdRadioButtonThridDigit.getText() + "." + thirdRadioButtonFourthDigit.getText());
			else
				utils.log().info("Third Subnet IP address Radion button option is not displayed");
			
			if (dncpRangeLabel.isDisplayed())
				utils.log().info("DHCP Range Label is displayed");
			else
				utils.log().info("BDHCP Range Label is not displayed");
			
			if (startingIPLabel.isDisplayed())
				utils.log().info("Starting IP Label is displayed");
			else
				utils.log().info("Starting IP Label is not displayed");
			
			if (startingIPPrefix.isDisplayed() && startingIPSuffix.isDisplayed())
				utils.log().info("DHCP Rage Starting IP Prefix is : " + startingIPPrefix.getText() + " and Suffix IP : " + startingIPSuffix.getText()+ " is displayed");
			else
				utils.log().info("DHCP Rage Starting IP Prefix and Suffix is not displayed");
			
			if (endingIPLabel.isDisplayed())
				utils.log().info("Ending IP Label is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			if (endingIPPrefix.isDisplayed() && endingIPSuffix.isDisplayed())
				utils.log().info("DHCP Rage Ending IP Prefix is : " + endingIPPrefix.getText() + " and Suffix IP : " + endingIPSuffix.getText()+ " is displayed");
			else
				utils.log().info("DHCP Rage Ending IP Label Prefix and Suffix is not displayed");
			
			if (subnetMaskIPLabel.isDisplayed())
				utils.log().info("Subnet Mask Label is displayed");
			else
				utils.log().info("Subnet Mask Label is not displayed");
			
			if (subnetMask.isDisplayed() && !(subnetMask.isEnabled()))
				utils.log().info("Subnet Mask : " + subnetMask.getText() + " is displayed and is disabled. Subnet Mask cannot be changed");
			else
				utils.log().info("Subnet Mask is not displayed");
			
			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " button is displayed");
			else
				utils.log().info("Save Subnet Mask Button is not displayed");
			
			if (resetSubnetButton.isDisplayed())
				utils.log().info(resetSubnetButton.getText() + " button is displayed");
			else
				utils.log().info("Reset Subnet Mask Button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyDHCPIPAddressRangeForSelectedSubnet() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying DHCP IP Address Range For Selected Subnet ");
		utils.log().info("****************************************************");
		
		click(firstRadiodButtonFirstDigit);
		utils.log().info("First Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("First Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		
		click(secondRadioFirstDigit);
		utils.log().info("Second Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("Second Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		
		click(thirdRadioFirstDigit);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		
		return true;
		
	}
	
	public boolean EditDHCPIPAddressRangeForFirstSubnet() {
		utils.log().info("                                               ");
		utils.log().info("************************************************");
		utils.log().info("Changing DHCP IP Address Range For First Subnet ");
		utils.log().info("************************************************");
		
		click(firstRadiodButtonFirstDigit);
		utils.log().info("First Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("First Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		super.sendKeys(startingIPSuffix, "10");
		utils.log().info("First Subnet - Starting DHCP IP Address Range is Changed to : " + startingIPPrefix.getText() + startingIPSuffix.getText());
		super.sendKeys(startingIPSuffix, "150");
		utils.log().info("First Subnet - Ending DHCP IP Address Range is Changed to : " + endingIPPrefix.getText() + endingIPSuffix.getText());
		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
		
	}
	
	public boolean EditDHCPIPAddressRangeForSecondSubnet() {
		utils.log().info("                                                ");
		utils.log().info("*************************************************");
		utils.log().info("Changing DHCP IP Address Range For Second Subnet ");
		utils.log().info("*************************************************");
		
		click(secondRadioFirstDigit);
		utils.log().info("Second Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("Second Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		super.sendKeys(startingIPSuffix, "150");
		utils.log().info("Second Subnet - Starting DHCP IP Address Range is Changed to : " + startingIPPrefix.getText() + startingIPSuffix.getText());
		super.sendKeys(endingIPSuffix, "220");
		utils.log().info("Second Subnet - Ending DHCP IP Address Range is Changed to : " + endingIPPrefix.getText() + endingIPSuffix.getText());
		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean EditDHCPIPAddressRangeForThirdSubnet() {
		utils.log().info("                                               ");
		utils.log().info("************************************************");
		utils.log().info("Changing DHCP IP Address Range For Third Subnet ");
		utils.log().info("************************************************");
		
		click(thirdRadioFirstDigit);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		super.sendKeys(startingIPSuffix, "10");
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is Changed to : " + startingIPPrefix.getText() + startingIPSuffix.getText());
		super.sendKeys(endingIPSuffix, "150");
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is Changed to : " + endingIPPrefix.getText() + endingIPSuffix.getText());
		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
	}

	
	public boolean verifyLANDHCPRangeBetween1And255() {
		utils.log().info("                                               ");
		utils.log().info("**************************************************");
		utils.log().info("DHCP IP Address Range Should be Between 1 and 255 ");
		utils.log().info("**************************************************");
		
		click(thirdRadioFirstDigit);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix.getText() + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix.getText() + endingIPSuffix.getText());
		super.sendKeys(startingIPSuffix, "1");
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is Changed to : " + startingIPPrefix.getText() + startingIPSuffix.getText());
		super.sendKeys(endingIPSuffix, "255");
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is Changed to : " + endingIPPrefix.getText() + endingIPSuffix.getText());
		return true;
		
		// click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean verifyFirstLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                              ");
		utils.log().info("**********************************************");
		utils.log().info("Changing 3rd Octet to Invalid IP Address Range");
		utils.log().info("**********************************************");
		
		click(firstRadiodButtonFirstDigit);
		utils.log().info("Selected First Subnet IP address Radion button option : " + firstRadiodButtonFirstDigit.getText() + "." + firstRadioButtonSecondDigit.getText()
		+ "." + firstRadioButtonThridDigit.getText() + "." + firstRadioButtonFourthDigit.getText());
		super.sendKeys(firstRadioButtonThridDigit, "999");
		return true;
		
		//click save.  enterValidIPAddressText1 text should be displayed
	}
	
	public boolean verifySecondLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                                      ");
		utils.log().info("******************************************************");
		utils.log().info("Changing 2nd and 3rd Octet to Invalid IP Address Range");
		utils.log().info("******************************************************");
		
		click(secondRadioFirstDigit);
		utils.log().info("Selected Second Subnet IP address Radion button option : " + secondRadioFirstDigit.getText() + "." + secondRadioButtonSecondDigit.getText()
		+ "." + secondRadioButtonThridDigit.getText() + "." + secondRadioButtonFourthDigit.getText());
		super.sendKeys(secondRadioButtonSecondDigit, "555");
		super.sendKeys(secondRadioButtonThridDigit, "888");
		return true;
		
		//click save.  enterValidIPAddressText2 text should be displayed
	}
	
	public boolean verifyThirdLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                                      ");
		utils.log().info("******************************************************");
		utils.log().info("Changing 2nd and 3rd Octet to Invalid IP Address Range");
		utils.log().info("******************************************************");
		
		click(thirdRadioFirstDigit);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + "." + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + "." + thirdRadioButtonFourthDigit.getText());
		super.sendKeys(secondRadioButtonSecondDigit, "666");
		super.sendKeys(secondRadioButtonThridDigit, "000");
		return true;
		
		//click save.  enterValidIPAddressText3 text should be displayed
	}
	
	public boolean verifyThirdLANSubnetConfigurationWithSecondInvalidOctet() {
		utils.log().info("                                                         ");
		utils.log().info("*********************************************************");
		utils.log().info("Changing 2nd Octet value to less than 16 IP Address Range");
		utils.log().info("*********************************************************");
		
		click(thirdRadioFirstDigit);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + "." + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + "." + thirdRadioButtonFourthDigit.getText());
		super.sendKeys(secondRadioButtonSecondDigit, "10");
		return true;
		
		//click save. enterValidIPAddressTex16_31 text should be displayed
	}
	
	public boolean verifyLANDHCPRangeWithEmptySuffix() {
		utils.log().info("                                                                        ");
		utils.log().info("************************************************************************");
		utils.log().info("Select 3rd Subnet and Configure DHCP Starting IP Range with Empty Suffix");
		utils.log().info("************************************************************************");
		
		click(thirdRadioFirstDigit);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + "." + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + "." + thirdRadioButtonFourthDigit.getText());
		super.sendKeys(startingIPSuffix, " ");
		return true;
		
		//click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	
	//click Reset button. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear. Click close/cancel button


	@Override
	public boolean isAt() {
		if (lanSubnetConfigurationTitle.isDisplayed()) {
			utils.log().info("On LAN Subnet Configuration Page");
			return true;
		} else {
			utils.log().info("Not on LAN Subnet Configuration Page");
			return false;
		}
	}
}
