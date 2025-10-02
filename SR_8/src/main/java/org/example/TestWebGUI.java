package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestWebGUI {
    private WebDriver driver;


    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:9999/");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void checkCriticalPath () throws InterruptedException {

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[1]/span/span/span[2]/input")).sendKeys("Гарри Поттер");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[2]/span/span/span[2]/input")).sendKeys("+78021391698");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[4]/button")).click();
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/p")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkCriticalPathRatherBetterWay () throws InterruptedException {

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";

        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Гарри Поттер");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+78021391698");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        Thread.sleep(3000);
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkEmptyInput () throws InterruptedException {

        String expected = "Поле обязательно для заполнения";
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        Assertions.assertEquals(expected, actual);
    }

}
