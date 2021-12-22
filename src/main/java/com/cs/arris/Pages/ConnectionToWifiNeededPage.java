package com.cs.arris.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConnectionToWifiNeededPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public String ssid;
	public String pwd;
	public String udid;
	
//	@AndroidFindAll({
//		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnRetry']"),  //CONTINUE
//		@AndroidBy (xpath = "//android.widget.Button[@bounds='[122,1953][958,2042]']"),
//		@AndroidBy (id = "com.arris.sbcBeta:id/btnRetry") 
//	})
//	public MobileElement continueButton; 
//	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_congratulations") 
//	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_congratulations']") // text = CONNECTION NEEDED
//	public MobileElement connectToWifiText;
//	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_f_connect_internet_desc") 
//	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_f_connect_internet_desc']") // text = To continue with the install please connect to (arrisw311) through your Mobile Device Wi-Fi settings.
//	public MobileElement connectRouterToWifiText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Join\"]")
	public MobileElement joinButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
	public MobileElement cancelButton;
	
	public ConnectionToWifiNeededPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
//	public void turnOnRouterWifi(String ssid, String pwd, String udid)
//	{
//		super.pause(3);
//		this.ssid = ssid;
//		this.pwd = pwd;
//		this.udid = udid;
//		utils.log().info("Running App in the Background");
//	   super.getDriver().runAppInBackground(Duration.ofSeconds(10));
//       try 
//       {
//    	   utils.log().info("Running adb shell to login to mAX " + this.ssid + " network");
//    	   ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", this.udid, "shell", "am", "start", "-n", "com.steinwurf.adbjoinwifi/.MainActivity", "-e", "ssid", this.ssid, "-e", "password_type", "WPA", "-e", "password", this.pwd);
//           Process pc1 = pb1.start();
//           super.pause(3);
//           ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", this.udid, "shell", "input", "keyevent", "3");
//           Process pc2 = pb2.start();
//       } catch (Exception e) 
//       {
//         e.printStackTrace();
//       }  
//       utils.log().info("Activating App running in Background");
//       super.pause(3);
//       super.getDriver().activateApp("com.arris.sbcBeta");
//	}
//	
//	public void isConnectedToRouterSSID()
//	{
//		
//	}
//	
//	public void clickContinue()
//	{
//		click(continueButton);
//		utils.log().info("Connection Needed Page - Clicked on Continue Button");
//	}
//	
	
	public void clickJoinButton()
	{
		click(joinButton);
		utils.log().info("Clicked on Join Button");
	}
	
	public void clickCancelButton()
	{
		click(cancelButton);
		utils.log().info("Clicked on Cancel Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
