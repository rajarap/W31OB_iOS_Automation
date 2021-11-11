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

public class ParentalControlUserProfilePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public String username;
	public MobileElement me;
	public int counter = 1;
	int size;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement userProfileTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_edit_profile_name")
	public MobileElement userProfileEditIcon;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement backButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"), 
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
	public MobileElement helpIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/profile_image_view")
	public MobileElement userProfilePic;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/edit_icon")
	public MobileElement userProfilePicEditIcon;

	// Pause Profile
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pause Profile']")
	public MobileElement pauseProfileText;

	// Pause Internet access for current profile
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pause Internet access for current profile']")
	public MobileElement pauseInternetForCurrentProfileText;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/internet_enable_disable' and @checked='true']")
	public MobileElement enablePauseInternetToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/internet_enable_disable' and @checked='false']")
	public MobileElement disablePauseInternetToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/profile_device_count")
	public MobileElement deviceCountPausedForProfile;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/add_devices']"), // +ADD
																														// DEVICE
	@AndroidBy(id = "com.arris.sbcBeta:id/add_devices") })
	public MobileElement addDeviceLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Associated Devices']")
	public MobileElement associatedDevicesText;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_count']"), 
			@AndroidBy(id = "com.arris.sbcBeta:id/device_count") })
	public MobileElement totalDevicesAdded;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_list_expand_icon']"), 
			@AndroidBy(id = "com.arris.sbcBeta:id/device_list_expand_icon") })
	public MobileElement expandDeviceListButton;
	
	@AndroidBy(id = "com.arris.sbcBeta:id/add_devices") 
	public MobileElement expandRuleListButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/time_rule_count")
	public MobileElement ruleCountForProfile;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/add_time_rule']"), 
			@AndroidBy(id = "com.arris.sbcBeta:id/add_time_rule") })
	public MobileElement addRuleLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Associated Rules']")
	public MobileElement associatedRulesText;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_rule_warning_message']"), 
			@AndroidBy(id = "com.arris.sbcBeta:id/time_rule_warning_message") })
	public MobileElement totalTimeActiveRule;

	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']")
	public MobileElement enableTimeBlockToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']")
	public MobileElement disableTimeBlockToggleButton;
	
	
