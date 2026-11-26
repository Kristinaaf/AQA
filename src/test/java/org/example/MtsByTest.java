package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");

    //Закрываем окно с cookie, если оно появилось
    try {
        WebElement acceptCookieButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Принять')]")));
        acceptCookieButton.click();
    } catch (Exception e) {
        // Если окна нет, просто идем дальше
        System.out.println("Окно с cookie не появилось или уже закрыто");
    }
    }

    @Test
    public void testBlockTitle() {
        // 1. Проверяем название блока
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Онлайн пополнение')]")));
        assertTrue(blockTitle.isDisplayed());
    }

    @Test
    public void testPaymentLogos() {
        // 2. Проверяем логотипы (ищем картинки внутри блока пополнения)
        // Ждем, пока блок прогрузится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Онлайн пополнение')]")));
        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'payment')]//img | //img[contains(@src, 'visa') or contains(@src, 'mastercard')]"));
        assertFalse(logos.isEmpty(), "Логотипы не найдены");
    }

    @Test
    public void testMoreAboutServiceLink() {
        // 3. Проверяем ссылку
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));

        // Прокручиваем страницу к ссылке, чтобы она точно была видна
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        wait.until(ExpectedConditions.elementToBeClickable(link));

        link.click();

        // Ждем смены URL
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("https://www.mts.by/")));
        assertNotEquals("https://www.mts.by/", driver.getCurrentUrl());
    }

    @Test
    public void testFillFormAndContinue() {
        // 1. Вводим номер телефона
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-phone")));
        phoneInput.sendKeys("297777777");

        // 2. Вводим сумму
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("connection-sum")));
        sumInput.sendKeys("10");

        // 3. Ищем кнопку "БАНКОВСКАЯ КАРТА" (увеличиваем время ожидания для нее)
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement continueButton = longWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(translate(., 'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ', 'абвгдеёжзийклмнопрстуфхцчшщъыьэюя'), 'банковская')]")));

        // Прокручиваем страницу к кнопке
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", continueButton);

        // Ждем, пока она станет кликабельной
        longWait.until(ExpectedConditions.elementToBeClickable(continueButton));

        // Кликаем
        continueButton.click();

        // 4. Ждем, пока загрузится iframe с оплатой (это и есть проверка)
        // Ждем до 15 секунд, пока не появится iframe
        WebDriverWait frameWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        frameWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        // Проверяем, что iframe действительно появился
        assertFalse(driver.findElements(By.tagName("iframe")).isEmpty(), "Окно оплаты (iframe) не появилось после нажатия кнопки");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}