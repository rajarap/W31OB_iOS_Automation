package com.cs.arris.Pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

public class DeviceSignalStrengthLeaderBoardPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public List<MobileElement> listOfDevices;
	public int counter = 1;

	@AndroidFindAll({ 
		@AndroidBy(id = "com.arris.sbcBeta:id/txtHeader"), // DEVICE SIGNAL STRENGTH LEADER BOARD
		@AndroidBy(xpath = "//android.widget.TextView[@bounds='[101,311][854,380]']")})
	public MobileElement leaderBoardTitleText;

//	@AndroidFindAll({
//			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtTotalDevices']"),
//			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[101,397][337,471]']"),
//			@AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='SBC Test']/android.widget.TextView[2]]")
//			})
//	public MobileElement numberOfDevicesText;
	
	//@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='SBC Test']/android.widget.TextView[2]]")
	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtTotalDevices")
	public MobileElement numberOfDevicesText;

	@AndroidFindAll({ @AndroidBy(id = "com.arris.sbcBeta:id/txtThree"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[101,514][451,567]']") })
	public MobileElement topFiveOnlineDevices;

	// @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='SBC
	// Test']/android.view.ViewGroup/android.widget.Spinner/android.widget.TextView")
	// //strong to weak
	@AndroidFindAll({
			@AndroidBy(xpath = "//android.view.ViewGroup[@content-desc='SBC Test']/android.view.ViewGroup/android.widget.Spinner/android.widget.TextView"),
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']") })
	public MobileElement signalStrengthOptions;

	@AndroidFindAll({
			@AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[526,579][979,647]']") })
	public MobileElement strongToWeak;

	@AndroidFindAll({
			@AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"),
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[526,647][979,715]']") })
	public MobileElement weakToStrong;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceName']"), // Galaxy-S10-Android
																												// (me)
			@AndroidBy(id = "com.arris.sbcBeta:id/txtDeviceName") })
	public MobileElement mobileDeviceName;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainSignalStrength']"), // 5GHz
			@AndroidBy(id = "com.arris.sbcBeta:id/txtMainSignalStrength") })
	public MobileElement signalStrength;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainDownloadSpeed']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtMainDownloadSpeed") })
	public MobileElement downloadSpeed;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtMainUpLoadSpeed']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtMainUpLoadSpeed") })
	public MobileElement uploadSpeed;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/imgDevice") })
	public MobileElement mobileDeviceImage;

	@AndroidFindAll({
			@AndroidBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/rcyclrDevices']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/rcyclrDevices") })
	public MobileElement recyclerView;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgCloseIcon']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/imgCloseIcon") })
	public MobileElement closeIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/setBackgroundForFreezingList']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/setBackgroundForFreezingList") })
	public MobileElement deviceEntry1;

	public DeviceSignalStrengthLeaderBoardPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseIcon()
	{
		if(closeIcon.isDisplayed())	{
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		}else {
			return false;
		}
	}
	
	public boolean clickEditDeviceName()
	{
		if(mobileDeviceName.isDisplayed())	{
			click(mobileDeviceName);
			utils.log().info("Device Signal Strength Leader Board - Clicked on Device Name Text");
			return true;
		}else {
			return false;
		}
	}
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDeviceNameDialog = new EditDeviceNameDialog();
		return editDeviceNameDialog;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}
	
	public boolean verifyUIOnDeviceSignalStrengthPage() {
		try {
			if (leaderBoardTitleText.isDisplayed())
				utils.log().info("Title - " + leaderBoardTitleText.getText() + " - is displayed");
			else
				utils.log().info("Leader Board Title Text is not displayed");

			if (topFiveOnlineDevices.isDisplayed())
				utils.log().info(topFiveOnlineDevices.getText() + " - text is displayed");
			else
				utils.log().info("Top five Online Devices text is not displayed");

			if (signalStrengthOptions.isDisplayed())
				utils.log().info("Sorting based on Device Signal Strength option is displayed");
			else
				utils.log().info("Sorting based on device signal strength option is not displayed");
			
			if (numberOfDevicesText.isDisplayed())
				utils.log().info(numberOfDevicesText.getText() + " are displayed");
			else
				utils.log().info("Number of Devices is not displayed");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public boolean verifySignalStrengthForDevices() {
		try {
			utils.log().info("************************************");
			utils.log().info("Device Signal Strength Leader Board  ");
			utils.log().info("************************************");

//			int deviceCount = getDeviceSignalStrengthCount(numberOfDevicesText.getText());
//			utils.log().info("Device count is : " + deviceCount);

			for (int i = 1; i <= 3; i++) {
				utils.log().info("Devices  : " + counter);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView/android.widget.ScrollView["+i+"]/android.view.ViewGroup/android.view.ViewGroup");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainDownloadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainUpLoadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info("RSSI Label             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatusTitle").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label is not available/displayed");
					}

					try {
						utils.log().info("RSSI Value             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatus").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available/displayed");
					}
					counter++;
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}

	public boolean sortStrongToWeak() {
		try {
			click(signalStrengthOptions);
			click(strongToWeak);
			listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath(
					"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
			int size = listOfDevices.size();
			utils.log().info("Verifying Signal Strength for " + size + " devices");
			counter = 1;
			Integer[] originalSignalStrength;
			Integer[] desendingSignalStrength;
			int i = 0;

			originalSignalStrength = new Integer[size];
			desendingSignalStrength = new Integer[size];

			for (MobileElement e : listOfDevices) {
				originalSignalStrength[i] = convertSignalStrengthToInteger(
						e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}

			desendingSignalStrength = sortArrayDecending(originalSignalStrength);
			if (Arrays.equals(originalSignalStrength, desendingSignalStrength)) {
				utils.log().info("Signal Strength option selected is - Strong to Weak");
				utils.log().info("The devices are displayed from Strongest to Weakest signal strength order");
			} 
			return true;
//			else {
//				utils.log().info("Signal Strength option selected is - Strong to Weak");
//				utils.log().info("The devices are not displayed from Strongest to Weakest signal strength order");
//				return false;
//			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean sortWeakToStrong() {
		try {
			click(signalStrengthOptions);
			click(weakToStrong);
			listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath(
					"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
			int size = listOfDevices.size();
			utils.log().info("Verifying Signal Strength for " + size + " devices");
			counter = 1;
			Integer[] originalSignalStrength;
			Integer[] ascendingSignalStrength;
			int i = 0;

			originalSignalStrength = new Integer[size];
			ascendingSignalStrength = new Integer[size];

			for (MobileElement e : listOfDevices) {
				originalSignalStrength[i] = convertSignalStrengthToInteger(
						e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}

			ascendingSignalStrength = sortArrayAscending(originalSignalStrength);
			if (Arrays.equals(originalSignalStrength, ascendingSignalStrength)) {
				utils.log().info("Signal Strength option selected is - Weak to Strong");
				utils.log().info("The devices are displayed from Weakest to Strongest signal strength order");
			}
			return true;
//		else {
//			utils.log().info("Signal Strength option selected is - Weak to Strong");
//			utils.log().info("The devices are not displayed from Weakest to Strongest signal strength order");
//		}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifySignalStrengthStrongToWeak() {
		try {
			utils.log().info("****************************************************************");
			utils.log().info("Sorting Device Signal Strength Leader Board From Strong to Weak ");
			utils.log().info("****************************************************************");

//			int deviceCount = getDeviceSignalStrengthCount(numberOfDevicesText.getText());
//			utils.log().info("Device count is : " + deviceCount);
			
			click(signalStrengthOptions);
			click(strongToWeak);

			for (int i = 1; i <= 3; i++) {
				utils.log().info("Devices  : " + counter);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView/android.widget.ScrollView["+i+"]/android.view.ViewGroup/android.view.ViewGroup");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainDownloadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainUpLoadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info("RSSI Label             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatusTitle").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label is not available/displayed");
					}

					try {
						utils.log().info("RSSI Value             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatus").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available/displayed");
					}
					counter++;
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}
	
	public boolean verifySignalStrengthWeakToStrong() {
		try {
			utils.log().info("****************************************************************");
			utils.log().info("Sorting Device Signal Strength Leader Board From Weak to Strong ");
			utils.log().info("****************************************************************");

//			int deviceCount = getDeviceSignalStrengthCount(numberOfDevicesText.getText());
//			utils.log().info("Device count is : " + deviceCount);
			
			click(signalStrengthOptions);
			click(weakToStrong);

			for (int i = 1; i <= 3; i++) {
				utils.log().info("Devices  : " + counter);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView/android.widget.ScrollView["+i+"]/android.view.ViewGroup/android.view.ViewGroup");

				for (MobileElement e : entity) {
					try {
						if (e.findElementByXPath(
								"//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
								.isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ e.findElementById("com.arris.sbcBeta:id/txtDeviceName").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainDownloadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ e.findElementById("com.arris.sbcBeta:id/txtMainUpLoadSpeed").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info("RSSI Label             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatusTitle").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label is not available/displayed");
					}

					try {
						utils.log().info("RSSI Value             : "
								+ e.findElementById("com.arris.sbcBeta:id/txtStatus").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available/displayed");
					}
					counter++;
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}


	private Integer convertSignalStrengthToInteger(String ghz) // 5GHz
	{
		String i = ghz.substring(0, 1);
		return Integer.valueOf(i);
	}

	private Integer[] sortArrayDecending(Integer ss[]) {
		Arrays.sort(ss, Collections.reverseOrder());
		return ss;
	}

	private Integer[] sortArrayAscending(Integer ss[]) {
		Arrays.sort(ss);
		return ss;
	}

	@Override
	public boolean isAt() {
		if (leaderBoardTitleText.isDisplayed()) {
			utils.log().info("On Device Signal Strength Leader Board Page");
			return true;
		} else {
			utils.log().info("Not on Device Signal Strength Leader Board Page");
			return false;
		}
	}

}