//	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']")  //profile Image
//	public List<MobileElement> profileImage; 
//	
//	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")  //profile name
//	public List<MobileElement> profileName; 
//	
//	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")  //profile connected devices
//	public List<MobileElement> profileConnectedDevices; 
//	
//	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='ccom.arris.sbcBeta:id/pause_internet_message']")  //pause internet
//	public List<MobileElement> pauseInternet; 
//	
//	@AndroidFindBy (xpath = "/android.widget.Switch[@text='OFF']")  //disable toggle icon
//	public List<MobileElement> pauseInternetToggleOFF;  
//	
//	@AndroidFindBy (xpath = "/android.widget.Switch[@text='ON']")  //enable toggle icon name
//	public List<MobileElement> pauseInternetToggleON; 

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

	// On-click of Enable parent control toggle button sometime ratings page comes
	// up
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

	public void verifyUIOnUserProfilePage() {
		try {
			if (userProfileTitle.isDisplayed())
				utils.log().info("Title - " + userProfileTitle.getText() + " - is displayed");
		} catch (Exception e) {
			utils.log().info("User Profile Name is not displayed");
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
			utils.log().info("PCloud Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if (userProfileEditIcon.isDisplayed())
				utils.log().info("User Profile Edit Icon is displayed");
		} catch (Exception e) {
			utils.log().info("User Profile Edit Icon is not displayed");
		}

		try {
			if (userProfilePic.isDisplayed())
				utils.log().info("User Profile Pic is displayed");
		} catch (Exception e) {
			utils.log().info("User Profile Pic is not displayed");
		}

		try {
			if (userProfilePicEditIcon.isDisplayed())
				utils.log().info("User Profile Edit pic Icon is displayed");
		} catch (Exception e) {
			utils.log().info("User Profile Edit pic Icon is not displayed");
		}

		try {
			if (pauseProfileText.isDisplayed())
				utils.log().info(pauseProfileText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Pause Profile text is not displayed");
		}

		try {
			if (pauseInternetForCurrentProfileText.isDisplayed())
				utils.log().info(pauseInternetForCurrentProfileText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for Current Profile text is not displayed");
		}

		try {
			if (enablePauseInternetToggleButton.isDisplayed())
				utils.log().info("Pause Internet for Current Profile toggle button is ON");
		} catch (Exception e) {
			utils.log().info("Pause Internet for Current Profile toggle button is not displayed");
		}

		try {
			if (disablePauseInternetToggleButton.isDisplayed())
				utils.log().info("Pause Internet for Current Profile toggle button is OFF");
		} catch (Exception e) {
			utils.log().info("Pause Internet for Current Profile toggle button is not displayed");
		}

		try {
			if (deviceCountPausedForProfile.isDisplayed())
				utils.log().info(deviceCountPausedForProfile.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Device Count for user profie is not displayed");
		}

		try {
			if (addDeviceLink.isDisplayed())
				utils.log().info(addDeviceLink.getText() + " link is displayed");
		} catch (Exception e) {
			utils.log().info("ADD DEVICE link is not displayed");
		}

		try {
			if (associatedDevicesText.isDisplayed())
				utils.log().info(associatedDevicesText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Associated Devices text is not displayed");
		}

		try {
			if (totalDevicesAdded.isDisplayed())
				utils.log().info(totalDevicesAdded.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Total Devices Added text is not displayed");
		}

		try {
			if (expandDeviceListButton.isDisplayed())
				utils.log().info("Expand button image is displayed");
		} catch (Exception e) {
			utils.log().info("Expand button image is not displayed");
		}

		try {
			if (ruleCountForProfile.isDisplayed())
				utils.log().info(ruleCountForProfile.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Rules Count for user profile is not displayed");
		}

		try {
			if (addRuleLink.isDisplayed())
				utils.log().info(addRuleLink.getText() + " link is displayed");
		} catch (Exception e) {
			utils.log().info("ADD RULE link is not displayed");
		}

		try {
			if (associatedRulesText.isDisplayed())
				utils.log().info(associatedRulesText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Associated Rules text is not displayed");
		}

		try {
			if (totalTimeActiveRule.isDisplayed())
				utils.log().info(totalTimeActiveRule.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Total Devices and Active Rules text is not displayed");
		}

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

	public void clickAddDeviceLink() {
		try {
			if (addDeviceLink.isDisplayed())
				click(addDeviceLink);
			utils.log().info("Clicked on ADD DEVICE Link");
		} catch (Exception e) {
			utils.log().info("ADD DEVICE link is not displayed");
		}
	}

	public void clickAddRuleLink() {
		try {
			if (addRuleLink.isDisplayed())
				click(addRuleLink);
			utils.log().info("Clicked on ADD RULE Link");
		} catch (Exception e) {
			utils.log().info("ADD RULE link is not displayed");
		}
	}

	public void clickDeviceListExpandButton() {
		try {
			if (expandDeviceListButton.isDisplayed())
				click(expandDeviceListButton);
			utils.log().info("Clicked on Device List Expand button");
		} catch (Exception e) {
			utils.log().info("Device List Expand button is not displayed");
		}
	}
	
	public void clickRuleListExpandButton() {
		try {
			if (expandRuleListButton.isDisplayed())
				click(expandRuleListButton);
			utils.log().info("Clicked on Rules List expand button");
		} catch (Exception e) {
			utils.log().info("Rules List Expand button is not displayed");
		}
	}
	
	public void getExistingUserName() {
		try {
			if (userProfileTitle.isDisplayed())
				username = userProfileTitle.getText();
		} catch (Exception e) {
			utils.log().info("User Profile Name is not displayed");
		}
	}

	public void clickUserProfileNameEditButton() {
		try {
			if (userProfileEditIcon.isDisplayed())
				click(userProfileEditIcon);
			utils.log().info("Clicked on User Profile Name Edit button");
		} catch (Exception e) {
			utils.log().info("User Profile Name Edit button is not displayed");
		}
	}

	public void validateUserProfileEditedName() {
		try {
			if (!userProfileTitle.getText().equals(this.username))
				utils.log().info("User Profile Name has been changed from " + this.username + " to "
						+ userProfileTitle.getText());
		} catch (Exception e) {
			utils.log().info("User Profile Name has not changed to the newly edited name");
		}
	}

	public void enablePauseInternetAccessForCurentProfiles() {
		try {
			if (disablePauseInternetToggleButton.isDisplayed()) {
				click(disablePauseInternetToggleButton);
				
				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
			}
			else if(enablePauseInternetToggleButton.isDisplayed())
				utils.log().info("Pause Internet Access for current user profile is already enabled.");
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for current user profile is not displayed");
		}
	}
	
	public void disablePauseInternetAccessForAllProfiles() {
		try {
			if (enablePauseInternetToggleButton.isDisplayed()) {
				click(enablePauseInternetToggleButton);
				
				if (getAppRatingDialogObject().isAt()) {
					getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("Internet Access is allowed for the Current User Profiles.");
				}
			}
			else if(disablePauseInternetToggleButton.isDisplayed())
				utils.log().info("Pause Internet Access for current user profile is already disabled.");
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for Current User Profile is not displayed");
		}
	}

	public void verifyAssociatedDeviceList() {
		try {
			if (this.getTotalDevicesAdded() > 0) {
				this.clickDeviceListExpandButton();

				for (int i = 1; i <= this.getTotalDevicesAdded(); i++) {
					utils.log().info("Associated Device : " + i);
					utils.log().info("-------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");
					for (MobileElement e : entity) {
						try {
							if (e.findElementByXPath(
									"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/device_type_icon']")
									.isDisplayed())
								utils.log().info("Device Image is displayed");
						} catch (Exception exp) {
							utils.log().info("Device image is not displayed ");
						}

						try {
							if (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']")
									.isDisplayed())
								utils.log().info("Device Name: " + e.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name']")
										.getText() + " is associated with the user : " + userProfileTitle.getText());
						} catch (Exception exp) {
							utils.log().info("Device name associated with the user is not available in the list ");
						}
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
					}
					if (i >= 3)
						new SwipeActions().swipeScreen(Direction.UP);
					super.pause(3);
				}
			}
		} catch (Exception e) {
			utils.log()
					.info("No devices from the Device List are associated with user : " + userProfileTitle.getText());
		}
	}
	
	public void verifyAssociatedRulesList() {
		try {
			if (this.getCountOfRules() > 0) {

				for (int i = 1; i <= this.getCountOfRules(); i++) {
					utils.log().info("Associated Rules : " + i);
					utils.log().info("-------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");
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
					if (i >= 1)
						new SwipeActions().swipeScreen(Direction.UP);
				}
			}
		} catch (Exception e) {
			utils.log()
					.info("No Rules are associated with user : " + userProfileTitle.getText());
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
			utils.log().info("On Parental Control - User Profiles Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control - User Profiles Page");
			return false;
		}
	}
}



//public void verifyUserProfile() {
//try {
//	utils.log().info("**********************************************************");
//	utils.log().info("Details of User Profiles created in Parental Control Page");
//	utils.log().info("**********************************************************");
//
//	for (int i = 1; i <= super.profileNames.size(); i++) {
//		utils.log().info("User Profile : " + counter);
//		utils.log().info("----------------------");
//		List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
//				"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
//						+ "]");
//		for (MobileElement e : entity) {
//			try {
//				if (e.findElementByXPath(
//						"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']")
//						.isDisplayed())
//					utils.log().info("Profile Image is displayed");
//			} catch (Exception exp) {
//				utils.log().info("Profile Image is not displayed ");
//			}
//
//			try {
//				if (e.findElementByXPath(
//						"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//						.isDisplayed()) {
//					utils.log().info("Profile user Name is : " + e.findElementByXPath(
//							"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//							.getText());
//				}
//			} catch (Exception exp) {
//				utils.log().info("User Profile Name is not displayed ");
//			}
//
//			try {
//				if (e.findElementByXPath(
//						"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//						.isDisplayed()) {
//					utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
//							.findElementByXPath(
//									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//							.getText()));
//				}
//			} catch (Exception exp) {
//				utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
//			}
//
//			try {
//				if (e.findElementByXPath(
//						"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//						.isDisplayed()) {
//					utils.log().info("Paused Internet Label is displayed : " + (e.findElementByXPath(
//							"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//							.getText()));
//				}
//			} catch (Exception exp) {
//				utils.log().info("Paused Internet Label is not displayed ");
//			}
//
//			try {
//				if (e.findElementByXPath("//android.widget.Switch[@text='OFF']").isDisplayed()) {
//					utils.log().info("Internet is not Paused for this user. Switch is : "
//							+ (e.findElementByXPath("//android.widget.Switch[@text='OFF']").getText()));
//				} else if (e.findElementByXPath("//android.widget.Switch[@text='ON']").isDisplayed()) {
//					utils.log().info("Internet is Paused for this user. Switch is : "
//							+ (e.findElementByXPath("//android.widget.Switch[@text='ON']").getText()));
//				}
//			} catch (Exception exp) {
//				utils.log().info("Paused Internet Switch is not displayed ");
//			}
//			utils.log().info("****************************************************");
//			utils.log().info("                                                    ");
//			counter++;
//		}
//		if (i >= 3)
//			new SwipeActions().swipeScreen(Direction.UP);
//		super.pause(3);
//	}
//} catch (Exception exp) {
//	utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
//}
//}

//public void pauseInternetForSelectedUserProfile() {
//try {
//	for (int i = 1; i <= super.profileNames.size(); i += 2) {
//		utils.log().info("User Profile : " + i);
//		utils.log().info("----------------------");
//		List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
//				"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
//						+ "]");
//		for (MobileElement e : entity) {
//			try {
//				if (e.findElementByXPath(
//						"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//						.isDisplayed()) {
//					utils.log().info("Profile user Name is : " + e.findElementByXPath(
//							"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//							.getText());
//					selectedProfileNames.add(e.findElementByXPath(
//							"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//							.getText());
//				}
//			} catch (Exception exp) {
//				utils.log().info("User Profile Name is not displayed ");
//			}
//
//			try {
//				if (e.findElementByXPath("//android.widget.Switch[@text='OFF']").isDisplayed()) {
//					click(e.findElementByXPath("//android.widget.Switch[@text='OFF']"));
//					utils.log().info("Internet is now Paused for this user");
//				} else if (e.findElementByXPath("//android.widget.Switch[@text='ON']").isDisplayed()) {
//					utils.log().info("Internet is already Paused for this user");
//				}
//			} catch (Exception exp) {
//				utils.log().info("Paused Internet Switch is not displayed ");
//			}
//			utils.log().info("****************************************************");
//			utils.log().info("                                                    ");
//		}
//		if (i >= 3)
//			new SwipeActions().swipeScreen(Direction.UP);
//		super.pause(3);
//	}
//} catch (Exception exp) {
//	utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
//}
//}
