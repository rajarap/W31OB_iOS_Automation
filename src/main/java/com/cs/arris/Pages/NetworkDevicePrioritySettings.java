package com.cs.arris.Pages;

import java.util.List;

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

public class NetworkDevicePrioritySettings extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement devicePriorityTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Device Level Prioritization")
	public MobileElement deviceLevelPrioritizationLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Device Priority")
	public MobileElement networkDevicePriorityLabel;

	@AndroidFindBy(id = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/device_enable_disable']")
	public MobileElement devicePrioritySettingToggleButton;
	
	@AndroidFindBy(id = "//android.widget.Switch[@text='ON']")
	public MobileElement enabledDevicePrioritySettingToggleButton;
	
	@AndroidFindBy(id = "//android.widget.Switch[@text='OFF']")
	public MobileElement disabledDevicePrioritySettingToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/add_device_configure")
	public MobileElement addDeviceButton;


	public NetworkDevicePrioritySettings() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkDevicePrioritySettingsHelpPage getDevicePriorityHelpPageObject() {
		NetworkDevicePrioritySettingsHelpPage devicePrioritySettings = new NetworkDevicePrioritySettingsHelpPage();
		return devicePrioritySettings;
	}

	public NetworkDevicePrioritySettingsAddDevicePage getAddDevicePriorityPageObject() {
		NetworkDevicePrioritySettingsAddDevicePage addDevice = new NetworkDevicePrioritySettingsAddDevicePage();
		return addDevice;
	}
	
	public NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog getAddedTwoHighestPriorityDevicesDialogObject() {
		NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog twoDeviceWithHighestPriority = new NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog();
		return twoDeviceWithHighestPriority;
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
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}
	
	public boolean clickAddDeviceButton() {
		if (addDeviceButton.isDisplayed()) {
			click(addDeviceButton);
			utils.log().info("Clicked on Add Device Button");
			return true;		
		}else{
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}
	
//	public boolean enableDevicePrioritySettings() {
//		if (enabledDevicePrioritySettingToggleButton.isDisplayed()) {
//			utils.log().info("Device Priority Settings is enabled");
//			return true;
//		}else{
//			click(devicePrioritySettingToggleButton);
//			super.pause(35);
//			utils.log().info("Device Priority Settings is selected");
//			return true;
//		}
//	}
	
	public boolean enableDevicePrioritySettings() {
			click(devicePrioritySettingToggleButton);
			utils.log().info("Device Priority Settings is enabled");
			return true;
	}
	
//	public boolean disableDevicePrioritySettings() {
//		if (disabledDevicePrioritySettingToggleButton.isSelected()) {
//			utils.log().info("Device Priority Settings is disabled");
//			return true;
//		}else{
//			click(devicePrioritySettingToggleButton);
//			super.pause(35);
//			utils.log().info("Device Priority Settings is disabled");
//			return false;
//		}
//	}
	
	public boolean disableDevicePrioritySettings() {
			click(devicePrioritySettingToggleButton);
			super.pause(35);
			utils.log().info("Device Priority Settings is disabled");
			return false;
	}
	

	public boolean verifyUIOnDevicePrioritySettingsPage() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Verifying UI Elements on Device Priority Settings Page ");
		utils.log().info("*******************************************************");
		try {
			if (devicePriorityTitle.isDisplayed())
				utils.log().info(devicePriorityTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Device Priority Settings title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");
			
			if (deviceLevelPrioritizationLabel.isDisplayed()) 
				utils.log().info("Device Level Prioritization Label is displayed");
			else
				utils.log().info("Device Level Prioritization Label is not displayed");
			
			if (devicePrioritySettingToggleButton.isDisplayed()) 
				utils.log().info("Device Level Prioritization toggle button is displayed");
			else
				utils.log().info("Device Level Prioritization toggle button is not displayed");

			if (addDeviceButton.isDisplayed()) 
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnNetworkPrioritizedDevices() {
		utils.log().info("                                                                                ");
		utils.log().info("********************************************************************************");
		utils.log().info("Verifying UI Elements after Adding Devices to the Device Priority Settings Page ");
		utils.log().info("********************************************************************************");
		
		int size = super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recyclerViewDevicePriority']").size();
		utils.log().info("Size of Prioritized Device List : " + size);
		
		
		try {
			for (int i = 1; i <= size; i++) {
			utils.log().info("Prioritized Device  : " + i);
			utils.log().info("--------------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver()
					.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + i  + "]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup");

			for (MobileElement e : entity) {
				if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/deviceTypeImage']").isDisplayed())
					utils.log().info("Device Image is displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").isDisplayed())
					utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").getText());
				
				try
				{
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest']").isDisplayed())
						utils.log().info("Highest Priority Radion Button option is displayed");
					
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest' and @checked='true']").isDisplayed())
						utils.log().info("Highest Priority Radion Button option is selected");
				}catch(Exception exp) {
					utils.log().info("Highest Priority Radion Button is not displayed");
				}
				
				try
				{
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_high']").isDisplayed())
						utils.log().info("High Priority Radion Button option is displayed");
					
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_high' and @checked='true']").isDisplayed())
						utils.log().info("High Priority Radion Button option is selected");
				}catch(Exception exp) {
					utils.log().info("High Priority Radion Button is not displayed");
				}
				
				try
				{
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_normal']").isDisplayed())
						utils.log().info("Normal Priority Radio Button is displayed");
					
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_normal' and @checked='true']").isDisplayed())
						utils.log().info("Normal Priority Radion Button option is selected by default");
				}catch(Exception exp) {
					utils.log().info("Normal Priority Radion Button is not displayed");
				}				
			}
		}
			return true;
		}catch(Exception e){
			utils.log().info("No Device found to prioritize");
			return false;
		}
	}
	
	public boolean verifyTwoDevicesWithHighestPriority() {
		utils.log().info("                                   ");
		utils.log().info("***********************************");
		utils.log().info(" Devices Assigned Highest Priority ");
		utils.log().info("***********************************");
	
		try {
			for (int i = 1; i <= 2; i++) {
			utils.log().info("Prioritized Device  : " + i);
			utils.log().info("--------------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver()
					.findElementsByXPath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + i  + "]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup");

			for (MobileElement e : entity) {
				if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/deviceTypeImage']").isDisplayed())
					utils.log().info("Device Image is displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").isDisplayed())
					utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").getText());
				
				try
				{
					if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest']").isDisplayed()) {			
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest' and @checked='false']").isDisplayed())
							click(e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest' and @checked='false']"));
							utils.log().info("Highest Priority Radion Button option is selected");
						}
				}catch(Exception exp) {
					utils.log().info("Highest Priority Radion Button is not displayed");
				}			
			}
		}
			return true;
		}catch(Exception e){
			utils.log().info("No Device found to prioritize");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (devicePriorityTitle.isDisplayed()) {
			utils.log().info("On Device Priortization Settings Page");
			return true;
		} else {
			utils.log().info("Not on Device Priortization Settings Page");
			return false;
		}
	}
}
