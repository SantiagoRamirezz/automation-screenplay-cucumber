package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EmployeeListPage {

    public static final Target INPUT_GROUP_CONTAINERS =
            Target.the("employee list input group containers")
                    .located(By.cssSelector(".oxd-input-group"));
}
