package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PracticumQuestionsChromeTest {
    private WebDriver driver;
    private QuestionsPage questionsPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        questionsPage = new QuestionsPage(driver);
    }

    //Тестовые данные
    static Stream<Arguments> questionAnswerProvider() {
        return Stream.of(
                Arguments.of(1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of(2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of(3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of(4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of(5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of(6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of(7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of(8, "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }
    @DisplayName("Тест на корректное открытие раздела 'Вопросы о важном' и проверка соответствия написанного в нем текста " )
    @ParameterizedTest
    @MethodSource("questionAnswerProvider")
    public void testAllQuestions(int questionNumber, String expectedAnswer) {
        questionsPage.clickQuestionByNumber(questionNumber);
        String actualAnswer = questionsPage.getAnswerTextByNumber(questionNumber);

        assertEquals(expectedAnswer, actualAnswer,
                "Текст ответа для вопроса " + questionNumber + " не совпадает");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }


}
