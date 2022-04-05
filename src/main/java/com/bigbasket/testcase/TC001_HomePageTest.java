package com.bigbasket.testcase;

import org.testng.annotations.Test;

import com.bigbasket.pageobject.HomePage;
import com.bigbasket.pageobject.ItemListPage;

public class TC001_HomePageTest extends BaseClass{
	
	@Test
	public void searchItem()
	{
		HomePage hp=new HomePage(driver);
		ItemListPage ilp=new ItemListPage(driver);
		//hp.setLocation("Kolkata");
		hp.searchItem("Sugar");
		hp.clickOnSubmit();
		ilp.clickAddButton("Sugar");
		hp.searchItem("Salt");
		hp.clickOnSubmit();
	}

}
