package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

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

public class ParentalControlWithProfilesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public MobileElement me;
	public int counter = 1;
	public int elementX;
	public int elementY;
	int size;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement parentalControlTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Profiles\"]")
	public MobileElement profilesTab;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Currently Blocked\"]")
	public MobileElement currentlyBlockedTab;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Enable\"]") // Enable Parental Control Text
	public MobileElement enableParentalControlText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_EnableInfo\"]")
	public MobileElement enableDisableProfileText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_Enable\"]")
	public MobileElement parentalControlToggleButton;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Global\"]")
	public MobileElement globalSettingText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_Expand\"]")
	public MobileElement globalSettingExpandButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseAll\"]")
	public MobileElement pauseAllProfilesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseInfo\"]")
	public MobileElement pauseInternetAccessToAllText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_PauseAll\"]")
	public MobileElement pauseAllProfilesToggleButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_User\"]") // User Profiles Text
	public MobileElement userProfilesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"+ Add Profile\"]")
	public MobileElement addProfileLink;

	//When there are no user profiles
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_NoProfile\"]")
	public MobileElement noProfilesText1;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Image_Note\"]")
	public MobileElement noProfilesText2;
	
	//Delete Associated Rules
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileConfirmationText;
	
	//Delete Associated Rules

	
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

	public boolean verifyUIOnParentalControlProfilesPage() {
		utils.log().info("**********************************************************");
		utils.log().info("Verifying Objects on Parental Control - Profiles Tab      ");
		utils.log().info("**********************************************************");

		try {
			if (parentalControlTitle.isDisplayed())
				utils.log().info("Title - " + parentalControlTitle.getText() + " - is displayed");
			else
				utils.log().info("Parental Control Title Text is not displayed");
			
			try {
				if (backButton.isDisplayed())
					utils.log().info("Back Button is displayed");
				}catch(Exception e) {utils.log().info("Back Button is not displayed");}

			try {
				if (cloudIcon.isDisplayed())
					utils.log().info("Cloud Icon is displayed");
				}catch(Exception e) {utils.log().info("Cloud Icon is not displayed");}

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");

			if (profilesTab.isDisplayed())
				utils.log().info("Profiles Tab is displayed");
			else
				utils.log().info("Profiles Tab is not displayed");

			if (currentlyBlockedTab.isDisplayed())
				utils.log().info("Currently Blocked Tab is displayed");
			else
				utils.log().info("Currently Blocked Tab is not displayed");
			
			if (enableParentalControlText.isDisplayed())
				utils.log().info(enableParentalControlText.getText() + " text is displayed");
			else
				utils.log().info("Enable Parental Control Text is not displayed");
			
//			try {
//				if (parentalControlToggleButton.isDisplayed() && parentalControlToggleButton.isSelected())
//					utils.log().info("Parental Control Switch button is enabled");
//				else
//					utils.log().info("Parental Control Switch button is disabled");
//			}catch(Exception exp) {utils.log().info("Parental Control is not displayed");}
//			
//			try {
//				if (globalSettingText.isDisplayed())
//					utils.log().info("Global Settings Text is displayed");
//				}catch(Exception e) {utils.log().info("Global Settings Text is not displayed since there are no profiles created");}
//
//			try {
//				if (globalSettingExpandButton.isDisplayed())
//					utils.log().info("Global Settings Expand button is displayed");
//				click(globalSettingExpandButton);
//				}catch(Exception e) {utils.log().info("Global Settings Expand button is not displayed since there are no profiles created");}
//			
//
//			if (pauseAllProfilesText.isDisplayed())
//				utils.log().info(pauseAllProfilesText.getText() + " text is displayed");
//			else
//				utils.log().info("Pause All Profiles text is not displayed");
//		
//			if (pauseInternetAccessToAllText.isDisplayed())
//				utils.log().info(pauseInternetAccessToAllText.getText() + " text is displayed");
//			else 
//				utils.log().info("Pause Internet For All Profiles text is not displayed");
//			
//			try {
//				if (pauseAllProfilesToggleButton.isDisplayed() && pauseAllProfilesToggleButton.isSelected())
//					utils.log().info("Pause All Profiles Switch button is enabled");
//				else
//					utils.log().info("Pause All Profiles Switch button is disabled");
//			}catch(Exception exp) {utils.log().info("Pause All Profiles is not displayed");}

			if (userProfilesText.isDisplayed())
				utils.log().info(userProfilesText.getText() + " text is displayed");
			else
				utils.log().info("User Profiles text is not displayed");

			if (addProfileLink.isDisplayed())
				utils.log().info(addProfileLink.getText() + " link is displayed");
			else
				utils.log().info("Add Profile link is not displayed");
			
			try {	
				if (noProfilesText1.isDisplayed())
					utils.log().info(noProfilesText1.getText());
			}catch(Exception exp) {utils.log().info("Currently there are users under Parental Control ");}

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
			utils.log().info("Back button is not displayed");
			return false;
		}
	}

	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickProfilesTab() {
		if (profilesTab.isDisplayed()) {
			click(profilesTab);
			utils.log().info("Clicked Profiles Tab on Parental Control Page");
			return true;
		} else {
			utils.log().info("Profiles Tab on Parental Control Page is not displayed");
			return false;
		}
	}

	public boolean clickCurrentlyBlockedTab() {
		if (profilesTab.isDisplayed()) {
			click(currentlyBlockedTab);
			utils.log().info("Clicked Currently Blocked Tab on Parental Control Page");
			return true;
		} else {
			utils.log().info("Currently Blocked Tab on Parental Control Page is not displayed");
			return false;
		}
	}

	public boolean enableParentalControl() {
		try {
			if(parentalControlToggleButton.isDisplayed() && (!(parentalControlToggleButton.isSelected()))) {
				click(parentalControlToggleButton);
				utils.log().info("Parental Control is enabled. Add Profile option is enabled to add new profiles.");
			}else {
				utils.log().info("Parental Control is already enabled. Add Profile option is enabled to add new profiles.");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Parental Control is already enabled");
			return true;
		}
	}

	public boolean disableParentalControl() {
		try {
			if(parentalControlToggleButton.isDisplayed() && (parentalControlToggleButton.isSelected()))
				click(parentalControlToggleButton);
			utils.log().info("Parental Control is disabled. Add Profile option is disabled");
			return true;
		} catch(Exception e) {
			utils.log().info("Parental Control is already disabled. Add Profile option is disabled");
			return true;
		}
	}
	
	public boolean enablePauseAllProfiles() {
		try {
			if(pauseAllProfilesToggleButton.isDisplayed() && (!(pauseAllProfilesToggleButton.isSelected()))) {
				click(pauseAllProfilesToggleButton);
				utils.log().info("Pause All Profiles is enabled");}
			return true;
		} catch(Exception e) {
			utils.log().info("Pause All Profiles is already enabled");
			return true;
		}
	}

	public boolean disablePauseAllProfiles() {
		try {
			if(pauseAllProfilesToggleButton.isDisplayed() && (pauseAllProfilesToggleButton.isSelected()))
				click(parentalControlToggleButton);
			utils.log().info("Pause All Profiles is disabled");
			return true;
		} catch(Exception e) {
			utils.log().info("Pause All Profiles is already disabled");
			return true;
		}
	}

	public boolean clickAddProfilesLink() {
		if (addProfileLink.isDisplayed()) {
			click(addProfileLink);
			utils.log().info("Clicked on Add Profile Link");
			return true;
		} else {
			utils.log().info("Add Profile link is not displayed");
			return false;
		}
	}

//	public int getCountOfProfiles() {
//		int size = profileListView.size();
//		try {
//			if (super.profileNames.size() == size)
//				utils.log().info("Count of User Profiles : " + size);
//		} catch (Exception e) {
//			utils.log().info("Number of user profiles created in app does not match with size of arraylist");
//		}
//		return size;
//	}

	public boolean verifyUserProfile() {

		utils.log().info("                                                          ");
		utils.log().info("**********************************************************");
		utils.log().info("Details of User Profiles created in Parental Control Page ");
		utils.log().info("**********************************************************");
		
//		int size = super.getDriver().findElementsByXPath(
//		"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable").size();
//		utils.log().info("No of User Profiles added : " + size);
		
		try {
			for (int i = 1; i <= 3; i++) {
				utils.log().info("                   ");
				utils.log().info("User Profile : " + i);
				utils.log().info("------------------");
				
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Screen_Image_Profile["+i+"]\"]").isDisplayed())
							utils.log().info("Profile Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Profile Image is not displayed ");
					}

					try {
						if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").isDisplayed()) {
							utils.log().info("Profile user Name is : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").getText());}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ConnectedDevice["+i+"]\"]").isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e.findElementByXPath(
											"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ConnectedDevice["+i+"]\"]").getText()));}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause["+i+"]\"]").isDisplayed()) {
							utils.log().info("Paused Internet Label is displayed : " + (e.findElementByXPath(
									"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause["+i+"]\"]").getText()));}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Label is not displayed ");
					}

					try {
						if (e.findElementByXPath("//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_Profile["+i+"]\"]").isSelected())
							utils.log().info("Internet is Paused for this user");
						else
							utils.log().info("Internet is not Paused for this user");
					} catch (Exception exp) {}

					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i >= 3)
					super.swipeUp();
				super.pause(3);
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean pauseInternetForSelectedUserProfile() {
		utils.log().info("**********************************************");
		utils.log().info("Internet Is Paused For Selected User Profiles ");
		utils.log().info("**********************************************");

		try {
			for (int i = 0; i < 5; i += 2) {
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
						if (e.findElementByXPath(
								"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
								.isDisplayed())
							utils.log()
									.info("Internet is not Paused for this user. Switch is : " + (e.findElementByXPath(
											"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
											.getText()));
						else
							utils.log().info("Internet is Paused for this user. Switch is : " + (e.findElementByXPath(
									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']")
									.getText()));
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i == 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean clickOnUserProfile() {
		utils.log().info("****************************************");
		utils.log().info("Selecting a User Profile from the list  ");
		utils.log().info("****************************************");
		super.generateRandomNumber13();

		try {
			for (int i = 1; i <= 1; i++) {
//				utils.log().info("User Profile : " + i);
//				utils.log().info("------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");


				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").isDisplayed()) {
							utils.log().info("Clicking on User profile Name : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").getText());
							click(e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]"));
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("User Profile does not exits. Please create one");
			return false;
		}
	}
	
	public boolean deleteUserProfile() {
		//utils.log().info("****************************************");
		utils.log().info("Deleting a User Profile from the list  ");
		//utils.log().info("****************************************");
		super.generateRandomNumber13();

		try {
			for (int i = 3; i <= 3; i++) {
//				utils.log().info("User Profile : " + i);
//				utils.log().info("------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");

				for (MobileElement e : entity) {
					
					try {
						if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']").isDisplayed())
							utils.log().info("Deleting on User profile Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
							.getText());
							elementX = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']").getLocation().getX();
							elementY = super.getDriver().findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']").getLocation().getY();
							new SwipeOnElement().swipeAction(elementX, elementY, "Left");
							if(deleteProfileIcon.isDisplayed())
								click(deleteProfileIcon);
					} catch (Exception exp) {
						utils.log().info("Unable to Delete the selected user profile");
					}
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("User Profile does not exits. Please create one");
			return false;
		}
	}

	public boolean verifyPauseInternetAccessForAllUserProfile() {
		counter = 1;
		utils.log().info("***************************************************");
		utils.log().info("Internet Is Paused For The Following User Profiles ");
		utils.log().info("***************************************************");
		try {
			for (int i = 1; i < 3 ; i++) {
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
						if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed())
							utils.log().info("Internet is Paused for this user. Switch is : " + (e.findElementByXPath(
									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
					} catch (Exception exp) {
						utils.log().info("Internet is not Paused for this user. Switch is : " + (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i == 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean verifyResumeInternetAccessForAllUserProfile() {
		counter = 1;
		utils.log().info("****************************************************");
		utils.log().info("Internet Is Resumed For The Following User Profiles ");
		utils.log().info("****************************************************");
		
		try {
			for (int i = 1; i < 3 ; i++) {
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
						if (e.findElementByXPath(
								"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
								.isDisplayed()) {
							utils.log()
									.info("Internet is not Paused for this user. Switch is : " + (e.findElementByXPath(
											"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
											.getText()));
						} else
							utils.log().info("Internet is Paused for this user. Switch is : " + (e.findElementByXPath(
									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']")
									.getText()));
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					counter++;
				}
				if (i == 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
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
