package rough;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestRough {
	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities caps = new DesiredCapabilities();
	public static WebDriverWait wait;
	public String g = "Glomin";
	public static ExcelRe read = new ExcelRe();

	public static void main(String[] args) throws Exception {
		String g = "glomin";
		String x = "Glomin";
		read.xlRead_TD("D:\\2.Learning_Paths\\4.selenium data driven_chapter 4\\testing.xls", 0);
		
		System.out.println(read.xData_TD[1][1]);
		
		System.out.println(g.equalsIgnoreCase(x));


	}

	@BeforeTest
	public void BeforeSetup() throws Exception {
		read.xlRead_TD("D:\\2.Learning_Paths\\4.selenium data driven_chapter 4\\testing.xls", 0);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability("appPackage", "com.flipkart.android");
		caps.setCapability("appActivity", ".activity.HomeFragmentHolderActivity");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	private static void setUp() {

		wait = new WebDriverWait(driver, 5);
		List<AndroidElement> selectLanguage = driver
				.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.flipkart.android:id/tv_text\"]"));
		for (int i = 0; i <= selectLanguage.size(); i++) {
			System.out.println(selectLanguage.get(i).getText());
			if (selectLanguage.get(i).getAttribute("text").contains(read.xData_TD[1][0])) {
				selectLanguage.get(i).click();
				driver.findElementById("com.flipkart.android:id/select_btn").click();
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/custom_back_icon"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox"))).click();
		driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys(read.xData_TD[1][1]);
		List<AndroidElement> items = driver.findElementsByClassName("android.widget.TextView");
		for(int i=0; i<=items.size(); i++) {
			System.out.println(items.get(i).getText());
			if(items.get(i).getText().contains("Almonds")) {
				System.out.println(items.get(i).getText());
				items.get(i).click();
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/not_now_button"))).click();
		int count=0;
		String selectEnteredProduct = "1 Kg Almonds";
		while(count>=0) {
			System.out.println("//android.widget.TextView[contains(@text,\""+read.xData_TD[1][1]+"\")]");

		if(driver.findElementsByXPath("//android.widget.TextView[contains(@text,\""+read.xData_TD[1][1]+"\")]").size()>0) {
		 driver.findElementByXPath("//android.widget.TextView[contains(@text,\""+read.xData_TD[1][1]+"\")]").click();
			System.out.println("clicked");
			break;
		}else {
	
				System.out.println("scrolling");
				scrollUp(1, driver);
				count++;
			
		}

		
	}
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	private static void test() {
		driver.quit();

	}

	public static void scrollUp(int howManySwipes,AppiumDriver<AndroidElement> driver) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(driver).press(PointOption.point(startVerticalX, startVerticalY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, endVerticalY)).release()
				.perform();
			}
		} catch (Exception e) {
			
		}
	}



	public static void scrollDown(int howManySwipes,AndroidDriver<MobileElement> driver) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(driver).press(PointOption.point(startVerticalX, endVerticalY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, startVerticalY)).release()
				.perform();
			}
		} catch (Exception e) {
			//print error or something
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
