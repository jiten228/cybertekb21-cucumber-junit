package com.cybertek.step_definitions;

import com.cybertek.pages.SBear_OrderPage;
import com.cybertek.pages.SBear_ViewAllOrderPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class ScenarioOutlines_StepDefinitions {
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    SBear_OrderPage sBearOrderPage = new SBear_OrderPage();
    SBear_ViewAllOrderPage sBear_viewAllOrdersPage = new SBear_ViewAllOrderPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        smartBearLoginPage.loginToSmartBear();
        sBearOrderPage.orderLink.click();
    }

    @When("User fills out the form as followed from the table below:")
    public void user_fills_out_the_form_as_followed_from_the_table_below() {

    }

    @When("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {
        Select productDropdown = new Select(sBearOrderPage.productDropdown);
        productDropdown.selectByVisibleText(string);
    }

    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {
        sBearOrderPage.quantity.sendKeys(Keys.BACK_SPACE + string);
    }

    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String string) {
        sBearOrderPage.customerName.sendKeys(string);
    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String string) {
        sBearOrderPage.street.sendKeys(string);
    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String string) {
        sBearOrderPage.inputCity.sendKeys(string);
    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String string) {
        sBearOrderPage.inputState.sendKeys(string);
    }

    @When("User enters {string} to zip")
    public void user_enters_to_zip(String string) {
        sBearOrderPage.inputZip.sendKeys(string);
    }

    @When("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {
        sBearOrderPage.visaCredit.click();
    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {
        sBearOrderPage.inputCardNumber.sendKeys(string);
    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {
        sBearOrderPage.inputExpireDate.sendKeys(string);
    }

    @When("User clicks process button")
    public void user_clicks_process_button() {
        sBearOrderPage.processButton.click();
    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String expectedName) {
        sBearOrderPage.viewAllOrdersLink.click();
BrowserUtils.sleep(5);
        String actualName = sBear_viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertTrue(actualName.equals(expectedName));

    }

}
