package screens;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase {

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id=Constants.SELECT_SKIP_LOGIN_ID)
	private AndroidElement skipSignIn;
	
	public SearchProductScreen skipSignIn() {
		waitForElement(Constants.SELECT_SKIP_LOGIN_ID, "ID");
		skipSignIn.click();
		return new SearchProductScreen(driver);
	}

}
