package screens;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyCartScreen extends ScreenBase {

	public MyCartScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 
	
	@AndroidFindBy(uiAutomator = Constants.MY_CART_PRICE_UIAUTOMATOR)
	AndroidElement myCartPrice;
	
	public String myCartPrice() {
		waitForElement(Constants.MY_CART_PRICE_UIAUTOMATOR, "UIAUTOMATOR");
		return  myCartPrice.getText();
	}

}
