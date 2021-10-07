package com.cs.arris.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConnectToWifiUsingRouterSSID extends ParentClass
{
	public TestUtils utils = new TestUtils();
	public String ssid;
	public String pwd;
	
	public void turnOnRouterWifi(String ssid, String pwd)
	{
		this.ssid = ssid;
		this.pwd = pwd;
		Capabilities cap = getDriver().getCapabilities();
        try {
            Runtime.getRuntime().exec("adb shell am start -n com.steinwurf.adbjoinwifi/.MainActivity -e ssid " + this.ssid + " -e password_type WPA -e password " + this.pwd);
            pause(3);
            Runtime.getRuntime().exec("adb shell input keyevent 3");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
