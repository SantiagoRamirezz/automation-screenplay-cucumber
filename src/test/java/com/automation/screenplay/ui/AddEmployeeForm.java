package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddEmployeeForm {
    public static final Target FIRST_NAME =
            Target.the("first name input")
                    .located(By.name("firstName"));

    public static final Target MIDDLE_NAME =
            Target.the("middle name input")
                    .located(By.name("middleName"));

    public static final Target LAST_NAME =
            Target.the("last name input")
                    .located(By.name("lastName"));

    public static final Target EMPLOYEE_ID =
            Target.the("employee id input")
                    .located(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input"));

    public static final Target CREATE_LOGIN_DETAILS_SWITCH =
            Target.the("create login details switch")
                    .located(By.cssSelector(".user-form-header .oxd-switch-wrapper"));

    public static final Target INPUT_GROUP_CONTAINERS =
            Target.the("input group containers")
                    .located(By.cssSelector(".user-form-header ~ .oxd-form-row .oxd-input-group"));
}
