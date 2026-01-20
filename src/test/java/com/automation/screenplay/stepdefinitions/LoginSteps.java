package com.automation.screenplay.stepdefinitions;

import com.automation.screenplay.tasks.OpenTheApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.automation.screenplay.questions.DashboardIsVisible.*;
import static com.automation.screenplay.tasks.Login.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    @Given("the user logs in with valid credentials")
    public void login() {
        theActorInTheSpotlight().attemptsTo(
                OpenTheApplication.atHomePage(),
                withCredentials("Admin", "admin123")
        );
    }

    @Then("the dashboard should be visible")
    public void dashboardVisible() {
        theActorInTheSpotlight().should(
                seeThat(displayed(), is(true))
        );
    }
}
