package screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import base.CommonFunctions;
import constants.Constants;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchedProductList_Screen extends ScreenBase {
	public String enteredProdcut;
	public static String price;
	public static String addToCartPrice;

	public SearchedProductList_Screen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = Constants.LOCATION_CONSENT_ID)
	private AndroidElement locationConsent;

	@AndroidFindBy(id = Constants.LOCATION_CONSENT_ID)
	private List<AndroidElement> locationConsents;

	public void locationNotNow() {
		locationConsent.click();
	}
	
	public String getAddToCartPrice() {
		addToCartPrice=price;
		return addToCartPrice;
	}

	public void selectProductFromList(String selectEnteredProduct) {

		if (locationConsents.size() > 0) {
			locationConsent.click();
			int count = 0;
			while (count >= 0) {
				if (driver.findElementsByXPath(
						"//android.view.ViewGroup/preceding-sibling::android.widget.TextView[contains(@text,\""
								+ selectEnteredProduct + "\")]")
						.size() > 0) {
					price = driver
							.findElementByXPath("//android.widget.TextView[contains(@text,\"" + selectEnteredProduct
									+ "\")]/following-sibling::android.widget.TextView[contains(@text,\"₹\")]")
							.getText();
					System.out.println("price : " + price);
					driver.findElementByXPath("//android.widget.TextView[contains(@text,\"" + selectEnteredProduct
							+ "\")]/following-sibling::android.widget.TextView[contains(@text,\"₹\")]").click();
					break;
				} else {
					CommonFunctions.scrollUp(1, driver);
					count++;
				}
			}
		} else {

			int count = 0;
			while (count >= 0) {
				if (driver.findElementsByXPath(
						"//android.view.ViewGroup/preceding-sibling::android.widget.TextView[contains(@text,\""
								+ selectEnteredProduct + "\")]")
						.size() > 0) {
					System.out.println("----here1----");
					price = driver
							.findElementByXPath("//android.widget.TextView[contains(@text,\"" + selectEnteredProduct
									+ "\")]/following-sibling::android.widget.TextView[contains(@text,\"₹\")]")
							.getText();
					System.out.println("price : " + price);
					driver.findElementByXPath("//android.widget.TextView[contains(@text,\"" + selectEnteredProduct
							+ "\")]/following-sibling::android.widget.TextView[contains(@text,\"₹\")]").click();
					break;

				} else {
					CommonFunctions.scrollUp(1, driver);
					count++;
				}
			}
		}
		
	}

}