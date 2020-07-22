package com.orderry.page_object.main;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum MainMenuElements {
    MAIN_MENU($(By.cssSelector("[data-cid='main_menu']"))),
    AVATAR($(By.cssSelector("[data-cid='main_menu'] img"))),

    GENERAL_MENU($(By.cssSelector("[data-cid='general_menu_group']"))),
    TASKS($($(By.cssSelector("a[href='/taskman']")))),
    ORDERS($($(By.cssSelector("a[href='/orders']")))),
    SHOP($($(By.cssSelector("a[href='/shop']")))),
    PAYMENTS($($(By.cssSelector("a[href='/payments']")))),
    WAREHOUSE($($(By.cssSelector("a[href='/warehouse']")))),
    CLIENTS($($(By.cssSelector("a[href='/clients']")))),

    INDICATORS_MENU($(By.cssSelector("[data-cid='indicators_menu_group']"))),
    ANALYTICS($($(By.cssSelector("a[href='/analytics']")))),
    REPORTS($($(By.cssSelector("a[href='/reports']")))),
    TELEPHONY($($(By.cssSelector("a[href='/telephony']")))),

    SETTINGS_MENU($(By.cssSelector("[data-cid='settings_menu_group']"))),
    SETTINGS_SUBMENU($(By.cssSelector("[data-cid='main_menu-sub_menu']"))),
    SETTINGS_GENERAL($(By.cssSelector("a[href='/settings/general']"))),
    SETTINGS_BRANCHES($(By.cssSelector("a[href='/settings/branches']"))),
    SETTINGS_EMPLOYEES($(By.cssSelector("a[href='/settings/employees']"))),

    SETTINGS_STATUSES($(By.cssSelector("a[href='/settings/statuses']"))),
    SETTINGS_TAGS($(By.cssSelector("a[href='/settings/tags']"))),
    SETTINGS_NOTIFICATIONS($(By.cssSelector("a[href='/settings/notifications']"))),
    SETTINGS_PRICE_LIST($(By.cssSelector("a[href='/settings/services-pricelist']"))),
    SETTINGS_BOOKS($(By.cssSelector("a[href='/settings/book']"))),
    SETTINGS_FORM_EDITOR($(By.cssSelector("a[href='/settings/fe']"))),
    SETTINGS_TEMPLATES($(By.cssSelector("a[href='/settings/document-templates']"))),
    SETTINGS_PRICES($(By.cssSelector("a[href='/settings/prices']"))),
    SETTINGS_MARKETING($(By.cssSelector("a[href='/settings/marketing']"))),

    SETTINGS_INTEGRATIONS($(By.cssSelector("a[href='/settings/integrations']"))),
    SETTINGS_API($(By.cssSelector("a[href='/settings/api']"))),

    SETTINGS_LICENSE($(By.cssSelector("a[href='/settings/license']"))),
    SETTINGS_REFERRALS($(By.cssSelector("a[href='/settings/referrals']")));


    private final SelenideElement element;

    MainMenuElements(SelenideElement locator) {
        this.element = locator;
    }

    public SelenideElement get() {
        return element;
    }
}
