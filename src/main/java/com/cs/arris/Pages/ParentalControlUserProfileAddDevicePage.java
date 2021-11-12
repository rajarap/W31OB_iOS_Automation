package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParentalControlUserProfileAddDevicePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public List<String> deviceList = new ArrayList<String>();
	public int deviceListSize;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	public MobileElement addDeviceTitle; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/img_edit_profile_name") 
	public MobileElement userProfileEditIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
		@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon;
	
	@AndroidBy (id = "com.arris.sbcBeta:id/add_connected_devices") 
	public MobileElement addDeviceButton;
	
	public ParentalControlAddDeviceHelpPage getParentalAddDeviceHelpPageObject(){
		ParentalControlAddDeviceHelpPage addDeviceHelpPage = new ParentalControlAddDeviceHelpPage();
		return addDeviceHelpPage;
	}
	
	public ParentalControlUserProfileAddDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton() {
		try {
			if (backButton.isDisplayed())
				click(backButton);
			utils.log().info("Clicked on Back Button");
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}

	public void clickHelpIcon() {
		try {
			if (helpIcon.isDisplayed())
				click(helpIcon);
			utils.log().info("Clicked on Help Icon");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}
	}
	
	public void clickAddDeviceButton()
	{
		try {
			click(addDeviceButton); // Goes back to user profile page.
			utils.log().info("Clicked on Add Device Button");
		} catch (Exception e) {
			utils.log().info("Add Device button is not displayed");
		}
	}
	
	//Add device page should not list the device already associated to the user
	public void verifyDeviceCountAfterAssociatingToUser()
	{
		int deviceListSizeBeforeAssociation = deviceListSize;
		int deviceListSizeAfterAssociation = super.deviceNames.size();
		int result = deviceListSizeBeforeAssociation - deviceListSizeAfterAssociation;
		//utils.log().info("Number of Devices associated to the user is " + result);
	}
	
	// To verify the devices listed in Add Device Page
	public void verifyandSelectDevice(String dname) {
		int counter = 1;
		String devName;
		utils.log().info("************************************************");
		utils.log().info("Details of Devices Listed in the Add Device Page");
		utils.log().info("************************************************");

		deviceListSize = super.deviceNames.size();
		
		for (int i = 1; i <= 2; i++) {
			utils.log().info("Device : " + counter);
			utils.log().info("--------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");
			
			for (MobileElement e : entity) {
				try {
					if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']").isDisplayed())
						utils.log().info("Device Image is displayed");
				} catch (Exception exp) {
					utils.log().info("Device Image is not available : ");
				}

				try {
					if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
						utils.log().info("Device name " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText());
//						devName = e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText();
//						if(!devName.contains("(me)"))
//						{
//							utils.log().info("Device Name: " + devName);
//							deviceList.add(devName);
//						}else {
//							utils.log().info("Current device name " + devName + " is listed in the Add Device screen ");
//						}
				} catch (Exception exp) {
					utils.log().info("Device Name is not available ");
				}

				try {
					if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed())
						utils.log().info("Check box is displayed ");
//					if(deviceList.get(i).equals(dname))
//					{
//						click(e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']"));
//						utils.log().info("Selected device " + deviceList.get(i) + "for which the internet will be paused");
//					else 
	//					utils.log().info("Device Name did not match the device name in the list ");
				} catch (Exception exp) {
					utils.log().info("Check box is not available ");
				}

				utils.log().info("****************************************************");
				utils.log().info("                                                    ");
				counter++;
			}
			if (i >= 8)
				new SwipeActions().swipeScreen(Direction.UP);
		}
	}
	 
//	//Verify if the current device name is listed. current device should not be listed.    
//	public void verifyCurrentDeviceIsNotListed()
//	{
//		String me;
//		try
//		{
//			for (int i = 0 ; i < deviceList.size(); i++)
//			{
//				if(deviceList.get(i).contains("(me)"))
//				{
//					me = deviceList.get(i);
//					utils.log().info("Current device name "+ me +" is listed in the Add Device screen ");
//				}else
//				{
//					utils.log().info("Devices displayed in the Add Device screen does not contain the current device *(me)");
//				}
//			}
//		}catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public void verifyUIOnAddDevicePage()
	{
		utils.log().info("*************************************************");
		utils.log().info(" Parental Control  -  Add Device Page            ");
		utils.log().info("*************************************************");
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info("Title - " + addDeviceTitle.getText() + " - is displayed");
		} catch (Exception e) {
			utils.log().info("Add Device Text is not displayed");
		}

		try {
			if (backButton.isDisplayed())
				utils.log().info("Back Button is displayed");
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}

		try {
			if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Cloud Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}
		
		try {
			if (addDeviceButton.isDisplayed())
				utils.log().info("Add Device button is displayed");
		} catch (Exception e) {
			utils.log().info("Add Device button is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if(addDeviceTitle.isDisplayed())
		{
			utils.log().info("On Add Device Page");
			return true;}
		else {
			utils.log().info("Not on Add Device Page");
		return false;}
	}
	
}

