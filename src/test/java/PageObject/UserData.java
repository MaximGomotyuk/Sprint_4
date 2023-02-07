package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserData {
    private final WebDriver driver;
    // поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле Станция метро
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    // поле Телефон
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка Далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public UserData(WebDriver driver) {
        this.driver = driver;
    }
    // Вводи имени
    public void inputName (String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // Ввод фамилии
    public void inputSurname (String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    // Ввод адреса
    public void inputAddress (String address){
        driver.findElement(addressField).sendKeys(address);
    }
    // Ввод и выбор станции метро
    public void inputMetro (String metroStation){
        driver.findElement(metroField).sendKeys(metroStation);
        driver.findElement(By.className("select-search__select")).click();
    }
    // Ввод номера телефона
    public void inputPhone (String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    // Нажатие кнопки Дальше
    public void pushNextButton (){
        driver.findElement(nextButton).click();
    }
    //Шаг ввод данных пользователя
    public void usersData (String name, String surname, String adress, String metroStation, String phoneNumber){
        inputName(name);
        inputSurname(surname);
        inputAddress(adress);
        inputMetro(metroStation);
        inputPhone(phoneNumber);
        pushNextButton();
    }
}