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

public class ParentalControlWithProfilesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public MobileElement me;
	public int counter = 1;
	int size;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"), // Devices
																													// (2)
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[359,149][721,223]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") })
	public MobileElement parentalControlTitle;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement backButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"), // help
																														// Icon
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
	public MobileElement helpIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_parental_view']"), // Profile
																														// tab
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[102,276][540,378]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/profile_parental_view") })
	public MobileElement profilesTab;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/blocked_parental_view']"), 
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[540,276][978,378]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/blocked_parental_view") })
	public MobileElement currentlyBlockedTab;

//	@AndroidFindAll({
//			@AndroidBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"), // toggle
//																														// Icon
//			@AndroidBy(xpath = "//android.widget.Switch[@text='ON']"),
//			@AndroidBy(xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
//			@AndroidBy(id = "com.arris.sbcBeta:id/parental_enable_disable") })
//	public MobileElement parentalControlToggleIconON;

//	@AndroidFindAll({
//			@AndroidBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"), // toggle
//																														// Icon
//			@AndroidBy(xpath = "//android.widget.Switch[@text='OFF']"),
//			@AndroidBy(xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
//			@AndroidBy(id = "com.arris.sbcBeta:id/parental_enable_disable") })
//	public MobileElement parentalControlToggleIconOFF;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable' and @checked='true']")
	public MobileElement enableParentalControlToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable' and @checked='false']")
	public MobileElement disableParentalControlToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/pause_internet_enable_disable' and @checked='true']")
	public MobileElement enablePauseAllProfilesToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/pause_internet_enable_disable' and @checked='false']")
	public MobileElement disablePauseAllProfilesToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']")
	public MobileElement enableProfilesToggleButton;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
	public MobileElement disableProfilesToggleButton;
	
	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/add_profile']"), 
	@AndroidBy(xpath = "//android.widget.TextView[@bounds='[722,671][978,735]']"),
	@AndroidBy(id = "com.arris.sbcBeta:id/add_profile") })
	public MobileElement addProfileLink;
	
	// when toggle button is off, add profile link is disabled
	// when toggle button is on, add profile link is enabled

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Parental Control']") // Enable Parental Control Text
	public MobileElement enableParentalControlText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Parental Control']") // Enable Disable Profile Text
	public MobileElement enableDisableProfileText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='User Profiles']") // User Profiles Text
	public MobileElement userProfilesText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pause All Profiles']") // Pause All Profiles Text
	public MobileElement pauseAllProfilesText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pause Internet Access for All Profiles']") 
	public MobileElement pauseInternetAccessToAllText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/profile_list_view") // Profile Dinning List View
	public List<MobileElement> profileListView;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']") // profile
																											// Image
	public List<MobileElement> profileImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']") // profile
																											// name
	public List<MobileElement> profileName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']") // profile
																														// connected
																														// devices
	public List<MobileElement> profileConnectedDevices;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='ccom.arris.sbcBeta:id/pause_internet_message']") // pause
																														// internet
	public List<MobileElement> pauseInternet;

	@AndroidFindBy(xpath = "/android.widget.Switch[@text='OFF']") // disable toggle icon
	public List<MobileElement> pauseInternetToggleOFF;

	@AndroidFindBy(xpath = "/android.widget.Switch[@text='ON']") // enable toggle icon name
	public List<MobileElement> pauseInternetToggleON;

	public ParentalControlWithProfilesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	// click currently blocked devices tab when enable parental control on profiles
	// tab is ON and profiles are blocked.
	public ParentalControlCurrentlyBlockedPage getParentalControlCurrentlyBlockedTabPageObject() {
		ParentalControlCurrentlyBlockedPage parentalControlCurrentlyBlockedTabPage = new ParentalControlCurrentlyBlockedPage();
		return parentalControlCurrentlyBlockedTabPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	// click on currently blocked tab. Alert dialog should be displayed when enable
	// prarental control toggle button is off.
	public ParentalControlAlertDialog getParentalControlAlertDialogObject() {
		ParentalControlAlertDialog alertDialog = new ParentalControlAlertDialog();
		return alertDialog;
	}

	// On-click of Enable parent control toggle button sometime ratings page comes
	// up
	public AppRatingDialog getAppRatingDialogObject() {
		AppRatingDialog ratingDialog = new AppRatingDialog();
		return ratingDialog;
	}

	public ParentalControlAddProfileDialog getAddProfileDialogObject() {
		ParentalControlAddProfileDialog addProfileDialog = new ParentalControlAddProfileDialog();
		return addProfileDialog;
	}

	public ParentalControlUserProfilePage getUserProfilePageObject() {
		ParentalControlUserProfilePage userProfilePage = new ParentalControlUserProfilePage();
		return userProfilePage;
	}

	public ParentalControlHelpPage getParentalHelpPageObject() {
		ParentalControlHelpPage helpPage = new ParentalControlHelpPage();
		return helpPage;
	}

	public ParentalControlPauseInternetforAllProfilesDialog getPauseInternetForAllDialogObject() {
		ParentalControlPauseInternetforAllProfilesDialog pauseInternet = new ParentalControlPauseInternetforAllProfilesDialog();
		return pauseInternet;
	}
	
	public ParentalControlResumeInternetforAllProfilesDialog getResumeInternetForAllDialogObject() {
		ParentalControlResumeInternetforAllProfilesDialog resumeInternet = new ParentalControlResumeInternetforAllProfilesDialog();
		return resumeInternet;
	}
	

	public void verifyUIOnParentalControlProfilesPage() {
		try {
			if (parentalControlTitle.isDisplayed())
				utils.log().info("Title - " + parentalControlTitle.getText() + " - is displayed");
		} catch (Exception e) {
			utils.log().info("Parental Control Title Text is not displayed");
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
			if (profilesTab.isDisplayed())
				utils.log().info("Profiles Tab is displayed");
		} catch (Exception e) {
			utils.log().info("Profiles Tab is not displayed");
		}

		try {
			if (currentlyBlockedTab.isDisplayed())
				utils.log().info("Currently Blocked Tab is displayed");
		} catch (Exception e) {
			utils.log().info("Currently Blocked Tab is not displayed");
		}

		try {
			if (enableParentalControlText.isDisplayed())
				utils.log().info(enableParentalControlText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Enable Parental Control Text is not displayed");
		}

		try {
			if (enableDisableProfileText.isDisplayed())
				utils.log().info(enableDisableProfileText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Enable/Disable for All Profiles is not displayed");
		}

		try {
			if (disableParentalControlToggleButton.isDisplayed())
				utils.log().info("Parental Control toggle button is disabled(OFF)");
			else if(enableParentalControlToggleButton.isDisplayed())
					utils.log().info("Parental Control toggle button enabled(ON)");
		} catch (Exception e) {
			utils.log().info("Parental Control toggle button not displayed");
		}

		try {
			if (userProfilesText.isDisplayed())
				utils.log().info(userProfilesText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("User Profiles text is not displayed");
		}

		try {
			if (addProfileLink.isDisplayed())
				utils.log().info(addProfileLink.getText() + " link is displayed");
		} catch (Exception e) {
			utils.log().info("Add Profile link is not displayed");
		}

		try {
			if (pauseAllProfilesText.isDisplayed())
				utils.log().info(pauseAllProfilesText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Pause All Profiles text is not displayed");
		}

		try {
			if (pauseInternetAccessToAllText.isDisplayed())
				utils.log().info(pauseInternetAccessToAllText.getText() + " text is displayed");
		} catch (Exception e) {
			utils.log().info("Pause Internet For All Profiles text is not displayed");
		}

		try {
			if (disablePauseAllProfilesToggleButton.isDisplayed())
				utils.log().info("Pause Internet Access to All Profiles toggle button is disabled(OFF)");
		} catch (Exception e) {
			utils.log().info("Pause Internet Access to All Profiles toggle button is not displayed");
		}

		try {
			if (disablePauseAllProfilesToggleButton.isDisplayed())
				utils.log().info("Pause All Profiles toggle button is disabled(OFF)");
			else if(enableParentalControlToggleButton.isDisplayed())
					utils.log().info("Pause All Profiles toggle button enabled(ON)");
		} catch (Exception e) {
			utils.log().info("Pause All Profiles toggle button not displayed");
		}
	}

	public void clickBackButton() {
		try {
			click(backButton);
			utils.log().info("Clicked on Back Button");
		} catch (Exception e) {
			utils.log().info("Back button is not displayed");
		}
	}

	public void clickHelpIcon() {
		try {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
		} catch (Exception e) {
			utils.log().info("Help button is not displayed");
		}
	}

	public void clickProfilesTab() {
		try {
			click(profilesTab);
			utils.log().info("Clicked Profiles Tab on Parental Control Page");
		} catch (Exception e) {
			utils.log().info("Profiles Tab on Parental Control Page is not displayed");
		}
	}

	public void clickCurrentlyBlockedTab() {
		try {
			click(currentlyBlockedTab);
			utils.log().info("Clicked Currently Blocked Tab on Parental Control Page");
		} catch (Exception e) {
			utils.log().info("Currently Blocked Tab on Parental Control Page is not displayed");
		}
	}

	public void enableParentalControl() {
		try {
			if (disableParentalControlToggleButton.isDisplayed()) {
				click(disableParentalControlToggleButton);
				
				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
				
				utils.log().info("Parental Control is turned ON. Add Profile option is enabled to add new profiles.");}
			else if(enableParentalControlToggleButton.isDisplayed())
				utils.log().info("Parental Control is already enabled. Add Profile option is already enabled to add new profiles.");
		} catch (Exception e) {
			utils.log().info("Parental Control toggle switch button is not displayed");
		}
	}

	public void disableParentalControl() {
		try {
			if (enableParentalControlToggleButton.isDisplayed()) {
				click(enableParentalControlToggleButton);

				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
			
				utils.log().info("Parental Control is turned OFF. Add Profile option is disabled");}
			else if(disableParentalControlToggleButton.isDisplayed())
				utils.log().info("Parental Control is already diabled. Add Profile option is already disabled.");
		} catch (Exception e) {
			utils.log().info("Parental Control toggle switch button is not displayed");
		}
	}

	public void enablePauseInternetAccessForAllUserProfiles() {
		try {
			if (disablePauseAllProfilesToggleButton.isDisplayed()) {
				click(disablePauseAllProfilesToggleButton);
				
				if (this.getAppRatingDialogObject().isAt()) {
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
				
				if (this.getPauseInternetForAllDialogObject().isAt()) {
					this.getPauseInternetForAllDialogObject().verifyUIOnPauseInternetForAllDialog();
					this.getPauseInternetForAllDialogObject().clickYesPauseButton();
					super.pause(5);
				}
				utils.log().info("Pause All Profiles is turned ON");}
			else if (enablePauseAllProfilesToggleButton.isDisplayed()) {
				utils.log().info("Internet is already Paused for all user profiles");
			}
		} catch (Exception exp) {
			utils.log().info("Paused Internet Accesss to all toggle Switch is not displayed ");
		}
	}

	public void disablePauseInternetAccessForAllProfiles() {
		try {
			if (enablePauseAllProfilesToggleButton.isDisplayed()) {
				click(enablePauseAllProfilesToggleButton);
				
				if (getAppRatingDialogObject().isAt()) {
					getAppRatingDialogObject().clickRemindMeLaterLink();
					utils.log().info("App Rating Dialog - Clicked on Remind me Later Text");
				} else {
					utils.log().info("App Rating Dialog is not displayed");
				}
				if (this.getResumeInternetForAllDialogObject().isAt()) {
					this.getResumeInternetForAllDialogObject().verifyUIOnResumeInternetForAllDialog();
					this.getResumeInternetForAllDialogObject().clickYesResumeButton();
					super.pause(5);
				}
			} else if (disablePauseAllProfilesToggleButton.isDisplayed()) {
				utils.log().info("Internet is already Resumed for all users");
			} 
		} catch (Exception e) {
			utils.log().info("Pause Internet Access to all switch button is not displayed");
		}
	}

	public void clickAddProfilesLink() {
		try {
			if (addProfileLink.isDisplayed())
				click(addProfileLink);
			utils.log().info("Clicked on Add Profile Link");
		} catch (Exception e) {
			utils.log().info("Add Profile link is not displayed");
		}
	}

	public int getCountOfProfiles() {
		int size = profileListView.size();
		try {
			if (super.profileNames.size() == size)
				utils.log().info("Count of User Profiles : " + size);
		} catch (Exception e) {
			utils.log().info("Number of user profiles created in app does not match with size of arraylist");
		}
		return size;
	}

	public void verifyUserProfile() {
		try {
			utils.log().info("**********************************************************");
			utils.log().info("Details of User Profiles created in Parental Control Page");
			utils.log().info("**********************************************************");

			for (int i = 1; i < super.profileNames.size(); i++) {
				utils.log().info("User Profile : " + counter);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/profile_image']")
								.isDisplayed())
							utils.log().info("Profile Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Profile Image is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
								.isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
									.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
								.isDisplayed()) {
							utils.log().info("Paused Internet Label is displayed : " + (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Label is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").isDisplayed()) {
							utils.log().info("Internet is not Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").getText()));
						} else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed()) {
							utils.log().info("Internet is Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i >= 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
		}
	}

	public void pauseInternetForSelectedUserProfile() {
		try {
			for (int i = 0; i < super.profileNames.size(); i += 2) {
				utils.log().info("User Profile : " + i);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
							selectedProfileNames.add(e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").isDisplayed()) {
							utils.log().info("Internet is not Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").getText()));
						} else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed()) {
							utils.log().info("Internet is Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
		}
	}

	public void clickOnUserProfile() {
		try {
			MobileElement entity = (MobileElement) super.getDriver().findElementsByXPath(
					"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[0]");
			if (entity.isDisplayed()) {
				click(entity);
				utils.log().info("Clicking on User Profile");
			}
		} catch (Exception exp) {
			utils.log().info("User Profile does not exits. Please create one");
		}
	}
	
	public void verifyPauseInternetAccessForAllUserProfile() {
		try {
			utils.log().info("****************************************");
			utils.log().info("Internt Is Paused For All User Profiles ");
			utils.log().info("****************************************");

			for (int i = 1; i < super.profileNames.size(); i++) {
				utils.log().info("User Profile : " + counter);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
								.isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
									.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
								.isDisplayed()) {
							utils.log().info("Paused Internet Label is displayed : " + (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Label is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").isDisplayed()) {
							utils.log().info("Internet is not Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").getText()));
						} else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed()) {
							utils.log().info("Internet is Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i >= 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
		}
	}
	
	public void verifyResumeInternetAccessForAllUserProfile() {
		try {
			utils.log().info("*****************************************");
			utils.log().info("Internt Is Resumed For All User Profiles ");
			utils.log().info("*****************************************");

			for (int i = 1; i < super.profileNames.size(); i++) {
				utils.log().info("User Profile : " + counter);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
								.isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
									.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (e.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
								.isDisplayed()) {
							utils.log().info("Paused Internet Label is displayed : " + (e.findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
									.getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Label is not displayed ");
					}

					try {
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").isDisplayed()) {
							utils.log().info("Internet is not Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']").getText()));
						} else if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed()) {
							utils.log().info("Internet is Paused for this user. Switch is : "
									+ (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
						}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i >= 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
		}
	}


	@Override
	public boolean isAt() {
		if (enableParentalControlText.isDisplayed()) {
			utils.log().info("On Parental Control - Profiles Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control - Profilees Page");
			return false;
		}
	}
}
