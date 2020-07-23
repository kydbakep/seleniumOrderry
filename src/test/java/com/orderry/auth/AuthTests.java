package com.orderry.auth;

import com.codeborne.selenide.Configuration;
import com.orderry.helper.system.properties.PropertiesLoader;
import com.orderry.page_object.auth.AuthPage;
import com.orderry.page_object.auth.RegisterPage;
import com.orderry.page_object.main.MainMenu;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthTests {
    PropertiesLoader properties = new PropertiesLoader();

    @BeforeClass
    public void setUp() throws IOException {
        Configuration.timeout = Long.parseLong(properties.getSelenideProperty("timeout"));
        Configuration.browser = properties.getSelenideProperty("browser");
        Configuration.startMaximized = Boolean.parseBoolean(properties.getSelenideProperty("startMaximized"));
        Configuration.headless = Boolean.parseBoolean(properties.getSelenideProperty("headless"));
    }

    @Test
    public void canAuthorize() {
        new AuthPage("tober@mail.com", "12345");
        $("[data-cid='main_menu']").should(be(visible));
    }

    @Test
    public void canRegister() throws IOException {
        new RegisterPage().setRegistrationData().submitForm2();

        $("[data-cid='main_menu']").should(be(visible));
    }

    @AfterMethod
    public void logOut() {
        new MainMenu();
        $("[data-cid='main_menu'] img").click();
        $("[data-cid='avatar-menu-logout']").click();
    }

}
