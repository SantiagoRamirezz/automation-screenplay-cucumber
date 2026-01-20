package com.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.automation.screenplay.ui.CommonFormActions.SAVE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveForm implements Task {

    public static Task now() {
        return instrumented(SaveForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SAVE_BUTTON)
        );
    }
}

