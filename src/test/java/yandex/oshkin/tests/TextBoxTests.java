package yandex.oshkin.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browserSize ="1920x1080";
//    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Some name");
        $("[id=userEmail]").setValue("111@333.com");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").scrollTo().click();

        $("#output #name").shouldHave(text("Some name"));
        $("#output").$("#email").shouldHave(text("111@333.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(text("Another address"));


//        $("#output").shouldHave(text("Some name"),text("111@333.com"),
//               text("Some address"),text("Another address"));
    }

}
