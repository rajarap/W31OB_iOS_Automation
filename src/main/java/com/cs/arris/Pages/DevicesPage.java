package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DevicesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	public List<MobileElement> onlineDeviceList;
	public List<MobileElement> offlineDeviceList;
	public MobileElement me;
	public int offlineDeviceCount;
	public int onlineDeviceCount;
	public int counter = 1;
	public String connectedDeviceName;
	public String editedDeviceName;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"), // Devices(2)
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[424,149][656,223]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NavigationBar_Title\"]")
	public MobileElement onlineDeviceTitle;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"), // Devices(1)
			@AndroidBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") })
	public MobileElement offlineDeviceTitle;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[893,154][956,217]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOnline']"), // Online
			@AndroidBy(xpath = "//android.widget.Button[@bounds='[79,397][541,484]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/buttonOnline") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Online\"]")
	public MobileElement onlineButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOffline']"), // Offline
			@AndroidBy(xpath = "//android.widget.Button[@bounds='[539,397][1001,484]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/buttonOffline") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Offline\"]")
	public MobileElement offlineButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Home\"]")
	public MobileElement backButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"), // CONTINUE
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/ivDialogClose") })
	public MobileElement closeButton;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtAllDeviceTitleOne']"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[55,380][141,437]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtAllDeviceTitleOne") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MAIN\"]")
	public MobileElement mainDeviceName;

	public DevicesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public int getOnlineDeviceCount() {
		this.getOnlineDevicesCount();
		return onlineDeviceCount;
	}

	public int getOfflineDeviceCount() {
		this.getOfflineDevicesCount();
		return offlineDeviceCount;
	}

	public String getOnlineButtonText() {
		return onlineButton.getText();
	}

	public String getOfflineButton() {
		return offlineButton.getText();
	}

	public String getBackButton() {
		return backButton.getText();
	}

	public String getMainDeviceName() {
		return mainDeviceName.getText();
	}

	public DevicesHelpPage getDevicesHelpPageObject() {
		DevicesHelpPage devicesHelpPage = new DevicesHelpPage();
		return devicesHelpPage;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDeviceNameDialog = new EditDeviceNameDialog();
		return editDeviceNameDialog;
	}
	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public boolean clickOnlineTab() {
		if (onlineButton.isDisplayed()) {
			click(onlineButton);
			utils.log().info("Clicked on Online Tab");
			return true;
		} else {
			utils.log().info("Online Tab is not displayed");
			return false;
		}
	}

	public boolean clickOfflineTab() {
		if (offlineButton.isDisplayed()) {
			click(offlineButton);
			utils.log().info("Clicked on Offile Tab");
			return true;
		} else {
			utils.log().info("Offline Tab is not displayed");
			return false;
		}
	}

	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Tab is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("HElp Tab is not displayed");
			return false;
		}
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			super.swipeUp();
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public void getOnlineDevicesCount() {
		clickOnlineTab();
		onlineDeviceCount = getCountOfDevices(onlineDeviceTitle.getText());
		utils.log().info("Number of online devices connected to the main mAX Router are : " + onlineDeviceCount);
	}
	
	public void getOnlineDeviceNameCount() {
		onlineDeviceCount = getCountOfDevices(onlineDeviceTitle.getText());
	}

	public void getOfflineDevicesCount() {
		clickOfflineTab();
		utils.log().info("Offline Device Page Title : " + offlineDeviceTitle.getText());
		offlineDeviceCount = getCountOfDevices(offlineDeviceTitle.getText());
		utils.log().info("Number of offline devices connected to the main mAX Router are : " + offlineDeviceCount);
	}

	// To verify the details of online devices
	public boolean verifyOnlineDeviceDetails() {
		this.getOnlineDevicesCount();
		utils.log().info("***************************************************");
		utils.log().info("Details of Online Devices Connected to Main Device ");
		utils.log().info("***************************************************");

		if (this.onlineDeviceCount > 0) {
			
			for (int i = 1; i <= onlineDeviceCount; i++) {
				utils.log().info("Online Device : " + i);
				utils.log().info("----------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]");

				for (MobileElement e : entity) 
				{
					click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));
					
					try {
						if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not displayed");
					}

					try {
						if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']").isDisplayed())
							utils.log().info("Expand Button Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Expand button is not available : ");
					}

					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']").isDisplayed())
							utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available ");
					}

					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']").isDisplayed())
							utils.log().info("Device Signal Strength : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
								.isDisplayed())
							utils.log().info("Device Download Speed : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed data is not available ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
								.isDisplayed())
							utils.log().info("Device Upload Speed : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed data is not available ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("IP Address Label is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']")
								.isDisplayed())
							utils.log().info("Device IP Address : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Device IP Address is not available ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("MAC Address Label is not displayed");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']")
								.isDisplayed())
							utils.log().info("Device MAC Address : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Device MAC Address is not available");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Channel Label is not displayed");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']")
								.isDisplayed())
							utils.log().info("Device Channel Number : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Device Channel Number is not available");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']")
								.isDisplayed())
							utils.log().info("Label	: " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']")
									.getText());
					} catch (Exception exp) {
						utils.log().info("Status Label is not displayed");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']")
								.isDisplayed())
							utils.log()
									.info("Device Status : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']")
											.getText());
					} catch (Exception exp) {
						utils.log().info("Device Status is not available");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']")
								.isDisplayed())
							utils.log()
									.info("Label : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']")
											.getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label is not displayed");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']").isDisplayed())
							utils.log()
									.info("RSSI Value : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
											.getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available ");
					}

					click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));

					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} else {
			utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently offline");
			return true;
		}
	}

	// To verify the details of online devices
	public boolean verifyOfflineDeviceDetails() {
		try {
			this.getOfflineDevicesCount();
			utils.log().info("****************************************************");
			utils.log().info("Details of Offline Devices Connected to Main Device ");
			utils.log().info("****************************************************");
			
			if (offlineDeviceCount > 0) {
				for (int i = 1; i <= offlineDeviceCount; i++) {
					utils.log().info("Offline Device : " + i);
					utils.log().info("----------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]");
					
					for (MobileElement e : entity) {
						if (e.findElementById("com.arris.sbcBeta:id/imgDevice").isDisplayed())
							utils.log().info("Device Image is displayed");
						else
							utils.log().info("Device Image is not available : ");

						if (e.findElementById("com.arris.sbcBeta:id/txtDeviceName").isDisplayed())
							utils.log().info("Device Name: " + e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
						else
							utils.log().info("Device Name is not available ");

						if (e.findElementById("com.arris.sbcBeta:id/txtLastOnline").isDisplayed())
							utils.log().info(e.findElementById("com.arris.sbcBeta:id/txtLastOnline").getText());
						else
							utils.log().info("Last Online data is not available ");

						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if (i >= 7)
						super.swipeUp();
				}
			} else {
				utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently online");
				return true;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnDevicesPage() {
		utils.log().info("********************************************");
		utils.log().info("Details of UI Elements on the Devices Page  ");
		utils.log().info("********************************************");

		try {
			if (onlineDeviceTitle.isDisplayed())
				utils.log().info("Device Title is displayed");
			else
				utils.log().info("Device Title - " + onlineDeviceTitle.getText() + " - is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back Icon is displayed");
			else
				utils.log().info("Back Icon is displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is displayed");

			if (onlineButton.isDisplayed())
				utils.log().info("Online Tab is displayed");
			else
				utils.log().info("Online Tab is not displayed");

			if (offlineButton.isDisplayed())
				utils.log().info("Offline Tab is displayed");
			else
				utils.log().info("Offline Tab is not displayed");

			if (mainDeviceName.isDisplayed())
				utils.log().info("Main Device name - " + mainDeviceName.getText() + " - is displayed");
			else
				utils.log().info("Main Device name is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyEditDeviceName() {
		try {
			this.getOnlineDeviceNameCount();
			if (this.onlineDeviceCount > 0) 
			{
				for (int i = 1; i <= 1; i++) 
				{
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+ i + "]");

					for (MobileElement e : entity) 
					{
						if (super.getDriver().findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
								.isDisplayed()) 
						{
							utils.log().info("Device Name: " + super.getDriver().findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
									.getText());
							this.connectedDeviceName = super.getDriver().findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
									.getText();
							click(super.getDriver().findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']"));
							if (this.getEditDeviceNameDialogObject().isAt())
							{
								this.getEditDeviceNameDialogObject().editDeviceName();
								this.getEditDeviceNameDialogObject().clickSaveButton();
							}
						}
					}
				}
			} else {
				utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently offline");
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Online Devices Page ");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (onlineDeviceTitle.isDisplayed()) {
			utils.log().info("On Devices Page");
			return true;
		} else {
			utils.log().info("Not on Devices Page");
			return false;
		}
	}
}
