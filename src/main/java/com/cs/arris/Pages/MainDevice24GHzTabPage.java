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

public class MainDevice24GHzTabPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public List<String> signal = new ArrayList<String>();
	public String fiveGhzDevice;
	public String twoFourGhzDevice;
	public int allDevicesCount;
	public int fiveGHzDevicesCount;
	public int twoFourGHzDevicesCount;
	
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

//	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/android.widget.ImageView/android.widget.SeekBar[@resource-id='com.arris.sbcBeta:id/seekBar']")
//	public MobileElement seekBar;

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

	public MainDevice24GHzTabPage() {
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

	public void increaseLedBrightnessSettings() {
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
			utils.log().info("                             ");
		} catch (Exception e) {
			utils.log().info("Enter valid brightness value");
		}
	}

	public void decreaseLedBrightnessSettings() {
		utils.log().info("                             ");
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
			utils.log().info("                             ");
		} catch (Exception e) {
			utils.log().info("Enter valid brightness value");
		}
	}

	public void verifyUIOnLedSettings() {
		utils.log().info("                         ");
		utils.log().info("**************************");
		utils.log().info("LED Settings Verficiation");
		utils.log().info("*************************");
		try {
			if (ledSettingsText.isDisplayed())
				utils.log().info(ledSettingsText.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("LED SEttings text is not displayed");
		}

		try {
			if (ledExpandImage.isDisplayed())
				utils.log().info("Expand button image is displayed ");
			click(ledExpandImage);
		} catch (Exception e) {
			utils.log().info("Expand button image is not displayed");
		}

		try {
			if (ledColorImage.isDisplayed())
				utils.log().info("Brightness Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Brightness Icon is not displayed");
		}

		try {
			if (ledMoonColorImage.isDisplayed())
				utils.log().info("Moon Image is displayed");
		} catch (Exception e) {
			utils.log().info("Moon Image is not displayed");
		}

		try {
			if (ledSunColorImage.isDisplayed())
				utils.log().info("Sun Brightness image is displayed");
		} catch (Exception e) {
			utils.log().info("Sun Brightness image is not displayed");
		}

		try {
			if (chooseColorBrightnessLabel.isDisplayed())
				utils.log().info("Choose Color Brightness label is displayed");
		} catch (Exception e) {
			utils.log().info("Choose Color Brightness label is not displayed");
		}

		try {
			if (ten.isDisplayed())
				utils.log().info("Scale of 10 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 10 is not displayed");
		}

		try {
			if (twenty.isDisplayed())
				utils.log().info("Scale of 20 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 20 is not displayed");
		}

		try {
			if (thirty.isDisplayed())
				utils.log().info("Scale of 30 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 30 is not displayed");
		}

		try {
			if (forty.isDisplayed())
				utils.log().info("Scale of 40 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 40 is not displayed");
		}

		try {
			if (fifty.isDisplayed())
				utils.log().info("Scale of 50 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 50 is displayed");
		}

		try {
			if (sixty.isDisplayed())
				utils.log().info("Scale of 60 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 60 is not displayed");
		}

		try {
			if (seventy.isDisplayed())
				utils.log().info("Scale of 70 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 70 is not displayed");
		}

		try {
			if (eighty.isDisplayed())
				utils.log().info("Scale of 80 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 80 is not displayed");
		}

		try {
			if (ninety.isDisplayed())
				utils.log().info("Scale of 90 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 80 is not displayed");
		}

		try {
			if (hundred.isDisplayed())
				utils.log().info("Scale of 100 is displayed");
		} catch (Exception e) {
			utils.log().info("Scale of 100 is not displayed");
		}

		try {
			click(ledExpandImage);
			utils.log().info("Clicked on collapse button image");
		} catch (Exception e) {
			utils.log().info("Collapse button image is not displayed");
		}
	}

	public void clickAllTab() {
		try {
			click(allTab);
			utils.log().info("Clicked on All tab ");
		} catch (Exception exp) {
			utils.log().info("All Tab is not displayed ");
		}
	}

	public void click5GhzTab() {
		try {
			click(fiveGhzTab);
			utils.log().info("Clicked on 5GHz tab ");
		} catch (Exception exp) {
			utils.log().info("5GHz Tab is not displayed ");
		}
	}

	public void click24GhzTab() {
		try {
			click(twentyFourGhzTab);
			utils.log().info("Clicked on 2.4GHz tab ");
		} catch (Exception exp) {
			utils.log().info("2.4GHz Tab is not displayed ");
		}
	}

	public void clickEthernetTab() {
		try {
			click(ethernetTab);
			utils.log().info("Clicked on Ethernet tab ");
		} catch (Exception exp) {
			utils.log().info("Ethernet Tab is not displayed ");
		}
	}

	public void clickHelpButton() {
		try {
			click(helpIcon);
			utils.log().info("Clicked on Main Router Help tab ");
		} catch (Exception exp) {
			utils.log().info("Help Icon is not displayed ");
		}
	}

	public void clickBackButton() {
		try {
			click(backIcon);
			utils.log().info("Clicked on Back button ");
		} catch (Exception exp) {
			utils.log().info("Back Button is not displayed ");
		}
	}

	public void getAllDevicesCount() {
		// this.clickAllTab();
		allDevicesCount = super.getAllCountOfDevices(connectedDevicesCountText.getText());
		utils.log().info("Number of online devices connected to the main mAX Router is : " + allDevicesCount);
	}

	public void get24GHzDevicesCount() {
		twoFourGHzDevicesCount = super.get24GHzCountOfDevices(this.twoFourGhzDevice);
		utils.log().info("Number of 2.4GHz devices connected to the main mAX Router is : " + twoFourGHzDevicesCount);
	}

	public void verifyDevicesCount() {
		if (String.valueOf(allDevicesCount).equals(totalDeviceImage.getText())) {
			utils.log().info("");
			utils.log().info("Device Count displayed on the main device image is equal to the Connected Devices count");
			utils.log().info("");
		} else
			utils.log().info(
					"Device Count displayed on the main device image is not equal to the Connected Devices count");
	}

	public void changeMainDeviceName() {
		try {
			click(mainRouterName);
			utils.log().info("Clicked on Main Router Name ");
			utils.log().info("--------------------------- ");
		} catch (Exception exp) {
			utils.log().info("Main Router name is not displayed ");
		}
	}

	public void changeDeviceName() {
		try {
			click(deviceName1);
			utils.log().info("Clicked on Device " + deviceName1.getText());
			utils.log().info("----------------------------------- ");
		} catch (Exception exp) {
			utils.log().info("Device Name is not displayed ");
		}
	}

	public void verifyUIOn24DevicePage() {
		try {
			if (mainTitle.isDisplayed())
				utils.log().info(mainTitle.getText() + " Title text is displayed ");
		} catch (Exception e) {
			utils.log().info("Main title text is not displayed");
		}

		try {
			if (backIcon.isDisplayed())
				utils.log().info("Back Icon image is displayed ");
		} catch (Exception e) {
			utils.log().info("EBack Icon image is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if (allTab.isDisplayed())
				utils.log().info("All tab is displayed");
		} catch (Exception e) {
			utils.log().info("All tab is not displayed");
		}

		try {
			if (fiveGhzTab.isDisplayed())
				utils.log().info("5GHz tab is displayed");
		} catch (Exception e) {
			utils.log().info("5GHz tab is not displayed");
		}

		try {
			if (twentyFourGhzTab.isDisplayed())
				utils.log().info("2.4GHz tab is displayed");
		} catch (Exception e) {
			utils.log().info("2.4GHz tab is not displayed");
		}

		try {
			if (ethernetTab.isDisplayed())
				utils.log().info("Ethernet tab is displayed");
		} catch (Exception e) {
			utils.log().info("Ethernet tab is not displayed");
		}

		try {
			if (mainRouterImage.isDisplayed())
				utils.log().info("Main Router image is displayed");
		} catch (Exception e) {
			utils.log().info("Main Router image is not displayed");
		}

		try {
			if (totalDeviceImage.isDisplayed())
				utils.log().info(totalDeviceImage.getText() + " devices are connected to the Main Router ");
		} catch (Exception e) {
			utils.log().info("Count of devices connected to the Main Router is not displayed");
		}

		try {
			if (excellentDeviceImage.isDisplayed())
				utils.log()
						.info(excellentDeviceImage.getText() + " excellent devices are connected to the Main Router");
		} catch (Exception e) {
			utils.log().info("Count of excellent devices connected to the Main Router is not displayed");
		}

		try {
			if (mediumDeviceImage.isDisplayed())
				utils.log().info(mediumDeviceImage.getText() + " medium devices are connected to the Main Router");
		} catch (Exception e) {
			utils.log().info("Count of medium devices connected to the Main Router is not displayed");
		}

		try {
			if (poorDeviceImage.isDisplayed())
				utils.log().info(poorDeviceImage.getText() + " poor devices are connected to the Main Router");
		} catch (Exception e) {
			utils.log().info("Count of poor devices connected to the Main Router is not displayed");
		}

		try {
			if (mainRouterName.isDisplayed())
				utils.log().info("Main Router Device Name is " + mainRouterName.getText());
		} catch (Exception e) {
			utils.log().info("Main Router Name is not displayed");
		}

		try {
			if (mainRouterStatus.isDisplayed())
				utils.log().info("Main Router Status " + mainRouterStatus.getText());
		} catch (Exception e) {
			utils.log().info("Main Router Status is not displayed");
		}
	}

	// To verify the details of all connected devices
	public void verifyConnectedDeviceDetails() {
		try {
			utils.log().info("***************************************************");
			utils.log().info("Details of 2.4 GHz Devices Connected to Main Router");
			utils.log().info("***************************************************");

			this.getAllDevicesCount();
			if (connectedDevicesExpandImage.isDisplayed()) {
				click(connectedDevicesExpandImage);
				utils.log().info("Clicked on Connected Devices Expand button ");
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
					}
					if (i == 1)
						new SwipeActions().swipeScreen(Direction.UP);
					super.pause(3);
				}
			} else
				utils.log().info(
						"Currently there are no devices with signal strength 2.4GHz connected to the main Router ");

		} catch (Exception ex) {
			utils.log().info("Error found when verifying Connected Device Details on Main Device Page 2.4 GHz Tab ");
		}

		new SwipeActions().swipeScreen(Direction.DOWN);
		if (connectedDevicesExpandImage.isDisplayed()) {
			click(connectedDevicesExpandImage);
		} else {
			utils.log().info("Currently no 2.4GHz devices are connected to the main router");
		}
	}

	public void verifyMainRouterDetails() {
		new SwipeActions().swipeScreen(Direction.UP);
		super.waitForVisibility(mainRouterExpandImage);

		if (mainRouterExpandImage.isDisplayed()) {
			try {
				if (detailsText.isDisplayed())
					utils.log().info("Details Text is displayed");
			} catch (Exception exp) {
				utils.log().info("Details Text is not displayed ");
			}

			try {
				if (mainRouterExpandImage.isDisplayed()) {
					click(mainRouterExpandImage);
//					utils.log().info("Clicked on Main Router Device Expand Image");
					new SwipeActions().swipeScreen(Direction.UP);
					super.pause(3);
				}
			} catch (Exception exp) {
				utils.log().info("Details Text is not displayed ");
			}

			try {
				if (channelLabel.isDisplayed()) {
					if (fiveGhzDeviceCount.isDisplayed()) {
//						utils.log().info("Channel : " + fiveGhzDeviceCount.getText());
						this.fiveGhzDevice = fiveGhzDeviceCount.getText();
						utils.log().info("Channel 1 : " + this.fiveGhzDevice);}
					else
						utils.log().info("Count of 5GHz devices connected to Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("Channel Label is not displayed ");
			}

			try {
				if (channelLabel.isDisplayed()) {
					if (twoFourGhzDeviceCount.isDisplayed()) {
//						utils.log().info("Channel : " + twoFourGhzDeviceCount.getText());
						this.twoFourGhzDevice = twoFourGhzDeviceCount.getText();
						utils.log().info("Channel 2 : " + this.twoFourGhzDevice);}
					else
						utils.log().info("Count of 2.4GHz devices connected to Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("Channel Label is not displayed ");
			}

			try {
				if (wanIPAddressLabel.isDisplayed()) {
					if (mainDeviceWANIPAddress.isDisplayed())
						utils.log().info("WAN IP Address : " + mainDeviceWANIPAddress.getText());
					else
						utils.log().info("WAN IP Address of the Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("WAN IP Address Label is not displayed ");
			}

			try {
				if (lanIPAddressLabel.isDisplayed()) {
					if (mainDeviceLANIPAddress.isDisplayed())
						utils.log().info("LAN IP Address : " + mainDeviceLANIPAddress.getText());
					else
						utils.log().info("LAN IP Address of the Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("LAN IP Address Label is not displayed ");
			}

			try {
				if (macAddressLabel.isDisplayed()) {
					if (mainDeviceMACAddress.isDisplayed())
						utils.log().info("MAC Address : " + mainDeviceMACAddress.getText());
					else
						utils.log().info("MAC Address of the Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("MAC Address Label is not displayed ");
			}

			try {
				if (serialNumberLabel.isDisplayed()) {
					if (mainDeviceSerialNumber.isDisplayed())
						utils.log().info("Serial No. : " + mainDeviceSerialNumber.getText());
					else
						utils.log().info("Serial No. of the Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("Serial No. Label is not displayed ");
			}

			try {
				if (firmwareLabel.isDisplayed()) {
					if (firmwareVersion.isDisplayed())
						utils.log().info("Firmware : " + firmwareVersion.getText());
					else
						utils.log().info("Firmware version is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("Firmware Label is not displayed ");
			}

			try {
				if (mainDeviceModelNoLabel.isDisplayed()) {
					if (mainDeviceModelNumber.isDisplayed())
						utils.log().info("Model No. : " + mainDeviceModelNumber.getText());
					else
						utils.log().info("Model No. of the Main Router is not displayed ");
				}
			} catch (Exception exp) {
				utils.log().info("Model No. Label is not displayed ");
			}

			try {
				if (restartRouterButton.isDisplayed())
					utils.log().info("Restart Router Button is displayed");
			} catch (Exception exp) {
				utils.log().info("Restart Router Button is not displayed");
			}

			try {
				if (mainRouterExpandImage.isDisplayed()) {
					click(mainRouterExpandImage);
//					utils.log().info("Clicked on Main Router Device Collapse Image");
					new SwipeActions().swipeScreen(Direction.DOWN);
					super.pause(3);
				}
			} catch (Exception exp) {
				utils.log().info("Main Router Collapse Image is not displayed ");
			}
		} else
			utils.log().info("Main Router Details Expand Button is either not visible or is not present in the DOM");
	}

	public void validations() {
		utils.log().info(String.valueOf(allDevicesCount));
		utils.log().info(totalDeviceImage.getText());
		if (String.valueOf(allDevicesCount).equals(totalDeviceImage.getText())) 
			utils.log().info("Count of 2.4 GHz devices displayed on the main device image is equal to the Connected Devices count");
		else
			utils.log().info("Device Count displayed on the main device image is not equal to the Connected Devices count");

		for (String str : signal) {
			if (str.contains("5GHz") || str.contains("5GHz"))
				counter5 += 1;
			else if (str.contains("2.4GHz")) {
				counter24 += 1;
			} else {
				counterEthernet += 1;
			}
		}

		if (twoFourGHzDevicesCount == counter5) {
			utils.log().info("All devices listed under the 2.4 GHz tab contains signal strength of 2.4 GHz");
			utils.log().info("                                                                         ");}
		else
			utils.log()
					.info("Not all devices listed under the 2.4 GHz tab contains signal strength of 2.4GHz.  "
							+ counter5 + " 5GHz devices, " + counter24 + " 2.4GHz devices and " + counterEthernet
							+ " Ethernet devices are listed under 2.4 GHz tab");
	}

	@Override
	public boolean isAt() {
		if (mainTitle.isDisplayed()) {
			utils.log().info("********** On MAIN Router Page **********");
			utils.log().info("*****************************************");
			return true;
		} else {
			utils.log().info("Not on MAIN Page");
			return false;
		}
	}
}
