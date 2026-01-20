package com.automation.screenplay.stepdefinitions;

import com.automation.screenplay.questions.EmployeeCreationConfirmed;
import com.automation.screenplay.questions.EmployeeListIsDisplayed;
import com.automation.screenplay.questions.EmployeeShouldAppearInList;
import com.automation.screenplay.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EmployeeSteps {

    @When("the user navigates to the PIM module")
    public void navigateToPIM() {
        theActorInTheSpotlight().attemptsTo(
                NavigateToOption.called("PIM")
        );
    }

    @And("the user adds a new employee with login details")
    public void fillEmployeeBasicInfo() {

        theActorInTheSpotlight().attemptsTo(
                ClickAddEmployee.button(),
                AddEmployee.withPersonalData("Juan", "Carlos", "Pérez"),
                SaveForm.now()
        );

        theActorInTheSpotlight().should(
                seeThat(EmployeeCreationConfirmed.successfully())
        );
    }

    @Then("the new employee should appear in the employee list")
    public void searchEmployeeInList() {

        theActorInTheSpotlight().attemptsTo(
                NavigateToOption.called("PIM")
        );

        theActorInTheSpotlight().should(
                seeThat(EmployeeListIsDisplayed.correctly())
        );

        theActorInTheSpotlight().attemptsTo(
                SearchEmployeeById.usingStoredEmployeeId()
        );

        theActorInTheSpotlight().should(
                seeThat(EmployeeShouldAppearInList.successfully())
        );
    }


}
