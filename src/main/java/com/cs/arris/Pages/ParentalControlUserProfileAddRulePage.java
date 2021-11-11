package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

public class ParentalControlUserProfileAddRulePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public List<String> deviceList = new ArrayList<String>();
	public int deviceListSize;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	public MobileElement enableScheduleTimeTitle; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='No Active Time Rule Found']") 
	public MobileElement noActiveRuleFoundText; 
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Currently, you have not added any time schedules for this profile. Please tap on the \"Add Time Schedule\" button to set time schedule to block Internet access.']") 
	public MobileElement noActiveRuleFoundMessage; 
	
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
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/add_time_blocks']"),  //back button
		@AndroidBy (id = "com.arris.sbcBeta:id/add_time_blocks")
	})
	public MobileElement addScheduleButton; 
	
	public ParentalControlAddRuleHelpPage getParentalAddRuleHelpPageObject(){
		ParentalControlAddRuleHelpPage addDeviceHelpPage = new ParentalControlAddRuleHelpPage();
		return addDeviceHelpPage;
	}
	
	public ParentalControlAddRuleAddInternetBlockingScheduleDialog getInternetBlockingScheduleDialogObject(){
		ParentalControlAddRuleAddInternetBlockingScheduleDialog addinternetBlockingDialog = new ParentalControlAddRuleAddInternetBlockingScheduleDialog();
		return addinternetBlockingDialog;
	}
	
	
	public ParentalControlUserProfileAddRulePage()
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
	
	public void clickAddScheduleButton()
	{
		try {
			click(addScheduleButton); 
			utils.log().info("Clicked on Add Time Schedule Button");
		} catch (Exception e) {
			utils.log().info("Add Time Schedule button is not displayed");
		}
	}
	
	
	// To verify the devices listed in Add Device Page
	public void verifyUIonAddRuleEnableScheduleTimePage() {
		int counter = 1;
		String devName;
		utils.log().info("********************************************");
		utils.log().info("Add Rule - Details of Enabled Schedule Time");
		utils.log().info("********************************************");
		
		int scheduleList = super.getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/time_block_list_view']")).size();
		
		for (int i = 1; i < scheduleList; i++) {
			utils.log().info("Enable Schedule Time - Rule : " + counter);
			utils.log().info("-----------------------------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]");
			
			for (MobileElement e : entity) {
				if (e.findElement(By.id("com.arris.sbcBeta:id/cbSunday")).isDisplayed())
				{
					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
							utils.log().info("Schedule Time : " +  e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").getText());
					} catch (Exception exp) {
						utils.log().info("Schedule Time is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbSunday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbSunday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbMonday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbMonday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbTuesday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbWednesday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbThrusday").isDisplayed())
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbFriday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbFriday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementById("com.arris.sbcBeta:id/cbSaturday").isDisplayed())
							utils.log().info("DOW : " +  e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText());
					} catch (Exception exp) {
						utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText() + " is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
							utils.log().info("Time Block Toggle Button is currently disabled");
						else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
							utils.log().info("Time Block Toggle Button is currently enabled");
					} catch (Exception exp) {
						utils.log().info("STime Block Toggle Button is not displayed ");
					}
				}else
				{
					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
							utils.log().info("Schedule Time : " +  e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").getText());
					} catch (Exception exp) {
						utils.log().info("Schedule Time is not displayed ");
					}

					try {
						if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed())
							utils.log().info(e.findElementById("com.arris.sbcBeta:id/time_block_every_day").getText() + " button is displayed ");
					} catch (Exception exp) {
						utils.log().info("EVERY DAY button is not displayed ");
					}
					
					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
							utils.log().info("Time Block Toggle Button is currently disabled");
						else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
							utils.log().info("Time Block Toggle Button is currently enabled");
					} catch (Exception exp) {
						utils.log().info("STime Block Toggle Button is not displayed ");
					}
				}

				utils.log().info("****************************************************");
				utils.log().info("                                                    ");
				counter++;
			}
			if (i >= 6)
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
	
	@Override
	public boolean isAt() {
		if(enableScheduleTimeTitle.isDisplayed())
		{
			utils.log().info("On Add Rule - Enable Schedule Time Page");
			return true;}
		else {
			utils.log().info("Not on Add Rule - Enable Schedule Time Page");
		return false;}
	}
	
}

