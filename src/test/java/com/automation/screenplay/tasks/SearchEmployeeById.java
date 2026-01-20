package com.automation.screenplay.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

import java.util.List;

import static com.automation.screenplay.ui.EmployeeListPage.INPUT_GROUP_CONTAINERS;
import static com.automation.screenplay.ui.CommonFormActions.SAVE_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchEmployeeById implements Task {

    public static Task usingStoredEmployeeId() {
        return instrumented(SearchEmployeeById.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String employeeId = actor.recall("EMPLOYEE_ID");

        List<WebElementFacade> containers =
                INPUT_GROUP_CONTAINERS.resolveAllFor(actor);

        writeInputByLabel(containers, "Employee Id", employeeId);

        actor.attemptsTo(
                Click.on(SAVE_BUTTON)
        );
    }

    private void writeInputByLabel(List<WebElementFacade> containers,
                                   String labelText,
                                   String value) {

        for (WebElementFacade container : containers) {

            if (!container.containsElements(By.cssSelector("label.oxd-label"))) {
                continue;
            }

            String label = container
                    .find(By.cssSelector("label.oxd-label"))
                    .getText()
                    .trim();

            if (label.equalsIgnoreCase(labelText)) {

                WebElementFacade input =
                        container.find(By.cssSelector("input"));

                input.clear();
                input.sendKeys(value);
                return;
            }
        }

        throw new AssertionError("Input not found for label: " + labelText);
    }
}
