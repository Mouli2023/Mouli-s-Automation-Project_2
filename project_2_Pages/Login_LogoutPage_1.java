package project_2_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login_LogoutPage_1 {

	public WebDriver driver;

	public Login_LogoutPage_1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void Wait_Till_Link_Is_Clickable(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}

	//WebElement
	@FindBy(xpath="//div[text()='Swag Labs']")WebElement txt_Logo;
	By homepagelogo=By.xpath("//div[text()='Swag Labs']");


	@FindBy(xpath="//input[@name='user-name']")WebElement txt_Username;
	By username=By.xpath("//input[@name='user-name']");

	@FindBy(xpath="//input[@name='password']")WebElement txt_Password;
	@FindBy(xpath="//input[@name='login-button']")WebElement btn_Login;
	By loginbutton=By.xpath("//input[@name='login-button']");

	@FindBy(xpath="//div[@class='error-message-container error']")WebElement txt_errorMessage;
	By errormessage=By.xpath("//div[@class='error-message-container error']");

	@FindBy(xpath="//span[@class='title']")WebElement txt_Products;
	By textproduct=By.xpath("//span[@class='title']");

	@FindBy(id="react-burger-menu-btn")WebElement btn_OpenMenu;
	By openmenubutton=By.id("react-burger-menu-btn");

	@FindBy(id="logout_sidebar_link")WebElement btn_Logout;
	By logoutbutton=By.id("logout_sidebar_link");

	@FindBy(id="about_sidebar_link")WebElement btn_About;
	By aboutbutton=By.id("about_sidebar_link");

	@FindBy(id="reset_sidebar_link")WebElement btn_Reset;
	By resetbutton=By.id("reset_sidebar_link");

	//Action Methods
	public String getHomePageLogo() {
		Wait_Till_Link_Is_Clickable(homepagelogo);
		return txt_Logo.getText();
	}

	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}

	public void userName(String UserName) {
		Wait_Till_Link_Is_Clickable(username);
		txt_Username.clear();
		txt_Username.sendKeys(UserName);
	}

	public void passWord(String PassWord) {
		txt_Password.sendKeys(PassWord);
	}

	public void clickLoginBtn() {
		Wait_Till_Link_Is_Clickable(loginbutton);
		btn_Login.click();
	}

	public void getTextErrorMessage() {
		Wait_Till_Link_Is_Clickable(errormessage);
		System.out.println(txt_errorMessage.getText());

		System.out.println(" User is entered wrong username ");
	}

	public String getTxtProducts() {
		Wait_Till_Link_Is_Clickable(textproduct);
		return txt_Products.getText();
	}

	public void clickOpenMenuBtn() {
		Wait_Till_Link_Is_Clickable(openmenubutton);
		btn_OpenMenu.click();
	}

	public void clickLogoutBtn() {
		Wait_Till_Link_Is_Clickable(logoutbutton);
		btn_Logout.click();
	}

	public void clickFuntionMenuList() {
		Wait_Till_Link_Is_Clickable(openmenubutton);
		btn_OpenMenu.click();
		Wait_Till_Link_Is_Clickable(aboutbutton);
		btn_About.click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
		System.out.println(" User is successfully navigated to the 'About' page of saucelabs ");

		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		System.out.println(" User is successfully navigated to the products page ");

		Wait_Till_Link_Is_Clickable(openmenubutton);
		btn_OpenMenu.click();
		Wait_Till_Link_Is_Clickable(resetbutton);
		btn_Reset.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		System.out.println(" After clicking of 'Reset app state' user is navigated to the product page only ");

	}

}
