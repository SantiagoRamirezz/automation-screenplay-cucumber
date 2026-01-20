package com.automation.screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static com.automation.screenplay.ui.DashboardPage.DASHBOARD_HEADER;

public class DashboardIsVisible {

    public static Question<Boolean> displayed() {
        return actor ->
                WebElementQuestion.the(DASHBOARD_HEADER)
                        .answeredBy(actor)
                        .isVisible();
    }
}
