package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Google_StepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {

        Driver.getDriver().get("https://www.google.com");
    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Google";

        Assert.assertTrue(actual.equals(expected));
    }

    @When("User searches for apple")
    public void user_searches_for_apple() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);
    }
    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @When("User searches for {string}")
    public void user_searches_for(String string) {

        googleSearchPage.searchBar.sendKeys(string, Keys.ENTER);
    }

    @Then("User should see {string} in the title")
    public void user_should_see_in_the_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Then("User should see following links")
    public void user_should_see_following_links(List<String> expectedFooterLinks) {
        System.out.println("footerLinks = " + expectedFooterLinks);

        for (WebElement eachLink : googleSearchPage.footerLinks) {
            System.out.println("eachLink = " + eachLink.getText());
        }
    }
}
