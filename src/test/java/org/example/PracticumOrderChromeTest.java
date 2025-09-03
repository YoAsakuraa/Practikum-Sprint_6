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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticumOrderChromeTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    static Stream<Arguments> PersonalInfo() {
        return Stream.of(
                Arguments.of("Валерий", "Петров", "Город Москва улица Пушкина дом 35 квартира 67", "89774583354", "Комментарий 1"),
                Arguments.of("Сергей", "Иванов", "Город Кукушка", "89774583322", "null")

        );
    }

    @DisplayName("Тест оформления заказа через кнопку в хедере")
    @ParameterizedTest
    @MethodSource("PersonalInfo")
    public void testOrderHeaderButton(String name, String surname, String address,
                                      String phone, String comment) {
        HeaderButtonOrder headerButtonOrder = new HeaderButtonOrder(driver);
        OrderWindowLocator orderWindowLocator = new OrderWindowLocator(driver);
        headerButtonOrder.clickButtonOrder();                               // Вызываем кнопку из хэдора страницы
        orderWindowLocator.fillPersonalInfo(name, surname, address, phone); //Вводим данные на первую страницу оформления заказа
        orderWindowLocator.selectMetroAndContinue();                        //Выбираем метро и жмем продолжить
        orderWindowLocator.fillRentalDetails(comment);                      //Вводим оставшиеся данные по заказу и пишем комментариий
        orderWindowLocator.completeOrder();                                 //Жмем кнопку заказать и да
        String actual = orderWindowLocator.GetTextOrderDecorated();
        assertTrue(actual.contains("Заказ оформлен"),
                "Заказ не был оформлен успешно. Полученный текст: " + actual);


    }

    @DisplayName("Тест оформления заказа через кнопку в теле")
    @ParameterizedTest
    @MethodSource("PersonalInfo")
    public void testOrderMainButton(String name, String surname, String address,
                                    String phone, String comment) {
        MainButtonOrder mainButtonOrder = new MainButtonOrder(driver);
        OrderWindowLocator orderWindowLocator = new OrderWindowLocator(driver);
        mainButtonOrder.scrollAndClickMainButton();                                   // Вызываем кнопку из тела страницы
        orderWindowLocator.fillPersonalInfo(name, surname, address, phone);
        orderWindowLocator.selectMetroAndContinue();
        orderWindowLocator.fillRentalDetails(comment);
        orderWindowLocator.completeOrder();
        String actual = orderWindowLocator.GetTextOrderDecorated();
        assertTrue(actual.contains("Заказ оформлен"),
                "Заказ не был оформлен успешно. Полученный текст: " + actual);


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }
}