package com.automation.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automation.screenplay.ui.EmployeeListFilter.EMPLOYEE_INFORMATION_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;

public class EmployeeListIsDisplayed implements Question<Boolean> {

    public static Question<Boolean> correctly() {
        return new EmployeeListIsDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                the(EMPLOYEE_INFORMATION_TITLE, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return true;
    }
}
