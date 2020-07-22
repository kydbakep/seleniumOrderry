package com.orderry.page_object.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.orderry.page_object.main.MainMenuElements.MAIN_MENU;

public class MainMenu {

    public MainMenu() {
        MAIN_MENU.get().shouldBe(Condition.visible);
    }

    public MainMenu(SelenideElement target){

        MAIN_MENU.get().shouldBe(Condition.visible);
        navigateTo(target);
    }

    public MainMenu(SelenideElement first_target, SelenideElement second_target){
        MAIN_MENU.get().shouldBe(Condition.visible);
        navigateTo(first_target, second_target);
    }

    public void navigateTo(SelenideElement target){
        MAIN_MENU.get().shouldBe(Condition.visible);
        target.click();
    }

    public void navigateTo(SelenideElement... elements){
        MAIN_MENU.get().shouldBe(Condition.visible);
        for (SelenideElement element: elements){
            element.click();
        }
    }

}
