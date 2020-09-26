package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import screens.AddToCartScreen;
import screens.LoginScreen;
import screens.MyCartScreen;
import screens.SearchProductScreen;
import screens.SearchedProductList_Screen;
import screens.WelcomeScreen;
import utilities.Constants;
import utilities.ExcelReader;

public class FlipkartAddToCartTest extends TestBase {
	
	WelcomeScreen welcomeScreen;
	LoginScreen loginScreen;
	SearchProductScreen srchProductScreen;
	SearchedProductList_Screen srchProductListScreen;
	AddToCartScreen addToCart;
	MyCartScreen myCartScreen;
	public static ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH);
	
	@BeforeTest
	public void init() throws IOException {
		
		setUp();
		welcomeScreen = new WelcomeScreen(driver);
		addToCart = new AddToCartScreen(driver);
		
	}
	
	@Test(dataProvider="getData")
	public void verificationOfItemsAddedToCart(String Select_Language, String Produt_Data) {
		
		loginScreen = welcomeScreen.selectLanguage(Select_Language);

		srchProductScreen = loginScreen.skipSignIn();
		
		srchProductListScreen = srchProductScreen.enterProduct(Produt_Data);
		
		srchProductListScreen.selectProductFromList(Produt_Data);
		
		String addCart = srchProductListScreen.getAddToCartPrice();
		
		addToCart.selectaddToCart();
		
		myCartScreen = addToCart.selectGoToCart();
		
		String myCart = myCartScreen.myCartPrice();
		
		Assert.assertEquals(myCart.stripTrailing().stripLeading(), addCart.stripTrailing().stripLeading());
		
		
		
	}
	
	
	@AfterTest
	public void quitDriver() {
		
		quit();
	}
	

	
	@DataProvider
	public static Object[][] getData() {
		String sheetName = "Data";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
		for( int rowNum=2; rowNum<=rows; rowNum++) {
			
			for( int colNum=0; colNum<cols; colNum++) {
				data [rowNum-2] [colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		
		return data;

		
	
	}

}
