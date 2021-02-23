package com.cybertek.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/*
We will create utility methods for repeated steps that can be used
in browsers, and store in the class.
 */
public class BrowserUtils {

    //create method name : wait
    //converting milliseconds to seconds
    //handle checked exception

    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){
            System.out.println("Something happened in sleep method");
        }
    }

    /**
     * This method accept List<WebElement> and returns List<String>
     *
     * @param webElementList
     * @return webElementsAsString
     */
    public static List<String> getElementsText(List<WebElement> webElementList) {
        List<String> webElementsAsString = new ArrayList<>();
        for (WebElement each : webElementList) {
            webElementsAsString.add(each.getText());
        }
        return webElementsAsString;
    }

    /*
     Method to assert title
     */

    public static void titleVerification(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
