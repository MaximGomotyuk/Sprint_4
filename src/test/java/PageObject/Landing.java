package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landing {
    private final WebDriver driver;
    // кнопка Закзать вверху страницы
    private final By UpOrderButton  = By.className("Button_Button__ra12g");
    // кнопка Заказать внизу страницы
    private final By DownOrderButton = By.className("Button_Button__ra12g");

    public Landing (WebDriver driver) {
        this.driver = driver;
    }
    // Нажатие кнопок Заказать для теста кнопок
    public void clickOrderButton(WebElement button) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }
    // Нажатие на пункт списка в футере
    public void clickDropDownListButton(int listPoint) {
        WebElement element = driver.findElement(By.id("accordion__heading-"+listPoint+""));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-"+listPoint+"")).click();
    }
    // Получение текста из развёрнутого пунтка в футере
    public String getTextFromDropDownListInFooter (int listPoint) {
        new WebDriverWait(driver, 1);
        return driver.findElement(By.xpath("//div[@aria-labelledby='accordion__heading-"+ listPoint +"']")).getText();
    }
    // Нажатие кнопки Заказать ВВЕРХУ
    public void clickUpOrderButton() {
        driver.findElement(UpOrderButton).click();
    }
}
