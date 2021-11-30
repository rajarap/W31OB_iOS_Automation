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
	public MobileElement onlineButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOffline']"), // Offline
			@AndroidBy(xpath = "//android.widget.Button[@bounds='[539,397][1001,484]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/buttonOffline") })
	public MobileElement offlineButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement backButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
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
	public MobileElement mainDeviceName;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/home_view") })
	public MobileElement homeButton;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/network_view") })
	public MobileElement networkButton;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/parental_view") })
	public MobileElement parentalButton;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']"),
			@AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup"),
			@AndroidBy(id = "com.arris.sbcBeta:id/setBackgroundForFreezingList") })
	public MobileElement firstFreezingItem;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']")
	public List<MobileElement> listOfOnlineDevices;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
	public List<MobileElement> deviceImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
	public List<MobileElement> deviceName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtMainSignalStrength")
	public List<MobileElement> deviceSignalStrength;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
	public List<MobileElement> deviceDownloadSpeed;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
	public List<MobileElement> deviceUploadSpeed;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']")
	public List<MobileElement> expandButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_ip_address")
	public List<MobileElement> ipAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtIpAddress")
	public List<MobileElement> deviceIPAddress;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/macAddressTitle")
	public List<MobileElement> macAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtMacAddress")
	public List<MobileElement> deviceMACAddress;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_channel")
	public List<MobileElement> channelLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtChannelValue")
	public List<MobileElement> deviceChannelNumber;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/statusTitle")
	public List<MobileElement> statusLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtStatus")
	public List<MobileElement> deviceStatus;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/rssiTitle")
	public List<MobileElement> rssiLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtRssi")
	public List<MobileElement> deviceRSSIText;

	// ************************ Offline Devices ****************************

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@index='1']/androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']")
	public List<MobileElement> listOfOfflineDevices;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgDevice")
	public List<MobileElement> offlineDeviceImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceName")
	public List<MobileElement> offlineDeviceName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtLastOnline")
	public List<MobileElement> timeSinceLastOnline;

	// ************************ Offline Devices ****************************

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
		try {
			this.getOnlineDevicesCount();
			utils.log().info("***************************************************");
			utils.log().info("Details of Online Devices Connected to Main Device ");
			utils.log().info("***************************************************");
			
			
			if(this.onlineDeviceCount == 0) 
				utils.log().info("There are no online devices currently connected to the Main Router ");
			else if (this.onlineDeviceCount > 0) {
				for (int i = 1; i <= onlineDeviceCount-1; i++) {
					utils.log().info("Online Device : " + i);
					utils.log().info("--------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");

					for (MobileElement e : entity) {
						click(e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));

						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']").isDisplayed())
							utils.log().info("Device Image is displayed");
						else
							utils.log().info("Device Image is not displayed");

						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']").isDisplayed())
							utils.log().info("Expand Button Image is displayed");
						else
							utils.log().info("Expand button is not available : ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']").isDisplayed())
							utils.log().info("Device Name: " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']").getText());
						else
							utils.log().info("Device Name is not available ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']")
								.isDisplayed())
							utils.log().info("Device Signal Strength : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']")
									.getText());
						else
							utils.log().info("Device Signal Strength is not available ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
								.isDisplayed())
							utils.log().info("Device Download Speed : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
									.getText());
						else
							utils.log().info("Device Download Speed data is not available ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
								.isDisplayed())
							utils.log().info("Device Upload Speed : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
									.getText());
						else
							utils.log().info("Device Upload Speed data is not available ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
									.getText());
						else
							utils.log().info("IP Address Label is not displayed ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']")
								.isDisplayed())
							utils.log().info("Device IP Address : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']")
									.getText());
						else
							utils.log().info("Device IP Address is not available ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']")
									.getText());
						else
							utils.log().info("MAC Address Label is not displayed");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']")
								.isDisplayed())
							utils.log().info("Device MAC Address : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']")
									.getText());
						else
							utils.log().info("Device MAC Address is not available");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
								.isDisplayed())
							utils.log().info("Label : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
									.getText());
						else
							utils.log().info("Channel Label is not displayed");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']")
								.isDisplayed())
							utils.log().info("Device Channel Number : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']")
									.getText());
						else
							utils.log().info("Device Channel Number is not available");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']")
								.isDisplayed())
							utils.log().info("Label	: " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']")
									.getText());
						else
							utils.log().info("Status Label is not displayed");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']")
								.isDisplayed())
							utils.log()
									.info("Device Status : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']")
											.getText());
						else
							utils.log().info("Device Status is not available");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']")
								.isDisplayed())
							utils.log()
									.info("Label : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']")
											.getText());
						else
							utils.log().info("RSSI Label is not displayed");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']").isDisplayed())
							utils.log()
									.info("RSSI Value : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
											.getText());
						else
							utils.log().info("RSSI data is not available ");

						click(e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));

						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if (i >= 5)
						super.swipeUp();
				}
			}else {utils.log().info("Either there are no devices connected to the main mAX router or all devices are currently offline");}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Online Devices Page ");
			return false;
		}
	}

	// To verify the details of online devices
	public boolean verifyOfflineDeviceDetails() {
		try {
			this.getOfflineDevicesCount();
			utils.log().info("****************************************************");
			utils.log().info("Details of Offline Devices Connected to Main Device ");
			utils.log().info("****************************************************");
			
			if(offlineDeviceCount == 0)
				utils.log().info("There are no offline devices currently connected to the Main Router ");
			else if (offlineDeviceCount > 0) {
				for (int i = 1; i <= offlineDeviceCount; i++) {
					utils.log().info("Offline Device : " + i);
					utils.log().info("----------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");
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
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
								.isDisplayed()) 
						{
							utils.log().info("Device Name: " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
									.getText());
							this.connectedDeviceName = e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
									.getText();
							click(e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']"));
							if (this.getEditDeviceNameDialogObject().isAt())
							{
								this.getEditDeviceNameDialogObject().editDeviceName1();
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
