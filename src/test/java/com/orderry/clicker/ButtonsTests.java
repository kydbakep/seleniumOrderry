package com.orderry.clicker;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.InvalidStateException;
import com.orderry.page_object.auth.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static com.codeborne.selenide.Selenide.*;

public class ButtonsTests {

    private void waitForPageLoads() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private void openPage(String page) {
        open(page);
        waitForPageLoads();
    }

    @BeforeClass
    public void register() {
        new RegisterPage().setRegistrationData().submitForm2();
        waitForPageLoads();
    }

    @Test
    public void clickButtons() {
        String url = WebDriverRunner.driver().url();
        ElementsCollection elements = $$x(("//button[@class]")).filterBy(Condition.visible);
        System.out.println(elements.size());
        List<String> els = new LinkedList<>();
        for (SelenideElement element : elements) {
            String cls = element.shouldBe(Condition.exist).getAttribute("class");
            els.add(cls);
        }

        for (String elem : els) {
            int sub_size = $$x((String.format("//button[@class='%s']", elem))).size();
            if (sub_size > 0) {
                for (int i = 0; i < sub_size; i++) {
                    String z = elem;
                    $$x((String.format("//button[@class='%s']", z))).get(i).click();
                    open(url);
                }
            } else {
                String x = elem;
                $x((String.format("//button[@class='%s']", x))).click();
                open(url);
            }

        }
    }

    @Test
    public void click2() {
        Map<String, List<SelenideElement>> collection = getVisiblePageElementsByXpath("//button[@class]");
        String page = collection.keySet().iterator().next();
        List<SelenideElement> elements = collection.values().iterator().next();
        Set<String> attributes = getAttributes(elements, "class");

        for (String attribute : attributes) {
            Set<String> els = getElementLocators(attribute);
            for (String el : els) {
                SelenideElement button = $x(el);
                String firstAncestor = "";
                try {
                    firstAncestor = el + "//ancestor::a";
                    SelenideElement huy = $x(firstAncestor);
                    String at = huy.getAttribute("aria-current");
                    if (at != null && at.equals("page")) {
                        button = huy;
                    }
                } catch (Throwable t) {}

                String state = String.format("%s: ", el);
                try {
                    clickButton(button);
                    System.out.println(page + " -- " + state + " OK");
                    // GET NEW PAGE WITH NEW BUTTONS AND ITERATE SAME
                } catch (InvalidStateException e) {
                    String secondAncestor = firstAncestor + "/..";
                    button = $x(secondAncestor);
                    try {
                        clickButton(button);
                        System.out.println(page + " -- " + state + " OK");
                    } catch (InvalidStateException e2) {
                        System.out.println(page + " -- " + secondAncestor + e.getClass());
                    }
                }
                openPage(page);
            }
        }

        System.out.println("finish");
    }

    private void clickButton(SelenideElement button) {
        button.click();
        waitForPageLoads();
    }

    private Set<String> getElementLocators(String cls) {
        sleep(1500);
        String locator = String.format("//button[@class='%s']", cls);
        ElementsCollection elements = $$x(locator);
        Set<String> locators = new HashSet<>();
        for (int i = 0; i < elements.size(); i++) {
            String xpath = String.format("(%s)[%d]", locator, i + 1);
            locators.add(xpath);
        }
        return locators;
    }

    private Set<String> getAttributes(List<SelenideElement> elements, String attribute) {
        Set<String> attributes = new HashSet<>();
        for (SelenideElement element : elements) {
            attributes.add(element.shouldBe(Condition.visible).attr(attribute));
        }
        return attributes;
    }

    private Map<String, List<SelenideElement>> getVisiblePageElementsByXpath(String xpath) {
        sleep(3000);
        ElementsCollection elements = $$x(xpath).exclude(Condition.not(Condition.be(Condition.visible)));
        String page = WebDriverRunner.driver().url();
        Map<String, List<SelenideElement>> map = new HashMap<>();
        map.put(page, elements);
        return map;
    }
}
