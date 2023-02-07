package Tests;

import PageObject.Landing;
import PageObject.RentData;
import PageObject.UserData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

@RunWith(Parameterized.class)

public class OrdersFlow {
        private static WebDriver driver;
           String metroStationName;
           String date;
           String daysQuantity;
           String colour;
           int numberOfButton;

        public OrdersFlow (String metroStationName, String date, String daysQuantity, String colour, int numberOfButton) {
            this.metroStationName = metroStationName;
            this.date = date;
            this.daysQuantity = daysQuantity;
            this.colour = colour;
            this.numberOfButton = numberOfButton;
        }
        @Parameterized.Parameters
        public static Object[][] getStations() {
            return new Object[][]{
                    {"Курская ", "07.02.2023", "сутки", "black", 0},
                    {"Арбатская ", "08.02.2023", "трое суток", "grey", 1},
                    {"Новогиреево ", "09.02.2023", "пятеро суток", "black", 1},
            };
        }

        @Test
        public void checkPositiveOrderFlow() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing startOfOrder = new Landing(driver);
            List<WebElement> buttons = driver.findElements(By.xpath(".//button[text()='Заказать']"));
            WebElement button = buttons.get (numberOfButton);
            startOfOrder.clickOrderButton(button);

            UserData newUser = new UserData(driver);
            newUser.usersData("Василий", "Петров", "Москва, ул.Лубянка - 64", metroStationName, "84951112233");

            RentData newRent = new RentData(driver);
            newRent.inputRentData(date, daysQuantity, colour, "Побыстрее, пожалуйста");
            newRent.popupTextEqual();
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }






