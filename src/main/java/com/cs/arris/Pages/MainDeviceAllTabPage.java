package com.cs.arris.Pages;

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

public class MainDeviceAllTabPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	public List<MobileElement> onlineDeviceList;
	public List<MobileElement> offlineDeviceList;
	public MobileElement me;
	public int offlineDeviceCount;
	public int onlineDeviceCount;
	public int counter = 1;
	
	public Integer[] brightnessPercentage = {20, 40, 60, 80, 100};
	
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
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtRoutername")
	public MobileElement mainRouterStatus;
	
	//====================LED Settings=====================
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
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/twenty_progress_tv")
	public MobileElement twenty;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/forty_progress_tv")
	public MobileElement forty;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/sixty_progress_tv")
	public MobileElement sixty;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/eighty_progress_tv")
	public MobileElement eighty;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/hundred_progress_tv")
	public MobileElement hundred;
	//====================LED Settings=====================
	
	
	//====================Connected Devices=====================
	@AndroidFindBy(id = "com.arris.sbcBeta:id/devicesNumbers")
	public MobileElement connectedDevicesCountText;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgDeviceInfoOpen")
	public MobileElement connectedDevicesExpandImage;
	//====================Connected Devices=====================
	
	
	//====================Main Router Details=====================
	
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
	public MobileElement macIPAddressLabel;
	
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
	
	//====================Main Router Details=====================
	
	
	public MainDeviceAllTabPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	
    public void dragTo40()throws  Exception
    {
    	int startX = seekBar.getLocation().getX();
    	int endX = seekBar.getSize().getWidth();
    	int yAxis = seekBar.getLocation().getY();
    	
    	int start=seekBar.getLocation().getX();
    	int end=seekBar.getSize().getWidth();
    	int y=seekBar.getLocation().getY();

        TouchAction action=new TouchAction(super.getDriver());
        action.press(start,y).moveTo(end,y).release().perform();

        //Move it 40%
        int moveTo=(int)(end*0.4);
        action.press(start,y).moveTo(moveTo,y).release().perform();

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
			utils.log().info("On Devices Page");
			return true;
		} else {
			utils.log().info("Not on Devices Page");
			return false;
		}
	}
}
