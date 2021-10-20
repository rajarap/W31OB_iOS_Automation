package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class GetStartedPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	SoftAssert softAssert;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_welcome_one']") 
	private MobileElement getStartedMessage;
	
	@AndroidFindBy (xpath ="//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/welcome_one_circle_bg']")
	private MobileElement getStartedImage;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_start_welcome"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_start_welcome']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1968][1019,2042]']")
	})
	private MobileElement getStartedButton;
	
	public GetStartedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickGetStartedButton() 
	{
		click(getStartedButton);
		utils.log().info("Get Started - Clicked on Get Started Button");

	}
		
	public void getGetStartedImage()
	{
		if(getStartedImage.isDisplayed())
			utils.log("Get Started Image is displayed");
		else
		{
			utils.log("Image on the Get Started page is not displayed");
		}
	}
	
	  public String getGetStartedMessage() 
	  {
		  return getStartedMessage.getText();
		  //String expectedlGetStartedMessage = super.getStrings().get("get_started_page_message");

	  }
	
	public String getGetStartedButtonText()
	{
		return getStartedButton.getText();
		//String expectedlGetStartedButtonText = super.getStrings().get("get_started_page_get_started_button_text");
	}

	@Override
	public boolean isAt() {
		if(getStartedButton.isDisplayed())
		{
			utils.log().info("At Get Started Page displayed");
			return true;
		}
		else
		{
			utils.log().info("Get Started Page is not displayed");
			return false;
		}
	}
}
