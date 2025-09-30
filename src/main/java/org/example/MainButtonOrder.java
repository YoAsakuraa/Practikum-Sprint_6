package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainButtonOrder extends BasePage {
    //Кнопка "заказать" в теле страницы
    private final By mainOrderButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    public MainButtonOrder(WebDriver driver) {
        super(driver);
    }

    public void scrollAndClickMainButton() {
        scrollToElement(mainOrderButton);
        click(mainOrderButton);

    }


}
