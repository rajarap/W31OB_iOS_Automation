package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.SwipeOnElement;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlUserProfilePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
//	public SwipeOnElement swipe = new SwipeOnElement();
//	public SwipeActions swipe = new SwipeActions();
	public String username;
	public MobileElement me;
	public int counter = 1;
	int size;
	public int elementX;
	public int elementY;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfile\"]")
	public MobileElement userProfileTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement userProfileEditIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_Profile\"]")
	public MobileElement userProfilePic;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Parental_Control_Profiles_Screen_Image_Edit\"]")
	public MobileElement userProfilePicEditIcon;

	// Pause Profile
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_PauseProfile\"]")
	public MobileElement pauseProfileText;

	// Pause Internet access for current profile
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_PauseInfo\"]")
	public MobileElement pauseInternetForCurrentProfileText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Parental_Control_Profiles_Screen_Switch_PauseInternet\"]")
	public MobileElement pauseInternetToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_DeviceCount\"]")
	public MobileElement deviceCountPausedForProfile;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"+ Add Device\"]")
	public MobileElement addDeviceLink;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_Associated\"]")
	public MobileElement associatedDevicesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_ConnectedDevices\"]")
	public MobileElement totalDevicesAdded;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_DeviceExpand\"]")
	public MobileElement expandDeviceListButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement expandRuleListButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_RuleCounter\"]")
	public MobileElement ruleCountForProfile;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"+ Add Rule\"]")
	public MobileElement addRuleLink;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_AssociatedRules\"]")
	public MobileElement associatedRulesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_Total\"]")
	public MobileElement totalTimeActiveRule;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement enableTimeBlockToggleButton;

	
	//Delete User Profiles
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Delete\"]")
	public MobileElement userProfile;
	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
