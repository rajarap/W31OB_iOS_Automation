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

public class CongratulationsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_congratulations]"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1926][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_congratulations") 
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Congratulations_Screen_Button\"]")
	public MobileElement continueButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_congratulations") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_congratulations']") // text =CONGRATULATIONS
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Congratulations_Screen_TitleLabel\"]")
	public MobileElement congratulationsText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_f_connect_internet_desc") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_f_connect_internet_desc']") // text = You have successfully configured your router and home network
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Congratulations_Screen_SubTitleLabel\"]")
	public MobileElement connectRouterToWifiText;
	
	public CongratulationsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueButton()
	{
		click(continueButton);
		utils.log().info("Congratulations Page - Clicked on Continue Button");
	}
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
