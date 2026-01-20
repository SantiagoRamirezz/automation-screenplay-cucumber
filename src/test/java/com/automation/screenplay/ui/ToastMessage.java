package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ToastMessage {

    public static final Target TOAST =
            Target.the("confirmation toast message")
                    .located(By.cssSelector(".oxd-toast-container .oxd-toast"));
}
