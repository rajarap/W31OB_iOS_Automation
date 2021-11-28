package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MainDeviceAllTabPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public List<String> signal = new ArrayList<String>();
	public String fiveGhzDevice;
	public String twoFourGhzDevice;
	public String txtDevices;
	public String execDevices;
	public String medDevices;
	public String prDevices;
	public String connDevices;
	public int allDevicesCount;
	public int fiveGHzDevicesCount;
	public int twoFourGHzDevicesCount;
	public int counter = 1;
	public int counter5 = 0;
	public int counter24 = 0;
	public int counterEthernet = 0;



	public Integer[] increaseBrightness = { 30, 60, 90 };
	public Integer[] decreaseBrightness = { 90, 60, 30 };

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement mainTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/buttonAll")
	public MobileElement allTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/button5Ghz")
	public MobileElement fiveGhzTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/button2.4Ghz")
	public MobileElement twentyFourGhzTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/buttonEthernet")
	public MobileElement ethernetTab;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_dining_room_router")
	public MobileElement mainRouterImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtTotalDevices")
	public MobileElement totalDeviceImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtExcellentDevices")
	public MobileElement excellentDeviceImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtMediumDevices")
	public MobileElement mediumDeviceImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtPoorDevices")
	public MobileElement poorDeviceImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtRoutername")
	public MobileElement mainRouterName;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_online")
	public MobileElement mainRouterStatus;

	// ====================LED Settings=====================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtLed")
	public MobileElement ledSettingsText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgLedOpenClose")
	public MobileElement ledExpandImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgLedColor")
	public MobileElement ledColorImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgMoon")
	public MobileElement ledMoonColorImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgSun")
	public MobileElement ledSunColorImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_led_color_title")
	public MobileElement chooseColorBrightnessLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/seekBar")
	public MobileElement seekBar;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ten_progress_tv")
	public MobileElement ten;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/twenty_progress_tv")
	public MobileElement twenty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/thirty_progress_tv")
	public MobileElement thirty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/forty_progress_tv")
	public MobileElement forty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/fifty_progress_tv")
	public MobileElement fifty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/sixty_progress_tv")
	public MobileElement sixty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/seventy_progress_tv")
	public MobileElement seventy;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/eighty_progress_tv")
	public MobileElement eighty;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ninety_progress_tv")
	public MobileElement ninety;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/hundred_progress_tv")
	public MobileElement hundred;
	// ====================LED Settings=====================

	// ====================Connected Devices=====================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/devicesNumbers")
	public MobileElement connectedDevicesCountText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgDeviceInfoOpen")
	public MobileElement connectedDevicesExpandImage;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
	public MobileElement deviceName1;
	// ====================Connected Devices=====================

	// ====================Main Router Details=====================

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_title")
	public MobileElement detailsText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgDeviceOpenClose")
	public MobileElement mainRouterExpandImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_channel")
	public MobileElement channelLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtChannelOne")
	public MobileElement fiveGhzDeviceCount;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtChannelTwo")
	public MobileElement twoFourGhzDeviceCount;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_wan_ip_address")
	public MobileElement wanIPAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceWanIp")
	public MobileElement mainDeviceWANIPAddress;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceLanIp")
	public MobileElement lanIPAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceLanIpA")
	public MobileElement mainDeviceLANIPAddress;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_mac_add_title")
	public MobileElement macAddressLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceMacAddress")
	public MobileElement mainDeviceMACAddress;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_serial_title")
	public MobileElement serialNumberLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceSerialNum")
	public MobileElement mainDeviceSerialNumber;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_firmware_title")
	public MobileElement firmwareLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceFirmware")
	public MobileElement firmwareVersion;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_model_title")
	public MobileElement mainDeviceModelNoLabel;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtDeviceModelNumber")
	public MobileElement mainDeviceModelNumber;

	// ====================Main Router Details=====================

	@AndroidFindBy(id = "com.arris.sbcBeta:id/restartRouter")
	public MobileElement restartRouterButton;
	
	//======================  Device Counts ====================
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtTotalDevices")
	public MobileElement totalDevices;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtExcellentDevices")
	public MobileElement excellentDevices;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtMediumDevices")
	public MobileElement mediumDevices;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtPoorDevices")
	public MobileElement poorDevices;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/devicesNumbers")
	public MobileElement connectedDevices;
	
	//======================  Device Counts ====================

	public MainDeviceAllTabPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public MainRouterDetailsHelpPage getMainRouterDetailsHelpPageObject() {
		MainRouterDetailsHelpPage routerDetialsHelpPage = new MainRouterDetailsHelpPage();
		return routerDetialsHelpPage;
	}

	public EditMainDeviceNameDialog getEditMainDeviceNameDialogObject() {
		EditMainDeviceNameDialog editDeviceNameDialog = new EditMainDeviceNameDialog();
		return editDeviceNameDialog;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDevNameDialog = new EditDeviceNameDialog();
		return editDevNameDialog;
	}

	public MainDevice5GHzTabPage get5GHzPageObject() {
		MainDevice5GHzTabPage device5GHz = new MainDevice5GHzTabPage();
		return device5GHz;
	}

	public MainDevice24GHzTabPage get24GHzPageObject() {
		MainDevice24GHzTabPage device24GHz = new MainDevice24GHzTabPage();
		return device24GHz;
	}

	public MainDeviceEthernetTabPage getEthernetPageObject() {
		MainDeviceEthernetTabPage ethernetDevice = new MainDeviceEthernetTabPage();
		return ethernetDevice;
	}
	
	public void getAllDevicesCount() {
		allDevicesCount = super.getAllCountOfDevices(connectedDevicesCountText.getText());
		utils.log().info("Number of online devices connected to the main mAX Router is : " + allDevicesCount);
	}

	public void get5GHzDevicesCount() {
		fiveGHzDevicesCount = super.get5GHzCountOfDevices(fiveGhzDeviceCount.getText());
		utils.log().info("Number of 5GHz devices connected to the main mAX Router is : " + fiveGHzDevicesCount);
	}

	public void get24GHzDevicesCount() {
		twoFourGHzDevicesCount = super.get24GHzCountOfDevices(twoFourGhzDeviceCount.getText());
		utils.log().info("Number of 2.4GHz devices connected to the main mAX Router is : " + twoFourGHzDevicesCount);
	}

	public boolean increaseLedBrightnessSettings() {
		utils.log().info("-----------------------------");
		try {
			click(ledExpandImage);
			for (int i = 0; i < increaseBrightness.length; i++) {
				switch (increaseBrightness[i]) {
				case 30:
					click(thirty);
					utils.log().info("Increased LED light by 30%");
					break;
				case 60:
					click(sixty);
					utils.log().info("Increased LED light by 60%");
					break;
				case 90:
					click(ninety);
					utils.log().info("Increased LED light by 90%");
					break;
				default:
					utils.log().info("Enter valid brightness value");
				}
			}
			click(ledExpandImage);
			utils.log().info("-----------------------------");
			return true;
		} catch (Exception e) {
			utils.log().info("Issue in increasing LED Brightness Settings");
			return false;
		}
	}

	public boolean decreaseLedBrightnessSettings() {
		utils.log().info("-----------------------------");
		try {
			click(ledExpandImage);
			for (int i = 0; i < decreaseBrightness.length; i++) {
				switch (decreaseBrightness[i]) {
				case 90:
					click(ninety);
					utils.log().info("Decrease LED light to 90%");
					break;
				case 60:
					click(sixty);
					utils.log().info("Decrease LED light to 60%");
					break;
				case 30:
					click(thirty);
					utils.log().info("Decrease LED light to 30%");
					break;
				default:
					utils.log().info("Enter valid brightness value");
				}
			}
			click(ledExpandImage);
			utils.log().info("-----------------------------");
			return true;
		} catch (Exception e) {
			utils.log().info("Issue in decreaseing LED Brightness Settings");
			return false;
		}
	}

	public boolean verifyUIOnLedSettings() {
		utils.log().info("                         ");
		utils.log().info("**************************");
		utils.log().info("LED Settings Verficiation");
		utils.log().info("*************************");
		try {
			if (ledSettingsText.isDisplayed())
				utils.log().info(ledSettingsText.getText() + " text is displayed ");
			else
				utils.log().info("LED SEttings text is not displayed");

			if (ledExpandImage.isDisplayed()) {
				utils.log().info("Expand button image is displayed ");
				click(ledExpandImage);
			} else
				utils.log().info("Expand button image is not displayed");

			if (ledColorImage.isDisplayed())
				utils.log().info("Brightness Icon is displayed");
			else
				utils.log().info("Brightness Icon is not displayed");

			if (ledMoonColorImage.isDisplayed())
				utils.log().info("Moon Image is displayed");
			else
				utils.log().info("Moon Image is not displayed");

			if (ledSunColorImage.isDisplayed())
				utils.log().info("Sun Brightness image is displayed");
			else
				utils.log().info("Sun Brightness image is not displayed");

			if (chooseColorBrightnessLabel.isDisplayed())
				utils.log().info("Choose Color Brightness label is displayed");
			else
				utils.log().info("Choose Color Brightness label is not displayed");

			if (ten.isDisplayed())
				utils.log().info("Scale of 10 is displayed");
			else
				utils.log().info("Scale of 10 is not displayed");

			if (twenty.isDisplayed())
				utils.log().info("Scale of 20 is displayed");
			else
				utils.log().info("Scale of 20 is not displayed");

			if (thirty.isDisplayed())
				utils.log().info("Scale of 30 is displayed");
			else
				utils.log().info("Scale of 30 is not displayed");

			if (forty.isDisplayed())
				utils.log().info("Scale of 40 is displayed");
			else
				utils.log().info("Scale of 40 is not displayed");

			if (fifty.isDisplayed())
				utils.log().info("Scale of 50 is displayed");
			else
				utils.log().info("Scale of 50 is displayed");

			if (sixty.isDisplayed())
				utils.log().info("Scale of 60 is displayed");
			else
				utils.log().info("Scale of 60 is not displayed");

			if (seventy.isDisplayed())
				utils.log().info("Scale of 70 is displayed");
			else
				utils.log().info("Scale of 70 is not displayed");

			if (eighty.isDisplayed())
				utils.log().info("Scale of 80 is displayed");
			else
				utils.log().info("Scale of 80 is not displayed");

			if (ninety.isDisplayed())
				utils.log().info("Scale of 90 is displayed");
			else
				utils.log().info("Scale of 80 is not displayed");

			if (hundred.isDisplayed())
				utils.log().info("Scale of 100 is displayed");
			else
				utils.log().info("Scale of 100 is not displayed");

			click(ledExpandImage);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAllTab() {
		if (allTab.isDisplayed()) {
			click(allTab);
			utils.log().info("Clicked on All tab ");
			return true;
		} else {
			utils.log().info("All Tab is not displayed ");
			return false;
		}
	}

	public boolean click5GhzTab() {
		if (fiveGhzTab.isDisplayed()) {
			click(fiveGhzTab);
			utils.log().info("Clicked on 5GHz tab ");
			return true;
		} else {
			utils.log().info("5GHz Tab is not displayed ");
			return false;
		}
	}

	public boolean click24GhzTab() {
		if (twentyFourGhzTab.isDisplayed()) {
			click(twentyFourGhzTab);
			utils.log().info("Clicked on 2.4GHz tab ");
			return true;
		} else {
			utils.log().info("2.4GHz Tab is not displayed ");
			return false;
		}
	}

	public boolean clickEthernetTab() {
		if (ethernetTab.isDisplayed()) {
			click(ethernetTab);
			utils.log().info("Clicked on Ethernet tab ");
			return true;
		} else {
			utils.log().info("Ethernet Tab is not displayed ");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Main Router Help tab ");
			return true;
		} else {
			utils.log().info("Help Icon is not displayed ");
			return false;
		}
	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back button ");
			return true;
		} else {
			utils.log().info("Back Button is not displayed ");
			return false;
		}
	}

	public boolean clickMainDeviceName() {
		if (mainRouterName.isDisplayed()) {
			click(mainRouterName);
			utils.log().info("Clicked on Main Router Name ");
			return true;
		} else {
			utils.log().info("Main Router name is not displayed");
			return false;
		}
	}

//	public boolean clickDeviceName() {
//		if (deviceName1.isDisplayed()) {
//			click(deviceName1);
//			utils.log().info("Clicked on Device " + deviceName1.getText());
//			return true;
//		} else {
//			utils.log().info("Device Name is not displayed ");
//			return false;
//		}
//	}
	
	public boolean clickDeviceName(int i) {
		try {
				utils.log().info("Editing Device Name  : " + i);
				utils.log().info("-----------------------------");

						List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
								"//android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+ i + "]");

						for (MobileElement e : entity) {
							try {
								if (e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceName']")
										.isDisplayed())
									click(e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceName']"));
							} catch (Exception exp) {
								utils.log().info("Device Name is not available ");
							}
						}
				return true;
			} catch (Exception ex) {
				utils.log().info("Unable to retrieve Device Name");
			return false;
			}
	}

	public boolean verifyUIOnMainDevicePage() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Details of UI Elements on the All Tab Page ");
		utils.log().info("*******************************************");
		try {
			if (mainTitle.isDisplayed())
				utils.log().info(mainTitle.getText() + " Title text is displayed ");
			else
				utils.log().info("Main title text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon image is displayed ");
			else
				utils.log().info("Back Icon image is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (allTab.isDisplayed())
				utils.log().info("All tab is displayed");
			else
				utils.log().info("All tab is not displayed");

			if (fiveGhzTab.isDisplayed())
				utils.log().info("5GHz tab is displayed");
			else
				utils.log().info("5GHz tab is not displayed");

			if (twentyFourGhzTab.isDisplayed())
				utils.log().info("2.4GHz tab is displayed");
			else
				utils.log().info("2.4GHz tab is not displayed");

			if (ethernetTab.isDisplayed())
				utils.log().info("Ethernet tab is displayed");
			else
				utils.log().info("Ethernet tab is not displayed");

			if (mainRouterImage.isDisplayed())
				utils.log().info("Main Router image is displayed");
			else
				utils.log().info("Main Router image is not displayed");

			if (totalDeviceImage.isDisplayed()) 
				utils.log().info(totalDeviceImage.getText() + " devices are connected to the Main Router ");
			else
				utils.log().info("Count of devices connected to the Main Router is not displayed");

			if (excellentDeviceImage.isDisplayed()) 
				utils.log().info(excellentDeviceImage.getText() + " excellent devices are connected to the Main Router");
			else
				utils.log().info("Count of excellent devices connected to the Main Router is not displayed");

			if (mediumDeviceImage.isDisplayed()) 
				utils.log().info(mediumDeviceImage.getText() + " medium devices are connected to the Main Router");
			else
				utils.log().info("Count of medium devices connected to the Main Router is not displayed");

			if (poorDeviceImage.isDisplayed()) 
				utils.log().info(poorDeviceImage.getText() + " poor devices are connected to the Main Router");

			else
				utils.log().info("Count of poor devices connected to the Main Router is not displayed");

			if (mainRouterName.isDisplayed())
				utils.log().info("Main Router Device Name is " + mainRouterName.getText());
			else
				utils.log().info("Main Router Name is not displayed");

			if (mainRouterStatus.isDisplayed())
				utils.log().info("Main Router Status " + mainRouterStatus.getText());
			else
				utils.log().info("Main Router Status is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// To verify the details of all connected devices
	public boolean verifyConnectedDeviceDetails() {
		try {
			utils.log().info("                                               ");
			utils.log().info("***********************************************");
			utils.log().info("Details of All Devices Connected to Main Router");
			utils.log().info("***********************************************");

			this.getAllDevicesCount();
			if (connectedDevicesExpandImage.isDisplayed()) {
				click(connectedDevicesExpandImage);
			} else {
				utils.log().info("Connected Devices Expand button is not available");
			}

			if (allDevicesCount > 0) {
				for (int i = 1; i <= allDevicesCount; i++) {
					utils.log().info("Connected Device  : " + i);
					utils.log().info("--------------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");

					for (MobileElement e : entity) {
						try {
							if (e.findElementByXPath(
									"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
									.isDisplayed())
								utils.log().info("Device Image is displayed");
						} catch (Exception exp) {
							utils.log().info("Device Image is not displayed ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceName']")
									.isDisplayed())
								utils.log().info("Device Name: " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceName']")
										.getText());
						} catch (Exception exp) {
							utils.log().info("Device Name is not available ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtSignalStrength']")
									.isDisplayed()) {
								utils.log().info("Device Signal Strength : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtSignalStrength']")
										.getText());
								signal.add(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtSignalStrength']")
										.getText());
							}
						} catch (Exception exp) {
							utils.log().info("Device Signal Strength data is not available ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceDownloadSpeed']")
									.isDisplayed()) {
								utils.log().info("Device Download Speed : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceDownloadSpeed']")
										.getText());
							}
						} catch (Exception exp) {
							utils.log().info("Device Download Speed data is not available ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceUploadSpeed']")
									.isDisplayed()) {
								utils.log().info("Device Upload Speed : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceUploadSpeed']")
										.getText());
							}
						} catch (Exception exp) {
							utils.log().info("Device Upload Speed data is not available ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
									.isDisplayed()
									&& e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceIpAddress']")
											.isDisplayed()) {
								utils.log().info(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
										.getText()
										+ " : "
										+ e.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceIpAddress']")
												.getText());
							}
						} catch (Exception exp) {
							utils.log().info("IP Address Details are not available or displayed ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_mac_address']")
									.isDisplayed()
									&& e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceIpAddress']")
											.isDisplayed()) {
								utils.log().info(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_mac_address']")
										.getText()
										+ " : "
										+ e.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceMacAddress']")
												.getText());
							}
						} catch (Exception exp) {
							utils.log().info("MAC Address Details are not available or displayed ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
									.isDisplayed()
									&& e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceChannel']")
											.isDisplayed()) {
								utils.log().info(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
										.getText()
										+ " : "
										+ e.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceChannel']")
												.getText());
							}
						} catch (Exception exp) {
							utils.log().info("Channel Details are not available or displayed ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
									.isDisplayed()
									&& e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssi']")
											.isDisplayed()) {
								utils.log().info(e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
										.getText()
										+ " : "
										+ e.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssi']")
												.getText());
							}
						} catch (Exception exp) {
							utils.log().info("RSSI Details are not available or displayed ");
						}

						utils.log().info("****************************************************");
//						utils.log().info("                                                    ");
					}
					if (i >= 1)
						super.swipeUp();
						super.pause(3);
				}
			} else {
				utils.log().info("Currently there are no devices connected to the main Router ");
				click(connectedDevicesExpandImage);
				return false;}
			super.swipeDown();
			click(connectedDevicesExpandImage);
			return true;
		} catch (Exception ex) {
			utils.log().info("Error found when verifying Connected Device Details on Main Device Page All Tab ");
			return false;
		}
	}

	public boolean verifyMainRouterDetails() {
		try {
			super.swipeUp();
			super.waitForVisibility(mainRouterExpandImage);
			click(mainRouterExpandImage);
			super.swipeUp();
			utils.log().info("***************************************************");
			utils.log().info("Details of MAIN Router Device                      ");
			utils.log().info("***************************************************");

			if (detailsText.isDisplayed())
				utils.log().info("Details Text is displayed");
			else
				utils.log().info("Details Text is not displayed ");

			if (channelLabel.isDisplayed()) {
				if (fiveGhzDeviceCount.isDisplayed()) {
					this.fiveGhzDevice = fiveGhzDeviceCount.getText();
					utils.log().info("Channel 1 : " + this.fiveGhzDevice);
				} else {
					utils.log().info("Count of 5GHz devices connected to Main Router is not displayed ");
				}
			} else {
				utils.log().info("Channel Label is not displayed ");
			}

			if (channelLabel.isDisplayed()) {
				if (twoFourGhzDeviceCount.isDisplayed()) {
//						utils.log().info("Channel : " + twoFourGhzDeviceCount.getText());
					this.twoFourGhzDevice = twoFourGhzDeviceCount.getText();
					utils.log().info("Channel 2 : " + this.twoFourGhzDevice);
				} else {
					utils.log().info("Count of 2.4GHz devices connected to Main Router is not displayed ");
				}
			} else {
				utils.log().info("Channel Label is not displayed ");
			}

			if (wanIPAddressLabel.isDisplayed()) {
				if (mainDeviceWANIPAddress.isDisplayed())
					utils.log().info("WAN IP Address : " + mainDeviceWANIPAddress.getText());
				else
					utils.log().info("WAN IP Address of the Main Router is not displayed ");
			} else {
				utils.log().info("WAN IP Address Label is not displayed ");
			}

			if (lanIPAddressLabel.isDisplayed()) {
				if (mainDeviceLANIPAddress.isDisplayed())
					utils.log().info("LAN IP Address : " + mainDeviceLANIPAddress.getText());
				else
					utils.log().info("LAN IP Address of the Main Router is not displayed ");
			} else {
				utils.log().info("LAN IP Address Label is not displayed ");
			}

			if (macAddressLabel.isDisplayed()) {
				if (mainDeviceMACAddress.isDisplayed())
					utils.log().info("MAC Address : " + mainDeviceMACAddress.getText());
				else
					utils.log().info("MAC Address of the Main Router is not displayed ");
			} else {
				utils.log().info("MAC Address Label is not displayed ");
			}

			if (serialNumberLabel.isDisplayed()) {
				if (mainDeviceSerialNumber.isDisplayed())
					utils.log().info("Serial No. : " + mainDeviceSerialNumber.getText());
				else
					utils.log().info("Serial No. of the Main Router is not displayed ");
			} else {
				utils.log().info("Serial No. Label is not displayed ");
			}

			if (firmwareLabel.isDisplayed()) {
				if (firmwareVersion.isDisplayed())
					utils.log().info("Firmware : " + firmwareVersion.getText());
				else
					utils.log().info("Firmware version is not displayed ");
			} else {
				utils.log().info("Firmware Label is not displayed ");
			}

			if (mainDeviceModelNoLabel.isDisplayed()) {
				if (mainDeviceModelNumber.isDisplayed())
					utils.log().info("Model No. : " + mainDeviceModelNumber.getText());
				else
					utils.log().info("Model No. of the Main Router is not displayed ");
			} else {
				utils.log().info("Model No. Label is not displayed ");
			}

			if (restartRouterButton.isDisplayed())
				utils.log().info("Restart Router Button is displayed");
			else
				utils.log().info("Restart Router Button is not displayed");

			click(mainRouterExpandImage);
			return true;
		} catch (Exception e) {
			utils.log().info("Issue when verifying Main Router Details");
			return false;
		}
	}

	public boolean allTabvalidations() {
		try {
			
			 txtDevices = totalDevices.getText();
			 execDevices = excellentDevices.getText();
			 medDevices = mediumDevices.getText();
			 prDevices = poorDevices.getText();
			 connDevices = String.valueOf(getAllCountOfDevices(connectedDevices.getText()));
			
			try {
				if(txtDevices.equals(connDevices)) {
					utils.log().info("Total Count of devices displayed to the main Router Image are : " + txtDevices);
					utils.log().info("Total Count of 5GHz devices connected to the main Router are : " + connDevices);
					utils.log().info("Count of devices displayed on the main Router Image is equal to the count of all devices connected to the main Router");
				}else {
					utils.log().info("Count of devices displayed on the main Router Image is not equal to the count of all devices connected to the main Router");
				}
			}catch(Exception e) {}
			
			try {
				String sumOfDevices = String.valueOf(Integer.valueOf(execDevices) + Integer.valueOf(medDevices) + Integer.valueOf(prDevices));
				if(sumOfDevices.equals(txtDevices)) {
					utils.log().info("Total Count of execellent devices connected to the main Router are : " + execDevices);
					utils.log().info("Total Count of medium devices connected to the main Router are : " + medDevices);
					utils.log().info("Total Count of poor devices connected to the main Router are : " + prDevices);
					utils.log().info("Total Count of execellent, medium and poor devices are equal the count of devices displayed on the main Router Image");
				}else {
					utils.log().info("Total Count of execellent, medium and poor devices are not equal the count of devices displayed on the main Router Image");
				}
			}catch(Exception e) {}
			return true;
		} catch (Exception e) {
			utils.log().info("Issue in validating count of devices");
			return false;
		}
	}
	
