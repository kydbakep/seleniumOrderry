package com.orderry.page_object.auth;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum AuthPageElements {
    REGISTRATION_LINK($(By.cssSelector("a[href='/registration']"))),
    HEADER($(By.className("b-entrance__right__title h2"))),
    LOGIN_INPUT($(By.id("l-auth-login"))),
    PASSWORD_INPUT($(By.id("l-auth-pass"))),
    SHOW_PASSWORD_BUTTON($(By.cssSelector(".js-password-watch-box .b-entrance__eye"))),
    PASSWORD_RECOVERY_LINK($(By.cssSelector("a[href='/recovery-password']")));


    private final SelenideElement element;

    AuthPageElements(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement get() {
        return element;
    }
}