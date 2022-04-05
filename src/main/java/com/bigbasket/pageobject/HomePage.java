package com.bigbasket.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="input")
	WebElement searchBar;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(className="hvc")
	WebElement locationSelector;
	
	@FindBy(xpath="//div[@qa='cityDD']")
	WebElement selectCity;
	
	public HomePage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String item)
	{
		searchBar.sendKeys(item);
	}
	public void clickOnSubmit()
	{
		submitButton.click();
	}
	public void setLocation(String cityName)
	{
		locationSelector.click();
		selectCity.click();
		selectCity.sendKeys(cityName);
		List<WebElement>cityList=driver.findElements(By.xpath("//span[@qa='citySelectList']"));
		for(WebElement city:cityList)
		{
			if(city.getText().contains(cityName))
			{
				city.click();
				break;
			}
		}
	}
	

}
