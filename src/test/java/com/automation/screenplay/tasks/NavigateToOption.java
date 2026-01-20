package com.automation.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.automation.screenplay.ui.Sidebar.MAIN_MENU_OPTIONS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToOption implements Task {

    private final String option;

    public NavigateToOption(String option) {
        this.option = option;
    }

    public static Task called(String option) {
        return instrumented(NavigateToOption.class, option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<net.serenitybdd.core.pages.WebElementFacade> options =
                MAIN_MENU_OPTIONS.resolveAllFor(actor);

        options.stream()
                .filter(element -> element.getText().trim().equalsIgnoreCase(option))
                .findFirst()
                .ifPresent(element ->
                        actor.attemptsTo(
                                Click.on(element)
                        )
                );
    }
}
