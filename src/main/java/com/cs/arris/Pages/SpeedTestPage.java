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
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //Notification
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
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	public MobileElement homeButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_view") 
	})
	public MobileElement networkButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_view") 
	})
	public MobileElement parentalButton; 
	
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
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/view_history")
	public MobileElement viewHistory;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/download_wifi_view")
	public MobileElement downloadWifiView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/upload_wifi_view")
	public MobileElement uploadWifiView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/internet_speed_test_result")
	public MobileElement speedLegends;
	
	
	public SpeedTestPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	//click back icon on notification page
	public void clickBackIcon()
	{
		click(backIcon); // goes back to home page
		utils.log().info("Speed Test Page - Clicked on Back Button");
	}
	
	public void clickHomeButton()
	{
		click(homeButton);
		utils.log().info("Speed Test Page - Clicked on Home Button");
	}
	
	public void clickNetworkButton()
	{
		click(networkButton);
		utils.log().info("Speed Test Page - Clicked on Network Button");
	}
	
	public void clickParentalButton()
	{
		click(parentalButton);
		utils.log().info("Speed Test Page - Clicked on Parental Button");
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
		
		if(homeButton.isDisplayed())
			utils.log().info("Speed Test Page - Home Button is displayed");
		else
			utils.log().info("Speed Test Page - Home Button is not displayed");
		
		if(networkButton.isDisplayed())
			utils.log().info("Speed Test Page - Network Button is displayed");
		else
			utils.log().info("Speed Test Page - Network Button is not displayed");
		
		if(parentalButton.isDisplayed())
			utils.log().info("Speed Test Page - Partental Button is displayed");
		else
			utils.log().info("Speed Test Page - Parental Button is not displayed");
		
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
	
	public void verifySpeedTestButtonLabel()
	{
		utils.log().info("Speed Test Page - Label on button before speed Test: " + startSpeedTestButton.getText());
		clickStartSpeedTestButton();
		utils.log().info("Speed Test Page -Label on button after speed Test: " + stopSpeedTestButton.getText());
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
