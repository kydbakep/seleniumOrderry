package com.orderry.auth;

import com.codeborne.selenide.Configuration;
import com.orderry.page_object.auth.AuthPage;
import com.orderry.page_object.auth.RegisterPage;
import com.orderry.page_object.main.MainMenu;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthTests {
    @BeforeClass
    public void setUp() {
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.headless = false;
    }

    @Test
    public void canAuthorize() {
        new AuthPage("tober@mail.com", "12345");
        $(By.cssSelector("[data-cid='main_menu']")).should(be(visible));
    }

    @Test
    public void canRegister() {
        new RegisterPage().setRegistrationData().submitForm2();
        $(By.cssSelector("[data-cid='main_menu']")).should(be(visible));
    }

    @AfterMethod
    public void logOut() {
        new MainMenu();
        $(By.cssSelector("[data-cid='main_menu'] img")).click();
        $(By.cssSelector("[data-cid='avatar-menu-logout']")).click();
    }

}
