package com.cs.arris.Pages;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CodeVerifiedPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	public MobileElement codeVerifiedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/success_icon") 
	public MobileElement successIcon;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/user_email_id_success']")
	@AndroidFindBy (id = "com.arris.sbcBeta:id/user_email_id_success") 
	public MobileElement emailAddress;
	
	//@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/next_button']");
	@AndroidFindBy (id = "com.arris.sbcBeta:id/next_button")
	public MobileElement nextButton;
	
	public void clickNextButton()
	{
		click(nextButton);
	}
	
	public void getCodeVerifiedText()
	{
		System.out.println(codeVerifiedText.getText());
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
