package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeListFilter {

    public static final Target EMPLOYEE_INFORMATION_TITLE =
            Target.the("employee information filter title")
                    .located(By.cssSelector(".oxd-table-filter-header h5"));
}
