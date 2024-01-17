package project_2_Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllProductsPage_2 {

	public WebDriver driver;

	public AllProductsPage_2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void Wait_Till_Link_Is_Clickable(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}

	//WebElement
	@FindBy(xpath="//div[@class='inventory_item_name ']")List<WebElement> list_AllProducts;
	By allproductlist=By.xpath("//div[@class='inventory_item_name ']");

	@FindBy(xpath="(//div[@class='inventory_item_label'])[1]")WebElement first_ProductDescription;
	@FindBy(xpath="(//div[@class='inventory_item_price'])[1]")WebElement first_ProductPrice;

	@FindBy(xpath="//div[@class='footer_copy']")WebElement txt_Footer;
	By footertext=By.xpath("//div[@class='footer_copy']");

	@FindBy(className="social")WebElement Footer;
	By footer=By.className("social");

	@FindBy(tagName="li")List<WebElement> Links;

	@FindBy(className="social_twitter")WebElement link_Twitter;
	By twitterlink=By.className("social_twitter");

	@FindBy(className="social_facebook")WebElement link_fb;
	By fblink=By.className("social_facebook");

	@FindBy(className="social_linkedin")WebElement link_linkdin;
	By linkdin=By.className("social_linkedin");


	//Action Methods
	public List<WebElement> productList(){
		Wait_Till_Link_Is_Clickable(allproductlist);
		System.out.println(list_AllProducts.size());
		for(WebElement products:list_AllProducts) 
			System.out.println(products.getText());

		return null;		
	}

	public void getFirstProductDetails() {
		System.out.println(" Product Desription : " +  first_ProductDescription.getText());
		System.out.println(" Price : " +  first_ProductPrice.getText());
	}

	public String getFooterText() {
		Wait_Till_Link_Is_Clickable(footertext);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,600)");
		return txt_Footer.getText();
	}

	public List<WebElement>Links(){
		Wait_Till_Link_Is_Clickable(footer);
		int count=Links.size();
		System.out.println(" The total number of links present at footer is " + count);
		return null;
	}

	public void socialmediaWindowHandle() {
		Wait_Till_Link_Is_Clickable(twitterlink);
		link_Twitter.click();

		Wait_Till_Link_Is_Clickable(fblink);
		link_fb.click();

		Wait_Till_Link_Is_Clickable(linkdin);
		link_linkdin.click();

		driver.quit();
	}

}
