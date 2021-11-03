package com.cs.arris.Pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DeviceSignalStrengthLeaderBoardPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public List<MobileElement> listOfDevices;
	public int counter = 1;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/txtHeader"),  //DEVICE SIGNAL STRENGTH LEADER BOARD
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[101,311][854,380]']"),
	})
	public MobileElement leaderBoardTitleText; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtTotalDevices"),  
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[101,397][325,471]']"),
	})
	public MobileElement numberOfDevicesText; 
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/txtThree"),
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[101,514][451,567]']")
	})
	public MobileElement topFiveOnlineDevices; 
	

	//@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='SBC Test']/android.view.ViewGroup/android.widget.Spinner/android.widget.TextView")  //strong to weak
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.view.ViewGroup[@content-desc='SBC Test']/android.view.ViewGroup/android.widget.Spinner/android.widget.TextView"),
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
	})
	public MobileElement signalStrengthOptions;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"),
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[526,579][979,647]']")
	})
	public MobileElement strongToWeak; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"),
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[526,647][979,715]']")
	})
	public MobileElement weakToStrong; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']"),  //Galaxy-S10-Android (me)
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceName") 
	})
	public MobileElement mobileDeviceName; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']"),  //5GHz
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainSignalStrength") 
	})
	public MobileElement signalStrength; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainDownloadSpeed") 
	})
	public MobileElement downloadSpeed; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']"), 
		@AndroidBy (id = "com.arris.sbcBeta:id/txtMainUpLoadSpeed") 
	})
	public MobileElement uploadSpeed; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/imgDevice") 
	})
	public MobileElement mobileDeviceImage; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/rcyclrDevices']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/rcyclrDevices") 
	})
	public MobileElement recyclerView; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgCloseIcon']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/imgCloseIcon") 
	})
	public MobileElement closeIcon;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']"),  
		@AndroidBy (id = "com.arris.sbcBeta:id/setBackgroundForFreezingList") 
	})
	public MobileElement deviceEntry1; 
	
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
		
		if(signalStrengthOptions.isDisplayed())
			utils.log().info("Sorting based on Device Signal Strength is displayed");
		else
			utils.log().info("Sorting based on device signal strength is not displayed");
		
