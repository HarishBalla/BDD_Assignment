/*Author: Harish.Balla
 *Date:  18/11/2024
 *Comments: Added Keywords Class which contains multiple keywords for each action
 *Modified By: Harish.Balla 
 *Date: 18/11/2024
 *Comments: Added Pagination Keyword
 */
package commons;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageUIs.DerivedProduct1Tests;

//import org.testng.Assert;


public class BasePage{
	public static Properties OR;
	public static String currentTest;
	public static String currentTestDesc;
	public static String severity;
	public static String tcdesc;
	public static String keyword;
	public static WebDriver driver=null;
	public static WebElement doubleclickelement=null;
	public static WebElement rightClick=null;
	public static WebElement hoverMouseAction=null;
	public static By locator;
	public static Actions action=null;
	//public static EventFiringWebDriver edriver=null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	public static String finalTestStatus;
	public static WebElement Dragelement=null;
	public static WebElement Dropelement=null;
	// temp
	public static String tsData;
	public static int  testRepeat;
	public static int  SuiteRepeat;
	public static String finalStartTime;
	public static String finalEndTime;
	public static String tdID;
	public static String tcEndTime;
	public static String tcDuration;
	public static String duration;
	public static String SuiteName=null;
	public static String getValue=null;
	public static String FileName;
	public static String AdvanceSearchData=null;
	public static String reportsPath, screenshotsPath, resultFolder;
	public static String env;
	public static String AppURL;
	public static String downloadpath;
	public static String ModuleName;
	public static String calValue=null;
	public static String testBrowser;
	private static final Logger log = LogManager.getLogger(BasePage.class);


