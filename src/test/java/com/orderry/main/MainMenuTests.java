package com.orderry.main;

import com.orderry.page_object.auth.AuthPage;
import com.orderry.page_object.main.MainMenu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.orderry.page_object.main.MainMenuElements.*;

public class MainMenuTests {

    @BeforeClass
    public void logIn(){
        new AuthPage("tober@mail.com", "12345");
    }

    @Test
    public void navigateToSettingsGeneral(){
        MainMenu mainMenu = new MainMenu();
        mainMenu.navigateTo(SETTINGS_MENU.get(), SETTINGS_GENERAL.get());
        SETTINGS_GENERAL.get().should(visible);
    }

    @Test
    public void navigateToSettingsBranches(){
        MainMenu mainMenu = new MainMenu();
        mainMenu.navigateTo(SETTINGS_MENU.get(), SETTINGS_BRANCHES.get());
        SETTINGS_BRANCHES.get().should(visible);
    }

    @Test
    public void navigateToSettingsBranches2(){
        new MainMenu(SETTINGS_MENU.get(), SETTINGS_BRANCHES.get());
        SETTINGS_BRANCHES.get().should(visible);
    }
}
