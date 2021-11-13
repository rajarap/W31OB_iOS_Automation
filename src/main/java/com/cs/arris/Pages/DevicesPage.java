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

public class DevicesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	public List<MobileElement> onlineDeviceList;
	public List<MobileElement> offlineDeviceList;
	public MobileElement me;
	public int offlineDeviceCount;
	public int onlineDeviceCount;
	public int counter = 1;

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

	public String getOnlineDeviceTitleText() {
		return onlineDeviceTitle.getText();
	}

	public String getOfflineDeviceTitleText() {
		return offlineDeviceTitle.getText();
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

	public void getOnlineDevicesCount() {
		clickOnlineTab();
		utils.log().info("Online Device Page Title : " + getOnlineDeviceTitleText());// Devices(2)
		onlineDeviceCount = getCountOfDevices(getOnlineDeviceTitleText());
		utils.log().info("Number of online devices connected to the main mAX Router is : " + onlineDeviceCount);
	}

	public void getOfflineDevicesCount() {
		clickOfflineTab();
		utils.log().info("Offline Device Page Title : " + getOfflineDeviceTitleText());
		offlineDeviceCount = getCountOfDevices(getOfflineDeviceTitleText());
		utils.log().info("Number of offline devices are : " + offlineDeviceCount);
	}	

	
	//To verify the details of online devices
	public void verifyOnlineDeviceDetails()
	{
		try {

			utils.log().info("****************************************************");
			utils.log().info("Details of Online Devices Connected to Main Device");
			utils.log().info("****************************************************");

			for (int i = 1; i <= onlineDeviceCount; i++) {
				utils.log().info("Online Device : " + i);
				utils.log().info("--------------------");
				// me = (MobileElement)
				// super.getDriver().findElementByXPath("//android.view.ViewGroup[@index="+i+"]");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Expand button is not available : ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']")
								.isDisplayed()) {
							utils.log().info("Expand Button Image is displayed");
							click(e.findElementByXPath(
									"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));
							super.pause(2);
						}
					} catch (Exception exp) {
						utils.log().info("Expand button is not available : ");
					}

					try {
						utils.log()
								.info("Device Name: " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
										.getText());
								deviceNames.add(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available ");
					}
					try {
						utils.log().info("Device Signal Strength : " + e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']")
								.getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available ");
					}
					try {
						utils.log().info("Device Download Speed : " + e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
								.getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed data is not available ");
					}
					try {
						utils.log().info("Device Upload Speed : " + e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
								.getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed data is not available ");
					}
					try {
						utils.log()
								.info("Label : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("IP Address Label is not displayed ");
					}
					try {
						utils.log()
								.info("Device IP Address : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Device IP Address is not available ");
					}
					try {
						utils.log().info("Label : " + e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']")
								.getText());
					} catch (Exception exp) {
						utils.log().info("MAC Address Label is not displayed");
					}
					try {
						utils.log()
								.info("Device MAC Address : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Device MAC Address is not available");
					}
					try {
						utils.log()
								.info("Label : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Channel Label is not displayed");
					}
					try {
						utils.log().info("Device Channel Number : " + e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']")
								.getText());
					} catch (Exception exp) {
						utils.log().info("Device Channel Number is not available");
					}
					try {
						utils.log()
								.info("Label	: " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Status Label is not displayed");
					}
					try {
						utils.log()
								.info("Device Status : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("Device Status is not available");
					}
					try {
						utils.log()
								.info("Label : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label is not displayed");
					}
					try {
						utils.log()
								.info("RSSI Value : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
										.getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available ");
					}

					click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));

					// utils.log().info("Clicked Collapse Button image");
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i >= 5)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception ex) {
			utils.log().info("Error in Online Devices Page ");
		}
	}
	
	
	//To verify the details of online devices
	public void verifyOfflineDeviceDetails() {
		counter = 1;
		utils.log().info("****************************************************");
		utils.log().info("Details of Offline Devices Connected to Main Device");
		utils.log().info("****************************************************");

		for (int i = 1; i <= offlineDeviceCount; i++) {
			utils.log().info("Offline Device : " + counter);
			utils.log().info("--------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
							+ "]");
			for (MobileElement e : entity) {
				try {
					if (e.findElementById("com.arris.sbcBeta:id/imgDevice").isDisplayed())
						utils.log().info("Device Image is displayed");
				} catch (Exception exp) {
					utils.log().info("Expand button is not available : ");
				}
				try {
					utils.log()
							.info("Device Name: " + e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
				} catch (Exception exp) {
					utils.log().info("Device Name is not available ");
				}
				try {
					utils.log().info(e.findElementById("com.arris.sbcBeta:id/txtLastOnline").getText());
				} catch (Exception exp) {
					utils.log().info("Last Online data is not available ");
				}

				utils.log().info("****************************************************");
				utils.log().info("                                                    ");
				counter++;
			}
			if (i >= 7)
				new SwipeActions().swipeScreen(Direction.UP);
		}
	}

	// Verify if all the required UI elements are displayed on the Home Page
	public void verifyUIOnDevicesPage() {
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
	}
	
	
	public void clickOnlineTab() {
		click(onlineButton);
		utils.log().info("Devices Page - Clicked on Online Tab");
	}

	public void clickOfflineTab() {
		click(offlineButton);
		utils.log().info("Devices Page - Clicked on Offile Tab");
	}

	public void clickBackButton() {
		click(backButton);
		utils.log().info("Devices Page - Clicked on Back Button");
	}

	public void clickHomeButton() {
		homePage.getFooterIconsPageObject().clickHomeButton();
		utils.log().info("Devices Page - Clicked on Home Button");
	}

	public void clickNetworkButton() {
		homePage.getFooterIconsPageObject().clickNetworkButton();
		utils.log().info("Devices Page - Clicked on Network Button");
	}

	public void clickParentalButton() {
		homePage.getFooterIconsPageObject().clickParentalButton();
		utils.log().info("Devices Page - Clicked on Parental Button");
	}

	public void clickHelpButton() {
		click(helpIcon);
		utils.log().info("Devices Page - Clicked on Help Button");
	}

	public void clickCloseButton() {
		click(closeButton);
		utils.log().info("Devices Help Page - Clicked on Close Button");
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkPage getNetworkPageObject() {
		NetworkPage networkPage = new NetworkPage();
		return networkPage;
	}

	public ParentalControlProfilesPage getParentalControlPageObject() {
		ParentalControlProfilesPage parentalControlPage = new ParentalControlProfilesPage();
		return parentalControlPage;
	}

	public DevicesHelpPage getDevicesHelpPageObject() {
		DevicesHelpPage devicesHelpPage = new DevicesHelpPage();
		return devicesHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	@Override
	public boolean isAt() {
		if (onlineDeviceTitle.isDisplayed()) {
			utils.log().info("                ");
			utils.log().info("----------------");
			utils.log().info("On Devices Page");
			return true;
		} else {
			utils.log().info("Not on Devices Page");
			return false;
		}
	}
}
