package yandex.oshkin;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browserSize ="1920x1080";
//    }

    @Test
    void fillPracticeFormTest() {
        //Открываем форму
        open("https://demoqa.com/automation-practice-form");
        // Заполняем имя
        $("#firstName").setValue("Dmitriy");
        // Заполняем фамилию
        $("#lastName").setValue("Oshkin");
        //Заполняем email
        $("#userEmail").setValue("userEmail@gmail.com");
        //  Выбрать пол
        $x("//label[contains(text(),'Male')]").click();
        // Заполняем номер телефона
        $("#userNumber").setValue("9876543210");
        // Заполняем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
		$(".react-datepicker__day.react-datepicker__day--005").click();
        // Заполняем предмет
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        // Заполняем хобби
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        //Прикрепляем фото
        $("#uploadPicture").uploadFile();
        // Заполняем адрес
        $("#currentAddress").setValue("Страна Город Улица Дом Квартира");
        //Заполняем Штат и город
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").scrollTo().click();
        $("#submit").scrollTo().click();
//       $("#output #name").shouldHave(text("Some name"));
//       $("#output").$("#email").shouldHave(text("111@333.com"));
//       $("#output").$("#currentAddress").shouldHave(text("Some address"));
//       $("#output").$("#permanentAddress").shouldHave(text("Another address"));


//        $("#output").shouldHave(text("Some name"),text("111@333.com"),
//               text("Some address"),text("Another address"));
    }

}
