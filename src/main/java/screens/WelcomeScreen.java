package screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen extends ScreenBase {

	public WelcomeScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath=Constants.SELECT_LANGUAGE_XPATH)
	private List <AndroidElement> selectLanguage;
	
	@AndroidFindBy(id=Constants.SELECT_CONTINUE_ID)
	private AndroidElement selectContinue;
	
	public LoginScreen selectLanguage(String SelectLanguage) {
		for(int i=0; i<=selectLanguage.size(); i++) {
			if(selectLanguage.get(i).getAttribute("text").contains(SelectLanguage)) {
				selectLanguage.get(i).click();
				selectContinue.click();
				break;
			}
		}
		
		return new LoginScreen(driver);
	}

}
