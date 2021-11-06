package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FAQHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") //Help
	public MobileElement helpTitle; 
	
	@AndroidFindAll({ 
		@AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), // back button
		@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
		public MobileElement backButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text")
	//Search product FAQs here and get answers to you most pressing issues.
	public MobileElement titleText;
	
	@AndroidFindBy (id = "android:id/search_src_text") //Search FAQs by keywords...
	public MobileElement searchText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/searchButton")  //SEARCH
	public MobileElement searchButton;

	@AndroidFindBy (xpath = "//android.view.View[@content-desc='GENERAL mAX']/android.widget.TextView")
	public MobileElement generalMaxLink;
	
	

	public FAQHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton()
	{
		click(backButton);
		utils.log().info("FAQ Help Page - Clicked on Back Button");
	}
	
	public void verifyUIOnFAQHelpPage()
	{
		if (helpTitle.isDisplayed())
			utils.log().info("Title : "+ helpTitle.getText() +" is displayed");
		else
			utils.log().info("Help Title is not displayed");
		
		if (titleText.isDisplayed())
			utils.log().info(titleText.getText() + " text is displayed");
		else
			utils.log().info("FAQ Help Message is not displayed");
		
		if (searchText.isDisplayed())
			utils.log().info("Search Text : " + searchText.getText()+ " is displayed");
		else
			utils.log().info("Search Text is not displayed");
		
		if (searchButton.isDisplayed())
			utils.log().info("Search Button is displayed");
		else
			utils.log().info("Search Button is not displayed");
		
		if (generalMaxLink.isDisplayed())
			utils.log().info("Link : " + generalMaxLink.getText() + " is displayed");
		else
			utils.log().info("General Max Link is not displayed");
	}
	
	@Override
	public boolean isAt() {
		if(helpTitle.isDisplayed())
		{
			utils.log().info("On FAQ Help Page");
			return true;}
		else {
			utils.log().info("Not on FAQ Help Page");
		return false;}
		
	}

}
