package base;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import utilities.AppiumServer;
import utilities.CommonUtitlities;


public class TestBase {

	public static AndroidDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static String log4j = "log4j.properties";
	public static String loadPropertyFile = "flipkart_Android.properties";
	
	public static void setUp() throws IOException {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/properties/logs4j.properties");
		AppiumServer.start();
		log.info("Appium Server Started !!");
		CommonUtitlities.loadConfig(loadPropertyFile);
		log.info(loadPropertyFile + " properties file loaded !!!");
		CommonUtitlities.loadCapabilities();
		driver=CommonUtitlities.getDriver();	
		
	}
	

	public static void quit() {
		driver.quit();
		log.info("Test case execution completed");

		AppiumServer.stop();
		log.info("Appium server stopped !!!");
	}
	

}
