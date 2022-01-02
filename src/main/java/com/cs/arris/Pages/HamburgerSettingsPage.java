package com.cs.arris.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.android.nativekey.PressesKey;

public class HamburgerSettingsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
	public MobileElement settingsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_TitleLabel\"]")
	public MobileElement accountSettingsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_Name\"]")
	public MobileElement nameLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_UserName\"]")
	public MobileElement accountName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Settings_Screen_Image_User\"]")
	public MobileElement userImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_Email\"]")
	public MobileElement emailLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_EmailId\"]")
	public MobileElement emailAddress;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Settings_Screen_Image_Email\"]")
	public MobileElement emailImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings_Screen_Button\"]")
	public MobileElement signoutButton;
	// ****************************Settings*****************************************

	// ****************************About*****************************************
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") // About
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"About\"])[2]")
	public MobileElement aboutTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/setupImageView") // Router Image
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage[1]")
	public MobileElement routerImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_surfboard") // Surfboard Image
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"surfboardIcon\"]")
	public MobileElement surfboardImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/text_firmware_version") // Firmware Version
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Firmware Version: AXR.0509.210914.13\"]")
	public MobileElement firmwareVersionText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/text_app_version") // App Version
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"App Version: 3.7.41\"]")
	public MobileElement appVersionText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/text_app_model") // Model Name
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Model Number: W31\"]")
	public MobileElement modelNameText;

