package com.automation.screenplay.stepdefinitions;

import com.automation.screenplay.abilities.Browse;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());

        theActorCalled("User").can(
                Browse.with(net.serenitybdd.screenplay.abilities.BrowseTheWeb.as(theActorCalled("User")).getDriver())
        );
    }
}
