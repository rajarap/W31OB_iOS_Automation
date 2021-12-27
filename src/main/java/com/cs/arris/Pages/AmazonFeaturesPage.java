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

public class AmazonFeaturesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;

	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Amazon Features\"])[2]")
	public MobileElement amazonTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_surfboard_logo") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]")
	public MobileElement amazonSurfboardImage;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable/Disable Amazon Frustration Free Setup Feature']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enable/Disable Amazon Frustration Free Setup Feature\"]")
	public MobileElement enableDisableAFFSText;

	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/affs_enable_disable' and @checked='false']") 
	@iOSXCUITFindBy(xpath = "**/XCUIElementTypeSwitch[`value == \"0\"`]")
	public MobileElement disableAFFSToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/affs_enable_disable' and @checked='true']") 
	@iOSXCUITFindBy(xpath = "**/XCUIElementTypeSwitch[`value == \"1\"`]")
	public MobileElement enableAFFSToggleButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/affs_des_click") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"This is an Amazon feature enabling simpler smart device setup. For more information, please tap here\"]")
	public MobileElement pleaseTapHere;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/title_text") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Get Alexa Skills\"]")
	public MobileElement getAlexaSkillsButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/item1_text_title") 
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\" (1) Open the Amazon Alexa app.\"])[1]")
	public MobileElement alexaSkillsContent;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/pas") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Password\"]")
	public MobileElement passwordLabel;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/password") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
	public MobileElement passwordTextBox;
	
	@AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc='Show password']") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"eyeIcon\"]")
	public MobileElement showpassword;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/imageButtonCopy") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"copy\"]")
	public MobileElement passwordCopyButton;
		
	@AndroidFindBy(id = "com.arris.sbcBeta:id/tv_bottom") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"www.amazon.com/alexaskills\"]")
	public MobileElement alexaSkillsLink;
	
	
	//Password Copied Dialog
	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Password Copied\"]")
	public MobileElement passworkCopiedText;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
	public MobileElement okbutton;
	
	
	
	public AmazonFeaturesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public AmazonWiFiSimpleSetupDialog getAmazonWifiSimpleSetupPageObject() {
		AmazonWiFiSimpleSetupDialog simpleSetupPage = new AmazonWiFiSimpleSetupDialog();
		return simpleSetupPage;
	}

	public AFFSHelpPage getAFFSHelpPageObject() {
		AFFSHelpPage affsHelpPage = new AFFSHelpPage();
		return affsHelpPage;
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
	
	public boolean enableAFFS() {
		if (disableAFFSToggleButton.isDisplayed()) {
			click(disableAFFSToggleButton);
			utils.log().info("Amazon Frustration Free Setup Feature is enabled");
			return true;
		}else {
			utils.log().info("Amazon Frustration Free Setup Feature is already enabled");
			return false;
		}
	}
	
//} else if (enableAFFSToggleButton.isDisplayed()) {
//	utils.log().info("Amazon Frustration Free Setup Feature is already enabled");
//	return true;

	public boolean disableAFFS() {
		if (enableAFFSToggleButton.isDisplayed()) {
			click(enableAFFSToggleButton);
			utils.log().info("Amazon Frustration Free Setup Feature is disabled");
			return true;
		} else {
			utils.log().info("Amazon Frustration Free Setup Feature is already disabled");
			return false;
		}
	}
	
//} else if (disableAFFSToggleButton.isDisplayed()) {
//	utils.log().info("Amazon Frustration Free Setup Feature is already disabled");
//	return true;

	public boolean clickGetAlexaSkillsButton() {
		if (getAlexaSkillsButton.isDisplayed()) {
			click(getAlexaSkillsButton);
			super.swipeUp();
			utils.log().info("Clicked on Get Alexa Skills Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickAlexaSkillsButtonAgain() {
		if (getAlexaSkillsButton.isDisplayed()) {
			click(getAlexaSkillsButton);
			return true;
		} else {
			return false;
		}
	}

	public boolean clickShowPasswordButton() {
		if (showpassword.isDisplayed()) {
			click(showpassword);
			utils.log().info("Clicked on Show Password Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCopyPasswordButton() {
		if (passwordCopyButton.isDisplayed()) {
			click(passwordCopyButton);
			utils.log().info("Clicked on Copy Password Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getPasswordText() {
		if (passwordTextBox.isDisplayed()) {
			utils.log().info("Password is : " + passwordTextBox.getText());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCopyPasswordOKButton()
	{
		if(passworkCopiedText.isDisplayed())
		{
			utils.log().info(passworkCopiedText.getText());
			if (okbutton.isDisplayed()) {
				click(okbutton);
				utils.log().info("Clicked on Copy Password Ok button");
			}		
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyUIOnAFFSPage() {
		utils.log().info("****************************************************");
		utils.log().info("Details of UI Elements on the Amazon Features Page  ");
		utils.log().info("****************************************************");
		try {
			if (amazonTitle.isDisplayed())
				utils.log().info("Title " + amazonTitle.getText() + " is displayed");
			else
				utils.log().info("Amazon Feature title is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back Button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (amazonSurfboardImage.isDisplayed())
				utils.log().info("Amazon Surfboard Image is displayed");
			else
				utils.log().info("Amazon Surfboard Image is not displayed");
			
			if (enableDisableAFFSText.isDisplayed())
				utils.log().info(enableDisableAFFSText.getText() + " text is displayed");
			else
			utils.log().info("Enable/Disable AFFS text is not displayed");
			
			try {
				if (disableAFFSToggleButton.isDisplayed())
					utils.log().info("AFFS is currently disabled");
				else if(enableAFFSToggleButton.isDisplayed())
					utils.log().info("AFFS is currently enabled");
				else
					utils.log().info("AFFS Toggle button is not displayed");
			}catch(Exception t) {
				utils.log().info("AFFS Toggle button is not displayed");
			}

			if (pleaseTapHere.isDisplayed())
				utils.log().info(pleaseTapHere.getText() + " is displayed");
			else
				utils.log().info("Please Tap Here text is not displayed");

			if (getAlexaSkillsButton.isDisplayed())
				utils.log().info(getAlexaSkillsButton.getText() + " is displayed");
			else
				utils.log().info("Get Alexa Skills text is not displayed");

			if (passwordLabel.isDisplayed())
				utils.log().info(passwordLabel.getText() + " label is displayed");
			else
				utils.log().info("Password Label is not displayed");

			if (passwordTextBox.isDisplayed())
				utils.log().info("Text box to enter password is displayed");
			else
				utils.log().info("Text box to enter password is not displayed");
			
			if (showpassword.isDisplayed())
				utils.log().info("Show password icon is displayed");
			else
				utils.log().info("Show password icon is not displayed");
			
			if (passwordCopyButton.isDisplayed())
				utils.log().info("Password copy button is displayed");
			else
				utils.log().info("Password copy button is not displayed");
			
			if (alexaSkillsLink.isDisplayed())
				utils.log().info("Alexa Skills link is displayed");
			else
				utils.log().info("Alexa Skills link  is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAlexaSkillsLink() {
		try {
			click(alexaSkillsLink);
			super.pause(5);
			utils.log().info("Clicked on " + alexaSkillsLink.getText() +  " link");	
			
			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(alexaSkillsLink.getText());
			String webURL = driver.getCurrentUrl();
			try {
				if (webURL.equalsIgnoreCase(alexaSkillsLink.getText())) {
					driver.getPageSource();
					if (driver.findElement(By.xpath("//android.webkit.WebView[@text='Alexa Skills and Features | Amazon.com']")).isDisplayed())
						utils.log().info("On www.amazon.com/alexaskills web page");
					else
						utils.log().info("www.amazon.com/alexaskills web page is not displayed");
				}
			} catch (Exception e) {
				utils.log().info("Unable to fetch alexa skills Web Page objects");
			}
			
			if (driver != null)
				driver.quit();
			
			
			super.getDriver().context("NATIVE_APP");
			utils.log().info("Switched to NATIVE_APP View");
			//((PressesKey) super.getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
			super.getDriver().activateApp("com.arris.sbcBeta");
   
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickPleaseTapHereLink() {
		try {
			click(pleaseTapHere);
			super.pause(5);
			utils.log().info("Clicked on Please Tap Here Link");
						
			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl(); 
			try {
				if (webURL.contains("amazon.com/gp/help/customer/")) {
//					driver.getPageSource();
					if (driver
							.findElement(By.xpath("//android.view.View[@content-desc='Where's My Stuff?'])[1]/android.view.View/android.widget.TextView[2]")).isDisplayed())
						utils.log().info("On amazon.com/gp/help/customer web page");
					else
						utils.log().info("amazon.com/gp/help/customer web page is not displayed");
				}
			} catch (Exception e) {
				utils.log().info("Unable to fetch amazon.com/gp/help/customer web page objects");
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

	@Override
	public boolean isAt() {
		if (amazonTitle.isDisplayed()) {
			utils.log().info("On Amazon Features Page");
			return true;
		} else {
			utils.log().info("Not on Amazon Features Page");
			return false;
		}
	}
}
