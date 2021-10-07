package com.cs.arris.Base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.cs.arris.Reports.ExtentReport;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ParentClass 
{
	public Properties properties = new Properties();
	
	protected static ThreadLocal <AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
	protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <HashMap<String, String>> errorcode = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <HashMap<String, String>> testdata = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <String> platformName = new ThreadLocal<String>();
	protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
	private static AppiumDriverLocalService server;
	
	TestUtils utils = new TestUtils();
	public AppiumDriver<MobileElement> driver;
	public AndroidDriver<MobileElement> androidDriver;
	DesiredCapabilities desiredCapabilities ;
	public URL url;
	public InputStream inputStream = null;
	public InputStream stringsis = null;
	public InputStream errorCode = null;
	public InputStream testData = null;
	public String pltName;
	public String dvcName;
	public File ssFile;
	public String OTP;
	public String randomEmailAdress;
	
//	@BeforeSuite
//	public void beforeSuite() throws Exception
//	{
//		setConfigProperties();
//		ThreadContext.put("ROUTINGKEY", "ServerLogs");
//		server = getAppiumService();
//		if(!checkIfAppiumServerIsRunnning(4723)) {
//			server.start();
//			server.clearOutPutStreams();
//			System.out.println("***************   Appium server started   **************");
//			utils.log().info("Appium server started");
//		} else {
//			utils.log().info("Appium server already running");
//		}	
//	}
	
	public ParentClass() 
	{ 
		//PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(10)), this); 
	}
	
//	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
//	    boolean isAppiumServerRunning = false;
//	    ServerSocket socket;
//	    try {
//	        socket = new ServerSocket(port);
//	        socket.close();
//	    } catch (IOException e) {
//	    	System.out.println("1");
//	        isAppiumServerRunning = true;
//	    } finally {
//	        socket = null;
//	    }
//	    return isAppiumServerRunning;
//	}
	
	@AfterSuite
	public void afterSuite() 
	{
		if (stringsis != null)
		try {
			stringsis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (errorCode != null)
			try {
				errorCode.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		if (testData != null)
			try {
				testData.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		utils.log().info("Closing App");
		getDriver().closeApp();
		utils.log().info("Closing Driver");
		driver.close();
		utils.log().info("Quitting Driver");
		driver.quit();
		
//		server.stop();
//		utils.log().info("Appium server stopped");
		
	}
	
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}
	
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH",  "/Users/prabhu/.fastlane/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin:/opt/homebrew/bin:/opt/homebrew/Cellar/openjdk@11/11.0.10/libexec/openjdk.jdk/Contents/Home/bin:/Users/prabhu/Library/Android/sdk:/Applications/sonar-scanner/bin:/Applications/sonarqube/bin:/usr/bin/ruby:/usr/local/bin/pod");
		environment.put("ANDROID_HOME", "/Users/prabhu/Library/Android/sdk");
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withEnvironment(environment)
				.withLogFile(new File("ServerLogs/server.log")));
	}
	
	@Parameters({"platform", "device"})
	@BeforeSuite
	public void beforeSuite(String platform, String device)
	{
		this.pltName = platform;
		this.dvcName = device;
		
		try
		{
			setConfigProperties();
			setDateTime(utils.dateTime());
			setPlatformName(this.pltName);
			setDeviceName(this.dvcName);
			
			//Load strings.xml, error_code.xml and logs
			loadStringsXML("strings/strings.xml");
			loadErrorCodesXML("error_codes/error_codes.xml");
			loadLogs();
		
			//Fetch url from config.properties file. setProps already set in BeforeSuite
			url = new URL(getProps().getProperty("appiumURL"));  //  http://127.0.0.1:4723/wd/hub
			
			//set the DesiredCapabilites of the device
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPlatformName());
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
			
			if(getPlatformName().equalsIgnoreCase("Android"))
			{
				System.out.println("Inside Android DesiredCapabilities...Platform Name ---> : " + getPlatformName());
				desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProps().getProperty("androidAutomationName"));
				desiredCapabilities.setCapability(MobileCapabilityType.UDID, getProps().getProperty("androidUDID"));
				desiredCapabilities.setCapability(MobileCapabilityType.VERSION, getProps().getProperty("androidVersion"));
				desiredCapabilities.setCapability(MobileCapabilityType.APP, getProps().getProperty("androidAppLocation"));
				desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
				setDriver(driver);
				System.out.println("Android Driver is set to the Thread Local context =======> "+ getDriver().getPlatformName());
				utils.log().info("driver initialized: " + getDriver()); 
				//PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
			}
		}catch (Exception e) 
		{
			  utils.log().fatal("Unable to initialization driver...... ABORTING !!!\n" + e.toString());
		  } 
	  }
	
	@BeforeTest
	public void beforeTest()
	{
		
	}
	
	  @AfterTest
	  public void afterTest() 
	  {
		  closeApp();
	  
	  }
	
	  public void loadLogs() throws Exception 
	  {
		  String strFile = "logs" + File.separator + getPlatformName() + "_" + getUDID();
			File logFile = new File(strFile);
			if (!logFile.exists()) {
				logFile.mkdirs();
			}
			//route logs to separate file for each thread
			ThreadContext.put("ROUTINGKEY", strFile);
			utils.log().info("log path: " + strFile);
	 }
	  
	  public void setConfigProperties()
	  {
			//load config.properties and assign properties object to properties ThreadLocal
			String propFileName = "config.properties";
			utils.log().info("load " + propFileName);
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			setProps(properties);
			System.out.println("Config.properties object set to Thread Local");
	  }
	  
	  public void loadTestData(String filePath)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
			try 
			{
				String dataFilename = filePath; 
				utils.log().info("loading..." + dataFilename);
				testData = getClass().getClassLoader().getResourceAsStream(dataFilename);
				properties.load(testData);
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public void loadStringsXML(String stringsFile)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
			try 
			{
				String xmlFileName = stringsFile; 
				utils.log().info("load " + xmlFileName);
				stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
				setStrings(utils.parseStringXML(stringsis));
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public void loadErrorCodesXML(String errorFile)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
			try 
			{
				String xmlFileName = errorFile; 
				utils.log().info("load " + xmlFileName);
				errorCode = getClass().getClassLoader().getResourceAsStream(xmlFileName);
				setErrorCode(utils.parseStringXML(errorCode));
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  
	public AppiumDriver<?> getDriver() { return appiumDriver.get(); }
	
	public void setDriver(AppiumDriver<MobileElement> driver) { appiumDriver.set(driver); }
	
	public Properties getProperties() { return props.get(); }
	
	public void setProperties(Properties properties) { props.set(properties); }
	
	public HashMap<String, String> getStrings() { return strings.get(); }
	  
	public void setStrings(HashMap<String, String> strings2) { strings.set(strings2); }
	
	public HashMap<String, String> getErrorCode() { return errorcode.get(); }
	  
	public void setErrorCode(HashMap<String, String> errorcode2) { errorcode.set(errorcode2); }
	
	public String getPlatformName() { return platformName.get(); }
	  
	public void setPlatformName(String platform2) { platformName.set(platform2); }
	
	public String getUDID() { return getProps().getProperty("androidUDID"); }
	  
	public String getDateTime() { return dateTime.get(); }
	  
	public void setDateTime(String dateTime2) { dateTime.set(dateTime2); }
	  
	public String getDeviceName() { return deviceName.get(); }
	  
	public void setDeviceName(String deviceName2) { deviceName.set(deviceName2); }
	
	public Properties getProps() { return props.get(); }
	 
	public void setProps(Properties props2) { props.set(props2); }
	
	@BeforeMethod
	public void beforeMethod() 
	{
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}
	
	//stop video capturing and create *.mp4 file
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws Exception 
	{
		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		
		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();		
		String dirPath = "videos" + File.separator + params.get("platform") + "_" + getUDID() 
		+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
		
		File videoDir = new File(dirPath);
		
		synchronized(videoDir){
			if(!videoDir.exists()) {
				videoDir.mkdirs();
			}	
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
			stream.close();
			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
		} catch (Exception e) {
			utils.log().error("error during video capture" + e.toString());
		} finally {
			if(stream != null) {
				stream.close();
			}
		}		
	}
	
	 public void waitForVisibility(MobileElement e) {
		  WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		  wait.until(ExpectedConditions.visibilityOf(e));
	  }
	  
	  public void waitForVisibility(WebElement e){
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);
		  
		  wait.until(ExpectedConditions.visibilityOf(e));
		  }
	  
	  public void clear(MobileElement e) {
		  waitForVisibility(e);
		  e.clear();
	  }
	  
	  public void click(MobileElement e) {
		  waitForVisibility(e);
		  e.click();
	  }
	  
	  public void click(MobileElement e, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.click();
	  }
	  
	  public void sendKeys(MobileElement e, String txt) {
		  //waitForVisibility(e);
		  e.sendKeys(txt);
	  }
	  
	  public void sendKeys(MobileElement e, String txt, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.sendKeys(txt);
	  }
	  
	  public String getAttribute(MobileElement e, String attribute) {
		  waitForVisibility(e);
		  return e.getAttribute(attribute);
	  }
	  
//	  public String getText(MobileElement e, String msg) {
//		  String txt = null;
//		  switch(getPlatformName()) {
//		  case "Android":
//			  txt = getAttribute(e, "text");
//			  break;
//		  case "iOS":
//			  txt = getAttribute(e, "label");
//			  break;
//		  }
//		  utils.log().info(msg + txt);
//		  ExtentReport.getTest().log(Status.INFO, msg);
//		  return txt;
//	  }
	  
	  public MobileElement scrollToElement() 
	  {	  
			return (MobileElement) ((FindsByAndroidUIAutomator<?>) getDriver()).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
							+ "new UiSelector().description(\"test-Price\"));");
	  }
	  
	  public void iOSScrollToElement() {
		  RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name("test-ADD TO CART"));
		  String elementID = element.getId();
		  HashMap<String, String> scrollObject = new HashMap<String, String>();
		  scrollObject.put("element", elementID);
//		  scrollObject.put("direction", "down");
//		  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//		  scrollObject.put("name", "test-ADD TO CART");
		  scrollObject.put("toVisible", "sdfnjksdnfkld");
		  getDriver().executeScript("mobile:scroll", scrollObject);
	  }

	  public void closeApp() {
		  ((InteractsWithApps) getDriver()).closeApp();
	  }
	  
	  public void launchApp() {
		  ((InteractsWithApps) getDriver()).launchApp();
	  }
	  
	  public void takeScreenshot(String methodName, ITestResult result) 
	  {
		  	String ssPath = "Screenshots" + File.separator + getPlatformName() + "_" + getUDID() + File.separator + utils.onlyDate();
			ssFile = new File(ssPath);
			if (!ssFile.exists()) 
			{
				ssFile.mkdirs();
			}
			File file  = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			    try {
			        FileUtils.copyFile(file, new File(ssFile.getAbsolutePath() + File.separator + result.getTestClass().getRealClass().getSimpleName() + File.separator + methodName + ".jpg"));
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		}
	  
		 public void setBlueTooth(String statusToSet, MobileElement bluetoothIcon) 
		 {
		        Capabilities cap = getDriver().getCapabilities();
		        try {
		            Runtime.getRuntime().exec("adb -s " + cap.getCapability(MobileCapabilityType.UDID).toString() + " shell am start -a android.settings.BLUETOOTH_SETTINGS");
		            //MobileElement bluetoothIcon = driver.findElementById("com.android.settings:id/switch_text");
		            String actualStatus = bluetoothIcon.getText();
		            System.out.println(actualStatus);
		            if (!actualStatus.equalsIgnoreCase(statusToSet)) {
		                Runtime.getRuntime().exec("adb -s " + cap.getCapability(MobileCapabilityType.UDID).toString() + " shell input keyevent 19");
		                Runtime.getRuntime().exec("adb -s " + cap.getCapability(MobileCapabilityType.UDID).toString() + " shell input keyevent 23");
		                Runtime.getRuntime().exec("adb -s " + cap.getCapability(MobileCapabilityType.UDID).toString() + " shell input keyevent 3");
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		            //android.widget.Switch[@resource-id='com.android.settings:id/switch_widget']
		            //aandroid.widget.Switch[@text='Bluetooth, On']
		        }
		    }
		 
		 public void pause()
		 {
			 try {
				 getDriver().manage().timeouts().pageLoadTimeout(TestUtils.WAIT, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 public void pause(int sec)
		 {
			try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
}
	
	
	
	
	







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//Switch based on platform name
//	switch (getPlatformName())
//	{
//		case "Android":
//			System.out.println("Inside Android DesiredCapabilities...Platform Name ---> : " + getPlatformName());
//			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProps().getProperty("androidAutomationName"));
//			desiredCapabilities.setCapability(MobileCapabilityType.UDID, getProps().getProperty("androidUDID"));
//			desiredCapabilities.setCapability(MobileCapabilityType.VERSION, getProps().getProperty("androidVersion"));
//			desiredCapabilities.setCapability(MobileCapabilityType.APP, getProps().getProperty("androidAppLocation"));
//			driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
//			System.out.println("=======> "+ driver.getPlatformName());
//			break;
//		default:
//			throw new Exception("Invalid platform! - " + getPlatformName());
//	}
//	setDriver(driver);
//	utils.log().info("driver initialized: " + getDriver()); 
//	PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
//}catch (Exception e) {
//	  utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
//  } finally {
//	  if(inputStream != null) {
//		  try {
//			inputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//	  if(stringsis != null) {
//		  try {
//			stringsis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//  }