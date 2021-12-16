package yandex.oshkin;

import org.junit.jupiter.api.*;

public class FirstSimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll method!");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    @BeforeEach method!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    @AfterEach method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll method!");
    }
    @DisplayName("Простенький тест на assertEquals")
    @Test
    void firstTest() {
        System.out.println("        Easy test on assertEquals");
        Assertions.assertEquals(1, 1);
    }

    @DisplayName("Простенький тест на assertTrue")
    @Test
    void secondTest() {
        System.out.println("        Easy test on assertTrue");
        Assertions.assertTrue(7 > 6);
    }



}
