package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeSignupPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public String email;
	public RandomEmailAddress random;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/need_help']") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") 
	public MobileElement welcomeMessage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") 
	public MobileElement createAccountMessage;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etRegistrationEmail"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,602][1029,710]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etRegistrationEmail']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText") 
	})
	public MobileElement emailAddress;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etFirstName"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,793][506,901]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etFirstName']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText") 
	})
	public MobileElement firstName;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etLastName"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[540,793][995,901]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etLastName']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText") 
	}) 
	public MobileElement lastName;
	
	@AndroidFindBy (xpath = "//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/cbtermsandcondition']")  
	public MobileElement agreeCheckBox;
	
	@AndroidFindBy (xpath = "//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/cbupdatesagreement']")   
	public MobileElement recieveUpdateCheckBox;
	
//	@AndroidFindAll({
//		@AndroidBy (id = "com.arris.sbcBeta:id/btnSignUp"),
//		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnSignUp']"),
//		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,1320][1029,1457]']")
//	})
	@AndroidFindBy (id = "com.arris.sbcBeta:id/btnSignUp")
	public MobileElement signupButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/already_having_an_accountTV']")
	public MobileElement alreadyRegisteredMessage;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/already_having_an_account']") 
	public MobileElement signinButton;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ic_back_icon']") 
	public MobileElement backButton;
	
	public WelcomeSignupPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enterValidEmailAddress(String email)
	{
		sendKeys(emailAddress, email);
		utils.log("Entering user email address");

	}
	
	public void enterFirstName(String fname)
	{
		sendKeys(firstName, fname);
		utils.log("Entering user first name");

	}
	
	public void enterLastName(String lname)
	{
		sendKeys(lastName, lname);
		utils.log("Entering user last name");

	}
	
	public void clickSignupButton()
	{
		click(signupButton);
	}
	
	public WelcomeSigninPage clickSignInButton()
	{
		click(signinButton);
		return new WelcomeSigninPage();
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
