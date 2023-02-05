package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentData {
    private final WebDriver driver;
    // поле Дата
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // день в календаре
    private final By dayOfMonth = By.xpath(".//div[contains(@class, 'day--selected')]");
    // поле Срок аренды
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    // комментарий для курьера
    private final By courierComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка Заказать
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text()='Заказать')]");
    // кнопка "Да" в попапе (из курса ручного тестировщика помню, что попапа здесь быть не должно,
    //но сейчас мы работаем по готовому продукту, а не по требованиям, так что нажму её ))
    private final By yesButton = By.xpath(".//button[(text()='Да')]");
    // попап успешно оформленного заказа
    private final By successPopup = By.className("Order_ModalHeader__3FDaJ");

    public RentData(WebDriver driver) {
        this.driver = driver;
    }
    // Ввод даты
    public void inputDate (String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dayOfMonth).click();
    }
    // Ввод срока аренды
    public void inputRentalPeriod (String daysQuantity) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[(@class='Dropdown-option') and (text()='" + daysQuantity +"')]")).click();
    }
    // Выбор цвета
    public void chooseColour (String colour) {
        driver.findElement(By.xpath (".//label[@for='" + colour + "']")).click();
    }
    // Ввод комментария для курьера
    public void inputCourierComment (String comment) {
        driver.findElement(courierComment).sendKeys(comment);
    }
    // Нажатие кнопки Заказать
    public void clickOrderButton () {
        driver.findElement(orderButton).click();
    }
    // Нажатие кнопки Да в попапе
    public void clickYesButton () {
        driver.findElement(yesButton).click();
    }
    // Получение текста из попапа успешного заказа
    public String getTextFromSuccessPopup () {
        return driver.findElement(successPopup).getText();
    }
    // Шаг ввода данных Об аренде
    public void inputRentData (String date, String daysQuantity, String colour, String comment) {
        inputDate(date);
        inputRentalPeriod(daysQuantity);
        chooseColour(colour);
        inputCourierComment(comment);
        clickOrderButton();
        clickYesButton();
    }
    //Проверка соответствия тексат в попапе
    public void popupTextEqual () {
        Assert.assertEquals("Заказ оформлен",getTextFromSuccessPopup());
    }
}