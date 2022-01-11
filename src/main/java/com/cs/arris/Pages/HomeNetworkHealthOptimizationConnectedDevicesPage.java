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

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeNetworkHealthOptimizationConnectedDevicesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Network Optimization Settings\"]")
	public MobileElement backButton; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Connected Devices\"]")
	public MobileElement connectedDevicesTitle; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Sensitivity_Connected_Devices_Recommendation_Screen_Label\"]")
	public MobileElement recommendedSensitivityLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"NH_Sensitivity_Connected_Devices_Recommendation_Screen_Image\"]")
	public MobileElement image; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Sensitivity_Connected_Devices_Recommendation_Screen_Label_Signal\"]")
	public MobileElement recommendationText; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Sensitivity_Connected_Devices_Recommendation_Screen_Label_Title\"]")
	public MobileElement whenToRecommendText; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Sensitivity_Connected_Devices_Recommendation_Screen_Label_Detail\"]")
	public MobileElement recommendation; 
	
	
	public HomeNetworkHealthOptimizationConnectedDevicesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
		public boolean clickBackButton() {
			if (backButton.isDisplayed()) {
				click(backButton);
				utils.log().info("Clicked on Back Button");
				return true;
			} else {
				utils.log().info("Back Button is not displayed");
				return false;
			}
		}
		
	 
	 public boolean verifyConnectedDevicesPageUI() {
			
			utils.log().info("                                                                                       ");
			utils.log().info("***************************************************************************************");
			utils.log().info("Details of UI Elements on Network Health Optimization Settings - Connected Devices Page");
			utils.log().info("***************************************************************************************");
			try {
				if (connectedDevicesTitle.isDisplayed())
					utils.log().info(connectedDevicesTitle.getText() + " title text is displayed");
				else
					utils.log().info("Connected Devices title text is not displayed");

				if (backButton.isDisplayed())
					utils.log().info("Back button is displayed");
				else
					utils.log().info("Back button is not displayed");
				
				if (recommendedSensitivityLabel.isDisplayed())
					utils.log().info(recommendedSensitivityLabel.getText() + " is displayed");
				else
					utils.log().info("Sensitivity Text is not displayed");
				
				try{
					if (recommendationText.isDisplayed())
						utils.log().info("Recommendation : " + recommendationText.getText() + " text is displayed");
				}catch(Exception e) {
					utils.log().info("Recommendation is not displayed");
				}
				
				try{
					if (whenToRecommendText.isDisplayed())
						utils.log().info(whenToRecommendText.getText() + " label is displayed");
				}catch(Exception e) {
					utils.log().info("When do you get this recommendation? text is not displayed");
				}
				
				try{
					if (recommendation.isDisplayed())
						utils.log().info(recommendation.getText() + " message is displayed");
				}catch(Exception e) {
					utils.log().info("Recommendation message is not displayed");
				}

				return true;
			} catch (Exception e) {
				return false;
			}
		}
	 
	@Override
	public boolean isAt() {
		if(connectedDevicesTitle.isDisplayed())
		{
			utils.log().info("On Network Health Optimization Settings - Connected Devices Page");
			return true;}
		else {
			utils.log().info("Not on Network Health Optimization Settings - Connected Devices Page");
		return false;}
	}
}
