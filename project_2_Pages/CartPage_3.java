package project_2_Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage_3 {

	public WebDriver driver;

	public CartPage_3(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void Wait_Till_Link_Is_Clickable(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}

	//WebElement
	@FindBy(xpath="(//div[@class='inventory_item_name '])[1]")
	public WebElement first_Product;
	By firstproduct=By.xpath("(//div[@class='inventory_item_name '])[1]");

	@FindBy(xpath="(//div[@class='inventory_item_name '])[2]")
	public WebElement second_Product;
	By secondproduct=By.xpath("(//div[@class='inventory_item_name '])[2]");

	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public WebElement first_ProductAddToCart;
	By addtocart_1= By.id("add-to-cart-sauce-labs-backpack");

	@FindBy(xpath="//button[@data-test='add-to-cart-sauce-labs-bike-light']")
	public WebElement second_ProductAddToCart;
	By addtocart_2= By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']");

	@FindBy(id="shopping_cart_container")WebElement btn_ViewCart;
	By viewcart=By.id("shopping_cart_container");

	@FindBy(xpath="//span[@class='shopping_cart_badge']")WebElement txt_CartContainerValue;
	By cartvalue=By.xpath("//span[@class='shopping_cart_badge']");

	@FindBy(xpath="//div[@class='cart_list']")List<WebElement> list_Cart;
	By cartlist=By.xpath("//div[@class='cart_list']");

	@FindBy(xpath="(//div[@class='inventory_item_price'])[1]")WebElement cart_price1;
	@FindBy(xpath="(//div[@class='cart_quantity'])[1]")WebElement cart_Qyantity1;

	@FindBy(xpath="(//div[@class='inventory_item_price'])[2]")WebElement cart_price2;
	@FindBy(xpath="(//div[@class='cart_quantity'])[2]")WebElement cart_Qyantity2;

	@FindBy(xpath="//button[@data-test='continue-shopping']")WebElement btn_ShoppingContinue;
	By continueshopping=By.xpath("//button[@data-test='continue-shopping']");

	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")WebElement btn_Remove;

	@FindBy(xpath="//button[@id='checkout']")WebElement btn_CheckOut;

	@FindBy(xpath="//input[@name='firstName']")WebElement txt_FName;
	@FindBy(xpath="//input[@name='lastName']")WebElement txt_LName;
	@FindBy(xpath="//input[@name='postalCode']")WebElement txt_PostalCode;

	@FindBy(xpath="//input[@name='continue']")WebElement btn_Continue_ChcekOut;

	@FindBy(xpath="//span[text()='Checkout: Overview']")WebElement txt_ChcekOut_Overview;
	@FindBy(xpath="//div[@class='summary_info']")List<WebElement> ChcekOutOverview;

	@FindBy(xpath="//button[@id='finish']")WebElement btn_Finish;
	@FindBy(xpath="//h2[text()='Thank you for your order!']")WebElement txt_OrderComplete;
	@FindBy(xpath="//button[@name='back-to-products']")WebElement btn_BackHome;

	//Action Methods
	public void productsAddToCart() throws InterruptedException {
		Actions action = new Actions(driver);
		Wait_Till_Link_Is_Clickable(firstproduct);
		action.moveToElement(first_Product).perform();
		Wait_Till_Link_Is_Clickable(addtocart_1);
		action.moveToElement(first_ProductAddToCart).click();
		
		Wait_Till_Link_Is_Clickable(secondproduct);
		action.moveToElement(second_Product).perform();
		Wait_Till_Link_Is_Clickable(addtocart_2);
		action.moveToElement(second_ProductAddToCart).click();	
	}

	public String getQuantityTextViewCart() {
		Wait_Till_Link_Is_Clickable(cartvalue);
		return txt_CartContainerValue.getText();
	}

	public void actionBtnViewCart() {
		Actions action = new Actions(driver);
		Wait_Till_Link_Is_Clickable(viewcart);
		action.moveToElement(btn_ViewCart).perform();		
	}

	public void clickBtnViewCart() {
		Wait_Till_Link_Is_Clickable(viewcart);
		btn_ViewCart.click();		
	}

	public List<WebElement>CartList(){
		Wait_Till_Link_Is_Clickable(cartlist);
		System.out.println(list_Cart.size());
		if(list_Cart.size()>=2) {
			System.out.println("Both products are added to cart");
		}
		else{
			System.out.println("Both the products are not added to cart");
		}
		return null;		
	}

	public void getDetailsCartProduct() {
		System.out.println(" The Price of first product is " + cart_price1.getText());
		System.out.println(" The Quantity of first product is " + cart_Qyantity1.getText());
		System.out.println(" The Price of second product is " + cart_price2.getText());
		System.out.println(" The Quantity of second product is " + cart_Qyantity2.getText());

		System.out.println(" Price & Quantity of both the products are verified ");
	}

	public void clickShoppingContinue() {
		Wait_Till_Link_Is_Clickable(continueshopping);
		btn_ShoppingContinue.click();
	}

	public void clickBtnRemove() {
		btn_Remove.click();
	}

	public void clickBtnChcekOut() {
		btn_CheckOut.click();
	}

	public String getTxtChcekOutInfo() {
		return driver.getCurrentUrl();
	}

	public void enterCheckOutInfo(String firstname, String lastname, String zipcode) {
		txt_FName.clear();
		txt_FName.sendKeys(firstname);
		txt_LName.clear();
		txt_FName.sendKeys(lastname);
		txt_PostalCode.clear();
		txt_FName.sendKeys(zipcode);
	}

	public void clickCheckOutContinue() {
		btn_Continue_ChcekOut.click();
	}

	public String getTxtChcekOutOverview() {
		return txt_ChcekOut_Overview.getText();
	}

	public List<WebElement>OverView(){
		for(WebElement info:ChcekOutOverview) {
			System.out.println(info.getText());		
		}
		return null;
	}

	public void clickBtnFinish() {
		btn_Finish.click();
	}

	public String getOrderPlacedMessage() {
		return txt_OrderComplete.getText();
	}

	public void clickBackToHome() {
		btn_BackHome.click();
	}

	public void placeOrder() {
		Actions action = new Actions(driver);
		Wait_Till_Link_Is_Clickable(firstproduct);
		action.moveToElement(first_Product).perform();
		Wait_Till_Link_Is_Clickable(addtocart_1);
		action.moveToElement(first_ProductAddToCart).click();

		Wait_Till_Link_Is_Clickable(viewcart);
		btn_ViewCart.click();	

		Wait_Till_Link_Is_Clickable(continueshopping);
		btn_ShoppingContinue.click();

		Wait_Till_Link_Is_Clickable(secondproduct);
		action.moveToElement(second_Product).perform();
		Wait_Till_Link_Is_Clickable(addtocart_2);
		action.moveToElement(second_ProductAddToCart).click();	

		Wait_Till_Link_Is_Clickable(viewcart);
		btn_ViewCart.click();	
	}
}





