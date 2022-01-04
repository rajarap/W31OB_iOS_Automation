package com.cs.arris.Pages;

import java.time.Duration;

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

public class HomePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public Integer count;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home\"]")
	public MobileElement homeTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_TitleLabel\"]")
	public MobileElement networkSpeedTitle;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Menu\"]")
	public MobileElement navigateButton;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Cloud\"]")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement notificationsIcon;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_DownloadTitle\"]")
	public MobileElement downloadText;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Download\"]")
	public MobileElement downloadSpeedText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_UploadTitle\"]")
	public MobileElement uploadText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Upload\"]")
	public MobileElement uploadSpeedText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_SSID\"]")
	public MobileElement ssidName;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_MainAP\"]")
	public MobileElement mainDeviceName; // MAIN

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_Mesh\"]")
	public MobileElement mainDeviceImage; // MAIN

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_MainAPWithDevices\"]")
	public MobileElement mainDeviceCounter;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_AllDevicesCount\"]")
	public MobileElement totalNoOfDevices;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AllDevices\"]")
	public MobileElement totalNoOfDevicesImage;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AddLeft\"]")
	public MobileElement leftSatelliteImage;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AddRight\"]")
	public MobileElement rightSatelliteImage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title[1]\"]")
	public MobileElement deviceSignalStrengthLeaderBoardText;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_Expand[1]\"]")
	public MobileElement deviceSignalStrengthLeaderBoardImage;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Value[1]\"]")
	public MobileElement bitRateDevices;

	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title[1]\"])[2]")
	public MobileElement speedTestHistoryText;

	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_Expand[1]\"])[2]")
	public MobileElement speedTestHistoryImage;

	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Value[1]\"])[2]")
	public MobileElement speedTestHistoryDevices;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_WhoIsHomeTitle\"]")
	public MobileElement whoseHomeText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_WhoIsHomeSubTitle\"]")
	public MobileElement whoseHomeAndWhoseNotText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_Arrow\"]")
	public MobileElement whoseHomeArrow;

//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title_Currently\"]")
//	public MobileElement currentlyBlockedDevicesText; // Currently Blocked Devices
//
//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_ExpandCurrently\"]")
//	public MobileElement currentlyBlockedDevicesImage;
//
//	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgBlockedDevices")
//	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
//	public MobileElement currentlyBlockedDevicesButton;
//
//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_CurrentlyValue\"]")
//	public MobileElement parentalControlIsDisabled; // Parental Control is disabled
//
//	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
//	public MobileElement parentalControlImage;
//
//	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
//	public MobileElement currentlyBlockedDevicesEnabledText; // Currently Blocked Devices
//
//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
//	public MobileElement parentalControlBlockedDevices; // 00
//
//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
//	public MobileElement parentalControlEnabledImage;
	
	//Network Health
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Header\"]")
	public MobileElement networkHealthHeader;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Detail\"]")
	public MobileElement networkHealthOptimizatonTurnedOffText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Tap here to turn on\"]")
	public MobileElement tapToTurnOnNetworkHealth;
	
	//Promotion
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Home_Screen_Image_Logo\"]")
	public MobileElement promotionLogo;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Home_Screen_Image_Promotion\"]")
	public MobileElement promotionImage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Home_Screen_Button_Learn\"]")
	public MobileElement getProtectionNowButton;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Don't want to see promotion again?\"]")
	public MobileElement dontSeePromotionAgainText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Home_Screen_Label_Promotion\"]")
	public MobileElement specialOffersText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Home_Screen_Label_Offer\"]")
	public MobileElement freeTrialText;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Home_Screen_Button_Close\"]")
	public MobileElement closeBanner;
	
	//RAT
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Error\"]")
	public MobileElement remoteAccessNotAvailableLink; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_More\"]")
	public MobileElement moreLink; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Cloud\"]")
	public MobileElement cloudIcon1;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeCell[@name=\"Wi-Fi\"]")
	public MobileElement wifiLink;

