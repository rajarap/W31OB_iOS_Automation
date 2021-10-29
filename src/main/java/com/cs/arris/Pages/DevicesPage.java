package com.cs.arris.Pages;

import java.util.List;

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
	public int count;
	public int offlineDevices;
	public int onlineDevices;
	
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
	
	public int getCount() {
		return count;
	}

	public MobileElement getDeviceTitle() {
		return deviceTitle;
	}

	public MobileElement getCloudIcon() {
		return cloudIcon;
	}

	public MobileElement getOnlineButton() {
		return onlineButton;
	}

	public MobileElement getOfflineButton() {
		return offlineButton;
	}

	public MobileElement getBackButton() {
		return backButton;
	}

	public MobileElement getHelpIcon() {
		return helpIcon;
	}

	public MobileElement getMainDeviceName() {
		return mainDeviceName;
	}

	public MobileElement getListOfDevicesConnected() {
		return listOfDevicesConnected;
	}

	public MobileElement getDeviceImage() {
		return deviceImage;
	}

	public MobileElement getDeviceName2() {
		return deviceName;
	}

	public MobileElement getDeviceSignalStrength() {
		return deviceSignalStrength;
	}

	public MobileElement getDeviceDownloadSpeed() {
		return deviceDownloadSpeed;
	}

	public MobileElement getDeviceUploadSpeed() {
		return deviceUploadSpeed;
	}

	public MobileElement getIpAddressLabel() {
		return ipAddressLabel;
	}

	public MobileElement getDeviceIPAddress() {
		return deviceIPAddress;
	}

	public MobileElement getMacAddressLabel() {
		return macAddressLabel;
	}

	public MobileElement getDeviceMACAddress() {
		return deviceMACAddress;
	}

	public MobileElement getChannelLabel() {
		return channelLabel;
	}

	public MobileElement getDeviceChannelNumber() {
		return deviceChannelNumber;
	}

	public MobileElement getStatusLabel() {
		return statusLabel;
	}

	public MobileElement getDeviceStatus() {
		return deviceStatus;
	}

	public MobileElement getRssiLabel() {
		return rssiLabel;
	}

	public MobileElement getDeviceRSSIText() {
		return deviceRSSIText;
	}
	
	public void getTotalCountOfDevices()
	{
		String noOfDevices = deviceTitle.getText();  //Devices (2)
		count = getCountOfDevices(noOfDevices);
		utils.log().info("Number of Devices connected to the main mAX Router is : " + count);
	}
	
	//To verify if the number of devices listed are equal to the count of devices displayed in the home page and the number of online and offline devices
	public void verifyCountOfDeviceList()
	{
		//get device count displayed in home page
		getTotalCountOfDevices();
		
		if (onlineButton.isDisplayed() && onlineButton.isEnabled() && onlineButton.isSelected())
		{
			List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom");
			//List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			int size = deviceList.size();
			if (size == count)
			{
				onlineDevices = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently online");
			}else if(size < count)
			{
				offlineDevices = count - size;  //5-4 = 1  4-online and 1-offline
				onlineDevices = size;
				utils.log().info("Number of Devices currently online are : " + onlineDevices);
				utils.log().info("Number of Devices currently offline are : " + offlineDevices);
			}
		}
		else
		{
			click(onlineButton);
		}		
	}
	
	public void getOnlineDevicesCount()
	{
		//get device count displayed in home page
		getTotalCountOfDevices();
		
		if (onlineButton.isDisplayed() && onlineButton.isEnabled() && onlineButton.isSelected())
		{
			List<MobileElement> onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom");
			//List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			int size = onlineDeviceList.size();
			if (size == count)
			{
				onlineDevices = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently online");
			}else if(size < count)
			{
				offlineDevices = count - size;  //5-4 = 1  4-online and 1-offline
				onlineDevices = size;
				utils.log().info("Number of Devices currently online are : " + onlineDevices);
				utils.log().info("Number of Devices currently offline are : " + offlineDevices);
			}
		}
		else
		{
			click(onlineButton);
			
			List<MobileElement> onlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom");
			//List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			int size = onlineDeviceList.size();
			if (size == count)
			{
				onlineDevices = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently online");
			}else if(size < count)
			{
				offlineDevices = count - size;  //5-4 = 1  4-online and 1-offline
				onlineDevices = size;
				utils.log().info("Number of Devices currently online are : " + onlineDevices);
				utils.log().info("Number of Devices currently offline are : " + offlineDevices);
			}
		}		
	}
	
	public void getOfflineDevicesCount()
	{
		//get device count displayed in home page
		getTotalCountOfDevices();
		
		if (offlineButton.isDisplayed() && offlineButton.isEnabled() && offlineButton.isSelected())
		{
			List<MobileElement> offlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom");
			//List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			int size = offlineDeviceList.size();
			if (size == count)
			{
				offlineDevices = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently offline");
			}else if(size < count)
			{
				offlineDevices = count - size;  //5-4 = 1  4-online and 1-offline
				onlineDevices = size;
				utils.log().info("Number of Devices currently offline are : " + offlineDevices);
				utils.log().info("Number of Devices currently online are : " + onlineDevices);
			}
		}
		else
		{
			click(offlineButton);
			
			List<MobileElement> offlineDeviceList = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=com.arris.sbcBeta:id/recycleViewDiningRoom");
			//List<MobileElement> deviceList = (List<MobileElement>) super.getDriver().findElementsByClassName("androidx.recyclerview.widget.RecyclerView");
			int size = offlineDeviceList.size();
			if (size == count)
			{
				offlineDevices = size;
				utils.log().info("Number of Devices listed in the Devices page is equal to the count of devices displayed in the homepage");
				utils.log().info("All the Devices listed in the Devices page are currently offline");
			}else if(size < count)
			{
				offlineDevices = count - size;  //5-4 = 1  4-online and 1-offline
				onlineDevices = size;
				utils.log().info("Number of Devices currently offline are : " + offlineDevices);
				utils.log().info("Number of Devices currently online are : " + onlineDevices);
			}
		}		
	}
	
	//To verify the details of online devices
	public void verifyOnlineDeviceDetails()
	{
		getOnlineDevicesCount();
				
		utils.log().info("Detatils of Online Devices Connected to Main Device");
		utils.log().info("****************************************************");
				
		for (int i = 1; i <= onlineDevices ; i++)
		{
			List<MobileElement> deviceDetails = listOfDevicesConnected.findElementsByXPath("//android.view.ViewGroup["+i+"][@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']");
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgDevice") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtDeviceName") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Name : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainSignalStrength") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Signal Strength: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgAllDeviceExpand") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Expand image is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainDownloadSpeed") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Download Speed : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainUpLoadSpeed") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Upload Speed : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_ip_address") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("IP Address Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtIpAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("IP address of the device : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/macAddressTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address Title: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_channel") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Channel Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtChannelValue") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Channel Number : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/statusTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status Label: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/rssiTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("RSSI Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtRssi") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("RSSI : " + deviceDetails.get(i).getText() + " - is displayed");
			}
		}
	}
	
	//To verify the details of offline devices
	public void verifyOfflineDeviceDetails()
	{
		//get the number of devices currently offline
		getOfflineDevicesCount();
				
		utils.log().info("List of Offline Devices Connected to Main Device");
		utils.log().info("*************************************************");
				
		for (int i = 1; i <= count ; i++)
		{
			List<MobileElement> deviceDetails = listOfDevicesConnected.findElementsByXPath("//android.view.ViewGroup["+i+"][@resouce-d='com.arris.sbcBeta:id/setBackgroundForFreezingList']");
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgDevice") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtDeviceName") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Name : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainSignalStrength") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Device Signal Strength: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/imgAllDeviceExpand") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Expand image is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainDownloadSpeed") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Download Speed : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMainUpLoadSpeed") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Upload Speed : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_ip_address") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("IP Address Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtIpAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("IP address of the device : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/macAddressTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address Title: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtMacAddress") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("MAC Address : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txt_channel") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Channel Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtChannelValue") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Channel Number : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/statusTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtStatus") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("Status Label: " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/rssiTitle") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("RSSI Label : " + deviceDetails.get(i).getText() + " - is displayed");
			}
			
			if (deviceDetails.get(i).getAttribute("id").equalsIgnoreCase("com.arris.sbcBeta:id/txtRssi") && deviceDetails.get(i).isDisplayed())
			{
				utils.log().info("RSSI : " + deviceDetails.get(i).getText() + " - is displayed");
			}
		}
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
		click(homeButton);
		utils.log().info("Devices Page - Clicked on Home Button");
	}
	
	public void clickNetworkButton()
	{
		click(networkButton);
		utils.log().info("Devices Page - Clicked on Network Button");
	}
	
	public void clickParentalButton()
	{
		click(parentalButton);
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
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
}
