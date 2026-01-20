package com.automation.screenplay.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.automation.screenplay.ui.EmployeeListTable.TABLE_ROWS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EmployeeShouldAppearInList implements Question<Boolean> {

    public static Question<Boolean> successfully() {
        return new EmployeeShouldAppearInList();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo( WaitUntil.the(TABLE_ROWS, isVisible()) .forNoMoreThan(10).seconds() );

        List<WebElementFacade> rows;
        long endTime = System.currentTimeMillis() + 10_000; // 10 segundos

        do {
            rows = TABLE_ROWS.resolveAllFor(actor);

            if (rows.size() == 1) {
                break;
            }

            try {
                Thread.sleep(300); // polling corto
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError("Thread interrupted while waiting for table rows");
            }

        } while (System.currentTimeMillis() < endTime);

        if (rows.size() != 1) {
            throw new AssertionError(
                    "Expected exactly 1 row, but found: " + rows.size()
            );
        }

        WebElementFacade row = rows.get(0);
        actor.attemptsTo(
                Scroll.to(row)
        );

        List<WebElementFacade> cells =
                row.thenFindAll(".oxd-table-cell");

        String expectedId = actor.recall("EMPLOYEE_ID");
        String expectedName = actor.recall("EMPLOYEE_NAME");

        String actualId = cells.get(1).getText().trim();
        String actualFirstName = cells.get(2).getText().trim();
        String actualLastName = cells.get(3).getText().trim();

        if (!actualId.equals(expectedId)) {
            throw new AssertionError(
                    "Expected employee id: " + expectedId +
                            " but found: " + actualId
            );
        }

        String fullName = actualFirstName + " " + actualLastName;

        if (!fullName.equals(expectedName)) {
            throw new AssertionError(
                    "Expected employee name: " + expectedName +
                            " but found: " + fullName
            );
        }

        return true;
    }
}
