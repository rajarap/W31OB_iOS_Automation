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

	@AndroidFindBy(id = "com.arris.sbcBeta:id/device_list_expand_icon")
	public MobileElement expandDeviceListButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/expand_time_rule_list_icon") 
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
		utils.log().info("*************************************************");
		utils.log().info(" Parental Control  - User Profile Page           ");
		utils.log().info("*************************************************");
		try {
			if (userProfileTitle.isDisplayed())
				utils.log().info("Title - " + userProfileTitle.getText() + " - is displayed");
			else
				utils.log().info("User Profile Name is not displayed");

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

			if (userProfileEditIcon.isDisplayed())
				utils.log().info("User Profile Edit Icon is displayed");
			else
				utils.log().info("User Profile Edit Icon is not displayed");

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

			if (enablePauseInternetToggleButton.isDisplayed())
				utils.log().info("Pause Internet for Current Profile toggle button is ON");
			else
				utils.log().info("Pause Internet for Current Profile toggle button is OFF");

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

			if (expandDeviceListButton.isDisplayed())
				utils.log().info("Expand button image is displayed");
			else
				utils.log().info("Expand button image is not displayed");

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
			utils.log().info("Clicked on Device List Expand button");
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
			if (disablePauseInternetToggleButton.isDisplayed()) {
				click(disablePauseInternetToggleButton);

				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
			} else
				utils.log().info("Pause Internet Access for current user profile is already enabled.");
			return true;
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for current user profile is not displayed");
			return false;
		}
	}
	
	public boolean disablePauseInternetAccessForAllProfiles() {
		try {
			if (enablePauseInternetToggleButton.isDisplayed()) {
				click(enablePauseInternetToggleButton);

				if (getAppRatingDialogObject().isAt()) {
					getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("Internet Access is allowed for the Current User Profiles.");
				}
			} else
				utils.log().info("Pause Internet Access for current user profile is already disabled.");
			return true;
		} catch (Exception e) {
			utils.log().info("Pause Internet Access for Current User Profile is not displayed");
			return false;
		}
	}

	public boolean verifyAssociatedDeviceList() {
		utils.log().info("*******************************************************************");
		utils.log().info("Parental Control - List of Devices Associated with User Profile    ");
		utils.log().info("*******************************************************************");
		try {
			if (this.getTotalDevicesAdded() > 0) {
				utils.log().info("Total devices associated with user : " + getTotalDevicesAdded());
				this.clickDeviceListExpandButton();

				for (int i = 1; i <= this.getTotalDevicesAdded(); i++) {
					utils.log().info("Associated Device : " + i);
					utils.log().info("-------------------------");
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+ i +"]");
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
			return true;
		} catch (Exception e) {
			utils.log().info("No devices from the Device List are associated with user : " + userProfileTitle.getText());
			return false;
		}
	}
	
	public boolean verifyAssociatedRulesList() {
		utils.log().info("**************************************************************");
		utils.log().info("Parental Control - List of Rules Associated with User Profile ");
		utils.log().info("**************************************************************");
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
								utils.log().info("Time Block Toggle Button is not displayed ");
							}
						}

						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
						counter++;
					}
					if (i == 1)
						new SwipeActions().swipeScreen(Direction.UP);
				}
			}
			return true;
		} catch (Exception e) {
			utils.log().info("No Rules are associated with user : " + userProfileTitle.getText());
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

