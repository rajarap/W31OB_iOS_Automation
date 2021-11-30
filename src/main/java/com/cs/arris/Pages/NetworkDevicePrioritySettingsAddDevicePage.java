package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.By;
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

public class NetworkDevicePrioritySettingsAddDevicePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement addDeviceTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/add_device")
	public MobileElement addDeviceButton;

	public NetworkDevicePrioritySettingsAddDevicePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkDevicePrioritySettingsAddDeviceHelpPage getAddDevicePriorityHelpPageObject() {
		NetworkDevicePrioritySettingsAddDeviceHelpPage addDevice = new NetworkDevicePrioritySettingsAddDeviceHelpPage();
		return addDevice;
	}
	
	public NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog getSelectDeviceAlertDialogObject() {
		NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog selectDevice = new NetworkDevicePrioritySettingsSelectAtleatOneDeviceAlertDialog();
		return selectDevice;
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

	public boolean clickAddDeviceButton() {
		if (addDeviceButton.isDisplayed()) {
			click(addDeviceButton);
			return true;
		} else {
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}


	public boolean verifyUIOnAddDevicePage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on Add Device Settings Page");
		utils.log().info("*************************************************");
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info(addDeviceTitle.getText() + " title text is displayed ");
			else
				utils.log().info("Add Device title text is displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed ");

			if (addDeviceButton.isDisplayed())
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed ");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyDeviceListForPrioritization() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying List of Devices on Add Device Page ");
		utils.log().info("*********************************************");
		
		int size = super.getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/add_device_rv']")).size();
		
		try {
			for (int i = 1; i <= size ; i++) {
				utils.log().info("Device Details  : " + i);
				utils.log().info("--------------------------");

				List<MobileElement> entity = (List<MobileElement>) 
						super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");

				for (MobileElement e : entity) {
					if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']").isDisplayed())
						utils.log().info("Device Image is displayed");

					if ((e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed()))
						utils.log().info("Device Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText() + " is displayed");

					if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed())
						utils.log().info("Checkbox is displayed");

				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifySelectDeviceFromList() {
		utils.log().info("                                               ");
		utils.log().info("***********************************************");
		utils.log().info("Verifying Selecting Devices on Add Device Page ");
		utils.log().info("******************************************((***");
		
		int size = super.getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/add_device_rv']")).size();
		if(size > 0) {
		try {
			for (int i = 1; i <= size ; i++) {
				utils.log().info("Selecting Device : " + i);
				utils.log().info("------------------------");

				List<MobileElement> entity = (List<MobileElement>) 
						super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");

				for (MobileElement e : entity) {
					if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']").isDisplayed())
						utils.log().info("Device Image is displayed");

					if ((e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed()))
						utils.log().info("Device Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText() + " is displayed");

					if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed())
						utils.log().info("Checkbox is displayed");
					
					try {
						if(i==2) {
							if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select' and @checked='false']").isDisplayed())
								click(e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select' and @checked='false']"));
						}
					}catch (Exception exp) {}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}else {utils.log().info("There are no devices listed in the Device Priority Add Device Page");}
		return true;
	}

	@Override
	public boolean isAt() {
		if (addDeviceTitle.isDisplayed()) {
			utils.log().info("On Add Device Settings Page");
			return true;
		} else {
			utils.log().info("Not on Add Device Settings Page");
			return false;
		}
	}
}
