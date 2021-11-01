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

public class SpeedTestPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //Speed Test
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[420,149][660,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement speedTestTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //Navigate up
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	

	@AndroidFindBy (id = "com.arris.sbcBeta:id/left_speed_test_icon")
	public MobileElement deviceImage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/device_name")
	public MobileElement deviceName;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/center_router")
	public MobileElement routerImage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/router_name")
	public MobileElement ssidName;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/right_speed_test_icon")
	public MobileElement speedTestIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[870,423][978,469]']")
	public MobileElement speedTestName;  //nternet
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/speed_meter")
	public MobileElement speedTestMeter;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/stop_speed_test")
	public MobileElement startSpeedTestButton;

	@AndroidFindBy (id = "com.arris.sbcBeta:id/stop_speed_test")
	public MobileElement stopSpeedTestButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/stop_speed_test")
	public MobileElement runSpeedTestAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/view_history")
	public MobileElement viewHistory;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[136,479][328,532]']")
	public MobileElement wifiDownloadView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/wifi_download_speed")
	public MobileElement wifiDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[136,571][281,624]']")
	public MobileElement wifiUploadWifiView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/wifi_download_speed")
	public MobileElement wifiUploadloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[756,479][948,532]']")
	public MobileElement internetDownloadView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/internet_download_speed")
	public MobileElement internetDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[756,571][901,624]']")
	public MobileElement internetUploadView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/internet_upload_speed")
	public MobileElement internetUploadSpeed;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/speed_test_message_heading")
	public MobileElement wifiSpeedGoodForText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[156,1039][937,1099]']")
	public MobileElement webBrowsingEmail;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/email_enable_disable")
	public MobileElement emailEnableIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[159,1150][937,1216]']")
	public MobileElement casualGaming;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/sd_video_enable_disable")
	public MobileElement sdVideoEnableIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[153,1267][937,1330]']")
	public MobileElement hdVideo;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/hd_video_enable_disable")
	public MobileElement hdVideoEnableIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[159,1381][937,1441]']")
	public MobileElement virtualReality;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/k4_video_enable_disable")
	public MobileElement virtualEnableIcon;
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public SpeedTestHistoryPage getSpeedTestHistoryPageObject() {
		 SpeedTestHistoryPage speedTestHistoryPage = new SpeedTestHistoryPage();
	     return speedTestHistoryPage;
	  }
	
	
	public SpeedTestPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	//click back icon 
	public void clickBackIcon()
	{
		click(backIcon); // goes back to home page
		utils.log().info("Speed Test Page - Clicked on Back Button");
	}
	
	//click help icon 
	public void clickHelpIcon()
	{
		click(helpIcon); // goes back to home page
		utils.log().info("Speed Test Page - Clicked on Help Button");
	}
	
	
	public void verifyUIOnSpeedTestPage()
	{
		if(speedTestTitle.isDisplayed())
			utils.log().info("Speed Test Page - Title - " + speedTestTitle.getText() + " - is displayed");
		else
			utils.log().info("Notifications Title is not displayed");
		
		if(backIcon.isDisplayed())
			utils.log().info("Speed Test Page - Back Icon is displayed");
		else
			utils.log().info("Speed Test Page - Back Icon is not displayed");
		
		if(cloudIcon.isDisplayed())
			utils.log().info("Speed Test Page - Cloud Icon is displayed");
		else
			utils.log().info("Speed Test Page - Cloud Icon is displayed");
		
		if(helpIcon.isDisplayed())
			utils.log().info("Speed Test Page - Help Icon is displayed");
		else
			utils.log().info("Speed Test Page - Help Icon is displayed");
		
		if(deviceImage.isDisplayed())
			utils.log().info("Speed Test Page - Device Image is displayed");
		else
			utils.log().info("Speed Test Page - Device Image is not displayed");
		
		if(deviceName.isDisplayed())
			utils.log().info("Speed Test Page - Device Name is displayed");
		else
			utils.log().info("Speed Test Page - Device Name is not displayed");
		
		if(routerImage.isDisplayed())
			utils.log().info("Speed Test Page - Router Image is displayed");
		else
			utils.log().info("Speed Test Page - Router Imnage Button is not displayed");
		
		if(ssidName.isDisplayed())
			utils.log().info("Speed Test Page - SSID Name is displayed");
		else
			utils.log().info("Speed Test Page - SSID Name is not displayed");
		
		if(speedTestIcon.isDisplayed())
			utils.log().info("Speed Test Page - Interet Icon is displayed");
		else
			utils.log().info("Speed Test Page - Interet Icon is not displayed");
		
		if(speedTestName.isDisplayed())
			utils.log().info("Speed Test Page - Internet Text is displayed");
		else
			utils.log().info("Speed Test Page - Internet Text is not displayed");
		
		if(speedTestMeter.isDisplayed())
			utils.log().info("Speed Test Page - Speed Test Meter is displayed");
		else
			utils.log().info("Speed Test Page - Speed Test Meter is not displayed");
		
		if(startSpeedTestButton.isDisplayed())
			utils.log().info("Speed Test Page - Start Speed Test Button is displayed");
		else
			utils.log().info("Speed Test Page - Start Speed Test Button is not displayed");
			
		if(viewHistory.isDisplayed())
			utils.log().info("Speed Test Page - View History Button is displayed");
		else
			utils.log().info("Speed Test Page - View History Button is not displayed");
	}
	
	public void clickStartSpeedTestButton()
	{
		click(startSpeedTestButton);
		utils.log().info("Speed Test Page - Clicked Start Speed Test Button");
	}
	
	public void clickStopSpeedTestButton()
	{
		click(stopSpeedTestButton);
		utils.log().info("Speed Test Page - Clicked Stop Speed Test Button");
	}
	
	public void clickViewHistoryButton()
	{
		click(viewHistory);
		utils.log().info("Speed Test Page - Clicked View History Button");
	}
	
	public void clickSpeedTest()
	{
		utils.log().info("Speed Test Page - Label on button before speed Test: " + startSpeedTestButton.getText());
		clickStartSpeedTestButton();
		utils.log().info("Speed Test Page - Label on button during speed Test: " + stopSpeedTestButton.getText());
		super.pause(70);
		utils.log().info("Speed Test Page - Label on button after speed Test: " + runSpeedTestAgainButton.getText());
	}
	
	public void verifySpeedTestResults()
	{
		if(wifiDownloadView.isDisplayed())
			utils.log().info("Wifi Download Text " + wifiDownloadView.getText() + " is displayed");
		else
			utils.log().info("Wifi Download Text is not displayed");
		
		if(wifiDownloadSpeed.isDisplayed())
			utils.log().info("Wifi Download Speed of " + wifiDownloadView.getText() + " is displayed");
		else
			utils.log().info("Wifi Download Speed is not displayed");
		
		if(wifiUploadWifiView.isDisplayed())
			utils.log().info("Wifi Upload Text " + wifiUploadWifiView.getText() + " is displayed");
		else
			utils.log().info("Wifi Upload Text is not displayed");
		
		if(wifiUploadloadSpeed.isDisplayed())
			utils.log().info("Wifi Upload Speed " + wifiUploadloadSpeed.getText() + " is displayed");
		else
			utils.log().info("Wifi Upload Speed is not displayed");
		
		if(internetDownloadView.isDisplayed())
			utils.log().info("Internet Download Text " + internetDownloadView.getText() + " is displayed");
		else
			utils.log().info("Internet Download Text is not displayed");
		
		if(internetDownloadSpeed.isDisplayed())
			utils.log().info("Internet Download Speed " + internetDownloadSpeed.getText() + " is displayed");
		else
			utils.log().info("Internet Download Speed is not displayed");
		
		if(internetUploadView.isDisplayed())
			utils.log().info("Internet Upload Text " + internetUploadView.getText() + " is displayed");
		else
			utils.log().info("Internet Upload Text is not displayed");
		
		if(internetUploadSpeed.isDisplayed())
			utils.log().info("Internet Upload Speed " + internetUploadSpeed.getText() + " is displayed");
		else
			utils.log().info("Internet Download Speed is not displayed");
		
		if(wifiSpeedGoodForText.isDisplayed())
			utils.log().info(wifiSpeedGoodForText.getText() + " is displayed");
		else
			utils.log().info("This Wi-Fi Speed is good for: text is not displayed");
		
		if(webBrowsingEmail.isDisplayed())
			utils.log().info(webBrowsingEmail.getText() + " is displayed");
		else
			utils.log().info("Web Browsing/E-mail text is not displayed");
		
		if(emailEnableIcon.isDisplayed())
			utils.log().info("Web Browsing/E-mail enableddisable icon is displayed");
		else
			utils.log().info("Web Browsing/E-mail enable/disable iconis not displayed");
		
		if(casualGaming.isDisplayed())
			utils.log().info(casualGaming.getText() + " is displayed");
		else
			utils.log().info("SD Video, Music, and Casual Gaming text is not displayed");
		
		if(sdVideoEnableIcon.isDisplayed())
			utils.log().info("SD Video, Music, and Casual Gaming enable/disable icon is displayed");
		else
			utils.log().info("SD Video, Music, and Casual Gaming enable/disable icon is not displayed");
		
		if(hdVideo.isDisplayed())
			utils.log().info(hdVideo.getText() + " is displayed");
		else
			utils.log().info("HD Video and Competitive Gaming text is not displayed");
		
		if(hdVideoEnableIcon.isDisplayed())
			utils.log().info("HD Video and Competitive Gaming enable/disable icon is displayed");
		else
			utils.log().info("HD Video and Competitive Gaming enable/disable icon is not displayed");
		
		if(virtualReality.isDisplayed())
			utils.log().info(virtualReality.getText() + " is displayed");
		else
			utils.log().info("UHD/4K Video/ Virtual Reality text is not displayed");
		
		if(virtualEnableIcon.isDisplayed())
			utils.log().info("UHD/4K Video/ Virtual Reality enable/disable icon is displayed");
		else
			utils.log().info("UHD/4K Video/ Virtual Reality enable/disable icon  is not displayed");
	}
	

	@Override
	public boolean isAt() {
		if(speedTestTitle.isDisplayed())
		{
			utils.log().info("At Speed Test Page");
			return true;
		}
		else
		{
			utils.log().info("Speed Test Page is not displayed");
			return false;
		}
	}

}
