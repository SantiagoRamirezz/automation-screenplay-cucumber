package com.automation.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Sidebar {

    public static final Target MAIN_MENU_OPTIONS =
            Target.the("main menu options in the sidebar")
                    .located(By.cssSelector("ul.oxd-main-menu li > a"));

}
