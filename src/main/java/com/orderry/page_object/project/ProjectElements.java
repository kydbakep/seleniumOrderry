package com.orderry.page_object.project;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum ProjectElements {
    SUBMIT_BUTTON($(By.className("js-submit-btn")));

    private final SelenideElement element;

    ProjectElements(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement get() {
        return element;
    }
}
