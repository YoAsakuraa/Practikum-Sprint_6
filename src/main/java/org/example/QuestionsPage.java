package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuestionsPage  extends BasePage {



    //Не стал удалять эти локаторы , что бы показать какой был ход мысли  ,  потом пришел к мысли о том что лучше реализовать универсальные что бы была параметризация
    //Сначала были такие, но не оч универсально


    //Раздел "Вопросы о важном"
    //Кнопка и текст вопроса 1
    private final By buttonQuestionNumber1 = By.id("accordion__heading-0");
    private final By textQuestionNumber1 = By.cssSelector("#accordion__panel-0 p");

    //Кнопка и текст вопроса 2
    private final By questionButtonNumber2 = By.id("accordion__heading-1");
    private final By textQuestionNumber2 = By.cssSelector("#accordion__panel-1 p");

    //Кнопка и текст вопроса 3
    private final By questionButtonNumber3 = By.id("accordion__heading-2");
    private final By textQuestionNumber3 = By.cssSelector("#accordion__panel-2 p");

    //Кнопка и текст вопроса 4
    private final By questionButtonNumber4 = By.id("accordion__heading-3");
    private final By textQuestionNumber4 = By.cssSelector("#accordion__panel-3 p");

    //Кнопка и текст вопроса 5
    private final By questionButtonNumber5 = By.id("accordion__heading-4");
    private final By textQuestionNumber5 = By.cssSelector("#accordion__panel-4 p");

    //Кнопка и текст вопроса 6
    private final By questionButtonNumber6 = By.id("accordion__heading-5");
    private final By textQuestionNumber6 = By.cssSelector("#accordion__panel-5 p");

    //Кнопка и текст вопроса 7
    private final By questionButtonNumber7 = By.id("accordion__heading-6");
    private final By textQuestionNumber7 = By.cssSelector("#accordion__panel-6 p");

    //Кнопка и текст вопроса 8
    private final By questionButtonNumber8 = By.id("accordion__heading-7");
    private final By textQuestionNumber8 = By.cssSelector("#accordion__panel-7 p");

    public QuestionsPage (WebDriver driver) {
        super(driver);
    }

    // Универсальный метод для клика на вопрос по номеру
    public void clickQuestionByNumber(int questionNumber) {
        By questionLocator = By.id("accordion__heading-" + (questionNumber - 1));
        scrollAndClick(questionLocator);
    }

    // Универсальный метод для получения текста ответа
    public String getAnswerTextByNumber(int questionNumber) {
        By answerLocator = By.cssSelector("#accordion__panel-" + (questionNumber - 1) + " p");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator)).getText();
    }

    // Универсальный метод проверки видимости ответа
    public boolean isAnswerVisible(int questionNumber) {
        By answerLocator = By.cssSelector("#accordion__panel-" + (questionNumber - 1) + " p");
        return isVisible(answerLocator);
    }

}