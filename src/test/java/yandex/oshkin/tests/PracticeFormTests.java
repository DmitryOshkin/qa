package yandex.oshkin.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import yandex.oshkin.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest() {
        registrationPage
                .openPage()
                .typeFirstName("Dmitriy")
                .typeLastName("Oshkin")
                .typeUserEmail("userEmail@gmail.com")
                .selectGender("Male")
                .setPhoneNumber("9876543210")
                .setBirthDate("05", "June", "1988")
                .setSubject("Physics")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setHobbies("Music")
                .uploadPicture("img/sketching8.jpg")
                .setAddress("Country City Street number")
                .selectState("Haryana")
                .selectCity("Panipat")
                .clickSubmit()
                .takeScreenshot("my_file_name")
                .checkResultsText("Thanks for submitting the form")
                .checkResultsValue("Student Name", "Dmitriy Oshkin")
                .checkResultsValue("Student Email", "userEmail@gmail.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9876543210")
                .checkResultsValue("Date of Birth", "05 June,1988")
                .checkResultsValue("Subjects", "Physics, Maths")
                .checkResultsValue("Hobbies", "Sports, Music")
                .checkResultsValue("Picture", "sketching8.jpg")
                .checkResultsValue("Address", "Country City Street number")
                .checkResultsValue("State and City", "Haryana Panipat")
                .takeScreenshot("my_file_name2");
    }
}
