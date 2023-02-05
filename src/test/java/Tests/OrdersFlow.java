package Tests;

import PageObject.Landing;
import PageObject.RentData;
import PageObject.UserData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrdersFlow {
    private static WebDriver driver;

    @RunWith(Parameterized.class)
    public static class MetroStations {
        String metroStationName;

        public MetroStations(String metroStationName) {
            this.metroStationName = metroStationName;
        }

        @Parameterized.Parameters
        public static Object[][] getStations() {
            return new Object[][]{
                    {"Курская "},
                    {"Новогиреево "},
            };
        }

        @Test
        public void checkMetroStations() {    //Проверяем возможность заказа на разные станции метро
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing LandingPage = new Landing(driver);
            LandingPage.clickUpOrderButton();

            UserData newUser = new UserData(driver);
            newUser.usersData("Василий", "Петров", "Москва, ул.Лубянка - 64", metroStationName, "84951112233");

            RentData newRent = new RentData(driver);
            newRent.inputRentData("04.02.2023", "пятеро суток", "grey", "Побыстрее, пожалуйста");
            newRent.popupTextEqual();
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }

    @RunWith(Parameterized.class)
    public static class OrdersDate {
        String date;

        public OrdersDate(String date) {
            this.date = date;
        }

        @Parameterized.Parameters
        public static Object[][] getStations() {
            return new Object[][]{
                    {"04.02.2023"},
                    {"05.02.2023"},
            };
        }

        @Test
        public void checkDifferentDates() {    //Проверяем возможность заказа на разные даты
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing LandingPage = new Landing(driver);
            LandingPage.clickUpOrderButton();

            UserData newUser = new UserData(driver);
            newUser.usersData("Василий", "Петров", "Москва, ул.Лубянка -64", "Арбатская ", "84951112233");

            RentData newRent = new RentData(driver);
            newRent.inputRentData(date, "пятеро суток", "grey", "Побыстрее, пожалуйста");
            newRent.popupTextEqual();
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }

    @RunWith(Parameterized.class)
    public static class OrderDaysQuantity {
        String daysQuantity;

        public OrderDaysQuantity(String daysQuantity) {
            this.daysQuantity = daysQuantity;
        }

        @Parameterized.Parameters
        public static Object[][] getDaysQuantity() {
            return new Object[][]{
                    {"сутки"},
                    {"пятеро суток"},
            };
        }

        @Test
        public void checkDiffDaysQuantity() {    //Проверяем возможность заказа на разное кол-во дней
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing LandingPage = new Landing(driver);
            LandingPage.clickUpOrderButton();

            UserData newUser = new UserData(driver);
            newUser.usersData("Василий", "Петров", "Москва, ул.Лубянка -64", "Арбатская ", "84951112233");

            RentData newRent = new RentData(driver);
            newRent.inputRentData("05.02.2023", daysQuantity, "grey", "Побыстрее, пожалуйста");
            newRent.popupTextEqual();
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }
    @RunWith(Parameterized.class)
    public static class ScooterColour {
        String colour;

        public ScooterColour(String colour) {
            this.colour = colour;
        }

        @Parameterized.Parameters
        public static Object[][] getScooterColour() {
            return new Object[][]{
                    {"black"},
                    {"grey"},
            };
        }

        @Test
        public void checkDiffDaysQuantity() {    //Проверяем возможность заказа самоката с разными цветами
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing LandingPage = new Landing(driver);
            LandingPage.clickUpOrderButton();

            UserData newUser = new UserData(driver);
            newUser.usersData("Василий", "Петров", "Москва, ул.Лубянка -64", "Арбатская ", "84951112233");

            RentData newRent = new RentData(driver);
            newRent.inputRentData("05.02.2023", "сутки", colour, "Побыстрее, пожалуйста");
            newRent.popupTextEqual();
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }
    @RunWith(Parameterized.class)
    public static class orderButtons {
        int numberOfButton;

        public orderButtons(int numberOfButton) {
            this.numberOfButton = numberOfButton;
        }

        @Parameterized.Parameters
        public static Object[][] getNumberOfButton() {
            return new Object[][]{
                    {0},
                    {1},
            };
        }

        @Test
        public void checkDiffOrdersButton() {    //Проверяем возможность заказа c разных кнопок
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");

            Landing startOfOrder = new Landing(driver);
            List<WebElement> buttons = driver.findElements(By.xpath(".//button[text()='Заказать']"));
            WebElement button = buttons.get (numberOfButton);
            startOfOrder.clickOrderButton(button);
            Assert.assertEquals("Для кого самокат", driver.findElement(By.className("Order_Header__BZXOb")).getText());
        }
        @After
        public void closeBro() {
            driver.quit();
        }
    }

}
