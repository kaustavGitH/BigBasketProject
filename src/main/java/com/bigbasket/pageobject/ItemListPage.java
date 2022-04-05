package com.bigbasket.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemListPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@qa='product']")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@qa='product_name']//a")
	List<WebElement> productNames;
	
	@FindBy(xpath="//div[@qa='rnr_section']/descendant::span[@class='ng-binding ng-scope']")
	List<WebElement> productNoOfRatings;
	
	@FindBy(xpath="//div[@qa='product']/descendant::button[@class='btn btn-default dropdown-toggle form-control']")
	List<WebElement> amountDropdown;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]//a")
	List<WebElement> amountSelector; 
	
	@FindBy(xpath="//div[@qa='qty']/descendant::input[@type='text']")
	List<WebElement> quantityText;
	
	@FindBy(xpath="//div[@qa='product']/descendant::button[@qa='add']")
	List<WebElement> addButton;
	
	public ItemListPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private int selectProduct(String product)
	{
		int max=0,i=0,finalIndex=0;
		while(i<productNoOfRatings.size())
		{
			if(productNames.get(i).getText().contains(product))
			{
				//for(int j=0;j<itemNoOfRatings.size();j++)
				int temp=Integer.parseInt(productNoOfRatings.get(i).getText());
				System.out.println(temp);
				if(temp>max)
				{
					max=temp;
					finalIndex=i;
				}
			}
			i++;
		}
		//System.out.println("Max is "+finalIndex);
		//System.out.println(max);
		return finalIndex;
			
	}
	private void clickOnDropdown(String product)
	{
		//System.out.println(index);
		amountDropdown.get(selectProduct(product)).click();
	}
	private void selectAmount(int amt,String product)
	{
		for(WebElement amount:amountSelector)
		{
			String[]quantity=amount.getText().split(" ");
			int splitAmount=Integer.parseInt(quantity[0]);
			if(splitAmount==amt)
			{
				
			}
		}
	}
	public void clickAddButton(String product)
	{
		//clickOnDropdown(product);
		//selectAmount(1,product);
		int index=selectProduct(product);
		quantityText.get(index).clear();
		quantityText.get(index).sendKeys("2");;
		addButton.get(selectProduct(product)).click();
	}
}

