package com.cybertek.step_definitions;

import com.cybertek.pages.WikiPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wiki_StepDefinitions {
    WikiPage wikiPage = new WikiPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikiUrl"));
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiPage.searchBox.sendKeys(string);
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.button.click();
    }

    @Then("User sees {string} in the wiki title")
    public void user_sees_in_the_wiki_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string + " - Wikipedia";

        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
    }

    @Then("User sees {string} in the main header")
    public void userSeesInTheMainHeader(String arg0) {
        BrowserUtils.sleep(2);
        String actualHeaderText = wikiPage.mainHeader.getText();
        String expectedHeaderText = arg0;
        System.out.println("arg0 = " + arg0);
        System.out.println("actualHeaderText = " + actualHeaderText);

        Assert.assertTrue(actualHeaderText.equals(expectedHeaderText));
        Assert.assertTrue(wikiPage.mainHeader.isDisplayed());
    }
}