//	public MobileElement deleteDeviceLabel;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
//	public MobileElement deleteDeviceConfirmationText;
	
	//Delete User Profiles
	
	//Delete Associated Devices
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/delete")
	public MobileElement deleteDeviceIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public MobileElement deleteDeviceLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want delete this device from Profile? This action cannot be undone.']")
	public MobileElement deleteDeviceConfirmationText;
	
	//Delete Associated Devices
	
	
	//Delete Associated Rules
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/delete")
	public MobileElement deleteRuleIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public MobileElement deleteRuleLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want delete this time rule from Profile? This action can not be undone.']")
	public MobileElement deleteRuleConfirmationText;
	
	//Delete Associated Rules
	
	public ParentalControlUserProfilePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public AppRatingDialog getAppRatingDialogObject() {
		AppRatingDialog ratingDialog = new AppRatingDialog();
		return ratingDialog;
	}

	public ParentalControlEditUserProfileNameDialog getParentalEditUserProfileDialogObject() {
		ParentalControlEditUserProfileNameDialog editProfileNameDialog = new ParentalControlEditUserProfileNameDialog();
		return editProfileNameDialog;
	}

	public ParentalControlUserProfileAddDevicePage getParentalUserProfileAddDevicePageObject() {
		ParentalControlUserProfileAddDevicePage addDevicePage = new ParentalControlUserProfileAddDevicePage();
		return addDevicePage;
	}

	public ParentalControlUserProfileAddRulePage getParentalUserProfileAddRulePageObject() {
		ParentalControlUserProfileAddRulePage addRulePage = new ParentalControlUserProfileAddRulePage();
		return addRulePage;
	}

	public ParentalControlUserProfileHelpPage getParentalUserProfileHelpPageObject() {
		ParentalControlUserProfileHelpPage helpPage = new ParentalControlUserProfileHelpPage();
		return helpPage;
	}

	public boolean verifyUIOnUserProfilePage() {
		utils.log().info("                                      ");
		utils.log().info("**************************************");
		utils.log().info(" Parental Control  - User Profile Page");
		utils.log().info("**************************************");
		try {
			if (userProfileTitle.isDisplayed())
				utils.log().info("Title - " + userProfileTitle.getText() + " - is displayed");
			else
				utils.log().info("User Profile Name is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back Button is displayed");
			else
				utils.log().info("Back Button is not displayed");
			
			try {
			if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
			else
				utils.log().info("Cloud Icon is not displayed");
			}catch(Exception e) {utils.log().info("Cloud Icon is not displayed");}

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

//			if (userProfileEditIcon.isDisplayed())
//				utils.log().info("User Profile Edit Icon is displayed");
//			else
//				utils.log().info("User Profile Edit Icon is not displayed");

			if (userProfilePic.isDisplayed())
				utils.log().info("User Profile Pic is displayed");
			else
				utils.log().info("User Profile Pic is not displayed");

			if (userProfilePicEditIcon.isDisplayed())
				utils.log().info("User Profile Edit pic Icon is displayed");
			else
				utils.log().info("User Profile Edit pic Icon is not displayed");

			if (pauseProfileText.isDisplayed())
				utils.log().info(pauseProfileText.getText() + " text is displayed");
			else
				utils.log().info("Pause Profile text is not displayed");

			if (pauseInternetForCurrentProfileText.isDisplayed())
				utils.log().info(pauseInternetForCurrentProfileText.getText() + " text is displayed");
			else
				utils.log().info("Pause Internet Access for Current Profile text is not displayed");
			
			try {
				if (pauseInternetToggleButton.isDisplayed() && (!(pauseInternetToggleButton).isSelected()))
					utils.log().info("Pause Internet switch is displayed but is disabled");
			}catch(Exception e) {
					utils.log().info("Pause Internet switch is displayed and is enabled");}

			if (deviceCountPausedForProfile.isDisplayed())
				utils.log().info(deviceCountPausedForProfile.getText() + " text is displayed");
			else
				utils.log().info("Device Count for user profie is not displayed");

			if (addDeviceLink.isDisplayed())
				utils.log().info(addDeviceLink.getText() + " link is displayed");
			else
				utils.log().info("ADD DEVICE link is not displayed");

			if (associatedDevicesText.isDisplayed())
				utils.log().info(associatedDevicesText.getText() + " text is displayed");
			else
				utils.log().info("Associated Devices text is not displayed");

			if (totalDevicesAdded.isDisplayed())
				utils.log().info(totalDevicesAdded.getText() + " text is displayed");
			else
				utils.log().info("Total Devices Added text is not displayed");

//			if (expandDeviceListButton.isDisplayed())
//				utils.log().info("Expand button image is displayed");
//			else
//				utils.log().info("Expand button image is not displayed");

			if (ruleCountForProfile.isDisplayed())
				utils.log().info(ruleCountForProfile.getText() + " text is displayed");
			else
				utils.log().info("Rules Count for user profile is not displayed");

			if (addRuleLink.isDisplayed())
				utils.log().info(addRuleLink.getText() + " link is displayed");
			else
				utils.log().info("ADD RULE link is not displayed");

			if (associatedRulesText.isDisplayed())
				utils.log().info(associatedRulesText.getText() + " text is displayed");
			else
				utils.log().info("Associated Rules text is not displayed");

			if (totalTimeActiveRule.isDisplayed())
				utils.log().info(totalTimeActiveRule.getText() + " text is displayed");
			else
				utils.log().info("Total Devices and Active Rules text is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
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

	public boolean clickAddDeviceLink() {
		if (addDeviceLink.isDisplayed()) {
			click(addDeviceLink);
			utils.log().info("Clicked on ADD DEVICE Link");
			return true;
		} else {
			utils.log().info("ADD DEVICE link is not displayed");
			return false;
		}
	}

	public boolean clickAddRuleLink() {
		if (addRuleLink.isDisplayed()) {
			click(addRuleLink);
			utils.log().info("Clicked on ADD RULE Link");
			return true;
		} else {
			utils.log().info("ADD RULE link is not displayed");
			return false;
		}
	}

	public boolean clickDeviceListExpandButton() {
		if (expandDeviceListButton.isDisplayed()) {
			click(expandDeviceListButton);
			//utils.log().info("Clicked on Device List Expand button");
			return true;
		} else {
			utils.log().info("Device List Expand button is not displayed");
			return false;
		}
	}
	
	public boolean clickRuleListExpandButton() {
		if (expandRuleListButton.isDisplayed()) {
			click(expandRuleListButton);
			utils.log().info("Clicked on Rules List expand button");
			return true;
		} else {
			utils.log().info("Rules List Expand button is not displayed");
			return false;
		}
	}

	public boolean getExistingUserName() {
		if (userProfileTitle.isDisplayed()) {
			username = userProfileTitle.getText();
			utils.log().info("Saved Existing User Name");
			return true;
		} else {
			utils.log().info("User Profile Name is not displayed");
			return false;
		}
	}

	public boolean clickUserProfileNameEditButton() {
		if (userProfileEditIcon.isDisplayed()) {
			click(userProfileEditIcon);
			utils.log().info("Clicked on User Profile Name Edit button");
			return true;
		}else {
			utils.log().info("User Profile Name Edit button is not displayed");
			return false;
		}
	}

	public boolean validateUserProfileEditedName() {
		if (!userProfileTitle.getText().equals(this.username)) {
			utils.log().info("User Profile Name is changed to " + userProfileTitle.getText());
			return true;
		} else {
			utils.log().info("User Profile Name has not changed to the newly edited name");
			return false;
		}
	}

	public boolean enablePauseInternetAccessForCurentProfiles() {
		try {
			if (pauseInternetToggleButton.isDisplayed() &&  (!(pauseInternetToggleButton).isSelected()))
			{
				click(pauseInternetToggleButton);

				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
			} else {
				utils.log().info("Pause Internet Access for current user profile is enabled.");}
			return true;
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for current user profile is already enabled");
			return false;
		}
	}
	
	public boolean disablePauseInternetAccessForAllProfiles() {
		try {
			if (pauseInternetToggleButton.isDisplayed() &&  (pauseInternetToggleButton).isSelected())
			{
				click(pauseInternetToggleButton);

				if (getAppRatingDialogObject().isAt()) {
					getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("Internet Access is allowed for the Current User Profiles.");
				}
			} else {
				utils.log().info("Pause Internet Access for current user profile is disabled.");}
			return true;
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for Current User Profile is already diabled");
			return false;
		}
	}

	public boolean verifyAssociatedDeviceList() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("List of Devices Associated with Selected User Profile  ");
		utils.log().info("*******************************************************");
		
		int size = super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTable").size();
		utils.log().info("Count of Devices associated with User is : " + size);
		
		try {
				for (int i = 1; i <= size ; i++) 
				{
					utils.log().info("Associated Device : " + i);
					utils.log().info("-------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");
					
					for (MobileElement e : entity) {
						try {
							if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Profiles_Screen_Image_Device["+i+"]\"]").isDisplayed())
								utils.log().info("Device Image is displayed");
						} catch (Exception exp) {
							utils.log().info("Device image is not displayed ");
						}

						try {
							if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_Device["+i+"]\"]").isDisplayed())
								utils.log().info("Device Name: " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_Device["+i+"]\"]")
										.getText() + " is associated with the user : " + userProfileTitle.getText());
						} catch (Exception exp) {
							utils.log().info("Device name associated with the user is not available in the list ");
						}
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
				}
			return true;
		} catch (Exception e) {
			utils.log().info("No devices from the Device List are associated with this user : " + userProfileTitle.getText());
			return false;
		}
	}
	
	public boolean deleteAssociatedDevice() {
		utils.log().info("*****************************************************");
		utils.log().info("Delete Devices Associated with Selected User Profile ");
		utils.log().info("*****************************************************");
		
		try {
				for (int i = 1; i <= 3 ; i++) 
				{
					utils.log().info("Deleting Associated Device : " + i);
					utils.log().info("---------------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.FrameLayout");
					
					for (MobileElement e : entity) {
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
								utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']")
										.getText() + " is associated with the user : " + userProfileTitle.getText());
						} catch (Exception exp) {
							utils.log().info("Device name associated with the user is not available in the list ");
						}
						
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
								elementX = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getX();
								elementY = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getY();
								new SwipeOnElement().swipeAction(elementX, elementY, "Left");
								if(deleteDeviceIcon.isDisplayed())
									click(deleteDeviceIcon);
						} catch (Exception exp) {
							utils.log().info("Unable to Delete the device associated with user");
						}
						
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
				}
			return true;
		} catch (Exception e) {
			utils.log().info("No devices from the Device List are associated with this user : " + userProfileTitle.getText());
			return false;
		}
	}
	
	public boolean deleteUserProfiles() {
			utils.log().info("**********************");
			utils.log().info("Delete A User Profile ");
			utils.log().info("**********************");
		
			try {
				for (int i = 1; i <= 3 ; i++) 
				{
					utils.log().info("Deleting A User Profile : " + i);
					utils.log().info("---------------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.FrameLayout");
					
					for (MobileElement e : entity) {
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
								utils.log().info("Device Name: " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']")
										.getText() + " is associated with the user : " + userProfileTitle.getText());
						} catch (Exception exp) {
							utils.log().info("Device name associated with the user is not available in the list ");
						}
						
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").isDisplayed())
								elementX = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getX();
								elementY = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getY();
								new SwipeOnElement().swipeAction(elementX, elementY, "Left");
								if(deleteDeviceIcon.isDisplayed())
									click(deleteDeviceIcon);
						} catch (Exception exp) {
							utils.log().info("Unable to Delete the device associated with user");
						}
						
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
				}
			return true;
		} catch (Exception e) {
			utils.log().info("No devices from the Device List are associated with this user : " + userProfileTitle.getText());
			return false;
		}
	}
	
	public boolean verifyRulesAssociatedWithUser() {
		super.swipeUp();
		utils.log().info("**********************************************************");
		utils.log().info("Details of Rules Associated to the Selected User Profile  ");
		utils.log().info("**********************************************************");
		super.swipeUp();
		
		int size = super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView").size();
		utils.log().info("Count of Rules associated with User is : " + size);
		try {
			for (int i = 1; i <= size ; i++) 
			{
				utils.log().info("Enable Schedule Time Associated With User - Rule : " + i);
				utils.log().info("-------------------------------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.FrameLayout");

				for (MobileElement e : entity) 
				{
					try {
							try {
								if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
									utils.log().info("Schedule Time : " + e.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").getText());
							} catch (Exception exp) {
									utils.log().info("Schedule Time is not displayed ");
							}
							
							try {
								if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed()) 
									utils.log().info("EveryDay Schedule Time : " + e.findElementById("com.arris.sbcBeta:id/time_block_every_day").getText());
							} catch (Exception exp) {
									utils.log().info("EveryDay Schedule Time is not displayed ");
							}
						
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbSunday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText() + " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbMonday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText() + " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbTuesday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText()
										+ " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbWednesday").isDisplayed())
									utils.log()
											.info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText()
										+ " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbThrusday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText()
										+ " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbFriday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText()
										+ " is not displayed ");
							}
		
							try {
								if (e.findElementById("com.arris.sbcBeta:id/cbSaturday").isDisplayed())
									utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText());
							} catch (Exception exp) {
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText()
										+ " is not displayed ");
							}
							
							try {
								if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
									utils.log().info("Time Block Toggle Button is currently disabled");
								else if(e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
									utils.log().info("Time Block Toggle Button is currently enabled");
								else utils.log().info("Time Block Toggle Button not displayed");
							} catch (Exception exp) {}
			
							utils.log().info("****************************************************");
							utils.log().info("                                                    ");
					}catch(Exception exp) {}
				}
			}
			return true;
		} catch (Exception p) {
			return false;
		}
	}
	
	public boolean deleteAssociatedRulesList() {
		utils.log().info("*****************************************************");
		utils.log().info("Delete Rules Associated with Selected User Profile   ");
		utils.log().info("*****************************************************");
		
		try {
			for (int i = 1; i <= 1; i++) 
			{
				utils.log().info("Delete Schedule Time - Rule : " + i);
				utils.log().info("---------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.FrameLayout");

				for (MobileElement e : entity) 
				{
					try {
						if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed()) 
						{
							try {
								if (e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']")
										.isDisplayed())
									utils.log().info("Schedule Time : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']")
											.getText());
							} catch (Exception exp) {
								utils.log().info("Schedule Time is not displayed ");
							}
		
							try {
								if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
									elementX = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getX();
									elementY = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']").getLocation().getY();
									new SwipeOnElement().swipeAction(elementX, elementY, "Left");
									if(deleteRuleIcon.isDisplayed())
										click(deleteRuleIcon);
							} catch (Exception exp) {
								utils.log().info("Unable to Delete the rule associated with user");
							}

							utils.log().info("****************************************************");
							utils.log().info("                                                    ");
						}
					}catch(Exception exp) {	}
				}
			}
			return true;
		} catch (Exception p) {
			return false;
		}
	}
	
	public boolean verifyUIonEnableScheduleTimeForCustomPage() {

		utils.log().info("****************************************************************************");
		utils.log().info("Add Rule - Details of Schedules Listed in Enabled Schedule Time Custom Page ");
		utils.log().info("****************************************************************************");
		
		try {
			for (int i = 1; i <= 1; i++) 
			{
				utils.log().info("Enable Schedule Time - Rule : " + i);
				utils.log().info("---------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.FrameLayout/android.widget.LinearLayout");

			for (MobileElement e : entity) 
			{
				try {
					if (e.findElementById("com.arris.sbcBeta:id/cbMonday").isDisplayed())
					{
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
								utils.log().info("Schedule Time : " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").getText());
						} catch (Exception exp) {
							utils.log().info("Schedule Time is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbSunday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText() + " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbMonday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText() + " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbTuesday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbWednesday").isDisplayed())
								utils.log()
										.info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbThrusday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbFriday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbSaturday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText()
									+ " is not displayed ");
						}
						
						try {
							if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
								utils.log().info("Time Block Toggle Button is currently disabled");
							else if(e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
								utils.log().info("Time Block Toggle Button is currently enabled");
							else utils.log().info("Time Block Toggle Button not displayed");
						} catch (Exception exp) {}
		
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					}catch(Exception exp) {}
				}
			}
			return true;
		} catch (Exception p) {
			return false;
		}
	}

	public int getCountOfDevicesPaused() {
		int pausedDeviceCount = super.getCountOfDevicesWithSpace(deviceCountPausedForProfile.getText());
		return pausedDeviceCount;
	}
	
	public int getCountOfRules() {
		int rulesCount = super.getCountOfRulesWithSpace(ruleCountForProfile.getText());
		return rulesCount;
	}

	public void verifyPausedDeviceCount() {
		int beforeAddDevice = 0;
		int afterAddDevice = this.getCountOfDevicesPaused();
		int result = afterAddDevice - beforeAddDevice;
		utils.log().info("Currently " + result + " device(s) are paused for this user : " + userProfileTitle.getText());
	}

	public int getTotalDevicesAdded() {
		int totalDevices = super.getTotalDevicesAdded(totalDevicesAdded.getText());
		return totalDevices;
	}

	public void verifyAssociateddDeviceCount() {
		int beforeAddDevice = 0;
		int afterAddDevice = this.getTotalDevicesAdded();
		int result = afterAddDevice - beforeAddDevice;
		utils.log().info(
				"Currently " + result + " device(s) are associated with this user : " + userProfileTitle.getText());
	}
	
	public void verifyAssociateddRulesCount() {
		int beforeAddRule = 0;
		int afterAddRule = this.getCountOfRules();
		int result = afterAddRule - beforeAddRule;
		utils.log().info(
				"Currently " + result + " rule(s) are associated with this user : " + userProfileTitle.getText());
	}

	@Override
	public boolean isAt() {
		if (pauseInternetForCurrentProfileText.isDisplayed()) {
			utils.log().info("On User Profiles Page");
			return true;
		} else {
			utils.log().info("Not on User Profiles Page");
			return false;
		}
	}
}

