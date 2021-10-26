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

public class DeviceSignalStrengthLeaderBoardPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@content-desc='SBC Test']/android.widget.TextView[1]"),  //DEVICE SIGNAL STRENGTH LEADER BOARD
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[102,348][978,527]']"),
	})
	public MobileElement leaderBoardTitleText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@content-desc='SBC Test']/android.widget.TextView[2]"),
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtTotalDevices"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[101,535][325,609]']"),
	})
	public MobileElement numberOfDevicesText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@content-desc='SBC Test']/android.widget.TextView[3]"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement topFiveOnlineDevices; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='android:id/text1']"),  //strong to weak
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[526,644][979,712]']"),
		@AndroidBy (id = "android:id/text1") 
	})
	public MobileElement sortDevicesOnSignalStrength; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']"),  //Galaxy-S10-Android (me)
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[271,770][749,827]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceName") 
	})
	public MobileElement mobileDeviceName; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']"),  //5GHz
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[271,837][435,894]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainSignalStrength") 
	})
	public MobileElement signalStrength; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']"),  //5GHz
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[271,923][420,960]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainDownloadSpeed") 
	})
	public MobileElement downloadSpeed; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']"),  //5GHz
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[540,921][690,958]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainUpLoadSpeed") 
	})
	public MobileElement uploadSpeed; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']"),  //5GHz
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[160,784][213,876]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgDevice") 
	})
	public MobileElement mobileDeviceImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/rcyclrDevices']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/rcyclrDevices") 
	})
	public MobileElement recyclerView; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/setBackgroundForFreezingList") 
	})
	public MobileElement deviceEntry1; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	public MobileElement homeButton; 
	
	
	public DeviceSignalStrengthLeaderBoardPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void verifyUIOnDeviceSignalStrengthPage()
	{
		if(leaderBoardTitleText.isDisplayed())
			utils.log().info("Title - " + leaderBoardTitleText.getText() + " - is displayed");
		else
			utils.log().info("Leader Board Title Text is not displayed");
		
		if(numberOfDevicesText.isDisplayed())
			utils.log().info("Number of Devices - " + numberOfDevicesText.getText() + " - is displayed");
		else
			utils.log().info("Number of Devices is not displayed");
		
		if(topFiveOnlineDevices.isDisplayed())
			utils.log().info(topFiveOnlineDevices.getText() + " - text is displayed");
		else
			utils.log().info("Top five Online Devices text is not displayed");
		
		if(sortDevicesOnSignalStrength.isDisplayed())
			utils.log().info("Sorting based on Device Signal Strength - " + sortDevicesOnSignalStrength.getText() + " - is displayed");
		else
			utils.log().info("Sorting based on device signal strength is not displayed");
		
		if(mobileDeviceImage.isDisplayed())
			utils.log().info("Mobile Device image is displayed");
		else
			utils.log().info("Mobile Device image is not displayed");
		
		if(mobileDeviceName.isDisplayed())
			utils.log().info("Mobile Device Name - " + mobileDeviceName.getText() + " - is displayed");
		else
			utils.log().info("Mobile Device Name is not displayed");
		
		if(signalStrength.isDisplayed())
			utils.log().info("Mobile Device Signal Strength - " + signalStrength.getText() + " - is displayed");
		else
			utils.log().info("Mobile Device Signal Strength is not displayed");
		
		if(uploadSpeed.isDisplayed())
			utils.log().info("Upload Speed - " + uploadSpeed.getText() + " - is displayed");
		else
			utils.log().info("Upload Speed is not displayed");
		
		if(downloadSpeed.isDisplayed())
			utils.log().info("Download Speed - " + downloadSpeed.getText() + " - is displayed");
		else
			utils.log().info("Download Speed is not displayed");
	}
	
	public void clickHomeButton()
	{
		click(homeButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
