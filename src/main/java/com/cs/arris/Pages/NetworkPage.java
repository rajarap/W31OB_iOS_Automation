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

public class NetworkPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	HomePage homePage;
	NetworkPage networkPage;
	ParentalControlPage parentalControlPage;
	FooterIconsPage footerIconsPage ;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"),  //Online
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[450,149][631,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement networkTitleText; 
	
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	

	public NetworkPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public HomePage getHomePageObject()
	{
		homePage = new HomePage();
		return homePage;
	}
	
	 public NetworkPage getNetworkPageObject() {
		 networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public ParentalControlPage getParentalControlPageObject() {
		 parentalControlPage = new ParentalControlPage();
	     return parentalControlPage;
	  }
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	
	public void verifyUIOnNetworkPage()
	{

		utils.log().info("on Network Page");
	}
	
	public void clickBackButton()
	{
		click(backButton);
		utils.log().info("Network Page - Clicked on Back Button");
	}
	
	public void clickHomeButton()
	{
		homePage.getFooterIconsPageObject().clickHomeButton();
		utils.log().info("Network Page - Clicked on Home Button");
	}
	
	public void clickNetworkButton()
	{
		homePage.getFooterIconsPageObject().clickNetworkButton();
		utils.log().info("Network Page - Clicked on Network Button");
	}
	
	public void clickParentalButton()
	{
		homePage.getFooterIconsPageObject().clickParentalButton();
		utils.log().info("Network Page - Clicked on Parental Button");
	}
	
	public void clickHelpButton()
	{
		click(helpIcon);
		utils.log().info("Network Page - Clicked on Help Button");
	}
	
	@Override
	public boolean isAt() {
		if(networkTitleText.isDisplayed())
		{
			utils.log().info("On Network Page");
			return true;}
		else {
			utils.log().info("Not on Network Page");
		return false;}
	}
}
