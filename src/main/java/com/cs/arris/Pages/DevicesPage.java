package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DevicesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	HomePage homePage = new HomePage();
	public List<MobileElement> onlineDeviceList;
	public List<MobileElement> offlineDeviceList;
	public Integer deviceCount;
	public int offlineDeviceCount;
	public int onlineDeviceCount;
	public int counter = 1;
	
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"),  //Devices (2)
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[424,149][656,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement deviceTitle; 

	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[893,154][956,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOnline']"),  //Online
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[79,397][541,484]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonOnline") 
	})
	public MobileElement onlineButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOffline']"),  //Offline
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[539,397][1001,484]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonOffline") 
	})
	public MobileElement offlineButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ivDialogClose]"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[915,146][1046,241]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/ivDialogClose") 
	})
	public MobileElement closeButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtAllDeviceTitleOne']"),  //main device name
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[55,380][141,437]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtAllDeviceTitleOne") 
	})
	public MobileElement mainDeviceName;
	
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
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']"),  
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup"),
		@AndroidBy (id = "com.arris.sbcBeta:id/setBackgroundForFreezingList") 
	})
	public MobileElement firstFreezingItem; 
	
	@AndroidFindBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom")
	public MobileElement listOfDevicesConnected;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
	public MobileElement deviceImage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']")
	public MobileElement deviceName;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtMainSignalStrength")
	public MobileElement deviceSignalStrength;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']")
	public MobileElement deviceDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']")
	public MobileElement deviceUploadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']")
	public MobileElement expandButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_ip_address")
	public MobileElement ipAddressLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtIpAddress")
	public MobileElement deviceIPAddress;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/macAddressTitle")
	public MobileElement macAddressLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtMacAddress")
	public MobileElement deviceMACAddress;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txt_channel")
	public MobileElement channelLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtChannelValue")
	public MobileElement deviceChannelNumber;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/statusTitle")
	public MobileElement statusLabel;	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtStatus")
	public MobileElement deviceStatus;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/rssiTitle")
	public MobileElement rssiLabel;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtRssi")
	public MobileElement deviceRSSIText;
	
	public DevicesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public Integer getDeviceCount() {
		return deviceCount;
	}
	
	public int getOnlineDeviceCount()
	{
		this.getOnlineDevicesCount();
		return onlineDeviceCount;
	}
	
	public int getOfflineDeviceCount()
	{
		this.getOfflineDevicesCount();
		return offlineDeviceCount;
	}
	

	public String getDeviceTitleText() {
		return deviceTitle.getText();
	}

	public String getOnlineButtonText() {
		return onlineButton.getText();
	}

	public String getOfflineButton() {
		return offlineButton.getText();
	}

	public String getBackButton() {
		return backButton.getText();
	}

	public String getMainDeviceName() {
		return mainDeviceName.getText();
	}

	public MobileElement getListOfDevicesConnected() {
		return listOfDevicesConnected;
	}

	public String getListDeviceName() {
		return deviceName.getText();
	}

	public String getDeviceSignalStrengthText() {
		return deviceSignalStrength.getText();
	}

	public String getDeviceDownloadSpeedValue() {
		return deviceDownloadSpeed.getText();
	}

	public String getDeviceUploadSpeedValue() {
		return deviceUploadSpeed.getText();
	}

	public String getIpAddressLabelText() {
		return ipAddressLabel.getText();
	}

	public String getDeviceIPAddressValue() {
		return deviceIPAddress.getText();
	}

	public String getMacAddressLabelText() {
		return macAddressLabel.getText();
	}

	public String getDeviceMACAddressValue() {
		return deviceMACAddress.getText();
	}

	public String getChannelLabelText() {
		return channelLabel.getText();
	}

	public String getDeviceChannelNumber() {
		return deviceChannelNumber.getText();
	}

	public String getStatusLabelText() {
		return statusLabel.getText();
	}

	public String getDeviceStatus() {
		return deviceStatus.getText();
	}

	public String getRssiLabelText() {
		return rssiLabel.getText();
	}

	public String getDeviceRSSIValue() {
		return deviceRSSIText.getText();
	}
	
	public void getTotalCountOfDevices()
	{
		String noOfDevices = deviceTitle.getText();  //Devices(2)
		utils.log().info("Device Page Title : " + noOfDevices);
		deviceCount = getCountOfDevices(noOfDevices);
		utils.log().info("Number of Devices connected to the main mAX Router is : " + deviceCount.toString());
	}
	
	public void getOnlineDevicesCount()
	{	
		if (onlineButton.isDisplayed() && onlineButton.isSelected())
		{
			utils.log().info("Online Button is displayed and is selected");
			//onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView");
			//onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']");
			onlineDeviceList = (List<MobileElement>) super.getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']"));
			
			int size = onlineDeviceList.size();
			if (size == deviceCount)
			{
				onlineDeviceCount = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently online");
			}else if(size < deviceCount)
			{
				offlineDeviceCount = deviceCount - size;  //5-4 = 1  4-online and 1-offline
				onlineDeviceCount = size;
				utils.log().info("Number of Devices currently online are : " + onlineDeviceCount);
				utils.log().info("Number of Devices currently offline are : " + offlineDeviceCount);
			}
		}
		else
		{
			click(onlineButton);
			utils.log().info("Clicked on Online Button");
			//onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']");
			//onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView");
			onlineDeviceList = (List<MobileElement>) super.getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']"));
			
			int size = onlineDeviceList.size();
			if (size == deviceCount)
			{
				onlineDeviceCount = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently online");
			}else if(size < deviceCount)
			{
				offlineDeviceCount = deviceCount - size;  //5-4 = 1  4-online and 1-offline
				onlineDeviceCount = size;
				utils.log().info("Number of Devices currently online are : " + onlineDeviceCount);
				utils.log().info("Number of Devices currently offline are : " + offlineDeviceCount);
			}
		}		
	}
	
	public void getOfflineDevicesCount()
	{
		//get device count displayed in home page
		//getTotalCountOfDevices();
		
		if (offlineButton.isDisplayed() && offlineButton.isEnabled() && offlineButton.isSelected())
		{
			utils.log().info("Offline Button is displayed, enabled and selected");
			offlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView");

			int size = offlineDeviceList.size();
			if (size == deviceCount)
			{
				offlineDeviceCount = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently offline");
			}else if(size < deviceCount)
			{
				offlineDeviceCount = deviceCount - size;  //5-4 = 1  4-online and 1-offline
				onlineDeviceCount = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("Number of Devices currently offline are : " + offlineDeviceCount);
				utils.log().info("Number of Devices currently online are : " + onlineDeviceCount);
			}
		}
		else
		{
			click(offlineButton);
			utils.log().info("Clicked on Offline Button");
			List<MobileElement> offlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView");
			int size = offlineDeviceList.size();
			utils.log().info("No of offline devices : " + size);
			if (size == deviceCount)
			{
				offlineDeviceCount = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently offline");
			}else if(size < deviceCount)
			{
				offlineDeviceCount = deviceCount - size;  //5-4 = 1  4-online and 1-offline
				onlineDeviceCount = size;
				utils.log().info("Number of Devices currently offline are : " + offlineDeviceCount);
				utils.log().info("Number of Devices currently online are : " + onlineDeviceCount);
			}
		}		
	}
	
	//To verify the details of online devices
	public void verifyOnlineDeviceDetails()
	{		
		utils.log().info("Details of Online Devices Connected to Main Device");
		utils.log().info("****************************************************");
				
		for(MobileElement e : onlineDeviceList)
		{
			utils.log().info("Online Device : " + counter);
			utils.log().info("--------------------");
			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']").isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']").isDisplayed())
			{
				utils.log().info("Expand Button Image is displayed");
			}
			
			utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']").getText());
			utils.log().info("Device Signal Strength : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']").getText());
			click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));
			utils.log().info("Device Download Speed : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']").getText());
			utils.log().info("Device Upload Speed   : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']").getText());
			utils.log().info("Label                 : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']").getText());
			utils.log().info("Device IP Address     : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtIpAddress']").getText());
			utils.log().info("Label 			    : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/macAddressTitle']").getText());
			utils.log().info("Device MAC Address    : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMacAddress']").getText());
			utils.log().info("Label   				: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']").getText());
			utils.log().info("Device Channel Number : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelValue']").getText());
			utils.log().info("Label					: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/statusTitle']").getText());
			utils.log().info("Device Status			: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtStatus']").getText());
			utils.log().info("Label   				: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssiTitle']").getText());
			utils.log().info("RSSI Value            : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']").getText());
			click(e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgAllDeviceExpand']"));
			utils.log().info("Clicked Collapse Button image");
			counter++;
		}
	}

	
	//To verify the details of offline devices
	public void verifyOfflineDeviceDetails()
	{
		//get the number of devices currently offline
		//getOfflineDevicesCount();
				
		utils.log().info("List of Offline Devices Connected to Main Device");
		utils.log().info("*************************************************");
				
		for (int i = 1; i <= offlineDeviceCount ; i++)
		{
			MobileElement deviceDetails = (MobileElement) super.getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.view.ViewGroup");
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgDevice") && deviceDetails.isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtDeviceName") && deviceDetails.isDisplayed())
			{
				utils.log().info("Device Name : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainSignalStrength") && deviceDetails.isDisplayed())
			{
				utils.log().info("Device Signal Strength: " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgAllDeviceExpand") && deviceDetails.isDisplayed())
			{
				utils.log().info("Expand image is displayed");
				clickPlusButton();
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainDownloadSpeed") && deviceDetails.isDisplayed())
			{
				utils.log().info("Download Speed : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainUpLoadSpeed") && deviceDetails.isDisplayed())
			{
				utils.log().info("Upload Speed : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_ip_address") && deviceDetails.isDisplayed())
			{
				utils.log().info("IP Address Label : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtIpAddress") && deviceDetails.isDisplayed())
			{
				utils.log().info("IP address of the device : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/macAddressTitle") && deviceDetails.isDisplayed())
			{
				utils.log().info("MAC Address Title: " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.isDisplayed())
			{
				utils.log().info("MAC Address Label : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.isDisplayed())
			{
				utils.log().info("MAC Address : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_channel") && deviceDetails.isDisplayed())
			{
				utils.log().info("Channel Label : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtChannelValue") && deviceDetails.isDisplayed())
			{
				utils.log().info("Channel Number : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/statusTitle") && deviceDetails.isDisplayed())
			{
				utils.log().info("Status Label : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.isDisplayed())
			{
				utils.log().info("Status : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.isDisplayed())
			{
				utils.log().info("Status Label: " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/rssiTitle") && deviceDetails.isDisplayed())
			{
				utils.log().info("RSSI Label : " + deviceDetails.getText() + " - is displayed");
			}
			
			if (deviceDetails.getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtRssi") && deviceDetails.isDisplayed())
			{
				utils.log().info("RSSI : " + deviceDetails.getText() + " - is displayed");
				clickMinusButton();
			}
		}
	}
	
	//Verify if all the required UI elements are displayed on the Home Page
		public void verifyUIOnDevicesPage()
		{
			if(deviceTitle.isDisplayed())
				utils.log().info("Device Title is displayed");
			else
				utils.log().info("Device Title - " + deviceTitle.getText() + " - is not displayed");
			
			if(backButton.isDisplayed())
				utils.log().info("Back Icon is displayed");
			else
				utils.log().info("Back Icon is displayed");
			
			if(helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is displayed");
			
			if(onlineButton.isDisplayed())
				utils.log().info("Online Tab is displayed");
			else
				utils.log().info("Online Tab is not displayed");
			
			if(offlineButton.isDisplayed())
				utils.log().info("Offline Tab is displayed");
			else
				utils.log().info("Offline Tab is not displayed");
			
			if(mainDeviceName.isDisplayed())
				utils.log().info("Main Device name - " + mainDeviceName.getText() + " - is displayed");
			else
				utils.log().info("Main Device name is not displayed");
		}
	
	
	public void clickOnlineTab()
	{
		click(onlineButton);
		utils.log().info("Devices Page - Clicked on Online Tab");
	}
	
	public void clickOfflineTab()
	{
		click(offlineButton);
		utils.log().info("Devices Page - Clicked on Offile Tab");
	}
	
	public void clickPlusButton()
	{
		click(expandButton);
		utils.log().info("Devices Page - Clicked on Expand Button");
	}
	
	public void clickMinusButton()
	{
		click(expandButton);
		utils.log().info("Devices Page - Clicked on Collapse Button");
	}
	
	public void clickBackButton()
	{
		click(backButton);
		utils.log().info("Devices Page - Clicked on Back Button");
	}
	
	public void clickHomeButton()
	{
		homePage.getFooterIconsPageObject().clickHomeButton();
		utils.log().info("Devices Page - Clicked on Home Button");
	}
	
	public void clickNetworkButton()
	{
		homePage.getFooterIconsPageObject().clickNetworkButton();
		utils.log().info("Devices Page - Clicked on Network Button");
	}
	
	public void clickParentalButton()
	{
		homePage.getFooterIconsPageObject().clickParentalButton();
		utils.log().info("Devices Page - Clicked on Parental Button");
	}
	
	public void clickHelpButton()
	{
		click(helpIcon);
		utils.log().info("Devices Page - Clicked on Help Button");
	}
	
	public void clickCloseButton()
	{
		click(closeButton);
		utils.log().info("Devices Help Page - Clicked on Close Button");
	}
	
	public HomePage getHomePageObject()
	{
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	 public NetworkPage getNetworkPageObject() {
		 NetworkPage networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public ParentalControlPage getParentalControlPageObject() {
		 ParentalControlPage parentalControlPage = new ParentalControlPage();
	     return parentalControlPage;
	  }
	
	public DevicesHelpPage getDevicesHelpPageObject()
	{
		DevicesHelpPage devicesHelpPage = new  DevicesHelpPage();
		return devicesHelpPage;
	}
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	
	@Override
	public boolean isAt() {
		if(deviceTitle.isDisplayed())
		{
			utils.log().info("On Devices Page");
			return true;}
		else {
			utils.log().info("Not on Devices Page");
		return false;}
	}
}
