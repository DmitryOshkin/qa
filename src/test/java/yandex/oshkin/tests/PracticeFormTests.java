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
                .setSubject("Maths");
        // Заполняем хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //$("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        // Прикрепляем фото
        //File picture = new File("src/test/resources/img/sketching8.jpg");
        //$("#uploadPicture").uploadFile(picture);
        $("#uploadPicture").uploadFromClasspath("img/sketching8.jpg");
        // Заполняем адрес
        $("#currentAddress").setValue("Country City Street number");
        // Заполняем Штат и город
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        //$("#react-select-4-input").setValue("Panipat").pressEnter();
        String pngFileName = screenshot("my_file_name");
        $("#submit").scrollTo().click();
        // Проверяем результат работы формы
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        registrationPage
                .checkResultsValue("Student Name", "Dmitriy Oshkin")
                .checkResultsValue("Student Email", "userEmail@gmail.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9876543210")
                .checkResultsValue("Date of Birth", "05 June,1988")
                .checkResultsValue("Subjects", "Physics, Maths")
                .checkResultsValue("Hobbies", "Sports, Music")
                .checkResultsValue("Picture", "sketching8.jpg")
                .checkResultsValue("Address", "Country City Street number")
                .checkResultsValue("State and City", "Haryana Panipat");
        String pngFileName2 = screenshot("my_file_name2");
    }
}
