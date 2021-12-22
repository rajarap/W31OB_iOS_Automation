package com.cs.arris.Pages;

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

public class NameYourNetwokSSIDPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnCreateNetwork']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1976][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btnCreateNetwork") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Network_Connect_Screen_Button\"]")
	public MobileElement nextButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = LET’S NAME YOUR HOME NETWORK
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Connect_Screen_TitleLabel\"]")
	public MobileElement nameYourHomeNetworkText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") // text = Enter a name and password for your home network that you will use to connect your devices.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Connect_Screen_SubTitleLabel\"]")
	public MobileElement enterNameAndPasswordForHomeNetworkText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etNetworkName']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,770][1019,882]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/etNetworkName") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Connect_Screen_TextField_SSIDName\"]")
	public MobileElement ssIDName;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etNetworkPassword']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,965][1019,1091]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/etNetworkPassword") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField[@name=\"Network_Connect_Screen_TextField_Password\"]")
	public MobileElement ssidPassword;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Previous\"]")
	public MobileElement previousLink;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Next\"]")
	public MobileElement nextLink;
	
	public NameYourNetwokSSIDPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enterSSIDName(String ssidName)
	{
		sendKeys(ssIDName, ssidName);
		utils.log().info("Name Your Network Page - Entered SSID Name");
	}
	
	public void enterSSIDPassword(String ssidpwd)
	{
		sendKeys(ssidPassword, ssidpwd);
		utils.log().info("Name Your Network Page - Entered SSID Password");
	}
	
	public void clickDoneLink()
	{
		click(doneLink);
		utils.log().info("Name Your Network Page  - Clicked on Done Button");
	}

	public void clickNextButton()
	{
		click(nextButton);
		utils.log().info("Name Your Network Page  - Clicked on Next Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}

