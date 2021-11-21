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
	public List<MobileElement> me;
	public int counter = 1;
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
	public MobileElement speedTestHistoryDinning;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/date']")
	public List<MobileElement> speedTestHistoryDateTime;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/left_speed_test_icon']")
	public List<MobileElement>  speedTestHistoryDeviceImage;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/router_image']")
	public List<MobileElement>  speedTestHistoryRouterImage;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/right_speed_test_icon']")
	public List<MobileElement>  speedTestHistoryInternetImage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']")
	public List<MobileElement>  speedTestHistoryDeviceName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/routerName']")
	public List<MobileElement>  speedTestHistoryRouterName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Internet']")
	public List<MobileElement>  speedTestHistoryInternetName;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Download']")
	public List<MobileElement>  wifiDownloadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Upload']")
	public List<MobileElement>  wifiUploadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Download']")
	public List<MobileElement>  internetDownloadText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Upload']")
	public List<MobileElement>  internetUploadText;

	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiDownloadSpeed']")
	public List<MobileElement>  wifiDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiUploadSpeed']")
	public List<MobileElement>  wifiUploadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetDownloadSpeed']")
	public List<MobileElement>  internetDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetUploadSpeed']")
	public List<MobileElement>  internetUploadSpeed;
	
	public HomeSpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public SpeedTestPage getSpeedTestPageObject() {
		 SpeedTestPage speedTestPage = new SpeedTestPage();
	     return speedTestPage;
	  }
	 
		public boolean verifyHomeSpeedTestHistory() {
			try {
				utils.log().info("*************************************");
				utils.log().info("Details of Speed Test History Details");
				utils.log().info("*************************************");

				utils.log().info("Title : " + speedTestHistoryTitle.getText());
				MobileElement recycleView = (MobileElement) super.getDriver().findElementByXPath(
						"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView");

				for (int i = 1; i <= 3; i++) {
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
							"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
									+ i + "]");
					for (MobileElement m : entity) {
						utils.log().info("Speed Test History : " + counter);
						utils.log().info("------------------------------");
						if (m.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/left_speed_test_icon']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");

						if (m.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/router_image']")
								.isDisplayed())
							utils.log().info("Router Image is displayed");

						if (m.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/right_speed_test_icon']")
								.isDisplayed())
							utils.log().info("Internet Image is displayed");

						utils.log()
								.info("Date and Time: " + m
										.findElementByXPath(
												"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/date']")
										.getText());
						utils.log()
								.info("Device Name : " + m.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/deviceName']")
										.getText());
						utils.log()
								.info("Router Name : " + m.findElementByXPath(
										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/routerName']")
										.getText());
						utils.log().info("Internet Name : "
								+ m.findElementByXPath("//android.widget.TextView[@text='Internet']").getText());
						utils.log().info("Wifi Download Text : "
								+ m.findElementByXPath("//android.widget.TextView[@text='Download']").getText());
						utils.log().info("Wifi Download Speed: " + m.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiDownloadSpeed']")
								.getText());
						utils.log().info("Wifi Upload Text : "
								+ m.findElementByXPath("//android.widget.TextView[@text='Upload']").getText());
						utils.log().info("Wifi Upload Speed: " + m.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifiUploadSpeed']")
								.getText());
						utils.log().info("Internet Download Text : "
								+ m.findElementByXPath("//android.widget.TextView[@text='Download']").getText());
						utils.log().info("Internet Download Speed: " + m.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetDownloadSpeed']")
								.getText());
						utils.log().info("Internet Upload Text	: "
								+ m.findElementByXPath("//android.widget.TextView[@text='Upload']").getText());
						utils.log().info("Internet Upload Speed : " + m.findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internetUploadSpeed']")
								.getText());
						utils.log().info("****************************************************");
						counter++;
					}
					if (i == 2)
						super.swipeUp();
				}
				return true;
			} catch (Exception e) {
				return false;
			}
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
