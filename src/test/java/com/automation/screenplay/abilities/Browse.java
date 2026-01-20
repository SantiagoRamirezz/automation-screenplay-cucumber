package com.automation.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Browse {
    public static Ability with(WebDriver driver) {
        return BrowseTheWeb.with(driver);
    }
}
