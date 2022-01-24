package yandex.oshkin.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import yandex.oshkin.pages.RegistrationPage;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phoneNumber = faker.number().digits(10);

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .selectGender("Male")
                .setPhoneNumber(phoneNumber)
                .setBirthDate("05", "June", "1988")
                .setSubject("Physics")
                .setSubject("Maths")
                .selectHobbies("Sports")
                .selectHobbies("Music")
                .uploadPicture("img/sketching8.jpg")
                .setAddress(address)
                .selectState("Haryana")
                .selectCity("Panipat")
                .clickSubmit();
        registrationPage
                .checkResultsFormHeaderText("Thanks for submitting the form")
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "05 June,1988")
                .checkResultsValue("Subjects", "Physics, Maths")
                .checkResultsValue("Hobbies", "Sports, Music")
                .checkResultsValue("Picture", "sketching8.jpg")
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", "Haryana Panipat");
    }
}
