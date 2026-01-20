package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    public static final Target DASHBOARD_HEADER =
            Target.the("dashboard header")
                    .located(By.cssSelector("header.oxd-topbar"));
}
