package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SBear_OrderPage extends SBear_BasePage{
    public SBear_OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement pricePerUnit;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discount;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement total;
    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculate;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement inputCity;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement inputState;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement inputZip;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCredit;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement inputCardNumber;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement inputExpireDate;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

}
