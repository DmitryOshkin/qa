package yandex.oshkin;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest() {
        // Открываем форму
        open("/automation-practice-form");
        //Проверяем что форма та
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        // Заполняем имя
        $("#firstName").setValue("Dmitriy");
        // Заполняем фамилию
        $("#lastName").setValue("Oshkin");
        // Заполняем email
        $("#userEmail").setValue("userEmail@gmail.com");
        // Указываем пол
        $("#genterWrapper").$(byText("Male")).click();
        //$x("//label[contains(text(),'Male')]").click();
        // Заполняем номер телефона
        $("#userNumber").setValue("9876543210");
        // Заполняем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        //$(".react-datepicker__day.react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();
        $("[aria-label$='June 5th, 1988']").click();
        // Заполняем предмет
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
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
        $("[class='modal-body']").shouldHave(
                text("Dmitriy Oshkin"),
                text("userEmail@gmail.com"),
                text("Male"),
                text("9876543210"),
                text("05 June,1988"),
                text("Physics, Maths"),
                text("Sports, Music"),
                text("sketching8.jpg"),
                text("Country City Street number"),
                text("Haryana Panipat"));
        String pngFileName2 = screenshot("my_file_name2");


    }

}
