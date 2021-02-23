package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class SBear_BasePage {

    //Common web elements that can be reached from multiple modules can be stored in BasePage
    // So from each Page class, we just extend to them, and we will have access immediately

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(linkText = "View all products")
    public WebElement viewAllProductsLink;

    @FindBy(linkText = "Order")
    public WebElement orderLink;

}
