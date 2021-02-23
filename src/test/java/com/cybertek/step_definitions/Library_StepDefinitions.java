package com.cybertek.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Library_StepDefinitions {

    @Given("user in on the login page")
    public void user_in_on_the_login_page() {
        System.out.println("User is on the login page:");
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters LIBRARIAN username");

        //Intentionally failing this step
        //Assert.fail("INTENTIONAL FALI!!!!");
    }

    @When("user enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("User enters LIBRARIAN password");
    }

    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        System.out.println("User sees dashboard");
    }

    @When("user enters student username")
    public void userEntersStudentUsername() {
        System.out.println("User enters STUDENT username");
    }

    @And("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("User enters STUDENT password");
    }

    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("User enters ADMIN username");
    }

    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("User enters ADMIN password");
    }
}