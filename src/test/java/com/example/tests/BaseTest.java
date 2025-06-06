package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String URL_UNDER_TEST =
            "https://www.selenium.dev/selenium/web/web-form.html";

    @Before
    public void setUp() throws Exception {

        /* 1. Procura o chromedriver dentro de src/test/resources            */
        URL drvUrl = getClass()
                .getClassLoader()
                .getResource("chromedriver.exe");     // mesmo nome do arquivo

        if (drvUrl == null) {
            throw new IllegalStateException(
                    "chromedriver.exe não encontrado em src/test/resources");
        }

        /* 2. Converte o resource para Path físico e registra no sistema      */
        Path drvPath = Paths.get(drvUrl.toURI());
        System.setProperty("webdriver.chrome.driver", drvPath.toString());

        /* 3. Instancia o ChromeDriver normalmente                            */
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        /* 4. Espera explícita padrão de 10 s                                  */
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /* 5. Abre a página sob teste                                          */
        driver.get(URL_UNDER_TEST);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
