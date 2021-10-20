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

public class SetupHomeNetworkPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_routerSetup']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1915][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_routerSetup") 
	})
	public MobileElement nextButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = LET'S SET UP YOUR HOME NETWORK
	public MobileElement setupHomeNetworkText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") // text = You are only a few steps away from setting up your home network.
	public MobileElement fewStepsAwayText;
	
	public SetupHomeNetworkPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		utils.log().info("Setup Home Network Page - Clicked on Next Button");
		click(nextButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
