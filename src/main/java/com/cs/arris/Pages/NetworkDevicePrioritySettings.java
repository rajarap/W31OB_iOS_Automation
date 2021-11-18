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
	
	@AndroidFindBy(id = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/device_enable_disable' and @text='OFF']")
	public MobileElement disableDevicePrioritySettings;
	
	@AndroidFindBy(id = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/device_enable_disable' and @text='ON']")
	public MobileElement enableDevicePrioritySettings;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/add_device_configure")
	public MobileElement addDeviceButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Network Device Priority")
	public MobileElement networkDevicePriorityLabel;
	
	
	
	
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

	public void clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
		} else
			utils.log().info("Back Button is not displayed");
	}

	public boolean clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) 
				click(helpIcon);
			return true;
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}
	
	public boolean clickAddDeviceButton() {
		try {
			if (addDeviceButton.isDisplayed()) 
				click(addDeviceButton);
				//utils.log().info("Clicked on Test Your Connection Speed button");
				return true;		
			}catch(Exception e) {
			//utils.log().info("Test Your Connection Speed button is not displayed");
			return false;}
	}
	
	public void enableDevicePrioritySettings() {
		if (disableDevicePrioritySettings.isDisplayed())
			click(disableDevicePrioritySettings);
		else
			utils.log().info("Device Priority Settings is already enabled");
	}
	
	public void disableDevicePrioritySettings() {
		if (enableDevicePrioritySettings.isDisplayed())
			click(enableDevicePrioritySettings);
		else
			utils.log().info("Device Priority Settings is already disabled");
	}



	public boolean verifyUIOnNetworkAddDevicePage() {
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

			if (disableDevicePrioritySettings.isDisplayed()) 
				utils.log().info("Device Level Prioritization toggle button is disabled");
			else if(enableDevicePrioritySettings.isDisplayed())
				utils.log().info("Device Level Prioritization toggle button is enabled");
			else
				utils.log().info("Device Level Prioritization toggle button is not displayed");
				
			if (deviceLevelPrioritizationLabel.isDisplayed()) 
				utils.log().info("Device Level Prioritization Label is displayed");
			else
				utils.log().info("Device Level Prioritization Label is not displayed");

			if (addDeviceButton.isDisplayed()) 
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void verifyUIOnNetworkPrioritizedDevices() {
		utils.log().info("                                                                                ");
		utils.log().info("********************************************************************************");
		utils.log().info("Verifying UI Elements after Adding Devices to the Device Priority Settings Page ");
		utils.log().info("********************************************************************************");
		
		for (int i = 1; i <= 2; i++) {
				utils.log().info("Prioritized Device  : " + i);
				utils.log().info("--------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[" + i + "]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/deviceTypeImage']").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").isDisplayed())
							utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").isDisplayed())
							utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest' and @checked=false]").isDisplayed())
							utils.log().info("Highest Priority Radion Button is displayed");
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest' and @checked=true]").isDisplayed())
								utils.log().info("Priority : " + e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_highest']").getText() + " is selected");
					} catch (Exception exp) {
						utils.log().info("Highest Priority Radion Button is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_high' and @checked=false]").isDisplayed())
							utils.log().info("High Priority Radion Button is displayed");
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_high' and @checked=true]").isDisplayed())
								utils.log().info("Priority : " + e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_high']").getText() + " is selected");
					} catch (Exception exp) {
						utils.log().info("High Priority Radion Button is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_normal' and @checked=false]").isDisplayed())
							utils.log().info("Normal Priority Radio Button is displayed");
						if (e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_normal' and @checked=true]").isDisplayed())
								utils.log().info("Priority : " + e.findElementByXPath("//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/rb_normal']").getText() + " is selected");
					} catch (Exception exp) {
						utils.log().info("Normal Priority Radion Button is not displayed ");
					}
					
				}
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