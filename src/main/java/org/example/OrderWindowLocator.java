package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderWindowLocator extends BasePage {
    //Поле "Имя"
    private final By fieldName = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN");

    //Поле "Фамилия"
    private final By fieldSurname = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder*='Фамилия']");

    //Поле "Адрес"
    private final By fieldAddress = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder*='Адрес: куда привезти']");

    //Поле "Станция метро"
    private final By fieldMetroStation = By.cssSelector(".select-search__input");
    private final By buttonMetroStation = By.xpath("//button[contains(@class, 'select-search__option')]//div[text()='Бульвар Рокоссовского']");

    //Поле "Номер телефона"
    private final By fieldPhoneNumber = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder*='Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private final By buttonFurther = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    //Поле "Дата привоза самоката"
    private final By fieldDeliveriDate = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder*='Когда привезти самокат']");
    private final By buttonDeliveriDate = By.cssSelector(".react-datepicker__day.react-datepicker__day--013");


    //Поле "Срок Аренды"
    private final By fieldRentalPeriod = By.cssSelector(".Dropdown-placeholder");
    private final By buttonRentalPeriodOption = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']");

    //Поле "Цвет самоката = Черный жемчуг"
    private final By fieldColorBlack = By.cssSelector(".Checkbox_Label__3wxSf");

    //Поле "Цвет самоката = Серая безысходность"
    private final By fieldColorGrey = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[name*='серая безысходность']");

    //Поле Комментарий
    private final By fieldComments = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder*='Комментарий для курьера']");

    //Кнопка Заказать
    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Кнопка Да
    private final By YesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Текст заказ оформлен
    private final By TextOrderDecorated = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");

    public OrderWindowLocator(WebDriver driver) {
        super(driver);
    }


    public void fillPersonalInfo(String name , String Surname , String Adress , String phoneNumber) {
        SendKeys(fieldName, name);
        SendKeys(fieldSurname, Surname);
        SendKeys(fieldAddress, Adress);
        SendKeys(fieldPhoneNumber, phoneNumber);
    }

    public void selectMetroAndContinue() {
        click(fieldMetroStation);
        click(buttonMetroStation);
        click(buttonFurther);
    }

    public void fillRentalDetails(String comment ) {
        click(fieldDeliveriDate);
        click(buttonDeliveriDate);
        click(fieldRentalPeriod);
        click(buttonRentalPeriodOption);
        click(fieldColorBlack);
        SendKeys(fieldComments, comment);
    }

    public void completeOrder() {
        click(orderButton);
        click(YesButton);
    }


    public String GetTextOrderDecorated() {
       return getText(TextOrderDecorated);
    }

}
