package com.orderry.page_object.auth;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.orderry.page_object.project.ProjectElements.SUBMIT_BUTTON;


public enum RegisterPageElements {
    FORM_2($(".b-modal_type_registration")),
    FIRST_NAME_INPUT($("input[id='l-auth-name']")),
    LAST_NAME_INPUT($("input[id='l-auth-lname']")),
    EMAIL_INPUT($("input[id='l-auth-email']")),
    COMPANY_INPUT($("input[id='l-auth-company']")),
    COUNTRY_SELECT($("select[name='country']")),
    CITY_INPUT($("input[id='l-auth-city']")),
    PHONE_INPUT($("input[id='l-auth-phone']")),
    TEMPLATE_SELECT($("select[name='template_id']")),

    F1_SUBMIT_BUTTON(SUBMIT_BUTTON.get()),
    F2_SUBMIT_BUTTON($(By.className("js-submit")));


    private final SelenideElement element;

    RegisterPageElements(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement get() {
        return element;
    }
}