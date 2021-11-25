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
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/add_connected_devices") 
	public MobileElement addDeviceButton;
	
	
	//Click Add Device Button without selecting any devices
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog")
	public MobileElement alertTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description")
	public MobileElement description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement closeIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement okButton;

	//Click Add Device Button without selecting any devices
	
	public ParentalControlAddDeviceHelpPage getParentalAddDeviceHelpPageObject(){
		ParentalControlAddDeviceHelpPage addDeviceHelpPage = new ParentalControlAddDeviceHelpPage();
		return addDeviceHelpPage;
	}
	
	public ParentalControlUserProfileAddDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
				click(backButton);
				utils.log().info("Clicked on Back Button");
				return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
			return true;
		} else {
			utils.log().info("Help Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickAddDeviceButton()
	{
		if(addDeviceButton.isDisplayed()) {
			click(addDeviceButton); 
			utils.log().info("Clicked on Add Device Button");
			return true;
		} else {
			utils.log().info("Add Device button is not displayed");
			return false;
		}
	}
	
	public boolean clickOKButtonOnAlertDialog()	{
		if(okButton.isDisplayed()) {
			click(okButton); 
			utils.log().info("Clicked OK button on Alert Dialog");
			return true;
		} else {
			utils.log().info("Alert dialog did not appear");
			return false;
		}
	}
	
	public boolean clickCloseButtonOnAlertDialog()	{
		if(closeIcon.isDisplayed()) {
			click(closeIcon); 
			utils.log().info("Clicked Close button on Alert Dialog");
			return true;
		} else {
			utils.log().info("Alert dialog did not appear");
			return false;
		}
	}
	
	// Add device page should not list the device already associated to the user
//	public boolean verifyDeviceCountAfterAssociatingToUser() {
//		try {
//			int deviceListSizeBeforeAssociation = deviceListSize;
//			int deviceListSizeAfterAssociation = super.deviceNames.size();
//			int result = deviceListSizeBeforeAssociation - deviceListSizeAfterAssociation;
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//		// utils.log().info("Number of Devices associated to the user is " + result);
//	}
	
	// To verify the devices listed in Add Device Page
	public boolean verifyDevices() {

		utils.log().info("*************************************");
		utils.log().info("Devices Listed in the Add Device Page");
		utils.log().info("*************************************");

		//utils.log().info("Number of Devices listed in the Add Device page is  : " + super.devicesConnectedToRouter);

		try {
			for (int i = 1; i <= 4; i++) {
				utils.log().info("Device : " + i);
				utils.log().info("--------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");

				for (MobileElement e : entity) {
					if (e.findElementByXPath(
							"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']").isDisplayed())
						utils.log().info("Device Image is displayed");
					else
						utils.log().info("Device Image is not available : ");

					if (e.findElementByXPath(
							"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
						utils.log().info("Device name : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText());
					else
						utils.log().info("Device Name is not available ");

					if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed())
						utils.log().info("Check box is displayed ");
					else
						utils.log().info("Check box is not available ");
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 8)
					new SwipeActions().swipeScreen(Direction.UP);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean selectADeviceForUserProfile() {

		utils.log().info("*******************************************");
		utils.log().info("Devices Added to the Selected User Profile ");
		utils.log().info("*******************************************");

		//utils.log().info("Number of Devices listed in the Add Device page is  : " + super.devicesConnectedToRouter);

			try {
				for (int i = 2; i <= 2; i++) {
					utils.log().info("Device : " + i);
					utils.log().info("--------------------");

					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
							+ "]");

					for (MobileElement e : entity) {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_image']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");
						else
							utils.log().info("Device Image is not available : ");

						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
							utils.log()
								.info("Device name : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getText());
						else
							utils.log().info("Device Name is not available ");

						if (e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']").isDisplayed()) {
							click(e.findElementByXPath("//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/device_select']"));
							utils.log().info("Clicked the check box to select the device for the user ");}
						else
							utils.log().info("Check box is not available ");
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
				}
				return true;
			} catch (Exception e) {
				return false;}
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
	
	public boolean verifyUIOnAddDevicePage() {
		utils.log().info("***************************************");
		utils.log().info(" Parental Control  -  Add Device Page  ");
		utils.log().info("***************************************");
		
		try {
			if (addDeviceTitle.isDisplayed())
				utils.log().info("Title - " + addDeviceTitle.getText() + " - is displayed");
			else
				utils.log().info("Add Device Text is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back Button is displayed");
			else
				utils.log().info("Back Button is not displayed");

			if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
			else
				utils.log().info("Cloud Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (addDeviceButton.isDisplayed())
				utils.log().info("Add Device button is displayed");
			else
				utils.log().info("Add Device button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(addDeviceTitle.isDisplayed()){
			utils.log().info("On Add Device Page");
			return true;
		}else {
			utils.log().info("Not on Add Device Page");
		return false;}
	}
	
}

