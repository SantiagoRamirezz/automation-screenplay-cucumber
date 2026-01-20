package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonFormActions {

    public static final Target SAVE_BUTTON =
            Target.the("save button for forms")
                    .located(By.cssSelector(".oxd-form-actions button[type='submit']"));
}