	public static String launchbrowser() {
		if (driver == null) {
	        ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.prompt_for_download", false);
			
			prefs.put("plugins.plugins_disabled", new String[] { "Adobe Flash Player", "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("start-maximized");
			System.out.println("Setting Capabilities");
			//DesiredCapabilities dc = new DesiredCapabilities();
			//dc.setCapability(ChromeOptions.CAPABILITY, options);
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();		 
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
//			wbdriver = new EventFiringWebDriver(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		return "Pass";
	}

	public static String loginPage(String url) {
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			
		} catch (Throwable t) {			
			return "Fail -" + t.getMessage();
		}
		return "Pass";
	}

	public static String navigate(String object) {
		try {
			driver.navigate().to(object);
			}
		 catch (Throwable t) {
			return "Fail -" + t.getMessage();
		}
		return "Pass";
	}

	public static String verifyText() {
		
		String expected = tsData;
		String actual = null;
		try {
			actual = driver.findElement(By.xpath("")).getText();		
		} catch (Throwable t) {
			// error
			return "Fail -" + t.getMessage();
		}
		return "Pass";
	}

	public static String click(String object) {
		log.info("Executing click keyword for object " + object);
		try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.xpath(object)));
				driver.findElement(By.xpath(object.replaceAll("dynamicObject", tsData))).click();
			
		} catch (Throwable t) {
			// report error
			log.info("Error while clicking on -" + object + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

	public static String selectdropdown() {
		log.info("Executing selectdropdown keyword for object " + object);
		// extract the test data
		String data;
		if (tsData.equals("getValue")) {
			data = getValue;
		} else if (tsData.equals("calValue")) {
			data = calValue;
		} else {
			data = tsData;
		}

		try {
			WebElement select = driver
					.findElement(By.xpath(OR.getProperty(object).replaceAll("dynamicObject", getValue)));
			Select mySelect = new Select(select);
			mySelect.selectByValue(data);
		} catch (Throwable t) {
			// report error
			log.info("Error while Selecting from droplist -" + object + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

	public static String getAlllist(String locator) {
		StringBuilder sb=new StringBuilder();
		try {
			log.info("getting element of main");
			WebElement select = driver
					.findElement(By.xpath(locator));
			log.info("getting elements of list");
			List<WebElement> options = select.findElements(By.xpath(locator));
			
			log.info("Size of the list is " + options.size());
			log.info("first in the list - " + options.get(0).getText());
			
			for (int i = 0; i < options.size(); i++) {
				String getValue = Integer.toString(i);		    	
				String value= BasePage.getdynamichrefAttributeValue(locator+"["+getValue+"]");
				sb.append(value);
			}				
				log.info("All elements: "+sb);
				System.out.println("All elements: "+sb);
		} catch (Throwable t) {
			// report error
			log.info("Error while selectcombolist -" + object + t.getMessage());
		}
		return sb.toString();
	}

	public static String wait(int object) throws NumberFormatException, InterruptedException {
		log.info("Executing wait keyword");
		// extract the test data
		int data = object;
		// DecimalFormat df=new DecimalFormat("#");
		// Thread.sleep(Long.parseLong(df.format(Double.parseDouble(data))));
		TimeUnit.SECONDS.sleep(data);
		return "Pass";
	}
	
	public static Boolean waitForElement(String object) {
		log.info("Executing WaitforElement keyword for object " + object);
		locator = (By) By.xpath(object);
		try {			
			WebElement myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(20)))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(object)));
		} catch (Throwable t) {
			log.error(locator.toString() + " Element is not visible in 20 seconds");
			return false;
		}
		return true;
	}

//	public static String WaitforElement() {
//		log.info("Executing WaitforElement keyword for object " + object);
//		String data[] = tsData.split(",");
//		String status = "Pass";
//
//		if (data.length > 2) {
//			if (!data[2].equalsIgnoreCase("getValue")) {
//				locator = (By) By.xpath(OR.getProperty(object).replaceAll("dynamicObject", data[2]));
//			} else {
//				locator = (By) By.xpath(OR.getProperty(object).replaceAll("dynamicObject", getValue));
//			}
//
//		} else {
//			locator = (By) By.xpath(OR.getProperty(object).replaceAll("dynamicObject", getValue));
//		}
//
//		try {
//
//			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//			WebElement wt = new WebDriverWait(driver, Integer.parseInt(data[0]))
//					.pollingEvery(Integer.parseInt(data[1]), TimeUnit.SECONDS).ignoring(Exception.class)
//					.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//		} catch (Throwable t) {
//			log.error(locator.toString() + " Element is not visible in " + Integer.parseInt(data[0]) + " seconds");
//			return "Fail - " + t.getMessage();
//		}
//		return status;
//	}
	
	public static String getdynamicTextAttributeValue(String object) {
		log.info("Executing the getdynamicTextAttributeValue keyword " + object);
		try {

				getValue = driver.findElement(By.xpath(object)).getText();
		}
catch (Exception e) {
			e.printStackTrace();
			log.error("Error while executing the getdynamicTextAttributeValue " + e.getMessage());
			getValue = null;
			return "Fail - " + e.getMessage();
		}
		return getValue;
	}
	
	public static String getdynamichrefAttributeValue(String object) {
		log.info("Executing the getdynamichrefAttributeValue keyword " + object);
		try {

				getValue = driver.findElement(By.xpath(object)).getAttribute("href");
		}
catch (Exception e) {
			e.printStackTrace();
			log.error("Error while executing the getdynamicTextAttributeValue " + e.getMessage());
			getValue = null;
			return "Fail - " + e.getMessage();
		}
		return getValue;
	}

	public static int getCount(String object) {		
		int count = driver.findElements(By.xpath(object)).size();
		return count;
	}

	public static String browserQuit() {
		log.info("Executing browserQuit keyword");
		try {
			driver.quit();
			driver = null;
		} catch (Throwable t) {
			// report error
			log.info("Error in browserQuit " + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

	public static String windowMaximize() {
		log.info("Executing windowMaximize keyword");
		try {
			driver.manage().window().maximize();
		} catch (Throwable t) {
			// report error
			log.info("Error in windowMaximize " + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

	public static String verifyWebelementAttributeValue() {
		log.info("Executing verifyWebelementAttributeValue keyword for object " + object);
		String expected = tsData.substring(tsData.indexOf(",") + 1);
		String data = tsData.split(",")[0];
		String actual = driver.findElement(By.xpath(OR.getProperty(object).replaceAll("dynamicObject", getValue)))
				.getAttribute(data);
		String status = "Pass";
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			log.info("Expected value - " + expected);
			log.info("Actual value - " + actual);
			if (actual.equalsIgnoreCase(expected)) {
				status = "Pass";
			} else {
				status = "Fail";
			}
		} catch (Throwable t) {
			log.error(OR.getProperty(object) + "'s attribute - " + data + " value is not equal to " + expected);
			return "Fail - " + t.getMessage();
		}
		return status;
	}

	public static String hoverMouseAction(String object) {
		log.info("Executing hoverMouseAction keyword for object " + object);
		try {
			hoverMouseAction = (WebElement) driver.findElement(By.xpath(object));
			action = new Actions(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hoverMouseAction);
			action.moveToElement(hoverMouseAction).build().perform();
		} catch (Throwable t) {
			// report error
			log.info("Error in HoverMouseAction -" + object + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

	public static String switchToLatestOpenedWindow() {
		log.info("Executing switchToLatestOpenedWindow keyword");
		Set<String> WindowHandles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		try {
			for (String WindowHandle : WindowHandles) {
				if (!WindowHandle.equals(currentWindowHandle)) {
					driver.switchTo().window(WindowHandle);
				}
			}

		} catch (Throwable t) {
			// report error
			log.info("Error while switching to Window - " + t.getMessage());
			return "Fail - " + t.getMessage();
		}
		return "Pass";
	}

}
