package project_2_Pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductFilterPage_4 {

public WebDriver driver;
	
	public ProductFilterPage_4(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Wait_Till_Link_Is_Clickable(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}
	
	//WebElement
//	@FindBy(xpath="//span[@class='select_container']/select")WebElement product_Filter;
//	By filtericon=By.xpath("//span[@class='select_container']/select");
	
	@FindBy(xpath="//select[@class='product_sort_container']")WebElement select_Filter;
	By selectFilter=By.xpath("//select[@class='product_sort_container']");
	
	@FindBy(xpath="//div[@class='inventory_item_name']")List<WebElement> ProductName_List;
	By ProductNameList=By.xpath("//div[@class='inventory_item_name']");
	
//	@FindBy(css="inventory_item_name")List<WebElement> ProductName_List;
//	By ProductNameList=By.cssSelector("inventory_item_name");
	
	
	
	//Action Method
//	public void clickFilterIcon() {
//		Wait_Till_Link_Is_Clickable(filtericon);
//		product_Filter.click();
//	}
	
	public List<WebElement> getAtoZFilterOptions() {
		Select select = new Select(select_Filter);
		Wait_Till_Link_Is_Clickable(selectFilter);
		select_Filter.click();
		select.selectByValue("az");
		
		//Wait_Till_Link_Is_Clickable(ProductNameList);
		List<String>originalList=ProductName_List.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));	
		
		return getAtoZFilterOptions();
	}
	
	public List<WebElement> getZtoAFilterOptions() {
		Select select = new Select(select_Filter);
		Wait_Till_Link_Is_Clickable(selectFilter);
		select_Filter.click();
		select.selectByValue("za");
		
		//Wait_Till_Link_Is_Clickable(ProductNameList);
		List<String>originalList=ProductName_List.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));	
		
		return getZtoAFilterOptions();
	}
	
	public List<WebElement> getLowtoHighFilterOptions() {
		Select select = new Select(select_Filter);
		Wait_Till_Link_Is_Clickable(selectFilter);
		select_Filter.click();
		select.selectByValue("lohi");
		
		//Wait_Till_Link_Is_Clickable(ProductNameList);
		List<String>originalList=ProductName_List.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));	
		
		return getLowtoHighFilterOptions();
	}
	
	public List<WebElement> getHightoLowFilterOptions() {
		Select select = new Select(select_Filter);
		Wait_Till_Link_Is_Clickable(selectFilter);
		select_Filter.click();
		select.selectByValue("hilo");
		
		//Wait_Till_Link_Is_Clickable(ProductNameList);
		List<String>originalList=ProductName_List.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));	
		
		return getHightoLowFilterOptions();
	}
}
