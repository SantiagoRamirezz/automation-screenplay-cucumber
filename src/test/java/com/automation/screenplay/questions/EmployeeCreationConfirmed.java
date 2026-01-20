package com.automation.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automation.screenplay.ui.ToastMessage.TOAST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;

public class EmployeeCreationConfirmed implements Question<Boolean> {

    public static Question<Boolean> successfully() {
        return new EmployeeCreationConfirmed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                the(TOAST, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        actor.attemptsTo(
                the(TOAST, isNotVisible())
                        .forNoMoreThan(10).seconds()
        );

        return true;
    }
}