//	@iOSXCUITFindBy (xpath = "//XCUIElementTypeCell[@name=\""+arris65443+", Secure network, Signal strength 3 of 3 bars\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
//	public MobileElement networkName;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
	public MobileElement settings;

	public MainDeviceAllTabPage getMainDeviceAllTabPageObject() {
		MainDeviceAllTabPage mainDevicePage = new MainDeviceAllTabPage();
		return mainDevicePage;
	}

	public DevicesPage getDevicesPageObject() {
		DevicesPage devicesPage = new DevicesPage();
		return devicesPage;
	}
	
	public AppRatingDialog getAppRatingDialogObject() {
		AppRatingDialog appRating = new AppRatingDialog();
		return appRating;
	}
	
	public HomePageRATTroubleShootPage getRATObject() {
		HomePageRATTroubleShootPage ratPage = new HomePageRATTroubleShootPage();
		return ratPage;
	}

	public DeviceSignalStrengthLeaderBoardPage getDeviceSignalStrengthPageObject() {
		DeviceSignalStrengthLeaderBoardPage devicesSignalStrengthPage = new DeviceSignalStrengthLeaderBoardPage();
		return devicesSignalStrengthPage;
	}

	public SpeedTestHistoryPage getSpeedTestHistoryPageObject() {
		SpeedTestHistoryPage speedTestHistoryPage = new SpeedTestHistoryPage();
		return speedTestHistoryPage;
	}

	public CurrentlyBlockedDevicesPage getCurrentlyBlockedDevicesPageObject() {
		CurrentlyBlockedDevicesPage currentlyBlockedDevicePage = new CurrentlyBlockedDevicesPage();
		return currentlyBlockedDevicePage;
	}

	public InstallAdditionalSatellitePage getInstallLeftSatellitePageObject() {
		InstallAdditionalSatellitePage installLeftSatellitePage = new InstallAdditionalSatellitePage();
		return installLeftSatellitePage;
	}

	public InstallAdditionalSatellitePage getInstallRightSatellitePageObject() {
		InstallAdditionalSatellitePage installRightSatellitePage = new InstallAdditionalSatellitePage();
		return installRightSatellitePage;
	}

	public HamburgerMenuPage getHamburgerMenuPageObject() {
		HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();
		return hamburgerMenuPage;
	}

	public BlankSpeedTestHistoryPage getBlankSpeedTestHistoryPageObject() {
		BlankSpeedTestHistoryPage blankSpeedHistoryPage = new BlankSpeedTestHistoryPage();
		return blankSpeedHistoryPage;
	}
	
	public BlankBlockedDevicesPage getBlankBlockedDevicesPageObject() {
		BlankBlockedDevicesPage blankSpeedHistoryPage = new BlankBlockedDevicesPage();
		return blankSpeedHistoryPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NotificationPage getNotificationPageObject() {
		NotificationPage notificationPage = new NotificationPage();
		return notificationPage;
	}
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void getSSIDName() {
		String ssidname = ssidName.getText();
		utils.log().info("You are connected to your router " + ssidname + " home network....Happy Surfing");
	}

//	public void clickOkButton() {
//		click(okButton);
//		utils.log().info("Network Optimization Dialog2 - Clicked on OK Button");
//	}
	
	public void clickCloseBanner() {
		click(closeBanner);
		utils.log().info("Closed Banner on Home Page");
	}

	// Verify if all the required UI elements are displayed on the Home Page
	public boolean verifyUIOnHomePage() {
		utils.log().info("*****************************************");
		utils.log().info("Details of UI Elements on the Home Page  ");
		utils.log().info("*****************************************");
		try {
			if (homeTitle.isDisplayed()) 
				utils.log().info("Title " + homeTitle.getText() + " is displayed");
			else 
				utils.log().info("Home Title is not displayed");

			if (networkSpeedTitle.isDisplayed())
				utils.log().info("Title " + networkSpeedTitle.getText() + " is displayed");
			else
				utils.log().info("Network Title is not displayed");

			if (navigateButton.isDisplayed())
				utils.log().info("Navigate Icon is displayed");
			else
				utils.log().info("Navigate Icon is displayed");
			
			try {
				if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
			}catch(Exception e) {
				utils.log().info("Cloud Icon is not displayed");}

			if (notificationsIcon.isDisplayed())
				utils.log().info("Notifications Icon is displayed");
			else
				utils.log().info("Notifications Icon is not displayed");

			if (downloadText.isDisplayed())
				utils.log().info("Download Text is displayed");
			else
				utils.log().info("Download Text is not displayed");

			if (downloadSpeedText.isDisplayed())
				utils.log().info("Download Speed Text " + downloadSpeedText.getText() + " is displayed");
			else
				utils.log().info("Download Speed Text is not displayed");

			if (uploadText.isDisplayed())
				utils.log().info("Upload Text is displayed");
			else
				utils.log().info("Upload Text is not displayed");

			if (uploadSpeedText.isDisplayed())
				utils.log().info("Upload Speed Text " + uploadSpeedText.getText() + " is displayed");
			else
				utils.log().info("Upload Speed Text is not displayed");
			
			if (networkHealthHeader.isDisplayed())
				utils.log().info("Network Health Header Text is displayed");
			else
				utils.log().info("Network Health Header Text is not displayed");
			
			if (networkHealthOptimizatonTurnedOffText.isDisplayed())
				utils.log().info("Network health optimization is turned off Text is displayed");
			else
				utils.log().info("Network health optimization is turned off Text is not displayed");
			
			if (tapToTurnOnNetworkHealth.isDisplayed())
				utils.log().info("Tap here to turn on Text is displayed");
			else
				utils.log().info("Tap here to turn on Text is not displayed");

			if (ssidName.isDisplayed())
				utils.log().info("Main Router SSID Name " + ssidName.getText() + "  is displayed");
			else
				utils.log().info("Main Router SSID Name is not displayed");

			if (mainDeviceImage.isDisplayed())
				utils.log().info("Main Router Device image is displayed");
			else
				utils.log().info("Main Router Device is not displayed");

			if (mainDeviceName.isDisplayed())
				utils.log().info("Main Router Device Name " + mainDeviceName.getText() + " is displayed");
			else
				utils.log().info("Main Router Device Name is displayed");

			if (mainDeviceCounter.isDisplayed())
				utils.log().info(mainDeviceCounter.getText() + " are connected to Main Router " );
			else
				utils.log().info("Devices conneced to the Main Router is not displayed");

			if (totalNoOfDevicesImage.isDisplayed())
				utils.log().info("Total number of devices image is displayed");
			else
				utils.log().info("Total number of devices image is not displayed");

			if (totalNoOfDevices.isDisplayed())
				utils.log().info(totalNoOfDevices.getText() + " text is displayed");
			else
				utils.log().info("Number of devices connected to the router is not displayed");

			if (leftSatelliteImage.isDisplayed())
				utils.log().info("Left Satellite Image is displayed");
			else
				utils.log().info("Left Satellite Image is not displayed");

			if (rightSatelliteImage.isDisplayed())
				utils.log().info("Right Satellite Image is displayed");
			else
				utils.log().info("Right Satellite Image is not displayed");
			
			super.swipeUp();
			
			if (promotionLogo.isDisplayed()) 
				utils.log().info("Promotional Logo is displayed");
			else
				utils.log().info("Promotional Logo is not displayed");
			
			if (promotionImage.isDisplayed()) 
				utils.log().info("Promotional Image is displayed");
			else
				utils.log().info("Promotional Image is not displayed");
			
			if (getProtectionNowButton.isDisplayed()) 
				utils.log().info("GET PROTECTION NOW button is displayed");
			else
				utils.log().info("GET PROTECTION NOW button is not displayed");
			
			if (dontSeePromotionAgainText.isDisplayed()) 
				utils.log().info("Don't want to see promotion again? text is displayed");
			else
				utils.log().info("Don't want to see promotion again? text is not displayed");
			
			if (specialOffersText.isDisplayed()) 
				utils.log().info("Special offer to our valued customers text is displayed");
			else
				utils.log().info("Special offer to our valued customers text is not displayed");
			
			if (freeTrialText.isDisplayed())
				utils.log().info("Exclusive to ARRIS - Identity Guard free trial for 60 days text is displayed");
			else
				utils.log().info("Exclusive to ARRIS - Identity Guard free trial for 60 days text is not displayed");
			
			if (closeBanner.isDisplayed()) 
				utils.log().info("Close Banner Icon is displayed");
			else
				utils.log().info("Close Banner Icon is not displayed");
			
			try {
			if (deviceSignalStrengthLeaderBoardText.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board Text is displayed");
			}catch(Exception e) {utils.log().info("Device Signal Strength Leader Board Text is not displayed");}

			try {
			if (deviceSignalStrengthLeaderBoardImage.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board Image is displayed");
			}catch(Exception e) {utils.log().info("Device Signal Strength Leader Board Image is not displayed");}

			try {
			if (bitRateDevices.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board is displayed for " + bitRateDevices.getText());
			}catch(Exception e) {utils.log().info("Device Signal Strength Leader Board Count is not displayed");}

			if (speedTestHistoryText.isDisplayed())
				utils.log().info("Speed Test History Text is displayed");
			else
				utils.log().info("Speed Test History Text is not displayed");

			if (speedTestHistoryImage.isDisplayed())
				utils.log().info("Speed Test History Image is displayed");
			else
				utils.log().info("Speed Test History Image is not displayed");

			if (speedTestHistoryDevices.isDisplayed())
				utils.log().info("Count of Speed Test History Devices : " + speedTestHistoryDevices.getText() + " is displayed");
			else
				utils.log().info("Count of Speed Test History Devices is not displayed");

			if (whoseHomeText.isDisplayed())
				utils.log().info("Who's Home Text is displayed");
			else
				utils.log().info("Who's Home Text is not displayed");

			if (whoseHomeAndWhoseNotText.isDisplayed())
				utils.log().info("Find out who’s home and who’s not text is displayed");
			else
				utils.log().info("Find out who’s home and who’s not text is not displayed");
			
			if (whoseHomeArrow.isDisplayed())
				utils.log().info("Who's Home Arrow Image is displayed");
			else
				utils.log().info("Who's Home Arrow Image is not displayed");
			
//			if (currentlyBlockedDevicesText.isDisplayed())
//				utils.log().info("Currently Blocked Devices Text is displayed");
//			else
//				utils.log().info("Currently Blocked Devices is not displayed");
//
//			if (currentlyBlockedDevicesImage.isDisplayed())
//				utils.log().info("Currently Blocked Devices Image is displayed");
//			else
//				utils.log().info("Currently Blocked Devices Image is not displayed");
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean clickNotificationsIcon() {
		if (notificationsIcon.isDisplayed()) {
			click(notificationsIcon);
			utils.log().info("Home Page - Clicked on Notifications Icon");
			return true;
		} else {
			utils.log().info("Home Page - Notifications Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickNavigationButton() {
		if (navigateButton.isDisplayed()) {
			click(navigateButton);
			utils.log().info("Home Page - Clicked on Navigation Icon to display the Hamburger Menu");
			return true;
		} else {
			utils.log().info("Home Page - Navigation Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickDeviceSignalStrengthImage() {
		String selector = "**/XCUIElementTypeStaticText[`label == \"Device Signal Strength Leader Board\"`]";
		if (super.getDriver().findElement(MobileBy.iOSClassChain(selector)).isDisplayed()) {
			super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
			utils.log().info("Home Page - Clicked on Device Signal Strength Leader Board ");
			return true;
		} else {
			utils.log().info(
					"Home Page - Device Signal Strength Leader Board is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickSpeedTestHistoryImage() {
		if (speedTestHistoryText.isDisplayed()) {
			speedTestHistoryText.click();
			utils.log().info("Home Page - Clicked on Speed Test History");
			return true;
		} else {
			utils.log().info("Home Page - Speed Test History is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickCurrentlyBlockedDevicesImage() {
		super.swipeUp();
		if (whoseHomeText.isDisplayed()) {
			click(whoseHomeText);
			utils.log().info("Home Page - Clicked on Who's Home Text");
			return true;
		} else {
			utils.log().info("Home Page - Who's Home Text is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickMainDeviceImage() {
		if (mainDeviceImage.isDisplayed()) {
			click(mainDeviceImage);
			utils.log().info("Home Page - Clicked on Main Device Image");
			return true;
		} else {
			utils.log().info("Home Page - Main Device Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickDevicesImage() {
		if (totalNoOfDevicesImage.isDisplayed()) {
			click(totalNoOfDevicesImage); 
			utils.log().info("Home Page - Clicked on Devices Image");
			return true;
		} else {
			utils.log().info("Home Page - Devices Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickLeftSatelliteImage() {
		if (leftSatelliteImage.isDisplayed()) {
			click(leftSatelliteImage);
			utils.log().info("Home Page - Clicked on Left Satellite Image");
			return true;
		} else {
			utils.log().info("Home Page - Left Satellite Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickRightSatelliteImage() {
		if (rightSatelliteImage.isDisplayed()) {
			click(rightSatelliteImage);
			utils.log().info("Home Page - Clicked on Right Satellite Image");
			return true;
		} else {
			utils.log().info("Home Page - Right Satellite Image is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickWhoseHomeText() {
		if (whoseHomeText.isDisplayed()) {
			click(whoseHomeText);
			utils.log().info("Home Page - Clicked on Who's Home Text");
			return true;
		} else {
			utils.log().info("Home Page - Who's Home Text is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickPromotionClose() {
		if (closeBanner.isDisplayed()) {
			click(closeBanner);
			utils.log().info("Home Page - Clicked on Promotion close Button");
			return true;
		} else {
			utils.log().info("Home Page - Promotion close Button is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean ratExists() {
		if(cloudIcon.isDisplayed()) {
			utils.log().info("Home Page - Cloud Icon is displayed");
			if(remoteAccessNotAvailableLink.isDisplayed()) 
				utils.log().info("Home Page - Remote access to your Network is currently unavailable Link is displayed");
			utils.log().info("Home Page - Clicked in More... Link");
			return true;
		}else {
			utils.log().info("Home Page - Cloud icon is not displayed");
			return true;
		}
	}

	public int getTotalCountOfDevices() {
		String noOfDevices = totalNoOfDevices.getText(); // Devices (2)
		count = getCountOfDevicesWithSpace(noOfDevices);
		super.devicesConnectedToRouter = count;
		return super.devicesConnectedToRouter;
	}
	
	public Integer getBitRateDevicesCount()
	{
		String count = bitRateDevices.getText();
		utils.log().info("Count of Device signals : " + count);
		int noOfDevices = Integer.parseInt(count);
		utils.log().info("Count of Device signals : " + noOfDevices);
		return noOfDevices;
		//return(Integer.valueOf(count.replaceFirst("^0+(?!$)", "")));
	}
	
	public void connectToSSID(String ssidentity)
	{
		try
		{
			super.getDriver().activateApp("com.apple.Preferences");
			super.swipeDown();
				
			if(wifiLink.isDisplayed())
				click(wifiLink);
				
			super.pause(2);
				
			String selector = "**/XCUIElementTypeCell[`label == \""+ssidentity+", Secure network, Signal strength 3 of 3 bars\"`]";
			super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
			super.pause(3);
				
			click(settings);
			super.getDriver().activateApp("com.arris.sbcBeta");
		}catch(Exception e) {}
	}
	

	@Override
	public boolean isAt() {
		if (homeTitle.isDisplayed()) {
			utils.log().info("On Home Page");
			return true;
		} else {
			utils.log().info("Not on Home Page");
			return false;
		}
	}
}
