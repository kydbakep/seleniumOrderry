package com.orderry.page_object.auth;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;
import static com.orderry.page_object.auth.AuthPageElements.*;
import static com.orderry.page_object.project.ProjectElements.SUBMIT_BUTTON;

public class AuthPage {

    public AuthPage() {
        openPage();
    }

    public AuthPage(String login_or_email, String password) {
        openPage().enterAs(login_or_email, password);
    }

    public AuthPage openPage() {
        open("https://dev.remonline.ru");
        return this;
    }

    public void enterAs(String login_or_email, String password) {
        setLogin(login_or_email).setPassword(password).submit();
    }

    public AuthPage setLogin(String login_or_email) {
        LOGIN_INPUT.get().val(login_or_email);
        return this;
    }

    public AuthPage setPassword(String password) {
        PASSWORD_INPUT.get().val(password);
        return this;
    }

    public void submit() {
        SUBMIT_BUTTON.get().click();
    }

    public String getHeader() {
        return HEADER.get().text();
    }

    public void goToRecoveryPasswordPage() {
        PASSWORD_RECOVERY_LINK.get().click();
    }

    public void goToRegisterPage() {
        REGISTRATION_LINK.get().click();
    }

}
