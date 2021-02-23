package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Etsy_StepDefinitions {
    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("user is on the etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
    }

    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertTrue(actual.equals(expected));
    }

    @When("user searches for {string}")
    public void userSearchesFor(String arg0) {
        etsySearchPage.searchBox.sendKeys(arg0, Keys.ENTER);
    }

    @Then("user should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String arg0) {
        String actual = Driver.getDriver().getTitle();
        String expected = arg0 + " | Etsy";     // make it dynamic for any type of search
        Assert.assertTrue(actual.equals(expected));
    }
}