//		if(mobileDeviceImage.isDisplayed())
//			utils.log().info("Mobile Device image is displayed");
//		else
//			utils.log().info("Mobile Device image is not displayed");
//		
//		if(mobileDeviceName.isDisplayed())
//			utils.log().info("Mobile Device Name - " + mobileDeviceName.getText() + " - is displayed");
//		else
//			utils.log().info("Mobile Device Name is not displayed");
//		
//		if(signalStrength.isDisplayed())
//			utils.log().info("Mobile Device Signal Strength - " + signalStrength.getText() + " - is displayed");
//		else
//			utils.log().info("Mobile Device Signal Strength is not displayed");
//		
//		if(uploadSpeed.isDisplayed())
//			utils.log().info("Upload Speed - " + uploadSpeed.getText() + " - is displayed");
//		else
//			utils.log().info("Upload Speed is not displayed");
//		
//		if(downloadSpeed.isDisplayed())
//			utils.log().info("Download Speed - " + downloadSpeed.getText() + " - is displayed");
//		else
//			utils.log().info("Download Speed is not displayed");
	}
	
	public void clickCloseIcon()
	{
		click(closeIcon);
		utils.log().info("Device Signal Strength Leader Board - Clicked on Close Icon");
	}
	
	public void clickEditDeviceName()
	{
		click(mobileDeviceName);
		utils.log().info("Device Signal Strength Leader Board - Clicked on Device Name Text");
	}
	
	public HomePage getHomePageObject()
	{
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	public EditDeviceNameDialog getEditDeviceNameDialogObject()
	{
		EditDeviceNameDialog editDeviceNameDialog = new EditDeviceNameDialog();
		return editDeviceNameDialog;
	}
	
	 public NetworkPage getNetworkPageObject() {
		 NetworkPage networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public ParentalControlPage getParentalControlPageObject() {
		 ParentalControlPage parentalControlPage = new ParentalControlPage();
	     return parentalControlPage;
	  }

	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public void verifySignalStrengthForDevices()
	 {	
		listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath("//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
		int size = listOfDevices.size();
		utils.log().info("Verifying Signal Strength for " + size + " devices");
		
		for(MobileElement e : listOfDevices)
		{
			utils.log().info("Device : " + counter);
			utils.log().info("--------------");

			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']").isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			utils.log().info("Device Name            : " + e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
			utils.log().info("Device Signal Strength : " + e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
			utils.log().info("Device Download Speed  : " + e.findElementById("com.arris.sbcBeta:id/txtMainDownloadSpeed").getText());
			utils.log().info("Device Upload Speed    : " + e.findElementById("com.arris.sbcBeta:id/txtMainUpLoadSpeed").getText());
			utils.log().info("RSSI Label             : " + e.findElementById("com.arris.sbcBeta:id/txtStatusTitle").getText());
			utils.log().info("RSSI Value             : " + e.findElementById("com.arris.sbcBeta:id/txtStatus").getText());
			counter++;
		}
	 }
	 
	
	 public void sortStrongToWeak()
	 {
		 click(signalStrengthOptions);
		 click(strongToWeak);		 		 
		 listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath("//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
		 int size = listOfDevices.size();
		 utils.log().info("Verifying Signal Strength for " + size + " devices");
		 counter = 1;
		 Integer[] originalSignalStrength;
		 Integer[] decendingSignalStrength;
		 int i = 0;
		
		 	originalSignalStrength = new Integer[size];
		 	decendingSignalStrength = new Integer[size];
		 	
		 	for(MobileElement e : listOfDevices)
		 	{
				originalSignalStrength[i] = convertSignalStrengthToInteger(e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}
		 	
		 	decendingSignalStrength = sortArrayDecending(originalSignalStrength);
		 	if (Arrays.equals(originalSignalStrength, decendingSignalStrength))
		 	{
		 		utils.log().info("Signal Strength option selected is - Strong to Weak");
		 		utils.log().info("The devices are displayed from Strongest to Weakest signal strength order");
		 	}
		 	else
		 	{
		 		utils.log().info("Signal Strength option selected is - Strong to Weak");
		 		utils.log().info("The devices are not displayed from Strongest to Weakest signal strength order");
		 	}
	 }
	 
	 public void sortWeakToStrong()
	 {
		 click(signalStrengthOptions);
		 click(weakToStrong);
		 listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath("//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
		 int size = listOfDevices.size();
		 utils.log().info("Verifying Signal Strength for " + size + " devices");
		 counter = 1;
		 Integer[] originalSignalStrength;
		 Integer[] ascendingSignalStrength;
		 int i = 0;
		 	
		 	originalSignalStrength = new Integer[size];
		 	ascendingSignalStrength = new Integer[size];

		 	for(MobileElement e : listOfDevices)
		 	{
				originalSignalStrength[i] = convertSignalStrengthToInteger(e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}
		 	
		 	ascendingSignalStrength = sortArrayAscending(originalSignalStrength);
		 	if (Arrays.equals(originalSignalStrength, ascendingSignalStrength))
		 	{
		 		utils.log().info("Signal Strength option selected is - Weak to Strong");
		 		utils.log().info("The devices are displayed from Weakest to Strongest signal strength order");
		 	}
		 	else
		 	{
		 		utils.log().info("Signal Strength option selected is - Weak to Strong");
		 		utils.log().info("The devices are not displayed from Weakest to Strongest signal strength order");
		 	}
	 }
	 
	 private Integer convertSignalStrengthToInteger(String ghz)  //5GHz
	 {
		 String i = ghz.substring(0, 1);
		 return Integer.valueOf(i);
	 }
	 
	 private Integer[] sortArrayDecending(Integer ss[])
	 {
		 Arrays.sort(ss, Collections.reverseOrder());
		 return ss;
	 }
	 
	 private Integer[] sortArrayAscending(Integer ss[])
	 {
		 Arrays.sort(ss);
		 return ss;
	 }
	
	@Override
	public boolean isAt() {
		if(leaderBoardTitleText.isDisplayed())
		{
			utils.log().info("On Device Signal Strength Leader Board Page");
			return true;}
		else {
			utils.log().info("Not on Device Signal Strength Leader Board Page");
		return false;}
	}

}
