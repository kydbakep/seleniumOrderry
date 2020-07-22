package com.orderry.page_object.auth;

import static com.orderry.page_object.auth.AuthPageElements.PASSWORD_INPUT;
import static com.orderry.page_object.auth.RegisterPageElements.*;
import static com.orderry.page_object.project.ProjectElements.SUBMIT_BUTTON;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

public class RegisterPage {

    String login = String.format("%s_%s_%s@mail.com",
            new Faker().name().firstName().toLowerCase(),
            new Faker().lorem().characters(2).toLowerCase(),
            new Faker().name().lastName()).toLowerCase();
    String password = "12345";
    String firstName = String.format("%s", new Faker().name().firstName());
    String lastName = String.format("%s", new Faker().name().lastName());
    String company = String.format("%s", new Faker().commerce().department());
    String country = "UA";
    String city = "Київ";
    String phone = "0000000000";
    String templateName = "2";

    public RegisterPage() {
        new AuthPage().goToRegisterPage();
        EMAIL_INPUT.get().setValue(this.login);
        PASSWORD_INPUT.get().setValue(this.password);
        submitForm1();
        FORM_2.get().shouldBe(Condition.visible);
    }

    public RegisterPage(String login) {
        EMAIL_INPUT.get().setValue(login);
        PASSWORD_INPUT.get().setValue(this.password);
        submitForm1();
        FORM_2.get().shouldBe(Condition.visible);
    }

    public RegisterPage(String login, String password) {
        EMAIL_INPUT.get().setValue(login);
        PASSWORD_INPUT.get().setValue(password);
        submitForm1();
        FORM_2.get().shouldBe(Condition.visible);
    }

    public RegisterPage setRegistrationData() {
        setFirstName(this.firstName);
        setLastName(this.lastName);
        setCompany(this.company);
        setCountry(this.country);
        setCity(this.city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName) {
        setFirstName(firstName);
        setLastName(this.lastName);
        setCompany(this.company);
        setCountry(this.country);
        setCity(this.city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(this.country);
        setCompany(this.company);
        setCity(this.city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName, String country) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
        setCompany(this.company);
        setCity(this.city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName, String country, String company) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
        setCompany(company);
        setCity(this.city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName, String country, String company,
                                            String city) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
        setCompany(company);
        setCity(city);
        setPhone(this.phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName, String country, String company,
                                            String city, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
        setCompany(company);
        setCity(city);
        setPhone(phone);
        setTemplate(this.templateName);
        return this;
    }

    public RegisterPage setRegistrationData(String firstName, String lastName, String country, String company,
                                            String city, String phone, String templateName) {
        setFirstName(firstName);
        setLastName(lastName);
        setCountry(country);
        setCompany(company);
        setCity(city);
        setPhone(phone);
        setTemplate(templateName);
        return this;
    }


    public void submitForm1() {
        SelenideElement button = SUBMIT_BUTTON.get();
        button.click();
    }

    public void submitForm2() {
        SelenideElement button = F2_SUBMIT_BUTTON.get();
        button.click();
    }

    private void setFirstName(String firstName) {
        FIRST_NAME_INPUT.get().setValue(firstName);
    }

    private void setLastName(String lastName) {
        LAST_NAME_INPUT.get().setValue(lastName);
    }

    private void setCompany(String company) {
        COMPANY_INPUT.get().setValue(company);
    }

    private void setCountry(String country) {
        COUNTRY_SELECT.get().selectOptionByValue(country);
    }

    private void setCity(String city) {
        CITY_INPUT.get().setValue(city);
    }

    private void setPhone(String phone) {
        PHONE_INPUT.get().click();
        PHONE_INPUT.get().sendKeys(phone);
    }

    private void setTemplate(String template) {
        TEMPLATE_SELECT.get().selectOptionByValue(template);
    }
}
