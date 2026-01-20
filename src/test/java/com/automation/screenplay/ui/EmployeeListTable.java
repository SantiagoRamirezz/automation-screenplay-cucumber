package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeListTable {

    public static final Target TABLE_ROWS =
            Target.the("employee table rows")
                    .located(By.cssSelector(
                            ".orangehrm-container .oxd-table-body .oxd-table-card"
                    ));
}