//	public boolean validations() {
//		try {
//			if (String.valueOf(allDevicesCount).equals(totalDeviceImage.getText()))
//				utils.log().info(
//						"Count of All devices displayed on the main device image is equal to the Connected Devices count");
//			else
//				utils.log().info(
//						"Device Count displayed on the main device image is not equal to the Connected Devices count");
//			for (String str : signal) {
//				if (str.contains("5GHz") || str.contains("5.0GHz"))
//					counter5 += 1;
//				else if (str.contains("2.4GHz")) {
//					counter24 += 1;
//				} else {
//					counterEthernet += 1;
//				}
//			}
//			utils.log().info(
//					"Number of Devices with 5.0 GHz signal Strength conntected to the main router are : " + counter5);
//			utils.log().info(
//					"Number of Devices with 2.4 GHz signal Strength conntected to the main router are : " + counter24);
//			utils.log().info("Number of Ethernet Devices conntected to the main router are : " + counterEthernet);
//			utils.log().info("                                                                                 ");
//
//			return true;
//		} catch (Exception e) {
//			utils.log().info("Issue in validating count of devices with different signal strength");
//			return false;
//		}
//	}

	@Override
	public boolean isAt() {
		if (allTab.isDisplayed() && allTab.getText().equals("All")) {
			utils.log().info("On MAIN Router - All Tab  Page ");
			return true;
		} else {
			utils.log().info("Not on MAIN Page");
			return false;
		}
	}
}
