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
	
	public boolean verifyUIOnAddDevicePage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on Add Device Settings Page");
		utils.log().info("*************************************************");
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info(addDeviceTitle.getText() + " title text is displayed ");
//			else
//				utils.log().info("Add Device title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
//			else
//				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
//			else
//				utils.log().info("Help Icon is not displayed");

			if (addDeviceButton.isDisplayed()) 
				utils.log().info("Add Device button is displayed");
//			else
//				utils.log().info("Add Device button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void verifyNetworkAddDevice() 
	{
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying Network Add Device Priority Settings Page ");
		utils.log().info("****************************************************");

		//int deviceCount = super.lanIPRuleName.size();
		//if (deviceCount > 0) {
			for (int i = 2; i <= 2; i++) 
			{
				utils.log().info("Add Device Details  : " + i);
				utils.log().info("--------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");

				for (MobileElement e : entity) 
				{
					try {
						if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not displayed ");
					}

					try {
						if ((e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed()))
							utils.log().info("Added Device Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed())
							click(e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']"));
					} catch (Exception exp) {
						utils.log().info("Add Device Check box is not displayed ");
					}
				}
			}
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
