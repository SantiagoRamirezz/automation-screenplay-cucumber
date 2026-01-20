package com.automation.screenplay.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Random;

import static com.automation.screenplay.ui.AddEmployeeForm.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddEmployee implements Task {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    private static final String PASSWORD = "Colombia1a@";

    public AddEmployee(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public static Task withPersonalData(String firstName, String middleName, String lastName) {
        return instrumented(AddEmployee.class, firstName, middleName, lastName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String employeeId = generateEmployeeId();
        String username = "user" + employeeId;

        actor.attemptsTo(
                Enter.theValue(firstName).into(FIRST_NAME),
                Enter.theValue(middleName).into(MIDDLE_NAME),
                Enter.theValue(lastName).into(LAST_NAME),
                Click.on(EMPLOYEE_ID),
                SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(EMPLOYEE_ID),
                SendKeys.of(Keys.BACK_SPACE).into(EMPLOYEE_ID),
                Enter.theValue(employeeId).into(EMPLOYEE_ID),

                Click.on(CREATE_LOGIN_DETAILS_SWITCH)
        );

        List<WebElementFacade> containers =
                INPUT_GROUP_CONTAINERS.resolveAllFor(actor);

        writeInputByLabel(containers, "Username", username);
        writeInputByLabel(containers, "Password", PASSWORD);
        writeInputByLabel(containers, "Confirm Password", PASSWORD);

        actor.remember("EMPLOYEE_ID", employeeId);
        actor.remember("EMPLOYEE_NAME", firstName + " "+ middleName + " " + lastName);
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

    private String generateEmployeeId() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}
