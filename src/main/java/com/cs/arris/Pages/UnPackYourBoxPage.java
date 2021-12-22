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

public class UnPackYourBoxPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_routersetUp_two']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1915][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_routersetUp_two") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Unpack_Box_Screen_Button\"]")
	public MobileElement nextButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = LET'S SET UP YOUR HOME NETWORK
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Unpack_Box_Screen_TitleLabel\"]")
	public MobileElement letsUnpackYouBoxText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") // text = You are only a few steps away from setting up your home network.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Unpack_Box_Screen_SubTitleLabel\"]")
	public MobileElement routerAndPoweCableInsideBoxText;
	
	public UnPackYourBoxPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	
	public void clickNextButton()
	{
		utils.log().info("UnPack your Box Page - Clicked on Next Button");
		click(nextButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
