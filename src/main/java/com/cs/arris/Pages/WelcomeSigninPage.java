package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeSigninPage  extends ParentClass implements Page
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
	
	public WelcomeSigninPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enterEmailAddress(String email)
	{
		sendKeys(emailAddress, email);
	}
	
	public void clickSigninButton()
	{
		if(signinButton.isEnabled())
		{
			click(signinButton);
		}
	}
	
	public void clickSignUpButton()
	{
		click(signUpButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
