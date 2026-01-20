package com.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automation.screenplay.ui.PimPage.ADD_EMPLOYEE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickAddEmployee implements Task {

    public static Task button() {
        return instrumented(ClickAddEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ADD_EMPLOYEE_BUTTON)
        );
    }
}
