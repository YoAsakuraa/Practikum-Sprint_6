package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderButtonOrder extends BasePage {
    //Кнопка " заказать " в хэдоре страницы
    private final By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");

    public HeaderButtonOrder(WebDriver driver) {
        super(driver);
    }

    public void clickButtonOrder() {
        click(headerOrderButton);
    }


}