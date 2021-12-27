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

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Home\"]")
	public MobileElement homeTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/speedtitle")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_TitleLabel\"]")
	public MobileElement networkSpeedTitle;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),
		@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Menu\"]")
	public MobileElement navigateButton;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
		@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_notification"),
		@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[996,158][1046,213]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_notification") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement notificationsIcon;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView20"),
		@AndroidBy(xpath = "//android.widget.Button[@bounds='[239,395][424,441]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/textView20") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_DownloadTitle\"]")
	public MobileElement downloadText;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDownloadSpeed"),
		@AndroidBy(xpath = "//android.widget.Button[@bounds='[248,455][416,512]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/txtDownloadSpeed") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Download\"]")
	public MobileElement downloadSpeedText;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView8"),
		@AndroidBy(xpath = "//android.widget.Button[@bounds='[674,395][818,441]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/textView8") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_UploadTitle\"]")
	public MobileElement uploadText;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtUploadSpeed"),
		@AndroidBy(xpath = "//android.widget.Button[@bounds='[661,455][831,512]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/txtUploadSpeed") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Upload\"]")
	public MobileElement uploadSpeedText;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/ssidName"),
		@AndroidBy(xpath = "//android.widget.Button[@bounds='[428,587][653,661]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/ssidName") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_SSID\"]")
	public MobileElement ssidName;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainRouter"),
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[498,622][589,682]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/txtMainRouter") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_MainAP\"]")
	public MobileElement mainDeviceName; // MAIN

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgMainRouter"),
		@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[455,397][609,608]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/imgMainRouter") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_Mesh\"]")
	public MobileElement mainDeviceImage; // MAIN

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDeviceCounter"),
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[441,1077][639,1156]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/txtMainDeviceCounter") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_MainAPWithDevices\"]")
	public MobileElement mainDeviceCounter;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtTotalDevices"),
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[416,1017][665,1103]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/txtTotalDevices") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_AllDevicesCount\"]")
	public MobileElement totalNoOfDevices;

	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/imgtotalperipheral"),
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[404,904][677,1017]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/imgtotalperipheral") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AllDevices\"]")
	public MobileElement totalNoOfDevicesImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgNoLeftSatellite"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[217,1008][302,1192]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/imgNoLeftSatellite") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AddLeft\"]")
	public MobileElement leftSatelliteImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgNoRightSatellite"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[769,1008][854,1192]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/imgNoRightSatellite") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_AddRight\"]")
	public MobileElement rightSatelliteImage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Home_Screen_Button_Close\"]")
	public MobileElement promotionCloseIcon;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView162"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1569][784,1633]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textView162") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title_Device\"]")
	public MobileElement deviceSignalStrengthLeaderBoardText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen2"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[924,1596][995,1667]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen2") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_ExpandDevice\"]")
	public MobileElement deviceSignalStrengthLeaderBoardImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textBitRateDevices"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1633][118,1693]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textBitRateDevices") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_DeviceValue\"]")
	public MobileElement bitRateDevices;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@bounds='[51,1154][1029,1346]']")
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement deviceSignalStrengthButton;

	@AndroidFindAll({ 
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView163"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1838][437,1902]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textView163") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title_Speed\"]")
	public MobileElement speedTestHistoryText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen3"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[924,1873][995,1944]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen3") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_ExpandSpeed\"]")
	public MobileElement speedTestHistoryImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textSpeedHistoryDevices"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1919][129,1979]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textSpeedHistoryDevices") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_SpeedValue\"]")
	public MobileElement speedTestHistoryDevices;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@bounds='[51,1397][1029,1657]']")
	public MobileElement speedTestHistoryButton;


	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView164"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1742][585,1806]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textView164") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_Title_Currently\"]")
	public MobileElement currentlyBlockedDevicesText; // Currently Blocked Devices

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen5"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[924,1742][995,1813]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen5") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"Mesh_Home_Screen_Image_ExpandCurrently\"]")
	public MobileElement currentlyBlockedDevicesImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/imgBlockedDevices")
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement currentlyBlockedDevicesButton;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/img_full_screen3"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1806][578,1866]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen3") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Mesh_Home_Screen_Label_CurrentlyValue\"]")
	public MobileElement parentalControlIsDisabled; // Parental Control is disabled

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen5"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[924,1742][995,1813]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen5") })
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement parentalControlImage;

	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView164"),
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1742][585,1806]]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/textView164") })
	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement currentlyBlockedDevicesEnabledText; // Currently Blocked Devices

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textBlockedDevices"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[85,1806][129,1866]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/textBlockedDevices") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement parentalControlBlockedDevices; // 00

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen5"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[924,1742][995,1813]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_full_screen5") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_NavigationBar_Button_Notification\"]")
	public MobileElement parentalControlEnabledImage;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Home_Screen_Button_Close\"]")
	public MobileElement closeBanner;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/home_view") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleHome\"]")
	public MobileElement homeButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/home_txt"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[137,2089][218,2135]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/home_txt") })
	public MobileElement homeButtonText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_footer_home"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[142,2018][213,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_footer_home") })
	public MobileElement homeButtonImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/network_view") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleNetwork\"]")
	public MobileElement networkButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/network_txt"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[484,2089][595,2135]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/network_txt") })
	public MobileElement networkButtonText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView@resource-id='com.arris.sbcBeta:id/img_footer_network"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[504,2018][575,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_footer_network") })
	public MobileElement networkButtonImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),
			@AndroidBy(xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/parental_view") })
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"TabBar_TitleParental\"]")
	public MobileElement parentalButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/parental_txt"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[844,2089][959,2135]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/parental_txt") })
	public MobileElement parentalButtonText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='ccom.arris.sbcBeta:id/img_footer_parental"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[866,2018][937,2042]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_footer_parental") })
	public MobileElement parentalButtonImage;

	// Network Optimization dialog elements
	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialog_heading")
	public MobileElement networkOptimizationTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/dialog_description")
	public MobileElement networkOptimizationMessage;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ok']"),
			@AndroidBy(xpath = "//android.widget.Button[@bounds='[147,1312][933,1449]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/btn_dialog_ok") })
	public MobileElement okButton;
	
	
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

	public void clickOkButton() {
		click(okButton);
		utils.log().info("Network Optimization Dialog2 - Clicked on OK Button");
	}
	
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
			
			if (promotionCloseIcon.isDisplayed()) {
				utils.log().info("Promotional Image is displayed");
				click(promotionCloseIcon);
				utils.log().info("Closed Promotional Image");}
			else
				utils.log().info("Promotional Image is not displayed");
			

			if (deviceSignalStrengthLeaderBoardText.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board Text is displayed");
			else
				utils.log().info("Device Signal Strength Leader Board Text is not displayed");

			if (deviceSignalStrengthLeaderBoardImage.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board Image is displayed");
			else
				utils.log().info("Device Signal Strength Leader Board Image is not displayed");

			if (bitRateDevices.isDisplayed())
				utils.log().info("Device Signal Strength Leader Board is displayed for " + bitRateDevices.getText());
			else
				utils.log().info("Device Signal Strength Leader Board Count is not displayed");

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

			if (currentlyBlockedDevicesText.isDisplayed())
				utils.log().info("Currently Blocked Devices Text is displayed");
			else
				utils.log().info("Currently Blocked Devices is not displayed");

			if (currentlyBlockedDevicesImage.isDisplayed())
				utils.log().info("Currently Blocked Devices Image is displayed");
			else
				utils.log().info("Currently Blocked Devices Image is not displayed");
			
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
		if (deviceSignalStrengthLeaderBoardImage.isDisplayed()) {
			click(deviceSignalStrengthLeaderBoardImage);
			utils.log().info("Home Page - Clicked on Device Signal Strength Leader Board Image");
			return true;
		} else {
			utils.log().info(
					"Home Page - Device Signal Strength Leader Board Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickSpeedTestHistoryImage() {
		if (speedTestHistoryImage.isDisplayed()) {
			click(speedTestHistoryImage);
			utils.log().info("Home Page - Clicked on Speed Test History Image");
			return true;
		} else {
			utils.log().info("Home Page - Speed Test History Image is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickCurrentlyBlockedDevicesImage() {
		super.swipeUp();
		if (currentlyBlockedDevicesImage.isDisplayed()) {
			click(currentlyBlockedDevicesImage);
			utils.log().info("Home Page - Clicked on Currently Blocked Devices Image");
			return true;
		} else {
			utils.log().info("Home Page - Currently Blocked Devices Image is either not visible or is not present on the DOM");
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
		return(Integer.valueOf(count.replaceFirst("^0+(?!$)", "")));
	}
	
	public void connectToSSID(String ssidentity)
	{
		try
		{
//			utils.log().info("Running App in the Background");
//			super.getDriver().runAppInBackground(Duration.ofSeconds(20));
			
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
				
//			String wifiName = "//XCUIElementTypeStaticText[@name=\""+ssidentity+"\"]";
//				
//			if(super.getDriver().findElement(MobileBy.iOSClassChain(wifiName)).isDisplayed())
//				utils.log().info("IPhone Settings Page - mAX Router is now connected to the SSID network");
//			//super.getDriver().closeApp();
//				
//			utils.log().info("Activating App running in Background");

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
