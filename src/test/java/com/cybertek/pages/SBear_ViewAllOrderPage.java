package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SBear_ViewAllOrderPage extends SBear_BasePage{

    public SBear_ViewAllOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement newCustomerCell;
}
