package project_2_TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import project_2_Pages.Login_LogoutPage_1;
import project_2_Pages.ProductFilterPage_4;

public class TC_4_Filter {
	WebDriver driver;
	Login_LogoutPage_1 llp;
	ProductFilterPage_4 pfp;

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
	void testProductFilter() {
		try{
			pfp=new ProductFilterPage_4(driver);
			pfp.getAtoZFilterOptions();
			pfp.getZtoAFilterOptions();
			pfp.getLowtoHighFilterOptions();
			pfp.getHightoLowFilterOptions();

		} catch(Exception e) {
			System.out.println("Xpath expression is wrong");
		}

	}

	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
