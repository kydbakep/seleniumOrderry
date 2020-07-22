package com.orderry.google_tests;

import com.codeborne.selenide.Configuration;
import com.orderry.page_object.google_search.GooglePage;
import com.orderry.page_object.google_search.SearchResultsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {

    @BeforeClass
    public void setUp() {
        Configuration.timeout = 4000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.headless = false;
    }

    @Test
    public void userCanSearch() {
        open("https://google.com");
        new GooglePage().searchFor("Tober");
        SearchResultsPage results = new SearchResultsPage();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("Tober"));
    }

}
