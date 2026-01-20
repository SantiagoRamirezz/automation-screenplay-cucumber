package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PimPage {

    public static final Target ADD_EMPLOYEE_BUTTON =
            Target.the("add employee button")
                    .located(By.cssSelector("div.orangehrm-header-container button"));
}