//	@AndroidFindBy(id = "com.arris.sbcBeta:id/firmwareVersion") // AXR.0335.201111.12
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"message\"]")
//	public MobileElement firmwareNumber;
//
//	@AndroidFindBy(id = "com.arris.sbcBeta:id/appVersion") // 3.4.13
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"message\"]")
//	public MobileElement appNumber;
//
//	@AndroidFindBy(id = "com.arris.sbcBeta:id/appModelName") // W31
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"message\"]")
//	public MobileElement modelNumber;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/btnViewLicense") // VIEW LICENCES
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View EULA\"]")
	public MobileElement viewLicensesButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/newMaxView") // click to purchase new max Router
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
	public MobileElement newMaxRouter;
	// ****************************About*****************************************

	// ****************************Shop for another mAX
	// Router*****************************************
	@AndroidFindBy(id = "com.arris.sbcBeta:id/inner_view_router_iv") // another maz router image
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View EULA\"]")
	public MobileElement anotherMaxRouterImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/get_another_tv") // Get another mAX™
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Get another mAX™ \"]")
	public MobileElement getAnotherMaxRouterText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/just_can_not_tv") // Just can't get enough?
	public MobileElement cantGetEnoughText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/shop_now_tv") // Shop now
	public MobileElement shopNow;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/newMaxView']") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
	public MobileElement getAnotherMaxRouterButton;
	// ****************************Shop for another mAX
	// Router*****************************************

	// ****************************Help
	// Screen*****************************************
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") // Help
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Help\"])[2]")
	public MobileElement helpTitle;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_surfboard_logo") // Surfboard Logo
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"surfboardIcon\"]")
	public MobileElement surfboardLogoImage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_text") // NEED ADDITIONAL HELP?
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NEED ADDITIONAL HELP?\"]")
	public MobileElement additionalHelpText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/description_text") // Browse help section or contact support
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Browse our help content or start a chat for additional support.\"]")
	public MobileElement helpMessage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/faqButton") // Frequently Asked Questions
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement faqButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/bt_webAddress") // www.arris.com/selfhelp
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement selfHelpButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/bt_liveChat") // Chat with us
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	public MobileElement liveChatButton;
	// www5.nohold.net/Arris/ukp.aspx?pid=15&login=1&alt1=app&alt2=mAX+Pro+W31&model=mAX+Pro+W31&donelr=1
	// ****************************Help
	// Screen*****************************************

	public HamburgerSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public AboutViewLicensesPage getLicensesPageObject() {
		AboutViewLicensesPage licensePage = new AboutViewLicensesPage();
		return licensePage;
	}

	public AboutHelpPage getAboutHelpPageObject() {
		AboutHelpPage aboutHelpPage = new AboutHelpPage();
		return aboutHelpPage;
	}

	public SettingsHelpPage getSettingsHelpPageObject() {
		SettingsHelpPage settingsHelpPage = new SettingsHelpPage();
		return settingsHelpPage;
	}

	public FAQHelpPage getFAQHelpPageObject() {
		FAQHelpPage faqHelpPage = new FAQHelpPage();
		return faqHelpPage;
	}
	
	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickLicenseButton() {
		if (viewLicensesButton.isDisplayed()) {
			click(viewLicensesButton);
			utils.log().info("About Page - Clicked on View License Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickFAQButton() {
		if (faqButton.isDisplayed()) {
			click(faqButton);
			utils.log().info("Help Page - Clicked on FAQ Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickSignOutButton() {
		if (signoutButton.isDisplayed()) {
			click(signoutButton);
			utils.log().info("Settings Page - Clicked on Sign Out button");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUIOnSettingsPage() {
		utils.log().info("*********************************************************");
		utils.log().info("Details of UI Elements on the Hamburger - Settings Page  ");
		utils.log().info("*********************************************************");
		try {
			if (settingsTitle.isDisplayed())
				utils.log().info("Title " + settingsTitle.getText() + " is displayed");
			else
				utils.log().info("Settings page title is not displayed");

			if (accountSettingsTitle.isDisplayed())
				utils.log().info(accountSettingsTitle.getText() + " text is displayed");
			else
				utils.log().info("Account Settings Text is not displayed");

			if (nameLabel.isDisplayed())
				utils.log().info(nameLabel.getText() + " label is displayed");
			else
				utils.log().info("Name Label is not displayed");

			if (accountName.isDisplayed())
				utils.log().info("Users account firstname and lastname is displayed : " + accountName.getText());
			else
				utils.log().info("Users account firstname and lastname is not displayed");

			if (userImage.isDisplayed())
				utils.log().info("User Image is displayed");
			else
				utils.log().info("User Image Label is not displayed");

			if (emailImage.isDisplayed())
				utils.log().info("Email Address image is displayed");
			else
				utils.log().info("Email Address image is not displayed");

			if (emailLabel.isDisplayed())
				utils.log().info(emailLabel.getText() + " label is displayed");
			else
				utils.log().info("Email Label is not displayed");

			if (emailAddress.isDisplayed())
				utils.log().info("Email Address " + emailAddress.getText() + " is displayed");
			else
				utils.log().info("Email Address is not displayed");
			
			if (signoutButton.isDisplayed())
				utils.log().info("Sign Out button is displayed");
			else
				utils.log().info("Sign Out button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnAboutPage() {
		utils.log().info("******************************************************");
		utils.log().info("Details of UI Elements on the Hamburger - About Page  ");
		utils.log().info("******************************************************");
		try {
			if (aboutTitle.isDisplayed())
				utils.log().info("Title " + aboutTitle.getText() + " is displayed");
			else
				utils.log().info("About page title is not displayed");

			if (routerImage.isDisplayed())
				utils.log().info("Router Image is displayed");
			else
				utils.log().info("Router Image is not displayed");

			if (surfboardImage.isDisplayed())
				utils.log().info("Surfboard Image is displayed");
			else
				utils.log().info("Surfboard Image is not displayed");

			if (firmwareVersionText.isDisplayed())
				utils.log().info("Firmware Version Label is displayed");
			else
				utils.log().info("Firmware Version Label is not displayed");

//			if (firmwareNumber.isDisplayed())
//				utils.log().info("Firmware Number : " + firmwareNumber.getText() + " is displayed");
//			else
//				utils.log().info("Firmware Number is not displayed");

			if (appVersionText.isDisplayed())
				utils.log().info("App Version is displayed");
			else
				utils.log().info("App Version is not displayed");

//			if (appNumber.isDisplayed())
//				utils.log().info("App Number : " + appNumber.getText() + " is displayed");
//			else
//				utils.log().info("App Number is not displayed");

			if (modelNameText.isDisplayed())
				utils.log().info("Model Name is displayed");
			else
				utils.log().info("Model Name is not displayed");

//			if (modelNumber.isDisplayed())
//				utils.log().info("Model Number : " + modelNumber.getText() + " is displayed");
//			else
//				utils.log().info("Surfboard Image is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnHelpPage() {
		try {
			if (helpTitle.isDisplayed())
				utils.log().info("Title " + helpTitle.getText() + " is displayed");
			else
				utils.log().info("Help page title is not displayed");

			if (surfboardLogoImage.isDisplayed())
				utils.log().info("Surfboard Logo Image is displayed");
			else
				utils.log().info("Surfboard Logo Image is not displayed");

			if (additionalHelpText.isDisplayed())
				utils.log().info("Additional Help Text " + additionalHelpText.getText() + " is displayed");
			else
				utils.log().info("Additional Help Text is not displayed");

			if (helpMessage.isDisplayed())
				utils.log().info(helpMessage.getText() + " message is displayed");
			else
				utils.log().info("Help Message Text is not displayed");

			if (faqButton.isDisplayed())
				utils.log().info("Button " + faqButton.getText() + " is displayed");
			else
				utils.log().info("FAQ Button is not displayed");

			if (selfHelpButton.isDisplayed())
				utils.log().info(selfHelpButton.getText() + " is displayed");
			else
				utils.log().info("SelfHelp URL is not displayed");

			if (liveChatButton.isDisplayed())
				utils.log().info(liveChatButton.getText() + " is displayed");
			else
				utils.log().info("Chat With Us button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickGetAnotherMaxRouterButton() {
		try {
			click(getAnotherMaxRouterButton);
			super.pause(5);
			utils.log().info("About Page - Clicked on Get Another Max Router button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl();// http://shop.surfboard.com
			try {
				if (webURL.equalsIgnoreCase("http://shop.surfboard.com")) {
					driver.getPageSource();
					if (driver.findElement(By.xpath("//android.view.View[@content-desc='Vertical Categories']")).isDisplayed() && driver.findElement(By.xpath(
											"//android.view.View[@content-desc=' SIGN IN']/android.widget.TextView[2]]")).isDisplayed())
						utils.log().info("On shop.surfboard.com web page");
					else
						utils.log().info("shop.surfboard.com web page is not displayed");
				}
			} catch (Exception e) {
				utils.log().info("Unable to fetch Self Help Web Page objects");
			}
			
			if (driver != null)
				driver.quit();
			
			super.getDriver().context("NATIVE_APP");
			utils.log().info("Switched to NATIVE_APP View");
			//((PressesKey) super.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickSelfHelp() {
		try {
			click(selfHelpButton);
			super.pause(5);
			utils.log().info("Help Page - Clicked on Self Help button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl(); // arris.secure.force.com/consumers
			try {
				if (webURL.contains("arris.secure.force.com/consumers/")) {
					driver.getPageSource();
					driver.findElement(By.id("onetrust-close-btn-container")).click();
					driver.findElement(By.id("closeButton")).click();
					if (driver.findElement(By.xpath("//android.view.View[@content-desc='ARRIS Horizontal Logo']/android.widget.Image")).isDisplayed())
						utils.log().info("On arris.secure.force.com/consumers web page");
					else
						utils.log().info("arris.secure.force.com/consumers web page is not displayed");
				}
			} catch (Exception e) {
				utils.log().info("Unable to fetch Self Help Web Page objects");
			}
			super.getDriver().context("NATIVE_APP");
			utils.log().info("Switched to NATIVE_APP View");
			((PressesKey) super.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));

			if (driver != null)
				driver.quit();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickLiveChatHelp() {
		try {
			click(selfHelpButton);
			super.pause(5);
			utils.log().info("Help Page - Clicked on Chat With Us button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl();
			// www5.nohold.net/Arris/ukp.aspx?pid=15&login=1&alt1=app&alt2=mAX+Pro+W31&model=mAX+Pro+W31&donelr=1
			if (webURL.contains(
					"www5.nohold.net/Arris/ukp.aspx?pid=15&login=1&alt1=app&alt2=mAX+Pro+W31&model=mAX+Pro+W31&donelr=1")) {
				driver.getPageSource();
				if (driver
						.findElement(
								By.xpath("//android.view.View[@content-desc='Change Product']/android.widget.TextView"))
						.isDisplayed()
						&& driver
								.findElement(By
										.xpath("//android.view.View[@content-desc='Feedback']/android.widget.TextView"))
								.isDisplayed())
					utils.log().info("On www5.nohold.net/Arris/ukp.aspx web page");
				else
					utils.log().info("www5.nohold.net/Arris/ukp.aspx web page is not displayed");
			}
			super.getDriver().context("NATIVE_APP");
			utils.log().info("Switched to NATIVE_APP View");
			((PressesKey) super.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));

			if (driver != null)
				driver.quit();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	public String getUserAccountName() {
//		return accountName.getText();
//	}
//
	public String getUserEmailAddress() {
		return emailAddress.getText();
	}

	@Override
	public boolean isAt() {
		if (accountSettingsTitle.isDisplayed()) {
			utils.log().info("On Settings Page");
			return true;
		} else {
			utils.log().info("Not on Settings Page");
			return false;
		}
	}

	public boolean isAtAboutPage() {
		if (aboutTitle.isDisplayed()) {
			utils.log().info("On About Page");
			return true;
		} else {
			utils.log().info("Not on About Page");
			return false;
		}
	}

	public boolean isAtHelpPage() {
		if (helpTitle.isDisplayed()) {
			utils.log().info("On Help Page");
			return true;
		} else {
			utils.log().info("Not on Help Page");
			return false;
		}
	}
}
