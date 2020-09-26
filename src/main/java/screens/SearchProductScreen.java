package screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import constants.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchProductScreen extends ScreenBase {

	public SearchProductScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	} 
	
	@AndroidFindBy(id=Constants.SEARCH_PRODUCT_ID)
	AndroidElement searchProduct;
	
	@AndroidFindBy(id=Constants.SEARCH_AUTOCOMPLETE_ID)
	AndroidElement autoComplete;
	
	@AndroidFindBy(className=Constants.LIST_OF_ITEMS_CLASSNAME)
	List<AndroidElement> listItems;
	
	public SearchedProductList_Screen enterProduct(String enterProduct) {
		waitForElement(Constants.SEARCH_PRODUCT_ID, "ID");
		searchProduct.click();
		autoComplete.sendKeys(enterProduct.toLowerCase());
		for(int i=0; i<=listItems.size(); i++) {
			if(listItems.get(i).getText().contains(enterProduct.toLowerCase())) {
				listItems.get(i).click();
				break;
			}
		}
		
		return new SearchedProductList_Screen(driver);
		
	}
	
	

}
