package project_2_TestClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import project_2_Pages.AllProductsPage_2;
import project_2_Pages.CartPage_3;
import project_2_Pages.Login_LogoutPage_1;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_2_AllProductsPage {

	WebDriver driver;
	Login_LogoutPage_1 llp;
	AllProductsPage_2 app;
	CartPage_3 cp;

	@BeforeTest
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91933\\OneDrive\\Desktop\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority=1)
	void testLogo() throws InterruptedException {
		llp= new Login_LogoutPage_1(driver);
		Assert.assertEquals(llp.getHomePageLogo(), "Swag Labs");		
	}

	@Test(priority=2)
	void testSignIn() throws InterruptedException {
		try {
			llp= new Login_LogoutPage_1(driver);
			//Enter Login Credential
			llp.userName("standard_user");
			llp.passWord("secret_sauce");

			llp.clickLoginBtn();

			//Verify All products page is visible
			Assert.assertEquals(llp.getTxtProducts(), "Products");	
		} catch(Exception e){
			System.out.println("No such element exception");
		}
	}

	@Test(priority=3)
	void testAllProductDeatils() throws InterruptedException {
		try {
			app=new AllProductsPage_2(driver);
			//Verify all the products are visible
			app.productList();

			//Verify the details of first product 
			app.getFirstProductDetails();	

		}catch(Exception e){
			System.out.println("No such element exception");
		}

	}

	@Test(priority=6)
	void testFooter() throws InterruptedException {
		try {
			app=new AllProductsPage_2(driver);
			llp= new Login_LogoutPage_1(driver);

			//Verify the Footer text is visible
			app.getFooterText();
			Assert.assertTrue(app.getFooterText().toLowerCase().contains("© 2024 sauce labs. all rights reserved. terms of service | privacy policy"));

			//Verify the number of links present at footer 
			app.Links();
			app.socialmediaWindowHandle();

		} catch(Exception e){
			System.out.println("No such element exception");
		}
	}

	@Test(priority=4)
	void testCartPage() throws InterruptedException {

		try{
			cp= new CartPage_3(driver);

			//Verify the products are added to cart
			cp.productsAddToCart();
			cp.actionBtnViewCart();

			//Verify the cart quantity is equals to the quantity shown in the View cart icon
			Assert.assertEquals(cp.getQuantityTextViewCart(), "2");
			cp.clickBtnViewCart();

			//Verify the added products are visible in cart
			cp.CartList();

			//Verify the quantity & price of the added products in cart
			cp.getDetailsCartProduct();	

		} catch(Exception e) {
			System.out.println(" Exception Occured when product added to cart ");
		}
	}

	@Test(priority=5)
	void testOrderPlace() {

		try{
			cp= new CartPage_3(driver);
			llp= new Login_LogoutPage_1(driver);

			cp.placeOrder();
			cp.clickBtnViewCart();
			cp.clickShoppingContinue();
			cp.clickBtnViewCart();
			cp.clickBtnRemove();
			cp.clickBtnChcekOut();
			Assert.assertEquals(cp.getTxtChcekOutInfo(), "https://www.saucedemo.com/checkout-step-one.html");
			cp.enterCheckOutInfo("John", "Sen", "105406");
			cp.clickCheckOutContinue();
			Assert.assertTrue(cp.getTxtChcekOutOverview().toLowerCase().contains("checkout: overview"));
			cp.OverView();
			cp.clickBtnFinish();
			Assert.assertTrue(cp.getOrderPlacedMessage().toLowerCase().contains("thank you for your order!"));
			cp.clickBackToHome();

			Assert.assertEquals(llp.getTxtProducts(), "Products");
		} catch(Exception e) {
			System.out.println("No such element exception");
		}
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}
}

