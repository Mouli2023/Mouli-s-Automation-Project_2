package project_2_TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import project_2_Pages.Login_LogoutPage_1;

public class TC_1_Login {

	WebDriver driver;
	Login_LogoutPage_1 llp;

	@BeforeTest
	void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\91933\\OneDrive\\Desktop\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
			//Enter Login Credential
			llp.userName("standard_user");
			llp.passWord("secret_sauce");
			llp.clickLoginBtn();

			//Verify All products page is visible
			Assert.assertEquals(llp.getTxtProducts(), "Products");

		} catch (Exception e) {
			System.out.println("No such element exception");
		}
	}

	@Test(priority=4)
	void testLogout() throws InterruptedException {
		try {

			llp.clickLogoutBtn();	

			//Verify navigated to the homepage
			Assert.assertEquals(llp.getHomePageUrl(), "https://www.saucedemo.com/");

		} catch(Exception e){
			System.out.println("No such element exception");
		}
	}

	@Test(priority=5)
	void testSignInWithIncorrectUsername() throws InterruptedException {
		try {
			//Enter Login Credential
			llp.userName("locked_out_user");
			llp.passWord("secret_sauce");
			llp.clickLoginBtn();

			//Verify the Error Message after entering the incorrect username
			llp.getTextErrorMessage();

		} catch (Exception e) {
			System.out.println("No such element exception");
		}
	}

	@Test(priority=3)
	void testFunctionOfMenuList() {

		//Verify the clicking functionality of the tabs present in Menu list
		llp.clickFuntionMenuList();
	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}

}
