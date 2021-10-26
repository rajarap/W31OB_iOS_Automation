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

public class ParentalControlPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_congratulations]"),  //CONTINUE
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1926][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_congratulations") 
	})
	public MobileElement continueButton; 
	
	public ParentalControlPage()
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
