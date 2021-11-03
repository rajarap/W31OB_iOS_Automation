package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeSpeedTestHistoryPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public MobileElement me;
	public int counter = 2;
	int size;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtHeader]"),  //Speed Test History
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[101,311][482,380]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtHeader") 
	})
	public MobileElement speedTestHistoryTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/speed_test_history']"), 
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView"),
		@AndroidBy (id = "com.arris.sbcBeta:id/speed_test_history") 
	})
	public List<MobileElement> speedTestHistoryDinning;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/date']")
	public List<MobileElement> speedTestHistoryDateTime;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/left_speed_test_icon']")
	public List<MobileElement> speedTestHistoryDeviceImage;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/router_image']")
	public List<MobileElement> speedTestHistoryRouterImage;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/right_speed_test_icon']")
	public List<MobileElement> speedTestHistoryInternetImage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']")
	public List<MobileElement> speedTestHistoryDeviceName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/routerName']")
	public List<MobileElement> speedTestHistoryRouterName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Internet']")
	public List<MobileElement> speedTestHistoryInternetName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Download']")
	public List<MobileElement> wifiDownloadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Upload']")
	public List<MobileElement> wifiUploadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Download']")
	public List<MobileElement> internetDownloadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Upload']")
	public List<MobileElement> internetUploadText;

	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiDownloadSpeed']")
	public List<MobileElement> wifiDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiUploadSpeed']")
	public List<MobileElement> wifiUploadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetDownloadSpeed']")
	public List<MobileElement> internetDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetUploadSpeed']")
	public List<MobileElement> internetUploadSpeed;
	
	public HomeSpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void verifyHomeSpeedTestHistory()
	{
		utils.log().info("Size of Speed Test History is : " + size);
		utils.log().info("Home - Speed Test History Details");
		utils.log().info("**********************************");
		
		for(int i = 0 ; i < 3 ; i++)
		{
//			new SwipeActions().swipeScreen(Direction.UP);

			me = (MobileElement) super.getDriver().findElementByXPath("//android.view.ViewGroup[@index="+i+"]");		
			if (i < 2 && me.isDisplayed())
			{
				utils.log().info("Speed Test History : " + i);
				utils.log().info("----------------------------------------------------------------------");
				utils.log().info("Speed Test Date-Time		: " + speedTestHistoryDateTime.get(i).getText());
				utils.log().info("Device Name			: " + speedTestHistoryDeviceName.get(i).getText());
				utils.log().info("Router Name			: " + speedTestHistoryRouterName.get(i).getText());
				utils.log().info("Internet Name			: " + speedTestHistoryInternetName.get(i).getText());
				utils.log().info("Wifi Download Text		: " + wifiDownloadText.get(i).getText());
				utils.log().info("Wifi Download Speed		: " + wifiDownloadSpeed.get(i).getText());
				utils.log().info("Wifi Upload Text		: " + wifiUploadText.get(i).getText());
				utils.log().info("Wifi Upload Speed		: " + wifiUploadSpeed.get(i).getText());
				utils.log().info("Internet Download Text	: " + internetDownloadText.get(i).getText());
				utils.log().info("Internet Download Speed	: " + internetDownloadSpeed.get(i).getText());
				utils.log().info("Internet Upload Text	 	: " + internetUploadText.get(i).getText());
				utils.log().info("Internet Upload Speed	 	: " + internetUploadSpeed.get(i).getText());
				utils.log().info("----------------------------------------------------------------------");
				utils.log().info("");
			}
//			else
//			{
//				new SwipeActions().swipeScreen(Direction.UP);
//				super.pause(5);
//				me = (MobileElement) super.getDriver().findElementByXPath("//android.view.ViewGroup[@index="+i+"]");
//				if (i >= size-- && me.isDisplayed())
//				{
//					utils.log().info("Speed Test History : " + i++);
//					utils.log().info("-------------------------");
//								
//					utils.log().info("Speed Test Date-Time		: " + speedTestHistoryDateTime.get(i).getText());
//					utils.log().info("Device Name				: " + speedTestHistoryDeviceName.get(i).getText());
//					utils.log().info("Router Name				: " + speedTestHistoryRouterName.get(i).getText());
//					utils.log().info("Internet Name				: " + speedTestHistoryInternetName.get(i).getText());
//					utils.log().info("Wifi Download Text		: " + wifiDownloadText.get(i).getText());
//					utils.log().info("Wifi Download Speed		: " + wifiDownloadSpeed.get(i).getText());
//					utils.log().info("Wifi Upload Text			: " + wifiUploadText.get(i).getText());
//					utils.log().info("Wifi Upload Speed			: " + wifiUploadSpeed.get(i).getText());
//					utils.log().info("Internet Download Text	: " + internetDownloadText.get(i).getText());
//					utils.log().info("Internet Download Speed	: " + internetDownloadSpeed.get(i).getText());
//					utils.log().info("Internet Upload Text	 	: " + internetUploadText.get(i).getText());
//					utils.log().info("Internet Upload Speed	 	: " + internetUploadSpeed.get(i).getText());
//				}
//			}
		}
	}
	
	public HomePage getHomePageObject()
	{
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	 public NetworkPage getNetworkPageObject() {
		 NetworkPage networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public ParentalControlPage getParentalControlPageObject() {
		 ParentalControlPage parentalControlPage = new ParentalControlPage();
	     return parentalControlPage;
	  }
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public SpeedTestPage getSpeedTestPageObject() {
		 SpeedTestPage speedTestPage = new SpeedTestPage();
	     return speedTestPage;
	  }
	
	@Override
	public boolean isAt() {
		if(speedTestHistoryTitle.isDisplayed())
		{
			utils.log().info("On Speed Test History Page");
			return true;}
		else {
			utils.log().info("Not on Speed Test History Page");
		return false;}
	}
}
