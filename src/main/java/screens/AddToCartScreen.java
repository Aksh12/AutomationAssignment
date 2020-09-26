package screens;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToCartScreen extends ScreenBase {

	public AddToCartScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath=Constants.ADD_TO_CART_XPATH)
	AndroidElement addToCart;
	
	@AndroidFindBy(xpath=Constants.GO_TO_CART_XPATH)
	AndroidElement selectGoToCart;
	
	@AndroidFindBy(uiAutomator = Constants.GET_PRICE_UIAUTOMATOR)
	AndroidElement price;
	
	public void selectaddToCart() {
		addToCart.click();
	}
	
	public MyCartScreen selectGoToCart() {
		selectGoToCart.click();
		return new MyCartScreen(driver);
	}

}
