package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SiginPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/need_help']") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") 
	public MobileElement welcomeMessage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") 
	public MobileElement accessAccountMessage;
	
//	@AndroidFindBy (xpath = "com.arris.sbcBeta:id/tvEmail") 
//	public MobileElement signinEmailAddressLabel;
	
	@AndroidFindBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etEmail']") 
	public MobileElement emailAddress;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnSubmit']") 
	public MobileElement signinButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_notYetRegistered']") 
	public MobileElement signinNotRegisteredYetText;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/tvCreateAccount']") 
	public MobileElement signUpButton;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ic_back_icon']") 
	public MobileElement signinBackButton;
	
	public SiginPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean enterEmailAddress(String email)
	{
		sendKeys(emailAddress, email);
		utils.log().info("Sigin Page - Entered user email address");
		return true;
	}
	
	public boolean clickSigninButton()
	{
		if(signinButton.isEnabled())
		{
			click(signinButton);
			utils.log().info("Sigin Page - Clicked on Signin Button");
		}
		return true;
	}
	
	public void clickSignUpButton()
	{
		click(signUpButton);
		utils.log().info("Sigin Page - Clicked on SignUp Button");
	}
	
	@Override
	public boolean isAt() {
		if(signinButton.isDisplayed())
		{
			utils.log().info("At Signin Page");
			return true;
		}
		else
		{
			utils.log().info("Signin Page is not displayed");
			return false;
		}
	}
	
}
