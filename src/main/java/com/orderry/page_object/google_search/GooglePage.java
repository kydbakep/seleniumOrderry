package com.orderry.page_object.google_search;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class GooglePage {

    public void searchFor(String searchString) {
        $(By.name("q")).val(searchString).pressEnter();
    }
}
