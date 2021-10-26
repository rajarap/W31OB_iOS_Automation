package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public Integer count;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //HOME
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[474,149][606,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement homeTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/speedtitle"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[396,259][684,323]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/speedtitle") 
	})
	public MobileElement networkSpeed; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),  
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']"),
	})
	public MobileElement navigateButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_notification"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[996,158][1046,213]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_notification") 
	})
	public MobileElement notificationsIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView20"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[239,395][424,441]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textView20") 
	})
	public MobileElement downloadText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDownloadSpeed"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[248,455][416,512]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDownloadSpeed") 
	})
	public MobileElement downloadSpeedText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView8"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[674,395][818,441]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textView8") 
	})
	public MobileElement uploadText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtUploadSpeed"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[661,455][831,512]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtUploadSpeed") 
	})
	public MobileElement uploadSpeedText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/ssidName"),  
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[428,587][653,661]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ssidName") 
	})
	public MobileElement ssidName; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainRouter"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[498,622][589,682]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainRouter") 
	})
	public MobileElement mainDeviceName;  //MAIN
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgMainRouter"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[455,397][609,608]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgMainRouter") 
	})
	public MobileElement mainDeviceImage;  //MAIN 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDeviceCounter"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[441,1077][639,1156]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainDeviceCounter") 
	})
	public MobileElement mainDeviceCounter; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtTotalDevices"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[416,1017][665,1103]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtTotalDevices") 
	})
	public MobileElement totalNoOfDevices; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/imgtotalperipheral"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[404,904][677,1017]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgtotalperipheral") 
	})
	public MobileElement totalNoOfDevicesImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgNoLeftSatellite"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[217,1008][302,1192']']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgNoLeftSatellite") 
	})
	public MobileElement totalNoOfLeftSatellites; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgNoRightSatellite"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[769,1008][854,1192]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgNoRightSatellite") 
	})
	public MobileElement totalNoOfRightSatellites; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView162"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1569][784,1633]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textView162") 
	})
	public MobileElement deviceSignalStrengthLeaderBoardText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen2"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[924,1596][995,1667]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_full_screen2") 
	})
	public MobileElement deviceSignalStrengthLeaderBoardImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textBitRateDevices"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1633][118,1693]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textBitRateDevices") 
	})
	public MobileElement bitRateDevices; 
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@bounds='[51,1154][1029,1346]']")
	public MobileElement deviceSignalStrengthButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView163"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1838][437,1902]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textView163") 
	})
	public MobileElement speedTestHistoryText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen3"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[924,1873][995,1944]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_full_screen3") 
	})
	public MobileElement speedTestHistoryImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textSpeedHistoryDevices"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1919][129,1979]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textSpeedHistoryDevices") 
	})
	public MobileElement speedTestDevices; 
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@bounds='[51,1397][1029,1657]']")
	public MobileElement speedTestHistoryButton; 
	
	
	//######################### For Disabled Parental Control #########################################
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView164"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1742][585,1806]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/textView164") 
	})
	public MobileElement currentlyBlockedDevicesText;   //Currently Blocked Devices
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@bounds='[51,1708][1029,1913]']")
	public MobileElement currentlyBlockedDevicesButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/img_full_screen3"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1806][578,1866]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_full_screen3") 
	})
	public MobileElement parentalControlIsDisabled;   //Parental Control is disabled
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen5"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[924,1742][995,1813]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_full_screen5") 
	})
	public MobileElement parentalControlImage; 
	
	//######################### For Disabled Parental Control #########################################
	
	
	//######################### For Enabled Parental Control #########################################
	
		@AndroidFindAll({
			@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textView164"),  
			@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1742][585,1806]]']"),
			@AndroidBy (id = "com.arris.sbcBeta:id/textView164") 
		})
		public MobileElement currentlyBlockedDevicesEnabledText;   //Currently Blocked Devices
		
		@AndroidFindAll({
			@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/textBlockedDevices"),  
			@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1806][129,1866]']"),
			@AndroidBy (id = "com.arris.sbcBeta:id/textBlockedDevices") 
		})
		public MobileElement parentalControlBlockedDevices;   //00
		
		@AndroidFindAll({
			@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_full_screen5"),  
			@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[924,1742][995,1813]']"),
			@AndroidBy (id = "com.arris.sbcBeta:id/img_full_screen5") 
		})
		public MobileElement parentalControlEnabledImage; 
		
		//######################### For Enabled Parental Control #########################################
	
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	public MobileElement homeButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/home_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[137,2089][218,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_txt") 
	})
	public MobileElement homeButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_footer_home"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[142,2018][213,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_home") 
	})
	public MobileElement homeButtonImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_view") 
	})
	public MobileElement networkButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/network_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[484,2089][595,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_txt") 
	})
	public MobileElement networkButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView@resource-id='com.arris.sbcBeta:id/img_footer_network"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[504,2018][575,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_network") 
	})
	public MobileElement networkButtonImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_view") 
	})
	public MobileElement parentalButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/parental_txt"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[844,2089][959,2135]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_txt") 
	})
	public MobileElement parentalButtonText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='ccom.arris.sbcBeta:id/img_footer_parental"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[866,2018][937,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_footer_parental") 
	})
	public MobileElement parentalButtonImage; 
	
	
	
	//Network Optimization dialog elements
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_heading") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_heading']") // text = Network Optimization
	public MobileElement networkOptimizationTitle;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/dialog_description']") // text = Please connect to arrisw3130 through your Mobile Device Wi-Fi settings.
	public MobileElement networkOptimizationMessage;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_ok']"), // text = NEXT
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[147,1312][933,1449]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_dialog_ok") 
	})
	public MobileElement okButton;
	
	
	public HomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void getSSIDName()
	{
		String ssidname = ssidName.getText();
		utils.log().info("You are connected to your " + ssidname + " home network....Happy Surfing");
	}
	
	public void clickOkButton()
	{
		click(okButton);
		utils.log().info("Network Optimization Dialog2 - Clicked on OK Button");
	}
	
	public void verifyUIOnHomePage()
	{
		if(homeTitle.isDisplayed())
			utils.log().info("Home Title - " + homeTitle.getText() + " - is displayed");
		else
			utils.log().info("Home Title is not displayed");
		
		if(networkSpeed.isDisplayed())
			utils.log().info("Network Speed  Title - " + networkSpeed.getText() + " - is displayed");
		else
			utils.log().info("Network Title is not displayed");
		
		if(navigateButton.isDisplayed())
			utils.log().info("Navigate Icon is displayed");
		else
			utils.log().info("Navigate Icon is displayed");
		
		if(cloudIcon.isDisplayed())
			utils.log().info("Cloud Icon is displayed");
		else
			utils.log().info("Cloud Icon is not displayed");
		
		if(notificationsIcon.isDisplayed())
			utils.log().info("Notifications Icon is displayed");
		else
			utils.log().info("Notifications Icon is not displayed");
		
		if(downloadText.isDisplayed())
			utils.log().info("Download Text is displayed");
		else
			utils.log().info("Download Text is not displayed");
		
		if(downloadSpeedText.isDisplayed())
			utils.log().info("Download Speed Text - " + downloadSpeedText.getText() + " - is displayed");
		else
			utils.log().info("Download Speed Text is not displayed");
		
		if(uploadText.isDisplayed())
			utils.log().info("Upload Text is displayed");
		else
			utils.log().info("Upload Text is not displayed");
		
		if(uploadSpeedText.isDisplayed())
			utils.log().info("Upload Speed Text - " + uploadSpeedText.getText() + " - is displayed");
		else
			utils.log().info("Upload Speed Text is not displayed");
		
		if(ssidName.isDisplayed())
			utils.log().info("Main Router SSID Name - " + ssidName.getText() + " - is displayed");
		else
			utils.log().info("Main Router SSID Name is not displayed");
		
		if(mainDeviceImage.isDisplayed())
			utils.log().info("Main Router Device image is displayed");
		else
			utils.log().info("Main Router Device is not displayed");
		
		if(mainDeviceName.isDisplayed())
			utils.log().info("Main Router Device Name - " + mainDeviceName.getText() + " - is displayed");
		else
			utils.log().info("Main Router Device Name is displayed");
			
		if(mainDeviceCounter.isDisplayed())
			utils.log().info("Number of Devices Connected to Main Router - " + mainDeviceCounter.getText() + " - is displayed");
		else
			utils.log().info("Main devices counter is not displayed");
		
		if(totalNoOfDevicesImage.isDisplayed())
			utils.log().info("Total number of devices image is displayed");
		else
			utils.log().info("Total number of devices image is not displayed");
		
		if(totalNoOfDevices.isDisplayed())
			utils.log().info("Total of - " + super.getCountOfDevices(totalNoOfDevices.getText())+ " - devices are connected to the main Router");
		else
			utils.log().info("Total number of devices connected to the router is not displayed");
		
		if(totalNoOfLeftSatellites.isDisplayed())
			utils.log().info("Left Satellite Image is displayed");
		else 
			utils.log().info("Left Satellite Image is not displayed");
		
		if(totalNoOfRightSatellites.isDisplayed())
			utils.log().info("Right Satellite Image is displayed");
		else
			utils.log().info("Right Satellite Image is not displayed");
		
		if(deviceSignalStrengthLeaderBoardText.isDisplayed())
			utils.log().info("Device Signal Strength Leader Board Text is displayed");
		else
			utils.log().info("Device Signal Strength Leader Board Text is not displayed");
		
		if(speedTestDevices.isDisplayed())
			utils.log().info("Speed Test History Text is displayed");
		else
			utils.log().info("Speed Test History Text is not displayed");
		
		if(currentlyBlockedDevicesText.isDisplayed())
			utils.log().info("Currently Blocked Devices Text is displayed");
		else
			utils.log().info("Currently Blocked Devices is not displayed");
		
		if(parentalControlBlockedDevices.isDisplayed())
			utils.log().info("Count of devices blocked Text is displayed");
		else
			utils.log().info("Count of devices blocked is not displayed");
		
		if(homeButton.isDisplayed())
			utils.log().info("Home Button is displayed");
		else
			utils.log().info("Home Button is not displayed");
		
		if(homeButtonText.isDisplayed())
			utils.log().info("Home Button Text is displayed");
		else
			utils.log().info("Home Button Text is not displayed");
		
		if(homeButtonImage.isDisplayed())
			utils.log().info("Home Button Image is displayed");
		else
			utils.log().info("Home Button Image is not displayed");
		
		if(networkButton.isDisplayed())
			utils.log().info("Network Button is displayed");
		else
			utils.log().info("Network Button is not displayed");
		
		if(networkButtonText.isDisplayed())
			utils.log().info("Network Button Text is displayed");
		else
			utils.log().info("Network Button Text is not displayed");
		
		if(networkButtonImage.isDisplayed())
			utils.log().info("Network Button Image is displayed");
		else
			utils.log().info("Network Button Image is not displayed");
		
		if(parentalButton.isDisplayed())
			utils.log().info("Partental Button is displayed");
		else
			utils.log().info("Parental Button is not displayed");
		
		if(parentalButtonText.isDisplayed())
			utils.log().info("Partental Button Text is displayed");
		else
			utils.log().info("Parental Button Text is not displayed");
		
		if(parentalButtonImage.isDisplayed())
			utils.log().info("Parental Button Image is displayed");
		else
			utils.log().info("Parental Button Image is not displayed");
	}
	
	public void clickNotificationsIcon()
	{
		click(notificationsIcon);
	}
	
	public void clickNavigationButton()
	{
		click(navigateButton);
	}
	
	public void clickSpeedTestHistoryButton()
	{
		click(speedTestHistoryButton);
	}
	
	public void clickDeviceSignalStrengthButton()
	{
		click(deviceSignalStrengthButton);
	}
	
	public void clickCurrentlyBlockedDevicesButton()
	{
		click(currentlyBlockedDevicesButton);
	}
	
	public void clickHomeButton()
	{
		click(homeButton);
	}
	
	public void clickNetworkButton()
	{
		click(networkButton);
	}
	
	public void clickParentalButton()
	{
		click(parentalButton);
	}
	
	public void clickMainDeviceImage()
	{
		click(mainDeviceImage);	//Click this link to navigate to the Devices1Page
	}
	
	public void clicktotalNoOfDeviceImage()
	{
		click(totalNoOfDevicesImage);  //Click this link to navigate to the Devices2Page
	}
	
	public void getTotalCountOfDevices()
	{
		String noOfDevices = totalNoOfDevices.getText();  //Devices (2)
		count = getCountOfDevices(noOfDevices);
	}
	
	
	@Override
	public boolean isAt() {
		if(homeTitle.isDisplayed())
		{
			utils.log().info("On Home Page");
			return true;}
		else {
			utils.log().info("Not on Home Page");
		return false;}
		
	}

}
