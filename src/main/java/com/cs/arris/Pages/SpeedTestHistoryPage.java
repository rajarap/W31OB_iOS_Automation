package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SpeedTestHistoryPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //Speed Test History
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[338,149][742,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement speedTestHistoryTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //Navigate up
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	public MobileElement homeButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/network_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[362,2000][717,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/network_view") 
	})
	public MobileElement networkButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/parental_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[724,2000][1080,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/parental_view") 
	})
	public MobileElement parentalButton; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/speed_test_history")
	public MobileElement speedTestHistoryDinning;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/speed_test_time']")
	public MobileElement speedTestHistoryDateTime;
	
	@AndroidFindBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/wifi_speed_test_View']")
	public MobileElement speedTestHistoryView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/run_speed_test_again")
	public MobileElement runTestAgainButton;
	
	public SpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickHomeButton()
	{
		click(homeButton);
		utils.log().info("Speed Test History Page - Clicked on Home button");
	}
	
	//click back icon on notification page
	public void clickBackIcon()
	{
		click(backIcon); 
		utils.log().info("Speed Test History Page - Clicked on Back Button");
	}
	
	public void clickHelpIcon()
	{
		click(helpIcon); 
		utils.log().info("Speed Test History Page - Clicked on Help Button");
	}
	
	public void clickNetworkButton()
	{
		click(networkButton);
		utils.log().info("Speed Test History Page - Clicked on Network Button");
	}
	
	public void clickParentalButton()
	{
		click(parentalButton);
		utils.log().info("Speed Test History Page - Clicked on Parental Button");
	}
	
	public void verifySpeedTestHistory()
	{
		utils.log().info("Speed Test History Details");
		utils.log().info("**************************");
		
		List<MobileElement> speedTestHistory = (List<MobileElement>) super.getDriver().findElementsById("com.arris.sbcBeta:id/speed_test_history");
		int size = speedTestHistory.size();
		
		for (int i = 1; i <= speedTestHistory.size() ; i++)
		{
			if (speedTestHistory.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/speed_test_time") && speedTestHistory.get(i).isDisplayed())
			{
				utils.log().info("Speed Test History Time :" + speedTestHistoryDateTime.getText());
			}
			
			if (speedTestHistory.get(i).getAttribute("resource-id").equalsIgnoreCase("com.arris.sbcBeta:id/wifi_speed_test_View") && speedTestHistory.get(i).isDisplayed())
			{
				utils.log().info("Speed Test History - Download and Upload from Device to Router to Internet is displayed");
			}
		}
	}
	
	public void clickRunTestAgainButton()
	{
		click(runTestAgainButton);
		utils.log().info("Speed Test History Page - Clicked on Run Test Again button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
}
