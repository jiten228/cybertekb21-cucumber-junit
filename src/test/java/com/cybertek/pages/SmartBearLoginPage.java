package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement inputUsername;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement inputPassword;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    //login method where we dont have to pass username, password (hardcode)
    public void loginToSmartBear(){
        inputUsername.sendKeys("Tester");
        inputPassword.sendKeys("test");
        loginButton.click();;
    }

    //overloaded version where we can pass username and password
    public void loginToSmartBear(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    //login method where we can pass data from configuration.properties
    public void loginToSmartBear_Config(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("sbUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("sbPassword"));
        loginButton.click();
    }
}
