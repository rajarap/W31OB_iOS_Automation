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
	public MobileElement secondRadioFirstButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_two_digit_2")
	public MobileElement secondRadioButtonSecondDigit;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_et_ipaddress_two_digit_3")
	public MobileElement secondRadioButtonThridDigit;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_tv_ipaddress_two_digit_4")
	public MobileElement secondRadioButtonFourthDigit;
	
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rb_rb_ipaddress_three_digit_1")
	public MobileElement thirdRadioFirstButton;
	
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
	public MobileElement saveSubnetMask;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/rest_subnet_configure")
	public MobileElement resetSubnetMask;
	
		
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
	 
	public void clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");
			}
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
		}
	}
	
	public void clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}
	
	public void clickSaveButton() {
		try {
			if (saveSubnetMask.isDisplayed()) {
				click(saveSubnetMask);
				utils.log().info("Clicked on Save Changes button");
			}
		} catch (Exception e) {
			utils.log().info("Save Changes button is not displayed");
		}
	}
	
	public void clickResetToDefaultButton() {
		try {
			if (resetSubnetMask.isDisplayed()) {
				click(resetSubnetMask);
				utils.log().info("Clicked on Reset To Default button");
			}
		} catch (Exception e) {
			utils.log().info("Reset To Default button is not displayed");
		}
	}

	public boolean verifyUIOnNetworkPage() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Verifying UI Elements on LAN Subnet Configuration Page ");
		utils.log().info("*******************************************************");
		try
		{
			if (lanSubnetConfigurationTitle.isDisplayed())
				utils.log().info(lanSubnetConfigurationTitle.getText() + " title text is displayed ");
//			else
//				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
//			else
//				utils.log().info("Back Icon is not displayed");
			
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed ");
//			else
//				utils.log().info("Back Icon is not displayed");

			if (configureSubnetLabel.isDisplayed())
				utils.log().info(configureSubnetLabel.getText() + " label is displayed");
//			else
//				utils.log().info("Help Icon is not displayed");
//		
			if (firstRadiodButtonFirstDigit.isDisplayed() && firstRadioButtonSecondDigit.isDisplayed() && 
					firstRadioButtonThridDigit.isDisplayed() && firstRadioButtonFourthDigit.isDisplayed())
				utils.log().info("First subnet IP address is displayed");
//			else
//				utils.log().info("Set Lease Time label is displayed");
			
			if (secondRadioFirstButton.isDisplayed() && secondRadioButtonSecondDigit.isDisplayed() && 
					secondRadioButtonThridDigit.isDisplayed() && secondRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Second subnet IP address is displayed");
//			else
//				utils.log().info("Enter Lease Time TextBoxis not displayed");
			
			if (thirdRadioFirstButton.isDisplayed() && thirdRadioButtonSecondDigit.isDisplayed() && 
					thirdRadioButtonThridDigit.isDisplayed() && thirdRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Third subnet IP address is displayed");

//			else
//				utils.log().info("Select Time Unit Label is not displayed");
			
			if (dncpRangeLabel.isDisplayed())
				utils.log().info("DHCP Range Label is displayed");
//			else
//				utils.log().info("Button to select the time unit is not displayed");
			
			if (startingIPLabel.isDisplayed())
				utils.log().info("Starting IP Label is displayed");
			
			if (startingIPPrefix.isDisplayed() && startingIPSuffix.isDisplayed())
				utils.log().info("Starting IP Label is displayed");
			
			if (endingIPLabel.isDisplayed())
				utils.log().info("Ending IP Label is displayed");
			
			if (endingIPPrefix.isDisplayed() && endingIPSuffix.isDisplayed())
				utils.log().info("Ending IP Label is displayed");
			
			if (subnetMaskIPLabel.isDisplayed())
				utils.log().info("Subnet Mask Label is displayed");
			
			if (subnetMask.isDisplayed())
				utils.log().info("Subnet Mask : " + subnetMask.getText() + " is displayed");
			
			if (saveSubnetMask.isDisplayed())
				utils.log().info(saveSubnetMask.getText() + " button is displayed");
			
			if (resetSubnetMask.isDisplayed())
				utils.log().info(resetSubnetMask.getText() + " button is displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

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
